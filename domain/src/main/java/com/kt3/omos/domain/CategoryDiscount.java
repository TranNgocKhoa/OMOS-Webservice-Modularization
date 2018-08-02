package com.kt3.omos.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class CategoryDiscount extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal discountValue;
    private String discountUnit;
    private Date dateStarted;
    private Date vaildUntil;
    private String couponCode;
    private BigDecimal miniumOrderValue;
    private BigDecimal maximumDiscountAmount;
    private boolean redeemAllowed;

    @ManyToOne
    private Category category;

    public CategoryDiscount() {
    }

    public CategoryDiscount(BigDecimal discountValue, String discountUnit, Date dateStarted, Date vaildUntil, String couponCode, BigDecimal miniumOrderValue, BigDecimal maximumDiscountAmount, boolean redeemAllowed, Category category) {
        this.discountValue = discountValue;
        this.discountUnit = discountUnit;
        this.dateStarted = dateStarted;
        this.vaildUntil = vaildUntil;
        this.couponCode = couponCode;
        this.miniumOrderValue = miniumOrderValue;
        this.maximumDiscountAmount = maximumDiscountAmount;
        this.redeemAllowed = redeemAllowed;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(BigDecimal discountValue) {
        this.discountValue = discountValue;
    }

    public String getDiscountUnit() {
        return discountUnit;
    }

    public void setDiscountUnit(String discountUnit) {
        this.discountUnit = discountUnit;
    }

    public Date getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(Date dateStarted) {
        this.dateStarted = dateStarted;
    }

    public Date getVaildUntil() {
        return vaildUntil;
    }

    public void setVaildUntil(Date vaildUntil) {
        this.vaildUntil = vaildUntil;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public BigDecimal getMiniumOrderValue() {
        return miniumOrderValue;
    }

    public void setMiniumOrderValue(BigDecimal miniumOrderValue) {
        this.miniumOrderValue = miniumOrderValue;
    }

    public BigDecimal getMaximumDiscountAmount() {
        return maximumDiscountAmount;
    }

    public void setMaximumDiscountAmount(BigDecimal maximumDiscountAmount) {
        this.maximumDiscountAmount = maximumDiscountAmount;
    }

    public boolean isRedeemAllowed() {
        return redeemAllowed;
    }

    public void setRedeemAllowed(boolean redeemAllowed) {
        this.redeemAllowed = redeemAllowed;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
