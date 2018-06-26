package com.tsystems.javaschool.brajnikov.internetstore.webservices;

import com.tsystems.javaschool.brajnikov.internetstore.dto.TopGoodsList;
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
    @Autowired
    TopGoodsList topGoodsList;

    @Scheduled(fixedDelay = 600000) //10 minutes
    public void checkTopGods() {
        if (topGoodsList.updateTopGoods()) {
            template.convertAndSend("promo_queue", "GOODS.MESSAGE");
        }

    }
}
