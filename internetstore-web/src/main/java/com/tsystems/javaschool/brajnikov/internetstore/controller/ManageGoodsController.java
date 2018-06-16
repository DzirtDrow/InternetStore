package com.tsystems.javaschool.brajnikov.internetstore.controller;

import com.tsystems.javaschool.brajnikov.internetstore.exception.DeletingGoodsException;
import com.tsystems.javaschool.brajnikov.internetstore.model.CategoryEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.ParameterEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.CategoryService;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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
    public String addGoodsPage(Model model, @RequestParam(value = "error", required = false) String error) {
        logger.info("Showing add goods page");
        model.addAttribute("error", error);
        model.addAttribute("goods", new GoodsEntity());
        model.addAttribute("categories", categoryService.getCategoryDtoList());
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
                                    Model model, BindingResult result) {
        logger.info("Adding new goods {}", goodsEntity.getName());
        if (goodsEntity.getPrice() > 0) {
            goodsService.addGoods(goodsEntity);
            return new ModelAndView("redirect:/goodslist/");
        } else {
            return new ModelAndView("redirect:/addgoods?error=neg");
        }

    }

    /**
     * List of goods.
     *
     * @param model the model
     * @return the string
     */
//    @RequestMapping(value = {"/goodslist"}, method = RequestMethod.GET)
//    public String listGoods(Model model) {
//        logger.info("Showing goods list for manager");
//        List<GoodsEntity> goods = goodsService.findAllGoods();
//        model.addAttribute("goods", goods);
//        return "/goodslist";
//    }
    @RequestMapping(value = {"/goodslist/{type}", "/goodslist"}, method = RequestMethod.GET)
    public String listGoods(@PathVariable Map<String, String> pathVariablesMap, Model model, HttpServletRequest req) {
        String type = pathVariablesMap.get("type");
        logger.info("Showing goods list for manager");
        PagedListHolder<GoodsEntity> goodsPage = null;
        if (type == null) {
            List<GoodsEntity> goods = goodsService.findAllGoods();
            goodsPage = new PagedListHolder<GoodsEntity>();
            goodsPage.setSource(goods);
            goodsPage.setPageSize(10);
            req.getSession().setAttribute("goods", goodsPage);
            // model.addAttribute("goods", goodsPage);
        } else if ("next".equals(type)) {
            // Return next set of list
            goodsPage = (PagedListHolder<GoodsEntity>) req.getSession()
                    .getAttribute("goods");

            goodsPage.nextPage();
        } else if ("prev".equals(type)) {
            // Return previous set of list
            goodsPage = (PagedListHolder<GoodsEntity>) req.getSession()
                    .getAttribute("goods");
            goodsPage.previousPage();
        } else {
            // Return specific index set of list
            goodsPage = (PagedListHolder<GoodsEntity>) req.getSession()
                    .getAttribute("goods");
            int pageNum = Integer.parseInt(type);
            goodsPage.setPage(pageNum);

        }
        //ModelAndView mv = new ModelAndView("goodslist");
//        List<GoodsEntity> goods = goodsService.findAllGoods();
//        model.addAttribute("goods", goods);
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
    public String deleteGoods(Model model, @RequestParam("id") String id) throws DeletingGoodsException {
        if (id != null) {
            if (!goodsService.isInOrder(goodsService.findGoodsById(Integer.parseInt(id)))) {
                goodsService.deleteGoodsById(Integer.parseInt(id));
            } else {
                throw new DeletingGoodsException("You can not delete this goods, because it is in some orders");
            }

        }
        logger.info("Deleting goods {}", goodsService.findGoodsById(Integer.parseInt(id)));
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
        GoodsEntity goods = null;
        if (id != null) {
            goods = goodsService.findGoodsById(id);
            model.addAttribute("goods", goods);
        }
        List<ParameterEntity> parameters = null;
        if(goods != null) {
            CategoryEntity category = goods.getCategory(); //TODO
             parameters = category.getParameters();//categoryService.getParametersByCategory(category);

        }
        model.addAttribute("parameters", parameters);
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
