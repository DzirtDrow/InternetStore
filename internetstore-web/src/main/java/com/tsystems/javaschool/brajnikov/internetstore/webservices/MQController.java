package com.tsystems.javaschool.brajnikov.internetstore.webservices;

import com.tsystems.javaschool.brajnikov.internetstore.dto.TopGoodsList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MQController {
    static final Logger logger = LoggerFactory.getLogger(MQController.class);

    @Autowired
    RabbitTemplate template;
    @Autowired
    TopGoodsList topGoodsList;

    @RequestMapping("/emit")
    @ResponseBody
    String queue1() {
        logger.info("Emit to promo queue");
        template.convertAndSend("promo_queue","GOODS.MESSAGE");

        topGoodsList.updateTopGoods();

        return "Emit to queue";
    }
}
