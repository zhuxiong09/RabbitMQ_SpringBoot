package com.zx.fanout;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class FanoutConsumer {

    @RabbitListener(bindings = {@QueueBinding(
            value = @Queue,//创建临时队列
            exchange = @Exchange(value = "logs", type = "fanout")//绑定的交换机
    )
    })
    public void receive(String message){
        System.out.println("message1 = " + message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "logs",type = "fanout")
            )
    })
    public void receive2(String message){
        System.out.println("message1 = " + message);
    }
}
