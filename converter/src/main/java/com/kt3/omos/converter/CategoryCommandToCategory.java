package com.kt3.omos.converter;

import com.kt3.omos.command.CategoryCommand;
import com.kt3.omos.command.CategoryWithoutProductList;
import com.kt3.omos.command.ProductCommand;
import com.kt3.omos.domain.Category;
import com.kt3.omos.domain.Product;
import com.kt3.omos.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CategoryWithoutProductListToCategory categoryWithoutProductLists;
    @Autowired
    ProductCommandToProduct productCommandToProduct;
    @Override
    public Category convert(CategoryCommand categoryCommand) {
        if(categoryCommand == null) return null;
        Category category = new Category();
        category.setId(categoryCommand.getId());
        category.setCode(categoryCommand.getCode());
        category.setName(categoryCommand.getName());
        category.setDescription(categoryCommand.getDescription());
        category.setImage(categoryCommand.getImage());
        category.setStatus(categoryCommand.isStatus());
        category.setParent(categoryRepository.findById(categoryCommand.getParentId()).isPresent()? categoryRepository.findById(categoryCommand.getParentId()).get(): null);
        Set<CategoryWithoutProductList> childs = categoryCommand.getChilds();
        Set<Category> categoryChilds = new HashSet<>();
        for (CategoryWithoutProductList cat: childs
                ) {
            categoryChilds.add(categoryWithoutProductLists.convert(cat));
        }
        category.setChilds(categoryChilds);
        Set<Product> products = new HashSet<>();
        Set<ProductCommand> productCommands = categoryCommand.getProducts();
        for(ProductCommand product : productCommands){
            products.add(productCommandToProduct.convert(product));
        }
        category.setProducts(products);
        category.setCreatedBy(category.getCreatedBy());
        category.setCreationDate(category.getCreationDate());
        category.setLastModifiedBy(category.getLastModifiedBy());
        category.setLastModifiedDate(category.getLastModifiedDate());
        return category;
    }
}
