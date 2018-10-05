package com.synjones.pojogroup;

import com.synjones.pojo.TbGoods;
import com.synjones.pojo.TbGoodsDesc;
import com.synjones.pojo.TbItem;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author：eric
 * @Description：
 * @Date: 2018-10-05 14:19
 **/
@Data
public class Goods implements Serializable {
    private TbGoods tbGoods;            //商品基本信息
    private TbGoodsDesc tbGoodsDesc;    //商品描述
    private List<TbItem> itemList;


}
