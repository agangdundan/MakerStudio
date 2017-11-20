package cn.it.pwh.ms.pojo;

public class Meetingrecord {
    private Integer id;

    private Integer recorderId;

    private String recorderUsername;

    private String meetingTitle;

    private String meetingMember;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRecorderId() {
        return recorderId;
    }

    public void setRecorderId(Integer recorderId) {
        this.recorderId = recorderId;
    }

    public String getRecorderUsername() {
        return recorderUsername;
    }

    public void setRecorderUsername(String recorderUsername) {
        this.recorderUsername = recorderUsername == null ? null : recorderUsername.trim();
    }

    public String getMeetingTitle() {
        return meetingTitle;
    }

    public void setMeetingTitle(String meetingTitle) {
        this.meetingTitle = meetingTitle == null ? null : meetingTitle.trim();
    }

    public String getMeetingMember() {
        return meetingMember;
    }

    public void setMeetingMember(String meetingMember) {
        this.meetingMember = meetingMember == null ? null : meetingMember.trim();
    }
}