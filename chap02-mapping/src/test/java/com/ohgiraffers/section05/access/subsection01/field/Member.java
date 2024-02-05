package com.ohgiraffers.section05.access.subsection01.field;

import com.ohgiraffers.section04.enumtype.RoleType;
import jakarta.persistence.*;

import java.util.Date;

/*
* 필드 적븐이 기본 값이므로 해당 설정은 제거해도 동일하게 동작한다.
* 또한 필드 레벨과 프로퍼티 레벨에 모두 선언하면 프로퍼티 레벨을 우선으로 사용한다.
* */

@Entity(name = "member_section05_subsection01") //Entity와 Table의 이름을 지정하지 않으면 클래스 명을 그대로 따라감
@Table(name = "tbl_member_section05_subsection01")
@Access(AccessType.FIELD)
public class Member {
    @Id
    @Column(name = "member_no")
    @Access(AccessType.FIELD)
    private int memberNo;

    @Column(name = "member_id")
    @Access(AccessType.FIELD)
    private String memberId;

    @Column(name = "member_pad")
    @Access(AccessType.FIELD)
    private String memberPad;

    @Column(name = "nickName")
    @Access(AccessType.FIELD)
    private String nickName;

    public Member() {
    }

    public Member(int memberNo, String memberId, String memberPad, String nickName) {
        this.memberNo = memberNo;
        this.memberId = memberId;
        this.memberPad = memberPad;
        this.nickName = nickName;
    }

    public int getMemberNo() {
        System.out.println("getMemberNo를 이용한 access확인");
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberId() {
        System.out.println("getMemberId를 이용한 access확인");
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPad() {
        return memberPad;
    }

    public void setMemberPad(String memberPad) {
        this.memberPad = memberPad;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberNo=" + memberNo +
                ", memberId='" + memberId + '\'' +
                ", memberPad='" + memberPad + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
