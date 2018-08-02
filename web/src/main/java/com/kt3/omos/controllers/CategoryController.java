package com.kt3.omos.controllers;

import com.kt3.omos.command.CategoryCommand;
import com.kt3.omos.command.CategoryWithoutProductList;
import com.kt3.omos.command.ProductCommand;
import com.kt3.omos.domain.Category;
import com.kt3.omos.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/category/")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("/list-simple")
    List<CategoryWithoutProductList> getCategoriesWithoutProductList(){
        return categoryService.getAllCategoriesWithoutIstProductsList();
    }
    @GetMapping("/list")
    List<CategoryCommand> getAllCategories(){
        return categoryService.getAllCategoriesCommand();
    }

    @GetMapping("/{id}")
    CategoryCommand getCategoryById(@PathVariable String id){
        return categoryService.getCategoryCommandById(id);
    }

    @PostMapping("/add")
    CategoryWithoutProductList createCategory(@RequestBody CategoryWithoutProductList categoryWithoutProductList){
        if(categoryWithoutProductList.getId() != 0) return null;
        categoryWithoutProductList.setCreationDate(LocalDateTime.now());
        return categoryService.saveCategoryWithoutProductList(categoryWithoutProductList);
    }
    @PostMapping("/update")
    CategoryWithoutProductList updateCategory(@RequestBody CategoryWithoutProductList categoryWithoutProductList){
        if(categoryWithoutProductList.getId() == 0) return null;
        categoryWithoutProductList.setCreationDate(LocalDateTime.now());
        return categoryService.saveCategoryWithoutProductList(categoryWithoutProductList);
    }

    @PostMapping("/{id}/addProduct")
    CategoryCommand addProductToCategory(@PathVariable String id, @RequestBody ProductCommand productCommand){
        return categoryService.addProduct(categoryService.getCategoryCommandById(id), productCommand);
    }

    @PostMapping("/{id}/removeProduct")
    CategoryCommand removeProductFromCategory(@PathVariable String id, @RequestBody ProductCommand productCommand){
        return null;
    }

    @GetMapping("/{id}/clearAllProduct")
    CategoryCommand clearAllProductFromCategory(@PathVariable String id){
        return null;
    }

    @DeleteMapping("/{id}/delete")
    ResponseEntity deleteCategory(@PathVariable String id){
        try {
            Long catId = Long.valueOf(id);
            Category targetCat = categoryService.getCategoryById(id);
            if (targetCat == null) {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            else{
                if(categoryService.deleteCategoryById(id)) {
                    return new ResponseEntity(HttpStatus.OK);
                }
                else
                {
                    return new ResponseEntity(HttpStatus.CONFLICT);
                }
            }
        }
        catch (NumberFormatException exception){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        finally {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }

    }



}
