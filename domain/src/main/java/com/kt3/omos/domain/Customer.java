package com.kt3.omos.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer extends Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int promotionalRewardPoint;
    private int nonPromotionalRewardPoint;
    @ManyToOne
    private MembershipType membershipType;
    @OneToMany(mappedBy = "customer")
    private Set<CustomerRewardPointLog> customerRewardPointLogs = new HashSet<>();
    @OneToMany(mappedBy = "customer")
    private Set<ProductComment> productComments = new HashSet<>();

    public Customer() {
    }

    public Customer(int promotionalRewardPoint, int nonPromotionalRewardPoint, MembershipType membershipType, Set<CustomerRewardPointLog> customerRewardPointLogs, Set<ProductComment> productComments) {
        this.promotionalRewardPoint = promotionalRewardPoint;
        this.nonPromotionalRewardPoint = nonPromotionalRewardPoint;
        this.membershipType = membershipType;
        this.customerRewardPointLogs = customerRewardPointLogs;
        this.productComments = productComments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPromotionalRewardPoint() {
        return promotionalRewardPoint;
    }

    public void setPromotionalRewardPoint(int promotionalRewardPoint) {
        this.promotionalRewardPoint = promotionalRewardPoint;
    }

    public int getNonPromotionalRewardPoint() {
        return nonPromotionalRewardPoint;
    }

    public void setNonPromotionalRewardPoint(int nonPromotionalRewardPoint) {
        this.nonPromotionalRewardPoint = nonPromotionalRewardPoint;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
    }

    public Set<CustomerRewardPointLog> getCustomerRewardPointLogs() {
        return customerRewardPointLogs;
    }

    public void setCustomerRewardPointLogs(Set<CustomerRewardPointLog> customerRewardPointLogs) {
        this.customerRewardPointLogs = customerRewardPointLogs;
    }

    public Set<ProductComment> getProductComments() {
        return productComments;
    }

    public void setProductComments(Set<ProductComment> productComments) {
        this.productComments = productComments;
    }
}
