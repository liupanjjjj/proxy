package com.liupan.jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

    private Object targetObj;

    public MyInvocationHandler(Object targetObj) {
        this.targetObj = targetObj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("send")){
            System.out.println("before");
            Object res = method.invoke(targetObj, args);
            System.out.println("after");
            return res;
        }
        return method.invoke(targetObj, args);
    }

}
