package com.tsystems.javaschool.brajnikov.internetstore.controller;

import com.tsystems.javaschool.brajnikov.internetstore.model.CategoryEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.ParameterEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.CategoryService;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller("manageCategoriesController")
public class ManageCategoriesController extends AbstractController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ParameterService parameterService;

    @RequestMapping(value = {"/managecategories"}, method = RequestMethod.GET)
    public String manageCategoriesPage(Model model) {
        model.addAttribute("categories", categoryService.getCategoryList());
        return "/managecategories";
    }

    @RequestMapping(value = {"/editcategory"}, method = RequestMethod.GET)
    public String editCategory(Model model, @RequestParam(value = "id") Integer id) {
        CategoryEntity categoryEntity = categoryService.getCategoryById(id);
        model.addAttribute("category", categoryEntity);
        List<ParameterEntity> paremeters = categoryEntity.getParameters();
        //if (paremeters != null) {
        model.addAttribute("parameters", paremeters);

        List<ParameterEntity> possibleParameters = parameterService.getPossibleParameters();

        model.addAttribute("possibleParameters", possibleParameters);
        //}
        return "/editcategory";
    }

    @RequestMapping(value = {"/deletecategory"}, method = RequestMethod.GET)
    public String deleteCategory(Model model, @RequestParam(value = "id") Integer id) {

        categoryService.deleteCategoryById(id);
        return "redirect:/managecategories";
    }

    @RequestMapping(value = {"/deleteparamfromcategory"}, method = RequestMethod.GET)
    public String deleteParamFromCategory(Model model,
                                          @RequestParam(value = "idparam") Integer idparam,
                                          @RequestParam(value = "idcategory") Integer idcategory) {

        CategoryEntity categoryEntity = categoryService.getCategoryById(idcategory);
        List<ParameterEntity> parameters = categoryEntity.getParameters();
        for (int i = 0; i < parameters.size(); i++) {
            int pi = parameters.get(i).getId();
            if (pi == idparam) {
                //ParameterEntity p = parameters.get(i);
                parameters.remove(i);
                categoryEntity.setParameters(parameters);
                categoryService.updateCategory(categoryEntity);
            } //TODO replace to service
        }
        return "redirect:/editcategory?id=" + idcategory;
    }

    @RequestMapping(value = {"/addparamtocategory"}, method = RequestMethod.GET)
    public String addParamtoCategory(Model model,
                                     @RequestParam(value = "idparam") Integer idparam,
                                     @RequestParam(value = "idcategory") Integer idcategory) {

        CategoryEntity categoryEntity = categoryService.getCategoryById(idcategory);
        List<ParameterEntity> parameters = categoryEntity.getParameters();
        ParameterEntity newParameter = parameterService.getParameterById(idparam);
        if (!parameters.contains(newParameter)) {
            parameters.add(newParameter);
            categoryEntity.setParameters(parameters);
            categoryService.updateCategory(categoryEntity);
        }
        return "redirect:/editcategory?id=" + idcategory;
    }

    @RequestMapping(value = {"/addcategory"}, method = RequestMethod.GET)
    public String addCategoryPage(Model model) {
        model.addAttribute("newcategory", new CategoryEntity());
        return "/addcategory";
    }

    @RequestMapping(value = {"/addcategory"}, method = RequestMethod.POST)
    public String addCategory(@ModelAttribute("category") CategoryEntity category) {
        if (categoryService.findCategoryByName(category.getName()) == null) {
            categoryService.addCategory(category);
        }
        return "redirect:/managecategories";
    }

}
