package com.ohgiraffers.section02.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

public class B_EntityManagerCRUDTests {
    // EntityManagerFactory 생성후 EntityManager 생성
    // EntityManagerFactory에 이름 xml에 name과 맞춰줘야됨
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeAll
    public static void initFactory(){
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }
    @BeforeEach
    public void initManager() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterAll
    public static void closeFactory(){
        entityManagerFactory.close();
    }

    @AfterEach
    public void closeManager(){
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

    // 추가
    @Test
    public void 딸기아이스크림_메뉴추가하기(){
        // given 넣을 조건 생성
        Menu menu = new Menu();
        menu.setMenuName("딸기 아이스크림");
        menu.setMenuPrice(1200);
        menu.setCategoryCode(2);
        menu.setOrderableStatus("Y");

        // when 영속성컨텍스트와 db에 집어넣기
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            entityManager.persist(menu);
            entityTransaction.commit();
        } catch (Exception e){
            entityTransaction.rollback();
            e.printStackTrace();
        }

        // then : 검증 들어갔는지 검증하려면 null이 아닌지 확인
        Assertions.assertTrue(entityManager.contains(menu));
        // boolean타입이라 True 아님 false만 가능
    }

    //수정
    @Test
    public void 메뉴코드43_수정하기(){
        // given
        Menu menu = entityManager.find(Menu.class, 43);
        System.out.println("menu : " + menu);

        String UpdateMenu = "블루베리";
        // when
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            menu.setMenuName(UpdateMenu);
            entityTransaction.commit();
        } catch (Exception e){
            entityTransaction.rollback();
            e.printStackTrace();
        }

        // then 기존에 있떤걸 수정했으니 같은지 비교?
        Assertions.assertEquals(UpdateMenu, entityManager.find(Menu.class, 43).getMenuName());

    }

    //삭제
    @Test
    public void 메뉴코드46_삭제하기(){
        // given
        Menu menu = entityManager.find(Menu.class, 46);

        // when
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            entityManager.remove(menu);
            entityTransaction.commit();
        } catch (Exception e){
            entityTransaction.rollback();
            e.printStackTrace();
        }

        // then 삭제했으니 null인지 검증
        Assertions.assertNull(entityManager.find(Menu.class, 46));
    }
}
