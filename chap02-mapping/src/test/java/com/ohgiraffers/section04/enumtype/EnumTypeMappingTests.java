package com.ohgiraffers.section04.enumtype;

import com.ohgiraffers.section04.enumtype.Member;
import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import java.util.Date;

public class EnumTypeMappingTests {
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeAll
    public static void initFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach
    public void initManager() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterAll
    public static void closeFactory() {
        entityManagerFactory.close();
    }

    @AfterEach
    public void closeManager() {
        entityManager.close();
    }

    @Test
    void enum타입_메핑_테스트(){
        // given
        Member member = new Member();
        member.setMemberNo(1);
        member.setMemberId("user01");
        member.setMemberPad("pass01");
        member.setAddress("구로구 신도림동");
        member.setNickName("gorilla");
        member.setPhone("010-1234-5678");
        member.setStatus("Y");
        member.setEnrollDate(new Date());

        member.setMemberRole(RoleType.ADMIN);

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(member);
        transaction.commit();

        Member foundMember = entityManager.find(Member.class, member.getMemberNo());
        Assertions.assertEquals(member.getMemberNo(), foundMember.getMemberNo());
    }


}
