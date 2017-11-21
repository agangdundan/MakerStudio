package cn.it.phw.ms.pojo;

public class MeetingrecordWithBLOBs extends Meetingrecord {
    private String meetingContent;

    private String createTime;

    public String getMeetingContent() {
        return meetingContent;
    }

    public void setMeetingContent(String meetingContent) {
        this.meetingContent = meetingContent == null ? null : meetingContent.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }
}