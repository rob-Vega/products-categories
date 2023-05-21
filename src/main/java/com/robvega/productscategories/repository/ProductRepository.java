package com.robvega.productscategories.repository;

import com.robvega.productscategories.model.Category;
import com.robvega.productscategories.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByCategoriesNotContains(Category category);
}
