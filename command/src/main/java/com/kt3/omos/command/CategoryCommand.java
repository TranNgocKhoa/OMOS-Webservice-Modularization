package com.kt3.omos.command;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class CategoryCommand {
    private Long id;
    private String code;
    private String name;
    private String description;
    private String image;
    private boolean status;
    private Long parentId;
    private Set<CategoryWithoutProductList> childs = new HashSet<>();
    private Set<ProductCommand> products = new HashSet<>();
    protected String createdBy;
    protected LocalDateTime creationDate;
    protected String lastModifiedBy;
    protected LocalDateTime lastModifiedDate;

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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Set<CategoryWithoutProductList> getChilds() {
        return childs;
    }

    public void setChilds(Set<CategoryWithoutProductList> childs) {
        this.childs = childs;
    }

    public Set<ProductCommand> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductCommand> products) {
        this.products = products;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}