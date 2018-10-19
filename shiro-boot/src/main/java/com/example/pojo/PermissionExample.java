package com.example.pojo;

import java.util.ArrayList;
import java.util.List;

public class PermissionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PermissionExample() {
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

        public Criteria andResource_idIsNull() {
            addCriterion("resource_id is null");
            return (Criteria) this;
        }

        public Criteria andResource_idIsNotNull() {
            addCriterion("resource_id is not null");
            return (Criteria) this;
        }

        public Criteria andResource_idEqualTo(Long value) {
            addCriterion("resource_id =", value, "resource_id");
            return (Criteria) this;
        }

        public Criteria andResource_idNotEqualTo(Long value) {
            addCriterion("resource_id <>", value, "resource_id");
            return (Criteria) this;
        }

        public Criteria andResource_idGreaterThan(Long value) {
            addCriterion("resource_id >", value, "resource_id");
            return (Criteria) this;
        }

        public Criteria andResource_idGreaterThanOrEqualTo(Long value) {
            addCriterion("resource_id >=", value, "resource_id");
            return (Criteria) this;
        }

        public Criteria andResource_idLessThan(Long value) {
            addCriterion("resource_id <", value, "resource_id");
            return (Criteria) this;
        }

        public Criteria andResource_idLessThanOrEqualTo(Long value) {
            addCriterion("resource_id <=", value, "resource_id");
            return (Criteria) this;
        }

        public Criteria andResource_idIn(List<Long> values) {
            addCriterion("resource_id in", values, "resource_id");
            return (Criteria) this;
        }

        public Criteria andResource_idNotIn(List<Long> values) {
            addCriterion("resource_id not in", values, "resource_id");
            return (Criteria) this;
        }

        public Criteria andResource_idBetween(Long value1, Long value2) {
            addCriterion("resource_id between", value1, value2, "resource_id");
            return (Criteria) this;
        }

        public Criteria andResource_idNotBetween(Long value1, Long value2) {
            addCriterion("resource_id not between", value1, value2, "resource_id");
            return (Criteria) this;
        }

        public Criteria andResource_nameIsNull() {
            addCriterion("resource_name is null");
            return (Criteria) this;
        }

        public Criteria andResource_nameIsNotNull() {
            addCriterion("resource_name is not null");
            return (Criteria) this;
        }

        public Criteria andResource_nameEqualTo(String value) {
            addCriterion("resource_name =", value, "resource_name");
            return (Criteria) this;
        }

        public Criteria andResource_nameNotEqualTo(String value) {
            addCriterion("resource_name <>", value, "resource_name");
            return (Criteria) this;
        }

        public Criteria andResource_nameGreaterThan(String value) {
            addCriterion("resource_name >", value, "resource_name");
            return (Criteria) this;
        }

        public Criteria andResource_nameGreaterThanOrEqualTo(String value) {
            addCriterion("resource_name >=", value, "resource_name");
            return (Criteria) this;
        }

        public Criteria andResource_nameLessThan(String value) {
            addCriterion("resource_name <", value, "resource_name");
            return (Criteria) this;
        }

        public Criteria andResource_nameLessThanOrEqualTo(String value) {
            addCriterion("resource_name <=", value, "resource_name");
            return (Criteria) this;
        }

        public Criteria andResource_nameLike(String value) {
            addCriterion("resource_name like", value, "resource_name");
            return (Criteria) this;
        }

        public Criteria andResource_nameNotLike(String value) {
            addCriterion("resource_name not like", value, "resource_name");
            return (Criteria) this;
        }

        public Criteria andResource_nameIn(List<String> values) {
            addCriterion("resource_name in", values, "resource_name");
            return (Criteria) this;
        }

        public Criteria andResource_nameNotIn(List<String> values) {
            addCriterion("resource_name not in", values, "resource_name");
            return (Criteria) this;
        }

        public Criteria andResource_nameBetween(String value1, String value2) {
            addCriterion("resource_name between", value1, value2, "resource_name");
            return (Criteria) this;
        }

        public Criteria andResource_nameNotBetween(String value1, String value2) {
            addCriterion("resource_name not between", value1, value2, "resource_name");
            return (Criteria) this;
        }

        public Criteria andResource_urlIsNull() {
            addCriterion("resource_url is null");
            return (Criteria) this;
        }

        public Criteria andResource_urlIsNotNull() {
            addCriterion("resource_url is not null");
            return (Criteria) this;
        }

        public Criteria andResource_urlEqualTo(String value) {
            addCriterion("resource_url =", value, "resource_url");
            return (Criteria) this;
        }

        public Criteria andResource_urlNotEqualTo(String value) {
            addCriterion("resource_url <>", value, "resource_url");
            return (Criteria) this;
        }

        public Criteria andResource_urlGreaterThan(String value) {
            addCriterion("resource_url >", value, "resource_url");
            return (Criteria) this;
        }

        public Criteria andResource_urlGreaterThanOrEqualTo(String value) {
            addCriterion("resource_url >=", value, "resource_url");
            return (Criteria) this;
        }

        public Criteria andResource_urlLessThan(String value) {
            addCriterion("resource_url <", value, "resource_url");
            return (Criteria) this;
        }

        public Criteria andResource_urlLessThanOrEqualTo(String value) {
            addCriterion("resource_url <=", value, "resource_url");
            return (Criteria) this;
        }

        public Criteria andResource_urlLike(String value) {
            addCriterion("resource_url like", value, "resource_url");
            return (Criteria) this;
        }

        public Criteria andResource_urlNotLike(String value) {
            addCriterion("resource_url not like", value, "resource_url");
            return (Criteria) this;
        }

        public Criteria andResource_urlIn(List<String> values) {
            addCriterion("resource_url in", values, "resource_url");
            return (Criteria) this;
        }

        public Criteria andResource_urlNotIn(List<String> values) {
            addCriterion("resource_url not in", values, "resource_url");
            return (Criteria) this;
        }

        public Criteria andResource_urlBetween(String value1, String value2) {
            addCriterion("resource_url between", value1, value2, "resource_url");
            return (Criteria) this;
        }

        public Criteria andResource_urlNotBetween(String value1, String value2) {
            addCriterion("resource_url not between", value1, value2, "resource_url");
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