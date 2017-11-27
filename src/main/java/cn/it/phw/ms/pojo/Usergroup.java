package cn.it.phw.ms.pojo;

import java.util.Date;

public class Usergroup {
    private Integer id;

    private String groupName;

    private String groupInfo;

    private Date createTime;

    private Integer createrId;

    private String createrName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getGroupInfo() {
        return groupInfo;
    }

    public void setGroupInfo(String groupInfo) {
        this.groupInfo = groupInfo == null ? null : groupInfo.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreaterId() {
        return createrId;
    }

    public void setCreaterId(Integer createrId) {
        this.createrId = createrId;
    }

    public String getCreaterName() {
        return createrName;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName == null ? null : createrName.trim();
    }
}