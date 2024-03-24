package com.usermicroservice.user.producers;

import com.usermicroservice.user.domains.UserModel;
import com.usermicroservice.user.dtos.EmailDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {
    final RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.queue}")
    private String routingKey;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishMessageEmail(UserModel userModel) {
        var emailDTO = new EmailDTO(userModel.getUserID(), userModel.getEmail(), "User successfully created!", userModel.getUsername() + " Wellcome.");
        rabbitTemplate.convertAndSend("", routingKey, emailDTO);
    }
}
