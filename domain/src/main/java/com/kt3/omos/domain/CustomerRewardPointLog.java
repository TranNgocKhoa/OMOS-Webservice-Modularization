package com.kt3.omos.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class CustomerRewardPointLog extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal rewardPoint;
    private String rewardType;
    private String operationType;
    private Date expiredOn;
    @ManyToOne
    private Customer customer;

    public CustomerRewardPointLog() {
    }

    public CustomerRewardPointLog(BigDecimal rewardPoint, String rewardType, String operationType, Date expiredOn, Customer customer) {
        this.rewardPoint = rewardPoint;
        this.rewardType = rewardType;
        this.operationType = operationType;
        this.expiredOn = expiredOn;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getRewardPoint() {
        return rewardPoint;
    }

    public void setRewardPoint(BigDecimal rewardPoint) {
        this.rewardPoint = rewardPoint;
    }

    public String getRewardType() {
        return rewardType;
    }

    public void setRewardType(String rewardType) {
        this.rewardType = rewardType;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Date getExpiredOn() {
        return expiredOn;
    }

    public void setExpiredOn(Date expiredOn) {
        this.expiredOn = expiredOn;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
