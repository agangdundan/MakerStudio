package cn.it.pwh.ms.pojo;

public class Action {
    private Integer id;

    private Integer actionColumnId;

    private String action;

    private Integer visiable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActionColumnId() {
        return actionColumnId;
    }

    public void setActionColumnId(Integer actionColumnId) {
        this.actionColumnId = actionColumnId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
    }

    public Integer getVisiable() {
        return visiable;
    }

    public void setVisiable(Integer visiable) {
        this.visiable = visiable;
    }
}