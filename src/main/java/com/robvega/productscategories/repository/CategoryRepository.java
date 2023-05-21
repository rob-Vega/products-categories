package com.robvega.productscategories.repository;

import com.robvega.productscategories.model.Category;
import com.robvega.productscategories.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findByProductsNotContains(Product product);
}
