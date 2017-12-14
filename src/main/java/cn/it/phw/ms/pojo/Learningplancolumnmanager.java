package cn.it.phw.ms.pojo;

import cn.it.phw.ms.common.BaseEntity;

public class Learningplancolumnmanager extends BaseEntity {
    private Integer id;

    private Integer learningplanformId;

    private String learningplancolumnName;

    private Integer learningplancolumnId;

    private String learningplancolumnContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLearningplanformId() {
        return learningplanformId;
    }

    public void setLearningplanformId(Integer learningplanformId) {
        this.learningplanformId = learningplanformId;
    }

    public String getLearningplancolumnName() {
        return learningplancolumnName;
    }

    public void setLearningplancolumnName(String learningplancolumnName) {
        this.learningplancolumnName = learningplancolumnName == null ? null : learningplancolumnName.trim();
    }

    public Integer getLearningplancolumnId() {
        return learningplancolumnId;
    }

    public void setLearningplancolumnId(Integer learningplancolumnId) {
        this.learningplancolumnId = learningplancolumnId;
    }

    public String getLearningplancolumnContent() {
        return learningplancolumnContent;
    }

    public void setLearningplancolumnContent(String learningplancolumnContent) {
        this.learningplancolumnContent = learningplancolumnContent == null ? null : learningplancolumnContent.trim();
    }
}