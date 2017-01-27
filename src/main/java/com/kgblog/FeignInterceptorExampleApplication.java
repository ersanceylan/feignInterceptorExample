package com.kgblog;

import com.kgblog.config.FeignDefaultConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(defaultConfiguration = FeignDefaultConfiguration.class)
public class FeignInterceptorExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignInterceptorExampleApplication.class, args);
	}
}
