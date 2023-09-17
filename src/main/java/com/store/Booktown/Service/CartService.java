package com.store.Booktown.Service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.Booktown.DTO.Cart.AddtoCartDto;
import com.store.Booktown.Exception.CustomException;
import com.store.Booktown.Model.Cart;
import com.store.Booktown.Model.Product;
import com.store.Booktown.Model.User;
import com.store.Booktown.Repository.CartRepo;

@Service
public class CartService {
	
	@Autowired 
	private CartRepo cartrepo;  

	@Autowired
	ProductService productservice;
	
	public void addToCart(AddtoCartDto addtocartdto, User user) {
		// TODO Auto-generated method stub
		
	Product product = productservice.findById(addtocartdto.getProductId());
	 
    Cart cart = new Cart();
    cart.setProduct(product);
    cart.setUser(user);
    cart.setQuantity(addtocartdto.getQuantity());
	cart.setCreateddate(new Date());
	
    // save the cart
   cartrepo.save(cart);
   
	}
	/*
	public CartDto ListCartItems(User user) {
		// TODO Auto-generated method stub
		final List<Cart> cartList =cartrepo.findAllByUserOrderByCreatedDateDesc(user);
		
		List<CartItemDto> cartItems = new ArrayList<>();
		
		double totalCost = 0;
		for(Cart cart: cartList) {
			CartItemDto cartitemdto = new CartItemDto(cart);
			totalCost += cartitemdto.getQuantity() * cart.getProduct().getPrice();
			cartItems.add(cartitemdto);
		}
		
		CartDto cartdto = new CartDto();
		cartdto.setTotalCost(totalCost);
		cartdto.setCartitem(cartItems);
		return cartdto;
	}
	
*/
	
    public void deleteCartItem(Integer cartItemId, User user) {
        // the item id belongs to user

        Optional<Cart> optionalCart = cartrepo.findById(cartItemId);

        if (optionalCart.isEmpty()) {
            throw new CustomException("cart item id is invalid: " + cartItemId);
        }

        Cart cart = optionalCart.get();

        if (cart.getUser() != user) {
            throw  new CustomException("cart item does not belong to user: " +cartItemId);
        }

        cartrepo.delete(cart);


    }

}
