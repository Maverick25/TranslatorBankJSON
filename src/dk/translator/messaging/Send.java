/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.translator.messaging;

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
    // changes to come!!!!!!!!!!!!!!!!!!!
    
    private static final String TASK_QUEUE_NAME = "queue_bankJSON";
    
    public static void sendMessage(String message) throws IOException 
    {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("datdb.cphbusiness.dk");
	factory.setUsername("student");
	factory.setPassword("cph");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        
        channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
        
        channel.basicPublish( "", TASK_QUEUE_NAME, 
                MessageProperties.PERSISTENT_TEXT_PLAIN,
                message.getBytes());
        
        channel.close();
        connection.close();
    }
}
