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
}
