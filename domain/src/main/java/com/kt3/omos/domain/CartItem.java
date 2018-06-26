package com.kt3.omos.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class CartItem extends Auditable<String>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal unitPrice;
    private int quantity;
    private BigDecimal discount;
    @ManyToOne
    private Cart cart;
    @ManyToOne
    private Product product;
}
