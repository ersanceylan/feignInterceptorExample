package com.kgblog.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created on January, 2017
 *
 * @author ersan
 */
@Component
@FeignClient(name = "github", url = "${github.ribbon.listOfServers}")
public interface GithubClient {

	@RequestMapping(value = "user", method = RequestMethod.GET)
	String getUser();

}
