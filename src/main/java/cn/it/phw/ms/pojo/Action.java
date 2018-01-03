package cn.it.phw.ms.pojo;

public class Action {
    private Integer id;

    private Integer actionColumnId;

    private String action;

    private String type;

    private Integer visiable;

    private String description;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getVisiable() {
        return visiable;
    }

    public void setVisiable(Integer visiable) {
        this.visiable = visiable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}