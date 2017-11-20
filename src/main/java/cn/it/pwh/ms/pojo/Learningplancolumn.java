package cn.it.pwh.ms.pojo;

public class Learningplancolumn {
    private Integer id;

    private String learningplancolumnName;

    private String learningplancolumnDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLearningplancolumnName() {
        return learningplancolumnName;
    }

    public void setLearningplancolumnName(String learningplancolumnName) {
        this.learningplancolumnName = learningplancolumnName == null ? null : learningplancolumnName.trim();
    }

    public String getLearningplancolumnDesc() {
        return learningplancolumnDesc;
    }

    public void setLearningplancolumnDesc(String learningplancolumnDesc) {
        this.learningplancolumnDesc = learningplancolumnDesc == null ? null : learningplancolumnDesc.trim();
    }
}