package com.eu.authtest.vo;

/**
 * @author yuanjie
 * @date 2019/1/30 17:11
 */
public class BaseResponse {
    public BaseResponse(Object content) {
        this.content = content;
    }

    private Object content;

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
