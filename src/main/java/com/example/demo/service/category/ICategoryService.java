package com.example.demo.service.category;

import com.example.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    Boolean existsByName(String name);
    List<Category> findAll();
    Page<Category> findAll(Pageable pageable);
    Category save(Category category);
    Category findById(Long id);

}
