package com.store.Booktown.Controller;

import java.util.List;

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
import com.store.Booktown.Model.Category;
import com.store.Booktown.Service.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryservice;
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createCat(@RequestBody Category category) {  
		categoryservice.createCategory(category);
		return new ResponseEntity<>(new ApiResponse( true,"a new category created"),HttpStatus.CREATED);
	}
	
	
	@GetMapping("/list")
	public ResponseEntity<?> getAll(){
		return new ResponseEntity<List<Category>>(categoryservice.getAllCategory(),HttpStatus.OK);
	}
	
	 
	@PostMapping("/update/{categoryID}")
	public ResponseEntity<ApiResponse> updateCategory(@PathVariable("categoryID") Integer categoryID, @Valid @RequestBody Category category) {
		// Check to see if the category exists.
		if (categoryservice.findByIds(categoryID)) {
			// If the category exists then update it.
			categoryservice.updateCat(categoryID, category); 
			return new ResponseEntity<ApiResponse>(new ApiResponse(true, "updated the category"), HttpStatus.OK);
		}
		

		// If the category doesn't exist then return a response of unsuccessful.
		return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category does not exist"), HttpStatus.NOT_FOUND);
	}
	
	
}