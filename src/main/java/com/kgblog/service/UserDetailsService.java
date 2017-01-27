package com.kgblog.service;

import com.kgblog.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Component;

/**
 * Created on January, 2017
 *
 * @author ersan
 */
@Component
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Value("${github.username}")
	private String username;

	@Value("${github.token}")
	private String token;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = new User(username);
		user.setToken(generateGithubToken());
		return user;
	}

	private String generateGithubToken() {
		return new String(Base64.encode((username + ":" + token).getBytes()));
	}

}
