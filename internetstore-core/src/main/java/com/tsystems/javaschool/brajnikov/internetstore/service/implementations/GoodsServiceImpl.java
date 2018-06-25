package com.tsystems.javaschool.brajnikov.internetstore.service.implementations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.CategoryDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.GoodsDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.GoodsParameterDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.OrdersDao;
import com.tsystems.javaschool.brajnikov.internetstore.dto.GoodsDto;
import com.tsystems.javaschool.brajnikov.internetstore.enums.ParameterTypeEnum;
import com.tsystems.javaschool.brajnikov.internetstore.model.*;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service("goodsService")
@Transactional
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private OrdersDao ordersDao;

    @Autowired
    private GoodsParameterDao goodsParameterDao;

    @Autowired
    private CategoryDao categoryDao;

    public List<GoodsEntity> findAllGoods() {
        return goodsDao.findAllGoods();
    }

    public void addGoods(GoodsEntity goodsEntity) {
        goodsDao.create(goodsEntity);

        CategoryEntity category = categoryDao.read(goodsEntity.getCategory().getId());

        List<ParameterEntity> possibleParameters = category.getParameters();

        for (ParameterEntity param : possibleParameters) {
            GoodsParameterEntity goodsParameter = new GoodsParameterEntity();
            goodsParameter.setGoods(goodsEntity);
            goodsParameter.setParameter(param);
            if (param.getParameterType() == ParameterTypeEnum.param_num) {
                goodsParameter.setNumValue(0);
            } else {
                goodsParameter.setStringValue("");
            }
            goodsParameterDao.create(goodsParameter);
        }
    }

    public void deleteGoods(GoodsEntity goodsEntity) {
        goodsDao.delete(goodsEntity);
    }

    public GoodsEntity findGoodsById(int id) {
        return goodsDao.read(id);
    }

    public void updateGoods(GoodsEntity goodsEntity) {
        goodsDao.update(goodsEntity);
    }

    public void deleteGoodsById(Integer id) {
        goodsDao.delete(goodsDao.read(id));
    }

    @Override
    public boolean isInOrder(GoodsEntity goods) {

        List<OrderEntity> ordersList = ordersDao.getOrdersByGoods(goods);
        return !ordersList.isEmpty();
    }

    @Override
    public List<GoodsDto> getTopSales(int count) {

        List<GoodsEntity> goodsEntityList = goodsDao.getTopList(count);

        List<GoodsDto> resultList = new ArrayList<>();
        for (GoodsEntity goods : goodsEntityList) {
            GoodsDto goodsDto = new GoodsDto(goods.getId(),
                    goods.getName(),
                    goods.getPrice(),
                    goods.getDescription(),
                    goods.getLeftCount(),
                    goods.getSalesCount());
            resultList.add(goodsDto);
        }
        return resultList;

    }

    @Override
    public CategoryEntity findCategoryByGoods(GoodsEntity goods) {
        return goodsDao.findCategoryByGoods(goods);
    }

    @Override
    public void alignGoodsParametersToCategory(GoodsEntity goods) {
        List<GoodsParameterEntity> goodsParameterList = goods.getGoodsParameterList();
        List<ParameterEntity> goodsParameters = new ArrayList<>();
        for (GoodsParameterEntity goodsParam: goodsParameterList) {
            goodsParameters.add(goodsParam.getParameter()); //now we got list of ParameterEntity by Goods
        }

        CategoryEntity category = goods.getCategory();
        List<ParameterEntity> categoryParameters = category.getParameters();

        Iterator<GoodsParameterEntity> goodsP = goodsParameterList.iterator();

        while (goodsP.hasNext()){
            GoodsParameterEntity temp = goodsP.next();
            if(!categoryParameters.contains(temp.getParameter())){
                goodsParameterDao.delete(temp);
            }
        }


        for (ParameterEntity catP: categoryParameters) {
            if(!goodsParameters.contains(catP)){
                GoodsParameterEntity newGoodsParameter = new GoodsParameterEntity();
                newGoodsParameter.setStringValue("");
                newGoodsParameter.setNumValue(0);
                newGoodsParameter.setParameter(catP);
                newGoodsParameter.setGoods(goods);
                goodsParameterDao.create(newGoodsParameter);
            }
        }

    }
}
