package com.example.payments.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class Publishnotification {

    private RabbitTemplate rabbitTemplate;

    public Publishnotification(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessageToTopic(String message ){
        rabbitTemplate.convertAndSend("send-notification", message);
    }
}
