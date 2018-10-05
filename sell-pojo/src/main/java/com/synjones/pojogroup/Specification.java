package com.synjones.pojogroup;

import com.synjones.pojo.TbSpecification;
import com.synjones.pojo.TbSpecificationOption;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: eric
 * @Description:
 * @Date: 2018/9/18 17:23
 */
@Data
public class Specification implements Serializable {

    private TbSpecification specification;
    private List<TbSpecificationOption> specificationOptionList;
}
