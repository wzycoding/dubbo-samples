package com.wzy.dubbo.samples.echo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.wzy.dubbo.samples.echo.refer.EchoConsumer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

public class AnnotationConsumer {
    public static void main(String[] args) throws IOException {
        // 基于注解配置初始化Spring上下文
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();
        EchoConsumer echoService = context.getBean(EchoConsumer.class);
        String hello = echoService.echo("Hello world!");
        System.out.println("result：" + hello);
    }

    @Configuration
    // 指定要扫描的消费注解，会触发注入
    @EnableDubbo(scanBasePackages = "com.wzy.dubbo.samples.echo")
    @ComponentScan(value = {"com.wzy.dubbo.samples.echo"})
    static class ConsumerConfiguration {
        @Bean
        public ApplicationConfig applicationConfig() {
            ApplicationConfig applicationConfig = new ApplicationConfig();
            applicationConfig.setName("echo-annotation-consumer");
            return applicationConfig;
        }

        @Bean
        public ConsumerConfig consumerConfig() {
            return new ConsumerConfig();
        }

        @Bean
        public RegistryConfig registryConfig() {
            RegistryConfig registryConfig = new RegistryConfig();
            registryConfig.setProtocol("zookeeper");
            // 使用zookeeper作为注册中心，同时给出注册中心的IP和端口
            registryConfig.setAddress("192.168.152.111");
            registryConfig.setPort(2181);
            return registryConfig;
        }
    }
}
