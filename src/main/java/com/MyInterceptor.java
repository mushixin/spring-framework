package com;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.core.Ordered;

/**
 * 幂等校验拦截
 *
 * 注意，操作失败时以Exception或者VpcRTException的方式抛出，则不会被幂等拦截
 * 如果在逻辑中以success=false的方式返回，则会被幂等拦截
 * 
 * @author wxx 2015年5月28日 上午10:48:28
 */
public class MyInterceptor implements MethodInterceptor, Ordered {


    @Override
    public Object invoke(final MethodInvocation invocation) throws Throwable {
        return true;
    }

    @Override
    public int getOrder() {
        return Integer.MAX_VALUE;
    }
}
