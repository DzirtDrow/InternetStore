package com.tsystems.javaschool.brajnikov.internetstore.service.implementations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.CartDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.CartItemDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.UserDao;
import com.tsystems.javaschool.brajnikov.internetstore.enums.CartItemTypeEnum;
import com.tsystems.javaschool.brajnikov.internetstore.model.CartEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.CartItemEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class CartServiceImplTest {

    @InjectMocks
    private CartServiceImpl cartService;
    @Mock
    private CartDao cartDao;
    @Mock
    private UserDao userDao;
    @Mock
    private CartItemDao cartItemDao;

    @Test
    public void addGoodsToCart() {
    }

    @Test
    public void getCartItems() {
        initMocks(this);
        UserEntity testUser = new UserEntity();
        when(cartDao.findCartByUser(testUser)).thenReturn(getTestCartEntity(testUser));

        CartEntity testCartEntity = cartService.getCartByUser(testUser);

        assertNotNull(testCartEntity);

        assertEquals(100, testCartEntity.getSum());
        assertEquals(100, testCartEntity.getId());
        assertNotNull(testCartEntity.getCartItems());
        assertNotNull(testCartEntity.getUser());
        assertEquals(testUser, testCartEntity.getUser());
    }

    @Test
    public void getCartTotalPrice() {
        initMocks(this);
        UserEntity testUser = new UserEntity();
        testUser.setId(100);
        CartEntity testCartEntity = getTestCartEntity(testUser);
        testUser.setCart(testCartEntity);

        when(userDao.findById(100)).thenReturn(testUser);

        int testResult = cartService.getCartTotalPrice(100);

        assertNotNull(testResult);
        assertEquals(10, testResult);
    }

    @Test
    public void getCartByUser() {
        initMocks(this);

        UserEntity testUser = new UserEntity();
        when(cartDao.findCartByUser(testUser)).thenReturn(getTestCartEntity(testUser));

        CartEntity testCart = cartService.getCartByUser(testUser);

        assertNotNull(testCart);
        assertEquals(testUser, testCart.getUser());
        assertEquals(100, testCart.getId());
        assertEquals(100, testCart.getSum());
        assertNotNull(testCart.getCartItems());
    }

    @Test
    public void getCartItemById() {
        initMocks(this);

        when(cartItemDao.read(100)).thenReturn(getTestCartItemEntity());

        CartItemEntity testCartItem = cartService.getCartItemById(100);

        assertNotNull(testCartItem);
        assertEquals(100, testCartItem.getCount());
        assertEquals(CartItemTypeEnum.type_cart, testCartItem.getType());
        assertNotNull(testCartItem.getGoods());
        assertNotNull(testCartItem.getCart());
        assertNull(testCartItem.getOrder());

    }

    @Test
    public void deleteCartItem() {
        initMocks(this);

        cartService.deleteCartItem(100);
        verify(cartItemDao).deleteItemById(100);
    }

    @Test
    public void increaseItemsCount() {
        initMocks(this);
        CartItemEntity cartItem = new CartItemEntity();
        cartItem.setId(100);
        cartItem.setCount(10);

        when(cartItemDao.read(cartItem.getId())).thenReturn(cartItem);

        cartService.increaseItemsCount(cartItem.getId());
        cartItem.setCount(11);

        verify(cartItemDao).read(cartItem.getId());
        verify(cartItemDao).update(cartItem);
    }

    @Test
    public void decreaseItemsCount() {
        initMocks(this);
        CartItemEntity cartItem = new CartItemEntity();
        cartItem.setId(100);
        cartItem.setCount(10);

        when(cartItemDao.read(cartItem.getId())).thenReturn(cartItem);

        cartService.decreaseItemsCount(cartItem.getId());
        cartItem.setCount(9);

        verify(cartItemDao).read(cartItem.getId());
        verify(cartItemDao).update(cartItem);
    }

    public CartEntity getTestCartEntity(UserEntity testUser) {
        CartEntity testCartEntity = new CartEntity();
        testCartEntity.setSum(100);
        testCartEntity.setId(100);
        List<CartItemEntity> cartItemsList = new ArrayList<>();

        CartItemEntity testCartItem = new CartItemEntity();
        testCartItem.setCount(1);
        GoodsEntity testGoods = new GoodsEntity();
        testGoods.setPrice(10);
        testCartItem.setGoods(testGoods);
        cartItemsList.add(testCartItem);

        testCartEntity.setCartItems(cartItemsList);
        testCartEntity.setUser(testUser);

        return testCartEntity;
    }

    public CartItemEntity getTestCartItemEntity() {
        CartItemEntity testCartItemEntity = new CartItemEntity();
        testCartItemEntity.setGoods(new GoodsEntity());
        testCartItemEntity.setCount(100);
        testCartItemEntity.setType(CartItemTypeEnum.type_cart);
        testCartItemEntity.setOrder(null);
        testCartItemEntity.setCart(new CartEntity());
        return testCartItemEntity;
    }
}