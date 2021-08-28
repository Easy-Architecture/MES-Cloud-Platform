package com.mes.test;

import com.easy.mes.coregister10001.Coregister10001ApplicationMain;
import com.easy.mes.coregister10001.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;
import java.util.UUID;

/**
 * <p>
 *     RabbitMQ创建类
 * </p>
 *
 * @author LiZiHan
 * @since 2021-05-12
 */

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Coregister10001ApplicationMain.class)
public class RabbitMQTest {

    @Resource
    AmqpAdmin amqpAdmin;

    @Resource
    RabbitTemplate rabbitTemplate;

    /*
            创建交换机
            DirectExchange(String name--名字,
            boolean durable--持久化,
            boolean autoDelete--自动删除,
            Map<String, Object> arguments)
    */
    @Test
    public void createExchange() {
        DirectExchange directExchange = new DirectExchange("mes.test.Exchange", true, false);
        amqpAdmin.declareExchange(directExchange);
        log.info("Exchange创建完成");
    }

    /*
            创建队列
            Queue(String name--名字,
            boolean durable--持久化,
            boolean exclusive--排它,
            boolean autoDelete--自动删除,
            @Nullable Map<String, Object> arguments)
    */
    @Test
    public void createQueue() {
        Queue queue = new Queue("mes.test.Queue", true, false, false);
        amqpAdmin.declareQueue(queue);
        log.info("Queue创建完成");
    }

    /*
          绑定
          Binding(String destination--目的地,
          DestinationType destinationType--目的地类型,
          String exchange--交换机,
          String routingKey--路由键,
          @Nullable Map<String, Object> arguments)
    */
    @Test
    public void createBinding() {
        Binding binding = new Binding("mes.test.Queue",
                Binding.DestinationType.QUEUE,
                "mes.test.Exchange",
                "mes.test",
                null);
        amqpAdmin.declareBinding(binding);
        log.info("Binding创建完成");
    }

    @Test
    public void sendMessageTest(){
//        Product p = new Product();
        rabbitTemplate.convertAndSend("mes.test.Exchange",
                "mes.test",
                "testMessage",
                new CorrelationData(UUID.randomUUID().toString()));
        log.info("测试消息发送完成");
    }

    /*    注：
          监听消息使用注解两种
          1、--@RabbitListener(queues = {"被监听的队列名"})：标在类上用于监听队列
          2、--@RabbitHandler:标在方法上用于重载不同消息
          -->启动类添加@EnableRabbit
    */

}
