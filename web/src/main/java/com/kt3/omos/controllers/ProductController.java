package com.kt3.omos.controllers;

import com.kt3.omos.command.ProductCommand;
import com.kt3.omos.domain.Product;
import com.kt3.omos.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//CRUD: create read update delete
@RestController
@RequestMapping("/api/product/")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/list")
    List<ProductCommand> getAllProducts(){
        return productService.getAllProductCommands();
    }

    @PostMapping("/add")
    ProductCommand createProduct(@RequestBody ProductCommand productCommand){
        return productService.createProduct(productCommand);
    }

    @GetMapping("/{id}/view")
    ProductCommand viewProduct(@PathVariable String id){
        return null;
    }

    @PostMapping("/update")
    ProductCommand updateProduct(@RequestBody ProductCommand productCommand){
        return null;
    }

    @DeleteMapping("/{id}/delete")
    ResponseEntity deleteProduct(@PathVariable String id) {
        return null;
    }

}
