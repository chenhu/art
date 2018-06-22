package com.gg.art.service;

import com.gg.art.bean.ArtistQueryParam;
import com.gg.art.model.Artist;

import java.util.List;

/**
 * Created by chenhu on 2018/6/9.
 */
public interface ArtistService {

    boolean deleteById(Integer userId);

    boolean addArtist(Artist record);

    boolean addArtistSelective(Artist record);

    Artist selectById(Integer userId);

    List<Artist> selectByParam(ArtistQueryParam record);

    boolean updateByIdSelective(Artist record);

    boolean updateByIdWithBLOBs(Artist record);

    boolean updateById(Artist record);

    List<Artist> selectDropDownList();
}
