package com.zx.test;

import com.zx.RabbitmqSpringbootApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = RabbitmqSpringbootApplication.class)
@RunWith(SpringRunner.class)
public class RabbitMQ {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    //  1.hello模型一对一
    @Test
    public void testHello(){
        rabbitTemplate.convertAndSend("hello","ni hao ya !");
    }

    //  2.work模型，一对多 轮询
    @Test
    public void testWork(){
        for(int i = 1; i <= 10;i++){
            rabbitTemplate.convertAndSend("work","work模型:"+i);
        }
    }

    //  3.fanout 广播
    @Test
    public void testFanout(){
        rabbitTemplate.convertAndSend("logs","","Fanout的模型发送的消息");
    }

    //  4.route 路由模式
    @Test
    public void testRoute(){
        rabbitTemplate.convertAndSend("directs","info","发送info的key的路由信息");
    }

    //  5.topic 动态路由  订阅模式
    @Test
    public void testTopic(){
        rabbitTemplate.convertAndSend("topics","product.save.add","produce.save.add 路由消息");
    }
}
