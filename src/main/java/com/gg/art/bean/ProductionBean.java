package com.gg.art.bean;/**
 * Created by chenhu on 2018/6/12.
 */

import com.gg.art.model.Artist;
import com.gg.art.model.Production;

/**
 * @Auther: chenhu
 * @Date: 2018/6/12 15:48
 * @Description:
 */
public class ProductionBean {
    private Production production;
    private Artist artist;

    public Production getProduction() {
        return production;
    }

    public void setProduction(Production production) {
        this.production = production;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
