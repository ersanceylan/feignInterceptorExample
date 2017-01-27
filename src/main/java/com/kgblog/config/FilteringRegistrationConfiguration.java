package com.kgblog.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;

/**
 * Created on January, 2017
 *
 * @author ersan
 */
@Component
public class FilteringRegistrationConfiguration {

	@Bean
	public FilterRegistrationBean securityFilterChain(@Qualifier(AbstractSecurityWebApplicationInitializer.DEFAULT_FILTER_NAME) Filter securityFilter) {
		FilterRegistrationBean registration = new FilterRegistrationBean(securityFilter);
		registration.setOrder(Integer.MAX_VALUE - 2);
		registration.setName(AbstractSecurityWebApplicationInitializer.DEFAULT_FILTER_NAME);
		return registration;
	}

	@Bean
	public FilterRegistrationBean userInsertingMdcFilterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		HystrixRequestContextEnablerFilter userFilter = new HystrixRequestContextEnablerFilter();
		registrationBean.setFilter(userFilter);
		registrationBean.setOrder(Integer.MAX_VALUE - 1);
		return registrationBean;
	}

	@Bean
	public FilterRegistrationBean setterInsertingMdcFilterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		SecurityContextHystrixRequestVariableSetterFilter userFilter = new SecurityContextHystrixRequestVariableSetterFilter();
		registrationBean.setFilter(userFilter);
		registrationBean.setOrder(Integer.MAX_VALUE);
		return registrationBean;
	}

}

