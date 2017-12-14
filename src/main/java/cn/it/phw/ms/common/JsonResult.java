package cn.it.phw.ms.common;

import java.io.Serializable;
import java.util.Map;

/**
 * @author phw create on 17-11-9
 */
public class JsonResult implements Serializable {

    public static final String KEY_MESSAGE = "message";
    public static final String KEY_STATUS = "status";

    /**
     * 状态码
     */
    private Integer status;

    /**
     * 服务器信息
     */
    private String message;

    /**
     * 返回数据
     */
    private Map<String, Object> data;

    /**
     * Layui Json 数据格式
     */
    private Integer count;

    /**
     * Layui Json 数据格式
     */
    private Integer code;

    /**
     * Layui Json 数据格式
     */
    private Integer msg;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getMsg() {
        return msg;
    }

    public void setMsg(Integer msg) {
        this.msg = msg;
    }
}
