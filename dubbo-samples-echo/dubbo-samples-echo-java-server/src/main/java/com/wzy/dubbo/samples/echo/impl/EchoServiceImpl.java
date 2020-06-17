package com.wzy.dubbo.samples.echo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wzy.dubbo.samples.echo.api.EchoService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 描述： EchoServiceImpl实现类
 */
@Service
public class EchoServiceImpl implements EchoService {
    @Override
    public String echo(String message) {
        String now = new SimpleDateFormat("HH:mm:ss").format(new Date());
        System.out.println("[" + now + "] Hello" + message +
                ", request from consumer: " + message);
        return message;
    }
}
