package com.kt3.omos.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
public class Product extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private String description;
    private String thumbnail;
    @ElementCollection
    private List<String> images;
    private BigDecimal price;
    private float avgRating;
    private int quantity;
    private boolean hotFlag;
    private boolean status;

    @ManyToOne
    private Category category;
    @OneToMany(mappedBy = "product")
    private Set<ProductPricing> productPricings;
    @OneToMany(mappedBy = "product")
    private Set<ProductDiscount> productDiscounts;
    @OneToMany(mappedBy = "product")
    private Set<ProductComment> productComments;
}
