package com.easy.cloundmes.analysis;

import org.fusesource.mqtt.client.*;

/**
 * @author zhaohan
 * mqtt接受信息
 */

public class MqttSubscriber {
    public static final String  MQTT_SERVER_URL="127.0.0.0";

    public static String subscriber() throws Exception {

        MQTT mqtt = new MQTT();
        mqtt.setHost(MQTT_SERVER_URL, 1883);
        BlockingConnection connection = mqtt.blockingConnection();
        connection.connect();
        Topic[] topics = {new Topic("Java_Test", QoS.AT_LEAST_ONCE)};
        byte[] qoses = connection.subscribe(topics);
        Message message = connection.receive();
        System.out.println(message.getTopic());
        byte[] payload = message.getPayload();
        String json=new String(payload);
        message.ack();
        connection.disconnect();
        return json;

    }
}
