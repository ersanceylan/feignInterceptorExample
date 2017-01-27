package com.kgblog.config;

import feign.Logger;
import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

/**
 * Created on January, 2017
 *
 * @author ersan
 */
public class FeignDefaultConfiguration {


	public static final int CONNECT_TIMEOUT = 5 * 1000;
	public static final int READ_TIMEOUT = 10 * 1000;

	@Bean
	@Profile("dev")
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}

	@Bean
	public Request.Options options() {
		return new Request.Options(CONNECT_TIMEOUT, READ_TIMEOUT);
	}

}
