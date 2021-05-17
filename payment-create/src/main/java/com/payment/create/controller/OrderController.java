package com.payment.create.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.payment.create.service.OrderService;

@RestController

public class OrderController {

	@Autowired
	private OrderService orderService;

	@PutMapping("/send")
	public void sendOrderInfo(@RequestBody String message) {
		System.out.println("In Sending mode...");
		orderService.publishToQueue("100", message);

	}

}
