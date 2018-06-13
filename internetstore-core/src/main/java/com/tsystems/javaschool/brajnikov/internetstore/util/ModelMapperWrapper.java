package com.tsystems.javaschool.brajnikov.internetstore.util;

import com.tsystems.javaschool.brajnikov.internetstore.dto.*;
import com.tsystems.javaschool.brajnikov.internetstore.model.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class ModelMapperWrapper {
    private ModelMapper modelMapper = new ModelMapper();
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);

        modelMapper.getConfiguration().setAmbiguityIgnored(true);

//            modelMapper.createTypeMap(GoodsDto.class, GoodsEntity.class).addMappings(mapper -> mapper.skip(GoodsEntity::setId));
//
//            modelMapper.createTypeMap(Category.class, CategoryDTO.class).addMappings(mapper -> mapper.skip(CategoryDTO::setChildren));
//
//            modelMapper.createTypeMap(ProductStat.class, ProductStatDTO.class)
//                    .addMappings(mapper -> mapper.map(src -> src.getProduct().getId(), ProductStatDTO::setProductId));
//
//            Converter<Timestamp, LocalDateTime> timeStampConverter = ctx -> ctx.getSource().toLocalDateTime();
//
//            modelMapper.createTypeMap(Order.class, OrderDTO.class).addMappings(mapper -> mapper.using(timeStampConverter)
//                    .map(Order::getOrderedAt, OrderDTO::setOrderedAt));
    }
    public GoodsDto mapGoods(GoodsEntity goods) {
        return modelMapper.map(goods, GoodsDto.class);
    }

    public ParameterDto mapParameter(ParameterEntity parameter){
        return modelMapper.map(parameter,ParameterDto.class);
    }
    public CategoryDto mapCategory(CategoryEntity category) {
        return modelMapper.map(category, CategoryDto.class);
    }

    public GoodsParameterDto mapGoodsParameter(GoodsParameterEntity goodsParameter) {
        return modelMapper.map(goodsParameter, GoodsParameterDto.class);
    }

    public PromotionDto mapPromotion(PromotionEntity promotion){
        return modelMapper.map(promotion, PromotionDto.class);
    }
}
