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

    public CartItem() {
    }

    public CartItem(BigDecimal unitPrice, int quantity, BigDecimal discount, Cart cart, Product product) {
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.discount = discount;
        this.cart = cart;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
