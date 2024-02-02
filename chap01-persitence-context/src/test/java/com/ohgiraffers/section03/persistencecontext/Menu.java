package com.ohgiraffers.section03.persistencecontext;

import jakarta.persistence.*;

    @Entity(name = "section03_menu") // 엔티티 객체로 만들기 위한 어노테이션. 다른 패키지에 동일 이름의 클래스가 존재하면 name 지정필요
// 이름을 지정하지 않으면 기본으로 클래스로 따라감
    @Table(name = "tbl_menu") // 실제 데이터베이스에 Table 이름으로 지정됨
    public class Menu {
        @Id //Pk를 의미한다 @Id어노테이션을 무조건 가져야됨 영속성 컨텍스트에서 구별하는게 @Id기 때문
        @Column(name = "menu_code") // 실제 테이블 컬럼 이름으로 지정됨
        @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 값을 데이터베이스에서 생성하도록 지정
        // GenerationType.IDENTITY 잘못설정하면 안됨 정확히 특징을 알아야함
        private int menuCode;

        public Menu() {
        }

        public Menu(int menuCode, String menuName, int menuPrice, int categoryCode, String orderableStatus) {
            this.menuCode = menuCode;
            this.menuName = menuName;
            this.menuPrice = menuPrice;
            this.categoryCode = categoryCode;
            this.orderableStatus = orderableStatus;
        }

        @Column(name = "menu_name")
        private String menuName;
        @Column(name = "menu_price")
        private int menuPrice;
        @Column(name = "category_code")
        private int categoryCode;
        @Column(name = "orderable_status")
        private String orderableStatus;

        public int getMenuCode() {
            return menuCode;
        }

        public void setMenuCode(int menuCode) {
            this.menuCode = menuCode;
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

        public void setCategoryCode(int categoryCode) {
            this.categoryCode = categoryCode;
        }

        public String getOrderableStatus() {
            return orderableStatus;
        }

        public void setOrderableStatus(String orderableStatus) {
            this.orderableStatus = orderableStatus;
        }

        @Override
        public String toString() {
            return "Menu{" +
                    "menuCode=" + menuCode +
                    ", menuName='" + menuName + '\'' +
                    ", menuPrice=" + menuPrice +
                    ", categoryCode=" + categoryCode +
                    ", orderableStatus='" + orderableStatus + '\'' +
                    '}';
        }
}
