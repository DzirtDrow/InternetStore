package com.tsystems.javaschool.brajnikov.internetstore.configuration;

import com.tsystems.javaschool.brajnikov.internetstore.webservices.TestMQController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig{

    static final Logger logger = LoggerFactory.getLogger(TestMQController.class);

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory =
                new CachingConnectionFactory("localhost");
        return connectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }

    @Bean
    public Queue myQueue1() {
        return new Queue("queue1");
    }

    //объявляем контейнер, который будет содержать листенер для сообщений
    @Bean
    public SimpleMessageListenerContainer messageListenerContainer1() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setQueueNames("queue1");
        container.setMessageListener(new MessageListener() {
            //тут ловим сообщения из queue1
            public void onMessage(Message message) {
                logger.info("received from queue1 : " + new String(message.getBody()));
            }
        });
        return container;
    }
}
