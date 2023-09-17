package com.store.Booktown.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.Booktown.Model.Category;
import com.store.Booktown.Repository.CategoryRepo;

@Service
public class CategoryService {

	
	@Autowired
	private CategoryRepo categoryrepo;

	public Category createCategory(Category category) {
		 return categoryrepo.save(category);
	}
	
	public List<Category> getAllCategory(){
		return categoryrepo.findAll();
	}
	
	@SuppressWarnings("deprecation")
	public Category updateCat(Integer id,Category updCategory) {
		Category category = categoryrepo.getById(id);
		category.setCategoryName(updCategory.getCategoryName());
		category.setImageUrl(updCategory.getImageUrl());
		category.setDescription(updCategory.getDescription());
		
		return categoryrepo.save(category);

	}
	
	public boolean findByIds(Integer categoryid) {
		return categoryrepo.findById(categoryid).isPresent();
		
	}
}
