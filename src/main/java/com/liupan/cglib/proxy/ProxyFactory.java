package com.liupan.cglib.proxy;

import com.liupan.cglib.serviceimpl.SendServiceImpl;
import net.sf.cglib.proxy.Enhancer;

public class ProxyFactory {

    public static <T> T getProxy(Class<T> c){
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(c.getClassLoader());
        enhancer.setSuperclass(c);
        enhancer.setCallback(new MyMethodInterceptor());
        return (T)enhancer.create();
    }

    public static void main(String[] args) {
        SendServiceImpl proxy = getProxy(SendServiceImpl.class);
        System.out.println(proxy.send());
    }
}
