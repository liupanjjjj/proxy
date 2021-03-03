package com.liupan.jdk.service.impl;

import com.liupan.jdk.service.SendService;

public class SendServiceImpl implements SendService {
    @Override
    public String send() {
        System.out.println("send message hello!");
        return "success";
    }
}
