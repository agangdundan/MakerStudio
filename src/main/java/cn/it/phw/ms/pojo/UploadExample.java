package cn.it.phw.ms.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UploadExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UploadExample() {
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

        public Criteria andFilenameIsNull() {
            addCriterion("filename is null");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNotNull() {
            addCriterion("filename is not null");
            return (Criteria) this;
        }

        public Criteria andFilenameEqualTo(String value) {
            addCriterion("filename =", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotEqualTo(String value) {
            addCriterion("filename <>", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThan(String value) {
            addCriterion("filename >", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThanOrEqualTo(String value) {
            addCriterion("filename >=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThan(String value) {
            addCriterion("filename <", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThanOrEqualTo(String value) {
            addCriterion("filename <=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLike(String value) {
            addCriterion("filename like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotLike(String value) {
            addCriterion("filename not like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameIn(List<String> values) {
            addCriterion("filename in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotIn(List<String> values) {
            addCriterion("filename not in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameBetween(String value1, String value2) {
            addCriterion("filename between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotBetween(String value1, String value2) {
            addCriterion("filename not between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andImageIsNull() {
            addCriterion("image is null");
            return (Criteria) this;
        }

        public Criteria andImageIsNotNull() {
            addCriterion("image is not null");
            return (Criteria) this;
        }

        public Criteria andImageEqualTo(String value) {
            addCriterion("image =", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotEqualTo(String value) {
            addCriterion("image <>", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThan(String value) {
            addCriterion("image >", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThanOrEqualTo(String value) {
            addCriterion("image >=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThan(String value) {
            addCriterion("image <", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThanOrEqualTo(String value) {
            addCriterion("image <=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLike(String value) {
            addCriterion("image like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotLike(String value) {
            addCriterion("image not like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageIn(List<String> values) {
            addCriterion("image in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotIn(List<String> values) {
            addCriterion("image not in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageBetween(String value1, String value2) {
            addCriterion("image between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotBetween(String value1, String value2) {
            addCriterion("image not between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andContenttypeIsNull() {
            addCriterion("contenttype is null");
            return (Criteria) this;
        }

        public Criteria andContenttypeIsNotNull() {
            addCriterion("contenttype is not null");
            return (Criteria) this;
        }

        public Criteria andContenttypeEqualTo(String value) {
            addCriterion("contenttype =", value, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeNotEqualTo(String value) {
            addCriterion("contenttype <>", value, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeGreaterThan(String value) {
            addCriterion("contenttype >", value, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeGreaterThanOrEqualTo(String value) {
            addCriterion("contenttype >=", value, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeLessThan(String value) {
            addCriterion("contenttype <", value, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeLessThanOrEqualTo(String value) {
            addCriterion("contenttype <=", value, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeLike(String value) {
            addCriterion("contenttype like", value, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeNotLike(String value) {
            addCriterion("contenttype not like", value, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeIn(List<String> values) {
            addCriterion("contenttype in", values, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeNotIn(List<String> values) {
            addCriterion("contenttype not in", values, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeBetween(String value1, String value2) {
            addCriterion("contenttype between", value1, value2, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeNotBetween(String value1, String value2) {
            addCriterion("contenttype not between", value1, value2, "contenttype");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andLocalpathIsNull() {
            addCriterion("localpath is null");
            return (Criteria) this;
        }

        public Criteria andLocalpathIsNotNull() {
            addCriterion("localpath is not null");
            return (Criteria) this;
        }

        public Criteria andLocalpathEqualTo(String value) {
            addCriterion("localpath =", value, "localpath");
            return (Criteria) this;
        }

        public Criteria andLocalpathNotEqualTo(String value) {
            addCriterion("localpath <>", value, "localpath");
            return (Criteria) this;
        }

        public Criteria andLocalpathGreaterThan(String value) {
            addCriterion("localpath >", value, "localpath");
            return (Criteria) this;
        }

        public Criteria andLocalpathGreaterThanOrEqualTo(String value) {
            addCriterion("localpath >=", value, "localpath");
            return (Criteria) this;
        }

        public Criteria andLocalpathLessThan(String value) {
            addCriterion("localpath <", value, "localpath");
            return (Criteria) this;
        }

        public Criteria andLocalpathLessThanOrEqualTo(String value) {
            addCriterion("localpath <=", value, "localpath");
            return (Criteria) this;
        }

        public Criteria andLocalpathLike(String value) {
            addCriterion("localpath like", value, "localpath");
            return (Criteria) this;
        }

        public Criteria andLocalpathNotLike(String value) {
            addCriterion("localpath not like", value, "localpath");
            return (Criteria) this;
        }

        public Criteria andLocalpathIn(List<String> values) {
            addCriterion("localpath in", values, "localpath");
            return (Criteria) this;
        }

        public Criteria andLocalpathNotIn(List<String> values) {
            addCriterion("localpath not in", values, "localpath");
            return (Criteria) this;
        }

        public Criteria andLocalpathBetween(String value1, String value2) {
            addCriterion("localpath between", value1, value2, "localpath");
            return (Criteria) this;
        }

        public Criteria andLocalpathNotBetween(String value1, String value2) {
            addCriterion("localpath not between", value1, value2, "localpath");
            return (Criteria) this;
        }

        public Criteria andDownloadtimeIsNull() {
            addCriterion("downloadtime is null");
            return (Criteria) this;
        }

        public Criteria andDownloadtimeIsNotNull() {
            addCriterion("downloadtime is not null");
            return (Criteria) this;
        }

        public Criteria andDownloadtimeEqualTo(Integer value) {
            addCriterion("downloadtime =", value, "downloadtime");
            return (Criteria) this;
        }

        public Criteria andDownloadtimeNotEqualTo(Integer value) {
            addCriterion("downloadtime <>", value, "downloadtime");
            return (Criteria) this;
        }

        public Criteria andDownloadtimeGreaterThan(Integer value) {
            addCriterion("downloadtime >", value, "downloadtime");
            return (Criteria) this;
        }

        public Criteria andDownloadtimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("downloadtime >=", value, "downloadtime");
            return (Criteria) this;
        }

        public Criteria andDownloadtimeLessThan(Integer value) {
            addCriterion("downloadtime <", value, "downloadtime");
            return (Criteria) this;
        }

        public Criteria andDownloadtimeLessThanOrEqualTo(Integer value) {
            addCriterion("downloadtime <=", value, "downloadtime");
            return (Criteria) this;
        }

        public Criteria andDownloadtimeIn(List<Integer> values) {
            addCriterion("downloadtime in", values, "downloadtime");
            return (Criteria) this;
        }

        public Criteria andDownloadtimeNotIn(List<Integer> values) {
            addCriterion("downloadtime not in", values, "downloadtime");
            return (Criteria) this;
        }

        public Criteria andDownloadtimeBetween(Integer value1, Integer value2) {
            addCriterion("downloadtime between", value1, value2, "downloadtime");
            return (Criteria) this;
        }

        public Criteria andDownloadtimeNotBetween(Integer value1, Integer value2) {
            addCriterion("downloadtime not between", value1, value2, "downloadtime");
            return (Criteria) this;
        }

        public Criteria andUploadUserIdIsNull() {
            addCriterion("upload_user_id is null");
            return (Criteria) this;
        }

        public Criteria andUploadUserIdIsNotNull() {
            addCriterion("upload_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUploadUserIdEqualTo(Integer value) {
            addCriterion("upload_user_id =", value, "uploadUserId");
            return (Criteria) this;
        }

        public Criteria andUploadUserIdNotEqualTo(Integer value) {
            addCriterion("upload_user_id <>", value, "uploadUserId");
            return (Criteria) this;
        }

        public Criteria andUploadUserIdGreaterThan(Integer value) {
            addCriterion("upload_user_id >", value, "uploadUserId");
            return (Criteria) this;
        }

        public Criteria andUploadUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("upload_user_id >=", value, "uploadUserId");
            return (Criteria) this;
        }

        public Criteria andUploadUserIdLessThan(Integer value) {
            addCriterion("upload_user_id <", value, "uploadUserId");
            return (Criteria) this;
        }

        public Criteria andUploadUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("upload_user_id <=", value, "uploadUserId");
            return (Criteria) this;
        }

        public Criteria andUploadUserIdIn(List<Integer> values) {
            addCriterion("upload_user_id in", values, "uploadUserId");
            return (Criteria) this;
        }

        public Criteria andUploadUserIdNotIn(List<Integer> values) {
            addCriterion("upload_user_id not in", values, "uploadUserId");
            return (Criteria) this;
        }

        public Criteria andUploadUserIdBetween(Integer value1, Integer value2) {
            addCriterion("upload_user_id between", value1, value2, "uploadUserId");
            return (Criteria) this;
        }

        public Criteria andUploadUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("upload_user_id not between", value1, value2, "uploadUserId");
            return (Criteria) this;
        }

        public Criteria andUploadUsernameIsNull() {
            addCriterion("upload_username is null");
            return (Criteria) this;
        }

        public Criteria andUploadUsernameIsNotNull() {
            addCriterion("upload_username is not null");
            return (Criteria) this;
        }

        public Criteria andUploadUsernameEqualTo(String value) {
            addCriterion("upload_username =", value, "uploadUsername");
            return (Criteria) this;
        }

        public Criteria andUploadUsernameNotEqualTo(String value) {
            addCriterion("upload_username <>", value, "uploadUsername");
            return (Criteria) this;
        }

        public Criteria andUploadUsernameGreaterThan(String value) {
            addCriterion("upload_username >", value, "uploadUsername");
            return (Criteria) this;
        }

        public Criteria andUploadUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("upload_username >=", value, "uploadUsername");
            return (Criteria) this;
        }

        public Criteria andUploadUsernameLessThan(String value) {
            addCriterion("upload_username <", value, "uploadUsername");
            return (Criteria) this;
        }

        public Criteria andUploadUsernameLessThanOrEqualTo(String value) {
            addCriterion("upload_username <=", value, "uploadUsername");
            return (Criteria) this;
        }

        public Criteria andUploadUsernameLike(String value) {
            addCriterion("upload_username like", value, "uploadUsername");
            return (Criteria) this;
        }

        public Criteria andUploadUsernameNotLike(String value) {
            addCriterion("upload_username not like", value, "uploadUsername");
            return (Criteria) this;
        }

        public Criteria andUploadUsernameIn(List<String> values) {
            addCriterion("upload_username in", values, "uploadUsername");
            return (Criteria) this;
        }

        public Criteria andUploadUsernameNotIn(List<String> values) {
            addCriterion("upload_username not in", values, "uploadUsername");
            return (Criteria) this;
        }

        public Criteria andUploadUsernameBetween(String value1, String value2) {
            addCriterion("upload_username between", value1, value2, "uploadUsername");
            return (Criteria) this;
        }

        public Criteria andUploadUsernameNotBetween(String value1, String value2) {
            addCriterion("upload_username not between", value1, value2, "uploadUsername");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andVisiableIsNull() {
            addCriterion("visiable is null");
            return (Criteria) this;
        }

        public Criteria andVisiableIsNotNull() {
            addCriterion("visiable is not null");
            return (Criteria) this;
        }

        public Criteria andVisiableEqualTo(Integer value) {
            addCriterion("visiable =", value, "visiable");
            return (Criteria) this;
        }

        public Criteria andVisiableNotEqualTo(Integer value) {
            addCriterion("visiable <>", value, "visiable");
            return (Criteria) this;
        }

        public Criteria andVisiableGreaterThan(Integer value) {
            addCriterion("visiable >", value, "visiable");
            return (Criteria) this;
        }

        public Criteria andVisiableGreaterThanOrEqualTo(Integer value) {
            addCriterion("visiable >=", value, "visiable");
            return (Criteria) this;
        }

        public Criteria andVisiableLessThan(Integer value) {
            addCriterion("visiable <", value, "visiable");
            return (Criteria) this;
        }

        public Criteria andVisiableLessThanOrEqualTo(Integer value) {
            addCriterion("visiable <=", value, "visiable");
            return (Criteria) this;
        }

        public Criteria andVisiableIn(List<Integer> values) {
            addCriterion("visiable in", values, "visiable");
            return (Criteria) this;
        }

        public Criteria andVisiableNotIn(List<Integer> values) {
            addCriterion("visiable not in", values, "visiable");
            return (Criteria) this;
        }

        public Criteria andVisiableBetween(Integer value1, Integer value2) {
            addCriterion("visiable between", value1, value2, "visiable");
            return (Criteria) this;
        }

        public Criteria andVisiableNotBetween(Integer value1, Integer value2) {
            addCriterion("visiable not between", value1, value2, "visiable");
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