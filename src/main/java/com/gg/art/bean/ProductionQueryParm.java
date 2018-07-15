package com.gg.art.bean;/**
 * Created by chenhu on 2018/6/13.
 */

/**
 * @Auther: chenhu
 * @Date: 2018/6/13 09:18
 * @Description:
 */
public class ProductionQueryParm extends PageBean {
    /**
    * description: 这个属性可以是 作家姓名、作品名称、属性 中的任何一个
    * param:
    * return:
    **/
    private String union;

    public String getUnion() {
        return union;
    }

    public void setUnion(String union) {
        this.union = union;
    }
}
