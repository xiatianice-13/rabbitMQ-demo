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
}
