package com.liupan.cglib.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if(method.getName().equals("send")){
            System.out.println("before");
            Object res = methodProxy.invokeSuper(o, objects);
            System.out.println("after");
            return res;
        }

        return methodProxy.invokeSuper(o, objects);
    }
}
