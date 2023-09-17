package com.store.Booktown.Exception;

public class ProductNotExistsException extends IllegalArgumentException{
	
	private static final long serialVersionUID = -7820957060218179066L;

	public ProductNotExistsException(String msg) {
		super(msg);
	}

}
