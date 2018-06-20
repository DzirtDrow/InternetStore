package com.tsystems.javaschool.brajnikov.internetstore.service.interfaces;

import com.tsystems.javaschool.brajnikov.internetstore.dto.GoodsDto;
import com.tsystems.javaschool.brajnikov.internetstore.model.CategoryEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;

import java.util.List;

/**
 * The interface Goods service.
 */
public interface GoodsService {
    /**
     * Find all goods list.
     *
     * @return the list of {@link GoodsEntity}
     */
    List<GoodsEntity> findAllGoods();

    /**
     * Add goods.
     *
     * @param goodsEntity the {@link GoodsEntity}
     */
    void addGoods(GoodsEntity goodsEntity);

    /**
     * Find goods by id.
     *
     * @param id the id
     * @return the {@link GoodsEntity}
     */
    GoodsEntity findGoodsById(int id);

    /**
     * Update goods.
     *
     * @param goodsEntity the {@link GoodsEntity}
     */
    void updateGoods(GoodsEntity goodsEntity);

    /**
     * Delete goods by id.
     *
     * @param id the id
     */
    void deleteGoodsById(Integer id);

    /**
     * Is in order boolean.
     *
     * @param goods the goods
     * @return the boolean
     */
    boolean isInOrder(GoodsEntity goods);

    List<GoodsDto> getTopSales(int count);

    CategoryEntity findCategoryByGoods(GoodsEntity goods);

    void alignGoodsParametersToCategory(GoodsEntity goodsById);
}
