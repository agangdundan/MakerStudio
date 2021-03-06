package cn.it.phw.ms.pojo;

import java.util.ArrayList;
import java.util.List;

public class LearningplancolumnmanagerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LearningplancolumnmanagerExample() {
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

        public Criteria andLearningplanformIdIsNull() {
            addCriterion("learningplanform_id is null");
            return (Criteria) this;
        }

        public Criteria andLearningplanformIdIsNotNull() {
            addCriterion("learningplanform_id is not null");
            return (Criteria) this;
        }

        public Criteria andLearningplanformIdEqualTo(Integer value) {
            addCriterion("learningplanform_id =", value, "learningplanformId");
            return (Criteria) this;
        }

        public Criteria andLearningplanformIdNotEqualTo(Integer value) {
            addCriterion("learningplanform_id <>", value, "learningplanformId");
            return (Criteria) this;
        }

        public Criteria andLearningplanformIdGreaterThan(Integer value) {
            addCriterion("learningplanform_id >", value, "learningplanformId");
            return (Criteria) this;
        }

        public Criteria andLearningplanformIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("learningplanform_id >=", value, "learningplanformId");
            return (Criteria) this;
        }

        public Criteria andLearningplanformIdLessThan(Integer value) {
            addCriterion("learningplanform_id <", value, "learningplanformId");
            return (Criteria) this;
        }

        public Criteria andLearningplanformIdLessThanOrEqualTo(Integer value) {
            addCriterion("learningplanform_id <=", value, "learningplanformId");
            return (Criteria) this;
        }

        public Criteria andLearningplanformIdIn(List<Integer> values) {
            addCriterion("learningplanform_id in", values, "learningplanformId");
            return (Criteria) this;
        }

        public Criteria andLearningplanformIdNotIn(List<Integer> values) {
            addCriterion("learningplanform_id not in", values, "learningplanformId");
            return (Criteria) this;
        }

        public Criteria andLearningplanformIdBetween(Integer value1, Integer value2) {
            addCriterion("learningplanform_id between", value1, value2, "learningplanformId");
            return (Criteria) this;
        }

        public Criteria andLearningplanformIdNotBetween(Integer value1, Integer value2) {
            addCriterion("learningplanform_id not between", value1, value2, "learningplanformId");
            return (Criteria) this;
        }

        public Criteria andLearningplancolumnNameIsNull() {
            addCriterion("learningplancolumn_name is null");
            return (Criteria) this;
        }

        public Criteria andLearningplancolumnNameIsNotNull() {
            addCriterion("learningplancolumn_name is not null");
            return (Criteria) this;
        }

        public Criteria andLearningplancolumnNameEqualTo(String value) {
            addCriterion("learningplancolumn_name =", value, "learningplancolumnName");
            return (Criteria) this;
        }

        public Criteria andLearningplancolumnNameNotEqualTo(String value) {
            addCriterion("learningplancolumn_name <>", value, "learningplancolumnName");
            return (Criteria) this;
        }

        public Criteria andLearningplancolumnNameGreaterThan(String value) {
            addCriterion("learningplancolumn_name >", value, "learningplancolumnName");
            return (Criteria) this;
        }

        public Criteria andLearningplancolumnNameGreaterThanOrEqualTo(String value) {
            addCriterion("learningplancolumn_name >=", value, "learningplancolumnName");
            return (Criteria) this;
        }

        public Criteria andLearningplancolumnNameLessThan(String value) {
            addCriterion("learningplancolumn_name <", value, "learningplancolumnName");
            return (Criteria) this;
        }

        public Criteria andLearningplancolumnNameLessThanOrEqualTo(String value) {
            addCriterion("learningplancolumn_name <=", value, "learningplancolumnName");
            return (Criteria) this;
        }

        public Criteria andLearningplancolumnNameLike(String value) {
            addCriterion("learningplancolumn_name like", value, "learningplancolumnName");
            return (Criteria) this;
        }

        public Criteria andLearningplancolumnNameNotLike(String value) {
            addCriterion("learningplancolumn_name not like", value, "learningplancolumnName");
            return (Criteria) this;
        }

        public Criteria andLearningplancolumnNameIn(List<String> values) {
            addCriterion("learningplancolumn_name in", values, "learningplancolumnName");
            return (Criteria) this;
        }

        public Criteria andLearningplancolumnNameNotIn(List<String> values) {
            addCriterion("learningplancolumn_name not in", values, "learningplancolumnName");
            return (Criteria) this;
        }

        public Criteria andLearningplancolumnNameBetween(String value1, String value2) {
            addCriterion("learningplancolumn_name between", value1, value2, "learningplancolumnName");
            return (Criteria) this;
        }

        public Criteria andLearningplancolumnNameNotBetween(String value1, String value2) {
            addCriterion("learningplancolumn_name not between", value1, value2, "learningplancolumnName");
            return (Criteria) this;
        }

        public Criteria andLearningplancolumnIdIsNull() {
            addCriterion("learningplancolumn_id is null");
            return (Criteria) this;
        }

        public Criteria andLearningplancolumnIdIsNotNull() {
            addCriterion("learningplancolumn_id is not null");
            return (Criteria) this;
        }

        public Criteria andLearningplancolumnIdEqualTo(Integer value) {
            addCriterion("learningplancolumn_id =", value, "learningplancolumnId");
            return (Criteria) this;
        }

        public Criteria andLearningplancolumnIdNotEqualTo(Integer value) {
            addCriterion("learningplancolumn_id <>", value, "learningplancolumnId");
            return (Criteria) this;
        }

        public Criteria andLearningplancolumnIdGreaterThan(Integer value) {
            addCriterion("learningplancolumn_id >", value, "learningplancolumnId");
            return (Criteria) this;
        }

        public Criteria andLearningplancolumnIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("learningplancolumn_id >=", value, "learningplancolumnId");
            return (Criteria) this;
        }

        public Criteria andLearningplancolumnIdLessThan(Integer value) {
            addCriterion("learningplancolumn_id <", value, "learningplancolumnId");
            return (Criteria) this;
        }

        public Criteria andLearningplancolumnIdLessThanOrEqualTo(Integer value) {
            addCriterion("learningplancolumn_id <=", value, "learningplancolumnId");
            return (Criteria) this;
        }

        public Criteria andLearningplancolumnIdIn(List<Integer> values) {
            addCriterion("learningplancolumn_id in", values, "learningplancolumnId");
            return (Criteria) this;
        }

        public Criteria andLearningplancolumnIdNotIn(List<Integer> values) {
            addCriterion("learningplancolumn_id not in", values, "learningplancolumnId");
            return (Criteria) this;
        }

        public Criteria andLearningplancolumnIdBetween(Integer value1, Integer value2) {
            addCriterion("learningplancolumn_id between", value1, value2, "learningplancolumnId");
            return (Criteria) this;
        }

        public Criteria andLearningplancolumnIdNotBetween(Integer value1, Integer value2) {
            addCriterion("learningplancolumn_id not between", value1, value2, "learningplancolumnId");
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