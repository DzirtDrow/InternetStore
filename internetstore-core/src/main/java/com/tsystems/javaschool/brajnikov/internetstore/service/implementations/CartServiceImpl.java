package com.tsystems.javaschool.brajnikov.internetstore.service.implementations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.CartDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.CartItemDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.UserDao;
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

    public void addGoodsToCart(int userId, GoodsEntity goodsEntity) {

        UserEntity user = userDao.findById(userId);
        CartEntity cartEntity = cartDao.findCartByUser(user);

        if (cartEntity == null) { //check existing user's cart (one cart for one user)
            cartEntity = new CartEntity();
            cartEntity.setUser(user);
            cartDao.create(cartEntity); //creating cart if not exist
        }

        //
        CartItemEntity item = cartDao.getCartItemFromCartByGoods(cartEntity, goodsEntity);
        if (item == null) {
            item = new CartItemEntity();
            item.setGoods(goodsEntity);
            item.setCart(cartEntity);
            item.setCount(1);
            cartItemDao.create(item);

            cartEntity.addCartItem(item); // adding
        } else {
            item.setCount(item.getCount() + 1);
        }

        cartDao.update(cartEntity);//TODO ????

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

    public void deleteCartItem(int itemId) {
//        UserEntity user = userDao.findById(userId);
//        CartEntity cart = user.getCart();
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
