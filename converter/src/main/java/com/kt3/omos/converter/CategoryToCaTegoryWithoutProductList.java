package com.kt3.omos.converter;

import com.kt3.omos.command.CategoryWithoutProductList;
import com.kt3.omos.domain.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCaTegoryWithoutProductList implements Converter<Category, CategoryWithoutProductList> {
    @Override
    public CategoryWithoutProductList convert(Category category) {
        if(category == null)
        {
            return null;
        }

        final CategoryWithoutProductList categoryWithoutProductList = new CategoryWithoutProductList();
        categoryWithoutProductList.setId(category.getId());
        categoryWithoutProductList.setCode(category.getCode());
        categoryWithoutProductList.setName(category.getName());
        categoryWithoutProductList.setDescription(category.getDescription());
        categoryWithoutProductList.setImage(category.getImage());
        categoryWithoutProductList.setStatus(category.isStatus());
        categoryWithoutProductList.setCreatedBy(category.getCreatedBy());
        categoryWithoutProductList.setCreationDate(category.getCreationDate());
        categoryWithoutProductList.setLastModifiedBy(category.getLastModifiedBy());
        categoryWithoutProductList.setLastModifiedDate(category.getLastModifiedDate());
        return categoryWithoutProductList;
    }
}
