package com.ohgiraffers.section02.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

public class A_EntityManagerCRUDTests {

    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeAll
    public static void initFactory(){
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach
    public void initManager(){
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterAll
    static void closeFactory(){
        entityManagerFactory.close();
    }

    @AfterEach
    void closeManager(){
        entityManager.close();
    }

    @Test
    public void 메뉴코드로_메뉴_조회_테스트(){
        // given
        int menuCode = 2;

        // when
        Menu foundMenu = entityManager.find(Menu.class, menuCode);
        // 코드가 2인애를 가져와라

        // then
        Assertions.assertNotNull(foundMenu);
        Assertions.assertEquals(menuCode, foundMenu.getMenuCode());
        System.out.println("foundMenu : " + foundMenu);
    }

    @Test
    public void 메뉴가격으로_메뉴_조회_테스트하기(){
        // find는 PK로 찾아오기 때문에 menuPrice는 PK가 아니라서 찾아오지 못함
        // given
        int menuPrice = 5000;

        // when
        Menu foundMenu = entityManager.find(Menu.class, menuPrice);

        // then
        Assertions.assertNotNull(foundMenu);
        Assertions.assertEquals(menuPrice, foundMenu.getMenuPrice());
        System.out.println("foundMenu : " + foundMenu);
    }

    @Test
    public void 메뉴코드로_메뉴_조회_테스트2(){
        // given
        int menuCode = 3;

        // when
        Menu foundMenu = entityManager.find(Menu.class, menuCode);

        // then
        Assertions.assertNotNull(foundMenu);
        Assertions.assertEquals(menuCode, foundMenu.getMenuCode());
        System.out.println("foundMenu : " + foundMenu);
    }

    @Test
    public void 새로운_메뉴_추가_테스트(){
        // given
        Menu menu = new Menu();
        menu.setMenuName("jpa테스트 메뉴1");
        menu.setMenuPrice(5000);
        menu.setCategoryCode(4);
        menu.setOrderableStatus("Y");

        // when
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        // begin : 시작할거야
        try{
            entityManager.persist(menu); // 영속성컨텍스트에 넣겠다
            // persist는 영속성컨테이너에 엔터티를 추가하는것
            // 메뉴추가에는 있고 메뉴수정에는 없는 이유는 새로운걸 넣어야하니깐 먼저 영속성컨텍스트를 거치고 db에 추가하는것이니
            // 영속성컨텍스트에 등록해야함
            entityTransaction.commit(); // 디비에 넣겠다
            // commit하지 않으면 영속성컨텍스트에만 남고 디비에는 저장되지 않음
        }catch (Exception e){
            entityTransaction.rollback(); // 에러발생시 트랜잭션 시작한거를 모두 롤백하겠다
            e.printStackTrace();
        }

        Assertions.assertTrue(entityManager.contains(menu));
    }

    @Test
    public void 메뉴_이름_수정_테스트(){
        // given
        Menu menu = entityManager.find(Menu.class, 2);
        System.out.println("menu = " + menu);

        String menuNameToChange = "갈치스무디";

        // when
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            menu.setMenuName(menuNameToChange);
            entityTransaction.commit();
        } catch (Exception e){
            entityTransaction.rollback();
            e.printStackTrace();
        }
        // then
        Assertions.assertEquals(menuNameToChange, entityManager.find(Menu.class, 3).getMenuName());
    }

    @Test
    public void 메뉴_이름_수정_테스트2(){
        // given 조건
        Menu menu = entityManager.find(Menu.class, 80);
        System.out.println("menu = " + menu);

        String menuNameChange = "김치우동";

        // when 실행
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin(); //시작

        try {
            menu.setMenuName(menuNameChange);
            entityTransaction.commit();
        } catch (Exception e){
            entityTransaction.rollback(); // 에러시 롤백
            e.printStackTrace();
        }

        // then 검증
        Assertions.assertEquals(menuNameChange, entityManager.find(Menu.class, 80).getMenuName());
    }

    @Test
    public void 메뉴_삭제하기_테스트(){
        // given
        Menu menuToRemove = entityManager.find(Menu.class, 1000);

        // when
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            entityManager.remove(menuToRemove);
            entityTransaction.commit();
        }catch (Exception e){
            entityTransaction.rollback();
            e.printStackTrace();
        }

        Menu removedMenu = entityManager.find(Menu.class, 1000);
        Assertions.assertNull(removedMenu);
    }

    @Test
    public void 메뉴_삭제_테스트2(){
        // given 조건 PK 999를 찾아야됨
        Menu menuToRemove = entityManager.find(Menu.class, 999);
        // when 실행 menuToRemove를 삭제할것
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            entityManager.remove(menuToRemove);
            entityTransaction.commit();
        }catch (Exception e){
            entityTransaction.rollback();
            e.printStackTrace();
        }
        // then 검증 삭제됐는지
        Menu removedMenu = entityManager.find(Menu.class, 999);
        Assertions.assertNull(removedMenu);
    }
}
