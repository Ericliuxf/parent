package com.synjones.sellergoods.service;

import com.synjones.pojo.TbBrand;
import entity.PageResult;

import java.util.List;
import java.util.Map;

/**
 * @Author: eric
 * @Description:
 * @Date: 2018/9/7 20:51
 */
public interface BrandService {

    /**
     * 查询全部
     * @return
     */
    public List<TbBrand> findAll();

    /**
     * 分页查询
     */

    public PageResult findPage(int pageNum,int pageSize);

    /**
     * 增加
     */
    public void add(TbBrand brand);

    /**
     * 查询单个
     */
    public TbBrand findOne(long id);

    /**
     * 更新
     */
    public void update(TbBrand brand);

    /**
     * 删除
     */
    public void delete(long[] ids);

    /**
     * 商品map
     */
    public List<Map> selectOptionList();
}
