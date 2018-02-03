package com.fangda.skylot.mathine.model.parking;

import com.fangda.skylot.mathine.utils.Page;

import java.util.ArrayList;
import java.util.List;

public class IftbMachineActionCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public IftbMachineActionCriteria() {
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

        public Criteria andMmIdIsNull() {
            addCriterion("mm_id is null");
            return (Criteria) this;
        }

        public Criteria andMmIdIsNotNull() {
            addCriterion("mm_id is not null");
            return (Criteria) this;
        }

        public Criteria andMmIdEqualTo(Integer value) {
            addCriterion("mm_id =", value, "mmId");
            return (Criteria) this;
        }

        public Criteria andMmIdNotEqualTo(Integer value) {
            addCriterion("mm_id <>", value, "mmId");
            return (Criteria) this;
        }

        public Criteria andMmIdGreaterThan(Integer value) {
            addCriterion("mm_id >", value, "mmId");
            return (Criteria) this;
        }

        public Criteria andMmIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mm_id >=", value, "mmId");
            return (Criteria) this;
        }

        public Criteria andMmIdLessThan(Integer value) {
            addCriterion("mm_id <", value, "mmId");
            return (Criteria) this;
        }

        public Criteria andMmIdLessThanOrEqualTo(Integer value) {
            addCriterion("mm_id <=", value, "mmId");
            return (Criteria) this;
        }

        public Criteria andMmIdIn(List<Integer> values) {
            addCriterion("mm_id in", values, "mmId");
            return (Criteria) this;
        }

        public Criteria andMmIdNotIn(List<Integer> values) {
            addCriterion("mm_id not in", values, "mmId");
            return (Criteria) this;
        }

        public Criteria andMmIdBetween(Integer value1, Integer value2) {
            addCriterion("mm_id between", value1, value2, "mmId");
            return (Criteria) this;
        }

        public Criteria andMmIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mm_id not between", value1, value2, "mmId");
            return (Criteria) this;
        }

        public Criteria andMaIdIsNull() {
            addCriterion("ma_id is null");
            return (Criteria) this;
        }

        public Criteria andMaIdIsNotNull() {
            addCriterion("ma_id is not null");
            return (Criteria) this;
        }

        public Criteria andMaIdEqualTo(Integer value) {
            addCriterion("ma_id =", value, "maId");
            return (Criteria) this;
        }

        public Criteria andMaIdNotEqualTo(Integer value) {
            addCriterion("ma_id <>", value, "maId");
            return (Criteria) this;
        }

        public Criteria andMaIdGreaterThan(Integer value) {
            addCriterion("ma_id >", value, "maId");
            return (Criteria) this;
        }

        public Criteria andMaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ma_id >=", value, "maId");
            return (Criteria) this;
        }

        public Criteria andMaIdLessThan(Integer value) {
            addCriterion("ma_id <", value, "maId");
            return (Criteria) this;
        }

        public Criteria andMaIdLessThanOrEqualTo(Integer value) {
            addCriterion("ma_id <=", value, "maId");
            return (Criteria) this;
        }

        public Criteria andMaIdIn(List<Integer> values) {
            addCriterion("ma_id in", values, "maId");
            return (Criteria) this;
        }

        public Criteria andMaIdNotIn(List<Integer> values) {
            addCriterion("ma_id not in", values, "maId");
            return (Criteria) this;
        }

        public Criteria andMaIdBetween(Integer value1, Integer value2) {
            addCriterion("ma_id between", value1, value2, "maId");
            return (Criteria) this;
        }

        public Criteria andMaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ma_id not between", value1, value2, "maId");
            return (Criteria) this;
        }

        public Criteria andImaCodeIsNull() {
            addCriterion("ima_code is null");
            return (Criteria) this;
        }

        public Criteria andImaCodeIsNotNull() {
            addCriterion("ima_code is not null");
            return (Criteria) this;
        }

        public Criteria andImaCodeEqualTo(String value) {
            addCriterion("ima_code =", value, "imaCode");
            return (Criteria) this;
        }

        public Criteria andImaCodeNotEqualTo(String value) {
            addCriterion("ima_code <>", value, "imaCode");
            return (Criteria) this;
        }

        public Criteria andImaCodeGreaterThan(String value) {
            addCriterion("ima_code >", value, "imaCode");
            return (Criteria) this;
        }

        public Criteria andImaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ima_code >=", value, "imaCode");
            return (Criteria) this;
        }

        public Criteria andImaCodeLessThan(String value) {
            addCriterion("ima_code <", value, "imaCode");
            return (Criteria) this;
        }

        public Criteria andImaCodeLessThanOrEqualTo(String value) {
            addCriterion("ima_code <=", value, "imaCode");
            return (Criteria) this;
        }

        public Criteria andImaCodeLike(String value) {
            addCriterion("ima_code like", value, "imaCode");
            return (Criteria) this;
        }

        public Criteria andImaCodeNotLike(String value) {
            addCriterion("ima_code not like", value, "imaCode");
            return (Criteria) this;
        }

        public Criteria andImaCodeIn(List<String> values) {
            addCriterion("ima_code in", values, "imaCode");
            return (Criteria) this;
        }

        public Criteria andImaCodeNotIn(List<String> values) {
            addCriterion("ima_code not in", values, "imaCode");
            return (Criteria) this;
        }

        public Criteria andImaCodeBetween(String value1, String value2) {
            addCriterion("ima_code between", value1, value2, "imaCode");
            return (Criteria) this;
        }

        public Criteria andImaCodeNotBetween(String value1, String value2) {
            addCriterion("ima_code not between", value1, value2, "imaCode");
            return (Criteria) this;
        }

        public Criteria andImaNameIsNull() {
            addCriterion("ima_name is null");
            return (Criteria) this;
        }

        public Criteria andImaNameIsNotNull() {
            addCriterion("ima_name is not null");
            return (Criteria) this;
        }

        public Criteria andImaNameEqualTo(String value) {
            addCriterion("ima_name =", value, "imaName");
            return (Criteria) this;
        }

        public Criteria andImaNameNotEqualTo(String value) {
            addCriterion("ima_name <>", value, "imaName");
            return (Criteria) this;
        }

        public Criteria andImaNameGreaterThan(String value) {
            addCriterion("ima_name >", value, "imaName");
            return (Criteria) this;
        }

        public Criteria andImaNameGreaterThanOrEqualTo(String value) {
            addCriterion("ima_name >=", value, "imaName");
            return (Criteria) this;
        }

        public Criteria andImaNameLessThan(String value) {
            addCriterion("ima_name <", value, "imaName");
            return (Criteria) this;
        }

        public Criteria andImaNameLessThanOrEqualTo(String value) {
            addCriterion("ima_name <=", value, "imaName");
            return (Criteria) this;
        }

        public Criteria andImaNameLike(String value) {
            addCriterion("ima_name like", value, "imaName");
            return (Criteria) this;
        }

        public Criteria andImaNameNotLike(String value) {
            addCriterion("ima_name not like", value, "imaName");
            return (Criteria) this;
        }

        public Criteria andImaNameIn(List<String> values) {
            addCriterion("ima_name in", values, "imaName");
            return (Criteria) this;
        }

        public Criteria andImaNameNotIn(List<String> values) {
            addCriterion("ima_name not in", values, "imaName");
            return (Criteria) this;
        }

        public Criteria andImaNameBetween(String value1, String value2) {
            addCriterion("ima_name between", value1, value2, "imaName");
            return (Criteria) this;
        }

        public Criteria andImaNameNotBetween(String value1, String value2) {
            addCriterion("ima_name not between", value1, value2, "imaName");
            return (Criteria) this;
        }

        public Criteria andImaAddressIsNull() {
            addCriterion("ima_address is null");
            return (Criteria) this;
        }

        public Criteria andImaAddressIsNotNull() {
            addCriterion("ima_address is not null");
            return (Criteria) this;
        }

        public Criteria andImaAddressEqualTo(String value) {
            addCriterion("ima_address =", value, "imaAddress");
            return (Criteria) this;
        }

        public Criteria andImaAddressNotEqualTo(String value) {
            addCriterion("ima_address <>", value, "imaAddress");
            return (Criteria) this;
        }

        public Criteria andImaAddressGreaterThan(String value) {
            addCriterion("ima_address >", value, "imaAddress");
            return (Criteria) this;
        }

        public Criteria andImaAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ima_address >=", value, "imaAddress");
            return (Criteria) this;
        }

        public Criteria andImaAddressLessThan(String value) {
            addCriterion("ima_address <", value, "imaAddress");
            return (Criteria) this;
        }

        public Criteria andImaAddressLessThanOrEqualTo(String value) {
            addCriterion("ima_address <=", value, "imaAddress");
            return (Criteria) this;
        }

        public Criteria andImaAddressLike(String value) {
            addCriterion("ima_address like", value, "imaAddress");
            return (Criteria) this;
        }

        public Criteria andImaAddressNotLike(String value) {
            addCriterion("ima_address not like", value, "imaAddress");
            return (Criteria) this;
        }

        public Criteria andImaAddressIn(List<String> values) {
            addCriterion("ima_address in", values, "imaAddress");
            return (Criteria) this;
        }

        public Criteria andImaAddressNotIn(List<String> values) {
            addCriterion("ima_address not in", values, "imaAddress");
            return (Criteria) this;
        }

        public Criteria andImaAddressBetween(String value1, String value2) {
            addCriterion("ima_address between", value1, value2, "imaAddress");
            return (Criteria) this;
        }

        public Criteria andImaAddressNotBetween(String value1, String value2) {
            addCriterion("ima_address not between", value1, value2, "imaAddress");
            return (Criteria) this;
        }

        public Criteria andImaPortIsNull() {
            addCriterion("ima_port is null");
            return (Criteria) this;
        }

        public Criteria andImaPortIsNotNull() {
            addCriterion("ima_port is not null");
            return (Criteria) this;
        }

        public Criteria andImaPortEqualTo(String value) {
            addCriterion("ima_port =", value, "imaPort");
            return (Criteria) this;
        }

        public Criteria andImaPortNotEqualTo(String value) {
            addCriterion("ima_port <>", value, "imaPort");
            return (Criteria) this;
        }

        public Criteria andImaPortGreaterThan(String value) {
            addCriterion("ima_port >", value, "imaPort");
            return (Criteria) this;
        }

        public Criteria andImaPortGreaterThanOrEqualTo(String value) {
            addCriterion("ima_port >=", value, "imaPort");
            return (Criteria) this;
        }

        public Criteria andImaPortLessThan(String value) {
            addCriterion("ima_port <", value, "imaPort");
            return (Criteria) this;
        }

        public Criteria andImaPortLessThanOrEqualTo(String value) {
            addCriterion("ima_port <=", value, "imaPort");
            return (Criteria) this;
        }

        public Criteria andImaPortLike(String value) {
            addCriterion("ima_port like", value, "imaPort");
            return (Criteria) this;
        }

        public Criteria andImaPortNotLike(String value) {
            addCriterion("ima_port not like", value, "imaPort");
            return (Criteria) this;
        }

        public Criteria andImaPortIn(List<String> values) {
            addCriterion("ima_port in", values, "imaPort");
            return (Criteria) this;
        }

        public Criteria andImaPortNotIn(List<String> values) {
            addCriterion("ima_port not in", values, "imaPort");
            return (Criteria) this;
        }

        public Criteria andImaPortBetween(String value1, String value2) {
            addCriterion("ima_port between", value1, value2, "imaPort");
            return (Criteria) this;
        }

        public Criteria andImaPortNotBetween(String value1, String value2) {
            addCriterion("ima_port not between", value1, value2, "imaPort");
            return (Criteria) this;
        }

        public Criteria andImaStatusIsNull() {
            addCriterion("ima_status is null");
            return (Criteria) this;
        }

        public Criteria andImaStatusIsNotNull() {
            addCriterion("ima_status is not null");
            return (Criteria) this;
        }

        public Criteria andImaStatusEqualTo(String value) {
            addCriterion("ima_status =", value, "imaStatus");
            return (Criteria) this;
        }

        public Criteria andImaStatusNotEqualTo(String value) {
            addCriterion("ima_status <>", value, "imaStatus");
            return (Criteria) this;
        }

        public Criteria andImaStatusGreaterThan(String value) {
            addCriterion("ima_status >", value, "imaStatus");
            return (Criteria) this;
        }

        public Criteria andImaStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ima_status >=", value, "imaStatus");
            return (Criteria) this;
        }

        public Criteria andImaStatusLessThan(String value) {
            addCriterion("ima_status <", value, "imaStatus");
            return (Criteria) this;
        }

        public Criteria andImaStatusLessThanOrEqualTo(String value) {
            addCriterion("ima_status <=", value, "imaStatus");
            return (Criteria) this;
        }

        public Criteria andImaStatusLike(String value) {
            addCriterion("ima_status like", value, "imaStatus");
            return (Criteria) this;
        }

        public Criteria andImaStatusNotLike(String value) {
            addCriterion("ima_status not like", value, "imaStatus");
            return (Criteria) this;
        }

        public Criteria andImaStatusIn(List<String> values) {
            addCriterion("ima_status in", values, "imaStatus");
            return (Criteria) this;
        }

        public Criteria andImaStatusNotIn(List<String> values) {
            addCriterion("ima_status not in", values, "imaStatus");
            return (Criteria) this;
        }

        public Criteria andImaStatusBetween(String value1, String value2) {
            addCriterion("ima_status between", value1, value2, "imaStatus");
            return (Criteria) this;
        }

        public Criteria andImaStatusNotBetween(String value1, String value2) {
            addCriterion("ima_status not between", value1, value2, "imaStatus");
            return (Criteria) this;
        }

        public Criteria andImaCreatetimeIsNull() {
            addCriterion("ima_createtime is null");
            return (Criteria) this;
        }

        public Criteria andImaCreatetimeIsNotNull() {
            addCriterion("ima_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andImaCreatetimeEqualTo(String value) {
            addCriterion("ima_createtime =", value, "imaCreatetime");
            return (Criteria) this;
        }

        public Criteria andImaCreatetimeNotEqualTo(String value) {
            addCriterion("ima_createtime <>", value, "imaCreatetime");
            return (Criteria) this;
        }

        public Criteria andImaCreatetimeGreaterThan(String value) {
            addCriterion("ima_createtime >", value, "imaCreatetime");
            return (Criteria) this;
        }

        public Criteria andImaCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("ima_createtime >=", value, "imaCreatetime");
            return (Criteria) this;
        }

        public Criteria andImaCreatetimeLessThan(String value) {
            addCriterion("ima_createtime <", value, "imaCreatetime");
            return (Criteria) this;
        }

        public Criteria andImaCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("ima_createtime <=", value, "imaCreatetime");
            return (Criteria) this;
        }

        public Criteria andImaCreatetimeLike(String value) {
            addCriterion("ima_createtime like", value, "imaCreatetime");
            return (Criteria) this;
        }

        public Criteria andImaCreatetimeNotLike(String value) {
            addCriterion("ima_createtime not like", value, "imaCreatetime");
            return (Criteria) this;
        }

        public Criteria andImaCreatetimeIn(List<String> values) {
            addCriterion("ima_createtime in", values, "imaCreatetime");
            return (Criteria) this;
        }

        public Criteria andImaCreatetimeNotIn(List<String> values) {
            addCriterion("ima_createtime not in", values, "imaCreatetime");
            return (Criteria) this;
        }

        public Criteria andImaCreatetimeBetween(String value1, String value2) {
            addCriterion("ima_createtime between", value1, value2, "imaCreatetime");
            return (Criteria) this;
        }

        public Criteria andImaCreatetimeNotBetween(String value1, String value2) {
            addCriterion("ima_createtime not between", value1, value2, "imaCreatetime");
            return (Criteria) this;
        }

        public Criteria andImaCreateuserIsNull() {
            addCriterion("ima_createuser is null");
            return (Criteria) this;
        }

        public Criteria andImaCreateuserIsNotNull() {
            addCriterion("ima_createuser is not null");
            return (Criteria) this;
        }

        public Criteria andImaCreateuserEqualTo(String value) {
            addCriterion("ima_createuser =", value, "imaCreateuser");
            return (Criteria) this;
        }

        public Criteria andImaCreateuserNotEqualTo(String value) {
            addCriterion("ima_createuser <>", value, "imaCreateuser");
            return (Criteria) this;
        }

        public Criteria andImaCreateuserGreaterThan(String value) {
            addCriterion("ima_createuser >", value, "imaCreateuser");
            return (Criteria) this;
        }

        public Criteria andImaCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("ima_createuser >=", value, "imaCreateuser");
            return (Criteria) this;
        }

        public Criteria andImaCreateuserLessThan(String value) {
            addCriterion("ima_createuser <", value, "imaCreateuser");
            return (Criteria) this;
        }

        public Criteria andImaCreateuserLessThanOrEqualTo(String value) {
            addCriterion("ima_createuser <=", value, "imaCreateuser");
            return (Criteria) this;
        }

        public Criteria andImaCreateuserLike(String value) {
            addCriterion("ima_createuser like", value, "imaCreateuser");
            return (Criteria) this;
        }

        public Criteria andImaCreateuserNotLike(String value) {
            addCriterion("ima_createuser not like", value, "imaCreateuser");
            return (Criteria) this;
        }

        public Criteria andImaCreateuserIn(List<String> values) {
            addCriterion("ima_createuser in", values, "imaCreateuser");
            return (Criteria) this;
        }

        public Criteria andImaCreateuserNotIn(List<String> values) {
            addCriterion("ima_createuser not in", values, "imaCreateuser");
            return (Criteria) this;
        }

        public Criteria andImaCreateuserBetween(String value1, String value2) {
            addCriterion("ima_createuser between", value1, value2, "imaCreateuser");
            return (Criteria) this;
        }

        public Criteria andImaCreateuserNotBetween(String value1, String value2) {
            addCriterion("ima_createuser not between", value1, value2, "imaCreateuser");
            return (Criteria) this;
        }

        public Criteria andImaUpdatetimeIsNull() {
            addCriterion("ima_updatetime is null");
            return (Criteria) this;
        }

        public Criteria andImaUpdatetimeIsNotNull() {
            addCriterion("ima_updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andImaUpdatetimeEqualTo(String value) {
            addCriterion("ima_updatetime =", value, "imaUpdatetime");
            return (Criteria) this;
        }

        public Criteria andImaUpdatetimeNotEqualTo(String value) {
            addCriterion("ima_updatetime <>", value, "imaUpdatetime");
            return (Criteria) this;
        }

        public Criteria andImaUpdatetimeGreaterThan(String value) {
            addCriterion("ima_updatetime >", value, "imaUpdatetime");
            return (Criteria) this;
        }

        public Criteria andImaUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("ima_updatetime >=", value, "imaUpdatetime");
            return (Criteria) this;
        }

        public Criteria andImaUpdatetimeLessThan(String value) {
            addCriterion("ima_updatetime <", value, "imaUpdatetime");
            return (Criteria) this;
        }

        public Criteria andImaUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("ima_updatetime <=", value, "imaUpdatetime");
            return (Criteria) this;
        }

        public Criteria andImaUpdatetimeLike(String value) {
            addCriterion("ima_updatetime like", value, "imaUpdatetime");
            return (Criteria) this;
        }

        public Criteria andImaUpdatetimeNotLike(String value) {
            addCriterion("ima_updatetime not like", value, "imaUpdatetime");
            return (Criteria) this;
        }

        public Criteria andImaUpdatetimeIn(List<String> values) {
            addCriterion("ima_updatetime in", values, "imaUpdatetime");
            return (Criteria) this;
        }

        public Criteria andImaUpdatetimeNotIn(List<String> values) {
            addCriterion("ima_updatetime not in", values, "imaUpdatetime");
            return (Criteria) this;
        }

        public Criteria andImaUpdatetimeBetween(String value1, String value2) {
            addCriterion("ima_updatetime between", value1, value2, "imaUpdatetime");
            return (Criteria) this;
        }

        public Criteria andImaUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("ima_updatetime not between", value1, value2, "imaUpdatetime");
            return (Criteria) this;
        }

        public Criteria andImaUpdateuserIsNull() {
            addCriterion("ima_updateuser is null");
            return (Criteria) this;
        }

        public Criteria andImaUpdateuserIsNotNull() {
            addCriterion("ima_updateuser is not null");
            return (Criteria) this;
        }

        public Criteria andImaUpdateuserEqualTo(String value) {
            addCriterion("ima_updateuser =", value, "imaUpdateuser");
            return (Criteria) this;
        }

        public Criteria andImaUpdateuserNotEqualTo(String value) {
            addCriterion("ima_updateuser <>", value, "imaUpdateuser");
            return (Criteria) this;
        }

        public Criteria andImaUpdateuserGreaterThan(String value) {
            addCriterion("ima_updateuser >", value, "imaUpdateuser");
            return (Criteria) this;
        }

        public Criteria andImaUpdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("ima_updateuser >=", value, "imaUpdateuser");
            return (Criteria) this;
        }

        public Criteria andImaUpdateuserLessThan(String value) {
            addCriterion("ima_updateuser <", value, "imaUpdateuser");
            return (Criteria) this;
        }

        public Criteria andImaUpdateuserLessThanOrEqualTo(String value) {
            addCriterion("ima_updateuser <=", value, "imaUpdateuser");
            return (Criteria) this;
        }

        public Criteria andImaUpdateuserLike(String value) {
            addCriterion("ima_updateuser like", value, "imaUpdateuser");
            return (Criteria) this;
        }

        public Criteria andImaUpdateuserNotLike(String value) {
            addCriterion("ima_updateuser not like", value, "imaUpdateuser");
            return (Criteria) this;
        }

        public Criteria andImaUpdateuserIn(List<String> values) {
            addCriterion("ima_updateuser in", values, "imaUpdateuser");
            return (Criteria) this;
        }

        public Criteria andImaUpdateuserNotIn(List<String> values) {
            addCriterion("ima_updateuser not in", values, "imaUpdateuser");
            return (Criteria) this;
        }

        public Criteria andImaUpdateuserBetween(String value1, String value2) {
            addCriterion("ima_updateuser between", value1, value2, "imaUpdateuser");
            return (Criteria) this;
        }

        public Criteria andImaUpdateuserNotBetween(String value1, String value2) {
            addCriterion("ima_updateuser not between", value1, value2, "imaUpdateuser");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andImaCodeLikeInsensitive(String value) {
            addCriterion("upper(ima_code) like", value.toUpperCase(), "imaCode");
            return this;
        }

        public Criteria andImaNameLikeInsensitive(String value) {
            addCriterion("upper(ima_name) like", value.toUpperCase(), "imaName");
            return this;
        }

        public Criteria andImaAddressLikeInsensitive(String value) {
            addCriterion("upper(ima_address) like", value.toUpperCase(), "imaAddress");
            return this;
        }

        public Criteria andImaPortLikeInsensitive(String value) {
            addCriterion("upper(ima_port) like", value.toUpperCase(), "imaPort");
            return this;
        }

        public Criteria andImaStatusLikeInsensitive(String value) {
            addCriterion("upper(ima_status) like", value.toUpperCase(), "imaStatus");
            return this;
        }

        public Criteria andImaCreatetimeLikeInsensitive(String value) {
            addCriterion("upper(ima_createtime) like", value.toUpperCase(), "imaCreatetime");
            return this;
        }

        public Criteria andImaCreateuserLikeInsensitive(String value) {
            addCriterion("upper(ima_createuser) like", value.toUpperCase(), "imaCreateuser");
            return this;
        }

        public Criteria andImaUpdatetimeLikeInsensitive(String value) {
            addCriterion("upper(ima_updatetime) like", value.toUpperCase(), "imaUpdatetime");
            return this;
        }

        public Criteria andImaUpdateuserLikeInsensitive(String value) {
            addCriterion("upper(ima_updateuser) like", value.toUpperCase(), "imaUpdateuser");
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