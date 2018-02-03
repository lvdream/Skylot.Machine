package com.fangda.skylot.mathine.model.customer;

import com.fangda.skylot.mathine.utils.Page;

import java.util.ArrayList;
import java.util.List;

public class OftbReserveTakingCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public OftbReserveTakingCriteria() {
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

        public Criteria andOrtIdIsNull() {
            addCriterion("ort_id is null");
            return (Criteria) this;
        }

        public Criteria andOrtIdIsNotNull() {
            addCriterion("ort_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrtIdEqualTo(Integer value) {
            addCriterion("ort_id =", value, "ortId");
            return (Criteria) this;
        }

        public Criteria andOrtIdNotEqualTo(Integer value) {
            addCriterion("ort_id <>", value, "ortId");
            return (Criteria) this;
        }

        public Criteria andOrtIdGreaterThan(Integer value) {
            addCriterion("ort_id >", value, "ortId");
            return (Criteria) this;
        }

        public Criteria andOrtIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ort_id >=", value, "ortId");
            return (Criteria) this;
        }

        public Criteria andOrtIdLessThan(Integer value) {
            addCriterion("ort_id <", value, "ortId");
            return (Criteria) this;
        }

        public Criteria andOrtIdLessThanOrEqualTo(Integer value) {
            addCriterion("ort_id <=", value, "ortId");
            return (Criteria) this;
        }

        public Criteria andOrtIdIn(List<Integer> values) {
            addCriterion("ort_id in", values, "ortId");
            return (Criteria) this;
        }

        public Criteria andOrtIdNotIn(List<Integer> values) {
            addCriterion("ort_id not in", values, "ortId");
            return (Criteria) this;
        }

        public Criteria andOrtIdBetween(Integer value1, Integer value2) {
            addCriterion("ort_id between", value1, value2, "ortId");
            return (Criteria) this;
        }

        public Criteria andOrtIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ort_id not between", value1, value2, "ortId");
            return (Criteria) this;
        }

        public Criteria andMcIdIsNull() {
            addCriterion("mc_id is null");
            return (Criteria) this;
        }

        public Criteria andMcIdIsNotNull() {
            addCriterion("mc_id is not null");
            return (Criteria) this;
        }

        public Criteria andMcIdEqualTo(Integer value) {
            addCriterion("mc_id =", value, "mcId");
            return (Criteria) this;
        }

        public Criteria andMcIdNotEqualTo(Integer value) {
            addCriterion("mc_id <>", value, "mcId");
            return (Criteria) this;
        }

        public Criteria andMcIdGreaterThan(Integer value) {
            addCriterion("mc_id >", value, "mcId");
            return (Criteria) this;
        }

        public Criteria andMcIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mc_id >=", value, "mcId");
            return (Criteria) this;
        }

        public Criteria andMcIdLessThan(Integer value) {
            addCriterion("mc_id <", value, "mcId");
            return (Criteria) this;
        }

        public Criteria andMcIdLessThanOrEqualTo(Integer value) {
            addCriterion("mc_id <=", value, "mcId");
            return (Criteria) this;
        }

        public Criteria andMcIdIn(List<Integer> values) {
            addCriterion("mc_id in", values, "mcId");
            return (Criteria) this;
        }

        public Criteria andMcIdNotIn(List<Integer> values) {
            addCriterion("mc_id not in", values, "mcId");
            return (Criteria) this;
        }

        public Criteria andMcIdBetween(Integer value1, Integer value2) {
            addCriterion("mc_id between", value1, value2, "mcId");
            return (Criteria) this;
        }

        public Criteria andMcIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mc_id not between", value1, value2, "mcId");
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

        public Criteria andImaIdLike(String value) {
            addCriterion("ima_id like", value, "imaId");
            return (Criteria) this;
        }

        public Criteria andImaIdNotLike(String value) {
            addCriterion("ima_id not like", value, "imaId");
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

        public Criteria andOrtPhysicalCodeIsNull() {
            addCriterion("ort_physical_code is null");
            return (Criteria) this;
        }

        public Criteria andOrtPhysicalCodeIsNotNull() {
            addCriterion("ort_physical_code is not null");
            return (Criteria) this;
        }

        public Criteria andOrtPhysicalCodeEqualTo(String value) {
            addCriterion("ort_physical_code =", value, "ortPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andOrtPhysicalCodeNotEqualTo(String value) {
            addCriterion("ort_physical_code <>", value, "ortPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andOrtPhysicalCodeGreaterThan(String value) {
            addCriterion("ort_physical_code >", value, "ortPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andOrtPhysicalCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ort_physical_code >=", value, "ortPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andOrtPhysicalCodeLessThan(String value) {
            addCriterion("ort_physical_code <", value, "ortPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andOrtPhysicalCodeLessThanOrEqualTo(String value) {
            addCriterion("ort_physical_code <=", value, "ortPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andOrtPhysicalCodeLike(String value) {
            addCriterion("ort_physical_code like", value, "ortPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andOrtPhysicalCodeNotLike(String value) {
            addCriterion("ort_physical_code not like", value, "ortPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andOrtPhysicalCodeIn(List<String> values) {
            addCriterion("ort_physical_code in", values, "ortPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andOrtPhysicalCodeNotIn(List<String> values) {
            addCriterion("ort_physical_code not in", values, "ortPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andOrtPhysicalCodeBetween(String value1, String value2) {
            addCriterion("ort_physical_code between", value1, value2, "ortPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andOrtPhysicalCodeNotBetween(String value1, String value2) {
            addCriterion("ort_physical_code not between", value1, value2, "ortPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andOrtReserveTimeIsNull() {
            addCriterion("ort_reserve_time is null");
            return (Criteria) this;
        }

        public Criteria andOrtReserveTimeIsNotNull() {
            addCriterion("ort_reserve_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrtReserveTimeEqualTo(String value) {
            addCriterion("ort_reserve_time =", value, "ortReserveTime");
            return (Criteria) this;
        }

        public Criteria andOrtReserveTimeNotEqualTo(String value) {
            addCriterion("ort_reserve_time <>", value, "ortReserveTime");
            return (Criteria) this;
        }

        public Criteria andOrtReserveTimeGreaterThan(String value) {
            addCriterion("ort_reserve_time >", value, "ortReserveTime");
            return (Criteria) this;
        }

        public Criteria andOrtReserveTimeGreaterThanOrEqualTo(String value) {
            addCriterion("ort_reserve_time >=", value, "ortReserveTime");
            return (Criteria) this;
        }

        public Criteria andOrtReserveTimeLessThan(String value) {
            addCriterion("ort_reserve_time <", value, "ortReserveTime");
            return (Criteria) this;
        }

        public Criteria andOrtReserveTimeLessThanOrEqualTo(String value) {
            addCriterion("ort_reserve_time <=", value, "ortReserveTime");
            return (Criteria) this;
        }

        public Criteria andOrtReserveTimeLike(String value) {
            addCriterion("ort_reserve_time like", value, "ortReserveTime");
            return (Criteria) this;
        }

        public Criteria andOrtReserveTimeNotLike(String value) {
            addCriterion("ort_reserve_time not like", value, "ortReserveTime");
            return (Criteria) this;
        }

        public Criteria andOrtReserveTimeIn(List<String> values) {
            addCriterion("ort_reserve_time in", values, "ortReserveTime");
            return (Criteria) this;
        }

        public Criteria andOrtReserveTimeNotIn(List<String> values) {
            addCriterion("ort_reserve_time not in", values, "ortReserveTime");
            return (Criteria) this;
        }

        public Criteria andOrtReserveTimeBetween(String value1, String value2) {
            addCriterion("ort_reserve_time between", value1, value2, "ortReserveTime");
            return (Criteria) this;
        }

        public Criteria andOrtReserveTimeNotBetween(String value1, String value2) {
            addCriterion("ort_reserve_time not between", value1, value2, "ortReserveTime");
            return (Criteria) this;
        }

        public Criteria andOrtStatusIsNull() {
            addCriterion("ort_status is null");
            return (Criteria) this;
        }

        public Criteria andOrtStatusIsNotNull() {
            addCriterion("ort_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrtStatusEqualTo(String value) {
            addCriterion("ort_status =", value, "ortStatus");
            return (Criteria) this;
        }

        public Criteria andOrtStatusNotEqualTo(String value) {
            addCriterion("ort_status <>", value, "ortStatus");
            return (Criteria) this;
        }

        public Criteria andOrtStatusGreaterThan(String value) {
            addCriterion("ort_status >", value, "ortStatus");
            return (Criteria) this;
        }

        public Criteria andOrtStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ort_status >=", value, "ortStatus");
            return (Criteria) this;
        }

        public Criteria andOrtStatusLessThan(String value) {
            addCriterion("ort_status <", value, "ortStatus");
            return (Criteria) this;
        }

        public Criteria andOrtStatusLessThanOrEqualTo(String value) {
            addCriterion("ort_status <=", value, "ortStatus");
            return (Criteria) this;
        }

        public Criteria andOrtStatusLike(String value) {
            addCriterion("ort_status like", value, "ortStatus");
            return (Criteria) this;
        }

        public Criteria andOrtStatusNotLike(String value) {
            addCriterion("ort_status not like", value, "ortStatus");
            return (Criteria) this;
        }

        public Criteria andOrtStatusIn(List<String> values) {
            addCriterion("ort_status in", values, "ortStatus");
            return (Criteria) this;
        }

        public Criteria andOrtStatusNotIn(List<String> values) {
            addCriterion("ort_status not in", values, "ortStatus");
            return (Criteria) this;
        }

        public Criteria andOrtStatusBetween(String value1, String value2) {
            addCriterion("ort_status between", value1, value2, "ortStatus");
            return (Criteria) this;
        }

        public Criteria andOrtStatusNotBetween(String value1, String value2) {
            addCriterion("ort_status not between", value1, value2, "ortStatus");
            return (Criteria) this;
        }

        public Criteria andOrtCreatedateIsNull() {
            addCriterion("ort_createdate is null");
            return (Criteria) this;
        }

        public Criteria andOrtCreatedateIsNotNull() {
            addCriterion("ort_createdate is not null");
            return (Criteria) this;
        }

        public Criteria andOrtCreatedateEqualTo(String value) {
            addCriterion("ort_createdate =", value, "ortCreatedate");
            return (Criteria) this;
        }

        public Criteria andOrtCreatedateNotEqualTo(String value) {
            addCriterion("ort_createdate <>", value, "ortCreatedate");
            return (Criteria) this;
        }

        public Criteria andOrtCreatedateGreaterThan(String value) {
            addCriterion("ort_createdate >", value, "ortCreatedate");
            return (Criteria) this;
        }

        public Criteria andOrtCreatedateGreaterThanOrEqualTo(String value) {
            addCriterion("ort_createdate >=", value, "ortCreatedate");
            return (Criteria) this;
        }

        public Criteria andOrtCreatedateLessThan(String value) {
            addCriterion("ort_createdate <", value, "ortCreatedate");
            return (Criteria) this;
        }

        public Criteria andOrtCreatedateLessThanOrEqualTo(String value) {
            addCriterion("ort_createdate <=", value, "ortCreatedate");
            return (Criteria) this;
        }

        public Criteria andOrtCreatedateLike(String value) {
            addCriterion("ort_createdate like", value, "ortCreatedate");
            return (Criteria) this;
        }

        public Criteria andOrtCreatedateNotLike(String value) {
            addCriterion("ort_createdate not like", value, "ortCreatedate");
            return (Criteria) this;
        }

        public Criteria andOrtCreatedateIn(List<String> values) {
            addCriterion("ort_createdate in", values, "ortCreatedate");
            return (Criteria) this;
        }

        public Criteria andOrtCreatedateNotIn(List<String> values) {
            addCriterion("ort_createdate not in", values, "ortCreatedate");
            return (Criteria) this;
        }

        public Criteria andOrtCreatedateBetween(String value1, String value2) {
            addCriterion("ort_createdate between", value1, value2, "ortCreatedate");
            return (Criteria) this;
        }

        public Criteria andOrtCreatedateNotBetween(String value1, String value2) {
            addCriterion("ort_createdate not between", value1, value2, "ortCreatedate");
            return (Criteria) this;
        }

        public Criteria andOrtCreateuserIsNull() {
            addCriterion("ort_createuser is null");
            return (Criteria) this;
        }

        public Criteria andOrtCreateuserIsNotNull() {
            addCriterion("ort_createuser is not null");
            return (Criteria) this;
        }

        public Criteria andOrtCreateuserEqualTo(String value) {
            addCriterion("ort_createuser =", value, "ortCreateuser");
            return (Criteria) this;
        }

        public Criteria andOrtCreateuserNotEqualTo(String value) {
            addCriterion("ort_createuser <>", value, "ortCreateuser");
            return (Criteria) this;
        }

        public Criteria andOrtCreateuserGreaterThan(String value) {
            addCriterion("ort_createuser >", value, "ortCreateuser");
            return (Criteria) this;
        }

        public Criteria andOrtCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("ort_createuser >=", value, "ortCreateuser");
            return (Criteria) this;
        }

        public Criteria andOrtCreateuserLessThan(String value) {
            addCriterion("ort_createuser <", value, "ortCreateuser");
            return (Criteria) this;
        }

        public Criteria andOrtCreateuserLessThanOrEqualTo(String value) {
            addCriterion("ort_createuser <=", value, "ortCreateuser");
            return (Criteria) this;
        }

        public Criteria andOrtCreateuserLike(String value) {
            addCriterion("ort_createuser like", value, "ortCreateuser");
            return (Criteria) this;
        }

        public Criteria andOrtCreateuserNotLike(String value) {
            addCriterion("ort_createuser not like", value, "ortCreateuser");
            return (Criteria) this;
        }

        public Criteria andOrtCreateuserIn(List<String> values) {
            addCriterion("ort_createuser in", values, "ortCreateuser");
            return (Criteria) this;
        }

        public Criteria andOrtCreateuserNotIn(List<String> values) {
            addCriterion("ort_createuser not in", values, "ortCreateuser");
            return (Criteria) this;
        }

        public Criteria andOrtCreateuserBetween(String value1, String value2) {
            addCriterion("ort_createuser between", value1, value2, "ortCreateuser");
            return (Criteria) this;
        }

        public Criteria andOrtCreateuserNotBetween(String value1, String value2) {
            addCriterion("ort_createuser not between", value1, value2, "ortCreateuser");
            return (Criteria) this;
        }

        public Criteria andOrtUpdatedateIsNull() {
            addCriterion("ort_updatedate is null");
            return (Criteria) this;
        }

        public Criteria andOrtUpdatedateIsNotNull() {
            addCriterion("ort_updatedate is not null");
            return (Criteria) this;
        }

        public Criteria andOrtUpdatedateEqualTo(String value) {
            addCriterion("ort_updatedate =", value, "ortUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOrtUpdatedateNotEqualTo(String value) {
            addCriterion("ort_updatedate <>", value, "ortUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOrtUpdatedateGreaterThan(String value) {
            addCriterion("ort_updatedate >", value, "ortUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOrtUpdatedateGreaterThanOrEqualTo(String value) {
            addCriterion("ort_updatedate >=", value, "ortUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOrtUpdatedateLessThan(String value) {
            addCriterion("ort_updatedate <", value, "ortUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOrtUpdatedateLessThanOrEqualTo(String value) {
            addCriterion("ort_updatedate <=", value, "ortUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOrtUpdatedateLike(String value) {
            addCriterion("ort_updatedate like", value, "ortUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOrtUpdatedateNotLike(String value) {
            addCriterion("ort_updatedate not like", value, "ortUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOrtUpdatedateIn(List<String> values) {
            addCriterion("ort_updatedate in", values, "ortUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOrtUpdatedateNotIn(List<String> values) {
            addCriterion("ort_updatedate not in", values, "ortUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOrtUpdatedateBetween(String value1, String value2) {
            addCriterion("ort_updatedate between", value1, value2, "ortUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOrtUpdatedateNotBetween(String value1, String value2) {
            addCriterion("ort_updatedate not between", value1, value2, "ortUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOrtUpdateuserIsNull() {
            addCriterion("ort_updateuser is null");
            return (Criteria) this;
        }

        public Criteria andOrtUpdateuserIsNotNull() {
            addCriterion("ort_updateuser is not null");
            return (Criteria) this;
        }

        public Criteria andOrtUpdateuserEqualTo(String value) {
            addCriterion("ort_updateuser =", value, "ortUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOrtUpdateuserNotEqualTo(String value) {
            addCriterion("ort_updateuser <>", value, "ortUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOrtUpdateuserGreaterThan(String value) {
            addCriterion("ort_updateuser >", value, "ortUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOrtUpdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("ort_updateuser >=", value, "ortUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOrtUpdateuserLessThan(String value) {
            addCriterion("ort_updateuser <", value, "ortUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOrtUpdateuserLessThanOrEqualTo(String value) {
            addCriterion("ort_updateuser <=", value, "ortUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOrtUpdateuserLike(String value) {
            addCriterion("ort_updateuser like", value, "ortUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOrtUpdateuserNotLike(String value) {
            addCriterion("ort_updateuser not like", value, "ortUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOrtUpdateuserIn(List<String> values) {
            addCriterion("ort_updateuser in", values, "ortUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOrtUpdateuserNotIn(List<String> values) {
            addCriterion("ort_updateuser not in", values, "ortUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOrtUpdateuserBetween(String value1, String value2) {
            addCriterion("ort_updateuser between", value1, value2, "ortUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOrtUpdateuserNotBetween(String value1, String value2) {
            addCriterion("ort_updateuser not between", value1, value2, "ortUpdateuser");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andImaIdLikeInsensitive(String value) {
            addCriterion("upper(ima_id) like", value.toUpperCase(), "imaId");
            return this;
        }

        public Criteria andOrtPhysicalCodeLikeInsensitive(String value) {
            addCriterion("upper(ort_physical_code) like", value.toUpperCase(), "ortPhysicalCode");
            return this;
        }

        public Criteria andOrtReserveTimeLikeInsensitive(String value) {
            addCriterion("upper(ort_reserve_time) like", value.toUpperCase(), "ortReserveTime");
            return this;
        }

        public Criteria andOrtStatusLikeInsensitive(String value) {
            addCriterion("upper(ort_status) like", value.toUpperCase(), "ortStatus");
            return this;
        }

        public Criteria andOrtCreatedateLikeInsensitive(String value) {
            addCriterion("upper(ort_createdate) like", value.toUpperCase(), "ortCreatedate");
            return this;
        }

        public Criteria andOrtCreateuserLikeInsensitive(String value) {
            addCriterion("upper(ort_createuser) like", value.toUpperCase(), "ortCreateuser");
            return this;
        }

        public Criteria andOrtUpdatedateLikeInsensitive(String value) {
            addCriterion("upper(ort_updatedate) like", value.toUpperCase(), "ortUpdatedate");
            return this;
        }

        public Criteria andOrtUpdateuserLikeInsensitive(String value) {
            addCriterion("upper(ort_updateuser) like", value.toUpperCase(), "ortUpdateuser");
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