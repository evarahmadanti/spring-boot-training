package com.example.demo.dto;

public class UpdateBalanceDto {
    private long ids;
    private long balanceAmount;

    public long getIds() {
        return ids;
    }

    public void setIds(long ids) {
        this.ids = ids;
    }

    public long getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(long balanceAmount) {
        this.balanceAmount = balanceAmount;
    }
}
