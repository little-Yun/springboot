package com.study.mq.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class Sender  {
    private static final String QUEUE_NAME = "hello";

    public static void main(String[] args)
            throws IOException, TimeoutException
    {
        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("localhost");

        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare("hello", false, false, false, null);

        String message = "Hello World!";
        channel.basicPublish("", "hello", null, message.getBytes());
        System.err.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }
}