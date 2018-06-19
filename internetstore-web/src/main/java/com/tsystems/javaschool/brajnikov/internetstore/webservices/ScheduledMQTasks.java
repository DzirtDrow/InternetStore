package com.tsystems.javaschool.brajnikov.internetstore.webservices;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ScheduledMQTasks {

    @Autowired
    RabbitTemplate template;

    @Scheduled(fixedDelay = 10000)
    public void reportCurrentTime() {

        //TODO check top goods list
        //template.convertAndSend("promo_queue","TEST.MESSAGE");
    }
}
