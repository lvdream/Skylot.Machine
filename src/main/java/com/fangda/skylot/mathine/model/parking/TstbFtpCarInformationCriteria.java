package com.fangda.skylot.mathine.model.parking;

import com.fangda.skylot.mathine.utils.Page;

import java.util.ArrayList;
import java.util.List;

public class TstbFtpCarInformationCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public TstbFtpCarInformationCriteria() {
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

        public Criteria andTfcIdIsNull() {
            addCriterion("tfc_id is null");
            return (Criteria) this;
        }

        public Criteria andTfcIdIsNotNull() {
            addCriterion("tfc_id is not null");
            return (Criteria) this;
        }

        public Criteria andTfcIdEqualTo(Integer value) {
            addCriterion("tfc_id =", value, "tfcId");
            return (Criteria) this;
        }

        public Criteria andTfcIdNotEqualTo(Integer value) {
            addCriterion("tfc_id <>", value, "tfcId");
            return (Criteria) this;
        }

        public Criteria andTfcIdGreaterThan(Integer value) {
            addCriterion("tfc_id >", value, "tfcId");
            return (Criteria) this;
        }

        public Criteria andTfcIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tfc_id >=", value, "tfcId");
            return (Criteria) this;
        }

        public Criteria andTfcIdLessThan(Integer value) {
            addCriterion("tfc_id <", value, "tfcId");
            return (Criteria) this;
        }

        public Criteria andTfcIdLessThanOrEqualTo(Integer value) {
            addCriterion("tfc_id <=", value, "tfcId");
            return (Criteria) this;
        }

        public Criteria andTfcIdIn(List<Integer> values) {
            addCriterion("tfc_id in", values, "tfcId");
            return (Criteria) this;
        }

        public Criteria andTfcIdNotIn(List<Integer> values) {
            addCriterion("tfc_id not in", values, "tfcId");
            return (Criteria) this;
        }

        public Criteria andTfcIdBetween(Integer value1, Integer value2) {
            addCriterion("tfc_id between", value1, value2, "tfcId");
            return (Criteria) this;
        }

        public Criteria andTfcIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tfc_id not between", value1, value2, "tfcId");
            return (Criteria) this;
        }

        public Criteria andImaIdIsNull() {
            addCriterion("ima_id is null");
            return (Criteria) this;
        }

        public Criteria andImaIdIsNotNull() {
            addCriterion("ima_id is not null");
            return (Criteria) this;
        }

        public Criteria andImaIdEqualTo(String value) {
            addCriterion("ima_id =", value, "imaId");
            return (Criteria) this;
        }

        public Criteria andImaIdNotEqualTo(String value) {
            addCriterion("ima_id <>", value, "imaId");
            return (Criteria) this;
        }

        public Criteria andImaIdGreaterThan(String value) {
            addCriterion("ima_id >", value, "imaId");
            return (Criteria) this;
        }

        public Criteria andImaIdGreaterThanOrEqualTo(String value) {
            addCriterion("ima_id >=", value, "imaId");
            return (Criteria) this;
        }

        public Criteria andImaIdLessThan(String value) {
            addCriterion("ima_id <", value, "imaId");
            return (Criteria) this;
        }

        public Criteria andImaIdLessThanOrEqualTo(String value) {
            addCriterion("ima_id <=", value, "imaId");
            return (Criteria) this;
        }

        public Criteria andImaIdIn(List<String> values) {
            addCriterion("ima_id in", values, "imaId");
            return (Criteria) this;
        }

        public Criteria andImaIdNotIn(List<String> values) {
            addCriterion("ima_id not in", values, "imaId");
            return (Criteria) this;
        }

        public Criteria andImaIdBetween(String value1, String value2) {
            addCriterion("ima_id between", value1, value2, "imaId");
            return (Criteria) this;
        }

        public Criteria andImaIdNotBetween(String value1, String value2) {
            addCriterion("ima_id not between", value1, value2, "imaId");
            return (Criteria) this;
        }

        public Criteria andTfcCarCodeIsNull() {
            addCriterion("tfc_car_code is null");
            return (Criteria) this;
        }

        public Criteria andTfcCarCodeIsNotNull() {
            addCriterion("tfc_car_code is not null");
            return (Criteria) this;
        }

        public Criteria andTfcCarCodeEqualTo(String value) {
            addCriterion("tfc_car_code =", value, "tfcCarCode");
            return (Criteria) this;
        }

        public Criteria andTfcCarCodeNotEqualTo(String value) {
            addCriterion("tfc_car_code <>", value, "tfcCarCode");
            return (Criteria) this;
        }

        public Criteria andTfcCarCodeGreaterThan(String value) {
            addCriterion("tfc_car_code >", value, "tfcCarCode");
            return (Criteria) this;
        }

        public Criteria andTfcCarCodeGreaterThanOrEqualTo(String value) {
            addCriterion("tfc_car_code >=", value, "tfcCarCode");
            return (Criteria) this;
        }

        public Criteria andTfcCarCodeLessThan(String value) {
            addCriterion("tfc_car_code <", value, "tfcCarCode");
            return (Criteria) this;
        }

        public Criteria andTfcCarCodeLessThanOrEqualTo(String value) {
            addCriterion("tfc_car_code <=", value, "tfcCarCode");
            return (Criteria) this;
        }

        public Criteria andTfcCarCodeLike(String value) {
            addCriterion("tfc_car_code like", value, "tfcCarCode");
            return (Criteria) this;
        }

        public Criteria andTfcCarCodeNotLike(String value) {
            addCriterion("tfc_car_code not like", value, "tfcCarCode");
            return (Criteria) this;
        }

        public Criteria andTfcCarCodeIn(List<String> values) {
            addCriterion("tfc_car_code in", values, "tfcCarCode");
            return (Criteria) this;
        }

        public Criteria andTfcCarCodeNotIn(List<String> values) {
            addCriterion("tfc_car_code not in", values, "tfcCarCode");
            return (Criteria) this;
        }

        public Criteria andTfcCarCodeBetween(String value1, String value2) {
            addCriterion("tfc_car_code between", value1, value2, "tfcCarCode");
            return (Criteria) this;
        }

        public Criteria andTfcCarCodeNotBetween(String value1, String value2) {
            addCriterion("tfc_car_code not between", value1, value2, "tfcCarCode");
            return (Criteria) this;
        }

        public Criteria andTfcStatusIsNull() {
            addCriterion("tfc_status is null");
            return (Criteria) this;
        }

        public Criteria andTfcStatusIsNotNull() {
            addCriterion("tfc_status is not null");
            return (Criteria) this;
        }

        public Criteria andTfcStatusEqualTo(Integer value) {
            addCriterion("tfc_status =", value, "tfcStatus");
            return (Criteria) this;
        }

        public Criteria andTfcStatusNotEqualTo(Integer value) {
            addCriterion("tfc_status <>", value, "tfcStatus");
            return (Criteria) this;
        }

        public Criteria andTfcStatusGreaterThan(Integer value) {
            addCriterion("tfc_status >", value, "tfcStatus");
            return (Criteria) this;
        }

        public Criteria andTfcStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("tfc_status >=", value, "tfcStatus");
            return (Criteria) this;
        }

        public Criteria andTfcStatusLessThan(Integer value) {
            addCriterion("tfc_status <", value, "tfcStatus");
            return (Criteria) this;
        }

        public Criteria andTfcStatusLessThanOrEqualTo(Integer value) {
            addCriterion("tfc_status <=", value, "tfcStatus");
            return (Criteria) this;
        }

        public Criteria andTfcStatusIn(List<Integer> values) {
            addCriterion("tfc_status in", values, "tfcStatus");
            return (Criteria) this;
        }

        public Criteria andTfcStatusNotIn(List<Integer> values) {
            addCriterion("tfc_status not in", values, "tfcStatus");
            return (Criteria) this;
        }

        public Criteria andTfcStatusBetween(Integer value1, Integer value2) {
            addCriterion("tfc_status between", value1, value2, "tfcStatus");
            return (Criteria) this;
        }

        public Criteria andTfcStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("tfc_status not between", value1, value2, "tfcStatus");
            return (Criteria) this;
        }

        public Criteria andTfcCreatetimeIsNull() {
            addCriterion("tfc_createtime is null");
            return (Criteria) this;
        }

        public Criteria andTfcCreatetimeIsNotNull() {
            addCriterion("tfc_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andTfcCreatetimeEqualTo(String value) {
            addCriterion("tfc_createtime =", value, "tfcCreatetime");
            return (Criteria) this;
        }

        public Criteria andTfcCreatetimeNotEqualTo(String value) {
            addCriterion("tfc_createtime <>", value, "tfcCreatetime");
            return (Criteria) this;
        }

        public Criteria andTfcCreatetimeGreaterThan(String value) {
            addCriterion("tfc_createtime >", value, "tfcCreatetime");
            return (Criteria) this;
        }

        public Criteria andTfcCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("tfc_createtime >=", value, "tfcCreatetime");
            return (Criteria) this;
        }

        public Criteria andTfcCreatetimeLessThan(String value) {
            addCriterion("tfc_createtime <", value, "tfcCreatetime");
            return (Criteria) this;
        }

        public Criteria andTfcCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("tfc_createtime <=", value, "tfcCreatetime");
            return (Criteria) this;
        }

        public Criteria andTfcCreatetimeLike(String value) {
            addCriterion("tfc_createtime like", value, "tfcCreatetime");
            return (Criteria) this;
        }

        public Criteria andTfcCreatetimeNotLike(String value) {
            addCriterion("tfc_createtime not like", value, "tfcCreatetime");
            return (Criteria) this;
        }

        public Criteria andTfcCreatetimeIn(List<String> values) {
            addCriterion("tfc_createtime in", values, "tfcCreatetime");
            return (Criteria) this;
        }

        public Criteria andTfcCreatetimeNotIn(List<String> values) {
            addCriterion("tfc_createtime not in", values, "tfcCreatetime");
            return (Criteria) this;
        }

        public Criteria andTfcCreatetimeBetween(String value1, String value2) {
            addCriterion("tfc_createtime between", value1, value2, "tfcCreatetime");
            return (Criteria) this;
        }

        public Criteria andTfcCreatetimeNotBetween(String value1, String value2) {
            addCriterion("tfc_createtime not between", value1, value2, "tfcCreatetime");
            return (Criteria) this;
        }

        public Criteria andTfcCreateuserIsNull() {
            addCriterion("tfc_createuser is null");
            return (Criteria) this;
        }

        public Criteria andTfcCreateuserIsNotNull() {
            addCriterion("tfc_createuser is not null");
            return (Criteria) this;
        }

        public Criteria andTfcCreateuserEqualTo(String value) {
            addCriterion("tfc_createuser =", value, "tfcCreateuser");
            return (Criteria) this;
        }

        public Criteria andTfcCreateuserNotEqualTo(String value) {
            addCriterion("tfc_createuser <>", value, "tfcCreateuser");
            return (Criteria) this;
        }

        public Criteria andTfcCreateuserGreaterThan(String value) {
            addCriterion("tfc_createuser >", value, "tfcCreateuser");
            return (Criteria) this;
        }

        public Criteria andTfcCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("tfc_createuser >=", value, "tfcCreateuser");
            return (Criteria) this;
        }

        public Criteria andTfcCreateuserLessThan(String value) {
            addCriterion("tfc_createuser <", value, "tfcCreateuser");
            return (Criteria) this;
        }

        public Criteria andTfcCreateuserLessThanOrEqualTo(String value) {
            addCriterion("tfc_createuser <=", value, "tfcCreateuser");
            return (Criteria) this;
        }

        public Criteria andTfcCreateuserLike(String value) {
            addCriterion("tfc_createuser like", value, "tfcCreateuser");
            return (Criteria) this;
        }

        public Criteria andTfcCreateuserNotLike(String value) {
            addCriterion("tfc_createuser not like", value, "tfcCreateuser");
            return (Criteria) this;
        }

        public Criteria andTfcCreateuserIn(List<String> values) {
            addCriterion("tfc_createuser in", values, "tfcCreateuser");
            return (Criteria) this;
        }

        public Criteria andTfcCreateuserNotIn(List<String> values) {
            addCriterion("tfc_createuser not in", values, "tfcCreateuser");
            return (Criteria) this;
        }

        public Criteria andTfcCreateuserBetween(String value1, String value2) {
            addCriterion("tfc_createuser between", value1, value2, "tfcCreateuser");
            return (Criteria) this;
        }

        public Criteria andTfcCreateuserNotBetween(String value1, String value2) {
            addCriterion("tfc_createuser not between", value1, value2, "tfcCreateuser");
            return (Criteria) this;
        }

        public Criteria andTfcUpdatetimeIsNull() {
            addCriterion("tfc_updatetime is null");
            return (Criteria) this;
        }

        public Criteria andTfcUpdatetimeIsNotNull() {
            addCriterion("tfc_updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andTfcUpdatetimeEqualTo(String value) {
            addCriterion("tfc_updatetime =", value, "tfcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andTfcUpdatetimeNotEqualTo(String value) {
            addCriterion("tfc_updatetime <>", value, "tfcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andTfcUpdatetimeGreaterThan(String value) {
            addCriterion("tfc_updatetime >", value, "tfcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andTfcUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("tfc_updatetime >=", value, "tfcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andTfcUpdatetimeLessThan(String value) {
            addCriterion("tfc_updatetime <", value, "tfcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andTfcUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("tfc_updatetime <=", value, "tfcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andTfcUpdatetimeLike(String value) {
            addCriterion("tfc_updatetime like", value, "tfcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andTfcUpdatetimeNotLike(String value) {
            addCriterion("tfc_updatetime not like", value, "tfcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andTfcUpdatetimeIn(List<String> values) {
            addCriterion("tfc_updatetime in", values, "tfcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andTfcUpdatetimeNotIn(List<String> values) {
            addCriterion("tfc_updatetime not in", values, "tfcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andTfcUpdatetimeBetween(String value1, String value2) {
            addCriterion("tfc_updatetime between", value1, value2, "tfcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andTfcUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("tfc_updatetime not between", value1, value2, "tfcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andTfcUpdateuserIsNull() {
            addCriterion("tfc_updateuser is null");
            return (Criteria) this;
        }

        public Criteria andTfcUpdateuserIsNotNull() {
            addCriterion("tfc_updateuser is not null");
            return (Criteria) this;
        }

        public Criteria andTfcUpdateuserEqualTo(String value) {
            addCriterion("tfc_updateuser =", value, "tfcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTfcUpdateuserNotEqualTo(String value) {
            addCriterion("tfc_updateuser <>", value, "tfcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTfcUpdateuserGreaterThan(String value) {
            addCriterion("tfc_updateuser >", value, "tfcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTfcUpdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("tfc_updateuser >=", value, "tfcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTfcUpdateuserLessThan(String value) {
            addCriterion("tfc_updateuser <", value, "tfcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTfcUpdateuserLessThanOrEqualTo(String value) {
            addCriterion("tfc_updateuser <=", value, "tfcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTfcUpdateuserLike(String value) {
            addCriterion("tfc_updateuser like", value, "tfcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTfcUpdateuserNotLike(String value) {
            addCriterion("tfc_updateuser not like", value, "tfcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTfcUpdateuserIn(List<String> values) {
            addCriterion("tfc_updateuser in", values, "tfcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTfcUpdateuserNotIn(List<String> values) {
            addCriterion("tfc_updateuser not in", values, "tfcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTfcUpdateuserBetween(String value1, String value2) {
            addCriterion("tfc_updateuser between", value1, value2, "tfcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTfcUpdateuserNotBetween(String value1, String value2) {
            addCriterion("tfc_updateuser not between", value1, value2, "tfcUpdateuser");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andTfcCarCodeLikeInsensitive(String value) {
            addCriterion("upper(tfc_car_code) like", value.toUpperCase(), "tfcCarCode");
            return this;
        }

        public Criteria andTfcCreatetimeLikeInsensitive(String value) {
            addCriterion("upper(tfc_createtime) like", value.toUpperCase(), "tfcCreatetime");
            return this;
        }

        public Criteria andTfcCreateuserLikeInsensitive(String value) {
            addCriterion("upper(tfc_createuser) like", value.toUpperCase(), "tfcCreateuser");
            return this;
        }

        public Criteria andTfcUpdatetimeLikeInsensitive(String value) {
            addCriterion("upper(tfc_updatetime) like", value.toUpperCase(), "tfcUpdatetime");
            return this;
        }

        public Criteria andTfcUpdateuserLikeInsensitive(String value) {
            addCriterion("upper(tfc_updateuser) like", value.toUpperCase(), "tfcUpdateuser");
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