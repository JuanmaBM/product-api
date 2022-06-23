package org.jmb.productapi.core;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.jmb.productapi.data.Product;

@ApplicationScoped
public class ProductService {
    
    private final ProductRepository productRepository;

    @Inject
    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> listAll() {
        return productRepository.findAll().stream().collect(Collectors.toList());
    }

    public Product listOne(final String id) {
        return productRepository.findOne(id).orElse(new Product());
    }

    public Product create(final Product product) throws ValidationException {

        if (!isValid(product)) throw new ValidationException("Product is not valid");
        return productRepository.create(product);
    }

    public void update(final String id, final Product product) {
        product.id = id;
        productRepository.update(product);
    }

    public void delete(final String id) {
        productRepository.delete(id);
    }

    private boolean isValid(Product product) {
        return product != null
            && StringUtils.isNotBlank(product.name)
            && StringUtils.isNotBlank(product.description)
            && product.price != null
            && product.price > 0;
    }
}
