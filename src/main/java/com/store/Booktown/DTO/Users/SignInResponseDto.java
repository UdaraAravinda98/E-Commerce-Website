package com.store.Booktown.DTO.Users;

public class SignInResponseDto {

	
	private String status;
	private String token;
	
	public SignInResponseDto(String status, String token) {
		super();
		this.status = status;
		this.token = token;
	}
	
	public SignInResponseDto() {
		super();
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}
