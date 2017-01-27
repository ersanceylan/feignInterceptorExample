package com.kgblog.config;

import com.netflix.hystrix.HystrixInvokable;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by ersanceylan on 23/01/2017.
 */
public class SecurityContextRegistratorCommandHook extends HystrixCommandExecutionHook {

    @Override
    public <T> void onExecutionStart(HystrixInvokable<T> commandInstance) {
        SecurityContextHolder.setContext(SecurityContextHystrixRequestVariable.getInstance().get());
    }

//    @Override
//    public <T> T onEmit(HystrixInvokable<T> commandInstance, T value) {
//        SecurityContextHolder.setContext(null);
//        return value;
//    }

    @Override
    public <T> Exception onError(HystrixInvokable<T> commandInstance, HystrixRuntimeException.FailureType failureType, Exception e) {
        SecurityContextHolder.setContext(null);
        return e;
    }

}
