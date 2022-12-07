package com.dkt.pojo;

import java.io.Serializable;

/**
 * @author: dkt
 * @Pcakage: com.dkt.pojo.ResultBean
 * @Date: 2022年11月05日 14:29
 * @Description:
 */
public class ResultBean implements Serializable {
    // 服务器的状态
    private Boolean flag;
    // 服务器处理请求之后要响应的数据
    private Object Date;
    // 服务器错误信息
    private String errorMsg;

    public ResultBean(Boolean flag) {
        this.flag = flag;
    }

    public ResultBean() {
    }

    public ResultBean(Boolean flag, Object date, String errorMsg) {
        this.flag = flag;
        Date = date;
        this.errorMsg = errorMsg;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Object getDate() {
        return Date;
    }

    public void setDate(Object date) {
        Date = date;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
