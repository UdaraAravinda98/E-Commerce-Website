package com.store.Booktown.DTO.Cart;

import jakarta.validation.constraints.NotNull;

public class AddtoCartDto {

	private int id;
	private @NotNull int productId;
	private @NotNull int quantity;
	
	public AddtoCartDto() {
	
	}

	public AddtoCartDto(int id, @NotNull int productId, @NotNull int quantity) {
		super();
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	
	
	
}
