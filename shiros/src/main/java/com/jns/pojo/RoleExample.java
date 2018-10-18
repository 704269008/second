package com.jns.pojo;

import java.util.ArrayList;
import java.util.List;

public class RoleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoleExample() {
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

        public Criteria andRole_idIsNull() {
            addCriterion("role_id is null");
            return (Criteria) this;
        }

        public Criteria andRole_idIsNotNull() {
            addCriterion("role_id is not null");
            return (Criteria) this;
        }

        public Criteria andRole_idEqualTo(Long value) {
            addCriterion("role_id =", value, "role_id");
            return (Criteria) this;
        }

        public Criteria andRole_idNotEqualTo(Long value) {
            addCriterion("role_id <>", value, "role_id");
            return (Criteria) this;
        }

        public Criteria andRole_idGreaterThan(Long value) {
            addCriterion("role_id >", value, "role_id");
            return (Criteria) this;
        }

        public Criteria andRole_idGreaterThanOrEqualTo(Long value) {
            addCriterion("role_id >=", value, "role_id");
            return (Criteria) this;
        }

        public Criteria andRole_idLessThan(Long value) {
            addCriterion("role_id <", value, "role_id");
            return (Criteria) this;
        }

        public Criteria andRole_idLessThanOrEqualTo(Long value) {
            addCriterion("role_id <=", value, "role_id");
            return (Criteria) this;
        }

        public Criteria andRole_idIn(List<Long> values) {
            addCriterion("role_id in", values, "role_id");
            return (Criteria) this;
        }

        public Criteria andRole_idNotIn(List<Long> values) {
            addCriterion("role_id not in", values, "role_id");
            return (Criteria) this;
        }

        public Criteria andRole_idBetween(Long value1, Long value2) {
            addCriterion("role_id between", value1, value2, "role_id");
            return (Criteria) this;
        }

        public Criteria andRole_idNotBetween(Long value1, Long value2) {
            addCriterion("role_id not between", value1, value2, "role_id");
            return (Criteria) this;
        }

        public Criteria andRole_nameIsNull() {
            addCriterion("role_name is null");
            return (Criteria) this;
        }

        public Criteria andRole_nameIsNotNull() {
            addCriterion("role_name is not null");
            return (Criteria) this;
        }

        public Criteria andRole_nameEqualTo(String value) {
            addCriterion("role_name =", value, "role_name");
            return (Criteria) this;
        }

        public Criteria andRole_nameNotEqualTo(String value) {
            addCriterion("role_name <>", value, "role_name");
            return (Criteria) this;
        }

        public Criteria andRole_nameGreaterThan(String value) {
            addCriterion("role_name >", value, "role_name");
            return (Criteria) this;
        }

        public Criteria andRole_nameGreaterThanOrEqualTo(String value) {
            addCriterion("role_name >=", value, "role_name");
            return (Criteria) this;
        }

        public Criteria andRole_nameLessThan(String value) {
            addCriterion("role_name <", value, "role_name");
            return (Criteria) this;
        }

        public Criteria andRole_nameLessThanOrEqualTo(String value) {
            addCriterion("role_name <=", value, "role_name");
            return (Criteria) this;
        }

        public Criteria andRole_nameLike(String value) {
            addCriterion("role_name like", value, "role_name");
            return (Criteria) this;
        }

        public Criteria andRole_nameNotLike(String value) {
            addCriterion("role_name not like", value, "role_name");
            return (Criteria) this;
        }

        public Criteria andRole_nameIn(List<String> values) {
            addCriterion("role_name in", values, "role_name");
            return (Criteria) this;
        }

        public Criteria andRole_nameNotIn(List<String> values) {
            addCriterion("role_name not in", values, "role_name");
            return (Criteria) this;
        }

        public Criteria andRole_nameBetween(String value1, String value2) {
            addCriterion("role_name between", value1, value2, "role_name");
            return (Criteria) this;
        }

        public Criteria andRole_nameNotBetween(String value1, String value2) {
            addCriterion("role_name not between", value1, value2, "role_name");
            return (Criteria) this;
        }

        public Criteria andDesc_IsNull() {
            addCriterion("desc_ is null");
            return (Criteria) this;
        }

        public Criteria andDesc_IsNotNull() {
            addCriterion("desc_ is not null");
            return (Criteria) this;
        }

        public Criteria andDesc_EqualTo(String value) {
            addCriterion("desc_ =", value, "desc_");
            return (Criteria) this;
        }

        public Criteria andDesc_NotEqualTo(String value) {
            addCriterion("desc_ <>", value, "desc_");
            return (Criteria) this;
        }

        public Criteria andDesc_GreaterThan(String value) {
            addCriterion("desc_ >", value, "desc_");
            return (Criteria) this;
        }

        public Criteria andDesc_GreaterThanOrEqualTo(String value) {
            addCriterion("desc_ >=", value, "desc_");
            return (Criteria) this;
        }

        public Criteria andDesc_LessThan(String value) {
            addCriterion("desc_ <", value, "desc_");
            return (Criteria) this;
        }

        public Criteria andDesc_LessThanOrEqualTo(String value) {
            addCriterion("desc_ <=", value, "desc_");
            return (Criteria) this;
        }

        public Criteria andDesc_Like(String value) {
            addCriterion("desc_ like", value, "desc_");
            return (Criteria) this;
        }

        public Criteria andDesc_NotLike(String value) {
            addCriterion("desc_ not like", value, "desc_");
            return (Criteria) this;
        }

        public Criteria andDesc_In(List<String> values) {
            addCriterion("desc_ in", values, "desc_");
            return (Criteria) this;
        }

        public Criteria andDesc_NotIn(List<String> values) {
            addCriterion("desc_ not in", values, "desc_");
            return (Criteria) this;
        }

        public Criteria andDesc_Between(String value1, String value2) {
            addCriterion("desc_ between", value1, value2, "desc_");
            return (Criteria) this;
        }

        public Criteria andDesc_NotBetween(String value1, String value2) {
            addCriterion("desc_ not between", value1, value2, "desc_");
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