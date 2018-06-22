package com.gg.art.service.impl;/**
 * Created by chenhu on 2018/6/11.
 */

import com.gg.art.bean.ProductionBean;
import com.gg.art.bean.ProductionQueryParm;
import com.gg.art.mapper.ProductionMapper;
import com.gg.art.model.Production;
import com.gg.art.service.ProductionService;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

/**
 * @Auther: chenhu
 * @Date: 2018/6/11 17:22
 * @Description:
 */
@Service
public class ProductionServiceImpl implements ProductionService {
    @Autowired
    private ProductionMapper productionMapper;
    private static final Logger log = LoggerFactory.getLogger(ProductionServiceImpl.class);

    @Override
    public boolean deleteById(Integer productionId) {
        boolean result = false;
        try {
            result = productionMapper.deleteByPrimaryKey(productionId) == 1 ? true : false;
        }
        catch (Exception e) {
            log.error(e.getMessage());
        }
        return result;
    }


    @Override
    public boolean addProduction(Production record) {
        boolean result = false;
        try {
            this.setDefaultAddTime(record);
            result = productionMapper.insert(record) == 1 ? true : false;
        }
        catch (Exception e) {
            log.error(e.getMessage());
        }
        return result;
    }

    @Override
    public boolean addProductionSelective(Production record) {
        boolean result = false;
        try {
            this.setDefaultAddTime(record);
            result = productionMapper.insertSelective(record) == 1 ? true : false;
        }
        catch (Exception e) {
            log.error(e.getMessage());
        }
        return result;
    }

    @Override
    public ProductionBean selectById(Integer productionId) {
        return productionMapper.selectByPrimaryKey(productionId);
    }

    @Override
    public List<ProductionBean> selectByParam(ProductionQueryParm record) {
        PageHelper.startPage(record.getPageNum(), record.getPageSize());
        return productionMapper.selectByParam(record);
    }

    @Override
    public boolean updateByIdSelective(Production record) {
        boolean result = false;
        try {
            this.cleanAddTime(record);
            result = productionMapper.updateByPrimaryKeySelective(record) == 1 ? true : false;
        }
        catch (Exception e) {
            log.error(e.getMessage());
        }
        return result;
    }

    @Override
    public boolean updateById(Production record) {
        boolean result = false;
        try {
            this.cleanAddTime(record);
            result = productionMapper.updateByPrimaryKey(record) == 1 ? true : false;
        }
        catch (Exception e) {
            log.error(e.getMessage());
        }
        return result;
    }


    private void setDefaultAddTime(Production record) {
        if(record.getAddTime() == null) {
            record.setAddTime(Calendar.getInstance().getTime());
        }
    }

    private void cleanAddTime(Production record) {
        if(record.getAddTime() != null) {
            record.setAddTime(null);
        }
    }

}
