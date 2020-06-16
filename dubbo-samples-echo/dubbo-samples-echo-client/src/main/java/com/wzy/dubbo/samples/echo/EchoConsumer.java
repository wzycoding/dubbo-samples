package com.wzy.dubbo.samples.echo;

import com.wzy.dubbo.samples.echo.api.EchoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 描述： 消费者demo
 */
public class EchoConsumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(new String [] {"spring/echo-consumer.xml"});
        context.start();
        EchoService echoService = (EchoService) context.getBean("echoService");

        String status = echoService.echo("Hello world!");
        System.out.println("echo result: " + status);

    }

}
