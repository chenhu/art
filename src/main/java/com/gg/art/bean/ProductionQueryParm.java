package com.gg.art.bean;/**
 * Created by chenhu on 2018/6/13.
 */

/**
 * @Auther: chenhu
 * @Date: 2018/6/13 09:18
 * @Description:
 */
public class ProductionQueryParm extends PageBean {
    private String authorName;
    private String name;
    private int property;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProperty() {
        return property;
    }

    public void setProperty(int property) {
        this.property = property;
    }
}
