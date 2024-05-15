package com.rabbitmq.publisher;

import com.rabbitmq.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonProducer {
    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.json.routing.key}")
    private String routingJsonKey;

    private static final Logger LOGGER= LoggerFactory.getLogger(RabbitMQJsonProducer.class);
    @Autowired
    private RabbitTemplate rabbitTemplate;
    public void sendJsonMessage(User user){
        LOGGER.info(String.format("Json Message -> %s", user.toString()));
        rabbitTemplate.convertAndSend(exchange,routingJsonKey, user);
    }
 }