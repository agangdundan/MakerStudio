package cn.it.phw.ms.pojo;

public class Learningplancolumnmanager {
    private Integer id;

    private Integer learningplanformId;

    private String learningplancolumnName;

    private Integer learningplancolumnId;

    private String content;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}