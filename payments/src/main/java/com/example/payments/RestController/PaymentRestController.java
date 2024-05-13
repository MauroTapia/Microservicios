package com.example.payments.RestController;

import com.example.payments.model.Payment;
import com.example.payments.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/payments")
@RestController
public class PaymentRestController {
    
    private PaymentService paymentService;
    
    Logger log = LoggerFactory.getLogger(PaymentRestController.class);
    
    public PaymentRestController(PaymentService paymentService) {
        super();
        this.paymentService = paymentService;
    }
    
    @GetMapping()
    public Payment getPayment(String id){
        log.info("Intentando obtener payment con id: "+id);
        
        return new Payment(id, 400.0f, "id 1", "id 2");
    }

    @PostMapping()
    public  void createPayment(@RequestBody Payment payment){
        paymentService.createPayment(payment);
    }
}
