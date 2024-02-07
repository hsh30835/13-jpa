package com.ohgiraffers.springjpa.category.repository;

import com.ohgiraffers.springjpa.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category findByCategoryCode(int code);
    Category findByCategoryName(String name);
}
