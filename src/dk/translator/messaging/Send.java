/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.translator.messaging;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import java.io.IOException;

/**
 *
 * @author marekrigan
 */
public class Send 
{
    private static final String EXCHANGE_NAME = "cphbusiness.bankJSON";
    
    public static void sendMessage(String message, AMQP.BasicProperties props) throws IOException 
    {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("datdb.cphbusiness.dk");
	factory.setUsername("student");
	factory.setPassword("cph");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        
        channel.basicPublish(EXCHANGE_NAME, "" , props, message.getBytes());
        
        System.out.println(" [x] Sent '" + message + "'");
        
        channel.close();
        connection.close();
    }
}
