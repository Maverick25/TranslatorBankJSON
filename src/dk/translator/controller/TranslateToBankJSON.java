/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.translator.controller;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;
import dk.translator.messaging.Receive;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author marekrigan
 */
public class TranslateToBankJSON 
{
    private static Gson gson;
    
    public static void receiveMessages() throws IOException,InterruptedException
    {
        gson = new Gson();
        
        HashMap<String,Object> objects = Receive.setUpReceiver();
        
        QueueingConsumer consumer = (QueueingConsumer) objects.get("consumer");
        Channel channel = (Channel) objects.get("channel");
        
        
//        List<String> selectedBanks;
        
        while (true) 
        {
          QueueingConsumer.Delivery delivery = consumer.nextDelivery();
          String message = new String(delivery.getBody());
          
          String routingKey = delivery.getEnvelope().getRoutingKey();

          System.out.println(" [x] Received '" + routingKey + "':'" + message + "'");
          
          channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);

        }
        
    }
    
    public static void sendMessage() throws IOException
    {
     
        
//        Send.sendMessage(message);
    }   
}
