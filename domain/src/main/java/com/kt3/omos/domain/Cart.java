package com.kt3.omos.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
public class Cart extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal subTotal;
    @OneToOne
    private Account account;
    @OneToMany(mappedBy = "cart")
    private Set<CartItem> cartItems;
}
