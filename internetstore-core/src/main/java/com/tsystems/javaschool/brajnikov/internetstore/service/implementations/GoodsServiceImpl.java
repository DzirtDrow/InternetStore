package com.tsystems.javaschool.brajnikov.internetstore.service.implementations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.GoodsDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.OrdersDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.OrderEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("goodsService")
@Transactional
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private OrdersDao ordersDao;

    public List<GoodsEntity> findAllGoods() {
        return goodsDao.findAllGoods();
    }

    public void addGoods(GoodsEntity goodsEntity) {
        goodsDao.create(goodsEntity);
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
        if (!ordersList.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<GoodsEntity> getTopSales(int count) {
        return goodsDao.getTopList(count);

    }


}
