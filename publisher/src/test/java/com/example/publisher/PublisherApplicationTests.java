package com.example.publisher;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PublisherApplicationTests {
	@Autowired
	RabbitTemplate rabbitTemplate;
	@Test
	void contextLoads() {
		rabbitTemplate.convertAndSend("simple","msg123");
	}

}
