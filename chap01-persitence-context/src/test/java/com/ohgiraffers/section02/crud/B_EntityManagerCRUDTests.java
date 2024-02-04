package com.ohgiraffers.section02.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

public class B_EntityManagerCRUDTests {
    // EntityManagerFactory 생성후 EntityManager 생성
    // EntityManagerFactory에 이름 xml에 name과 맞춰줘야됨
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeAll
    private static void initFactory(){
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }
    @BeforeEach
    private void initManager() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterAll
    private static void closeFactory(){
        entityManagerFactory.close();
    }

    @AfterEach
    private void closeManager(){
        entityManager.close();
    }

    // 조회
    @Test
    public void 메뉴코드4_조회하기(){
        // given, when
        Menu foundMenu = entityManager.find(Menu.class, 4);
        // then 검증
        Assertions.assertNotNull(foundMenu);
        System.out.println("foundMenu : " + foundMenu);
    }
}
