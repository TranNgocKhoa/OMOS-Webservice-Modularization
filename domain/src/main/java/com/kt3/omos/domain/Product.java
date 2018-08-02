package com.kt3.omos.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Product extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private String urlPath;
    private String description;
    private String thumbnail;
    @ElementCollection
    @CollectionTable(name = "PRODUCT_IMAGES")
    @OrderColumn
    private List<String> images;
    private BigDecimal price;
    private float avgRating;
    private int quantity;
    private boolean hotFlag;
    private boolean status;

    @ManyToOne
    private Category category;
    @OneToMany(mappedBy = "product")
    private Set<ProductPricing> productPricings = new HashSet<>();
    @OneToMany(mappedBy = "product")
    private Set<ProductDiscount> productDiscounts = new HashSet<>();
    @OneToMany(mappedBy = "product")
    private Set<ProductComment> productComments = new HashSet<>();

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

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public float getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(float avgRating) {
        this.avgRating = avgRating;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isHotFlag() {
        return hotFlag;
    }

    public void setHotFlag(boolean hotFlag) {
        this.hotFlag = hotFlag;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
//        if(category != null) {
//            if(!category.getProducts().contains(this))
//            this.category.addProduct(this);
//        }
    }

    public Set<ProductPricing> getProductPricings() {
        return productPricings;
    }

    public void setProductPricings(Set<ProductPricing> productPricings) {
        this.productPricings = productPricings;
    }

    public Set<ProductDiscount> getProductDiscounts() {
        return productDiscounts;
    }

    public void setProductDiscounts(Set<ProductDiscount> productDiscounts) {
        this.productDiscounts = productDiscounts;
    }

    public Set<ProductComment> getProductComments() {
        return productComments;
    }

    public void setProductComments(Set<ProductComment> productComments) {
        this.productComments = productComments;
    }


}
