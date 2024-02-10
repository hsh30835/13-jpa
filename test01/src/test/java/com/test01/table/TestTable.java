package com.test01.table;

import jakarta.persistence.*;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Date;

@Entity(name = "test")
@Table(name = "test_table")
public class TestTable {
    @Id
    @Column(name = "test_no")
    private int testNo;

    @Column(name = "test_name")
    private String testName;

    @Column(name = "test_date")
    @Temporal(TemporalType.TIME)
    private Date testDate;

    public TestTable() {
    }

    public TestTable(int testNo, String testName, Date testDate) {
        this.testNo = testNo;
        this.testName = testName;
        this.testDate = testDate;
    }

    public int getTestNo() {
        return testNo;
    }

    public void setTestNo(int testNo) {
        this.testNo = testNo;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Date testDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    @Override
    public String toString() {
        return "TestTable{" +
                "testNo=" + testNo +
                ", testName='" + testName + '\'' +
                ", testDate='" + testDate + '\'' +
                '}';
    }
}
