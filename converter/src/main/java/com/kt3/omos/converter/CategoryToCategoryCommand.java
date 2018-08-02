package com.kt3.omos.converter;

import com.kt3.omos.command.CategoryCommand;
import com.kt3.omos.command.CategoryWithoutProductList;
import com.kt3.omos.command.ProductCommand;
import com.kt3.omos.domain.Category;
import com.kt3.omos.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

//    private Long id;
//    private String code;
//    private String name;
//    private String description;
//    private String image;
//    private boolean status;
//    private Long parentId;
//    private Set<CategoryWithoutProductList> childs = new HashSet<>();
//    private Set<ProductCommand> products = new HashSet<>();
//    protected String createdBy;
//    protected LocalDateTime creationDate;
//    protected String lastModifiedBy;
//    protected LocalDateTime lastModifiedDate;
@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {
    @Autowired
    CategoryToCaTegoryWithoutProductList categoryToCaTegoryWithoutProductList;
    @Autowired
    ProductToProductCommand productToProductCommand;
    @Override
    public CategoryCommand convert(Category category) {
        if(category == null) return null;
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(category.getId());
        categoryCommand.setCode(category.getCode());
        categoryCommand.setName(category.getName());
        categoryCommand.setDescription(category.getDescription());
        categoryCommand.setImage(category.getImage());
        categoryCommand.setStatus(category.isStatus());
        categoryCommand.setParentId(category.getParent()== null ? 0 : category.getParent().getId());
        Set<Category> childs = category.getChilds();
        Set<CategoryWithoutProductList> categoryWithoutProductLists = new HashSet<>();
        for (Category cat: childs
             ) {
            categoryWithoutProductLists.add(categoryToCaTegoryWithoutProductList.convert(cat));
        }
        categoryCommand.setChilds(categoryWithoutProductLists);
        Set<Product> products = category.getProducts();
        Set<ProductCommand> productCommands = new HashSet<>();
        for(Product product : products){
            productCommands.add(productToProductCommand.convert(product));
        }
        categoryCommand.setProducts(productCommands);
        categoryCommand.setCreatedBy(category.getCreatedBy());
        categoryCommand.setCreationDate(category.getCreationDate());
        categoryCommand.setLastModifiedBy(category.getLastModifiedBy());
        categoryCommand.setLastModifiedDate(category.getLastModifiedDate());
        return categoryCommand;
    }
}
