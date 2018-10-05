package com.synjones.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.synjones.mapper.TbBrandMapper;
import com.synjones.pojo.TbBrand;
import com.synjones.sellergoods.service.BrandService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @Author: eric
 * @Description:
 * @Date: 2018/9/9 08:47
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private TbBrandMapper tbBrandMapper;

    /**
     * 查询全部
     * @return
     */
    @Override
    public List<TbBrand> findAll() {
        return tbBrandMapper.selectByExample(null);
    }

    /**
     * 分页查询品牌
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<TbBrand> page = (Page<TbBrand>)tbBrandMapper.selectByExample(null);
        return new PageResult(page.getTotal(),page.getResult());
    }

    /**
     * 添加品牌
     */
    @Override
    public void add(TbBrand brand) {
        tbBrandMapper.insert(brand);
    }

    /**
     * 查询单个
     * @param id
     * @return
     */
    @Override
    public TbBrand findOne(long id) {
        return tbBrandMapper.selectByPrimaryKey(id);
    }

    /**
     * 更新
     */
    public void update(TbBrand brand){
        tbBrandMapper.updateByPrimaryKey(brand);
    }

    /**
     * 删除
     */
    public void delete(long[] ids){
        for(long id : ids)
            tbBrandMapper.deleteByPrimaryKey(id);
    }

    /**
     * 查询商品map
     */
    public List<Map> selectOptionList(){
        return tbBrandMapper.selectOptionList();
    }
}

