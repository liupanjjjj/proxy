package com.liupan.jdk.proxy;

import com.liupan.jdk.service.SendService;
import com.liupan.jdk.service.impl.SendServiceImpl;

import java.lang.reflect.Proxy;

public class ProxyFactory {

    public static void main(String[] args) {
        SendService sendService = new SendServiceImpl();
        SendService proxy = getProxy(sendService);
        System.out.println(proxy.send());
    }
    public static <T> T getProxy(T obj){
        T t = (T)Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),new MyInvocationHandler(obj));
        return t;
    }

}
