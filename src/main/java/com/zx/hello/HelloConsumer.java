package com.zx.hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queuesToDeclare = @Queue(value = "hello"))//声明队列
public class HelloConsumer {

    @RabbitHandler//代表处理队列中的消息
    public void receive (String message){//String要与消息生产者发出的消息类型一样
        System.out.println("message = " + message);
    }
}
