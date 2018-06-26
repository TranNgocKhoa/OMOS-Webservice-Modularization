package com.kt3.omos.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
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
    private Set<Customer> customers;
}
