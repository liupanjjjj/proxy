package com.liupan.cglib.proxy;

import com.liupan.cglib.serviceimpl.SendServiceImpl;
import net.sf.cglib.proxy.Enhancer;

public class ProxyFactory2 {

    public static <T> T getProxy(Class<T> c) throws IllegalAccessException, InstantiationException {
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(c.getClassLoader());
        enhancer.setSuperclass(c);
        enhancer.setCallback(new MyMethodInterceptor2(c.newInstance()));
        return (T)enhancer.create();
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        SendServiceImpl proxy = getProxy(SendServiceImpl.class);
        System.out.println(proxy.send());
    }
}
