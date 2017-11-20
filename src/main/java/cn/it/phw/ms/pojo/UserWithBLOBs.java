package cn.it.phw.ms.pojo;

public class UserWithBLOBs extends User {
    private String createTime;

    private String lastTime;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime == null ? null : lastTime.trim();
    }
}