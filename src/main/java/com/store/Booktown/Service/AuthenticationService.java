package com.store.Booktown.Service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.Booktown.Exception.AuthenticationFailException;
import com.store.Booktown.Model.AuthenticationToken;
import com.store.Booktown.Model.User;
import com.store.Booktown.Repository.TokenRepo;

@Service
public class AuthenticationService {
	
	@Autowired
	private TokenRepo tokenrepo;
	
	public void saveConfimationToken(AuthenticationToken authenticationtoken) {
		
		tokenrepo.save(authenticationtoken);
	}

	public AuthenticationToken getToken(User user) {
		
		return tokenrepo.findByUser(user);
	}
	
	
	public User getUser(String token) {
	
		final AuthenticationToken authenticationtoken = tokenrepo.findByToken(token);
		
		if(Objects.isNull(authenticationtoken)) {
			return null;
		}
		
		return authenticationtoken.getUser();
	}

public void authentication(String token) throws AuthenticationFailException {
		
		if(Objects.isNull(token)) {
			throw new AuthenticationFailException("token not present");
		}
		
		
		if(Objects.isNull(token)) {
			throw new AuthenticationFailException("token not valid");
		}
	}

}
