package top.myideas.utils;

import java.io.Serializable;

public class Result implements Serializable {
    private static final long serialVersionUID = 5559089572741299096L;

    @Override
    public String toString() {
        return "Result [msg=" + msg + ", data=" + data + "]";
    }

    private String msg;
    private Object data;
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
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
