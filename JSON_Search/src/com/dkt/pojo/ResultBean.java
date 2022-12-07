package com.dkt.pojo;

import java.io.Serializable;

/**
 * @author: dkt
 * @Pcakage: com.dkt.pojo.ResultBean
 * @Date: 2022年11月05日 09:17
 * @Description:
 */
public class ResultBean implements Serializable {
    // 服务器端是否正常
    private Boolean flag;
    // 服务器处理请求之后要响应的数据
    private Object data;
    // 服务器端的异常信息
    private String errorMsg;

    @Override
    public String toString() {
        return "ResultBean{" +
                "flag=" + flag +
                ", data=" + data +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public ResultBean(Boolean flag, Object data, String errorMsg) {
        this.flag = flag;
        this.data = data;
        this.errorMsg = errorMsg;
    }

    public ResultBean(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public ResultBean() {
    }
}
