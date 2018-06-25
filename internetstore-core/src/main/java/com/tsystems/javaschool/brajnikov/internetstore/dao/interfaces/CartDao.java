package com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces;

import com.tsystems.javaschool.brajnikov.internetstore.dao.GenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.*;

/**
 * The interface Cart dao.
 */
public interface CartDao extends GenericDao<CartEntity, Integer> {

    /**
     * Find cart by user.
     *
     * @param userEntity {@link UserEntity} the user entity
     * @return {@link CartEntity}
     */
    CartEntity findCartByUser(UserEntity userEntity);

    /**
     * Gets cart item from cart by goods.
     *
     * @param cartEntity  {@link CartEntity} the cart entity
     * @param goodsEntity {@link GoodsEntity}the goods entity
     * @return {@link CartItemEntity} from cart by goods
     */
    CartItemEntity getCartItemFromCartByGoods(CartEntity cartEntity, GoodsEntity goodsEntity);

}
