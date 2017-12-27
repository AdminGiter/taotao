package com.taotao.common.bean;

/**
 * com.taotao.common.bean.TaotaoResult
 *
 * @author Gentleman
 * @date 2017/12/26 23:47
 * @description  通用返回类
 */
public class TaotaoResult {

    
    /**
     * @Description: 返回成功的标志位
     */
     public static final String SUSSCESS="success";
    /**
     * @Description: 返回失败的标志位
     */
    public static final String ERROR="error";
    /**
     * @Description: 返回的标志位
     */
    private String status;
    /**
     * @Description: 返回的描述
     */
    private String msg;
    /**
     * @Description: 返回的数据
     */
    private Object data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
