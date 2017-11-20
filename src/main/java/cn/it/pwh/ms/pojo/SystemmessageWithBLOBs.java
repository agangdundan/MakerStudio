package cn.it.pwh.ms.pojo;

public class SystemmessageWithBLOBs extends Systemmessage {
    private String message;

    private String createTime;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }
}