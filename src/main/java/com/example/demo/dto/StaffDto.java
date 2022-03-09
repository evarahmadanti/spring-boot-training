package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StaffDto {
    private String staffName;
    private String position;
    private long balance;

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}
