package com.store.Booktown.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.store.Booktown.Common.ApiResponse;
import com.store.Booktown.DTO.Cart.AddtoCartDto;
import com.store.Booktown.Model.User;
import com.store.Booktown.Service.AuthenticationService;
import com.store.Booktown.Service.CartService;
import com.store.Booktown.Service.ProductService;


@RestController
@RequestMapping("/cart")
public class CartController {
	
	@GetMapping("/cart")
	public String cart() {
		return "Cart";
	}
	
	@Autowired
	ProductService productService;
	
	/*
	@GetMapping("/addToCart/{id}")
	public String addToCart(@PathVariable int id) {
	GlobalData.cart.add(productService.getProductById(id).get());
		return "redirect:/shop";
	}
	*/
	
	
	@Autowired 
	private CartService cartservice;
	
	@Autowired
	private AuthenticationService authenticateService;
	

	//post cart api
	@PostMapping("/add")
	public ResponseEntity<ApiResponse> addtoCart(@RequestBody AddtoCartDto addtocartdto,@RequestParam("token") String token){
		//authenticate the token
		authenticateService.authentication(token);
		 
		//find the user
		User user = authenticateService.getUser(token);
		   
		cartservice.addToCart(addtocartdto,user);
		
		return new ResponseEntity<>(new ApiResponse(true,"Added to cart"),HttpStatus.CREATED);
		 
	}
	
	/*
	@GetMapping("/cartitems")
	public ResponseEntity<CartDto> getCartItems(@RequestParam("token") String token){
		
		authenticateService.authentication(token);
		User user = authenticateService.getUser(token);
		
		CartDto cartdto = cartservice.ListCartItems(user);
		return new ResponseEntity<>(cartdto,HttpStatus.OK);
	}
	 	*/
	
	// delete a cart item for a user

    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") Integer itemId,
                                                      @RequestParam("token") String token) {

        // authenticate the token
    	authenticateService.authentication(token);

        // find the user
        User user = authenticateService.getUser(token);

        cartservice.deleteCartItem(itemId, user);

        return new ResponseEntity<>(new ApiResponse(true, "Item has been removed"), HttpStatus.OK);

    }
	

}


