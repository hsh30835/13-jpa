package com.ohgiraffers.section03.primarykey.subsection02.table;

import jakarta.persistence.*;

import java.util.Date;

/*
* 컬럼 매핑 시 @Column 어노테이션에 사용 가능한 속성들
* 1. name : 매핑할 테이블의 컬럼 이름
* 2. insertable : 엔터티 저장 시 필드 저장 여부 (default: true)
* 3. updatable : 엔터티 수정 시 필드 수정 여부 (default : true)
* 4. table : 엔터티와 매핑 될 테이블 이름. 하나의 엔터티를 두 개 이상의 테이블에 매핑할 때 사용(@SecondaryTable 사용)
* 5. nullable : null 값 허용 여부 설정 not null 제약조건에 해당함(true 기본값)
* 6. unique : 컬럼에 유일성 제약조건
* (두 개 이상 컬럼에 unique 제약조건을 설정하기 위해서 클래스 레벨에서 @Table의 uniqueConstrains 속성에 설정)
* 7. columnDefinition : 직접 컬럼의 ddl을 지정
* 8. length : 문자열 길이, String type에서만 사용(default : 255)
* */
@Entity(name = "member_section03_subsection02") //Entity와 Table의 이름을 지정하지 않으면 클래스 명을 그대로 따라감
@Table(name = "tbl_member_section03_subsection02")
@TableGenerator(
        name = "member_seq_table_generator",
        table = "tbl_my_sequences",
        pkColumnValue = "my_seq_member_no"
        // 컬럼의 이름을 무엇으로 할것이냐
)
public class Member {
    @Id
    @Column(name = "member_no")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "member_seq_table_generator")
    private int memberNo;

    @Column(name = "member_id")
    private String memberId;

    @Column(name = "member_pad")
    private String memberPad;

    @Column(name = "nickName")
    private String nickName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "emial")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "enroll_date")
    private Date enrollDate;

    @Column(name = "member_role")
    private String memberRole;

    @Column(name = "status")
    private String status;

    public Member() {
    }

    public Member(int memberNo, String memberId, String memberPad, String nickName, String phone, String email, String address, Date enrollDate, String memberRole, String status) {
        this.memberNo = memberNo;
        this.memberId = memberId;
        this.memberPad = memberPad;
        this.nickName = nickName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.enrollDate = enrollDate;
        this.memberRole = memberRole;
        this.status = status;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberId() {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    public String getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(String memberRole) {
        this.memberRole = memberRole;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberNo=" + memberNo +
                ", memberId='" + memberId + '\'' +
                ", memberPad='" + memberPad + '\'' +
                ", nickName='" + nickName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", enrollDate=" + enrollDate +
                ", memberRole='" + memberRole + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
