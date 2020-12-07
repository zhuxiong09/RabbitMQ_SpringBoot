package com.zx.topic;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicConsumer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "topics",type = "topic"),
                    key = {"user.save","user.*"}
            )
    })
    public void receive1(String message){
        System.out.println("message1 = " + message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "topics",type = "topic"),
                    key={"order.#","product.#","user.*"}
            )
    })
    public void receive2(String message){
        System.out.println("message2 = " + message);
    }
}

//# 统配符
//        * (star) can substitute for exactly one word.    匹配不多不少恰好1个词
//        # (hash) can substitute for zero or more words.  匹配一个或多个词
//# 如:
//        audit.#    匹配audit.irs.corporate或者 audit.irs 等
//        audit.*   只能匹配 audit.irs