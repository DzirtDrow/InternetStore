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

/**
 * The Manage goods controller.
 */
@Controller("manageGoodsController")
@RequestMapping
public class ManageGoodsController extends AbstractController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private CategoryService categoryService;

    /**
     * The Logger.
     */
    static final Logger logger = LoggerFactory.getLogger(ManageGoodsController.class);

    /**
     * Add goods page.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping(value = "/addgoods", method = RequestMethod.GET)
    public String addGoodsPage(Model model) {
        logger.info("Showing add goods page");
        model.addAttribute("goods", new GoodsEntity());
        model.addAttribute("categories", categoryService.getCategoryList());
        return "/addgoods";
    }

    /**
     * Add new goods.
     *
     * @param goodsEntity the {@link GoodsEntity}
     * @param model       the model
     * @return the model and view
     */
    @RequestMapping(value = "/addgoods", method = RequestMethod.POST)
    public ModelAndView addNewGoods(@ModelAttribute("goods") GoodsEntity goodsEntity,
                                    Model model) {
        logger.info("Adding new goods {}", goodsEntity.getName());
        goodsService.addGoods(goodsEntity);
        return new ModelAndView("redirect:/goodslist/");
    }

    /**
     * List of goods.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping(value = {"/goodslist"}, method = RequestMethod.GET)
    public String listGoods(Model model) {
        logger.info("Showing goods list for manager");
        List<GoodsEntity> goods = goodsService.findAllGoods();
        model.addAttribute("goods", goods);
        return "/goodslist";
    }


    /**
     * Delete goods.
     *
     * @param model the model
     * @param id    the goods id
     * @return the string
     */
    @RequestMapping(value = "/deleteGoods")
    public String deleteGoods(Model model, @RequestParam("id") Integer id) {
        if (id != null) {
            goodsService.deleteGoodsById(id);
        }
        logger.info("Deleting goods {}", goodsService.findGoodsById(id));
        return "redirect:/goodslist";
    }

    /**
     * Edit goods page.
     *
     * @param model the model
     * @param id    the id
     * @return the string
     */
    @RequestMapping(value = "/editgoods", method = RequestMethod.GET)
    public String editGoodsPage(Model model, @RequestParam("id") Integer id) {
        if (id != null) {
            model.addAttribute("goods", goodsService.findGoodsById(id));
        }
        logger.info("Showing goods edit page");
        return "/editgoods";
    }

    /**
     * Edit goods.
     *
     * @param goodsEntity the {@link GoodsEntity}
     * @return the model and view
     */
    @RequestMapping(value = "/editgoods", method = RequestMethod.POST)
    public ModelAndView editGoods(@ModelAttribute("goods") GoodsEntity goodsEntity) {

        GoodsEntity oldGoods = goodsService.findGoodsById(goodsEntity.getId());
        goodsEntity.setCategory(oldGoods.getCategory());
        goodsService.updateGoods(goodsEntity);
        logger.info("Updating goods {}", goodsEntity);
        return new ModelAndView("redirect:/goodslist");
    }
}
