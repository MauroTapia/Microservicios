package com.example.payments.service;

import com.example.payments.client.PaymentClient;
import com.example.payments.model.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private PaymentClient paymentClient;

    private Publishnotification publishnotification;


    public PaymentService(PaymentClient paymentClient, Publishnotification publishnotification) {
        this.paymentClient = paymentClient;
        this.publishnotification = publishnotification;
    }

    public void createPayment(Payment payment){
        paymentClient.createPayment(payment);
        publishnotification.sendMessageToTopic(payment.getClientId());
    }

}
