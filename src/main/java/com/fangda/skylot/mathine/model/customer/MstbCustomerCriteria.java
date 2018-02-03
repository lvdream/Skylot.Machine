package com.fangda.skylot.mathine.model.customer;

import com.fangda.skylot.mathine.utils.Page;
import java.util.ArrayList;
import java.util.List;

public class MstbCustomerCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public MstbCustomerCriteria() {
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

        public Criteria andMcCodeIsNull() {
            addCriterion("mc_code is null");
            return (Criteria) this;
        }

        public Criteria andMcCodeIsNotNull() {
            addCriterion("mc_code is not null");
            return (Criteria) this;
        }

        public Criteria andMcCodeEqualTo(String value) {
            addCriterion("mc_code =", value, "mcCode");
            return (Criteria) this;
        }

        public Criteria andMcCodeNotEqualTo(String value) {
            addCriterion("mc_code <>", value, "mcCode");
            return (Criteria) this;
        }

        public Criteria andMcCodeGreaterThan(String value) {
            addCriterion("mc_code >", value, "mcCode");
            return (Criteria) this;
        }

        public Criteria andMcCodeGreaterThanOrEqualTo(String value) {
            addCriterion("mc_code >=", value, "mcCode");
            return (Criteria) this;
        }

        public Criteria andMcCodeLessThan(String value) {
            addCriterion("mc_code <", value, "mcCode");
            return (Criteria) this;
        }

        public Criteria andMcCodeLessThanOrEqualTo(String value) {
            addCriterion("mc_code <=", value, "mcCode");
            return (Criteria) this;
        }

        public Criteria andMcCodeLike(String value) {
            addCriterion("mc_code like", value, "mcCode");
            return (Criteria) this;
        }

        public Criteria andMcCodeNotLike(String value) {
            addCriterion("mc_code not like", value, "mcCode");
            return (Criteria) this;
        }

        public Criteria andMcCodeIn(List<String> values) {
            addCriterion("mc_code in", values, "mcCode");
            return (Criteria) this;
        }

        public Criteria andMcCodeNotIn(List<String> values) {
            addCriterion("mc_code not in", values, "mcCode");
            return (Criteria) this;
        }

        public Criteria andMcCodeBetween(String value1, String value2) {
            addCriterion("mc_code between", value1, value2, "mcCode");
            return (Criteria) this;
        }

        public Criteria andMcCodeNotBetween(String value1, String value2) {
            addCriterion("mc_code not between", value1, value2, "mcCode");
            return (Criteria) this;
        }

        public Criteria andMcPassIsNull() {
            addCriterion("mc_pass is null");
            return (Criteria) this;
        }

        public Criteria andMcPassIsNotNull() {
            addCriterion("mc_pass is not null");
            return (Criteria) this;
        }

        public Criteria andMcPassEqualTo(String value) {
            addCriterion("mc_pass =", value, "mcPass");
            return (Criteria) this;
        }

        public Criteria andMcPassNotEqualTo(String value) {
            addCriterion("mc_pass <>", value, "mcPass");
            return (Criteria) this;
        }

        public Criteria andMcPassGreaterThan(String value) {
            addCriterion("mc_pass >", value, "mcPass");
            return (Criteria) this;
        }

        public Criteria andMcPassGreaterThanOrEqualTo(String value) {
            addCriterion("mc_pass >=", value, "mcPass");
            return (Criteria) this;
        }

        public Criteria andMcPassLessThan(String value) {
            addCriterion("mc_pass <", value, "mcPass");
            return (Criteria) this;
        }

        public Criteria andMcPassLessThanOrEqualTo(String value) {
            addCriterion("mc_pass <=", value, "mcPass");
            return (Criteria) this;
        }

        public Criteria andMcPassLike(String value) {
            addCriterion("mc_pass like", value, "mcPass");
            return (Criteria) this;
        }

        public Criteria andMcPassNotLike(String value) {
            addCriterion("mc_pass not like", value, "mcPass");
            return (Criteria) this;
        }

        public Criteria andMcPassIn(List<String> values) {
            addCriterion("mc_pass in", values, "mcPass");
            return (Criteria) this;
        }

        public Criteria andMcPassNotIn(List<String> values) {
            addCriterion("mc_pass not in", values, "mcPass");
            return (Criteria) this;
        }

        public Criteria andMcPassBetween(String value1, String value2) {
            addCriterion("mc_pass between", value1, value2, "mcPass");
            return (Criteria) this;
        }

        public Criteria andMcPassNotBetween(String value1, String value2) {
            addCriterion("mc_pass not between", value1, value2, "mcPass");
            return (Criteria) this;
        }

        public Criteria andMcNameCnIsNull() {
            addCriterion("mc_name_cn is null");
            return (Criteria) this;
        }

        public Criteria andMcNameCnIsNotNull() {
            addCriterion("mc_name_cn is not null");
            return (Criteria) this;
        }

        public Criteria andMcNameCnEqualTo(String value) {
            addCriterion("mc_name_cn =", value, "mcNameCn");
            return (Criteria) this;
        }

        public Criteria andMcNameCnNotEqualTo(String value) {
            addCriterion("mc_name_cn <>", value, "mcNameCn");
            return (Criteria) this;
        }

        public Criteria andMcNameCnGreaterThan(String value) {
            addCriterion("mc_name_cn >", value, "mcNameCn");
            return (Criteria) this;
        }

        public Criteria andMcNameCnGreaterThanOrEqualTo(String value) {
            addCriterion("mc_name_cn >=", value, "mcNameCn");
            return (Criteria) this;
        }

        public Criteria andMcNameCnLessThan(String value) {
            addCriterion("mc_name_cn <", value, "mcNameCn");
            return (Criteria) this;
        }

        public Criteria andMcNameCnLessThanOrEqualTo(String value) {
            addCriterion("mc_name_cn <=", value, "mcNameCn");
            return (Criteria) this;
        }

        public Criteria andMcNameCnLike(String value) {
            addCriterion("mc_name_cn like", value, "mcNameCn");
            return (Criteria) this;
        }

        public Criteria andMcNameCnNotLike(String value) {
            addCriterion("mc_name_cn not like", value, "mcNameCn");
            return (Criteria) this;
        }

        public Criteria andMcNameCnIn(List<String> values) {
            addCriterion("mc_name_cn in", values, "mcNameCn");
            return (Criteria) this;
        }

        public Criteria andMcNameCnNotIn(List<String> values) {
            addCriterion("mc_name_cn not in", values, "mcNameCn");
            return (Criteria) this;
        }

        public Criteria andMcNameCnBetween(String value1, String value2) {
            addCriterion("mc_name_cn between", value1, value2, "mcNameCn");
            return (Criteria) this;
        }

        public Criteria andMcNameCnNotBetween(String value1, String value2) {
            addCriterion("mc_name_cn not between", value1, value2, "mcNameCn");
            return (Criteria) this;
        }

        public Criteria andMcMobileIsNull() {
            addCriterion("mc_mobile is null");
            return (Criteria) this;
        }

        public Criteria andMcMobileIsNotNull() {
            addCriterion("mc_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMcMobileEqualTo(String value) {
            addCriterion("mc_mobile =", value, "mcMobile");
            return (Criteria) this;
        }

        public Criteria andMcMobileNotEqualTo(String value) {
            addCriterion("mc_mobile <>", value, "mcMobile");
            return (Criteria) this;
        }

        public Criteria andMcMobileGreaterThan(String value) {
            addCriterion("mc_mobile >", value, "mcMobile");
            return (Criteria) this;
        }

        public Criteria andMcMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mc_mobile >=", value, "mcMobile");
            return (Criteria) this;
        }

        public Criteria andMcMobileLessThan(String value) {
            addCriterion("mc_mobile <", value, "mcMobile");
            return (Criteria) this;
        }

        public Criteria andMcMobileLessThanOrEqualTo(String value) {
            addCriterion("mc_mobile <=", value, "mcMobile");
            return (Criteria) this;
        }

        public Criteria andMcMobileLike(String value) {
            addCriterion("mc_mobile like", value, "mcMobile");
            return (Criteria) this;
        }

        public Criteria andMcMobileNotLike(String value) {
            addCriterion("mc_mobile not like", value, "mcMobile");
            return (Criteria) this;
        }

        public Criteria andMcMobileIn(List<String> values) {
            addCriterion("mc_mobile in", values, "mcMobile");
            return (Criteria) this;
        }

        public Criteria andMcMobileNotIn(List<String> values) {
            addCriterion("mc_mobile not in", values, "mcMobile");
            return (Criteria) this;
        }

        public Criteria andMcMobileBetween(String value1, String value2) {
            addCriterion("mc_mobile between", value1, value2, "mcMobile");
            return (Criteria) this;
        }

        public Criteria andMcMobileNotBetween(String value1, String value2) {
            addCriterion("mc_mobile not between", value1, value2, "mcMobile");
            return (Criteria) this;
        }

        public Criteria andMcTypeIsNull() {
            addCriterion("mc_type is null");
            return (Criteria) this;
        }

        public Criteria andMcTypeIsNotNull() {
            addCriterion("mc_type is not null");
            return (Criteria) this;
        }

        public Criteria andMcTypeEqualTo(String value) {
            addCriterion("mc_type =", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeNotEqualTo(String value) {
            addCriterion("mc_type <>", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeGreaterThan(String value) {
            addCriterion("mc_type >", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeGreaterThanOrEqualTo(String value) {
            addCriterion("mc_type >=", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeLessThan(String value) {
            addCriterion("mc_type <", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeLessThanOrEqualTo(String value) {
            addCriterion("mc_type <=", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeLike(String value) {
            addCriterion("mc_type like", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeNotLike(String value) {
            addCriterion("mc_type not like", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeIn(List<String> values) {
            addCriterion("mc_type in", values, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeNotIn(List<String> values) {
            addCriterion("mc_type not in", values, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeBetween(String value1, String value2) {
            addCriterion("mc_type between", value1, value2, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeNotBetween(String value1, String value2) {
            addCriterion("mc_type not between", value1, value2, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcStatusIsNull() {
            addCriterion("mc_status is null");
            return (Criteria) this;
        }

        public Criteria andMcStatusIsNotNull() {
            addCriterion("mc_status is not null");
            return (Criteria) this;
        }

        public Criteria andMcStatusEqualTo(String value) {
            addCriterion("mc_status =", value, "mcStatus");
            return (Criteria) this;
        }

        public Criteria andMcStatusNotEqualTo(String value) {
            addCriterion("mc_status <>", value, "mcStatus");
            return (Criteria) this;
        }

        public Criteria andMcStatusGreaterThan(String value) {
            addCriterion("mc_status >", value, "mcStatus");
            return (Criteria) this;
        }

        public Criteria andMcStatusGreaterThanOrEqualTo(String value) {
            addCriterion("mc_status >=", value, "mcStatus");
            return (Criteria) this;
        }

        public Criteria andMcStatusLessThan(String value) {
            addCriterion("mc_status <", value, "mcStatus");
            return (Criteria) this;
        }

        public Criteria andMcStatusLessThanOrEqualTo(String value) {
            addCriterion("mc_status <=", value, "mcStatus");
            return (Criteria) this;
        }

        public Criteria andMcStatusLike(String value) {
            addCriterion("mc_status like", value, "mcStatus");
            return (Criteria) this;
        }

        public Criteria andMcStatusNotLike(String value) {
            addCriterion("mc_status not like", value, "mcStatus");
            return (Criteria) this;
        }

        public Criteria andMcStatusIn(List<String> values) {
            addCriterion("mc_status in", values, "mcStatus");
            return (Criteria) this;
        }

        public Criteria andMcStatusNotIn(List<String> values) {
            addCriterion("mc_status not in", values, "mcStatus");
            return (Criteria) this;
        }

        public Criteria andMcStatusBetween(String value1, String value2) {
            addCriterion("mc_status between", value1, value2, "mcStatus");
            return (Criteria) this;
        }

        public Criteria andMcStatusNotBetween(String value1, String value2) {
            addCriterion("mc_status not between", value1, value2, "mcStatus");
            return (Criteria) this;
        }

        public Criteria andMcVerifyCodeIsNull() {
            addCriterion("mc_verify_code is null");
            return (Criteria) this;
        }

        public Criteria andMcVerifyCodeIsNotNull() {
            addCriterion("mc_verify_code is not null");
            return (Criteria) this;
        }

        public Criteria andMcVerifyCodeEqualTo(String value) {
            addCriterion("mc_verify_code =", value, "mcVerifyCode");
            return (Criteria) this;
        }

        public Criteria andMcVerifyCodeNotEqualTo(String value) {
            addCriterion("mc_verify_code <>", value, "mcVerifyCode");
            return (Criteria) this;
        }

        public Criteria andMcVerifyCodeGreaterThan(String value) {
            addCriterion("mc_verify_code >", value, "mcVerifyCode");
            return (Criteria) this;
        }

        public Criteria andMcVerifyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("mc_verify_code >=", value, "mcVerifyCode");
            return (Criteria) this;
        }

        public Criteria andMcVerifyCodeLessThan(String value) {
            addCriterion("mc_verify_code <", value, "mcVerifyCode");
            return (Criteria) this;
        }

        public Criteria andMcVerifyCodeLessThanOrEqualTo(String value) {
            addCriterion("mc_verify_code <=", value, "mcVerifyCode");
            return (Criteria) this;
        }

        public Criteria andMcVerifyCodeLike(String value) {
            addCriterion("mc_verify_code like", value, "mcVerifyCode");
            return (Criteria) this;
        }

        public Criteria andMcVerifyCodeNotLike(String value) {
            addCriterion("mc_verify_code not like", value, "mcVerifyCode");
            return (Criteria) this;
        }

        public Criteria andMcVerifyCodeIn(List<String> values) {
            addCriterion("mc_verify_code in", values, "mcVerifyCode");
            return (Criteria) this;
        }

        public Criteria andMcVerifyCodeNotIn(List<String> values) {
            addCriterion("mc_verify_code not in", values, "mcVerifyCode");
            return (Criteria) this;
        }

        public Criteria andMcVerifyCodeBetween(String value1, String value2) {
            addCriterion("mc_verify_code between", value1, value2, "mcVerifyCode");
            return (Criteria) this;
        }

        public Criteria andMcVerifyCodeNotBetween(String value1, String value2) {
            addCriterion("mc_verify_code not between", value1, value2, "mcVerifyCode");
            return (Criteria) this;
        }

        public Criteria andMcCreatedateIsNull() {
            addCriterion("mc_createdate is null");
            return (Criteria) this;
        }

        public Criteria andMcCreatedateIsNotNull() {
            addCriterion("mc_createdate is not null");
            return (Criteria) this;
        }

        public Criteria andMcCreatedateEqualTo(String value) {
            addCriterion("mc_createdate =", value, "mcCreatedate");
            return (Criteria) this;
        }

        public Criteria andMcCreatedateNotEqualTo(String value) {
            addCriterion("mc_createdate <>", value, "mcCreatedate");
            return (Criteria) this;
        }

        public Criteria andMcCreatedateGreaterThan(String value) {
            addCriterion("mc_createdate >", value, "mcCreatedate");
            return (Criteria) this;
        }

        public Criteria andMcCreatedateGreaterThanOrEqualTo(String value) {
            addCriterion("mc_createdate >=", value, "mcCreatedate");
            return (Criteria) this;
        }

        public Criteria andMcCreatedateLessThan(String value) {
            addCriterion("mc_createdate <", value, "mcCreatedate");
            return (Criteria) this;
        }

        public Criteria andMcCreatedateLessThanOrEqualTo(String value) {
            addCriterion("mc_createdate <=", value, "mcCreatedate");
            return (Criteria) this;
        }

        public Criteria andMcCreatedateLike(String value) {
            addCriterion("mc_createdate like", value, "mcCreatedate");
            return (Criteria) this;
        }

        public Criteria andMcCreatedateNotLike(String value) {
            addCriterion("mc_createdate not like", value, "mcCreatedate");
            return (Criteria) this;
        }

        public Criteria andMcCreatedateIn(List<String> values) {
            addCriterion("mc_createdate in", values, "mcCreatedate");
            return (Criteria) this;
        }

        public Criteria andMcCreatedateNotIn(List<String> values) {
            addCriterion("mc_createdate not in", values, "mcCreatedate");
            return (Criteria) this;
        }

        public Criteria andMcCreatedateBetween(String value1, String value2) {
            addCriterion("mc_createdate between", value1, value2, "mcCreatedate");
            return (Criteria) this;
        }

        public Criteria andMcCreatedateNotBetween(String value1, String value2) {
            addCriterion("mc_createdate not between", value1, value2, "mcCreatedate");
            return (Criteria) this;
        }

        public Criteria andMcCreateuserIsNull() {
            addCriterion("mc_createuser is null");
            return (Criteria) this;
        }

        public Criteria andMcCreateuserIsNotNull() {
            addCriterion("mc_createuser is not null");
            return (Criteria) this;
        }

        public Criteria andMcCreateuserEqualTo(String value) {
            addCriterion("mc_createuser =", value, "mcCreateuser");
            return (Criteria) this;
        }

        public Criteria andMcCreateuserNotEqualTo(String value) {
            addCriterion("mc_createuser <>", value, "mcCreateuser");
            return (Criteria) this;
        }

        public Criteria andMcCreateuserGreaterThan(String value) {
            addCriterion("mc_createuser >", value, "mcCreateuser");
            return (Criteria) this;
        }

        public Criteria andMcCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("mc_createuser >=", value, "mcCreateuser");
            return (Criteria) this;
        }

        public Criteria andMcCreateuserLessThan(String value) {
            addCriterion("mc_createuser <", value, "mcCreateuser");
            return (Criteria) this;
        }

        public Criteria andMcCreateuserLessThanOrEqualTo(String value) {
            addCriterion("mc_createuser <=", value, "mcCreateuser");
            return (Criteria) this;
        }

        public Criteria andMcCreateuserLike(String value) {
            addCriterion("mc_createuser like", value, "mcCreateuser");
            return (Criteria) this;
        }

        public Criteria andMcCreateuserNotLike(String value) {
            addCriterion("mc_createuser not like", value, "mcCreateuser");
            return (Criteria) this;
        }

        public Criteria andMcCreateuserIn(List<String> values) {
            addCriterion("mc_createuser in", values, "mcCreateuser");
            return (Criteria) this;
        }

        public Criteria andMcCreateuserNotIn(List<String> values) {
            addCriterion("mc_createuser not in", values, "mcCreateuser");
            return (Criteria) this;
        }

        public Criteria andMcCreateuserBetween(String value1, String value2) {
            addCriterion("mc_createuser between", value1, value2, "mcCreateuser");
            return (Criteria) this;
        }

        public Criteria andMcCreateuserNotBetween(String value1, String value2) {
            addCriterion("mc_createuser not between", value1, value2, "mcCreateuser");
            return (Criteria) this;
        }

        public Criteria andMcUpdatedateIsNull() {
            addCriterion("mc_updatedate is null");
            return (Criteria) this;
        }

        public Criteria andMcUpdatedateIsNotNull() {
            addCriterion("mc_updatedate is not null");
            return (Criteria) this;
        }

        public Criteria andMcUpdatedateEqualTo(String value) {
            addCriterion("mc_updatedate =", value, "mcUpdatedate");
            return (Criteria) this;
        }

        public Criteria andMcUpdatedateNotEqualTo(String value) {
            addCriterion("mc_updatedate <>", value, "mcUpdatedate");
            return (Criteria) this;
        }

        public Criteria andMcUpdatedateGreaterThan(String value) {
            addCriterion("mc_updatedate >", value, "mcUpdatedate");
            return (Criteria) this;
        }

        public Criteria andMcUpdatedateGreaterThanOrEqualTo(String value) {
            addCriterion("mc_updatedate >=", value, "mcUpdatedate");
            return (Criteria) this;
        }

        public Criteria andMcUpdatedateLessThan(String value) {
            addCriterion("mc_updatedate <", value, "mcUpdatedate");
            return (Criteria) this;
        }

        public Criteria andMcUpdatedateLessThanOrEqualTo(String value) {
            addCriterion("mc_updatedate <=", value, "mcUpdatedate");
            return (Criteria) this;
        }

        public Criteria andMcUpdatedateLike(String value) {
            addCriterion("mc_updatedate like", value, "mcUpdatedate");
            return (Criteria) this;
        }

        public Criteria andMcUpdatedateNotLike(String value) {
            addCriterion("mc_updatedate not like", value, "mcUpdatedate");
            return (Criteria) this;
        }

        public Criteria andMcUpdatedateIn(List<String> values) {
            addCriterion("mc_updatedate in", values, "mcUpdatedate");
            return (Criteria) this;
        }

        public Criteria andMcUpdatedateNotIn(List<String> values) {
            addCriterion("mc_updatedate not in", values, "mcUpdatedate");
            return (Criteria) this;
        }

        public Criteria andMcUpdatedateBetween(String value1, String value2) {
            addCriterion("mc_updatedate between", value1, value2, "mcUpdatedate");
            return (Criteria) this;
        }

        public Criteria andMcUpdatedateNotBetween(String value1, String value2) {
            addCriterion("mc_updatedate not between", value1, value2, "mcUpdatedate");
            return (Criteria) this;
        }

        public Criteria andMcUpdateuserIsNull() {
            addCriterion("mc_updateuser is null");
            return (Criteria) this;
        }

        public Criteria andMcUpdateuserIsNotNull() {
            addCriterion("mc_updateuser is not null");
            return (Criteria) this;
        }

        public Criteria andMcUpdateuserEqualTo(String value) {
            addCriterion("mc_updateuser =", value, "mcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMcUpdateuserNotEqualTo(String value) {
            addCriterion("mc_updateuser <>", value, "mcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMcUpdateuserGreaterThan(String value) {
            addCriterion("mc_updateuser >", value, "mcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMcUpdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("mc_updateuser >=", value, "mcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMcUpdateuserLessThan(String value) {
            addCriterion("mc_updateuser <", value, "mcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMcUpdateuserLessThanOrEqualTo(String value) {
            addCriterion("mc_updateuser <=", value, "mcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMcUpdateuserLike(String value) {
            addCriterion("mc_updateuser like", value, "mcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMcUpdateuserNotLike(String value) {
            addCriterion("mc_updateuser not like", value, "mcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMcUpdateuserIn(List<String> values) {
            addCriterion("mc_updateuser in", values, "mcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMcUpdateuserNotIn(List<String> values) {
            addCriterion("mc_updateuser not in", values, "mcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMcUpdateuserBetween(String value1, String value2) {
            addCriterion("mc_updateuser between", value1, value2, "mcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMcUpdateuserNotBetween(String value1, String value2) {
            addCriterion("mc_updateuser not between", value1, value2, "mcUpdateuser");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andMcCodeLikeInsensitive(String value) {
            addCriterion("upper(mc_code) like", value.toUpperCase(), "mcCode");
            return this;
        }

        public Criteria andMcPassLikeInsensitive(String value) {
            addCriterion("upper(mc_pass) like", value.toUpperCase(), "mcPass");
            return this;
        }

        public Criteria andMcNameCnLikeInsensitive(String value) {
            addCriterion("upper(mc_name_cn) like", value.toUpperCase(), "mcNameCn");
            return this;
        }

        public Criteria andMcMobileLikeInsensitive(String value) {
            addCriterion("upper(mc_mobile) like", value.toUpperCase(), "mcMobile");
            return this;
        }

        public Criteria andMcTypeLikeInsensitive(String value) {
            addCriterion("upper(mc_type) like", value.toUpperCase(), "mcType");
            return this;
        }

        public Criteria andMcStatusLikeInsensitive(String value) {
            addCriterion("upper(mc_status) like", value.toUpperCase(), "mcStatus");
            return this;
        }

        public Criteria andMcVerifyCodeLikeInsensitive(String value) {
            addCriterion("upper(mc_verify_code) like", value.toUpperCase(), "mcVerifyCode");
            return this;
        }

        public Criteria andMcCreatedateLikeInsensitive(String value) {
            addCriterion("upper(mc_createdate) like", value.toUpperCase(), "mcCreatedate");
            return this;
        }

        public Criteria andMcCreateuserLikeInsensitive(String value) {
            addCriterion("upper(mc_createuser) like", value.toUpperCase(), "mcCreateuser");
            return this;
        }

        public Criteria andMcUpdatedateLikeInsensitive(String value) {
            addCriterion("upper(mc_updatedate) like", value.toUpperCase(), "mcUpdatedate");
            return this;
        }

        public Criteria andMcUpdateuserLikeInsensitive(String value) {
            addCriterion("upper(mc_updateuser) like", value.toUpperCase(), "mcUpdateuser");
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