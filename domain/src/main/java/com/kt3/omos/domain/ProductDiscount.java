package com.kt3.omos.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class ProductDiscount extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal discountValue;
    private String discountUnit;
    private Date dateStarted;
    private Date vaidldUntil;
    private String couponCode;
    private BigDecimal miniumOrderValue;
    private BigDecimal maximumDiscountAmount;
    private boolean redeemAllowed;

    @ManyToOne
    private Product product;
}
