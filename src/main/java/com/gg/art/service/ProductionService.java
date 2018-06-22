package com.gg.art.service;/**
 * Created by chenhu on 2018/6/11.
 */

import com.gg.art.bean.ProductionBean;
import com.gg.art.bean.ProductionQueryParm;
import com.gg.art.model.Production;

import java.util.List;

/**
 * @Auther: chenhu
 * @Date: 2018/6/11 17:22
 * @Description: 产品信息服务接口
 */
public interface ProductionService {
    boolean deleteById(Integer userId);

    boolean addProduction(Production record);

    boolean addProductionSelective(Production record);

    ProductionBean selectById(Integer userId);

    List<ProductionBean> selectByParam(ProductionQueryParm record);

    boolean updateByIdSelective(Production record);

    boolean updateById(Production record);
}
