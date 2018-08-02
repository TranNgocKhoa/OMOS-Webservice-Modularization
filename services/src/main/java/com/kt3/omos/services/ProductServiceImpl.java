package com.kt3.omos.services;

import com.kt3.omos.command.ProductCommand;
import com.kt3.omos.converter.ProductCommandToProduct;
import com.kt3.omos.converter.ProductToProductCommand;
import com.kt3.omos.domain.Product;
import com.kt3.omos.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductToProductCommand productToProductCommand;
    @Autowired
    ProductCommandToProduct productCommandToProduct;


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(String id) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        if(product == null) return null;
        if(product.getId() != 0) return null;

        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public List<ProductCommand> getAllProductCommands() {
        List<Product> products = getAllProducts();
        List<ProductCommand> productCommands = new ArrayList<>();
        for (Product product: products
             ) {
            productCommands.add(productToProductCommand.convert(product));
        }
        return productCommands;
    }

    @Override
    public ProductCommand createProduct(ProductCommand productCommand) {
        Product targetProduct = productCommandToProduct.convert(productCommand);
        Product savedProduct = createProduct(targetProduct);
        return productToProductCommand.convert(savedProduct);
    }

    @Override
    public ProductCommand getProductCommandById(String id) {
        return null;
    }

    @Override
    public ProductCommand updateProduct(ProductCommand productCommand) {
        return null;
    }

    @Override
    public boolean deleteProduct(String id) {
        return false;
    }
}
