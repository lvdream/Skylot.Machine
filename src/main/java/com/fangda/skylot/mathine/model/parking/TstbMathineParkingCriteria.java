package com.fangda.skylot.mathine.model.parking;

import com.fangda.skylot.mathine.utils.Page;

import java.util.ArrayList;
import java.util.List;

public class TstbMathineParkingCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public TstbMathineParkingCriteria() {
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

        public Criteria andTmpIdIsNull() {
            addCriterion("tmp_id is null");
            return (Criteria) this;
        }

        public Criteria andTmpIdIsNotNull() {
            addCriterion("tmp_id is not null");
            return (Criteria) this;
        }

        public Criteria andTmpIdEqualTo(Integer value) {
            addCriterion("tmp_id =", value, "tmpId");
            return (Criteria) this;
        }

        public Criteria andTmpIdNotEqualTo(Integer value) {
            addCriterion("tmp_id <>", value, "tmpId");
            return (Criteria) this;
        }

        public Criteria andTmpIdGreaterThan(Integer value) {
            addCriterion("tmp_id >", value, "tmpId");
            return (Criteria) this;
        }

        public Criteria andTmpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tmp_id >=", value, "tmpId");
            return (Criteria) this;
        }

        public Criteria andTmpIdLessThan(Integer value) {
            addCriterion("tmp_id <", value, "tmpId");
            return (Criteria) this;
        }

        public Criteria andTmpIdLessThanOrEqualTo(Integer value) {
            addCriterion("tmp_id <=", value, "tmpId");
            return (Criteria) this;
        }

        public Criteria andTmpIdIn(List<Integer> values) {
            addCriterion("tmp_id in", values, "tmpId");
            return (Criteria) this;
        }

        public Criteria andTmpIdNotIn(List<Integer> values) {
            addCriterion("tmp_id not in", values, "tmpId");
            return (Criteria) this;
        }

        public Criteria andTmpIdBetween(Integer value1, Integer value2) {
            addCriterion("tmp_id between", value1, value2, "tmpId");
            return (Criteria) this;
        }

        public Criteria andTmpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tmp_id not between", value1, value2, "tmpId");
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

        public Criteria andTmpCodeIsNull() {
            addCriterion("tmp_code is null");
            return (Criteria) this;
        }

        public Criteria andTmpCodeIsNotNull() {
            addCriterion("tmp_code is not null");
            return (Criteria) this;
        }

        public Criteria andTmpCodeEqualTo(String value) {
            addCriterion("tmp_code =", value, "tmpCode");
            return (Criteria) this;
        }

        public Criteria andTmpCodeNotEqualTo(String value) {
            addCriterion("tmp_code <>", value, "tmpCode");
            return (Criteria) this;
        }

        public Criteria andTmpCodeGreaterThan(String value) {
            addCriterion("tmp_code >", value, "tmpCode");
            return (Criteria) this;
        }

        public Criteria andTmpCodeGreaterThanOrEqualTo(String value) {
            addCriterion("tmp_code >=", value, "tmpCode");
            return (Criteria) this;
        }

        public Criteria andTmpCodeLessThan(String value) {
            addCriterion("tmp_code <", value, "tmpCode");
            return (Criteria) this;
        }

        public Criteria andTmpCodeLessThanOrEqualTo(String value) {
            addCriterion("tmp_code <=", value, "tmpCode");
            return (Criteria) this;
        }

        public Criteria andTmpCodeLike(String value) {
            addCriterion("tmp_code like", value, "tmpCode");
            return (Criteria) this;
        }

        public Criteria andTmpCodeNotLike(String value) {
            addCriterion("tmp_code not like", value, "tmpCode");
            return (Criteria) this;
        }

        public Criteria andTmpCodeIn(List<String> values) {
            addCriterion("tmp_code in", values, "tmpCode");
            return (Criteria) this;
        }

        public Criteria andTmpCodeNotIn(List<String> values) {
            addCriterion("tmp_code not in", values, "tmpCode");
            return (Criteria) this;
        }

        public Criteria andTmpCodeBetween(String value1, String value2) {
            addCriterion("tmp_code between", value1, value2, "tmpCode");
            return (Criteria) this;
        }

        public Criteria andTmpCodeNotBetween(String value1, String value2) {
            addCriterion("tmp_code not between", value1, value2, "tmpCode");
            return (Criteria) this;
        }

        public Criteria andTmpPhysicalCodeIsNull() {
            addCriterion("tmp_physical_code is null");
            return (Criteria) this;
        }

        public Criteria andTmpPhysicalCodeIsNotNull() {
            addCriterion("tmp_physical_code is not null");
            return (Criteria) this;
        }

        public Criteria andTmpPhysicalCodeEqualTo(String value) {
            addCriterion("tmp_physical_code =", value, "tmpPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andTmpPhysicalCodeNotEqualTo(String value) {
            addCriterion("tmp_physical_code <>", value, "tmpPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andTmpPhysicalCodeGreaterThan(String value) {
            addCriterion("tmp_physical_code >", value, "tmpPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andTmpPhysicalCodeGreaterThanOrEqualTo(String value) {
            addCriterion("tmp_physical_code >=", value, "tmpPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andTmpPhysicalCodeLessThan(String value) {
            addCriterion("tmp_physical_code <", value, "tmpPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andTmpPhysicalCodeLessThanOrEqualTo(String value) {
            addCriterion("tmp_physical_code <=", value, "tmpPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andTmpPhysicalCodeLike(String value) {
            addCriterion("tmp_physical_code like", value, "tmpPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andTmpPhysicalCodeNotLike(String value) {
            addCriterion("tmp_physical_code not like", value, "tmpPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andTmpPhysicalCodeIn(List<String> values) {
            addCriterion("tmp_physical_code in", values, "tmpPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andTmpPhysicalCodeNotIn(List<String> values) {
            addCriterion("tmp_physical_code not in", values, "tmpPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andTmpPhysicalCodeBetween(String value1, String value2) {
            addCriterion("tmp_physical_code between", value1, value2, "tmpPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andTmpPhysicalCodeNotBetween(String value1, String value2) {
            addCriterion("tmp_physical_code not between", value1, value2, "tmpPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andTmpCarCodeIsNull() {
            addCriterion("tmp_car_code is null");
            return (Criteria) this;
        }

        public Criteria andTmpCarCodeIsNotNull() {
            addCriterion("tmp_car_code is not null");
            return (Criteria) this;
        }

        public Criteria andTmpCarCodeEqualTo(String value) {
            addCriterion("tmp_car_code =", value, "tmpCarCode");
            return (Criteria) this;
        }

        public Criteria andTmpCarCodeNotEqualTo(String value) {
            addCriterion("tmp_car_code <>", value, "tmpCarCode");
            return (Criteria) this;
        }

        public Criteria andTmpCarCodeGreaterThan(String value) {
            addCriterion("tmp_car_code >", value, "tmpCarCode");
            return (Criteria) this;
        }

        public Criteria andTmpCarCodeGreaterThanOrEqualTo(String value) {
            addCriterion("tmp_car_code >=", value, "tmpCarCode");
            return (Criteria) this;
        }

        public Criteria andTmpCarCodeLessThan(String value) {
            addCriterion("tmp_car_code <", value, "tmpCarCode");
            return (Criteria) this;
        }

        public Criteria andTmpCarCodeLessThanOrEqualTo(String value) {
            addCriterion("tmp_car_code <=", value, "tmpCarCode");
            return (Criteria) this;
        }

        public Criteria andTmpCarCodeLike(String value) {
            addCriterion("tmp_car_code like", value, "tmpCarCode");
            return (Criteria) this;
        }

        public Criteria andTmpCarCodeNotLike(String value) {
            addCriterion("tmp_car_code not like", value, "tmpCarCode");
            return (Criteria) this;
        }

        public Criteria andTmpCarCodeIn(List<String> values) {
            addCriterion("tmp_car_code in", values, "tmpCarCode");
            return (Criteria) this;
        }

        public Criteria andTmpCarCodeNotIn(List<String> values) {
            addCriterion("tmp_car_code not in", values, "tmpCarCode");
            return (Criteria) this;
        }

        public Criteria andTmpCarCodeBetween(String value1, String value2) {
            addCriterion("tmp_car_code between", value1, value2, "tmpCarCode");
            return (Criteria) this;
        }

        public Criteria andTmpCarCodeNotBetween(String value1, String value2) {
            addCriterion("tmp_car_code not between", value1, value2, "tmpCarCode");
            return (Criteria) this;
        }

        public Criteria andTmpStatusIsNull() {
            addCriterion("tmp_status is null");
            return (Criteria) this;
        }

        public Criteria andTmpStatusIsNotNull() {
            addCriterion("tmp_status is not null");
            return (Criteria) this;
        }

        public Criteria andTmpStatusEqualTo(String value) {
            addCriterion("tmp_status =", value, "tmpStatus");
            return (Criteria) this;
        }

        public Criteria andTmpStatusNotEqualTo(String value) {
            addCriterion("tmp_status <>", value, "tmpStatus");
            return (Criteria) this;
        }

        public Criteria andTmpStatusGreaterThan(String value) {
            addCriterion("tmp_status >", value, "tmpStatus");
            return (Criteria) this;
        }

        public Criteria andTmpStatusGreaterThanOrEqualTo(String value) {
            addCriterion("tmp_status >=", value, "tmpStatus");
            return (Criteria) this;
        }

        public Criteria andTmpStatusLessThan(String value) {
            addCriterion("tmp_status <", value, "tmpStatus");
            return (Criteria) this;
        }

        public Criteria andTmpStatusLessThanOrEqualTo(String value) {
            addCriterion("tmp_status <=", value, "tmpStatus");
            return (Criteria) this;
        }

        public Criteria andTmpStatusLike(String value) {
            addCriterion("tmp_status like", value, "tmpStatus");
            return (Criteria) this;
        }

        public Criteria andTmpStatusNotLike(String value) {
            addCriterion("tmp_status not like", value, "tmpStatus");
            return (Criteria) this;
        }

        public Criteria andTmpStatusIn(List<String> values) {
            addCriterion("tmp_status in", values, "tmpStatus");
            return (Criteria) this;
        }

        public Criteria andTmpStatusNotIn(List<String> values) {
            addCriterion("tmp_status not in", values, "tmpStatus");
            return (Criteria) this;
        }

        public Criteria andTmpStatusBetween(String value1, String value2) {
            addCriterion("tmp_status between", value1, value2, "tmpStatus");
            return (Criteria) this;
        }

        public Criteria andTmpStatusNotBetween(String value1, String value2) {
            addCriterion("tmp_status not between", value1, value2, "tmpStatus");
            return (Criteria) this;
        }

        public Criteria andTmpCreatedateIsNull() {
            addCriterion("tmp_createdate is null");
            return (Criteria) this;
        }

        public Criteria andTmpCreatedateIsNotNull() {
            addCriterion("tmp_createdate is not null");
            return (Criteria) this;
        }

        public Criteria andTmpCreatedateEqualTo(String value) {
            addCriterion("tmp_createdate =", value, "tmpCreatedate");
            return (Criteria) this;
        }

        public Criteria andTmpCreatedateNotEqualTo(String value) {
            addCriterion("tmp_createdate <>", value, "tmpCreatedate");
            return (Criteria) this;
        }

        public Criteria andTmpCreatedateGreaterThan(String value) {
            addCriterion("tmp_createdate >", value, "tmpCreatedate");
            return (Criteria) this;
        }

        public Criteria andTmpCreatedateGreaterThanOrEqualTo(String value) {
            addCriterion("tmp_createdate >=", value, "tmpCreatedate");
            return (Criteria) this;
        }

        public Criteria andTmpCreatedateLessThan(String value) {
            addCriterion("tmp_createdate <", value, "tmpCreatedate");
            return (Criteria) this;
        }

        public Criteria andTmpCreatedateLessThanOrEqualTo(String value) {
            addCriterion("tmp_createdate <=", value, "tmpCreatedate");
            return (Criteria) this;
        }

        public Criteria andTmpCreatedateLike(String value) {
            addCriterion("tmp_createdate like", value, "tmpCreatedate");
            return (Criteria) this;
        }

        public Criteria andTmpCreatedateNotLike(String value) {
            addCriterion("tmp_createdate not like", value, "tmpCreatedate");
            return (Criteria) this;
        }

        public Criteria andTmpCreatedateIn(List<String> values) {
            addCriterion("tmp_createdate in", values, "tmpCreatedate");
            return (Criteria) this;
        }

        public Criteria andTmpCreatedateNotIn(List<String> values) {
            addCriterion("tmp_createdate not in", values, "tmpCreatedate");
            return (Criteria) this;
        }

        public Criteria andTmpCreatedateBetween(String value1, String value2) {
            addCriterion("tmp_createdate between", value1, value2, "tmpCreatedate");
            return (Criteria) this;
        }

        public Criteria andTmpCreatedateNotBetween(String value1, String value2) {
            addCriterion("tmp_createdate not between", value1, value2, "tmpCreatedate");
            return (Criteria) this;
        }

        public Criteria andTmpCreateuserIsNull() {
            addCriterion("tmp_createuser is null");
            return (Criteria) this;
        }

        public Criteria andTmpCreateuserIsNotNull() {
            addCriterion("tmp_createuser is not null");
            return (Criteria) this;
        }

        public Criteria andTmpCreateuserEqualTo(String value) {
            addCriterion("tmp_createuser =", value, "tmpCreateuser");
            return (Criteria) this;
        }

        public Criteria andTmpCreateuserNotEqualTo(String value) {
            addCriterion("tmp_createuser <>", value, "tmpCreateuser");
            return (Criteria) this;
        }

        public Criteria andTmpCreateuserGreaterThan(String value) {
            addCriterion("tmp_createuser >", value, "tmpCreateuser");
            return (Criteria) this;
        }

        public Criteria andTmpCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("tmp_createuser >=", value, "tmpCreateuser");
            return (Criteria) this;
        }

        public Criteria andTmpCreateuserLessThan(String value) {
            addCriterion("tmp_createuser <", value, "tmpCreateuser");
            return (Criteria) this;
        }

        public Criteria andTmpCreateuserLessThanOrEqualTo(String value) {
            addCriterion("tmp_createuser <=", value, "tmpCreateuser");
            return (Criteria) this;
        }

        public Criteria andTmpCreateuserLike(String value) {
            addCriterion("tmp_createuser like", value, "tmpCreateuser");
            return (Criteria) this;
        }

        public Criteria andTmpCreateuserNotLike(String value) {
            addCriterion("tmp_createuser not like", value, "tmpCreateuser");
            return (Criteria) this;
        }

        public Criteria andTmpCreateuserIn(List<String> values) {
            addCriterion("tmp_createuser in", values, "tmpCreateuser");
            return (Criteria) this;
        }

        public Criteria andTmpCreateuserNotIn(List<String> values) {
            addCriterion("tmp_createuser not in", values, "tmpCreateuser");
            return (Criteria) this;
        }

        public Criteria andTmpCreateuserBetween(String value1, String value2) {
            addCriterion("tmp_createuser between", value1, value2, "tmpCreateuser");
            return (Criteria) this;
        }

        public Criteria andTmpCreateuserNotBetween(String value1, String value2) {
            addCriterion("tmp_createuser not between", value1, value2, "tmpCreateuser");
            return (Criteria) this;
        }

        public Criteria andTmpUpdateuserIsNull() {
            addCriterion("tmp_updateuser is null");
            return (Criteria) this;
        }

        public Criteria andTmpUpdateuserIsNotNull() {
            addCriterion("tmp_updateuser is not null");
            return (Criteria) this;
        }

        public Criteria andTmpUpdateuserEqualTo(String value) {
            addCriterion("tmp_updateuser =", value, "tmpUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTmpUpdateuserNotEqualTo(String value) {
            addCriterion("tmp_updateuser <>", value, "tmpUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTmpUpdateuserGreaterThan(String value) {
            addCriterion("tmp_updateuser >", value, "tmpUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTmpUpdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("tmp_updateuser >=", value, "tmpUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTmpUpdateuserLessThan(String value) {
            addCriterion("tmp_updateuser <", value, "tmpUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTmpUpdateuserLessThanOrEqualTo(String value) {
            addCriterion("tmp_updateuser <=", value, "tmpUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTmpUpdateuserLike(String value) {
            addCriterion("tmp_updateuser like", value, "tmpUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTmpUpdateuserNotLike(String value) {
            addCriterion("tmp_updateuser not like", value, "tmpUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTmpUpdateuserIn(List<String> values) {
            addCriterion("tmp_updateuser in", values, "tmpUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTmpUpdateuserNotIn(List<String> values) {
            addCriterion("tmp_updateuser not in", values, "tmpUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTmpUpdateuserBetween(String value1, String value2) {
            addCriterion("tmp_updateuser between", value1, value2, "tmpUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTmpUpdateuserNotBetween(String value1, String value2) {
            addCriterion("tmp_updateuser not between", value1, value2, "tmpUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTmpUpdatedateIsNull() {
            addCriterion("tmp_updatedate is null");
            return (Criteria) this;
        }

        public Criteria andTmpUpdatedateIsNotNull() {
            addCriterion("tmp_updatedate is not null");
            return (Criteria) this;
        }

        public Criteria andTmpUpdatedateEqualTo(String value) {
            addCriterion("tmp_updatedate =", value, "tmpUpdatedate");
            return (Criteria) this;
        }

        public Criteria andTmpUpdatedateNotEqualTo(String value) {
            addCriterion("tmp_updatedate <>", value, "tmpUpdatedate");
            return (Criteria) this;
        }

        public Criteria andTmpUpdatedateGreaterThan(String value) {
            addCriterion("tmp_updatedate >", value, "tmpUpdatedate");
            return (Criteria) this;
        }

        public Criteria andTmpUpdatedateGreaterThanOrEqualTo(String value) {
            addCriterion("tmp_updatedate >=", value, "tmpUpdatedate");
            return (Criteria) this;
        }

        public Criteria andTmpUpdatedateLessThan(String value) {
            addCriterion("tmp_updatedate <", value, "tmpUpdatedate");
            return (Criteria) this;
        }

        public Criteria andTmpUpdatedateLessThanOrEqualTo(String value) {
            addCriterion("tmp_updatedate <=", value, "tmpUpdatedate");
            return (Criteria) this;
        }

        public Criteria andTmpUpdatedateLike(String value) {
            addCriterion("tmp_updatedate like", value, "tmpUpdatedate");
            return (Criteria) this;
        }

        public Criteria andTmpUpdatedateNotLike(String value) {
            addCriterion("tmp_updatedate not like", value, "tmpUpdatedate");
            return (Criteria) this;
        }

        public Criteria andTmpUpdatedateIn(List<String> values) {
            addCriterion("tmp_updatedate in", values, "tmpUpdatedate");
            return (Criteria) this;
        }

        public Criteria andTmpUpdatedateNotIn(List<String> values) {
            addCriterion("tmp_updatedate not in", values, "tmpUpdatedate");
            return (Criteria) this;
        }

        public Criteria andTmpUpdatedateBetween(String value1, String value2) {
            addCriterion("tmp_updatedate between", value1, value2, "tmpUpdatedate");
            return (Criteria) this;
        }

        public Criteria andTmpUpdatedateNotBetween(String value1, String value2) {
            addCriterion("tmp_updatedate not between", value1, value2, "tmpUpdatedate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andTmpCodeLikeInsensitive(String value) {
            addCriterion("upper(tmp_code) like", value.toUpperCase(), "tmpCode");
            return this;
        }

        public Criteria andTmpPhysicalCodeLikeInsensitive(String value) {
            addCriterion("upper(tmp_physical_code) like", value.toUpperCase(), "tmpPhysicalCode");
            return this;
        }

        public Criteria andTmpCarCodeLikeInsensitive(String value) {
            addCriterion("upper(tmp_car_code) like", value.toUpperCase(), "tmpCarCode");
            return this;
        }

        public Criteria andTmpStatusLikeInsensitive(String value) {
            addCriterion("upper(tmp_status) like", value.toUpperCase(), "tmpStatus");
            return this;
        }

        public Criteria andTmpCreatedateLikeInsensitive(String value) {
            addCriterion("upper(tmp_createdate) like", value.toUpperCase(), "tmpCreatedate");
            return this;
        }

        public Criteria andTmpCreateuserLikeInsensitive(String value) {
            addCriterion("upper(tmp_createuser) like", value.toUpperCase(), "tmpCreateuser");
            return this;
        }

        public Criteria andTmpUpdateuserLikeInsensitive(String value) {
            addCriterion("upper(tmp_updateuser) like", value.toUpperCase(), "tmpUpdateuser");
            return this;
        }

        public Criteria andTmpUpdatedateLikeInsensitive(String value) {
            addCriterion("upper(tmp_updatedate) like", value.toUpperCase(), "tmpUpdatedate");
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