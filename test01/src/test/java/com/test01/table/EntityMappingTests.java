package com.test01.table;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.util.Date;

public class EntityMappingTests {
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
    public static void closeFactory(){
        entityManagerFactory.close();
    }

    @AfterEach
    public void closeManager(){
        entityManager.close();
    }

    @Test
    void 테스트_테이블_만들기(){
        TestTable testTable = new TestTable();

        testTable.setTestNo(1);
        testTable.setTestName("테스트이름1");
        testTable.setTestDate(new Date());

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(testTable);
        entityTransaction.commit();

        TestTable foundTest = entityManager.find(TestTable.class, testTable.getTestNo());
        Assertions.assertEquals(testTable.getTestNo(), foundTest.getTestNo());
    }
}
