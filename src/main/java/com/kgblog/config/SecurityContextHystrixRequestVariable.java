package com.kgblog.config;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestVariableDefault;
import org.springframework.security.core.context.SecurityContext;

/**
 * Created by ersanceylan on 23/01/2017.
 */
public class SecurityContextHystrixRequestVariable {

    private static final HystrixRequestVariableDefault<SecurityContext> securityContextVariable = new HystrixRequestVariableDefault<>();

    private SecurityContextHystrixRequestVariable() {}

    public static HystrixRequestVariableDefault<SecurityContext> getInstance() {
        return securityContextVariable;
    }

}
