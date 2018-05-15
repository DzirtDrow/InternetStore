package com.tsystems.javaschool.brajnikov.internetstore.dao.implemenations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.AbstractGenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.OrderDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.CartItemEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.OrderEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository("orderDao")
public class OrderDaoImpl extends AbstractGenericDao<OrderEntity, Integer> implements OrderDao{
    @Autowired
    private SessionFactory sessionFactory;

    public void createOrder() {
//TODO ???
    }

    public void addGoodsToOrder(GoodsEntity goodsEntity, Integer num) {
        CartItemEntity cartEntity = new CartItemEntity(); // TODO

//TODO
    }

    public List<OrderEntity> getOrdersByUser(UserEntity userEntity) {
        Query query = sessionFactory.getCurrentSession().createQuery("from OrderEntity where user = :paramName");
        query.setParameter("paramName", userEntity);
        List<OrderEntity> orderList = query.getResultList();
        return orderList;
    }
}

