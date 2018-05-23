package com.tsystems.javaschool.brajnikov.internetstore.controller;

import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.CategoryService;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("manageGoodsController")
@RequestMapping
public class ManageGoodsController extends AbstractController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private CategoryService categoryService;

    static final Logger logger = LoggerFactory.getLogger(ManageGoodsController.class);

    @RequestMapping(value = "/addgoods", method = RequestMethod.GET)
    public String addGoodsPage(Model model) {
        model.addAttribute("goods", new GoodsEntity());
        model.addAttribute("categories", categoryService.getCategoryList());
        return "/addgoods";
    }

    @RequestMapping(value = "/addgoods", method = RequestMethod.POST)
    public ModelAndView addNewGoods(@ModelAttribute("goods") GoodsEntity goodsEntity,
                                    Model model) {

            goodsService.addGoods(goodsEntity);
        return new ModelAndView("redirect:/goodslist/");
    }

    @RequestMapping(value = {"/goodslist"}, method = RequestMethod.GET)
    public String listGoods(Model model) {
        List<GoodsEntity> goods = goodsService.findAllGoods();

        model.addAttribute("loggedinuser", getPrincipal());

        model.addAttribute("goods", goods);
        return "/goodslist";
    }


    @RequestMapping(value = "/deleteGoods")
    public String deleteGoods(Model model, @RequestParam("id") Integer id) {
        if (id != null) {
            goodsService.deleteGoodsById(id);
        }
        return "redirect:/goodslist";
    }

    @RequestMapping(value = "/editgoods", method = RequestMethod.GET)
    public String editGoodsPage(Model model, @RequestParam("id") Integer id) {
        if (id != null) {
            model.addAttribute("goods", goodsService.findGoodsById(id));
        }
        return "/editgoods";
    }

    @RequestMapping(value = "/editgoods", method = RequestMethod.POST)
    public ModelAndView editGoods(@ModelAttribute("goods") GoodsEntity goodsEntity) {

        GoodsEntity oldGoods = goodsService.findGoodsById(goodsEntity.getId());
        goodsEntity.setCategory(oldGoods.getCategory());
        goodsService.updateGoods(goodsEntity);
        return new ModelAndView("redirect:/goodslist");
    }
}
