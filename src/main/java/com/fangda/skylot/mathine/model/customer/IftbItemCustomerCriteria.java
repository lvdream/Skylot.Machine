package com.fangda.skylot.mathine.model.customer;

import com.fangda.skylot.mathine.utils.Page;

import java.util.ArrayList;
import java.util.List;

public class IftbItemCustomerCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public IftbItemCustomerCriteria() {
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
        this.page = page;
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

        public Criteria andIicIdIsNull() {
            addCriterion("iic_id is null");
            return (Criteria) this;
        }

        public Criteria andIicIdIsNotNull() {
            addCriterion("iic_id is not null");
            return (Criteria) this;
        }

        public Criteria andIicIdEqualTo(Integer value) {
            addCriterion("iic_id =", value, "iicId");
            return (Criteria) this;
        }

        public Criteria andIicIdNotEqualTo(Integer value) {
            addCriterion("iic_id <>", value, "iicId");
            return (Criteria) this;
        }

        public Criteria andIicIdGreaterThan(Integer value) {
            addCriterion("iic_id >", value, "iicId");
            return (Criteria) this;
        }

        public Criteria andIicIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("iic_id >=", value, "iicId");
            return (Criteria) this;
        }

        public Criteria andIicIdLessThan(Integer value) {
            addCriterion("iic_id <", value, "iicId");
            return (Criteria) this;
        }

        public Criteria andIicIdLessThanOrEqualTo(Integer value) {
            addCriterion("iic_id <=", value, "iicId");
            return (Criteria) this;
        }

        public Criteria andIicIdIn(List<Integer> values) {
            addCriterion("iic_id in", values, "iicId");
            return (Criteria) this;
        }

        public Criteria andIicIdNotIn(List<Integer> values) {
            addCriterion("iic_id not in", values, "iicId");
            return (Criteria) this;
        }

        public Criteria andIicIdBetween(Integer value1, Integer value2) {
            addCriterion("iic_id between", value1, value2, "iicId");
            return (Criteria) this;
        }

        public Criteria andIicIdNotBetween(Integer value1, Integer value2) {
            addCriterion("iic_id not between", value1, value2, "iicId");
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

        public Criteria andIiicStatusIsNull() {
            addCriterion("iiic_status is null");
            return (Criteria) this;
        }

        public Criteria andIiicStatusIsNotNull() {
            addCriterion("iiic_status is not null");
            return (Criteria) this;
        }

        public Criteria andIiicStatusEqualTo(String value) {
            addCriterion("iiic_status =", value, "iiicStatus");
            return (Criteria) this;
        }

        public Criteria andIiicStatusNotEqualTo(String value) {
            addCriterion("iiic_status <>", value, "iiicStatus");
            return (Criteria) this;
        }

        public Criteria andIiicStatusGreaterThan(String value) {
            addCriterion("iiic_status >", value, "iiicStatus");
            return (Criteria) this;
        }

        public Criteria andIiicStatusGreaterThanOrEqualTo(String value) {
            addCriterion("iiic_status >=", value, "iiicStatus");
            return (Criteria) this;
        }

        public Criteria andIiicStatusLessThan(String value) {
            addCriterion("iiic_status <", value, "iiicStatus");
            return (Criteria) this;
        }

        public Criteria andIiicStatusLessThanOrEqualTo(String value) {
            addCriterion("iiic_status <=", value, "iiicStatus");
            return (Criteria) this;
        }

        public Criteria andIiicStatusLike(String value) {
            addCriterion("iiic_status like", value, "iiicStatus");
            return (Criteria) this;
        }

        public Criteria andIiicStatusNotLike(String value) {
            addCriterion("iiic_status not like", value, "iiicStatus");
            return (Criteria) this;
        }

        public Criteria andIiicStatusIn(List<String> values) {
            addCriterion("iiic_status in", values, "iiicStatus");
            return (Criteria) this;
        }

        public Criteria andIiicStatusNotIn(List<String> values) {
            addCriterion("iiic_status not in", values, "iiicStatus");
            return (Criteria) this;
        }

        public Criteria andIiicStatusBetween(String value1, String value2) {
            addCriterion("iiic_status between", value1, value2, "iiicStatus");
            return (Criteria) this;
        }

        public Criteria andIiicStatusNotBetween(String value1, String value2) {
            addCriterion("iiic_status not between", value1, value2, "iiicStatus");
            return (Criteria) this;
        }

        public Criteria andIicStartdateIsNull() {
            addCriterion("iic_startdate is null");
            return (Criteria) this;
        }

        public Criteria andIicStartdateIsNotNull() {
            addCriterion("iic_startdate is not null");
            return (Criteria) this;
        }

        public Criteria andIicStartdateEqualTo(String value) {
            addCriterion("iic_startdate =", value, "iicStartdate");
            return (Criteria) this;
        }

        public Criteria andIicStartdateNotEqualTo(String value) {
            addCriterion("iic_startdate <>", value, "iicStartdate");
            return (Criteria) this;
        }

        public Criteria andIicStartdateGreaterThan(String value) {
            addCriterion("iic_startdate >", value, "iicStartdate");
            return (Criteria) this;
        }

        public Criteria andIicStartdateGreaterThanOrEqualTo(String value) {
            addCriterion("iic_startdate >=", value, "iicStartdate");
            return (Criteria) this;
        }

        public Criteria andIicStartdateLessThan(String value) {
            addCriterion("iic_startdate <", value, "iicStartdate");
            return (Criteria) this;
        }

        public Criteria andIicStartdateLessThanOrEqualTo(String value) {
            addCriterion("iic_startdate <=", value, "iicStartdate");
            return (Criteria) this;
        }

        public Criteria andIicStartdateLike(String value) {
            addCriterion("iic_startdate like", value, "iicStartdate");
            return (Criteria) this;
        }

        public Criteria andIicStartdateNotLike(String value) {
            addCriterion("iic_startdate not like", value, "iicStartdate");
            return (Criteria) this;
        }

        public Criteria andIicStartdateIn(List<String> values) {
            addCriterion("iic_startdate in", values, "iicStartdate");
            return (Criteria) this;
        }

        public Criteria andIicStartdateNotIn(List<String> values) {
            addCriterion("iic_startdate not in", values, "iicStartdate");
            return (Criteria) this;
        }

        public Criteria andIicStartdateBetween(String value1, String value2) {
            addCriterion("iic_startdate between", value1, value2, "iicStartdate");
            return (Criteria) this;
        }

        public Criteria andIicStartdateNotBetween(String value1, String value2) {
            addCriterion("iic_startdate not between", value1, value2, "iicStartdate");
            return (Criteria) this;
        }

        public Criteria andIicEnddateIsNull() {
            addCriterion("iic_enddate is null");
            return (Criteria) this;
        }

        public Criteria andIicEnddateIsNotNull() {
            addCriterion("iic_enddate is not null");
            return (Criteria) this;
        }

        public Criteria andIicEnddateEqualTo(String value) {
            addCriterion("iic_enddate =", value, "iicEnddate");
            return (Criteria) this;
        }

        public Criteria andIicEnddateNotEqualTo(String value) {
            addCriterion("iic_enddate <>", value, "iicEnddate");
            return (Criteria) this;
        }

        public Criteria andIicEnddateGreaterThan(String value) {
            addCriterion("iic_enddate >", value, "iicEnddate");
            return (Criteria) this;
        }

        public Criteria andIicEnddateGreaterThanOrEqualTo(String value) {
            addCriterion("iic_enddate >=", value, "iicEnddate");
            return (Criteria) this;
        }

        public Criteria andIicEnddateLessThan(String value) {
            addCriterion("iic_enddate <", value, "iicEnddate");
            return (Criteria) this;
        }

        public Criteria andIicEnddateLessThanOrEqualTo(String value) {
            addCriterion("iic_enddate <=", value, "iicEnddate");
            return (Criteria) this;
        }

        public Criteria andIicEnddateLike(String value) {
            addCriterion("iic_enddate like", value, "iicEnddate");
            return (Criteria) this;
        }

        public Criteria andIicEnddateNotLike(String value) {
            addCriterion("iic_enddate not like", value, "iicEnddate");
            return (Criteria) this;
        }

        public Criteria andIicEnddateIn(List<String> values) {
            addCriterion("iic_enddate in", values, "iicEnddate");
            return (Criteria) this;
        }

        public Criteria andIccCarCodeIn(List<String> values) {
            addCriterion("icc_car_code in", values, "iccCarCode");
            return (Criteria) this;
        }

        public Criteria andIccCarCodeEqualTo(String value) {
            addCriterion("icc_car_code =", value, "iccCarCode");
            return (Criteria) this;
        }

        public Criteria andIicEnddateNotIn(List<String> values) {
            addCriterion("iic_enddate not in", values, "iicEnddate");
            return (Criteria) this;
        }

        public Criteria andIicEnddateBetween(String value1, String value2) {
            addCriterion("iic_enddate between", value1, value2, "iicEnddate");
            return (Criteria) this;
        }

        public Criteria andIicEnddateNotBetween(String value1, String value2) {
            addCriterion("iic_enddate not between", value1, value2, "iicEnddate");
            return (Criteria) this;
        }

        public Criteria andIicCostIsNull() {
            addCriterion("iic_cost is null");
            return (Criteria) this;
        }

        public Criteria andIicCostIsNotNull() {
            addCriterion("iic_cost is not null");
            return (Criteria) this;
        }

        public Criteria andIicCostEqualTo(String value) {
            addCriterion("iic_cost =", value, "iicCost");
            return (Criteria) this;
        }

        public Criteria andIicCostNotEqualTo(String value) {
            addCriterion("iic_cost <>", value, "iicCost");
            return (Criteria) this;
        }

        public Criteria andIicCostGreaterThan(String value) {
            addCriterion("iic_cost >", value, "iicCost");
            return (Criteria) this;
        }

        public Criteria andIicCostGreaterThanOrEqualTo(String value) {
            addCriterion("iic_cost >=", value, "iicCost");
            return (Criteria) this;
        }

        public Criteria andIicCostLessThan(String value) {
            addCriterion("iic_cost <", value, "iicCost");
            return (Criteria) this;
        }

        public Criteria andIicCostLessThanOrEqualTo(String value) {
            addCriterion("iic_cost <=", value, "iicCost");
            return (Criteria) this;
        }

        public Criteria andIicCostLike(String value) {
            addCriterion("iic_cost like", value, "iicCost");
            return (Criteria) this;
        }

        public Criteria andIicCostNotLike(String value) {
            addCriterion("iic_cost not like", value, "iicCost");
            return (Criteria) this;
        }

        public Criteria andIicCostIn(List<String> values) {
            addCriterion("iic_cost in", values, "iicCost");
            return (Criteria) this;
        }

        public Criteria andIicCostNotIn(List<String> values) {
            addCriterion("iic_cost not in", values, "iicCost");
            return (Criteria) this;
        }

        public Criteria andIicCostBetween(String value1, String value2) {
            addCriterion("iic_cost between", value1, value2, "iicCost");
            return (Criteria) this;
        }

        public Criteria andIicCostNotBetween(String value1, String value2) {
            addCriterion("iic_cost not between", value1, value2, "iicCost");
            return (Criteria) this;
        }

        public Criteria andIicFormulaIsNull() {
            addCriterion("iic_formula is null");
            return (Criteria) this;
        }

        public Criteria andIicFormulaIsNotNull() {
            addCriterion("iic_formula is not null");
            return (Criteria) this;
        }

        public Criteria andIicFormulaEqualTo(String value) {
            addCriterion("iic_formula =", value, "iicFormula");
            return (Criteria) this;
        }

        public Criteria andIicFormulaNotEqualTo(String value) {
            addCriterion("iic_formula <>", value, "iicFormula");
            return (Criteria) this;
        }

        public Criteria andIicFormulaGreaterThan(String value) {
            addCriterion("iic_formula >", value, "iicFormula");
            return (Criteria) this;
        }

        public Criteria andIicFormulaGreaterThanOrEqualTo(String value) {
            addCriterion("iic_formula >=", value, "iicFormula");
            return (Criteria) this;
        }

        public Criteria andIicFormulaLessThan(String value) {
            addCriterion("iic_formula <", value, "iicFormula");
            return (Criteria) this;
        }

        public Criteria andIicFormulaLessThanOrEqualTo(String value) {
            addCriterion("iic_formula <=", value, "iicFormula");
            return (Criteria) this;
        }

        public Criteria andIicFormulaLike(String value) {
            addCriterion("iic_formula like", value, "iicFormula");
            return (Criteria) this;
        }

        public Criteria andIicFormulaNotLike(String value) {
            addCriterion("iic_formula not like", value, "iicFormula");
            return (Criteria) this;
        }

        public Criteria andIicFormulaIn(List<String> values) {
            addCriterion("iic_formula in", values, "iicFormula");
            return (Criteria) this;
        }

        public Criteria andIicFormulaNotIn(List<String> values) {
            addCriterion("iic_formula not in", values, "iicFormula");
            return (Criteria) this;
        }

        public Criteria andIicFormulaBetween(String value1, String value2) {
            addCriterion("iic_formula between", value1, value2, "iicFormula");
            return (Criteria) this;
        }

        public Criteria andIicFormulaNotBetween(String value1, String value2) {
            addCriterion("iic_formula not between", value1, value2, "iicFormula");
            return (Criteria) this;
        }

        public Criteria andIicCreatedateIsNull() {
            addCriterion("iic_createdate is null");
            return (Criteria) this;
        }

        public Criteria andIicCreatedateIsNotNull() {
            addCriterion("iic_createdate is not null");
            return (Criteria) this;
        }

        public Criteria andIicCreatedateEqualTo(String value) {
            addCriterion("iic_createdate =", value, "iicCreatedate");
            return (Criteria) this;
        }

        public Criteria andIicCreatedateNotEqualTo(String value) {
            addCriterion("iic_createdate <>", value, "iicCreatedate");
            return (Criteria) this;
        }

        public Criteria andIicCreatedateGreaterThan(String value) {
            addCriterion("iic_createdate >", value, "iicCreatedate");
            return (Criteria) this;
        }

        public Criteria andIicCreatedateGreaterThanOrEqualTo(String value) {
            addCriterion("iic_createdate >=", value, "iicCreatedate");
            return (Criteria) this;
        }

        public Criteria andIicCreatedateLessThan(String value) {
            addCriterion("iic_createdate <", value, "iicCreatedate");
            return (Criteria) this;
        }

        public Criteria andIicCreatedateLessThanOrEqualTo(String value) {
            addCriterion("iic_createdate <=", value, "iicCreatedate");
            return (Criteria) this;
        }

        public Criteria andIicCreatedateLike(String value) {
            addCriterion("iic_createdate like", value, "iicCreatedate");
            return (Criteria) this;
        }

        public Criteria andIicCreatedateNotLike(String value) {
            addCriterion("iic_createdate not like", value, "iicCreatedate");
            return (Criteria) this;
        }

        public Criteria andIicCreatedateIn(List<String> values) {
            addCriterion("iic_createdate in", values, "iicCreatedate");
            return (Criteria) this;
        }

        public Criteria andIicCreatedateNotIn(List<String> values) {
            addCriterion("iic_createdate not in", values, "iicCreatedate");
            return (Criteria) this;
        }

        public Criteria andIicCreatedateBetween(String value1, String value2) {
            addCriterion("iic_createdate between", value1, value2, "iicCreatedate");
            return (Criteria) this;
        }

        public Criteria andIicCreatedateNotBetween(String value1, String value2) {
            addCriterion("iic_createdate not between", value1, value2, "iicCreatedate");
            return (Criteria) this;
        }

        public Criteria andIicCreateuserIsNull() {
            addCriterion("iic_createuser is null");
            return (Criteria) this;
        }

        public Criteria andIicCreateuserIsNotNull() {
            addCriterion("iic_createuser is not null");
            return (Criteria) this;
        }

        public Criteria andIicCreateuserEqualTo(String value) {
            addCriterion("iic_createuser =", value, "iicCreateuser");
            return (Criteria) this;
        }

        public Criteria andIicCreateuserNotEqualTo(String value) {
            addCriterion("iic_createuser <>", value, "iicCreateuser");
            return (Criteria) this;
        }

        public Criteria andIicCreateuserGreaterThan(String value) {
            addCriterion("iic_createuser >", value, "iicCreateuser");
            return (Criteria) this;
        }

        public Criteria andIicCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("iic_createuser >=", value, "iicCreateuser");
            return (Criteria) this;
        }

        public Criteria andIicCreateuserLessThan(String value) {
            addCriterion("iic_createuser <", value, "iicCreateuser");
            return (Criteria) this;
        }

        public Criteria andIicCreateuserLessThanOrEqualTo(String value) {
            addCriterion("iic_createuser <=", value, "iicCreateuser");
            return (Criteria) this;
        }

        public Criteria andIicCreateuserLike(String value) {
            addCriterion("iic_createuser like", value, "iicCreateuser");
            return (Criteria) this;
        }

        public Criteria andIicCreateuserNotLike(String value) {
            addCriterion("iic_createuser not like", value, "iicCreateuser");
            return (Criteria) this;
        }

        public Criteria andIicCreateuserIn(List<String> values) {
            addCriterion("iic_createuser in", values, "iicCreateuser");
            return (Criteria) this;
        }

        public Criteria andIicCreateuserNotIn(List<String> values) {
            addCriterion("iic_createuser not in", values, "iicCreateuser");
            return (Criteria) this;
        }

        public Criteria andIicCreateuserBetween(String value1, String value2) {
            addCriterion("iic_createuser between", value1, value2, "iicCreateuser");
            return (Criteria) this;
        }

        public Criteria andIicCreateuserNotBetween(String value1, String value2) {
            addCriterion("iic_createuser not between", value1, value2, "iicCreateuser");
            return (Criteria) this;
        }

        public Criteria andIicUpdatedateIsNull() {
            addCriterion("iic_updatedate is null");
            return (Criteria) this;
        }

        public Criteria andIicUpdatedateIsNotNull() {
            addCriterion("iic_updatedate is not null");
            return (Criteria) this;
        }

        public Criteria andIicUpdatedateEqualTo(String value) {
            addCriterion("iic_updatedate =", value, "iicUpdatedate");
            return (Criteria) this;
        }

        public Criteria andIicUpdatedateNotEqualTo(String value) {
            addCriterion("iic_updatedate <>", value, "iicUpdatedate");
            return (Criteria) this;
        }

        public Criteria andIicUpdatedateGreaterThan(String value) {
            addCriterion("iic_updatedate >", value, "iicUpdatedate");
            return (Criteria) this;
        }

        public Criteria andIicUpdatedateGreaterThanOrEqualTo(String value) {
            addCriterion("iic_updatedate >=", value, "iicUpdatedate");
            return (Criteria) this;
        }

        public Criteria andIicUpdatedateLessThan(String value) {
            addCriterion("iic_updatedate <", value, "iicUpdatedate");
            return (Criteria) this;
        }

        public Criteria andIicUpdatedateLessThanOrEqualTo(String value) {
            addCriterion("iic_updatedate <=", value, "iicUpdatedate");
            return (Criteria) this;
        }

        public Criteria andIicUpdatedateLike(String value) {
            addCriterion("iic_updatedate like", value, "iicUpdatedate");
            return (Criteria) this;
        }

        public Criteria andIicUpdatedateNotLike(String value) {
            addCriterion("iic_updatedate not like", value, "iicUpdatedate");
            return (Criteria) this;
        }

        public Criteria andIicUpdatedateIn(List<String> values) {
            addCriterion("iic_updatedate in", values, "iicUpdatedate");
            return (Criteria) this;
        }

        public Criteria andIicUpdatedateNotIn(List<String> values) {
            addCriterion("iic_updatedate not in", values, "iicUpdatedate");
            return (Criteria) this;
        }

        public Criteria andIicUpdatedateBetween(String value1, String value2) {
            addCriterion("iic_updatedate between", value1, value2, "iicUpdatedate");
            return (Criteria) this;
        }

        public Criteria andIicUpdatedateNotBetween(String value1, String value2) {
            addCriterion("iic_updatedate not between", value1, value2, "iicUpdatedate");
            return (Criteria) this;
        }

        public Criteria andIicUpdateuserIsNull() {
            addCriterion("iic_updateuser is null");
            return (Criteria) this;
        }

        public Criteria andIicUpdateuserIsNotNull() {
            addCriterion("iic_updateuser is not null");
            return (Criteria) this;
        }

        public Criteria andIicUpdateuserEqualTo(String value) {
            addCriterion("iic_updateuser =", value, "iicUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIicUpdateuserNotEqualTo(String value) {
            addCriterion("iic_updateuser <>", value, "iicUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIicUpdateuserGreaterThan(String value) {
            addCriterion("iic_updateuser >", value, "iicUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIicUpdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("iic_updateuser >=", value, "iicUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIicUpdateuserLessThan(String value) {
            addCriterion("iic_updateuser <", value, "iicUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIicUpdateuserLessThanOrEqualTo(String value) {
            addCriterion("iic_updateuser <=", value, "iicUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIicUpdateuserLike(String value) {
            addCriterion("iic_updateuser like", value, "iicUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIicUpdateuserNotLike(String value) {
            addCriterion("iic_updateuser not like", value, "iicUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIicUpdateuserIn(List<String> values) {
            addCriterion("iic_updateuser in", values, "iicUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIicUpdateuserNotIn(List<String> values) {
            addCriterion("iic_updateuser not in", values, "iicUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIicUpdateuserBetween(String value1, String value2) {
            addCriterion("iic_updateuser between", value1, value2, "iicUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIicUpdateuserNotBetween(String value1, String value2) {
            addCriterion("iic_updateuser not between", value1, value2, "iicUpdateuser");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andIiicStatusLikeInsensitive(String value) {
            addCriterion("upper(iiic_status) like", value.toUpperCase(), "iiicStatus");
            return this;
        }

        public Criteria andIicStartdateLikeInsensitive(String value) {
            addCriterion("upper(iic_startdate) like", value.toUpperCase(), "iicStartdate");
            return this;
        }

        public Criteria andIicEnddateLikeInsensitive(String value) {
            addCriterion("upper(iic_enddate) like", value.toUpperCase(), "iicEnddate");
            return this;
        }

        public Criteria andIicCostLikeInsensitive(String value) {
            addCriterion("upper(iic_cost) like", value.toUpperCase(), "iicCost");
            return this;
        }

        public Criteria andIicFormulaLikeInsensitive(String value) {
            addCriterion("upper(iic_formula) like", value.toUpperCase(), "iicFormula");
            return this;
        }

        public Criteria andIicCreatedateLikeInsensitive(String value) {
            addCriterion("upper(iic_createdate) like", value.toUpperCase(), "iicCreatedate");
            return this;
        }

        public Criteria andIicCreateuserLikeInsensitive(String value) {
            addCriterion("upper(iic_createuser) like", value.toUpperCase(), "iicCreateuser");
            return this;
        }

        public Criteria andIicUpdatedateLikeInsensitive(String value) {
            addCriterion("upper(iic_updatedate) like", value.toUpperCase(), "iicUpdatedate");
            return this;
        }

        public Criteria andIicUpdateuserLikeInsensitive(String value) {
            addCriterion("upper(iic_updateuser) like", value.toUpperCase(), "iicUpdateuser");
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