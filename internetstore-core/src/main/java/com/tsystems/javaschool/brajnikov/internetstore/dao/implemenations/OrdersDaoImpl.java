package com.tsystems.javaschool.brajnikov.internetstore.dao.implemenations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.AbstractGenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.OrdersDao;
import com.tsystems.javaschool.brajnikov.internetstore.enums.SortingTypeEnum;
import com.tsystems.javaschool.brajnikov.internetstore.exception.OrdersNotFoundException;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.OrderEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Repository("orderDao")
public class OrdersDaoImpl extends AbstractGenericDao<OrderEntity, Integer> implements OrdersDao {
    @Autowired
    private SessionFactory sessionFactory;


    @SuppressWarnings("unchecked")
    public List<OrderEntity> getOrdersByUser(UserEntity userEntity) throws OrdersNotFoundException {

        Query query = sessionFactory.getCurrentSession()
                .createQuery("from OrderEntity where user = :userParam order by  id desc ");
        query.setParameter("userParam", userEntity);

        return (List<OrderEntity>) query.getResultList();

    }

    @Override
    public List<OrderEntity> getOrdersList() {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from OrderEntity");
        return (List<OrderEntity>) query.getResultList();
    }

    @Override
    public List<OrderEntity> getOrdersByGoods(GoodsEntity goods) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("select ord from OrderEntity ord " +
//                .createQuery("select OrderEntity from OrderEntity " +
                                "join CartItemEntity cartitrm on ord.id = cartitrm.order.id " +
                                "join GoodsEntity goods on goods.id = cartitrm.goods.id " +
                                "where goods.id = :goodsParam"
                );
        query.setParameter("goodsParam", goods.getId());
        return (List<OrderEntity>) query.getResultList();
    }

    @Override
    public List<OrderEntity> getAllOrdersOrderByDate(SortingTypeEnum type) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from OrderEntity order by order_date " + type);
        return (List<OrderEntity>) query.getResultList();
    }

    @Override
    public List<OrderEntity> getAllOrdersOrderByStatus(SortingTypeEnum type) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from OrderEntity order by status " + type);
        return (List<OrderEntity>) query.getResultList();

    }

    @Override
    public Integer getWeekProceed() {
        Date currentDate = new Date();
        Date weekDate = new Date();
        weekDate.setTime(currentDate.getTime() - 7 * 24 * 60 * 60 * 1000);
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from OrderEntity where order_date between :wd and :cd");
        query.setParameter("wd", weekDate);
        query.setParameter("cd", currentDate);
        List<OrderEntity> resultList = (List<OrderEntity>) query.getResultList();
        Integer result = 0;
        for (OrderEntity order : resultList) {
            result += order.getSumm();
        }

        return result;
    }

    @Override
    public Integer getMonthProceed() {
        Date currentDate = new Date();
        Date monthDate = new Date();
        Long milsInMonth = 1L;
        milsInMonth = milsInMonth * 31 * 24 * 60 * 60 * 1000;
        monthDate.setTime(currentDate.getTime() - milsInMonth);
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from OrderEntity where order_date between :wd and :cd");
        query.setParameter("wd", monthDate);
        query.setParameter("cd", currentDate);
        List<OrderEntity> resultList = (List<OrderEntity>) query.getResultList();
        Integer result = 0;
        for (OrderEntity order : resultList) {
            result += order.getSumm();
        }

        return result;
    }
}

