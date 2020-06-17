package com.wzy.dubbo.samples.echo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.wzy.dubbo.samples.echo.api.EchoService;

/**
 * 描述：使用Java API 调用dubbo暴露接口
 */
public class EchoConsumer {
    public static void main(String[] args) {
        ReferenceConfig<EchoService> reference = new ReferenceConfig<>();
        // 设置消费方应用名称
        reference.setApplication(new ApplicationConfig("java-echo-consumer"));
        // 设置注册中心地址和协议
        reference.setRegistry(new RegistryConfig("zookeeper://192.168.152.111:2181"));
        // 指定要消费的服务接口
        reference.setInterface(EchoService.class);
        // 创建远程连接并做动态代理转换
        EchoService greetingsService = reference.get();
        String message = greetingsService.echo("Hello world! ");
        System.out.println(message);
    }
}
