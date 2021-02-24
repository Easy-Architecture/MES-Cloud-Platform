package com.easy.cloundmes.publish;

import com.easy.cloundmes.analysis.Implementer;
import com.easy.cloundmes.analysis.MqttSubscriber;
import com.easy.cloundmes.analysis.ThreadPool;
import org.fusesource.mqtt.client.BlockingConnection;
import org.fusesource.mqtt.client.MQTT;
import org.fusesource.mqtt.client.QoS;

/**
 * @author zhaohan
 * mqtt发送信息
 */

public class MqttPublisher {

    public static final String  MQTT_SERVER_URL="127.0.0.0";

    public static void publisher(String order) throws Exception {

        MQTT mqtt = new MQTT();
        mqtt.setHost(MqttSubscriber.MQTT_SERVER_URL, 1883);
        BlockingConnection connection = mqtt.blockingConnection();
        connection.connect();
        String[] json= ThreadPool.distribute(new Implementer(order));
        String task1=json[0];
        connection.publish("Java_Test", task1.getBytes(), QoS.AT_LEAST_ONCE, true);
        String task2=json[1];
        connection.publish("Java_Test", task2.getBytes(), QoS.AT_LEAST_ONCE, true);


    }

}

