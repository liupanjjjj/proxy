package com.liupan.cglib.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyMethodInterceptor2 implements MethodInterceptor {
    Object target;

    public MyMethodInterceptor2(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if(method.getName().equals("send")){
            System.out.println("before");
            Object res = method.invoke(target, objects);
            System.out.println("after");
            return res;
        }

        return methodProxy.invokeSuper(o, objects);
    }
}
