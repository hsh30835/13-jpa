package com.ohgiraffers.springjpa.order.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ohgiraffers.springjpa.menu.entity.Menu;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_order")
public class MenuOrder {

    @Id
    @Column(name = "order_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderCode;

    @Column(name = "menu_code", nullable = false)
    private Integer menu;

    @Column(name = "order_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @JsonIgnore // 직렬화 시 해당 필드를 포함하고 싶지 않을 때 선언하는 어노테이션 해당 어노테이션을 사용하면 Response 데이터에서 해당필드가 제외됨
    // 직렬화 : 자바 언어에서 사용되는 Object 또는 Data를 다른 컴퓨터의 자바 시스템에서도 사용할 수 있도록 만든
    // 바이트 스트림 형태로 연속적인 데이터로 변환하는 포맷 변환 기술을 일컫는다
    // 바이트 스트림 : 1byte를 입출력 할 수 있는 스트림
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "menuOrder")
    private List<Payments> payments = new ArrayList<>();

    public MenuOrder() {
    }

    public MenuOrder(int orderCode, Integer menu, Date orderDate, List<Payments> payments) {
        this.orderCode = orderCode;
        this.menu = menu;
        this.orderDate = orderDate;
        this.payments = payments;
    }

    public int getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(int orderCode) {
        this.orderCode = orderCode;
    }

    public Integer getMenu() {
        return menu;
    }

    public void setMenu(Integer menu) {
        this.menu = menu;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<Payments> getPayments() {
        return payments;
    }

    public void setPayments(List<Payments> payments) {
        this.payments = payments;
    }

    @Override
    public String toString() {
        return "MenuOrder{" +
                "orderCode=" + orderCode +
                ", menu=" + menu +
                ", orderDate=" + orderDate +
                ", payments=" + payments +
                '}';
    }
}
