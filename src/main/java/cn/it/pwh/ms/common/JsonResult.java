package cn.it.pwh.ms.common;

import java.util.Map;

/**
 * @author phw create on 17-11-9
 */
public class JsonResult {

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
}
