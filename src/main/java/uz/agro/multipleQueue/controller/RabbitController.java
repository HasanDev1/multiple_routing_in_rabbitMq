package uz.agro.multipleQueue.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class RabbitController {

    private final AmqpTemplate amqpTemplate;

    @GetMapping("/producer")
    public String producer(
            @RequestParam(defaultValue = "exchangeName") String exchangeName
            , @RequestParam(defaultValue = "routingKey") String routingKey
            , @RequestParam(defaultValue = "messageDate") String messageDate) {

        amqpTemplate.convertAndSend(exchangeName, routingKey, messageDate);
        return "Send message to the rabbitMq successfully";
    }

}
