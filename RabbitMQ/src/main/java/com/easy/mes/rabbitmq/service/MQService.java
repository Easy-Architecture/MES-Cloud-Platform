package com.easy.mes.rabbitmq.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class MQService {
    @Resource
    private AmqpTemplate amqpTemplate;

    @Resource
    private RabbitTemplate rabbitTemplate;

    /*
        send(String exchange, String routingKey, Message message)
     */
    public boolean sendMessage(String exchange, String routingKey, Object message){
        amqpTemplate.convertAndSend(exchange,routingKey,message);
        log.info("消息发送完成！！！");
                /*
              publisher->Broker的确认回调
              confirm(@Nullable CorrelationData correlationData,
              boolean ack,
              @Nullable String cause)
        */
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> System.out.println("publisher->Broker的确认回调:confirm(CorrelationData:" + correlationData +
                "ack:" + ack + "cause:" + cause + ")"));

        /*
              当mandatory标志位设置为true时
              如果exchange根据自身类型和消息routingKey无法找到一个合适的queue存储消息
              那么broker会调用basic.return方法将消息返还给生产者
              当mandatory设置为false时，出现上述情况broker会直接将消息丢弃
        */
//        rabbitTemplate.setMandatory(true);
        /*
                Broker->Queue的回调(失败触发)
                returnedMessage(Message message,
                int replyCode,
                String replyText,
                String exchange,
                String routingKey)
        */
        //TODO:
        rabbitTemplate.setReturnCallback((m, rC, rT, e, rK) -> System.out.println("Broker->Queue的回调(失败触发):Fail_Message(message:" + m +
                "replyCode:" + rC +
                "replyText:" + rT +
                "exchange:" + e +
                "routingKey:" + rK + ")"));

        return true;
    }
}
