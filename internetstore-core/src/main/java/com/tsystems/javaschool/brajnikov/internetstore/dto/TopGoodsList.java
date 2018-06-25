package com.tsystems.javaschool.brajnikov.internetstore.dto;

import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component("topGoodsList")
@Scope(value = WebApplicationContext.SCOPE_APPLICATION)
public class TopGoodsList {
    @Autowired
    private GoodsService goodsService;

    List<GoodsDto> topGoods = new ArrayList<>();

    public boolean updateTopGoods() {
        List<GoodsDto> newList = goodsService.getTopSales(9);
        if (newList.size() != topGoods.size()) {
            topGoods = newList;
            return true;
        }
        int[] topGoodsIndexes = new int[topGoods.size()];
        for(int i = 0; i<topGoods.size(); i++){
            topGoodsIndexes[i] = topGoods.get(i).getId();
        }
        int[] newListIndexes = new int[newList.size()];
        for(int i = 0; i<newList.size(); i++){
            newListIndexes[i] = newList.get(i).getId();
        }

        Arrays.sort(topGoodsIndexes);
        Arrays.sort(newListIndexes);

        return !Arrays.equals(topGoodsIndexes,newListIndexes);
    }

}
