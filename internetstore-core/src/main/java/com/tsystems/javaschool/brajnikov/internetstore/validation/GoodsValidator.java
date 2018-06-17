package com.tsystems.javaschool.brajnikov.internetstore.validation;

import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class GoodsValidator  implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return GoodsEntity.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        GoodsEntity goods = (GoodsEntity) o;
        if (goods.getPrice() <= 0 ) {
            errors.rejectValue("price", "Size.goodsForm.price");
        }
    }
}
