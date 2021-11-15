package vn.neo.api.entity.log;

import java.util.ArrayList;
import java.util.List;

public class LogActExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table FURNITURE_LOG.LOG_ACT
     *
     * @mbg.generated Mon Nov 15 22:18:33 ICT 2021
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table FURNITURE_LOG.LOG_ACT
     *
     * @mbg.generated Mon Nov 15 22:18:33 ICT 2021
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table FURNITURE_LOG.LOG_ACT
     *
     * @mbg.generated Mon Nov 15 22:18:33 ICT 2021
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FURNITURE_LOG.LOG_ACT
     *
     * @mbg.generated Mon Nov 15 22:18:33 ICT 2021
     */
    public LogActExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FURNITURE_LOG.LOG_ACT
     *
     * @mbg.generated Mon Nov 15 22:18:33 ICT 2021
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FURNITURE_LOG.LOG_ACT
     *
     * @mbg.generated Mon Nov 15 22:18:33 ICT 2021
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FURNITURE_LOG.LOG_ACT
     *
     * @mbg.generated Mon Nov 15 22:18:33 ICT 2021
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FURNITURE_LOG.LOG_ACT
     *
     * @mbg.generated Mon Nov 15 22:18:33 ICT 2021
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FURNITURE_LOG.LOG_ACT
     *
     * @mbg.generated Mon Nov 15 22:18:33 ICT 2021
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FURNITURE_LOG.LOG_ACT
     *
     * @mbg.generated Mon Nov 15 22:18:33 ICT 2021
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FURNITURE_LOG.LOG_ACT
     *
     * @mbg.generated Mon Nov 15 22:18:33 ICT 2021
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FURNITURE_LOG.LOG_ACT
     *
     * @mbg.generated Mon Nov 15 22:18:33 ICT 2021
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FURNITURE_LOG.LOG_ACT
     *
     * @mbg.generated Mon Nov 15 22:18:33 ICT 2021
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FURNITURE_LOG.LOG_ACT
     *
     * @mbg.generated Mon Nov 15 22:18:33 ICT 2021
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FURNITURE_LOG.LOG_ACT
     *
     * @mbg.generated Mon Nov 15 22:18:33 ICT 2021
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Short value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Short value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Short value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Short value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Short value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Short value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Short> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Short> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Short value1, Short value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Short value1, Short value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andReqIsNull() {
            addCriterion("REQ is null");
            return (Criteria) this;
        }

        public Criteria andReqIsNotNull() {
            addCriterion("REQ is not null");
            return (Criteria) this;
        }

        public Criteria andReqEqualTo(String value) {
            addCriterion("REQ =", value, "req");
            return (Criteria) this;
        }

        public Criteria andReqNotEqualTo(String value) {
            addCriterion("REQ <>", value, "req");
            return (Criteria) this;
        }

        public Criteria andReqGreaterThan(String value) {
            addCriterion("REQ >", value, "req");
            return (Criteria) this;
        }

        public Criteria andReqGreaterThanOrEqualTo(String value) {
            addCriterion("REQ >=", value, "req");
            return (Criteria) this;
        }

        public Criteria andReqLessThan(String value) {
            addCriterion("REQ <", value, "req");
            return (Criteria) this;
        }

        public Criteria andReqLessThanOrEqualTo(String value) {
            addCriterion("REQ <=", value, "req");
            return (Criteria) this;
        }

        public Criteria andReqLike(String value) {
            addCriterion("REQ like", value, "req");
            return (Criteria) this;
        }

        public Criteria andReqNotLike(String value) {
            addCriterion("REQ not like", value, "req");
            return (Criteria) this;
        }

        public Criteria andReqIn(List<String> values) {
            addCriterion("REQ in", values, "req");
            return (Criteria) this;
        }

        public Criteria andReqNotIn(List<String> values) {
            addCriterion("REQ not in", values, "req");
            return (Criteria) this;
        }

        public Criteria andReqBetween(String value1, String value2) {
            addCriterion("REQ between", value1, value2, "req");
            return (Criteria) this;
        }

        public Criteria andReqNotBetween(String value1, String value2) {
            addCriterion("REQ not between", value1, value2, "req");
            return (Criteria) this;
        }

        public Criteria andResIsNull() {
            addCriterion("RES is null");
            return (Criteria) this;
        }

        public Criteria andResIsNotNull() {
            addCriterion("RES is not null");
            return (Criteria) this;
        }

        public Criteria andResEqualTo(String value) {
            addCriterion("RES =", value, "res");
            return (Criteria) this;
        }

        public Criteria andResNotEqualTo(String value) {
            addCriterion("RES <>", value, "res");
            return (Criteria) this;
        }

        public Criteria andResGreaterThan(String value) {
            addCriterion("RES >", value, "res");
            return (Criteria) this;
        }

        public Criteria andResGreaterThanOrEqualTo(String value) {
            addCriterion("RES >=", value, "res");
            return (Criteria) this;
        }

        public Criteria andResLessThan(String value) {
            addCriterion("RES <", value, "res");
            return (Criteria) this;
        }

        public Criteria andResLessThanOrEqualTo(String value) {
            addCriterion("RES <=", value, "res");
            return (Criteria) this;
        }

        public Criteria andResLike(String value) {
            addCriterion("RES like", value, "res");
            return (Criteria) this;
        }

        public Criteria andResNotLike(String value) {
            addCriterion("RES not like", value, "res");
            return (Criteria) this;
        }

        public Criteria andResIn(List<String> values) {
            addCriterion("RES in", values, "res");
            return (Criteria) this;
        }

        public Criteria andResNotIn(List<String> values) {
            addCriterion("RES not in", values, "res");
            return (Criteria) this;
        }

        public Criteria andResBetween(String value1, String value2) {
            addCriterion("RES between", value1, value2, "res");
            return (Criteria) this;
        }

        public Criteria andResNotBetween(String value1, String value2) {
            addCriterion("RES not between", value1, value2, "res");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FURNITURE_LOG.LOG_ACT
     *
     * @mbg.generated do_not_delete_during_merge Mon Nov 15 22:18:33 ICT 2021
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FURNITURE_LOG.LOG_ACT
     *
     * @mbg.generated Mon Nov 15 22:18:33 ICT 2021
     */
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