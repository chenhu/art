package com.gg.art.mapper;

import com.gg.art.bean.ArtistQueryParam;
import com.gg.art.model.Artist;

import java.util.List;

public interface ArtistMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Artist record);

    int insertSelective(Artist record);

    Artist selectByPrimaryKey(Integer id);

    List<Artist> selectByParam(ArtistQueryParam record);

    int updateByPrimaryKeySelective(Artist record);

    int updateByPrimaryKeyWithBLOBs(Artist record);

    int updateByPrimaryKey(Artist record);

    List<Artist> selectDropDownList();
}