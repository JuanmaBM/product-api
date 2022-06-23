package org.jmb.productapi.core;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;

import org.apache.commons.lang.StringUtils;
import org.jmb.productapi.data.Product;


@ApplicationScoped
public class ProductRepository {
    
    private static Set<Product> products;

    public ProductRepository() {
        products = new HashSet<>();
    }

    public Product create(final Product product) {
        product.id = generateProductId();
        products.add(product);
        return product;
    }

    public void update(final Product product) {
        for(Product prod : products) {
            if (prod.id.equals(product.id)) {
                updateProduct(prod, product);  
            }
        }
    }

    public void delete(final String id) {
        products.removeIf(prod -> id.equals(prod.id));
    }

    public Set<Product> findAll() {
        return products;
    }

    public Optional<Product> findOne(final String id) {
        return products.stream().filter(prod -> id.equals(prod.id)).findFirst();
    }

    private void updateProduct(final Product old, final Product updated) {
        old.name = updated.name;
        old.description = updated.description;
        old.price = updated.price;
    }

    private String generateProductId() {
        var productsSize = String.valueOf(products.size());
        return StringUtils.leftPad(productsSize, 4, "0");
    }
}
