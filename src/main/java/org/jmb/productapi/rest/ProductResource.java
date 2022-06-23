package org.jmb.productapi.rest;

import java.util.List;

import javax.inject.Inject;

import org.jmb.productapi.api.ProductApi;
import org.jmb.productapi.core.ProductService;
import org.jmb.productapi.core.ValidationException;
import org.jmb.productapi.data.Product;

public class ProductResource implements ProductApi {

    private final ProductService productService;

    @Inject
    public ProductResource(final ProductService productService) {
        this.productService = productService;
    }

    @Override
    public List<Product> listAll() {
        return productService.listAll();
    }

    @Override
    public Product create(Product product) throws ValidationException {
        return productService.create(product);
    }

    @Override
    public Product listOne(String id) {
        return productService.listOne(id);
    }

    @Override
    public void update(String id, Product product) {
        productService.update(id, product);
    }

    @Override
    public void delete(String id) {
        productService.delete(id);
    }
    

}
