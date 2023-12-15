/**
 * @program: rabbitMQ-demo
 * @description: config
 * @author: 王俊豪
 * @create: 2023-12-15 14:46
 **/
package com.example.consumer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 不推荐
 */
// @Configuration
public class DirectConfiguration {
    @Bean
    public DirectExchange directExchange(){
        // ExchangeBuilder.fanoutExchange("").build();
        return new DirectExchange("wjh.direct");
    }

    @Bean
    public Queue queue3(){
        return new Queue("direct.queue3");
    }

    @Bean
    public Queue queue4(){
        return new Queue("direct.queue4");
    }

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue3()).to(directExchange()).with("red");
    }
    /**
     * 太多，不便捷
     */
}
