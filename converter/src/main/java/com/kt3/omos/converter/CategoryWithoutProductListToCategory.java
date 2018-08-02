package com.kt3.omos.converter;

import com.kt3.omos.command.CategoryWithoutProductList;
import com.kt3.omos.domain.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CategoryWithoutProductListToCategory implements Converter<CategoryWithoutProductList, Category> {
    @Override
    public Category convert(CategoryWithoutProductList categoryWithoutProductList) {
        if(categoryWithoutProductList == null){
            return null;
        }
// private Long id;
//    private String code;
//    private String name;
//    private String description;
//    private String image;
//    private boolean status;
        final Category category = new Category();
        category.setId(categoryWithoutProductList.getId());
        category.setCode(categoryWithoutProductList.getCode());
        category.setName(categoryWithoutProductList.getName());
        category.setDescription(categoryWithoutProductList.getDescription());
        category.setImage(categoryWithoutProductList.getImage());
        category.setStatus(categoryWithoutProductList.isStatus());
        category.setCreatedBy(categoryWithoutProductList.getCreatedBy());
        category.setCreationDate(categoryWithoutProductList.getCreationDate());
        category.setLastModifiedBy(categoryWithoutProductList.getLastModifiedBy());
        category.setLastModifiedDate(LocalDateTime.now());
        return category;
    }
}
