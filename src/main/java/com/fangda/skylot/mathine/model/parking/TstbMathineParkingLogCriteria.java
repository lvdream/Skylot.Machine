package com.fangda.skylot.mathine.model.parking;

import com.fangda.skylot.mathine.utils.Page;
import java.util.ArrayList;
import java.util.List;

public class TstbMathineParkingLogCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public TstbMathineParkingLogCriteria() {
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

        public Criteria andTmplIdIsNull() {
            addCriterion("tmpl_id is null");
            return (Criteria) this;
        }

        public Criteria andTmplIdIsNotNull() {
            addCriterion("tmpl_id is not null");
            return (Criteria) this;
        }

        public Criteria andTmplIdEqualTo(Integer value) {
            addCriterion("tmpl_id =", value, "tmplId");
            return (Criteria) this;
        }

        public Criteria andTmplIdNotEqualTo(Integer value) {
            addCriterion("tmpl_id <>", value, "tmplId");
            return (Criteria) this;
        }

        public Criteria andTmplIdGreaterThan(Integer value) {
            addCriterion("tmpl_id >", value, "tmplId");
            return (Criteria) this;
        }

        public Criteria andTmplIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tmpl_id >=", value, "tmplId");
            return (Criteria) this;
        }

        public Criteria andTmplIdLessThan(Integer value) {
            addCriterion("tmpl_id <", value, "tmplId");
            return (Criteria) this;
        }

        public Criteria andTmplIdLessThanOrEqualTo(Integer value) {
            addCriterion("tmpl_id <=", value, "tmplId");
            return (Criteria) this;
        }

        public Criteria andTmplIdIn(List<Integer> values) {
            addCriterion("tmpl_id in", values, "tmplId");
            return (Criteria) this;
        }

        public Criteria andTmplIdNotIn(List<Integer> values) {
            addCriterion("tmpl_id not in", values, "tmplId");
            return (Criteria) this;
        }

        public Criteria andTmplIdBetween(Integer value1, Integer value2) {
            addCriterion("tmpl_id between", value1, value2, "tmplId");
            return (Criteria) this;
        }

        public Criteria andTmplIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tmpl_id not between", value1, value2, "tmplId");
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

        public Criteria andImaIdEqualTo(Integer value) {
            addCriterion("ima_id =", value, "imaId");
            return (Criteria) this;
        }

        public Criteria andImaIdNotEqualTo(Integer value) {
            addCriterion("ima_id <>", value, "imaId");
            return (Criteria) this;
        }

        public Criteria andImaIdGreaterThan(Integer value) {
            addCriterion("ima_id >", value, "imaId");
            return (Criteria) this;
        }

        public Criteria andImaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ima_id >=", value, "imaId");
            return (Criteria) this;
        }

        public Criteria andImaIdLessThan(Integer value) {
            addCriterion("ima_id <", value, "imaId");
            return (Criteria) this;
        }

        public Criteria andImaIdLessThanOrEqualTo(Integer value) {
            addCriterion("ima_id <=", value, "imaId");
            return (Criteria) this;
        }

        public Criteria andImaIdIn(List<Integer> values) {
            addCriterion("ima_id in", values, "imaId");
            return (Criteria) this;
        }

        public Criteria andImaIdNotIn(List<Integer> values) {
            addCriterion("ima_id not in", values, "imaId");
            return (Criteria) this;
        }

        public Criteria andImaIdBetween(Integer value1, Integer value2) {
            addCriterion("ima_id between", value1, value2, "imaId");
            return (Criteria) this;
        }

        public Criteria andImaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ima_id not between", value1, value2, "imaId");
            return (Criteria) this;
        }

        public Criteria andTmplCarIsNull() {
            addCriterion("tmpl_car is null");
            return (Criteria) this;
        }

        public Criteria andTmplCarIsNotNull() {
            addCriterion("tmpl_car is not null");
            return (Criteria) this;
        }

        public Criteria andTmplCarEqualTo(String value) {
            addCriterion("tmpl_car =", value, "tmplCar");
            return (Criteria) this;
        }

        public Criteria andTmplCarNotEqualTo(String value) {
            addCriterion("tmpl_car <>", value, "tmplCar");
            return (Criteria) this;
        }

        public Criteria andTmplCarGreaterThan(String value) {
            addCriterion("tmpl_car >", value, "tmplCar");
            return (Criteria) this;
        }

        public Criteria andTmplCarGreaterThanOrEqualTo(String value) {
            addCriterion("tmpl_car >=", value, "tmplCar");
            return (Criteria) this;
        }

        public Criteria andTmplCarLessThan(String value) {
            addCriterion("tmpl_car <", value, "tmplCar");
            return (Criteria) this;
        }

        public Criteria andTmplCarLessThanOrEqualTo(String value) {
            addCriterion("tmpl_car <=", value, "tmplCar");
            return (Criteria) this;
        }

        public Criteria andTmplCarLike(String value) {
            addCriterion("tmpl_car like", value, "tmplCar");
            return (Criteria) this;
        }

        public Criteria andTmplCarNotLike(String value) {
            addCriterion("tmpl_car not like", value, "tmplCar");
            return (Criteria) this;
        }

        public Criteria andTmplCarIn(List<String> values) {
            addCriterion("tmpl_car in", values, "tmplCar");
            return (Criteria) this;
        }

        public Criteria andTmplCarNotIn(List<String> values) {
            addCriterion("tmpl_car not in", values, "tmplCar");
            return (Criteria) this;
        }

        public Criteria andTmplCarBetween(String value1, String value2) {
            addCriterion("tmpl_car between", value1, value2, "tmplCar");
            return (Criteria) this;
        }

        public Criteria andTmplCarNotBetween(String value1, String value2) {
            addCriterion("tmpl_car not between", value1, value2, "tmplCar");
            return (Criteria) this;
        }

        public Criteria andTmplPhysicalCodeIsNull() {
            addCriterion("tmpl_physical_code is null");
            return (Criteria) this;
        }

        public Criteria andTmplPhysicalCodeIsNotNull() {
            addCriterion("tmpl_physical_code is not null");
            return (Criteria) this;
        }

        public Criteria andTmplPhysicalCodeEqualTo(String value) {
            addCriterion("tmpl_physical_code =", value, "tmplPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andTmplPhysicalCodeNotEqualTo(String value) {
            addCriterion("tmpl_physical_code <>", value, "tmplPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andTmplPhysicalCodeGreaterThan(String value) {
            addCriterion("tmpl_physical_code >", value, "tmplPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andTmplPhysicalCodeGreaterThanOrEqualTo(String value) {
            addCriterion("tmpl_physical_code >=", value, "tmplPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andTmplPhysicalCodeLessThan(String value) {
            addCriterion("tmpl_physical_code <", value, "tmplPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andTmplPhysicalCodeLessThanOrEqualTo(String value) {
            addCriterion("tmpl_physical_code <=", value, "tmplPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andTmplPhysicalCodeLike(String value) {
            addCriterion("tmpl_physical_code like", value, "tmplPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andTmplPhysicalCodeNotLike(String value) {
            addCriterion("tmpl_physical_code not like", value, "tmplPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andTmplPhysicalCodeIn(List<String> values) {
            addCriterion("tmpl_physical_code in", values, "tmplPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andTmplPhysicalCodeNotIn(List<String> values) {
            addCriterion("tmpl_physical_code not in", values, "tmplPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andTmplPhysicalCodeBetween(String value1, String value2) {
            addCriterion("tmpl_physical_code between", value1, value2, "tmplPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andTmplPhysicalCodeNotBetween(String value1, String value2) {
            addCriterion("tmpl_physical_code not between", value1, value2, "tmplPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andTmplCustomerIsNull() {
            addCriterion("tmpl_customer is null");
            return (Criteria) this;
        }

        public Criteria andTmplCustomerIsNotNull() {
            addCriterion("tmpl_customer is not null");
            return (Criteria) this;
        }

        public Criteria andTmplCustomerEqualTo(String value) {
            addCriterion("tmpl_customer =", value, "tmplCustomer");
            return (Criteria) this;
        }

        public Criteria andTmplCustomerNotEqualTo(String value) {
            addCriterion("tmpl_customer <>", value, "tmplCustomer");
            return (Criteria) this;
        }

        public Criteria andTmplCustomerGreaterThan(String value) {
            addCriterion("tmpl_customer >", value, "tmplCustomer");
            return (Criteria) this;
        }

        public Criteria andTmplCustomerGreaterThanOrEqualTo(String value) {
            addCriterion("tmpl_customer >=", value, "tmplCustomer");
            return (Criteria) this;
        }

        public Criteria andTmplCustomerLessThan(String value) {
            addCriterion("tmpl_customer <", value, "tmplCustomer");
            return (Criteria) this;
        }

        public Criteria andTmplCustomerLessThanOrEqualTo(String value) {
            addCriterion("tmpl_customer <=", value, "tmplCustomer");
            return (Criteria) this;
        }

        public Criteria andTmplCustomerLike(String value) {
            addCriterion("tmpl_customer like", value, "tmplCustomer");
            return (Criteria) this;
        }

        public Criteria andTmplCustomerNotLike(String value) {
            addCriterion("tmpl_customer not like", value, "tmplCustomer");
            return (Criteria) this;
        }

        public Criteria andTmplCustomerIn(List<String> values) {
            addCriterion("tmpl_customer in", values, "tmplCustomer");
            return (Criteria) this;
        }

        public Criteria andTmplCustomerNotIn(List<String> values) {
            addCriterion("tmpl_customer not in", values, "tmplCustomer");
            return (Criteria) this;
        }

        public Criteria andTmplCustomerBetween(String value1, String value2) {
            addCriterion("tmpl_customer between", value1, value2, "tmplCustomer");
            return (Criteria) this;
        }

        public Criteria andTmplCustomerNotBetween(String value1, String value2) {
            addCriterion("tmpl_customer not between", value1, value2, "tmplCustomer");
            return (Criteria) this;
        }

        public Criteria andTmplTypeIsNull() {
            addCriterion("tmpl_type is null");
            return (Criteria) this;
        }

        public Criteria andTmplTypeIsNotNull() {
            addCriterion("tmpl_type is not null");
            return (Criteria) this;
        }

        public Criteria andTmplTypeEqualTo(String value) {
            addCriterion("tmpl_type =", value, "tmplType");
            return (Criteria) this;
        }

        public Criteria andTmplTypeNotEqualTo(String value) {
            addCriterion("tmpl_type <>", value, "tmplType");
            return (Criteria) this;
        }

        public Criteria andTmplTypeGreaterThan(String value) {
            addCriterion("tmpl_type >", value, "tmplType");
            return (Criteria) this;
        }

        public Criteria andTmplTypeGreaterThanOrEqualTo(String value) {
            addCriterion("tmpl_type >=", value, "tmplType");
            return (Criteria) this;
        }

        public Criteria andTmplTypeLessThan(String value) {
            addCriterion("tmpl_type <", value, "tmplType");
            return (Criteria) this;
        }

        public Criteria andTmplTypeLessThanOrEqualTo(String value) {
            addCriterion("tmpl_type <=", value, "tmplType");
            return (Criteria) this;
        }

        public Criteria andTmplTypeLike(String value) {
            addCriterion("tmpl_type like", value, "tmplType");
            return (Criteria) this;
        }

        public Criteria andTmplTypeNotLike(String value) {
            addCriterion("tmpl_type not like", value, "tmplType");
            return (Criteria) this;
        }

        public Criteria andTmplTypeIn(List<String> values) {
            addCriterion("tmpl_type in", values, "tmplType");
            return (Criteria) this;
        }

        public Criteria andTmplTypeNotIn(List<String> values) {
            addCriterion("tmpl_type not in", values, "tmplType");
            return (Criteria) this;
        }

        public Criteria andTmplTypeBetween(String value1, String value2) {
            addCriterion("tmpl_type between", value1, value2, "tmplType");
            return (Criteria) this;
        }

        public Criteria andTmplTypeNotBetween(String value1, String value2) {
            addCriterion("tmpl_type not between", value1, value2, "tmplType");
            return (Criteria) this;
        }

        public Criteria andTmplStatusIsNull() {
            addCriterion("tmpl_status is null");
            return (Criteria) this;
        }

        public Criteria andTmplStatusIsNotNull() {
            addCriterion("tmpl_status is not null");
            return (Criteria) this;
        }

        public Criteria andTmplStatusEqualTo(String value) {
            addCriterion("tmpl_status =", value, "tmplStatus");
            return (Criteria) this;
        }

        public Criteria andTmplStatusNotEqualTo(String value) {
            addCriterion("tmpl_status <>", value, "tmplStatus");
            return (Criteria) this;
        }

        public Criteria andTmplStatusGreaterThan(String value) {
            addCriterion("tmpl_status >", value, "tmplStatus");
            return (Criteria) this;
        }

        public Criteria andTmplStatusGreaterThanOrEqualTo(String value) {
            addCriterion("tmpl_status >=", value, "tmplStatus");
            return (Criteria) this;
        }

        public Criteria andTmplStatusLessThan(String value) {
            addCriterion("tmpl_status <", value, "tmplStatus");
            return (Criteria) this;
        }

        public Criteria andTmplStatusLessThanOrEqualTo(String value) {
            addCriterion("tmpl_status <=", value, "tmplStatus");
            return (Criteria) this;
        }

        public Criteria andTmplStatusLike(String value) {
            addCriterion("tmpl_status like", value, "tmplStatus");
            return (Criteria) this;
        }

        public Criteria andTmplStatusNotLike(String value) {
            addCriterion("tmpl_status not like", value, "tmplStatus");
            return (Criteria) this;
        }

        public Criteria andTmplStatusIn(List<String> values) {
            addCriterion("tmpl_status in", values, "tmplStatus");
            return (Criteria) this;
        }

        public Criteria andTmplStatusNotIn(List<String> values) {
            addCriterion("tmpl_status not in", values, "tmplStatus");
            return (Criteria) this;
        }

        public Criteria andTmplStatusBetween(String value1, String value2) {
            addCriterion("tmpl_status between", value1, value2, "tmplStatus");
            return (Criteria) this;
        }

        public Criteria andTmplStatusNotBetween(String value1, String value2) {
            addCriterion("tmpl_status not between", value1, value2, "tmplStatus");
            return (Criteria) this;
        }

        public Criteria andTmplCreatedateIsNull() {
            addCriterion("tmpl_createdate is null");
            return (Criteria) this;
        }

        public Criteria andTmplCreatedateIsNotNull() {
            addCriterion("tmpl_createdate is not null");
            return (Criteria) this;
        }

        public Criteria andTmplCreatedateEqualTo(String value) {
            addCriterion("tmpl_createdate =", value, "tmplCreatedate");
            return (Criteria) this;
        }

        public Criteria andTmplCreatedateNotEqualTo(String value) {
            addCriterion("tmpl_createdate <>", value, "tmplCreatedate");
            return (Criteria) this;
        }

        public Criteria andTmplCreatedateGreaterThan(String value) {
            addCriterion("tmpl_createdate >", value, "tmplCreatedate");
            return (Criteria) this;
        }

        public Criteria andTmplCreatedateGreaterThanOrEqualTo(String value) {
            addCriterion("tmpl_createdate >=", value, "tmplCreatedate");
            return (Criteria) this;
        }

        public Criteria andTmplCreatedateLessThan(String value) {
            addCriterion("tmpl_createdate <", value, "tmplCreatedate");
            return (Criteria) this;
        }

        public Criteria andTmplCreatedateLessThanOrEqualTo(String value) {
            addCriterion("tmpl_createdate <=", value, "tmplCreatedate");
            return (Criteria) this;
        }

        public Criteria andTmplCreatedateLike(String value) {
            addCriterion("tmpl_createdate like", value, "tmplCreatedate");
            return (Criteria) this;
        }

        public Criteria andTmplCreatedateNotLike(String value) {
            addCriterion("tmpl_createdate not like", value, "tmplCreatedate");
            return (Criteria) this;
        }

        public Criteria andTmplCreatedateIn(List<String> values) {
            addCriterion("tmpl_createdate in", values, "tmplCreatedate");
            return (Criteria) this;
        }

        public Criteria andTmplCreatedateNotIn(List<String> values) {
            addCriterion("tmpl_createdate not in", values, "tmplCreatedate");
            return (Criteria) this;
        }

        public Criteria andTmplCreatedateBetween(String value1, String value2) {
            addCriterion("tmpl_createdate between", value1, value2, "tmplCreatedate");
            return (Criteria) this;
        }

        public Criteria andTmplCreatedateNotBetween(String value1, String value2) {
            addCriterion("tmpl_createdate not between", value1, value2, "tmplCreatedate");
            return (Criteria) this;
        }

        public Criteria andTmplCreateuserIsNull() {
            addCriterion("tmpl_createuser is null");
            return (Criteria) this;
        }

        public Criteria andTmplCreateuserIsNotNull() {
            addCriterion("tmpl_createuser is not null");
            return (Criteria) this;
        }

        public Criteria andTmplCreateuserEqualTo(String value) {
            addCriterion("tmpl_createuser =", value, "tmplCreateuser");
            return (Criteria) this;
        }

        public Criteria andTmplCreateuserNotEqualTo(String value) {
            addCriterion("tmpl_createuser <>", value, "tmplCreateuser");
            return (Criteria) this;
        }

        public Criteria andTmplCreateuserGreaterThan(String value) {
            addCriterion("tmpl_createuser >", value, "tmplCreateuser");
            return (Criteria) this;
        }

        public Criteria andTmplCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("tmpl_createuser >=", value, "tmplCreateuser");
            return (Criteria) this;
        }

        public Criteria andTmplCreateuserLessThan(String value) {
            addCriterion("tmpl_createuser <", value, "tmplCreateuser");
            return (Criteria) this;
        }

        public Criteria andTmplCreateuserLessThanOrEqualTo(String value) {
            addCriterion("tmpl_createuser <=", value, "tmplCreateuser");
            return (Criteria) this;
        }

        public Criteria andTmplCreateuserLike(String value) {
            addCriterion("tmpl_createuser like", value, "tmplCreateuser");
            return (Criteria) this;
        }

        public Criteria andTmplCreateuserNotLike(String value) {
            addCriterion("tmpl_createuser not like", value, "tmplCreateuser");
            return (Criteria) this;
        }

        public Criteria andTmplCreateuserIn(List<String> values) {
            addCriterion("tmpl_createuser in", values, "tmplCreateuser");
            return (Criteria) this;
        }

        public Criteria andTmplCreateuserNotIn(List<String> values) {
            addCriterion("tmpl_createuser not in", values, "tmplCreateuser");
            return (Criteria) this;
        }

        public Criteria andTmplCreateuserBetween(String value1, String value2) {
            addCriterion("tmpl_createuser between", value1, value2, "tmplCreateuser");
            return (Criteria) this;
        }

        public Criteria andTmplCreateuserNotBetween(String value1, String value2) {
            addCriterion("tmpl_createuser not between", value1, value2, "tmplCreateuser");
            return (Criteria) this;
        }

        public Criteria andTmplUpdatedateIsNull() {
            addCriterion("tmpl_updatedate is null");
            return (Criteria) this;
        }

        public Criteria andTmplUpdatedateIsNotNull() {
            addCriterion("tmpl_updatedate is not null");
            return (Criteria) this;
        }

        public Criteria andTmplUpdatedateEqualTo(String value) {
            addCriterion("tmpl_updatedate =", value, "tmplUpdatedate");
            return (Criteria) this;
        }

        public Criteria andTmplUpdatedateNotEqualTo(String value) {
            addCriterion("tmpl_updatedate <>", value, "tmplUpdatedate");
            return (Criteria) this;
        }

        public Criteria andTmplUpdatedateGreaterThan(String value) {
            addCriterion("tmpl_updatedate >", value, "tmplUpdatedate");
            return (Criteria) this;
        }

        public Criteria andTmplUpdatedateGreaterThanOrEqualTo(String value) {
            addCriterion("tmpl_updatedate >=", value, "tmplUpdatedate");
            return (Criteria) this;
        }

        public Criteria andTmplUpdatedateLessThan(String value) {
            addCriterion("tmpl_updatedate <", value, "tmplUpdatedate");
            return (Criteria) this;
        }

        public Criteria andTmplUpdatedateLessThanOrEqualTo(String value) {
            addCriterion("tmpl_updatedate <=", value, "tmplUpdatedate");
            return (Criteria) this;
        }

        public Criteria andTmplUpdatedateLike(String value) {
            addCriterion("tmpl_updatedate like", value, "tmplUpdatedate");
            return (Criteria) this;
        }

        public Criteria andTmplUpdatedateNotLike(String value) {
            addCriterion("tmpl_updatedate not like", value, "tmplUpdatedate");
            return (Criteria) this;
        }

        public Criteria andTmplUpdatedateIn(List<String> values) {
            addCriterion("tmpl_updatedate in", values, "tmplUpdatedate");
            return (Criteria) this;
        }

        public Criteria andTmplUpdatedateNotIn(List<String> values) {
            addCriterion("tmpl_updatedate not in", values, "tmplUpdatedate");
            return (Criteria) this;
        }

        public Criteria andTmplUpdatedateBetween(String value1, String value2) {
            addCriterion("tmpl_updatedate between", value1, value2, "tmplUpdatedate");
            return (Criteria) this;
        }

        public Criteria andTmplUpdatedateNotBetween(String value1, String value2) {
            addCriterion("tmpl_updatedate not between", value1, value2, "tmplUpdatedate");
            return (Criteria) this;
        }

        public Criteria andTmplUpdateuserIsNull() {
            addCriterion("tmpl_updateuser is null");
            return (Criteria) this;
        }

        public Criteria andTmplUpdateuserIsNotNull() {
            addCriterion("tmpl_updateuser is not null");
            return (Criteria) this;
        }

        public Criteria andTmplUpdateuserEqualTo(String value) {
            addCriterion("tmpl_updateuser =", value, "tmplUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTmplUpdateuserNotEqualTo(String value) {
            addCriterion("tmpl_updateuser <>", value, "tmplUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTmplUpdateuserGreaterThan(String value) {
            addCriterion("tmpl_updateuser >", value, "tmplUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTmplUpdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("tmpl_updateuser >=", value, "tmplUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTmplUpdateuserLessThan(String value) {
            addCriterion("tmpl_updateuser <", value, "tmplUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTmplUpdateuserLessThanOrEqualTo(String value) {
            addCriterion("tmpl_updateuser <=", value, "tmplUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTmplUpdateuserLike(String value) {
            addCriterion("tmpl_updateuser like", value, "tmplUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTmplUpdateuserNotLike(String value) {
            addCriterion("tmpl_updateuser not like", value, "tmplUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTmplUpdateuserIn(List<String> values) {
            addCriterion("tmpl_updateuser in", values, "tmplUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTmplUpdateuserNotIn(List<String> values) {
            addCriterion("tmpl_updateuser not in", values, "tmplUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTmplUpdateuserBetween(String value1, String value2) {
            addCriterion("tmpl_updateuser between", value1, value2, "tmplUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTmplUpdateuserNotBetween(String value1, String value2) {
            addCriterion("tmpl_updateuser not between", value1, value2, "tmplUpdateuser");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andTmplCarLikeInsensitive(String value) {
            addCriterion("upper(tmpl_car) like", value.toUpperCase(), "tmplCar");
            return this;
        }

        public Criteria andTmplPhysicalCodeLikeInsensitive(String value) {
            addCriterion("upper(tmpl_physical_code) like", value.toUpperCase(), "tmplPhysicalCode");
            return this;
        }

        public Criteria andTmplCustomerLikeInsensitive(String value) {
            addCriterion("upper(tmpl_customer) like", value.toUpperCase(), "tmplCustomer");
            return this;
        }

        public Criteria andTmplTypeLikeInsensitive(String value) {
            addCriterion("upper(tmpl_type) like", value.toUpperCase(), "tmplType");
            return this;
        }

        public Criteria andTmplStatusLikeInsensitive(String value) {
            addCriterion("upper(tmpl_status) like", value.toUpperCase(), "tmplStatus");
            return this;
        }

        public Criteria andTmplCreatedateLikeInsensitive(String value) {
            addCriterion("upper(tmpl_createdate) like", value.toUpperCase(), "tmplCreatedate");
            return this;
        }

        public Criteria andTmplCreateuserLikeInsensitive(String value) {
            addCriterion("upper(tmpl_createuser) like", value.toUpperCase(), "tmplCreateuser");
            return this;
        }

        public Criteria andTmplUpdatedateLikeInsensitive(String value) {
            addCriterion("upper(tmpl_updatedate) like", value.toUpperCase(), "tmplUpdatedate");
            return this;
        }

        public Criteria andTmplUpdateuserLikeInsensitive(String value) {
            addCriterion("upper(tmpl_updateuser) like", value.toUpperCase(), "tmplUpdateuser");
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