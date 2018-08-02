package com.kt3.omos.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class MembershipType extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String membershipTypeName;
    private BigDecimal discountValue;
    private String discountUnit;
    private Date vaildUntil;
    private boolean freeShippingActive;
    @OneToMany(mappedBy = "membershipType")
    private Set<Customer> customers = new HashSet<>();

    public MembershipType() {
    }

    public MembershipType(String membershipTypeName, BigDecimal discountValue, String discountUnit, Date vaildUntil, boolean freeShippingActive, Set<Customer> customers) {
        this.membershipTypeName = membershipTypeName;
        this.discountValue = discountValue;
        this.discountUnit = discountUnit;
        this.vaildUntil = vaildUntil;
        this.freeShippingActive = freeShippingActive;
        this.customers = customers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMembershipTypeName() {
        return membershipTypeName;
    }

    public void setMembershipTypeName(String membershipTypeName) {
        this.membershipTypeName = membershipTypeName;
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

    public Date getVaildUntil() {
        return vaildUntil;
    }

    public void setVaildUntil(Date vaildUntil) {
        this.vaildUntil = vaildUntil;
    }

    public boolean isFreeShippingActive() {
        return freeShippingActive;
    }

    public void setFreeShippingActive(boolean freeShippingActive) {
        this.freeShippingActive = freeShippingActive;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
