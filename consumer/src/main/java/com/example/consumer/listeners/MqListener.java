package com.example.consumer.listeners;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
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
	@RabbitListener(bindings = @QueueBinding(
			value = @Queue(name = "directqueue1",durable = "true"),
			exchange = @Exchange(name = "wjh.direct1",type = ExchangeTypes.DIRECT),
			key = {"red","blue"}
	))
	public void listendirect1(String msg){
		System.out.println("direct1: get message:【"+msg+"】");
	}

	@RabbitListener(bindings = @QueueBinding(
			value = @Queue(name = "directqueue2",durable = "true"),
			exchange = @Exchange(name = "wjh.direct1",type = ExchangeTypes.DIRECT),
			key = {"red","blue"}
	))
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
