package com.gg.art.mapper;

import com.gg.art.bean.ProductionBean;
import com.gg.art.bean.ProductionQueryParm;
import com.gg.art.model.Production;
import com.github.pagehelper.Page;

import java.util.List;

public interface ProductionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Production record);

    int insertSelective(Production record);

    ProductionBean selectByPrimaryKey(Integer id);

    Page<ProductionBean> selectByParam(ProductionQueryParm record);

    int updateByPrimaryKeySelective(Production record);

    int updateByPrimaryKey(Production record);
}