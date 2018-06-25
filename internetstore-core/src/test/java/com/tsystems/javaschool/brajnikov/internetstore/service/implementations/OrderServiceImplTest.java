package com.tsystems.javaschool.brajnikov.internetstore.service.implementations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.CartItemDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.GoodsDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.OrdersDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.UserDao;
import com.tsystems.javaschool.brajnikov.internetstore.enums.OrderDeliveryTypeEnum;
import com.tsystems.javaschool.brajnikov.internetstore.enums.OrderPaymentMethodEnum;
import com.tsystems.javaschool.brajnikov.internetstore.enums.OrderStatusEnum;
import com.tsystems.javaschool.brajnikov.internetstore.model.OrderEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class OrderServiceImplTest {

    @Mock
    private OrdersDao orderDao;
    @Mock
    private GoodsDao goodsDao;
    @Mock
    private UserDao userDao;
    @Mock
    private CartItemDao cartItemDao;

    @InjectMocks
    private OrderServiceImpl orderService;

    @Test
    public void createOrder() {
        initMocks(this);
        OrderEntity order = new OrderEntity();

        orderService.createOrder(order);
        verify(orderDao).create(order);
    }

    @Test
    public void createOrderByCart() {

    }

    @Test
    public void getOrderById() {
        initMocks(this);

        when(orderDao.read(100)).thenReturn(getTestOrder(100));

        OrderEntity order = orderService.getOrderById(100);

        assertNotNull(order);
        assertEquals(100,order.getId());
    }


    @Test
    public void getAllOrders() {
        initMocks(this);

        when(orderDao.getOrdersList()).thenReturn(getTestOrderList());

        List<OrderEntity> orderList = orderService.getAllOrders();

        assertNotNull(orderList);
        assertEquals(2,orderList.size());
        assertEquals(100, orderList.get(0).getId());
    }

    @Test
    public void getOrdersListByUser() {
        initMocks(this);
        UserEntity testUser = getTestUser("name");
//        try {
//            when(orderDao.getOrdersByUser(testUser)).thenReturn(getTestOrderListByUser(testUser));
//        } catch (OrdersNotFoundException e) {
//            Assert.assertNotEquals("", thrown.getMessage());
//        }
    }

    @Test
    public void updateOrder() {
        initMocks(this);
        OrderEntity order = new OrderEntity();

        orderService.updateOrder(order);
        verify(orderDao).update(order);
    }

    @Test
    public void pushOrderStatus() {
        initMocks(this);
        OrderEntity order = new OrderEntity();
        order.setStatus(OrderStatusEnum.PENDING_PAYMENT);

        orderService.pushOrderStatus(order);

        verify(orderDao).update(order);
    }

    @Test
    public void getAllOrdersOrderByDate() {
    }

    @Test
    public void getAllOrdersOrderByStatus() {
    }

    @Test
    public void createOrderFromSessionCart() {
    }

    @Test
    public void getWeekProceed() {
        initMocks(this);
        when(orderDao.getWeekProceed()).thenReturn(100);

        assertEquals((Integer)100, orderService.getWeekProceed());
    }

    @Test
    public void getMonthProceed() {
        initMocks(this);
        when(orderDao.getMonthProceed()).thenReturn(1000);

        assertEquals((Integer)1000, orderService.getMonthProceed());
    }


    private OrderEntity getTestOrder(int i) {
        OrderEntity testOrder = new OrderEntity();
        testOrder.setSumm(100);
        testOrder.setPaymentMethod(OrderPaymentMethodEnum.CASH);
        testOrder.setDeliveryType(OrderDeliveryTypeEnum.PICKUP);
        testOrder.setStatus(OrderStatusEnum.PENDING_PAYMENT);
        testOrder.setId(100);

        testOrder.setUser(getTestUser("name"));
        return testOrder;
    }

    public List<OrderEntity> getTestOrderList() {
        List<OrderEntity> testOrderList = new ArrayList<>();
        testOrderList.add(getTestOrder(100));
        testOrderList.add(getTestOrder(200));
        return testOrderList;
    }

    private UserEntity getTestUser(String name) {
        UserEntity testUser = new UserEntity();
        testUser.setId(100);
        testUser.setName(name);
        return testUser;
    }
}