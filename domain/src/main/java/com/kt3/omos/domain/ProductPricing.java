package com.kt3.omos.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class ProductPricing extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal basedPrice;
    private Date dateCreated;
    private Date dateExpiry;
    private boolean active;
    @ManyToOne
    private Product product;
}
