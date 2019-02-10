package com.example.android.epilogue;

import java.util.UUID;

public class User {
    String uId;
    String dob;
    int sHistory;
    String sHistoryType;
    String name;

    public User(String dob, int sHistory, String sHistoryType, String name) {
        uId = UUID.randomUUID().toString();
        this.dob = dob;
        this.sHistory = sHistory;
        this.sHistoryType = sHistoryType;
        this.name = name;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getsHistory() {
        return sHistory;
    }

    public void setsHistory(int sHistory) {
        this.sHistory = sHistory;
    }

    public String getsHistoryType() {
        return sHistoryType;
    }

    public void setsHistoryType(String sHistoryType) {
        this.sHistoryType = sHistoryType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
