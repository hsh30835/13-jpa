package com.ohgiraffers.section04.enumtype;

import jakarta.persistence.*;

import java.util.Date;


@Entity(name = "member_section04") //Entity와 Table의 이름을 지정하지 않으면 클래스 명을 그대로 따라감
@Table(name = "tbl_member_section04")
public class Member {
    @Id
    @Column(name = "member_no")
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
//    @Enumerated(EnumType.ORDINAL)
    @Enumerated(EnumType.STRING)
    private RoleType memberRole;

    @Column(name = "status")
    private String status;

    public Member() {
    }

    public Member(int memberNo, String memberId, String memberPad, String nickName, String phone, String email, String address, Date enrollDate, RoleType memberRole, String status) {
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

    public RoleType getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(RoleType memberRole) {
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
                ", memberRole=" + memberRole +
                ", status='" + status + '\'' +
                '}';
    }
}
