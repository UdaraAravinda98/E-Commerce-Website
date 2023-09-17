package com.store.Booktown.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.Booktown.Model.AuthenticationToken;
import com.store.Booktown.Model.User;

@Repository
public interface TokenRepo extends JpaRepository<AuthenticationToken,Integer>{

	AuthenticationToken findByUser(User user); 
	
	AuthenticationToken findByToken(String token);
}
