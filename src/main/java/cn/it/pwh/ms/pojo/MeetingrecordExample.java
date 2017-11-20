package cn.it.pwh.ms.pojo;

import java.util.ArrayList;
import java.util.List;

public class MeetingrecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MeetingrecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRecorderIdIsNull() {
            addCriterion("recorder_id is null");
            return (Criteria) this;
        }

        public Criteria andRecorderIdIsNotNull() {
            addCriterion("recorder_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecorderIdEqualTo(Integer value) {
            addCriterion("recorder_id =", value, "recorderId");
            return (Criteria) this;
        }

        public Criteria andRecorderIdNotEqualTo(Integer value) {
            addCriterion("recorder_id <>", value, "recorderId");
            return (Criteria) this;
        }

        public Criteria andRecorderIdGreaterThan(Integer value) {
            addCriterion("recorder_id >", value, "recorderId");
            return (Criteria) this;
        }

        public Criteria andRecorderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("recorder_id >=", value, "recorderId");
            return (Criteria) this;
        }

        public Criteria andRecorderIdLessThan(Integer value) {
            addCriterion("recorder_id <", value, "recorderId");
            return (Criteria) this;
        }

        public Criteria andRecorderIdLessThanOrEqualTo(Integer value) {
            addCriterion("recorder_id <=", value, "recorderId");
            return (Criteria) this;
        }

        public Criteria andRecorderIdIn(List<Integer> values) {
            addCriterion("recorder_id in", values, "recorderId");
            return (Criteria) this;
        }

        public Criteria andRecorderIdNotIn(List<Integer> values) {
            addCriterion("recorder_id not in", values, "recorderId");
            return (Criteria) this;
        }

        public Criteria andRecorderIdBetween(Integer value1, Integer value2) {
            addCriterion("recorder_id between", value1, value2, "recorderId");
            return (Criteria) this;
        }

        public Criteria andRecorderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("recorder_id not between", value1, value2, "recorderId");
            return (Criteria) this;
        }

        public Criteria andRecorderUsernameIsNull() {
            addCriterion("recorder_username is null");
            return (Criteria) this;
        }

        public Criteria andRecorderUsernameIsNotNull() {
            addCriterion("recorder_username is not null");
            return (Criteria) this;
        }

        public Criteria andRecorderUsernameEqualTo(String value) {
            addCriterion("recorder_username =", value, "recorderUsername");
            return (Criteria) this;
        }

        public Criteria andRecorderUsernameNotEqualTo(String value) {
            addCriterion("recorder_username <>", value, "recorderUsername");
            return (Criteria) this;
        }

        public Criteria andRecorderUsernameGreaterThan(String value) {
            addCriterion("recorder_username >", value, "recorderUsername");
            return (Criteria) this;
        }

        public Criteria andRecorderUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("recorder_username >=", value, "recorderUsername");
            return (Criteria) this;
        }

        public Criteria andRecorderUsernameLessThan(String value) {
            addCriterion("recorder_username <", value, "recorderUsername");
            return (Criteria) this;
        }

        public Criteria andRecorderUsernameLessThanOrEqualTo(String value) {
            addCriterion("recorder_username <=", value, "recorderUsername");
            return (Criteria) this;
        }

        public Criteria andRecorderUsernameLike(String value) {
            addCriterion("recorder_username like", value, "recorderUsername");
            return (Criteria) this;
        }

        public Criteria andRecorderUsernameNotLike(String value) {
            addCriterion("recorder_username not like", value, "recorderUsername");
            return (Criteria) this;
        }

        public Criteria andRecorderUsernameIn(List<String> values) {
            addCriterion("recorder_username in", values, "recorderUsername");
            return (Criteria) this;
        }

        public Criteria andRecorderUsernameNotIn(List<String> values) {
            addCriterion("recorder_username not in", values, "recorderUsername");
            return (Criteria) this;
        }

        public Criteria andRecorderUsernameBetween(String value1, String value2) {
            addCriterion("recorder_username between", value1, value2, "recorderUsername");
            return (Criteria) this;
        }

        public Criteria andRecorderUsernameNotBetween(String value1, String value2) {
            addCriterion("recorder_username not between", value1, value2, "recorderUsername");
            return (Criteria) this;
        }

        public Criteria andMeetingTitleIsNull() {
            addCriterion("meeting_title is null");
            return (Criteria) this;
        }

        public Criteria andMeetingTitleIsNotNull() {
            addCriterion("meeting_title is not null");
            return (Criteria) this;
        }

        public Criteria andMeetingTitleEqualTo(String value) {
            addCriterion("meeting_title =", value, "meetingTitle");
            return (Criteria) this;
        }

        public Criteria andMeetingTitleNotEqualTo(String value) {
            addCriterion("meeting_title <>", value, "meetingTitle");
            return (Criteria) this;
        }

        public Criteria andMeetingTitleGreaterThan(String value) {
            addCriterion("meeting_title >", value, "meetingTitle");
            return (Criteria) this;
        }

        public Criteria andMeetingTitleGreaterThanOrEqualTo(String value) {
            addCriterion("meeting_title >=", value, "meetingTitle");
            return (Criteria) this;
        }

        public Criteria andMeetingTitleLessThan(String value) {
            addCriterion("meeting_title <", value, "meetingTitle");
            return (Criteria) this;
        }

        public Criteria andMeetingTitleLessThanOrEqualTo(String value) {
            addCriterion("meeting_title <=", value, "meetingTitle");
            return (Criteria) this;
        }

        public Criteria andMeetingTitleLike(String value) {
            addCriterion("meeting_title like", value, "meetingTitle");
            return (Criteria) this;
        }

        public Criteria andMeetingTitleNotLike(String value) {
            addCriterion("meeting_title not like", value, "meetingTitle");
            return (Criteria) this;
        }

        public Criteria andMeetingTitleIn(List<String> values) {
            addCriterion("meeting_title in", values, "meetingTitle");
            return (Criteria) this;
        }

        public Criteria andMeetingTitleNotIn(List<String> values) {
            addCriterion("meeting_title not in", values, "meetingTitle");
            return (Criteria) this;
        }

        public Criteria andMeetingTitleBetween(String value1, String value2) {
            addCriterion("meeting_title between", value1, value2, "meetingTitle");
            return (Criteria) this;
        }

        public Criteria andMeetingTitleNotBetween(String value1, String value2) {
            addCriterion("meeting_title not between", value1, value2, "meetingTitle");
            return (Criteria) this;
        }

        public Criteria andMeetingMemberIsNull() {
            addCriterion("meeting_member is null");
            return (Criteria) this;
        }

        public Criteria andMeetingMemberIsNotNull() {
            addCriterion("meeting_member is not null");
            return (Criteria) this;
        }

        public Criteria andMeetingMemberEqualTo(String value) {
            addCriterion("meeting_member =", value, "meetingMember");
            return (Criteria) this;
        }

        public Criteria andMeetingMemberNotEqualTo(String value) {
            addCriterion("meeting_member <>", value, "meetingMember");
            return (Criteria) this;
        }

        public Criteria andMeetingMemberGreaterThan(String value) {
            addCriterion("meeting_member >", value, "meetingMember");
            return (Criteria) this;
        }

        public Criteria andMeetingMemberGreaterThanOrEqualTo(String value) {
            addCriterion("meeting_member >=", value, "meetingMember");
            return (Criteria) this;
        }

        public Criteria andMeetingMemberLessThan(String value) {
            addCriterion("meeting_member <", value, "meetingMember");
            return (Criteria) this;
        }

        public Criteria andMeetingMemberLessThanOrEqualTo(String value) {
            addCriterion("meeting_member <=", value, "meetingMember");
            return (Criteria) this;
        }

        public Criteria andMeetingMemberLike(String value) {
            addCriterion("meeting_member like", value, "meetingMember");
            return (Criteria) this;
        }

        public Criteria andMeetingMemberNotLike(String value) {
            addCriterion("meeting_member not like", value, "meetingMember");
            return (Criteria) this;
        }

        public Criteria andMeetingMemberIn(List<String> values) {
            addCriterion("meeting_member in", values, "meetingMember");
            return (Criteria) this;
        }

        public Criteria andMeetingMemberNotIn(List<String> values) {
            addCriterion("meeting_member not in", values, "meetingMember");
            return (Criteria) this;
        }

        public Criteria andMeetingMemberBetween(String value1, String value2) {
            addCriterion("meeting_member between", value1, value2, "meetingMember");
            return (Criteria) this;
        }

        public Criteria andMeetingMemberNotBetween(String value1, String value2) {
            addCriterion("meeting_member not between", value1, value2, "meetingMember");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}