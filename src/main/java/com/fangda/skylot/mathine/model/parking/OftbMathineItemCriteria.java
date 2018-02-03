package com.fangda.skylot.mathine.model.parking;

import com.fangda.skylot.mathine.utils.Page;

import java.util.ArrayList;
import java.util.List;

public class OftbMathineItemCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public OftbMathineItemCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
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

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
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

        public Criteria andOmiIdIsNull() {
            addCriterion("omi_id is null");
            return (Criteria) this;
        }

        public Criteria andOmiIdIsNotNull() {
            addCriterion("omi_id is not null");
            return (Criteria) this;
        }

        public Criteria andOmiIdEqualTo(Integer value) {
            addCriterion("omi_id =", value, "omiId");
            return (Criteria) this;
        }

        public Criteria andOmiIdNotEqualTo(Integer value) {
            addCriterion("omi_id <>", value, "omiId");
            return (Criteria) this;
        }

        public Criteria andOmiIdGreaterThan(Integer value) {
            addCriterion("omi_id >", value, "omiId");
            return (Criteria) this;
        }

        public Criteria andOmiIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("omi_id >=", value, "omiId");
            return (Criteria) this;
        }

        public Criteria andOmiIdLessThan(Integer value) {
            addCriterion("omi_id <", value, "omiId");
            return (Criteria) this;
        }

        public Criteria andOmiIdLessThanOrEqualTo(Integer value) {
            addCriterion("omi_id <=", value, "omiId");
            return (Criteria) this;
        }

        public Criteria andOmiIdIn(List<Integer> values) {
            addCriterion("omi_id in", values, "omiId");
            return (Criteria) this;
        }

        public Criteria andOmiIdNotIn(List<Integer> values) {
            addCriterion("omi_id not in", values, "omiId");
            return (Criteria) this;
        }

        public Criteria andOmiIdBetween(Integer value1, Integer value2) {
            addCriterion("omi_id between", value1, value2, "omiId");
            return (Criteria) this;
        }

        public Criteria andOmiIdNotBetween(Integer value1, Integer value2) {
            addCriterion("omi_id not between", value1, value2, "omiId");
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

        public Criteria andOmiCodeIsNull() {
            addCriterion("omi_code is null");
            return (Criteria) this;
        }

        public Criteria andOmiCodeIsNotNull() {
            addCriterion("omi_code is not null");
            return (Criteria) this;
        }

        public Criteria andOmiCodeEqualTo(String value) {
            addCriterion("omi_code =", value, "omiCode");
            return (Criteria) this;
        }

        public Criteria andOmiCodeNotEqualTo(String value) {
            addCriterion("omi_code <>", value, "omiCode");
            return (Criteria) this;
        }

        public Criteria andOmiCodeGreaterThan(String value) {
            addCriterion("omi_code >", value, "omiCode");
            return (Criteria) this;
        }

        public Criteria andOmiCodeGreaterThanOrEqualTo(String value) {
            addCriterion("omi_code >=", value, "omiCode");
            return (Criteria) this;
        }

        public Criteria andOmiCodeLessThan(String value) {
            addCriterion("omi_code <", value, "omiCode");
            return (Criteria) this;
        }

        public Criteria andOmiCodeLessThanOrEqualTo(String value) {
            addCriterion("omi_code <=", value, "omiCode");
            return (Criteria) this;
        }

        public Criteria andOmiCodeLike(String value) {
            addCriterion("omi_code like", value, "omiCode");
            return (Criteria) this;
        }

        public Criteria andOmiCodeNotLike(String value) {
            addCriterion("omi_code not like", value, "omiCode");
            return (Criteria) this;
        }

        public Criteria andOmiCodeIn(List<String> values) {
            addCriterion("omi_code in", values, "omiCode");
            return (Criteria) this;
        }

        public Criteria andOmiCodeNotIn(List<String> values) {
            addCriterion("omi_code not in", values, "omiCode");
            return (Criteria) this;
        }

        public Criteria andOmiCodeBetween(String value1, String value2) {
            addCriterion("omi_code between", value1, value2, "omiCode");
            return (Criteria) this;
        }

        public Criteria andOmiCodeNotBetween(String value1, String value2) {
            addCriterion("omi_code not between", value1, value2, "omiCode");
            return (Criteria) this;
        }

        public Criteria andOmiPhysicalCodeIsNull() {
            addCriterion("omi_physical_code is null");
            return (Criteria) this;
        }

        public Criteria andOmiPhysicalCodeIsNotNull() {
            addCriterion("omi_physical_code is not null");
            return (Criteria) this;
        }

        public Criteria andOmiPhysicalCodeEqualTo(String value) {
            addCriterion("omi_physical_code =", value, "omiPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andOmiPhysicalCodeNotEqualTo(String value) {
            addCriterion("omi_physical_code <>", value, "omiPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andOmiPhysicalCodeGreaterThan(String value) {
            addCriterion("omi_physical_code >", value, "omiPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andOmiPhysicalCodeGreaterThanOrEqualTo(String value) {
            addCriterion("omi_physical_code >=", value, "omiPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andOmiPhysicalCodeLessThan(String value) {
            addCriterion("omi_physical_code <", value, "omiPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andOmiPhysicalCodeLessThanOrEqualTo(String value) {
            addCriterion("omi_physical_code <=", value, "omiPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andOmiPhysicalCodeLike(String value) {
            addCriterion("omi_physical_code like", value, "omiPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andOmiPhysicalCodeNotLike(String value) {
            addCriterion("omi_physical_code not like", value, "omiPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andOmiPhysicalCodeIn(List<String> values) {
            addCriterion("omi_physical_code in", values, "omiPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andOmiPhysicalCodeNotIn(List<String> values) {
            addCriterion("omi_physical_code not in", values, "omiPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andOmiPhysicalCodeBetween(String value1, String value2) {
            addCriterion("omi_physical_code between", value1, value2, "omiPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andOmiPhysicalCodeNotBetween(String value1, String value2) {
            addCriterion("omi_physical_code not between", value1, value2, "omiPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andOmiNameIsNull() {
            addCriterion("omi_name is null");
            return (Criteria) this;
        }

        public Criteria andOmiNameIsNotNull() {
            addCriterion("omi_name is not null");
            return (Criteria) this;
        }

        public Criteria andOmiNameEqualTo(String value) {
            addCriterion("omi_name =", value, "omiName");
            return (Criteria) this;
        }

        public Criteria andOmiNameNotEqualTo(String value) {
            addCriterion("omi_name <>", value, "omiName");
            return (Criteria) this;
        }

        public Criteria andOmiNameGreaterThan(String value) {
            addCriterion("omi_name >", value, "omiName");
            return (Criteria) this;
        }

        public Criteria andOmiNameGreaterThanOrEqualTo(String value) {
            addCriterion("omi_name >=", value, "omiName");
            return (Criteria) this;
        }

        public Criteria andOmiNameLessThan(String value) {
            addCriterion("omi_name <", value, "omiName");
            return (Criteria) this;
        }

        public Criteria andOmiNameLessThanOrEqualTo(String value) {
            addCriterion("omi_name <=", value, "omiName");
            return (Criteria) this;
        }

        public Criteria andOmiNameLike(String value) {
            addCriterion("omi_name like", value, "omiName");
            return (Criteria) this;
        }

        public Criteria andOmiNameNotLike(String value) {
            addCriterion("omi_name not like", value, "omiName");
            return (Criteria) this;
        }

        public Criteria andOmiNameIn(List<String> values) {
            addCriterion("omi_name in", values, "omiName");
            return (Criteria) this;
        }

        public Criteria andOmiNameNotIn(List<String> values) {
            addCriterion("omi_name not in", values, "omiName");
            return (Criteria) this;
        }

        public Criteria andOmiNameBetween(String value1, String value2) {
            addCriterion("omi_name between", value1, value2, "omiName");
            return (Criteria) this;
        }

        public Criteria andOmiNameNotBetween(String value1, String value2) {
            addCriterion("omi_name not between", value1, value2, "omiName");
            return (Criteria) this;
        }

        public Criteria andOmiRateIsNull() {
            addCriterion("omi_rate is null");
            return (Criteria) this;
        }

        public Criteria andOmiRateIsNotNull() {
            addCriterion("omi_rate is not null");
            return (Criteria) this;
        }

        public Criteria andOmiRateEqualTo(String value) {
            addCriterion("omi_rate =", value, "omiRate");
            return (Criteria) this;
        }

        public Criteria andOmiRateNotEqualTo(String value) {
            addCriterion("omi_rate <>", value, "omiRate");
            return (Criteria) this;
        }

        public Criteria andOmiRateGreaterThan(String value) {
            addCriterion("omi_rate >", value, "omiRate");
            return (Criteria) this;
        }

        public Criteria andOmiRateGreaterThanOrEqualTo(String value) {
            addCriterion("omi_rate >=", value, "omiRate");
            return (Criteria) this;
        }

        public Criteria andOmiRateLessThan(String value) {
            addCriterion("omi_rate <", value, "omiRate");
            return (Criteria) this;
        }

        public Criteria andOmiRateLessThanOrEqualTo(String value) {
            addCriterion("omi_rate <=", value, "omiRate");
            return (Criteria) this;
        }

        public Criteria andOmiRateLike(String value) {
            addCriterion("omi_rate like", value, "omiRate");
            return (Criteria) this;
        }

        public Criteria andOmiRateNotLike(String value) {
            addCriterion("omi_rate not like", value, "omiRate");
            return (Criteria) this;
        }

        public Criteria andOmiRateIn(List<String> values) {
            addCriterion("omi_rate in", values, "omiRate");
            return (Criteria) this;
        }

        public Criteria andOmiRateNotIn(List<String> values) {
            addCriterion("omi_rate not in", values, "omiRate");
            return (Criteria) this;
        }

        public Criteria andOmiRateBetween(String value1, String value2) {
            addCriterion("omi_rate between", value1, value2, "omiRate");
            return (Criteria) this;
        }

        public Criteria andOmiRateNotBetween(String value1, String value2) {
            addCriterion("omi_rate not between", value1, value2, "omiRate");
            return (Criteria) this;
        }

        public Criteria andOmiStartdateIsNull() {
            addCriterion("omi_startdate is null");
            return (Criteria) this;
        }

        public Criteria andOmiStartdateIsNotNull() {
            addCriterion("omi_startdate is not null");
            return (Criteria) this;
        }

        public Criteria andOmiStartdateEqualTo(String value) {
            addCriterion("omi_startdate =", value, "omiStartdate");
            return (Criteria) this;
        }

        public Criteria andOmiStartdateNotEqualTo(String value) {
            addCriterion("omi_startdate <>", value, "omiStartdate");
            return (Criteria) this;
        }

        public Criteria andOmiStartdateGreaterThan(String value) {
            addCriterion("omi_startdate >", value, "omiStartdate");
            return (Criteria) this;
        }

        public Criteria andOmiStartdateGreaterThanOrEqualTo(String value) {
            addCriterion("omi_startdate >=", value, "omiStartdate");
            return (Criteria) this;
        }

        public Criteria andOmiStartdateLessThan(String value) {
            addCriterion("omi_startdate <", value, "omiStartdate");
            return (Criteria) this;
        }

        public Criteria andOmiStartdateLessThanOrEqualTo(String value) {
            addCriterion("omi_startdate <=", value, "omiStartdate");
            return (Criteria) this;
        }

        public Criteria andOmiStartdateLike(String value) {
            addCriterion("omi_startdate like", value, "omiStartdate");
            return (Criteria) this;
        }

        public Criteria andOmiStartdateNotLike(String value) {
            addCriterion("omi_startdate not like", value, "omiStartdate");
            return (Criteria) this;
        }

        public Criteria andOmiStartdateIn(List<String> values) {
            addCriterion("omi_startdate in", values, "omiStartdate");
            return (Criteria) this;
        }

        public Criteria andOmiStartdateNotIn(List<String> values) {
            addCriterion("omi_startdate not in", values, "omiStartdate");
            return (Criteria) this;
        }

        public Criteria andOmiStartdateBetween(String value1, String value2) {
            addCriterion("omi_startdate between", value1, value2, "omiStartdate");
            return (Criteria) this;
        }

        public Criteria andOmiStartdateNotBetween(String value1, String value2) {
            addCriterion("omi_startdate not between", value1, value2, "omiStartdate");
            return (Criteria) this;
        }

        public Criteria andOmiEnddateIsNull() {
            addCriterion("omi_enddate is null");
            return (Criteria) this;
        }

        public Criteria andOmiEnddateIsNotNull() {
            addCriterion("omi_enddate is not null");
            return (Criteria) this;
        }

        public Criteria andOmiEnddateEqualTo(String value) {
            addCriterion("omi_enddate =", value, "omiEnddate");
            return (Criteria) this;
        }

        public Criteria andOmiEnddateNotEqualTo(String value) {
            addCriterion("omi_enddate <>", value, "omiEnddate");
            return (Criteria) this;
        }

        public Criteria andOmiEnddateGreaterThan(String value) {
            addCriterion("omi_enddate >", value, "omiEnddate");
            return (Criteria) this;
        }

        public Criteria andOmiEnddateGreaterThanOrEqualTo(String value) {
            addCriterion("omi_enddate >=", value, "omiEnddate");
            return (Criteria) this;
        }

        public Criteria andOmiEnddateLessThan(String value) {
            addCriterion("omi_enddate <", value, "omiEnddate");
            return (Criteria) this;
        }

        public Criteria andOmiEnddateLessThanOrEqualTo(String value) {
            addCriterion("omi_enddate <=", value, "omiEnddate");
            return (Criteria) this;
        }

        public Criteria andOmiEnddateLike(String value) {
            addCriterion("omi_enddate like", value, "omiEnddate");
            return (Criteria) this;
        }

        public Criteria andOmiEnddateNotLike(String value) {
            addCriterion("omi_enddate not like", value, "omiEnddate");
            return (Criteria) this;
        }

        public Criteria andOmiEnddateIn(List<String> values) {
            addCriterion("omi_enddate in", values, "omiEnddate");
            return (Criteria) this;
        }

        public Criteria andOmiEnddateNotIn(List<String> values) {
            addCriterion("omi_enddate not in", values, "omiEnddate");
            return (Criteria) this;
        }

        public Criteria andOmiEnddateBetween(String value1, String value2) {
            addCriterion("omi_enddate between", value1, value2, "omiEnddate");
            return (Criteria) this;
        }

        public Criteria andOmiEnddateNotBetween(String value1, String value2) {
            addCriterion("omi_enddate not between", value1, value2, "omiEnddate");
            return (Criteria) this;
        }

        public Criteria andOmiStatusIsNull() {
            addCriterion("omi_status is null");
            return (Criteria) this;
        }

        public Criteria andOmiStatusIsNotNull() {
            addCriterion("omi_status is not null");
            return (Criteria) this;
        }

        public Criteria andOmiStatusEqualTo(String value) {
            addCriterion("omi_status =", value, "omiStatus");
            return (Criteria) this;
        }

        public Criteria andOmiStatusNotEqualTo(String value) {
            addCriterion("omi_status <>", value, "omiStatus");
            return (Criteria) this;
        }

        public Criteria andOmiStatusGreaterThan(String value) {
            addCriterion("omi_status >", value, "omiStatus");
            return (Criteria) this;
        }

        public Criteria andOmiStatusGreaterThanOrEqualTo(String value) {
            addCriterion("omi_status >=", value, "omiStatus");
            return (Criteria) this;
        }

        public Criteria andOmiStatusLessThan(String value) {
            addCriterion("omi_status <", value, "omiStatus");
            return (Criteria) this;
        }

        public Criteria andOmiStatusLessThanOrEqualTo(String value) {
            addCriterion("omi_status <=", value, "omiStatus");
            return (Criteria) this;
        }

        public Criteria andOmiStatusLike(String value) {
            addCriterion("omi_status like", value, "omiStatus");
            return (Criteria) this;
        }

        public Criteria andOmiStatusNotLike(String value) {
            addCriterion("omi_status not like", value, "omiStatus");
            return (Criteria) this;
        }

        public Criteria andOmiStatusIn(List<String> values) {
            addCriterion("omi_status in", values, "omiStatus");
            return (Criteria) this;
        }

        public Criteria andOmiStatusNotIn(List<String> values) {
            addCriterion("omi_status not in", values, "omiStatus");
            return (Criteria) this;
        }

        public Criteria andOmiStatusBetween(String value1, String value2) {
            addCriterion("omi_status between", value1, value2, "omiStatus");
            return (Criteria) this;
        }

        public Criteria andOmiStatusNotBetween(String value1, String value2) {
            addCriterion("omi_status not between", value1, value2, "omiStatus");
            return (Criteria) this;
        }

        public Criteria andOmiCreateuserIsNull() {
            addCriterion("omi_createuser is null");
            return (Criteria) this;
        }

        public Criteria andOmiCreateuserIsNotNull() {
            addCriterion("omi_createuser is not null");
            return (Criteria) this;
        }

        public Criteria andOmiCreateuserEqualTo(String value) {
            addCriterion("omi_createuser =", value, "omiCreateuser");
            return (Criteria) this;
        }

        public Criteria andOmiCreateuserNotEqualTo(String value) {
            addCriterion("omi_createuser <>", value, "omiCreateuser");
            return (Criteria) this;
        }

        public Criteria andOmiCreateuserGreaterThan(String value) {
            addCriterion("omi_createuser >", value, "omiCreateuser");
            return (Criteria) this;
        }

        public Criteria andOmiCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("omi_createuser >=", value, "omiCreateuser");
            return (Criteria) this;
        }

        public Criteria andOmiCreateuserLessThan(String value) {
            addCriterion("omi_createuser <", value, "omiCreateuser");
            return (Criteria) this;
        }

        public Criteria andOmiCreateuserLessThanOrEqualTo(String value) {
            addCriterion("omi_createuser <=", value, "omiCreateuser");
            return (Criteria) this;
        }

        public Criteria andOmiCreateuserLike(String value) {
            addCriterion("omi_createuser like", value, "omiCreateuser");
            return (Criteria) this;
        }

        public Criteria andOmiCreateuserNotLike(String value) {
            addCriterion("omi_createuser not like", value, "omiCreateuser");
            return (Criteria) this;
        }

        public Criteria andOmiCreateuserIn(List<String> values) {
            addCriterion("omi_createuser in", values, "omiCreateuser");
            return (Criteria) this;
        }

        public Criteria andOmiCreateuserNotIn(List<String> values) {
            addCriterion("omi_createuser not in", values, "omiCreateuser");
            return (Criteria) this;
        }

        public Criteria andOmiCreateuserBetween(String value1, String value2) {
            addCriterion("omi_createuser between", value1, value2, "omiCreateuser");
            return (Criteria) this;
        }

        public Criteria andOmiCreateuserNotBetween(String value1, String value2) {
            addCriterion("omi_createuser not between", value1, value2, "omiCreateuser");
            return (Criteria) this;
        }

        public Criteria andOmiCreatedateIsNull() {
            addCriterion("omi_createdate is null");
            return (Criteria) this;
        }

        public Criteria andOmiCreatedateIsNotNull() {
            addCriterion("omi_createdate is not null");
            return (Criteria) this;
        }

        public Criteria andOmiCreatedateEqualTo(String value) {
            addCriterion("omi_createdate =", value, "omiCreatedate");
            return (Criteria) this;
        }

        public Criteria andOmiCreatedateNotEqualTo(String value) {
            addCriterion("omi_createdate <>", value, "omiCreatedate");
            return (Criteria) this;
        }

        public Criteria andOmiCreatedateGreaterThan(String value) {
            addCriterion("omi_createdate >", value, "omiCreatedate");
            return (Criteria) this;
        }

        public Criteria andOmiCreatedateGreaterThanOrEqualTo(String value) {
            addCriterion("omi_createdate >=", value, "omiCreatedate");
            return (Criteria) this;
        }

        public Criteria andOmiCreatedateLessThan(String value) {
            addCriterion("omi_createdate <", value, "omiCreatedate");
            return (Criteria) this;
        }

        public Criteria andOmiCreatedateLessThanOrEqualTo(String value) {
            addCriterion("omi_createdate <=", value, "omiCreatedate");
            return (Criteria) this;
        }

        public Criteria andOmiCreatedateLike(String value) {
            addCriterion("omi_createdate like", value, "omiCreatedate");
            return (Criteria) this;
        }

        public Criteria andOmiCreatedateNotLike(String value) {
            addCriterion("omi_createdate not like", value, "omiCreatedate");
            return (Criteria) this;
        }

        public Criteria andOmiCreatedateIn(List<String> values) {
            addCriterion("omi_createdate in", values, "omiCreatedate");
            return (Criteria) this;
        }

        public Criteria andOmiCreatedateNotIn(List<String> values) {
            addCriterion("omi_createdate not in", values, "omiCreatedate");
            return (Criteria) this;
        }

        public Criteria andOmiCreatedateBetween(String value1, String value2) {
            addCriterion("omi_createdate between", value1, value2, "omiCreatedate");
            return (Criteria) this;
        }

        public Criteria andOmiCreatedateNotBetween(String value1, String value2) {
            addCriterion("omi_createdate not between", value1, value2, "omiCreatedate");
            return (Criteria) this;
        }

        public Criteria andOmiUpdateuserIsNull() {
            addCriterion("omi_updateuser is null");
            return (Criteria) this;
        }

        public Criteria andOmiUpdateuserIsNotNull() {
            addCriterion("omi_updateuser is not null");
            return (Criteria) this;
        }

        public Criteria andOmiUpdateuserEqualTo(String value) {
            addCriterion("omi_updateuser =", value, "omiUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOmiUpdateuserNotEqualTo(String value) {
            addCriterion("omi_updateuser <>", value, "omiUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOmiUpdateuserGreaterThan(String value) {
            addCriterion("omi_updateuser >", value, "omiUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOmiUpdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("omi_updateuser >=", value, "omiUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOmiUpdateuserLessThan(String value) {
            addCriterion("omi_updateuser <", value, "omiUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOmiUpdateuserLessThanOrEqualTo(String value) {
            addCriterion("omi_updateuser <=", value, "omiUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOmiUpdateuserLike(String value) {
            addCriterion("omi_updateuser like", value, "omiUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOmiUpdateuserNotLike(String value) {
            addCriterion("omi_updateuser not like", value, "omiUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOmiUpdateuserIn(List<String> values) {
            addCriterion("omi_updateuser in", values, "omiUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOmiUpdateuserNotIn(List<String> values) {
            addCriterion("omi_updateuser not in", values, "omiUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOmiUpdateuserBetween(String value1, String value2) {
            addCriterion("omi_updateuser between", value1, value2, "omiUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOmiUpdateuserNotBetween(String value1, String value2) {
            addCriterion("omi_updateuser not between", value1, value2, "omiUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOmiUpdatedateIsNull() {
            addCriterion("omi_updatedate is null");
            return (Criteria) this;
        }

        public Criteria andOmiUpdatedateIsNotNull() {
            addCriterion("omi_updatedate is not null");
            return (Criteria) this;
        }

        public Criteria andOmiUpdatedateEqualTo(String value) {
            addCriterion("omi_updatedate =", value, "omiUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOmiUpdatedateNotEqualTo(String value) {
            addCriterion("omi_updatedate <>", value, "omiUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOmiUpdatedateGreaterThan(String value) {
            addCriterion("omi_updatedate >", value, "omiUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOmiUpdatedateGreaterThanOrEqualTo(String value) {
            addCriterion("omi_updatedate >=", value, "omiUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOmiUpdatedateLessThan(String value) {
            addCriterion("omi_updatedate <", value, "omiUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOmiUpdatedateLessThanOrEqualTo(String value) {
            addCriterion("omi_updatedate <=", value, "omiUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOmiUpdatedateLike(String value) {
            addCriterion("omi_updatedate like", value, "omiUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOmiUpdatedateNotLike(String value) {
            addCriterion("omi_updatedate not like", value, "omiUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOmiUpdatedateIn(List<String> values) {
            addCriterion("omi_updatedate in", values, "omiUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOmiUpdatedateNotIn(List<String> values) {
            addCriterion("omi_updatedate not in", values, "omiUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOmiUpdatedateBetween(String value1, String value2) {
            addCriterion("omi_updatedate between", value1, value2, "omiUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOmiUpdatedateNotBetween(String value1, String value2) {
            addCriterion("omi_updatedate not between", value1, value2, "omiUpdatedate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andOmiCodeLikeInsensitive(String value) {
            addCriterion("upper(omi_code) like", value.toUpperCase(), "omiCode");
            return this;
        }

        public Criteria andOmiPhysicalCodeLikeInsensitive(String value) {
            addCriterion("upper(omi_physical_code) like", value.toUpperCase(), "omiPhysicalCode");
            return this;
        }

        public Criteria andOmiNameLikeInsensitive(String value) {
            addCriterion("upper(omi_name) like", value.toUpperCase(), "omiName");
            return this;
        }

        public Criteria andOmiRateLikeInsensitive(String value) {
            addCriterion("upper(omi_rate) like", value.toUpperCase(), "omiRate");
            return this;
        }

        public Criteria andOmiStartdateLikeInsensitive(String value) {
            addCriterion("upper(omi_startdate) like", value.toUpperCase(), "omiStartdate");
            return this;
        }

        public Criteria andOmiEnddateLikeInsensitive(String value) {
            addCriterion("upper(omi_enddate) like", value.toUpperCase(), "omiEnddate");
            return this;
        }

        public Criteria andOmiStatusLikeInsensitive(String value) {
            addCriterion("upper(omi_status) like", value.toUpperCase(), "omiStatus");
            return this;
        }

        public Criteria andOmiCreateuserLikeInsensitive(String value) {
            addCriterion("upper(omi_createuser) like", value.toUpperCase(), "omiCreateuser");
            return this;
        }

        public Criteria andOmiCreatedateLikeInsensitive(String value) {
            addCriterion("upper(omi_createdate) like", value.toUpperCase(), "omiCreatedate");
            return this;
        }

        public Criteria andOmiUpdateuserLikeInsensitive(String value) {
            addCriterion("upper(omi_updateuser) like", value.toUpperCase(), "omiUpdateuser");
            return this;
        }

        public Criteria andOmiUpdatedateLikeInsensitive(String value) {
            addCriterion("upper(omi_updatedate) like", value.toUpperCase(), "omiUpdatedate");
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
    }
}