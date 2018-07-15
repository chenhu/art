package com.gg.art.common;

import com.gg.art.bean.PageBean;

import java.io.Serializable;

/**
 * Created by chenhu on 2018/6/9.
 */
public class ResponseMessage<T>  implements Serializable{

    private String code;
    private String description;
    private PageBean pageInfo;
    private T messageBody;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public T getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(T messageBody) {
        this.messageBody = messageBody;
    }

    public PageBean getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageBean pageInfo) {
        this.pageInfo = pageInfo;
    }
}
