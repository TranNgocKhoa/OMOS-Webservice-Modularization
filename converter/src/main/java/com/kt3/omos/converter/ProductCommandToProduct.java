package com.kt3.omos.converter;

import com.kt3.omos.command.ProductCommand;
import com.kt3.omos.domain.Product;
import com.kt3.omos.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

//  private Long id;
//    private String code;
//    private String name;
//    private String urlPath;
//    private String description;
//    private String thumbnail;
//    private List<String> images;
//    private BigDecimal price;
//    private float avgRating;
//    private int quantity;
//    private boolean hotFlag;
//    private boolean status;
//    private Long categoryId;
//
//    protected String createdBy;
//    protected LocalDateTime creationDate;
//    protected String lastModifiedBy;
//    protected LocalDateTime lastModifiedDate;
@Component
public class ProductCommandToProduct implements Converter<ProductCommand, Product> {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public Product convert(ProductCommand productCommand) {
        if(productCommand == null) return null;
        Product product = new Product();
        product.setId(productCommand.getId());
        product.setCode(productCommand.getCode());
        product.setName(productCommand.getName());
        product.setUrlPath(productCommand.getUrlPath());
        product.setDescription(productCommand.getDescription());
        product.setThumbnail(productCommand.getThumbnail());
        product.setImages(productCommand.getImages());
        product.setPrice(productCommand.getPrice());
        product.setAvgRating(productCommand.getAvgRating());
        product.setQuantity(productCommand.getQuantity());
        product.setHotFlag(productCommand.isHotFlag());
        product.setStatus(productCommand.isStatus());
        product.setCategory(categoryRepository.findById(Long.valueOf(productCommand.getCategoryId())).isPresent()? categoryRepository.findById(Long.valueOf(productCommand.getCategoryId())).get(): null);
        product.setCreatedBy(null);
        product.setCreationDate(productCommand.getCreationDate());
        product.setLastModifiedBy(null);
        product.setLastModifiedDate(LocalDateTime.now());
        return product;
    }
}
