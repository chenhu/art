package com.gg.art.common;

/**
 * Created by chenhu on 2018/6/9.
 */
public class ResponseMessage<T> {

    private String code;
    private String description;
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
}
