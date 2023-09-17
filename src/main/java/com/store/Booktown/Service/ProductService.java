package com.store.Booktown.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.Booktown.DTO.ProductDto;
import com.store.Booktown.Exception.ProductNotExistsException;
import com.store.Booktown.Model.Category;
import com.store.Booktown.Model.Product;
import com.store.Booktown.Repository.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo productrepo;
	
	
	public Optional<Product> getProductById(int id){
		return productrepo.findById(id);
	}
	
	public void createProduct(ProductDto productdto,Category category) {
		Product product = new Product();
		product.setDescription(productdto.getDescription());
		product.setImageUrl(productdto.getImageUrl());
		product.setName(productdto.getName());
		product.setPrice(productdto.getPrice());
		product.setCategory(category);
		productrepo .save(product);
		
	}
	
	//convert to product to productdto
			public ProductDto getProductDto(Product product) {
				ProductDto productdto = new ProductDto();
				productdto.setDescription(product.getDescription());
				productdto.setImageUrl(product.getImageUrl());
				productdto.setName(product.getName());
				productdto.setCategoryId(product.getCategory().getId());
				productdto.setPrice(product.getPrice());
				productdto.setId(product.getId());
				productrepo.save(product);
				return productdto;
				
			}

			public List<ProductDto> getAllProducts(){
				List<Product> allProducts = productrepo.findAll();
				List<ProductDto> productDtos = new ArrayList<>();
				
				for(Product product:allProducts) {
					productDtos.add(getProductDto(product));
				}
				return productDtos;
			}
			
			//edit product
			public void updateProduct(ProductDto productdto,Integer productid) throws Exception {
			//optional means we might have a product or not
				 Optional<Product> optionalProduct =   productrepo.findById(productid);
				//throw an exception if product does not exist
				if(!optionalProduct.isPresent()) {
					throw new Exception("product not present");
				}else {
					 Product product = optionalProduct.get(); 
						product.setDescription(productdto.getDescription());
						product.setImageUrl(productdto.getImageUrl());
						product.setName(productdto.getName());
						product.setPrice(productdto.getPrice());
						productrepo.save(product);
					
				}
				
			}
			
			public Product findById(int productId) throws ProductNotExistsException{
				// TODO Auto-generated method stub
				Optional<Product> optionalproduct = productrepo.findById(productId);
				if(optionalproduct.isEmpty()) {
					throw new ProductNotExistsException("product id is inavlid"+productId);
				}
				return optionalproduct.get();
			}
			
			
}
