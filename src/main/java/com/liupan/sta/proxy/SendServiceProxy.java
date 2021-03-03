package com.liupan.sta.proxy;

import com.liupan.sta.SendService;
import com.liupan.sta.impl.SendServiceImpl;

public class SendServiceProxy implements SendService {

    private SendService sendService;

    public SendServiceProxy(SendService sendService) {
        this.sendService = sendService;
    }

    @Override
    public String send() {
        System.out.println("before");
        String res = sendService.send();
        System.out.println("after");
        return res;
    }

    public static void main(String[] args) {
        SendService sendService = new SendServiceProxy(new SendServiceImpl());
        sendService.send();
    }
}
