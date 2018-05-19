package com.tsystems.javaschool.brajnikov.internetstore.service.implementations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.GoodsDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.OrderDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.CartEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.CartItemEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.OrderEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.OrderService;
import com.tsystems.javaschool.brajnikov.internetstore.util.CartItemTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private GoodsDao goodsDao;

    public void createOrder(OrderEntity orderEntity) {
        orderDao.create(orderEntity);
    }

    public int createOrderByCart(CartEntity cartEntity) {
        List<CartItemEntity> itemsList = cartEntity.getCartItems();
        for (CartItemEntity item : itemsList) {
            item.setCart(null);
            item.setType(CartItemTypeEnum.type_order);
        }
        OrderEntity order = new OrderEntity();
        order.setSum(cartEntity.getSum());
        orderDao.create(order);

        return order.getId();
    }

    public void addGoodsToOrder(GoodsEntity goodsEntity) {

    }

    public List<CartItemEntity> getCarts() {
        return null;
    }
}
