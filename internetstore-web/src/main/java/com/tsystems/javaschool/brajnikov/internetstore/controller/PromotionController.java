package com.tsystems.javaschool.brajnikov.internetstore.controller;

import com.tsystems.javaschool.brajnikov.internetstore.model.PromotionEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.PromotionService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("promotionController")
public class PromotionController {
    @Autowired
    private PromotionService promotionService;
    @Autowired
    RabbitTemplate template;

    @RequestMapping(value = "/promo/promotionlist", method = RequestMethod.GET)
    public String getPromotionList(Model model) {
        model.addAttribute("promotions", promotionService.getPromotionList());
        return "/promo/promotionlist";
    }

    @RequestMapping(value = "/promo/addpromotion", method = RequestMethod.GET)
    public String addPromotion(Model model) {
        model.addAttribute("promotion", new PromotionEntity());
        return "/promo/addpromotion";
    }

    @RequestMapping(value = "/promo/addpromotion", method = RequestMethod.POST)
    public String addPromotion(Model model, @ModelAttribute("promotion") PromotionEntity promo) {
        promotionService.createPromotion(promo);
        template.convertAndSend("promo_queue","PROMO.MESSAGE");
        return "redirect:/promo/promotionlist";
    }

    @RequestMapping(value = "/promo/editpromotion", method = RequestMethod.GET)
    public String editPromotion(Model model, @RequestParam("id") Integer id) {
        model.addAttribute("promotion", promotionService.getPromotionById(id));
        template.convertAndSend("promo_queue","PROMO.MESSAGE");
        return "/promo/editpromotion";
    }

    @RequestMapping(value = "/promo/editpromotion", method = RequestMethod.POST)
    public String editPromotion(Model model, @ModelAttribute("promotion") PromotionEntity promo) {
        promotionService.updatePromotion(promo);
        template.convertAndSend("promo_queue","PROMO.MESSAGE");
        return "redirect:/promo/promotionlist";
    }

    @RequestMapping(value = "/promo/deletepromotion", method = RequestMethod.GET)
    public String deletePromotion(Model model, @RequestParam("id") Integer id) {
        if (promotionService.getPromotionById(id) != null) {
            promotionService.deletePromotionById(id);
        }
        template.convertAndSend("promo_queue","PROMO.MESSAGE");
        return "redirect:/promo/promotionlist";
    }

}
