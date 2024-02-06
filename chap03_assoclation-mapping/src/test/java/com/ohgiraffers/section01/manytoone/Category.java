package com.ohgiraffers.section01.manytoone;

import jakarta.persistence.*;

/*
* @JoinColumn은 다대일 연관 관계에서 사용되는 어노테이션이다.
* @JoinColumn에서 사용할 수 있는 속성들은 다음과 같다.
*
* - name : 참조하는 테이블의 컬럼명을 지정한다.
* - referencedColumnName : 참조되는 컬럼명을 지정한다,
* - nullable : 참조하는 테이블의 컬럼에 null 값을 허용할지 여부를 지정한다.
* - unique : 참조하는 테이블의 컬럼에 유일성 제약 조건을 추가할지 여부를 지정한다.
* - insertable : 새로운 엔티티가 저장될 때, 이 참조 컬럼이 sql insert 문에 포함될지 여부를 지정한다.
* - updatable : 엔티티가 업데이트 될 때, 이 참조 컬럼이 SQL update 문에 포함될지 여부를 지정한다.
* - table : 참조하는 테이블의 이름을 지정한다.
* - foreignkey : 참조하는 테이블에 생성될 외래 키에 대한 추가 정보를 지정한다.
*
* @ManyToOne은 다대일 연관관계에서 사용되는 어노테이션이다
* @ManyToOne에서 사용할 수 있는 속성들은 다음과 같다.
*
* - casecade : 연관된 엔티티에 대한영속성 전이를 설정한다.
* - fetch : 연관된 엔티티를 로딩하는 전략을 설정한다.
* - optional : 연관된 엔티티가 필수인지 서낵적인지 설정한다.
* */
@Entity(name = "category_section01")
@Table(name = "tbl_category")
public class Category {

    @Id
    @Column(name = "category_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryCode;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "ref_category_code")
    private Integer refCategoryCode;

    public Category() {
    }

    public Category(int categoryCode, String categoryName, Integer refCategoryCode) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.refCategoryCode = refCategoryCode;
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

    @Override
    public String toString() {
        return "Category{" +
                "categoryCode=" + categoryCode +
                ", categoryName='" + categoryName + '\'' +
                ", refCategoryCode=" + refCategoryCode +
                '}';
    }
}
