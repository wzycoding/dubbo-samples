package com.wzy.dubbo.samples.echo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.wzy.dubbo.samples.echo.api.EchoService;
import com.wzy.dubbo.samples.echo.impl.EchoServiceImpl;

import java.io.IOException;

/**
 * 描述： 通过API方式使用dubbo
 */
public class EchoProvider {
    public static void main(String[] args) throws IOException {
        ServiceConfig<EchoService> service = new ServiceConfig<>();
        service.setApplication(new ApplicationConfig("java-echo-provider"));
        service.setRegistry(new RegistryConfig("zookeeper://192.168.152.111:2181"));
        service.setInterface(EchoService.class);
        service.setRef(new EchoServiceImpl());
        service.export();

        System.out.println("java-echo-provider is running.");
        System.in.read();
    }
}
