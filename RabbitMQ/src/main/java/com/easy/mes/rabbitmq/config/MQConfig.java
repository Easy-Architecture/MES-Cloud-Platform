package com.easy.mes.rabbitmq.config;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//public class MQConfig {

//    TODO:下列配置在此位置未生效
    /*
        消息转换(json格式)
     */
//    @Bean
//    public MessageConverter messageConverter() {
//        return new Jackson2JsonMessageConverter();
//    }

//    @Bean
//    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
//        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//        /*
//              publisher->Broker的确认回调
//              confirm(@Nullable CorrelationData correlationData,
//              boolean ack,
//              @Nullable String cause)
//        */
//        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> System.out.println("confirm(CorrelationData:" + correlationData +
//                "ack:" + ack + "cause:" + cause + ")"));
//
//        /*
//              当mandatory标志位设置为true时
//              如果exchange根据自身类型和消息routingKey无法找到一个合适的queue存储消息
//              那么broker会调用basic.return方法将消息返还给生产者
//              当mandatory设置为false时，出现上述情况broker会直接将消息丢弃
//        */
////        rabbitTemplate.setMandatory(true);
//        /*
//                Broker->Queue的回调(失败触发)
//                returnedMessage(Message message,
//                int replyCode,
//                String replyText,
//                String exchange,
//                String routingKey)
//        */
//        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> System.out.println("Fail_Message(message:" + message +
//                "replyCode:" + replyCode +
//                "replyText:" + replyText +
//                "exchange:" + exchange +
//                "routingKey:" + routingKey + ")"));
//
//        return rabbitTemplate;
//    }
//}
