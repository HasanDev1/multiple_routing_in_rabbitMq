package uz.agro.multipleQueue.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqDirectConfig {

    @Bean
    public Queue marketingQueue() {
        return new Queue("marketingQueue", false);
    }

    @Bean
    public Queue financeQueue() {
        return new Queue("financeQueue", false);
    }

    @Bean
    public Queue adminQueue() {
        return new Queue("adminQueue", false);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("directExchange");
    }

    @Bean
    public Binding marketingBinding(Queue marketingQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(marketingQueue).to(directExchange).with("marketing");
    }

    @Bean Binding financeBinding(Queue financeQueue, DirectExchange directExchange){
        return BindingBuilder.bind(financeQueue).to(directExchange).with("finance");
    }

    @Bean
    Binding adminBinding(Queue adminQueue, DirectExchange directExchange){
        return BindingBuilder.bind(adminQueue).to(directExchange).with("admin");
    }
}
