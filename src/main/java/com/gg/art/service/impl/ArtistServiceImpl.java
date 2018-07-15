package com.gg.art.service.impl;

import com.gg.art.bean.ArtistQueryParam;
import com.gg.art.mapper.ArtistMapper;
import com.gg.art.model.Artist;
import com.gg.art.service.ArtistService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chenhu on 2018/6/9.
 */
@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private ArtistMapper artistMapper;
    private static Logger log = LoggerFactory.getLogger(ArtistServiceImpl.class);

    @Override
    public boolean deleteById(Integer userId) {
        boolean result = false;
        try {
            result = artistMapper.deleteByPrimaryKey(userId) == 1 ? true : false;
        }
        catch (Exception e) {
            log.error(e.getMessage());
        }
        return result;
    }

    @Override
    public boolean addArtist(Artist record) {
        boolean result = false;
        try {
            result = artistMapper.insert(record) == 1 ? true : false;
        }
        catch (Exception e) {
            log.error(e.getMessage());
        }
        return result;
    }

    @Override
    public boolean addArtistSelective(Artist record) {
        boolean result = false;
        try {
            result = artistMapper.insertSelective(record) == 1 ? true : false;
        }
        catch (Exception e) {
            log.error(e.getMessage());
        }
        return result;
    }

    @Override
    public Artist selectById(Integer userId) {
        return artistMapper.selectByPrimaryKey(userId);
    }

    @Override
    public Page<Artist> selectByParam(ArtistQueryParam record) {
        return PageHelper.startPage(record.getPageNum(), record.getPageSize()).doSelectPage(()-> artistMapper.selectByParam(record));
    }

    /**
     * @Description: 根据对象中字段内容更新
     * @Param: [record]
     * @Return: boolean
     **/
    @Override
    public boolean updateByIdSelective(Artist record) {
        boolean result = false;
        try {
            result = artistMapper.updateByPrimaryKeySelective(record) == 1 ? true : false;
        }
        catch (Exception e) {
            log.error(e.getMessage());
        }
        return result;
    }

    /**
     * @Description: 用户id和描述信息必须输入，用户id必须提供
     * @Param: [record]
     * @Return: boolean
     **/
    @Override
    public boolean updateByIdWithBLOBs(Artist record) {
        boolean result = false;
        try {
            result = artistMapper.updateByPrimaryKeyWithBLOBs(record) == 1 ? true : false;
        }
        catch (Exception e) {
            log.error(e.getMessage());
        }
        return result;
    }

    /**
     * @Description: 只更新除了描述意外的字段，用户id必须提供
     * @Param: [record]
     * @Return: boolean
     **/
    @Override
    public boolean updateById(Artist record) {
        boolean result = false;
        try {
            result = artistMapper.updateByPrimaryKey(record) == 1 ? true : false;
        }
        catch (Exception e) {
            log.error(e.getMessage());
        }
        return result;
    }

    /**
    * @Description: 下拉选择作家列表
    * @Param: []
    * @Return: java.util.List<com.gg.art.model.Artist>
    **/
    @Override
    public List<Artist> selectDropDownList() {
        return artistMapper.selectDropDownList();
    }
}
