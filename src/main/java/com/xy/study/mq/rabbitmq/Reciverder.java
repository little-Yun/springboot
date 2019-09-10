package com.xy.study.mq.rabbitmq;

import com.rabbitmq.client.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class Reciverder {
    private static final String QUEUE_NAME = "hello";

    public static void main(String[] args)
            throws IOException, TimeoutException
    {
        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("localhost");

        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare("hello", false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel)
        {
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException
            {
                String message = new String(body, "UTF-8");
                System.err.println(" [x] Received '" + message + "'");
            }
        };
        channel.basicConsume("hello", true, consumer);
    }
}