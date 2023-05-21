package com.robvega.productscategories.service;

import com.robvega.productscategories.model.Category;
import com.robvega.productscategories.model.Product;
import com.robvega.productscategories.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void create(Product product) {
        productRepository.save(product);
    }

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) return optionalProduct.get();
        return null;
    }

    public List<Product> findByCategoriesNotContains(Category category) {
        return productRepository.findByCategoriesNotContains(category);
    }

    public void addCategory(Long id, Category category) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.addCategory(category);
            productRepository.save(product);
        }
    }
}
