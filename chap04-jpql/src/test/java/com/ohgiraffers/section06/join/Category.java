package com.ohgiraffers.section06.join;

import jakarta.persistence.*;

import java.util.List;

@Entity(name="category_section06")
@Table(name="tbl_category")
public class Category {

    @Id
    @Column(name="category_code")
    private int categoryCode;

    @Column(name="category_name")
    private String categoryName;

    @Column(name="ref_category_code")
    private Integer refCategoryCode;

    @OneToMany(mappedBy = "category")
    private List<Menu> menusList;

    public Category() {}

    public Category(int categoryCode, String categoryName, Integer refCategoryCode, List<Menu> menusList) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.refCategoryCode = refCategoryCode;
        this.menusList = menusList;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getRefCategoryCode() {
        return refCategoryCode;
    }

    public void setRefCategoryCode(Integer refCategoryCode) {
        this.refCategoryCode = refCategoryCode;
    }

    public List<Menu> getMenusList() {
        return menusList;
    }

    public void setMenusList(List<Menu> menusList) {
        this.menusList = menusList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryCode=" + categoryCode +
                ", categoryName='" + categoryName + '\'' +
                ", refCategoryCode=" + refCategoryCode +
                ", menusList=" + menusList +
                '}';
    }
}