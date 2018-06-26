package com.kt3.omos.domain;

import javax.persistence.*;

@Entity
public class ProductComment extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float rating;
    private String commentTitle;
    private String commentContent;
    @ManyToOne
    private Product product;
    @ManyToOne
    private Customer customer;
}
