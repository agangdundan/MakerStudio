package cn.it.phw.ms.pojo;

public class Actioncolumn {
    private Integer id;

    private String actionColumnName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActionColumnName() {
        return actionColumnName;
    }

    public void setActionColumnName(String actionColumnName) {
        this.actionColumnName = actionColumnName == null ? null : actionColumnName.trim();
    }
}