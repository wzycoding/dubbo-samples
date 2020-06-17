package com.wzy.dubbo.samples.echo.refer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wzy.dubbo.samples.echo.api.EchoService;
import org.springframework.stereotype.Component;

@Component
public class EchoConsumer {
    @Reference
    private EchoService echoService;

    public String echo(String name) {
        return echoService.echo(name);
    }
}
