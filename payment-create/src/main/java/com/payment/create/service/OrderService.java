package com.payment.create.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
	
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "Lamp123";

    
    public void publishToQueue(String key,String msg) {
    	
        kafkaTemplate.send(TOPIC, key, msg);
        
    }

}
