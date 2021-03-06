package com.tsystems.javaschool.brajnikov.internetstore.service.implementations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.CartDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.CartItemDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.UserDao;
import com.tsystems.javaschool.brajnikov.internetstore.enums.CartItemTypeEnum;
import com.tsystems.javaschool.brajnikov.internetstore.model.CartEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.CartItemEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("cartService")
@Transactional
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;
    @Autowired
    private CartItemDao cartItemDao;
    @Autowired
    private UserDao userDao;

    public boolean addGoodsToCart(int userId, GoodsEntity goodsEntity) {

        if (goodsEntity.getLeftCount() < 1) {
            return false;
        }

        UserEntity user = userDao.findById(userId);
        CartEntity cartEntity = cartDao.findCartByUser(user);

        if (cartEntity == null) { //check existing user's cart (one cart for one user)
            cartEntity = new CartEntity();
            cartEntity.setUser(user);
            cartDao.create(cartEntity); //creating cart if not exist
        }

        CartItemEntity item = cartDao.getCartItemFromCartByGoods(cartEntity, goodsEntity);
        if (item == null) {
            item = new CartItemEntity();
            item.setGoods(goodsEntity);
            item.setCart(cartEntity);
            item.setType(CartItemTypeEnum.type_cart);
            item.setCount(1);

            cartItemDao.create(item);

            cartEntity.addCartItem(item); // adding
        } else {
            item.setCount(item.getCount() + 1);
        }

        cartEntity.setSum(getCartTotalPrice(userId)); // set cart total price

        cartDao.update(cartEntity);
        return true;
    }

    public List<CartItemEntity> getCartItems(int userId) {
        UserEntity user = userDao.findById(userId);
        CartEntity cart = user.getCart();
        if (cart == null) {
            cart = new CartEntity();
            cart.setUser(user);
            cartDao.create(cart); //creating cart if not exist
        }

        return cart.getCartItems();
    }

    public int getCartTotalPrice(int userId) {
        CartEntity cartEntity = userDao.findById(userId).getCart();
        int result = 0;
        List<CartItemEntity> items = cartEntity.getCartItems();
        for (CartItemEntity item : items) {
            result += item.getGoods().getPrice() * item.getCount();
        }
        return result;
    }

    public CartEntity getCartByUser(UserEntity user) {
        return cartDao.findCartByUser(user);
    }

    @Override
    public CartItemEntity getCartItemById(Integer id) {
        return cartItemDao.read(id);
    }

    public void deleteCartItem(int itemId) {
        cartItemDao.deleteItemById(itemId);
    }

    public void increaseItemsCount(int itemId) {
        CartItemEntity item = cartItemDao.read(itemId);
        item.setCount(item.getCount() + 1);
        cartItemDao.update(item);
    }

    public void decreaseItemsCount(int itemId) {
        CartItemEntity item = cartItemDao.read(itemId);
        if (item.getCount() > 1) {
            item.setCount(item.getCount() - 1);
            cartItemDao.update(item);
        } else {
            deleteCartItem(itemId);
        }
    }

}
