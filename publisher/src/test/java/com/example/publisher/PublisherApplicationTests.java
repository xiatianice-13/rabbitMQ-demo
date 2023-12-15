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

	@Test
	void friends2msg() throws InterruptedException {
		for (int i = 0; i < 50; i++) {
			String msg = "hi,"+i+" let's play csgo";
			rabbitTemplate.convertAndSend("friends",msg);
			Thread.sleep(20);
		}
	}
	@Test
	void sendFanout(){
		rabbitTemplate.convertAndSend("wjh.fanout",null,"fanout-msg");
	}

	@Test
	void sendDirect(){
		rabbitTemplate.convertAndSend("wjh.direct","red","direct-red-msg");
		rabbitTemplate.convertAndSend("wjh.direct","yellow","direct-yellow-msg");
		rabbitTemplate.convertAndSend("wjh.direct","blue","direct-blue-msg");
	}

	@Test
	void sendTopic(){
		rabbitTemplate.convertAndSend("wjh.topic","cq.news","cold");
		rabbitTemplate.convertAndSend("wjh.topic","china.salary","low");
	}
}
