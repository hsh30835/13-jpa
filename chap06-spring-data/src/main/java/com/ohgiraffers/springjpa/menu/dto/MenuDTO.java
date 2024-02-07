package com.ohgiraffers.springjpa.menu.dto;

import com.ohgiraffers.springjpa.category.entity.Category;
import jakarta.persistence.*;

public class MenuDTO {

    private String menuName;

    private int menuPrice;

    private int categoryCode;

    public MenuDTO() {
    }

    public MenuDTO(String menuName, int menuPrice, int categoryCode) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.categoryCode = categoryCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int category) {
        this.categoryCode = category;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", category=" + categoryCode +
                '}';
    }
}
