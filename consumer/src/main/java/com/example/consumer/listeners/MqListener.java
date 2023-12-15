package com.example.consumer.listeners;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 王俊豪
 * @Date: 2023/12/14/23:21
 * @Description:
 */
@Component
public class MqListener {
	@RabbitListener(queues = "simple")
	public void listen(String msg){
		System.out.println("get message:【"+msg+"】");
	}

	@RabbitListener(queues = "friends")
	public void listenfrienda(String msg){
		System.out.println("a: get message:【"+msg+"】");
	}
	@RabbitListener(queues = "friends")
	public void listenfriendb(String msg){
		System.err.println("b: get message:【"+msg+"】");
	}
	//广播
	@RabbitListener(queues = "fanout1")
	public void listenfanout1(String msg){
		System.out.println("fanout1: get message:【"+msg+"】");
	}
	@RabbitListener(queues = "fanout2")
	public void listenfanout2(String msg){
		System.out.println("fanout2: get message:【"+msg+"】");
	}
	@RabbitListener(queues = "direct.queue1")
	public void listendirect1(String msg){
		System.out.println("direct1: get message:【"+msg+"】");
	}
	@RabbitListener(queues = "direct.queue2")
	public void listendirect2(String msg){
		System.out.println("direct2: get message:【"+msg+"】");
	}

	@RabbitListener(queues = "topic.queue1")
	public void listentopic1(String msg){
		System.out.println("topic1: get message:【"+msg+"】");
	}
	@RabbitListener(queues = "topic.queue2")
	public void listentopic2(String msg){
		System.out.println("topic2: get message:【"+msg+"】");
	}

}
