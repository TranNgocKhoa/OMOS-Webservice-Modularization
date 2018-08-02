package com.kt3.omos.domain;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
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
    @ManyToOne(cascade = CascadeType.ALL)
    private Category parent;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "parent")
    private Set<Category> childs = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category", orphanRemoval = true)
    private Set<Product> products = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<CategoryDiscount> categoryDiscounts = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        if(parent != null) {
            parent.addChilds(this);
        }
        this.parent = parent;
    }

    public Set<Category> getChilds() {
        return childs;
    }

    public void setChilds(Set<Category> childs) {
        this.childs = childs;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<CategoryDiscount> getCategoryDiscounts() {
        return categoryDiscounts;
    }

    public void setCategoryDiscounts(Set<CategoryDiscount> categoryDiscounts) {
        this.categoryDiscounts = categoryDiscounts;
    }

    public void addProduct(Product product){

        this.products.add(product);
        if(product != null){
            if(product.getCategory() != this)
                product.setCategory(this);
        }
    }

    public void addChilds(Category child){
        //product.setCategory(this);
        this.childs.add(child);
    }

    @PreRemove
    public void nullParentChilds(){
        products.forEach(product -> product.setCategory(null));
        childs.forEach(child -> child.setParent(null));
    }
}
