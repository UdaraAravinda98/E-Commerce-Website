package com.store.Booktown.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.Booktown.Common.ApiResponse;
import com.store.Booktown.DTO.ProductDto;
import com.store.Booktown.Model.Category;
import com.store.Booktown.Repository.CategoryRepo;
import com.store.Booktown.Service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productservice;
	
	@Autowired 
	CategoryRepo categoryrepo;
	
	@PostMapping("/add")
	public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductDto productdto){
		Optional<Category> optionalCategory = categoryrepo.findById(productdto.getCategoryId());
		if(optionalCategory.isPresent()) {
			productservice.createProduct(productdto, optionalCategory.get());
			return new ResponseEntity<ApiResponse>(new ApiResponse(true,"product has been added"),HttpStatus.CREATED);
		}

		return new ResponseEntity<ApiResponse>(new ApiResponse(false,"Category does not exists"),HttpStatus.BAD_REQUEST);
			
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<ProductDto>> getProducts(){
		List<ProductDto> products = productservice.getAllProducts();
		return new ResponseEntity<>(products,HttpStatus.OK);
		
	}
	
	// edit
	@PostMapping("/update/{productID}")
	 public ResponseEntity<ApiResponse> updateProduct(@PathVariable("productID") Integer productid,@RequestBody ProductDto productdto) throws Exception{
		Optional<Category> optionalCategory = categoryrepo.findById(productdto.getCategoryId());
		if(optionalCategory.isPresent()) {
			
			productservice.updateProduct(productdto,productid);
			return new ResponseEntity<ApiResponse>(new ApiResponse(true,"product has been added"),HttpStatus.CREATED);
		}
		
		return new ResponseEntity<ApiResponse>(new ApiResponse(false,"Category does not exists"),HttpStatus.BAD_REQUEST);

	}
	

}
