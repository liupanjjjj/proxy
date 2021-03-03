package com.liupan.sta.impl;

import com.liupan.sta.SendService;

public class SendServiceImpl implements SendService {
    @Override
    public String send() {
        System.out.println("send message hello!");
        return "success";
    }
}
