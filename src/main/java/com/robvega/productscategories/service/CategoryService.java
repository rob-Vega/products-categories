package com.robvega.productscategories.service;

import com.robvega.productscategories.model.Category;
import com.robvega.productscategories.model.Product;
import com.robvega.productscategories.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void create(Category category) {
        categoryRepository.save(category);
    }

    public List<Category> findByProductsNotContains(Product product) {
        return categoryRepository.findByProductsNotContains(product);
    }

    public void addProduct(Long id, Product product) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            category.addProduct(product);
            categoryRepository.save(category);
        }
    }

    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id)  {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) return optionalCategory.get();
        return null;
    }
}
