package com.store.Booktown.DTO.Cart;

import java.util.List;

public class CartDto {
	
	private List<CartItemDto> cartitems;
	private double totalCost;
	
	public CartDto() {
		
		
	}
	

	public List<CartItemDto> getCartitems() {
		return cartitems;
	}

	public void setCartitems(List<CartItemDto> cartitems) {
		this.cartitems = cartitems;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	
	
	
	
	
	

}
