package com.fangda.skylot.mathine.model.customer;

import com.fangda.skylot.mathine.utils.Page;
import java.util.ArrayList;
import java.util.List;

public class OftbSyncLogCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public OftbSyncLogCriteria() {
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

    public void setPage(Page page) {
        this.page=page;
    }

    public Page getPage() {
        return page;
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

        public Criteria andOslIdIsNull() {
            addCriterion("osl_id is null");
            return (Criteria) this;
        }

        public Criteria andOslIdIsNotNull() {
            addCriterion("osl_id is not null");
            return (Criteria) this;
        }

        public Criteria andOslIdEqualTo(Integer value) {
            addCriterion("osl_id =", value, "oslId");
            return (Criteria) this;
        }

        public Criteria andOslIdNotEqualTo(Integer value) {
            addCriterion("osl_id <>", value, "oslId");
            return (Criteria) this;
        }

        public Criteria andOslIdGreaterThan(Integer value) {
            addCriterion("osl_id >", value, "oslId");
            return (Criteria) this;
        }

        public Criteria andOslIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("osl_id >=", value, "oslId");
            return (Criteria) this;
        }

        public Criteria andOslIdLessThan(Integer value) {
            addCriterion("osl_id <", value, "oslId");
            return (Criteria) this;
        }

        public Criteria andOslIdLessThanOrEqualTo(Integer value) {
            addCriterion("osl_id <=", value, "oslId");
            return (Criteria) this;
        }

        public Criteria andOslIdIn(List<Integer> values) {
            addCriterion("osl_id in", values, "oslId");
            return (Criteria) this;
        }

        public Criteria andOslIdNotIn(List<Integer> values) {
            addCriterion("osl_id not in", values, "oslId");
            return (Criteria) this;
        }

        public Criteria andOslIdBetween(Integer value1, Integer value2) {
            addCriterion("osl_id between", value1, value2, "oslId");
            return (Criteria) this;
        }

        public Criteria andOslIdNotBetween(Integer value1, Integer value2) {
            addCriterion("osl_id not between", value1, value2, "oslId");
            return (Criteria) this;
        }

        public Criteria andOslTypeIsNull() {
            addCriterion("osl_type is null");
            return (Criteria) this;
        }

        public Criteria andOslTypeIsNotNull() {
            addCriterion("osl_type is not null");
            return (Criteria) this;
        }

        public Criteria andOslTypeEqualTo(String value) {
            addCriterion("osl_type =", value, "oslType");
            return (Criteria) this;
        }

        public Criteria andOslTypeNotEqualTo(String value) {
            addCriterion("osl_type <>", value, "oslType");
            return (Criteria) this;
        }

        public Criteria andOslTypeGreaterThan(String value) {
            addCriterion("osl_type >", value, "oslType");
            return (Criteria) this;
        }

        public Criteria andOslTypeGreaterThanOrEqualTo(String value) {
            addCriterion("osl_type >=", value, "oslType");
            return (Criteria) this;
        }

        public Criteria andOslTypeLessThan(String value) {
            addCriterion("osl_type <", value, "oslType");
            return (Criteria) this;
        }

        public Criteria andOslTypeLessThanOrEqualTo(String value) {
            addCriterion("osl_type <=", value, "oslType");
            return (Criteria) this;
        }

        public Criteria andOslTypeLike(String value) {
            addCriterion("osl_type like", value, "oslType");
            return (Criteria) this;
        }

        public Criteria andOslTypeNotLike(String value) {
            addCriterion("osl_type not like", value, "oslType");
            return (Criteria) this;
        }

        public Criteria andOslTypeIn(List<String> values) {
            addCriterion("osl_type in", values, "oslType");
            return (Criteria) this;
        }

        public Criteria andOslTypeNotIn(List<String> values) {
            addCriterion("osl_type not in", values, "oslType");
            return (Criteria) this;
        }

        public Criteria andOslTypeBetween(String value1, String value2) {
            addCriterion("osl_type between", value1, value2, "oslType");
            return (Criteria) this;
        }

        public Criteria andOslTypeNotBetween(String value1, String value2) {
            addCriterion("osl_type not between", value1, value2, "oslType");
            return (Criteria) this;
        }

        public Criteria andOslCountIsNull() {
            addCriterion("osl_count is null");
            return (Criteria) this;
        }

        public Criteria andOslCountIsNotNull() {
            addCriterion("osl_count is not null");
            return (Criteria) this;
        }

        public Criteria andOslCountEqualTo(Integer value) {
            addCriterion("osl_count =", value, "oslCount");
            return (Criteria) this;
        }

        public Criteria andOslCountNotEqualTo(Integer value) {
            addCriterion("osl_count <>", value, "oslCount");
            return (Criteria) this;
        }

        public Criteria andOslCountGreaterThan(Integer value) {
            addCriterion("osl_count >", value, "oslCount");
            return (Criteria) this;
        }

        public Criteria andOslCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("osl_count >=", value, "oslCount");
            return (Criteria) this;
        }

        public Criteria andOslCountLessThan(Integer value) {
            addCriterion("osl_count <", value, "oslCount");
            return (Criteria) this;
        }

        public Criteria andOslCountLessThanOrEqualTo(Integer value) {
            addCriterion("osl_count <=", value, "oslCount");
            return (Criteria) this;
        }

        public Criteria andOslCountIn(List<Integer> values) {
            addCriterion("osl_count in", values, "oslCount");
            return (Criteria) this;
        }

        public Criteria andOslCountNotIn(List<Integer> values) {
            addCriterion("osl_count not in", values, "oslCount");
            return (Criteria) this;
        }

        public Criteria andOslCountBetween(Integer value1, Integer value2) {
            addCriterion("osl_count between", value1, value2, "oslCount");
            return (Criteria) this;
        }

        public Criteria andOslCountNotBetween(Integer value1, Integer value2) {
            addCriterion("osl_count not between", value1, value2, "oslCount");
            return (Criteria) this;
        }

        public Criteria andOslStatusIsNull() {
            addCriterion("osl_status is null");
            return (Criteria) this;
        }

        public Criteria andOslStatusIsNotNull() {
            addCriterion("osl_status is not null");
            return (Criteria) this;
        }

        public Criteria andOslStatusEqualTo(String value) {
            addCriterion("osl_status =", value, "oslStatus");
            return (Criteria) this;
        }

        public Criteria andOslStatusNotEqualTo(String value) {
            addCriterion("osl_status <>", value, "oslStatus");
            return (Criteria) this;
        }

        public Criteria andOslStatusGreaterThan(String value) {
            addCriterion("osl_status >", value, "oslStatus");
            return (Criteria) this;
        }

        public Criteria andOslStatusGreaterThanOrEqualTo(String value) {
            addCriterion("osl_status >=", value, "oslStatus");
            return (Criteria) this;
        }

        public Criteria andOslStatusLessThan(String value) {
            addCriterion("osl_status <", value, "oslStatus");
            return (Criteria) this;
        }

        public Criteria andOslStatusLessThanOrEqualTo(String value) {
            addCriterion("osl_status <=", value, "oslStatus");
            return (Criteria) this;
        }

        public Criteria andOslStatusLike(String value) {
            addCriterion("osl_status like", value, "oslStatus");
            return (Criteria) this;
        }

        public Criteria andOslStatusNotLike(String value) {
            addCriterion("osl_status not like", value, "oslStatus");
            return (Criteria) this;
        }

        public Criteria andOslStatusIn(List<String> values) {
            addCriterion("osl_status in", values, "oslStatus");
            return (Criteria) this;
        }

        public Criteria andOslStatusNotIn(List<String> values) {
            addCriterion("osl_status not in", values, "oslStatus");
            return (Criteria) this;
        }

        public Criteria andOslStatusBetween(String value1, String value2) {
            addCriterion("osl_status between", value1, value2, "oslStatus");
            return (Criteria) this;
        }

        public Criteria andOslStatusNotBetween(String value1, String value2) {
            addCriterion("osl_status not between", value1, value2, "oslStatus");
            return (Criteria) this;
        }

        public Criteria andOslCreatedateIsNull() {
            addCriterion("osl_createdate is null");
            return (Criteria) this;
        }

        public Criteria andOslCreatedateIsNotNull() {
            addCriterion("osl_createdate is not null");
            return (Criteria) this;
        }

        public Criteria andOslCreatedateEqualTo(String value) {
            addCriterion("osl_createdate =", value, "oslCreatedate");
            return (Criteria) this;
        }

        public Criteria andOslCreatedateNotEqualTo(String value) {
            addCriterion("osl_createdate <>", value, "oslCreatedate");
            return (Criteria) this;
        }

        public Criteria andOslCreatedateGreaterThan(String value) {
            addCriterion("osl_createdate >", value, "oslCreatedate");
            return (Criteria) this;
        }

        public Criteria andOslCreatedateGreaterThanOrEqualTo(String value) {
            addCriterion("osl_createdate >=", value, "oslCreatedate");
            return (Criteria) this;
        }

        public Criteria andOslCreatedateLessThan(String value) {
            addCriterion("osl_createdate <", value, "oslCreatedate");
            return (Criteria) this;
        }

        public Criteria andOslCreatedateLessThanOrEqualTo(String value) {
            addCriterion("osl_createdate <=", value, "oslCreatedate");
            return (Criteria) this;
        }

        public Criteria andOslCreatedateLike(String value) {
            addCriterion("osl_createdate like", value, "oslCreatedate");
            return (Criteria) this;
        }

        public Criteria andOslCreatedateNotLike(String value) {
            addCriterion("osl_createdate not like", value, "oslCreatedate");
            return (Criteria) this;
        }

        public Criteria andOslCreatedateIn(List<String> values) {
            addCriterion("osl_createdate in", values, "oslCreatedate");
            return (Criteria) this;
        }

        public Criteria andOslCreatedateNotIn(List<String> values) {
            addCriterion("osl_createdate not in", values, "oslCreatedate");
            return (Criteria) this;
        }

        public Criteria andOslCreatedateBetween(String value1, String value2) {
            addCriterion("osl_createdate between", value1, value2, "oslCreatedate");
            return (Criteria) this;
        }

        public Criteria andOslCreatedateNotBetween(String value1, String value2) {
            addCriterion("osl_createdate not between", value1, value2, "oslCreatedate");
            return (Criteria) this;
        }

        public Criteria andOslCreateuserIsNull() {
            addCriterion("osl_createuser is null");
            return (Criteria) this;
        }

        public Criteria andOslCreateuserIsNotNull() {
            addCriterion("osl_createuser is not null");
            return (Criteria) this;
        }

        public Criteria andOslCreateuserEqualTo(String value) {
            addCriterion("osl_createuser =", value, "oslCreateuser");
            return (Criteria) this;
        }

        public Criteria andOslCreateuserNotEqualTo(String value) {
            addCriterion("osl_createuser <>", value, "oslCreateuser");
            return (Criteria) this;
        }

        public Criteria andOslCreateuserGreaterThan(String value) {
            addCriterion("osl_createuser >", value, "oslCreateuser");
            return (Criteria) this;
        }

        public Criteria andOslCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("osl_createuser >=", value, "oslCreateuser");
            return (Criteria) this;
        }

        public Criteria andOslCreateuserLessThan(String value) {
            addCriterion("osl_createuser <", value, "oslCreateuser");
            return (Criteria) this;
        }

        public Criteria andOslCreateuserLessThanOrEqualTo(String value) {
            addCriterion("osl_createuser <=", value, "oslCreateuser");
            return (Criteria) this;
        }

        public Criteria andOslCreateuserLike(String value) {
            addCriterion("osl_createuser like", value, "oslCreateuser");
            return (Criteria) this;
        }

        public Criteria andOslCreateuserNotLike(String value) {
            addCriterion("osl_createuser not like", value, "oslCreateuser");
            return (Criteria) this;
        }

        public Criteria andOslCreateuserIn(List<String> values) {
            addCriterion("osl_createuser in", values, "oslCreateuser");
            return (Criteria) this;
        }

        public Criteria andOslCreateuserNotIn(List<String> values) {
            addCriterion("osl_createuser not in", values, "oslCreateuser");
            return (Criteria) this;
        }

        public Criteria andOslCreateuserBetween(String value1, String value2) {
            addCriterion("osl_createuser between", value1, value2, "oslCreateuser");
            return (Criteria) this;
        }

        public Criteria andOslCreateuserNotBetween(String value1, String value2) {
            addCriterion("osl_createuser not between", value1, value2, "oslCreateuser");
            return (Criteria) this;
        }

        public Criteria andOslUpdatedateIsNull() {
            addCriterion("osl_updatedate is null");
            return (Criteria) this;
        }

        public Criteria andOslUpdatedateIsNotNull() {
            addCriterion("osl_updatedate is not null");
            return (Criteria) this;
        }

        public Criteria andOslUpdatedateEqualTo(String value) {
            addCriterion("osl_updatedate =", value, "oslUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOslUpdatedateNotEqualTo(String value) {
            addCriterion("osl_updatedate <>", value, "oslUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOslUpdatedateGreaterThan(String value) {
            addCriterion("osl_updatedate >", value, "oslUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOslUpdatedateGreaterThanOrEqualTo(String value) {
            addCriterion("osl_updatedate >=", value, "oslUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOslUpdatedateLessThan(String value) {
            addCriterion("osl_updatedate <", value, "oslUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOslUpdatedateLessThanOrEqualTo(String value) {
            addCriterion("osl_updatedate <=", value, "oslUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOslUpdatedateLike(String value) {
            addCriterion("osl_updatedate like", value, "oslUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOslUpdatedateNotLike(String value) {
            addCriterion("osl_updatedate not like", value, "oslUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOslUpdatedateIn(List<String> values) {
            addCriterion("osl_updatedate in", values, "oslUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOslUpdatedateNotIn(List<String> values) {
            addCriterion("osl_updatedate not in", values, "oslUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOslUpdatedateBetween(String value1, String value2) {
            addCriterion("osl_updatedate between", value1, value2, "oslUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOslUpdatedateNotBetween(String value1, String value2) {
            addCriterion("osl_updatedate not between", value1, value2, "oslUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOslUpdateuserIsNull() {
            addCriterion("osl_updateuser is null");
            return (Criteria) this;
        }

        public Criteria andOslUpdateuserIsNotNull() {
            addCriterion("osl_updateuser is not null");
            return (Criteria) this;
        }

        public Criteria andOslUpdateuserEqualTo(String value) {
            addCriterion("osl_updateuser =", value, "oslUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOslUpdateuserNotEqualTo(String value) {
            addCriterion("osl_updateuser <>", value, "oslUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOslUpdateuserGreaterThan(String value) {
            addCriterion("osl_updateuser >", value, "oslUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOslUpdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("osl_updateuser >=", value, "oslUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOslUpdateuserLessThan(String value) {
            addCriterion("osl_updateuser <", value, "oslUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOslUpdateuserLessThanOrEqualTo(String value) {
            addCriterion("osl_updateuser <=", value, "oslUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOslUpdateuserLike(String value) {
            addCriterion("osl_updateuser like", value, "oslUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOslUpdateuserNotLike(String value) {
            addCriterion("osl_updateuser not like", value, "oslUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOslUpdateuserIn(List<String> values) {
            addCriterion("osl_updateuser in", values, "oslUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOslUpdateuserNotIn(List<String> values) {
            addCriterion("osl_updateuser not in", values, "oslUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOslUpdateuserBetween(String value1, String value2) {
            addCriterion("osl_updateuser between", value1, value2, "oslUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOslUpdateuserNotBetween(String value1, String value2) {
            addCriterion("osl_updateuser not between", value1, value2, "oslUpdateuser");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andOslTypeLikeInsensitive(String value) {
            addCriterion("upper(osl_type) like", value.toUpperCase(), "oslType");
            return this;
        }

        public Criteria andOslStatusLikeInsensitive(String value) {
            addCriterion("upper(osl_status) like", value.toUpperCase(), "oslStatus");
            return this;
        }

        public Criteria andOslCreatedateLikeInsensitive(String value) {
            addCriterion("upper(osl_createdate) like", value.toUpperCase(), "oslCreatedate");
            return this;
        }

        public Criteria andOslCreateuserLikeInsensitive(String value) {
            addCriterion("upper(osl_createuser) like", value.toUpperCase(), "oslCreateuser");
            return this;
        }

        public Criteria andOslUpdatedateLikeInsensitive(String value) {
            addCriterion("upper(osl_updatedate) like", value.toUpperCase(), "oslUpdatedate");
            return this;
        }

        public Criteria andOslUpdateuserLikeInsensitive(String value) {
            addCriterion("upper(osl_updateuser) like", value.toUpperCase(), "oslUpdateuser");
            return this;
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