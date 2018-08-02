package com.kt3.omos.services;

import com.kt3.omos.command.CategoryCommand;
import com.kt3.omos.command.CategoryWithoutProductList;
import com.kt3.omos.command.ProductCommand;
import com.kt3.omos.domain.Category;
import java.util.List;

public interface CategoryService {
    List<Category> getAllCategoriesWithItsProductList();
    List<CategoryCommand> getAllCategoriesCommand();
    List<CategoryWithoutProductList> getAllCategoriesWithoutIstProductsList();
    List<Category> getCategoriesByNameWithItsProductsList(String name);
    List<Category> getCategoriesByNameWithoutItsProductsList(String name);
    Category getCategoryById(String id);
    CategoryCommand getCategoryCommandById(String id);
    Category saveCategory(Category category);
    CategoryWithoutProductList saveCategoryWithoutProductList(CategoryWithoutProductList categoryWithoutProductList);
    Category saveListCategories(List<Category> categories);
    CategoryCommand addProduct(CategoryCommand categoryCommand, ProductCommand productCommand);
    CategoryCommand removeProduct(CategoryCommand categoryCommand, ProductCommand productCommand);
    CategoryCommand clearAllProduct(CategoryCommand categoryCommand);
    boolean deleteCategory(Category category);
    boolean deleteCategoryById(String id);
}
