package com.fangda.skylot.mathine.model.customer;

import com.fangda.skylot.mathine.utils.Page;

import java.util.ArrayList;
import java.util.List;

public class OftbCodeInfoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public OftbCodeInfoCriteria() {
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

        public Criteria andOciIdIsNull() {
            addCriterion("oci_id is null");
            return (Criteria) this;
        }

        public Criteria andOciIdIsNotNull() {
            addCriterion("oci_id is not null");
            return (Criteria) this;
        }

        public Criteria andOciIdEqualTo(Integer value) {
            addCriterion("oci_id =", value, "ociId");
            return (Criteria) this;
        }

        public Criteria andOciIdNotEqualTo(Integer value) {
            addCriterion("oci_id <>", value, "ociId");
            return (Criteria) this;
        }

        public Criteria andOciIdGreaterThan(Integer value) {
            addCriterion("oci_id >", value, "ociId");
            return (Criteria) this;
        }

        public Criteria andOciIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("oci_id >=", value, "ociId");
            return (Criteria) this;
        }

        public Criteria andOciIdLessThan(Integer value) {
            addCriterion("oci_id <", value, "ociId");
            return (Criteria) this;
        }

        public Criteria andOciIdLessThanOrEqualTo(Integer value) {
            addCriterion("oci_id <=", value, "ociId");
            return (Criteria) this;
        }

        public Criteria andOciIdIn(List<Integer> values) {
            addCriterion("oci_id in", values, "ociId");
            return (Criteria) this;
        }

        public Criteria andOciIdNotIn(List<Integer> values) {
            addCriterion("oci_id not in", values, "ociId");
            return (Criteria) this;
        }

        public Criteria andOciIdBetween(Integer value1, Integer value2) {
            addCriterion("oci_id between", value1, value2, "ociId");
            return (Criteria) this;
        }

        public Criteria andOciIdNotBetween(Integer value1, Integer value2) {
            addCriterion("oci_id not between", value1, value2, "ociId");
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

        public Criteria andOciPhysicalCodeIsNull() {
            addCriterion("oci_physical_code is null");
            return (Criteria) this;
        }

        public Criteria andOciPhysicalCodeIsNotNull() {
            addCriterion("oci_physical_code is not null");
            return (Criteria) this;
        }

        public Criteria andOciPhysicalCodeEqualTo(String value) {
            addCriterion("oci_physical_code =", value, "ociPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andOciPhysicalCodeNotEqualTo(String value) {
            addCriterion("oci_physical_code <>", value, "ociPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andOciPhysicalCodeGreaterThan(String value) {
            addCriterion("oci_physical_code >", value, "ociPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andOciPhysicalCodeGreaterThanOrEqualTo(String value) {
            addCriterion("oci_physical_code >=", value, "ociPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andOciPhysicalCodeLessThan(String value) {
            addCriterion("oci_physical_code <", value, "ociPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andOciPhysicalCodeLessThanOrEqualTo(String value) {
            addCriterion("oci_physical_code <=", value, "ociPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andOciPhysicalCodeLike(String value) {
            addCriterion("oci_physical_code like", value, "ociPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andOciPhysicalCodeNotLike(String value) {
            addCriterion("oci_physical_code not like", value, "ociPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andOciPhysicalCodeIn(List<String> values) {
            addCriterion("oci_physical_code in", values, "ociPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andOciPhysicalCodeNotIn(List<String> values) {
            addCriterion("oci_physical_code not in", values, "ociPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andOciPhysicalCodeBetween(String value1, String value2) {
            addCriterion("oci_physical_code between", value1, value2, "ociPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andOciPhysicalCodeNotBetween(String value1, String value2) {
            addCriterion("oci_physical_code not between", value1, value2, "ociPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andOciCodeUrlIsNull() {
            addCriterion("oci_code_url is null");
            return (Criteria) this;
        }

        public Criteria andOciCodeUrlIsNotNull() {
            addCriterion("oci_code_url is not null");
            return (Criteria) this;
        }

        public Criteria andOciCodeUrlEqualTo(String value) {
            addCriterion("oci_code_url =", value, "ociCodeUrl");
            return (Criteria) this;
        }

        public Criteria andOciCodeUrlNotEqualTo(String value) {
            addCriterion("oci_code_url <>", value, "ociCodeUrl");
            return (Criteria) this;
        }

        public Criteria andOciCodeUrlGreaterThan(String value) {
            addCriterion("oci_code_url >", value, "ociCodeUrl");
            return (Criteria) this;
        }

        public Criteria andOciCodeUrlGreaterThanOrEqualTo(String value) {
            addCriterion("oci_code_url >=", value, "ociCodeUrl");
            return (Criteria) this;
        }

        public Criteria andOciCodeUrlLessThan(String value) {
            addCriterion("oci_code_url <", value, "ociCodeUrl");
            return (Criteria) this;
        }

        public Criteria andOciCodeUrlLessThanOrEqualTo(String value) {
            addCriterion("oci_code_url <=", value, "ociCodeUrl");
            return (Criteria) this;
        }

        public Criteria andOciCodeUrlLike(String value) {
            addCriterion("oci_code_url like", value, "ociCodeUrl");
            return (Criteria) this;
        }

        public Criteria andOciCodeUrlNotLike(String value) {
            addCriterion("oci_code_url not like", value, "ociCodeUrl");
            return (Criteria) this;
        }

        public Criteria andOciCodeUrlIn(List<String> values) {
            addCriterion("oci_code_url in", values, "ociCodeUrl");
            return (Criteria) this;
        }

        public Criteria andOciCodeUrlNotIn(List<String> values) {
            addCriterion("oci_code_url not in", values, "ociCodeUrl");
            return (Criteria) this;
        }

        public Criteria andOciCodeUrlBetween(String value1, String value2) {
            addCriterion("oci_code_url between", value1, value2, "ociCodeUrl");
            return (Criteria) this;
        }

        public Criteria andOciCodeUrlNotBetween(String value1, String value2) {
            addCriterion("oci_code_url not between", value1, value2, "ociCodeUrl");
            return (Criteria) this;
        }

        public Criteria andOciPasswordIsNull() {
            addCriterion("oci_password is null");
            return (Criteria) this;
        }

        public Criteria andOciPasswordIsNotNull() {
            addCriterion("oci_password is not null");
            return (Criteria) this;
        }

        public Criteria andOciPasswordEqualTo(String value) {
            addCriterion("oci_password =", value, "ociPassword");
            return (Criteria) this;
        }

        public Criteria andOciPasswordNotEqualTo(String value) {
            addCriterion("oci_password <>", value, "ociPassword");
            return (Criteria) this;
        }

        public Criteria andOciPasswordGreaterThan(String value) {
            addCriterion("oci_password >", value, "ociPassword");
            return (Criteria) this;
        }

        public Criteria andOciPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("oci_password >=", value, "ociPassword");
            return (Criteria) this;
        }

        public Criteria andOciPasswordLessThan(String value) {
            addCriterion("oci_password <", value, "ociPassword");
            return (Criteria) this;
        }

        public Criteria andOciPasswordLessThanOrEqualTo(String value) {
            addCriterion("oci_password <=", value, "ociPassword");
            return (Criteria) this;
        }

        public Criteria andOciPasswordLike(String value) {
            addCriterion("oci_password like", value, "ociPassword");
            return (Criteria) this;
        }

        public Criteria andOciPasswordNotLike(String value) {
            addCriterion("oci_password not like", value, "ociPassword");
            return (Criteria) this;
        }

        public Criteria andOciPasswordIn(List<String> values) {
            addCriterion("oci_password in", values, "ociPassword");
            return (Criteria) this;
        }

        public Criteria andOciPasswordNotIn(List<String> values) {
            addCriterion("oci_password not in", values, "ociPassword");
            return (Criteria) this;
        }

        public Criteria andOciPasswordBetween(String value1, String value2) {
            addCriterion("oci_password between", value1, value2, "ociPassword");
            return (Criteria) this;
        }

        public Criteria andOciPasswordNotBetween(String value1, String value2) {
            addCriterion("oci_password not between", value1, value2, "ociPassword");
            return (Criteria) this;
        }

        public Criteria andOciStatusIsNull() {
            addCriterion("oci_status is null");
            return (Criteria) this;
        }

        public Criteria andOciStatusIsNotNull() {
            addCriterion("oci_status is not null");
            return (Criteria) this;
        }

        public Criteria andOciStatusEqualTo(String value) {
            addCriterion("oci_status =", value, "ociStatus");
            return (Criteria) this;
        }

        public Criteria andOciStatusNotEqualTo(String value) {
            addCriterion("oci_status <>", value, "ociStatus");
            return (Criteria) this;
        }

        public Criteria andOciStatusGreaterThan(String value) {
            addCriterion("oci_status >", value, "ociStatus");
            return (Criteria) this;
        }

        public Criteria andOciStatusGreaterThanOrEqualTo(String value) {
            addCriterion("oci_status >=", value, "ociStatus");
            return (Criteria) this;
        }

        public Criteria andOciStatusLessThan(String value) {
            addCriterion("oci_status <", value, "ociStatus");
            return (Criteria) this;
        }

        public Criteria andOciStatusLessThanOrEqualTo(String value) {
            addCriterion("oci_status <=", value, "ociStatus");
            return (Criteria) this;
        }

        public Criteria andOciStatusLike(String value) {
            addCriterion("oci_status like", value, "ociStatus");
            return (Criteria) this;
        }

        public Criteria andOciStatusNotLike(String value) {
            addCriterion("oci_status not like", value, "ociStatus");
            return (Criteria) this;
        }

        public Criteria andOciStatusIn(List<String> values) {
            addCriterion("oci_status in", values, "ociStatus");
            return (Criteria) this;
        }

        public Criteria andOciStatusNotIn(List<String> values) {
            addCriterion("oci_status not in", values, "ociStatus");
            return (Criteria) this;
        }

        public Criteria andOciStatusBetween(String value1, String value2) {
            addCriterion("oci_status between", value1, value2, "ociStatus");
            return (Criteria) this;
        }

        public Criteria andOciStatusNotBetween(String value1, String value2) {
            addCriterion("oci_status not between", value1, value2, "ociStatus");
            return (Criteria) this;
        }

        public Criteria andOciCreatedateIsNull() {
            addCriterion("oci_createdate is null");
            return (Criteria) this;
        }

        public Criteria andOciCreatedateIsNotNull() {
            addCriterion("oci_createdate is not null");
            return (Criteria) this;
        }

        public Criteria andOciCreatedateEqualTo(String value) {
            addCriterion("oci_createdate =", value, "ociCreatedate");
            return (Criteria) this;
        }

        public Criteria andOciCreatedateNotEqualTo(String value) {
            addCriterion("oci_createdate <>", value, "ociCreatedate");
            return (Criteria) this;
        }

        public Criteria andOciCreatedateGreaterThan(String value) {
            addCriterion("oci_createdate >", value, "ociCreatedate");
            return (Criteria) this;
        }

        public Criteria andOciCreatedateGreaterThanOrEqualTo(String value) {
            addCriterion("oci_createdate >=", value, "ociCreatedate");
            return (Criteria) this;
        }

        public Criteria andOciCreatedateLessThan(String value) {
            addCriterion("oci_createdate <", value, "ociCreatedate");
            return (Criteria) this;
        }

        public Criteria andOciCreatedateLessThanOrEqualTo(String value) {
            addCriterion("oci_createdate <=", value, "ociCreatedate");
            return (Criteria) this;
        }

        public Criteria andOciCreatedateLike(String value) {
            addCriterion("oci_createdate like", value, "ociCreatedate");
            return (Criteria) this;
        }

        public Criteria andOciCreatedateNotLike(String value) {
            addCriterion("oci_createdate not like", value, "ociCreatedate");
            return (Criteria) this;
        }

        public Criteria andOciCreatedateIn(List<String> values) {
            addCriterion("oci_createdate in", values, "ociCreatedate");
            return (Criteria) this;
        }

        public Criteria andOciCreatedateNotIn(List<String> values) {
            addCriterion("oci_createdate not in", values, "ociCreatedate");
            return (Criteria) this;
        }

        public Criteria andOciCreatedateBetween(String value1, String value2) {
            addCriterion("oci_createdate between", value1, value2, "ociCreatedate");
            return (Criteria) this;
        }

        public Criteria andOciCreatedateNotBetween(String value1, String value2) {
            addCriterion("oci_createdate not between", value1, value2, "ociCreatedate");
            return (Criteria) this;
        }

        public Criteria andOciCreateuserIsNull() {
            addCriterion("oci_createuser is null");
            return (Criteria) this;
        }

        public Criteria andOciCreateuserIsNotNull() {
            addCriterion("oci_createuser is not null");
            return (Criteria) this;
        }

        public Criteria andOciCreateuserEqualTo(String value) {
            addCriterion("oci_createuser =", value, "ociCreateuser");
            return (Criteria) this;
        }

        public Criteria andOciCreateuserNotEqualTo(String value) {
            addCriterion("oci_createuser <>", value, "ociCreateuser");
            return (Criteria) this;
        }

        public Criteria andOciCreateuserGreaterThan(String value) {
            addCriterion("oci_createuser >", value, "ociCreateuser");
            return (Criteria) this;
        }

        public Criteria andOciCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("oci_createuser >=", value, "ociCreateuser");
            return (Criteria) this;
        }

        public Criteria andOciCreateuserLessThan(String value) {
            addCriterion("oci_createuser <", value, "ociCreateuser");
            return (Criteria) this;
        }

        public Criteria andOciCreateuserLessThanOrEqualTo(String value) {
            addCriterion("oci_createuser <=", value, "ociCreateuser");
            return (Criteria) this;
        }

        public Criteria andOciCreateuserLike(String value) {
            addCriterion("oci_createuser like", value, "ociCreateuser");
            return (Criteria) this;
        }

        public Criteria andOciCreateuserNotLike(String value) {
            addCriterion("oci_createuser not like", value, "ociCreateuser");
            return (Criteria) this;
        }

        public Criteria andOciCreateuserIn(List<String> values) {
            addCriterion("oci_createuser in", values, "ociCreateuser");
            return (Criteria) this;
        }

        public Criteria andOciCreateuserNotIn(List<String> values) {
            addCriterion("oci_createuser not in", values, "ociCreateuser");
            return (Criteria) this;
        }

        public Criteria andOciCreateuserBetween(String value1, String value2) {
            addCriterion("oci_createuser between", value1, value2, "ociCreateuser");
            return (Criteria) this;
        }

        public Criteria andOciCreateuserNotBetween(String value1, String value2) {
            addCriterion("oci_createuser not between", value1, value2, "ociCreateuser");
            return (Criteria) this;
        }

        public Criteria andOciUpdatedateIsNull() {
            addCriterion("oci_updatedate is null");
            return (Criteria) this;
        }

        public Criteria andOciUpdatedateIsNotNull() {
            addCriterion("oci_updatedate is not null");
            return (Criteria) this;
        }

        public Criteria andOciUpdatedateEqualTo(String value) {
            addCriterion("oci_updatedate =", value, "ociUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOciUpdatedateNotEqualTo(String value) {
            addCriterion("oci_updatedate <>", value, "ociUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOciUpdatedateGreaterThan(String value) {
            addCriterion("oci_updatedate >", value, "ociUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOciUpdatedateGreaterThanOrEqualTo(String value) {
            addCriterion("oci_updatedate >=", value, "ociUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOciUpdatedateLessThan(String value) {
            addCriterion("oci_updatedate <", value, "ociUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOciUpdatedateLessThanOrEqualTo(String value) {
            addCriterion("oci_updatedate <=", value, "ociUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOciUpdatedateLike(String value) {
            addCriterion("oci_updatedate like", value, "ociUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOciUpdatedateNotLike(String value) {
            addCriterion("oci_updatedate not like", value, "ociUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOciUpdatedateIn(List<String> values) {
            addCriterion("oci_updatedate in", values, "ociUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOciUpdatedateNotIn(List<String> values) {
            addCriterion("oci_updatedate not in", values, "ociUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOciUpdatedateBetween(String value1, String value2) {
            addCriterion("oci_updatedate between", value1, value2, "ociUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOciUpdatedateNotBetween(String value1, String value2) {
            addCriterion("oci_updatedate not between", value1, value2, "ociUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOciUpdateuserIsNull() {
            addCriterion("oci_updateuser is null");
            return (Criteria) this;
        }

        public Criteria andOciUpdateuserIsNotNull() {
            addCriterion("oci_updateuser is not null");
            return (Criteria) this;
        }

        public Criteria andOciUpdateuserEqualTo(String value) {
            addCriterion("oci_updateuser =", value, "ociUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOciUpdateuserNotEqualTo(String value) {
            addCriterion("oci_updateuser <>", value, "ociUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOciUpdateuserGreaterThan(String value) {
            addCriterion("oci_updateuser >", value, "ociUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOciUpdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("oci_updateuser >=", value, "ociUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOciUpdateuserLessThan(String value) {
            addCriterion("oci_updateuser <", value, "ociUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOciUpdateuserLessThanOrEqualTo(String value) {
            addCriterion("oci_updateuser <=", value, "ociUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOciUpdateuserLike(String value) {
            addCriterion("oci_updateuser like", value, "ociUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOciUpdateuserNotLike(String value) {
            addCriterion("oci_updateuser not like", value, "ociUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOciUpdateuserIn(List<String> values) {
            addCriterion("oci_updateuser in", values, "ociUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOciUpdateuserNotIn(List<String> values) {
            addCriterion("oci_updateuser not in", values, "ociUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOciUpdateuserBetween(String value1, String value2) {
            addCriterion("oci_updateuser between", value1, value2, "ociUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOciUpdateuserNotBetween(String value1, String value2) {
            addCriterion("oci_updateuser not between", value1, value2, "ociUpdateuser");
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

        public Criteria andOciPhysicalCodeLikeInsensitive(String value) {
            addCriterion("upper(oci_physical_code) like", value.toUpperCase(), "ociPhysicalCode");
            return this;
        }

        public Criteria andOciCodeUrlLikeInsensitive(String value) {
            addCriterion("upper(oci_code_url) like", value.toUpperCase(), "ociCodeUrl");
            return this;
        }

        public Criteria andOciPasswordLikeInsensitive(String value) {
            addCriterion("upper(oci_password) like", value.toUpperCase(), "ociPassword");
            return this;
        }

        public Criteria andOciStatusLikeInsensitive(String value) {
            addCriterion("upper(oci_status) like", value.toUpperCase(), "ociStatus");
            return this;
        }

        public Criteria andOciCreatedateLikeInsensitive(String value) {
            addCriterion("upper(oci_createdate) like", value.toUpperCase(), "ociCreatedate");
            return this;
        }

        public Criteria andOciCreateuserLikeInsensitive(String value) {
            addCriterion("upper(oci_createuser) like", value.toUpperCase(), "ociCreateuser");
            return this;
        }

        public Criteria andOciUpdatedateLikeInsensitive(String value) {
            addCriterion("upper(oci_updatedate) like", value.toUpperCase(), "ociUpdatedate");
            return this;
        }

        public Criteria andOciUpdateuserLikeInsensitive(String value) {
            addCriterion("upper(oci_updateuser) like", value.toUpperCase(), "ociUpdateuser");
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