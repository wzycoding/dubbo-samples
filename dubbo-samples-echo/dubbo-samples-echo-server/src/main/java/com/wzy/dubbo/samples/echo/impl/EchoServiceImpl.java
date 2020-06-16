package com.wzy.dubbo.samples.echo.impl;


import com.alibaba.dubbo.rpc.RpcContext;
import com.wzy.dubbo.samples.echo.api.EchoService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 描述： Echo接口的实现类
 */
public class EchoServiceImpl implements EchoService {

    @Override
    public String echo(String message) {
        String now = new SimpleDateFormat("HH:mm:ss").format(new Date());
        System.out.println("[" + now + "] Hello " + message +
                ", request from consumer: " +
                RpcContext.getContext().getRemoteAddress());
        return message;
    }
}
