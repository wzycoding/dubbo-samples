package com.wzy.dubbo.samples.echo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class EchoProvider {
    public static void main(String[] args) throws IOException {
        // 1.指定服务暴露配置文件
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"spring/echo-provider.xml"});
        // 2.启动Spring容器并暴露服务
        context.start();

        System.in.read();
    }
}
