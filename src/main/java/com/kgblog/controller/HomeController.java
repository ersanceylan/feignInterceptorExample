package com.kgblog.controller;

import com.kgblog.client.GithubClient;
import com.kgblog.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created on January, 2017
 *
 * @author ersan
 */
@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private GithubClient githubClient;

	@ResponseBody
	@RequestMapping(value = {"/token"}, method = RequestMethod.GET)
	public String token() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return user.getToken();
	}

	@ResponseBody
	@RequestMapping(value = "/githubAccount", method = RequestMethod.GET)
	public String githubAccount() {
		return this.githubClient.getUser();
	}

}
