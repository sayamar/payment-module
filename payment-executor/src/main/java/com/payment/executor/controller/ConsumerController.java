package com.payment.executor.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
	
	private static final String TOPIC = "Lamp123";
		
		@KafkaListener(topics = TOPIC)
	    public void messageListener(ConsumerRecord<String, String> consumerRecord,
	    		Acknowledgment ack) {

	        String key = consumerRecord.key();
	        String value = consumerRecord.value();
	        int partition = consumerRecord.partition();

	        System.out.println("Consumed message : " + value
	                        + " with key : " + key
	                        + " from partition : "+ partition);

	        ack.acknowledge();
	    }
	

}
