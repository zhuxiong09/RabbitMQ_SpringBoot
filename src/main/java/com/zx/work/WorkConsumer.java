package com.zx.work;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class WorkConsumer {

    //一个消费者
    @RabbitListener(queuesToDeclare = @Queue("work"))//@RabbitListener直接加在方法上，代表监听当前队列消息的回调
    public void receive1(String message){ //String要与消息生产者发出的消息类型一样
        System.out.println("message1 = "+message);
    }


    //2个消费者
    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receive2(String message){
        System.out.println("message2 = "+message);
    }
}
