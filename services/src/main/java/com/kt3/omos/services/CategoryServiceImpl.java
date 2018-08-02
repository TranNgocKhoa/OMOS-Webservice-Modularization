package com.kt3.omos.services;

import com.kt3.omos.command.CategoryCommand;
import com.kt3.omos.command.ProductCommand;
import com.kt3.omos.converter.*;
import com.kt3.omos.command.CategoryWithoutProductList;
import com.kt3.omos.domain.Category;
import com.kt3.omos.domain.Product;
import com.kt3.omos.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryWithoutProductListToCategory categoryWithoutProductListToCategory;
    @Autowired
    CategoryToCaTegoryWithoutProductList categoryToCaTegoryWithoutProductList;
    @Autowired
    CategoryToCategoryCommand categoryToCategoryCommand;
    @Autowired
    CategoryCommandToCategory categoryCommandToCategory;
    @Autowired
    ProductToProductCommand productToProductCommand;
    @Autowired
    ProductCommandToProduct productCommandToProduct;
    @Autowired
    CategoryRepository categoryRepository;



    @Override
    public List<Category> getAllCategoriesWithItsProductList() {
        return null;
    }

    @Override
    public List<CategoryCommand> getAllCategoriesCommand() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryCommand> categoryCommands = new ArrayList<>();
        for (Category cat: categories
             ) {
            categoryCommands.add(categoryToCategoryCommand.convert(cat));
        }
        return categoryCommands;
    }

    @Override
    public List<CategoryWithoutProductList> getAllCategoriesWithoutIstProductsList() {
       List<Category> categories = categoryRepository.findAll();
       List<CategoryWithoutProductList> categoryWithoutProductLists = new ArrayList<>();
        for (Category cat : categories
             ) {
            categoryWithoutProductLists.add(categoryToCaTegoryWithoutProductList.convert(cat));
        }
        return categoryWithoutProductLists;
    }

    @Override
    public List<Category> getCategoriesByNameWithItsProductsList(String name) {
        return null;
    }

    @Override
    public List<Category> getCategoriesByNameWithoutItsProductsList(String name) {
        return null;
    }

    @Override
    public Category getCategoryById(String id) {
        return categoryRepository.findById(Long.valueOf(id)).get();
    }

    @Override
    public CategoryCommand getCategoryCommandById(String id) {
        return categoryToCategoryCommand.convert(categoryRepository.findById(Long.valueOf(id)).get());
    }


    @Override
    public Category saveCategory(Category category) {
        return null;
    }

    @Override
    public CategoryWithoutProductList saveCategoryWithoutProductList(CategoryWithoutProductList categoryWithoutProductList) {
        Category detachedCategory = categoryWithoutProductListToCategory.convert(categoryWithoutProductList);
        if(categoryRepository.findById(detachedCategory.getId()).isPresent()){
            Category parent = categoryRepository.findById(detachedCategory.getId()).get().getParent();
            detachedCategory.setParent(parent);
        }
        Category savedCategory = categoryRepository.save(detachedCategory);
        return categoryToCaTegoryWithoutProductList.convert(savedCategory);
    }

    @Override
    public Category saveListCategories(List<Category> categories) {
        return null;
    }

    @Override
    public CategoryCommand addProduct(CategoryCommand categoryCommand, ProductCommand productCommand) {
        if(categoryRepository.findById(categoryCommand.getId()).get()== null) return null;
        Category targetCat = categoryCommandToCategory.convert(categoryCommand);
        Product product = productCommandToProduct.convert(productCommand);
        targetCat.addProduct(product);
        Category savedCategory = categoryRepository.save(targetCat);
        return categoryToCategoryCommand.convert(savedCategory);
    }

    @Override
    public CategoryCommand removeProduct(CategoryCommand categoryCommand, ProductCommand productCommand) {
        if(categoryRepository.findById(categoryCommand.getId()).get()== null) return null;
        Category targetCat = categoryCommandToCategory.convert(categoryCommand);
        Product product = productCommandToProduct.convert(productCommand);
        targetCat.getProducts().remove(product);
        product.setCategory(null);
        Category savedCategory = categoryRepository.save(targetCat);
        return categoryToCategoryCommand.convert(savedCategory);
    }

    @Override
    public CategoryCommand clearAllProduct(CategoryCommand categoryCommand) {
        if(categoryRepository.findById(categoryCommand.getId()).get()== null) return null;
        Category targetCat = categoryCommandToCategory.convert(categoryCommand);
        for (Product product: targetCat.getProducts()
             ) {
            product.setCategory(null);
        }
        targetCat.setProducts(new HashSet<>());
        Category savedCategory = categoryRepository.save(targetCat);
        return categoryToCategoryCommand.convert(savedCategory);
    }

    @Override
    public boolean deleteCategory(Category category) {
        return false;
    }

    @Override
    public boolean deleteCategoryById(String id) {
        try{
            Long targetId = Long.valueOf(id);
            categoryRepository.deleteById(targetId);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
