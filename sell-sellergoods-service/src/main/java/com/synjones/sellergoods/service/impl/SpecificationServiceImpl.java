package com.synjones.sellergoods.service.impl;
import java.util.List;
import java.util.Map;

import com.synjones.mapper.TbSpecificationOptionMapper;
import com.synjones.pojo.TbSpecificationOption;
import com.synjones.pojo.TbSpecificationOptionExample;
import com.synjones.pojogroup.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.synjones.mapper.TbSpecificationMapper;
import com.synjones.pojo.TbSpecification;
import com.synjones.pojo.TbSpecificationExample;
import com.synjones.pojo.TbSpecificationExample.Criteria;
import com.synjones.sellergoods.service.SpecificationService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class SpecificationServiceImpl implements SpecificationService {

	@Autowired
	private TbSpecificationMapper specificationMapper;

	@Autowired
	private TbSpecificationOptionMapper tbSpecificationOptionMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbSpecification> findAll() {
		return specificationMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbSpecification> page = (Page<TbSpecification>) specificationMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Specification specification) {
		//1.保存规格表
		TbSpecification tbspecification = specification.getSpecification();
		specificationMapper.insert(tbspecification);
		//2.保存规格详情表
		List<TbSpecificationOption> specificationOptionList = specification.getSpecificationOptionList();
		for(TbSpecificationOption option: specificationOptionList){
			option.setSpecId(tbspecification.getId());	//mapper里设置 keyProperty返回插入数据的id
			tbSpecificationOptionMapper.insert(option);
		}
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(Specification specification){
		//更新规格
		TbSpecification tbSpecification = specification.getSpecification();
		specificationMapper.updateByPrimaryKey(tbSpecification);

		//规格详情，先删除，后添加
		TbSpecificationOptionExample example = new TbSpecificationOptionExample();
		example.createCriteria().andSpecIdEqualTo(tbSpecification.getId());
		tbSpecificationOptionMapper.deleteByExample(example);

		List<TbSpecificationOption> specificationOptionList = specification.getSpecificationOptionList();
		for (TbSpecificationOption option : specificationOptionList){
			option.setSpecId(tbSpecification.getId());
			tbSpecificationOptionMapper.insert(option);
		}

	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Specification findOne(Long id){
		//获取规格实体
		Specification specification = new Specification();
		TbSpecification tbSpecification = specificationMapper.selectByPrimaryKey(id);
		specification.setSpecification(tbSpecification);

		//获取规格详情
		TbSpecificationOptionExample example = new TbSpecificationOptionExample();
		example.createCriteria().andSpecIdEqualTo(tbSpecification.getId());
		List<TbSpecificationOption> tbSpecificationOptionList = tbSpecificationOptionMapper.selectByExample(example);

		specification.setSpecificationOptionList(tbSpecificationOptionList);
		return  specification;
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			//删除规格
			specificationMapper.deleteByPrimaryKey(id);

			//删除规格详情
			TbSpecificationOptionExample example = new TbSpecificationOptionExample();
			example.createCriteria().andSpecIdEqualTo(id);
			tbSpecificationOptionMapper.deleteByExample(example);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbSpecification specification, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbSpecificationExample example=new TbSpecificationExample();
		Criteria criteria = example.createCriteria();
		
		if(specification!=null){			
						if(specification.getSpecName()!=null && specification.getSpecName().length()>0){
				criteria.andSpecNameLike("%"+specification.getSpecName()+"%");
			}
	
		}
		
		Page<TbSpecification> page= (Page<TbSpecification>)specificationMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public List<Map> selectSpecList() {
		return specificationMapper.selectSpecList();
	}
}
