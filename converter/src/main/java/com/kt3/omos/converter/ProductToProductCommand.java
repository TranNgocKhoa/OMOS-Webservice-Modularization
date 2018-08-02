package com.kt3.omos.converter;

import com.kt3.omos.command.ProductCommand;
import com.kt3.omos.domain.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductToProductCommand implements Converter<Product, ProductCommand> {


    @Override
    public ProductCommand convert(Product product) {
        if(product == null) return null;

        ProductCommand productCommand = new ProductCommand();

        productCommand.setId(product.getId());
        productCommand.setCode(product.getCode());
        productCommand.setName(product.getName());
        productCommand.setUrlPath(product.getUrlPath());
        productCommand.setDescription(product.getDescription());
        productCommand.setThumbnail(product.getThumbnail());
        productCommand.setImages(product.getImages());
        productCommand.setPrice(product.getPrice());
        productCommand.setAvgRating(product.getAvgRating());
        productCommand.setQuantity(product.getQuantity());
        productCommand.setHotFlag(product.isHotFlag());
        productCommand.setStatus(product.isStatus());
        productCommand.setCategoryId(product.getCategory() !=  null? product.getCategory().getId() : null);
        productCommand.setCreatedBy(product.getCreatedBy());
        productCommand.setCreationDate(product.getCreationDate());
        productCommand.setLastModifiedBy(product.getLastModifiedBy());
        productCommand.setLastModifiedDate(product.getLastModifiedDate());
        return productCommand;
    }
}
