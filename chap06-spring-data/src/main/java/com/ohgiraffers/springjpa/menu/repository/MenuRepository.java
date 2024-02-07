package com.ohgiraffers.springjpa.menu.repository;

import com.ohgiraffers.springjpa.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
    Menu findByMenuName(String name); // 얘를 기준으로 메소드네임을 만들어줌

    Menu findByMenuCode(Integer menuCode);
}
