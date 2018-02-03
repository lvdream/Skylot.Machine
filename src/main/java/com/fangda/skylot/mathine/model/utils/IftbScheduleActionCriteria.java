package com.fangda.skylot.mathine.model.utils;


import com.fangda.skylot.mathine.utils.Page;

import java.util.ArrayList;
import java.util.List;

public class IftbScheduleActionCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public IftbScheduleActionCriteria() {
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

        public Criteria andIsaIdIsNull() {
            addCriterion("isa_id is null");
            return (Criteria) this;
        }

        public Criteria andIsaIdIsNotNull() {
            addCriterion("isa_id is not null");
            return (Criteria) this;
        }

        public Criteria andIsaIdEqualTo(Integer value) {
            addCriterion("isa_id =", value, "isaId");
            return (Criteria) this;
        }

        public Criteria andIsaIdNotEqualTo(Integer value) {
            addCriterion("isa_id <>", value, "isaId");
            return (Criteria) this;
        }

        public Criteria andIsaIdGreaterThan(Integer value) {
            addCriterion("isa_id >", value, "isaId");
            return (Criteria) this;
        }

        public Criteria andIsaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("isa_id >=", value, "isaId");
            return (Criteria) this;
        }

        public Criteria andIsaIdLessThan(Integer value) {
            addCriterion("isa_id <", value, "isaId");
            return (Criteria) this;
        }

        public Criteria andIsaIdLessThanOrEqualTo(Integer value) {
            addCriterion("isa_id <=", value, "isaId");
            return (Criteria) this;
        }

        public Criteria andIsaIdIn(List<Integer> values) {
            addCriterion("isa_id in", values, "isaId");
            return (Criteria) this;
        }

        public Criteria andIsaIdNotIn(List<Integer> values) {
            addCriterion("isa_id not in", values, "isaId");
            return (Criteria) this;
        }

        public Criteria andIsaIdBetween(Integer value1, Integer value2) {
            addCriterion("isa_id between", value1, value2, "isaId");
            return (Criteria) this;
        }

        public Criteria andIsaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("isa_id not between", value1, value2, "isaId");
            return (Criteria) this;
        }

        public Criteria andIsaBusinessObjIsNull() {
            addCriterion("isa_business_obj is null");
            return (Criteria) this;
        }

        public Criteria andIsaBusinessObjIsNotNull() {
            addCriterion("isa_business_obj is not null");
            return (Criteria) this;
        }

        public Criteria andIsaBusinessObjEqualTo(String value) {
            addCriterion("isa_business_obj =", value, "isaBusinessObj");
            return (Criteria) this;
        }

        public Criteria andIsaBusinessObjNotEqualTo(String value) {
            addCriterion("isa_business_obj <>", value, "isaBusinessObj");
            return (Criteria) this;
        }

        public Criteria andIsaBusinessObjGreaterThan(String value) {
            addCriterion("isa_business_obj >", value, "isaBusinessObj");
            return (Criteria) this;
        }

        public Criteria andIsaBusinessObjGreaterThanOrEqualTo(String value) {
            addCriterion("isa_business_obj >=", value, "isaBusinessObj");
            return (Criteria) this;
        }

        public Criteria andIsaBusinessObjLessThan(String value) {
            addCriterion("isa_business_obj <", value, "isaBusinessObj");
            return (Criteria) this;
        }

        public Criteria andIsaBusinessObjLessThanOrEqualTo(String value) {
            addCriterion("isa_business_obj <=", value, "isaBusinessObj");
            return (Criteria) this;
        }

        public Criteria andIsaBusinessObjLike(String value) {
            addCriterion("isa_business_obj like", value, "isaBusinessObj");
            return (Criteria) this;
        }

        public Criteria andIsaBusinessObjNotLike(String value) {
            addCriterion("isa_business_obj not like", value, "isaBusinessObj");
            return (Criteria) this;
        }

        public Criteria andIsaBusinessObjIn(List<String> values) {
            addCriterion("isa_business_obj in", values, "isaBusinessObj");
            return (Criteria) this;
        }

        public Criteria andIsaBusinessObjNotIn(List<String> values) {
            addCriterion("isa_business_obj not in", values, "isaBusinessObj");
            return (Criteria) this;
        }

        public Criteria andIsaBusinessObjBetween(String value1, String value2) {
            addCriterion("isa_business_obj between", value1, value2, "isaBusinessObj");
            return (Criteria) this;
        }

        public Criteria andIsaBusinessObjNotBetween(String value1, String value2) {
            addCriterion("isa_business_obj not between", value1, value2, "isaBusinessObj");
            return (Criteria) this;
        }

        public Criteria andIsaModuleIdIsNull() {
            addCriterion("isa_module_id is null");
            return (Criteria) this;
        }

        public Criteria andIsaModuleIdIsNotNull() {
            addCriterion("isa_module_id is not null");
            return (Criteria) this;
        }

        public Criteria andIsaModuleIdEqualTo(String value) {
            addCriterion("isa_module_id =", value, "isaModuleId");
            return (Criteria) this;
        }

        public Criteria andIsaModuleIdNotEqualTo(String value) {
            addCriterion("isa_module_id <>", value, "isaModuleId");
            return (Criteria) this;
        }

        public Criteria andIsaModuleIdGreaterThan(String value) {
            addCriterion("isa_module_id >", value, "isaModuleId");
            return (Criteria) this;
        }

        public Criteria andIsaModuleIdGreaterThanOrEqualTo(String value) {
            addCriterion("isa_module_id >=", value, "isaModuleId");
            return (Criteria) this;
        }

        public Criteria andIsaModuleIdLessThan(String value) {
            addCriterion("isa_module_id <", value, "isaModuleId");
            return (Criteria) this;
        }

        public Criteria andIsaModuleIdLessThanOrEqualTo(String value) {
            addCriterion("isa_module_id <=", value, "isaModuleId");
            return (Criteria) this;
        }

        public Criteria andIsaModuleIdLike(String value) {
            addCriterion("isa_module_id like", value, "isaModuleId");
            return (Criteria) this;
        }

        public Criteria andIsaModuleIdNotLike(String value) {
            addCriterion("isa_module_id not like", value, "isaModuleId");
            return (Criteria) this;
        }

        public Criteria andIsaModuleIdIn(List<String> values) {
            addCriterion("isa_module_id in", values, "isaModuleId");
            return (Criteria) this;
        }

        public Criteria andIsaModuleIdNotIn(List<String> values) {
            addCriterion("isa_module_id not in", values, "isaModuleId");
            return (Criteria) this;
        }

        public Criteria andIsaModuleIdBetween(String value1, String value2) {
            addCriterion("isa_module_id between", value1, value2, "isaModuleId");
            return (Criteria) this;
        }

        public Criteria andIsaModuleIdNotBetween(String value1, String value2) {
            addCriterion("isa_module_id not between", value1, value2, "isaModuleId");
            return (Criteria) this;
        }

        public Criteria andIsaItemIdIsNull() {
            addCriterion("isa_item_id is null");
            return (Criteria) this;
        }

        public Criteria andIsaItemIdIsNotNull() {
            addCriterion("isa_item_id is not null");
            return (Criteria) this;
        }

        public Criteria andIsaItemIdEqualTo(String value) {
            addCriterion("isa_item_id =", value, "isaItemId");
            return (Criteria) this;
        }

        public Criteria andIsaItemIdNotEqualTo(String value) {
            addCriterion("isa_item_id <>", value, "isaItemId");
            return (Criteria) this;
        }

        public Criteria andIsaItemIdGreaterThan(String value) {
            addCriterion("isa_item_id >", value, "isaItemId");
            return (Criteria) this;
        }

        public Criteria andIsaItemIdGreaterThanOrEqualTo(String value) {
            addCriterion("isa_item_id >=", value, "isaItemId");
            return (Criteria) this;
        }

        public Criteria andIsaItemIdLessThan(String value) {
            addCriterion("isa_item_id <", value, "isaItemId");
            return (Criteria) this;
        }

        public Criteria andIsaItemIdLessThanOrEqualTo(String value) {
            addCriterion("isa_item_id <=", value, "isaItemId");
            return (Criteria) this;
        }

        public Criteria andIsaItemIdLike(String value) {
            addCriterion("isa_item_id like", value, "isaItemId");
            return (Criteria) this;
        }

        public Criteria andIsaItemIdNotLike(String value) {
            addCriterion("isa_item_id not like", value, "isaItemId");
            return (Criteria) this;
        }

        public Criteria andIsaItemIdIn(List<String> values) {
            addCriterion("isa_item_id in", values, "isaItemId");
            return (Criteria) this;
        }

        public Criteria andIsaItemIdNotIn(List<String> values) {
            addCriterion("isa_item_id not in", values, "isaItemId");
            return (Criteria) this;
        }

        public Criteria andIsaItemIdBetween(String value1, String value2) {
            addCriterion("isa_item_id between", value1, value2, "isaItemId");
            return (Criteria) this;
        }

        public Criteria andIsaItemIdNotBetween(String value1, String value2) {
            addCriterion("isa_item_id not between", value1, value2, "isaItemId");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleDateIsNull() {
            addCriterion("isa_schedule_date is null");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleDateIsNotNull() {
            addCriterion("isa_schedule_date is not null");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleDateEqualTo(String value) {
            addCriterion("isa_schedule_date =", value, "isaScheduleDate");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleDateNotEqualTo(String value) {
            addCriterion("isa_schedule_date <>", value, "isaScheduleDate");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleDateGreaterThan(String value) {
            addCriterion("isa_schedule_date >", value, "isaScheduleDate");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleDateGreaterThanOrEqualTo(String value) {
            addCriterion("isa_schedule_date >=", value, "isaScheduleDate");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleDateLessThan(String value) {
            addCriterion("isa_schedule_date <", value, "isaScheduleDate");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleDateLessThanOrEqualTo(String value) {
            addCriterion("isa_schedule_date <=", value, "isaScheduleDate");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleDateLike(String value) {
            addCriterion("isa_schedule_date like", value, "isaScheduleDate");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleDateNotLike(String value) {
            addCriterion("isa_schedule_date not like", value, "isaScheduleDate");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleDateIn(List<String> values) {
            addCriterion("isa_schedule_date in", values, "isaScheduleDate");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleDateNotIn(List<String> values) {
            addCriterion("isa_schedule_date not in", values, "isaScheduleDate");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleDateBetween(String value1, String value2) {
            addCriterion("isa_schedule_date between", value1, value2, "isaScheduleDate");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleDateNotBetween(String value1, String value2) {
            addCriterion("isa_schedule_date not between", value1, value2, "isaScheduleDate");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleTypeIsNull() {
            addCriterion("isa_schedule_type is null");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleTypeIsNotNull() {
            addCriterion("isa_schedule_type is not null");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleTypeEqualTo(String value) {
            addCriterion("isa_schedule_type =", value, "isaScheduleType");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleTypeNotEqualTo(String value) {
            addCriterion("isa_schedule_type <>", value, "isaScheduleType");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleTypeGreaterThan(String value) {
            addCriterion("isa_schedule_type >", value, "isaScheduleType");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleTypeGreaterThanOrEqualTo(String value) {
            addCriterion("isa_schedule_type >=", value, "isaScheduleType");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleTypeLessThan(String value) {
            addCriterion("isa_schedule_type <", value, "isaScheduleType");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleTypeLessThanOrEqualTo(String value) {
            addCriterion("isa_schedule_type <=", value, "isaScheduleType");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleTypeLike(String value) {
            addCriterion("isa_schedule_type like", value, "isaScheduleType");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleTypeNotLike(String value) {
            addCriterion("isa_schedule_type not like", value, "isaScheduleType");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleTypeIn(List<String> values) {
            addCriterion("isa_schedule_type in", values, "isaScheduleType");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleTypeNotIn(List<String> values) {
            addCriterion("isa_schedule_type not in", values, "isaScheduleType");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleTypeBetween(String value1, String value2) {
            addCriterion("isa_schedule_type between", value1, value2, "isaScheduleType");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleTypeNotBetween(String value1, String value2) {
            addCriterion("isa_schedule_type not between", value1, value2, "isaScheduleType");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleMessageIsNull() {
            addCriterion("isa_schedule_message is null");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleMessageIsNotNull() {
            addCriterion("isa_schedule_message is not null");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleMessageEqualTo(String value) {
            addCriterion("isa_schedule_message =", value, "isaScheduleMessage");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleMessageNotEqualTo(String value) {
            addCriterion("isa_schedule_message <>", value, "isaScheduleMessage");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleMessageGreaterThan(String value) {
            addCriterion("isa_schedule_message >", value, "isaScheduleMessage");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleMessageGreaterThanOrEqualTo(String value) {
            addCriterion("isa_schedule_message >=", value, "isaScheduleMessage");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleMessageLessThan(String value) {
            addCriterion("isa_schedule_message <", value, "isaScheduleMessage");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleMessageLessThanOrEqualTo(String value) {
            addCriterion("isa_schedule_message <=", value, "isaScheduleMessage");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleMessageLike(String value) {
            addCriterion("isa_schedule_message like", value, "isaScheduleMessage");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleMessageNotLike(String value) {
            addCriterion("isa_schedule_message not like", value, "isaScheduleMessage");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleMessageIn(List<String> values) {
            addCriterion("isa_schedule_message in", values, "isaScheduleMessage");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleMessageNotIn(List<String> values) {
            addCriterion("isa_schedule_message not in", values, "isaScheduleMessage");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleMessageBetween(String value1, String value2) {
            addCriterion("isa_schedule_message between", value1, value2, "isaScheduleMessage");
            return (Criteria) this;
        }

        public Criteria andIsaScheduleMessageNotBetween(String value1, String value2) {
            addCriterion("isa_schedule_message not between", value1, value2, "isaScheduleMessage");
            return (Criteria) this;
        }

        public Criteria andIsaStatusIsNull() {
            addCriterion("isa_status is null");
            return (Criteria) this;
        }

        public Criteria andIsaStatusIsNotNull() {
            addCriterion("isa_status is not null");
            return (Criteria) this;
        }

        public Criteria andIsaStatusEqualTo(String value) {
            addCriterion("isa_status =", value, "isaStatus");
            return (Criteria) this;
        }

        public Criteria andIsaStatusNotEqualTo(String value) {
            addCriterion("isa_status <>", value, "isaStatus");
            return (Criteria) this;
        }

        public Criteria andIsaStatusGreaterThan(String value) {
            addCriterion("isa_status >", value, "isaStatus");
            return (Criteria) this;
        }

        public Criteria andIsaStatusGreaterThanOrEqualTo(String value) {
            addCriterion("isa_status >=", value, "isaStatus");
            return (Criteria) this;
        }

        public Criteria andIsaStatusLessThan(String value) {
            addCriterion("isa_status <", value, "isaStatus");
            return (Criteria) this;
        }

        public Criteria andIsaStatusLessThanOrEqualTo(String value) {
            addCriterion("isa_status <=", value, "isaStatus");
            return (Criteria) this;
        }

        public Criteria andIsaStatusLike(String value) {
            addCriterion("isa_status like", value, "isaStatus");
            return (Criteria) this;
        }

        public Criteria andIsaStatusNotLike(String value) {
            addCriterion("isa_status not like", value, "isaStatus");
            return (Criteria) this;
        }

        public Criteria andIsaStatusIn(List<String> values) {
            addCriterion("isa_status in", values, "isaStatus");
            return (Criteria) this;
        }

        public Criteria andIsaStatusNotIn(List<String> values) {
            addCriterion("isa_status not in", values, "isaStatus");
            return (Criteria) this;
        }

        public Criteria andIsaStatusBetween(String value1, String value2) {
            addCriterion("isa_status between", value1, value2, "isaStatus");
            return (Criteria) this;
        }

        public Criteria andIsaStatusNotBetween(String value1, String value2) {
            addCriterion("isa_status not between", value1, value2, "isaStatus");
            return (Criteria) this;
        }

        public Criteria andIsaCreatedateIsNull() {
            addCriterion("isa_createdate is null");
            return (Criteria) this;
        }

        public Criteria andIsaCreatedateIsNotNull() {
            addCriterion("isa_createdate is not null");
            return (Criteria) this;
        }

        public Criteria andIsaCreatedateEqualTo(String value) {
            addCriterion("isa_createdate =", value, "isaCreatedate");
            return (Criteria) this;
        }

        public Criteria andIsaCreatedateNotEqualTo(String value) {
            addCriterion("isa_createdate <>", value, "isaCreatedate");
            return (Criteria) this;
        }

        public Criteria andIsaCreatedateGreaterThan(String value) {
            addCriterion("isa_createdate >", value, "isaCreatedate");
            return (Criteria) this;
        }

        public Criteria andIsaCreatedateGreaterThanOrEqualTo(String value) {
            addCriterion("isa_createdate >=", value, "isaCreatedate");
            return (Criteria) this;
        }

        public Criteria andIsaCreatedateLessThan(String value) {
            addCriterion("isa_createdate <", value, "isaCreatedate");
            return (Criteria) this;
        }

        public Criteria andIsaCreatedateLessThanOrEqualTo(String value) {
            addCriterion("isa_createdate <=", value, "isaCreatedate");
            return (Criteria) this;
        }

        public Criteria andIsaCreatedateLike(String value) {
            addCriterion("isa_createdate like", value, "isaCreatedate");
            return (Criteria) this;
        }

        public Criteria andIsaCreatedateNotLike(String value) {
            addCriterion("isa_createdate not like", value, "isaCreatedate");
            return (Criteria) this;
        }

        public Criteria andIsaCreatedateIn(List<String> values) {
            addCriterion("isa_createdate in", values, "isaCreatedate");
            return (Criteria) this;
        }

        public Criteria andIsaCreatedateNotIn(List<String> values) {
            addCriterion("isa_createdate not in", values, "isaCreatedate");
            return (Criteria) this;
        }

        public Criteria andIsaCreatedateBetween(String value1, String value2) {
            addCriterion("isa_createdate between", value1, value2, "isaCreatedate");
            return (Criteria) this;
        }

        public Criteria andIsaCreatedateNotBetween(String value1, String value2) {
            addCriterion("isa_createdate not between", value1, value2, "isaCreatedate");
            return (Criteria) this;
        }

        public Criteria andIsaCreateuserIsNull() {
            addCriterion("isa_createuser is null");
            return (Criteria) this;
        }

        public Criteria andIsaCreateuserIsNotNull() {
            addCriterion("isa_createuser is not null");
            return (Criteria) this;
        }

        public Criteria andIsaCreateuserEqualTo(String value) {
            addCriterion("isa_createuser =", value, "isaCreateuser");
            return (Criteria) this;
        }

        public Criteria andIsaCreateuserNotEqualTo(String value) {
            addCriterion("isa_createuser <>", value, "isaCreateuser");
            return (Criteria) this;
        }

        public Criteria andIsaCreateuserGreaterThan(String value) {
            addCriterion("isa_createuser >", value, "isaCreateuser");
            return (Criteria) this;
        }

        public Criteria andIsaCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("isa_createuser >=", value, "isaCreateuser");
            return (Criteria) this;
        }

        public Criteria andIsaCreateuserLessThan(String value) {
            addCriterion("isa_createuser <", value, "isaCreateuser");
            return (Criteria) this;
        }

        public Criteria andIsaCreateuserLessThanOrEqualTo(String value) {
            addCriterion("isa_createuser <=", value, "isaCreateuser");
            return (Criteria) this;
        }

        public Criteria andIsaCreateuserLike(String value) {
            addCriterion("isa_createuser like", value, "isaCreateuser");
            return (Criteria) this;
        }

        public Criteria andIsaCreateuserNotLike(String value) {
            addCriterion("isa_createuser not like", value, "isaCreateuser");
            return (Criteria) this;
        }

        public Criteria andIsaCreateuserIn(List<String> values) {
            addCriterion("isa_createuser in", values, "isaCreateuser");
            return (Criteria) this;
        }

        public Criteria andIsaCreateuserNotIn(List<String> values) {
            addCriterion("isa_createuser not in", values, "isaCreateuser");
            return (Criteria) this;
        }

        public Criteria andIsaCreateuserBetween(String value1, String value2) {
            addCriterion("isa_createuser between", value1, value2, "isaCreateuser");
            return (Criteria) this;
        }

        public Criteria andIsaCreateuserNotBetween(String value1, String value2) {
            addCriterion("isa_createuser not between", value1, value2, "isaCreateuser");
            return (Criteria) this;
        }

        public Criteria andIsaUpdatedateIsNull() {
            addCriterion("isa_updatedate is null");
            return (Criteria) this;
        }

        public Criteria andIsaUpdatedateIsNotNull() {
            addCriterion("isa_updatedate is not null");
            return (Criteria) this;
        }

        public Criteria andIsaUpdatedateEqualTo(String value) {
            addCriterion("isa_updatedate =", value, "isaUpdatedate");
            return (Criteria) this;
        }

        public Criteria andIsaUpdatedateNotEqualTo(String value) {
            addCriterion("isa_updatedate <>", value, "isaUpdatedate");
            return (Criteria) this;
        }

        public Criteria andIsaUpdatedateGreaterThan(String value) {
            addCriterion("isa_updatedate >", value, "isaUpdatedate");
            return (Criteria) this;
        }

        public Criteria andIsaUpdatedateGreaterThanOrEqualTo(String value) {
            addCriterion("isa_updatedate >=", value, "isaUpdatedate");
            return (Criteria) this;
        }

        public Criteria andIsaUpdatedateLessThan(String value) {
            addCriterion("isa_updatedate <", value, "isaUpdatedate");
            return (Criteria) this;
        }

        public Criteria andIsaUpdatedateLessThanOrEqualTo(String value) {
            addCriterion("isa_updatedate <=", value, "isaUpdatedate");
            return (Criteria) this;
        }

        public Criteria andIsaUpdatedateLike(String value) {
            addCriterion("isa_updatedate like", value, "isaUpdatedate");
            return (Criteria) this;
        }

        public Criteria andIsaUpdatedateNotLike(String value) {
            addCriterion("isa_updatedate not like", value, "isaUpdatedate");
            return (Criteria) this;
        }

        public Criteria andIsaUpdatedateIn(List<String> values) {
            addCriterion("isa_updatedate in", values, "isaUpdatedate");
            return (Criteria) this;
        }

        public Criteria andIsaUpdatedateNotIn(List<String> values) {
            addCriterion("isa_updatedate not in", values, "isaUpdatedate");
            return (Criteria) this;
        }

        public Criteria andIsaUpdatedateBetween(String value1, String value2) {
            addCriterion("isa_updatedate between", value1, value2, "isaUpdatedate");
            return (Criteria) this;
        }

        public Criteria andIsaUpdatedateNotBetween(String value1, String value2) {
            addCriterion("isa_updatedate not between", value1, value2, "isaUpdatedate");
            return (Criteria) this;
        }

        public Criteria andIsaUpdateuserIsNull() {
            addCriterion("isa_updateuser is null");
            return (Criteria) this;
        }

        public Criteria andIsaUpdateuserIsNotNull() {
            addCriterion("isa_updateuser is not null");
            return (Criteria) this;
        }

        public Criteria andIsaUpdateuserEqualTo(String value) {
            addCriterion("isa_updateuser =", value, "isaUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIsaUpdateuserNotEqualTo(String value) {
            addCriterion("isa_updateuser <>", value, "isaUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIsaUpdateuserGreaterThan(String value) {
            addCriterion("isa_updateuser >", value, "isaUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIsaUpdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("isa_updateuser >=", value, "isaUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIsaUpdateuserLessThan(String value) {
            addCriterion("isa_updateuser <", value, "isaUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIsaUpdateuserLessThanOrEqualTo(String value) {
            addCriterion("isa_updateuser <=", value, "isaUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIsaUpdateuserLike(String value) {
            addCriterion("isa_updateuser like", value, "isaUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIsaUpdateuserNotLike(String value) {
            addCriterion("isa_updateuser not like", value, "isaUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIsaUpdateuserIn(List<String> values) {
            addCriterion("isa_updateuser in", values, "isaUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIsaUpdateuserNotIn(List<String> values) {
            addCriterion("isa_updateuser not in", values, "isaUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIsaUpdateuserBetween(String value1, String value2) {
            addCriterion("isa_updateuser between", value1, value2, "isaUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIsaUpdateuserNotBetween(String value1, String value2) {
            addCriterion("isa_updateuser not between", value1, value2, "isaUpdateuser");
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
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andIsaBusinessObjLikeInsensitive(String value) {
            addCriterion("upper(isa_business_obj) like", value.toUpperCase(), "isaBusinessObj");
            return this;
        }

        public Criteria andIsaModuleIdLikeInsensitive(String value) {
            addCriterion("upper(isa_module_id) like", value.toUpperCase(), "isaModuleId");
            return this;
        }

        public Criteria andIsaItemIdLikeInsensitive(String value) {
            addCriterion("upper(isa_item_id) like", value.toUpperCase(), "isaItemId");
            return this;
        }

        public Criteria andIsaScheduleDateLikeInsensitive(String value) {
            addCriterion("upper(isa_schedule_date) like", value.toUpperCase(), "isaScheduleDate");
            return this;
        }

        public Criteria andIsaScheduleTypeLikeInsensitive(String value) {
            addCriterion("upper(isa_schedule_type) like", value.toUpperCase(), "isaScheduleType");
            return this;
        }

        public Criteria andIsaScheduleMessageLikeInsensitive(String value) {
            addCriterion("upper(isa_schedule_message) like", value.toUpperCase(), "isaScheduleMessage");
            return this;
        }

        public Criteria andIsaStatusLikeInsensitive(String value) {
            addCriterion("upper(isa_status) like", value.toUpperCase(), "isaStatus");
            return this;
        }

        public Criteria andIsaCreatedateLikeInsensitive(String value) {
            addCriterion("upper(isa_createdate) like", value.toUpperCase(), "isaCreatedate");
            return this;
        }

        public Criteria andIsaCreateuserLikeInsensitive(String value) {
            addCriterion("upper(isa_createuser) like", value.toUpperCase(), "isaCreateuser");
            return this;
        }

        public Criteria andIsaUpdatedateLikeInsensitive(String value) {
            addCriterion("upper(isa_updatedate) like", value.toUpperCase(), "isaUpdatedate");
            return this;
        }

        public Criteria andIsaUpdateuserLikeInsensitive(String value) {
            addCriterion("upper(isa_updateuser) like", value.toUpperCase(), "isaUpdateuser");
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