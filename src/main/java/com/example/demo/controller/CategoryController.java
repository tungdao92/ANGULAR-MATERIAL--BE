package com.example.demo.controller;

import com.example.demo.dto.response.ResponMessage;
import com.example.demo.model.Category;
import com.example.demo.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/categories")

public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @GetMapping
    public ResponseEntity<?> showList(){
        Iterable<Category> listCategories = categoryService.findAll();
        return new ResponseEntity<>(listCategories, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody Category category){
        categoryService.save(category);
        return new ResponseEntity<>(new ResponMessage("create Success"), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<?>detailCategory(@PathVariable("id") Category category){
        return category == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(category);
    }
}
