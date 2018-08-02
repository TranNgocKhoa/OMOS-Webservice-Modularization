package com.kt3.omos.services;

import com.kt3.omos.command.ProductCommand;
import com.kt3.omos.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(String id);
    Product createProduct(Product product);
    Product updateProduct(Product product);

    List<ProductCommand> getAllProductCommands();
    ProductCommand createProduct(ProductCommand productCommand);
    ProductCommand getProductCommandById(String id);
    ProductCommand updateProduct(ProductCommand productCommand);
    boolean deleteProduct(String id);
}
