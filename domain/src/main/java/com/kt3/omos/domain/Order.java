package com.kt3.omos.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "Orders")
public class Order extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private BigDecimal subTotal;
    private BigDecimal tax;
    private BigDecimal totalPrice;
    private int status;
    private String paymentInfo;
    @OneToMany(mappedBy = "order")
    private Set<OrderItem> orderItems;
}
