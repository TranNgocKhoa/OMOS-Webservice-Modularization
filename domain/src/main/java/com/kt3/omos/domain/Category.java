package com.kt3.omos.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private String description;
    private String image;
    private boolean status;
    @ManyToOne
    private Category parent;
    @OneToMany(mappedBy = "parent")
    private Set<Category> childs;
    @OneToMany(mappedBy = "category")
    private Set<Product> products;
    @OneToMany(mappedBy = "category")
    private Set<CategoryDiscount> categoryDiscounts;


}
