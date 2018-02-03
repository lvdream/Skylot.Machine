package com.fangda.skylot.mathine.model.customer;

import com.fangda.skylot.mathine.utils.Page;
import java.util.ArrayList;
import java.util.List;

public class OftbCustomerCarCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public OftbCustomerCarCriteria() {
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

        public Criteria andOccIdIsNull() {
            addCriterion("occ_id is null");
            return (Criteria) this;
        }

        public Criteria andOccIdIsNotNull() {
            addCriterion("occ_id is not null");
            return (Criteria) this;
        }

        public Criteria andOccIdEqualTo(Integer value) {
            addCriterion("occ_id =", value, "occId");
            return (Criteria) this;
        }

        public Criteria andOccIdNotEqualTo(Integer value) {
            addCriterion("occ_id <>", value, "occId");
            return (Criteria) this;
        }

        public Criteria andOccIdGreaterThan(Integer value) {
            addCriterion("occ_id >", value, "occId");
            return (Criteria) this;
        }

        public Criteria andOccIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("occ_id >=", value, "occId");
            return (Criteria) this;
        }

        public Criteria andOccIdLessThan(Integer value) {
            addCriterion("occ_id <", value, "occId");
            return (Criteria) this;
        }

        public Criteria andOccIdLessThanOrEqualTo(Integer value) {
            addCriterion("occ_id <=", value, "occId");
            return (Criteria) this;
        }

        public Criteria andOccIdIn(List<Integer> values) {
            addCriterion("occ_id in", values, "occId");
            return (Criteria) this;
        }

        public Criteria andOccIdNotIn(List<Integer> values) {
            addCriterion("occ_id not in", values, "occId");
            return (Criteria) this;
        }

        public Criteria andOccIdBetween(Integer value1, Integer value2) {
            addCriterion("occ_id between", value1, value2, "occId");
            return (Criteria) this;
        }

        public Criteria andOccIdNotBetween(Integer value1, Integer value2) {
            addCriterion("occ_id not between", value1, value2, "occId");
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

        public Criteria andOccNameIsNull() {
            addCriterion("occ_name is null");
            return (Criteria) this;
        }

        public Criteria andOccNameIsNotNull() {
            addCriterion("occ_name is not null");
            return (Criteria) this;
        }

        public Criteria andOccNameEqualTo(String value) {
            addCriterion("occ_name =", value, "occName");
            return (Criteria) this;
        }

        public Criteria andOccNameNotEqualTo(String value) {
            addCriterion("occ_name <>", value, "occName");
            return (Criteria) this;
        }

        public Criteria andOccNameGreaterThan(String value) {
            addCriterion("occ_name >", value, "occName");
            return (Criteria) this;
        }

        public Criteria andOccNameGreaterThanOrEqualTo(String value) {
            addCriterion("occ_name >=", value, "occName");
            return (Criteria) this;
        }

        public Criteria andOccNameLessThan(String value) {
            addCriterion("occ_name <", value, "occName");
            return (Criteria) this;
        }

        public Criteria andOccNameLessThanOrEqualTo(String value) {
            addCriterion("occ_name <=", value, "occName");
            return (Criteria) this;
        }

        public Criteria andOccNameLike(String value) {
            addCriterion("occ_name like", value, "occName");
            return (Criteria) this;
        }

        public Criteria andOccNameNotLike(String value) {
            addCriterion("occ_name not like", value, "occName");
            return (Criteria) this;
        }

        public Criteria andOccNameIn(List<String> values) {
            addCriterion("occ_name in", values, "occName");
            return (Criteria) this;
        }

        public Criteria andOccNameNotIn(List<String> values) {
            addCriterion("occ_name not in", values, "occName");
            return (Criteria) this;
        }

        public Criteria andOccNameBetween(String value1, String value2) {
            addCriterion("occ_name between", value1, value2, "occName");
            return (Criteria) this;
        }

        public Criteria andOccNameNotBetween(String value1, String value2) {
            addCriterion("occ_name not between", value1, value2, "occName");
            return (Criteria) this;
        }

        public Criteria andOccCodeIsNull() {
            addCriterion("occ_code is null");
            return (Criteria) this;
        }

        public Criteria andOccCodeIsNotNull() {
            addCriterion("occ_code is not null");
            return (Criteria) this;
        }

        public Criteria andOccCodeEqualTo(String value) {
            addCriterion("occ_code =", value, "occCode");
            return (Criteria) this;
        }

        public Criteria andOccCodeNotEqualTo(String value) {
            addCriterion("occ_code <>", value, "occCode");
            return (Criteria) this;
        }

        public Criteria andOccCodeGreaterThan(String value) {
            addCriterion("occ_code >", value, "occCode");
            return (Criteria) this;
        }

        public Criteria andOccCodeGreaterThanOrEqualTo(String value) {
            addCriterion("occ_code >=", value, "occCode");
            return (Criteria) this;
        }

        public Criteria andOccCodeLessThan(String value) {
            addCriterion("occ_code <", value, "occCode");
            return (Criteria) this;
        }

        public Criteria andOccCodeLessThanOrEqualTo(String value) {
            addCriterion("occ_code <=", value, "occCode");
            return (Criteria) this;
        }

        public Criteria andOccCodeLike(String value) {
            addCriterion("occ_code like", value, "occCode");
            return (Criteria) this;
        }

        public Criteria andOccCodeNotLike(String value) {
            addCriterion("occ_code not like", value, "occCode");
            return (Criteria) this;
        }

        public Criteria andOccCodeIn(List<String> values) {
            addCriterion("occ_code in", values, "occCode");
            return (Criteria) this;
        }

        public Criteria andOccCodeNotIn(List<String> values) {
            addCriterion("occ_code not in", values, "occCode");
            return (Criteria) this;
        }

        public Criteria andOccCodeBetween(String value1, String value2) {
            addCriterion("occ_code between", value1, value2, "occCode");
            return (Criteria) this;
        }

        public Criteria andOccCodeNotBetween(String value1, String value2) {
            addCriterion("occ_code not between", value1, value2, "occCode");
            return (Criteria) this;
        }

        public Criteria andOccTypeIsNull() {
            addCriterion("occ_type is null");
            return (Criteria) this;
        }

        public Criteria andOccTypeIsNotNull() {
            addCriterion("occ_type is not null");
            return (Criteria) this;
        }

        public Criteria andOccTypeEqualTo(String value) {
            addCriterion("occ_type =", value, "occType");
            return (Criteria) this;
        }

        public Criteria andOccTypeNotEqualTo(String value) {
            addCriterion("occ_type <>", value, "occType");
            return (Criteria) this;
        }

        public Criteria andOccTypeGreaterThan(String value) {
            addCriterion("occ_type >", value, "occType");
            return (Criteria) this;
        }

        public Criteria andOccTypeGreaterThanOrEqualTo(String value) {
            addCriterion("occ_type >=", value, "occType");
            return (Criteria) this;
        }

        public Criteria andOccTypeLessThan(String value) {
            addCriterion("occ_type <", value, "occType");
            return (Criteria) this;
        }

        public Criteria andOccTypeLessThanOrEqualTo(String value) {
            addCriterion("occ_type <=", value, "occType");
            return (Criteria) this;
        }

        public Criteria andOccTypeLike(String value) {
            addCriterion("occ_type like", value, "occType");
            return (Criteria) this;
        }

        public Criteria andOccTypeNotLike(String value) {
            addCriterion("occ_type not like", value, "occType");
            return (Criteria) this;
        }

        public Criteria andOccTypeIn(List<String> values) {
            addCriterion("occ_type in", values, "occType");
            return (Criteria) this;
        }

        public Criteria andOccTypeNotIn(List<String> values) {
            addCriterion("occ_type not in", values, "occType");
            return (Criteria) this;
        }

        public Criteria andOccTypeBetween(String value1, String value2) {
            addCriterion("occ_type between", value1, value2, "occType");
            return (Criteria) this;
        }

        public Criteria andOccTypeNotBetween(String value1, String value2) {
            addCriterion("occ_type not between", value1, value2, "occType");
            return (Criteria) this;
        }

        public Criteria andOccStatusIsNull() {
            addCriterion("occ_status is null");
            return (Criteria) this;
        }

        public Criteria andOccStatusIsNotNull() {
            addCriterion("occ_status is not null");
            return (Criteria) this;
        }

        public Criteria andOccStatusEqualTo(String value) {
            addCriterion("occ_status =", value, "occStatus");
            return (Criteria) this;
        }

        public Criteria andOccStatusNotEqualTo(String value) {
            addCriterion("occ_status <>", value, "occStatus");
            return (Criteria) this;
        }

        public Criteria andOccStatusGreaterThan(String value) {
            addCriterion("occ_status >", value, "occStatus");
            return (Criteria) this;
        }

        public Criteria andOccStatusGreaterThanOrEqualTo(String value) {
            addCriterion("occ_status >=", value, "occStatus");
            return (Criteria) this;
        }

        public Criteria andOccStatusLessThan(String value) {
            addCriterion("occ_status <", value, "occStatus");
            return (Criteria) this;
        }

        public Criteria andOccStatusLessThanOrEqualTo(String value) {
            addCriterion("occ_status <=", value, "occStatus");
            return (Criteria) this;
        }

        public Criteria andOccStatusLike(String value) {
            addCriterion("occ_status like", value, "occStatus");
            return (Criteria) this;
        }

        public Criteria andOccStatusNotLike(String value) {
            addCriterion("occ_status not like", value, "occStatus");
            return (Criteria) this;
        }

        public Criteria andOccStatusIn(List<String> values) {
            addCriterion("occ_status in", values, "occStatus");
            return (Criteria) this;
        }

        public Criteria andOccStatusNotIn(List<String> values) {
            addCriterion("occ_status not in", values, "occStatus");
            return (Criteria) this;
        }

        public Criteria andOccStatusBetween(String value1, String value2) {
            addCriterion("occ_status between", value1, value2, "occStatus");
            return (Criteria) this;
        }

        public Criteria andOccStatusNotBetween(String value1, String value2) {
            addCriterion("occ_status not between", value1, value2, "occStatus");
            return (Criteria) this;
        }

        public Criteria andOccCreateuserIsNull() {
            addCriterion("occ_createuser is null");
            return (Criteria) this;
        }

        public Criteria andOccCreateuserIsNotNull() {
            addCriterion("occ_createuser is not null");
            return (Criteria) this;
        }

        public Criteria andOccCreateuserEqualTo(String value) {
            addCriterion("occ_createuser =", value, "occCreateuser");
            return (Criteria) this;
        }

        public Criteria andOccCreateuserNotEqualTo(String value) {
            addCriterion("occ_createuser <>", value, "occCreateuser");
            return (Criteria) this;
        }

        public Criteria andOccCreateuserGreaterThan(String value) {
            addCriterion("occ_createuser >", value, "occCreateuser");
            return (Criteria) this;
        }

        public Criteria andOccCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("occ_createuser >=", value, "occCreateuser");
            return (Criteria) this;
        }

        public Criteria andOccCreateuserLessThan(String value) {
            addCriterion("occ_createuser <", value, "occCreateuser");
            return (Criteria) this;
        }

        public Criteria andOccCreateuserLessThanOrEqualTo(String value) {
            addCriterion("occ_createuser <=", value, "occCreateuser");
            return (Criteria) this;
        }

        public Criteria andOccCreateuserLike(String value) {
            addCriterion("occ_createuser like", value, "occCreateuser");
            return (Criteria) this;
        }

        public Criteria andOccCreateuserNotLike(String value) {
            addCriterion("occ_createuser not like", value, "occCreateuser");
            return (Criteria) this;
        }

        public Criteria andOccCreateuserIn(List<String> values) {
            addCriterion("occ_createuser in", values, "occCreateuser");
            return (Criteria) this;
        }

        public Criteria andOccCreateuserNotIn(List<String> values) {
            addCriterion("occ_createuser not in", values, "occCreateuser");
            return (Criteria) this;
        }

        public Criteria andOccCreateuserBetween(String value1, String value2) {
            addCriterion("occ_createuser between", value1, value2, "occCreateuser");
            return (Criteria) this;
        }

        public Criteria andOccCreateuserNotBetween(String value1, String value2) {
            addCriterion("occ_createuser not between", value1, value2, "occCreateuser");
            return (Criteria) this;
        }

        public Criteria andOccCreatedateIsNull() {
            addCriterion("occ_createdate is null");
            return (Criteria) this;
        }

        public Criteria andOccCreatedateIsNotNull() {
            addCriterion("occ_createdate is not null");
            return (Criteria) this;
        }

        public Criteria andOccCreatedateEqualTo(String value) {
            addCriterion("occ_createdate =", value, "occCreatedate");
            return (Criteria) this;
        }

        public Criteria andOccCreatedateNotEqualTo(String value) {
            addCriterion("occ_createdate <>", value, "occCreatedate");
            return (Criteria) this;
        }

        public Criteria andOccCreatedateGreaterThan(String value) {
            addCriterion("occ_createdate >", value, "occCreatedate");
            return (Criteria) this;
        }

        public Criteria andOccCreatedateGreaterThanOrEqualTo(String value) {
            addCriterion("occ_createdate >=", value, "occCreatedate");
            return (Criteria) this;
        }

        public Criteria andOccCreatedateLessThan(String value) {
            addCriterion("occ_createdate <", value, "occCreatedate");
            return (Criteria) this;
        }

        public Criteria andOccCreatedateLessThanOrEqualTo(String value) {
            addCriterion("occ_createdate <=", value, "occCreatedate");
            return (Criteria) this;
        }

        public Criteria andOccCreatedateLike(String value) {
            addCriterion("occ_createdate like", value, "occCreatedate");
            return (Criteria) this;
        }

        public Criteria andOccCreatedateNotLike(String value) {
            addCriterion("occ_createdate not like", value, "occCreatedate");
            return (Criteria) this;
        }

        public Criteria andOccCreatedateIn(List<String> values) {
            addCriterion("occ_createdate in", values, "occCreatedate");
            return (Criteria) this;
        }

        public Criteria andOccCreatedateNotIn(List<String> values) {
            addCriterion("occ_createdate not in", values, "occCreatedate");
            return (Criteria) this;
        }

        public Criteria andOccCreatedateBetween(String value1, String value2) {
            addCriterion("occ_createdate between", value1, value2, "occCreatedate");
            return (Criteria) this;
        }

        public Criteria andOccCreatedateNotBetween(String value1, String value2) {
            addCriterion("occ_createdate not between", value1, value2, "occCreatedate");
            return (Criteria) this;
        }

        public Criteria andOccUpdateuserIsNull() {
            addCriterion("occ_updateuser is null");
            return (Criteria) this;
        }

        public Criteria andOccUpdateuserIsNotNull() {
            addCriterion("occ_updateuser is not null");
            return (Criteria) this;
        }

        public Criteria andOccUpdateuserEqualTo(String value) {
            addCriterion("occ_updateuser =", value, "occUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOccUpdateuserNotEqualTo(String value) {
            addCriterion("occ_updateuser <>", value, "occUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOccUpdateuserGreaterThan(String value) {
            addCriterion("occ_updateuser >", value, "occUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOccUpdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("occ_updateuser >=", value, "occUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOccUpdateuserLessThan(String value) {
            addCriterion("occ_updateuser <", value, "occUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOccUpdateuserLessThanOrEqualTo(String value) {
            addCriterion("occ_updateuser <=", value, "occUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOccUpdateuserLike(String value) {
            addCriterion("occ_updateuser like", value, "occUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOccUpdateuserNotLike(String value) {
            addCriterion("occ_updateuser not like", value, "occUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOccUpdateuserIn(List<String> values) {
            addCriterion("occ_updateuser in", values, "occUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOccUpdateuserNotIn(List<String> values) {
            addCriterion("occ_updateuser not in", values, "occUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOccUpdateuserBetween(String value1, String value2) {
            addCriterion("occ_updateuser between", value1, value2, "occUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOccUpdateuserNotBetween(String value1, String value2) {
            addCriterion("occ_updateuser not between", value1, value2, "occUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOccUpdatedateIsNull() {
            addCriterion("occ_updatedate is null");
            return (Criteria) this;
        }

        public Criteria andOccUpdatedateIsNotNull() {
            addCriterion("occ_updatedate is not null");
            return (Criteria) this;
        }

        public Criteria andOccUpdatedateEqualTo(String value) {
            addCriterion("occ_updatedate =", value, "occUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOccUpdatedateNotEqualTo(String value) {
            addCriterion("occ_updatedate <>", value, "occUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOccUpdatedateGreaterThan(String value) {
            addCriterion("occ_updatedate >", value, "occUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOccUpdatedateGreaterThanOrEqualTo(String value) {
            addCriterion("occ_updatedate >=", value, "occUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOccUpdatedateLessThan(String value) {
            addCriterion("occ_updatedate <", value, "occUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOccUpdatedateLessThanOrEqualTo(String value) {
            addCriterion("occ_updatedate <=", value, "occUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOccUpdatedateLike(String value) {
            addCriterion("occ_updatedate like", value, "occUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOccUpdatedateNotLike(String value) {
            addCriterion("occ_updatedate not like", value, "occUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOccUpdatedateIn(List<String> values) {
            addCriterion("occ_updatedate in", values, "occUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOccUpdatedateNotIn(List<String> values) {
            addCriterion("occ_updatedate not in", values, "occUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOccUpdatedateBetween(String value1, String value2) {
            addCriterion("occ_updatedate between", value1, value2, "occUpdatedate");
            return (Criteria) this;
        }

        public Criteria andOccUpdatedateNotBetween(String value1, String value2) {
            addCriterion("occ_updatedate not between", value1, value2, "occUpdatedate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andOccNameLikeInsensitive(String value) {
            addCriterion("upper(occ_name) like", value.toUpperCase(), "occName");
            return this;
        }

        public Criteria andOccCodeLikeInsensitive(String value) {
            addCriterion("upper(occ_code) like", value.toUpperCase(), "occCode");
            return this;
        }

        public Criteria andOccTypeLikeInsensitive(String value) {
            addCriterion("upper(occ_type) like", value.toUpperCase(), "occType");
            return this;
        }

        public Criteria andOccStatusLikeInsensitive(String value) {
            addCriterion("upper(occ_status) like", value.toUpperCase(), "occStatus");
            return this;
        }

        public Criteria andOccCreateuserLikeInsensitive(String value) {
            addCriterion("upper(occ_createuser) like", value.toUpperCase(), "occCreateuser");
            return this;
        }

        public Criteria andOccCreatedateLikeInsensitive(String value) {
            addCriterion("upper(occ_createdate) like", value.toUpperCase(), "occCreatedate");
            return this;
        }

        public Criteria andOccUpdateuserLikeInsensitive(String value) {
            addCriterion("upper(occ_updateuser) like", value.toUpperCase(), "occUpdateuser");
            return this;
        }

        public Criteria andOccUpdatedateLikeInsensitive(String value) {
            addCriterion("upper(occ_updatedate) like", value.toUpperCase(), "occUpdatedate");
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