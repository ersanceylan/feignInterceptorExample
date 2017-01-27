package com.kgblog.config;

import com.kgblog.domain.User;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

/**
 * Created on January, 2017
 *
 * @author ersan
 */
@Component
public class FeignRequestInterceptor implements RequestInterceptor {

	@Override
	public void apply(RequestTemplate template) {
		if (SecurityContextHystrixRequestVariable.getInstance().get().getAuthentication() != null) {
			User user = (User) SecurityContextHystrixRequestVariable.getInstance().get().getAuthentication().getPrincipal();
			template.header("Authorization", "Basic " + user.getToken());
		}
	}

}