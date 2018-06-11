package com.tsystems.javaschool.brajnikov.internetstore.webservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestMQController {
    static final Logger logger = LoggerFactory.getLogger(TestMQController.class);

    @Autowired
    RabbitTemplate template;

    @RequestMapping("/emit")
    @ResponseBody
    String queue1() {
        logger.info("Emit to queue1");
        template.convertAndSend("queue1","Message to queue");
        return "Emit to queue";
    }
}
