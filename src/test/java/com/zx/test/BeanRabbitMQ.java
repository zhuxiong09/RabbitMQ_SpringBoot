package com.zx.test;

import com.zx.RabbitmqSpringbootApplication;
import com.zx.bean.Color;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = RabbitmqSpringbootApplication.class)
@RunWith(SpringRunner.class)
public class BeanRabbitMQ {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    //  4.route 路由模式
    @Test
    public void testRoute(){
        Color color = new Color(1,"lansssss");

        rabbitTemplate.convertAndSend("directs","info",color);
    }
}
