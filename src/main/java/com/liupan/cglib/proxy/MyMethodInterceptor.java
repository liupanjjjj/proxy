package com.liupan.cglib.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 有自身增强问题
 */
public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if(method.getName().equals("send")){
            System.out.println("before");
            //调用的是增强类类的父类方法 this指向子类，有一个问题，若父类有调用类中其他方法会执行子类中的增强方法（自身增强）
            Object res = methodProxy.invokeSuper(o, objects);
            //调用的是代理类（原始类子类）的增强方法，会无限进拦截器 导致死循环
//            Object res = methodProxy.invoke(o, objects);
            System.out.println("after");
            return res;
        }

        return methodProxy.invokeSuper(o, objects);
    }
}
