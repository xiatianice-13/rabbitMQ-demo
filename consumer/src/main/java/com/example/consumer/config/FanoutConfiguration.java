/**
 * @program: rabbitMQ-demo
 * @description: config
 * @author: 王俊豪
 * @create: 2023-12-15 14:11
 **/
package com.example.consumer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfiguration {
    @Bean
    public FanoutExchange fanoutExchange(){
        // ExchangeBuilder.fanoutExchange("").build();
        return new FanoutExchange("wjh.fanout1");
    }

    @Bean
    public Queue queue(){
        //QueueBuilder.durable("").build(); // 持久化
        return new Queue("fanout3");
    }
    @Bean
    public Binding binding(FanoutExchange fanoutExchange,Queue queue){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

    @Bean
    public Queue queue4(){
        //QueueBuilder.durable("").build(); // 持久化
        return new Queue("fanout4");
    }

    @Bean
    public Binding binding4(){
        return BindingBuilder.bind(queue4()).to(fanoutExchange());
    }
}
