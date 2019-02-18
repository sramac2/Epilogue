package com.example.android.epilogue;

import java.util.Date;
import java.util.UUID;

public class User {
    String uId;
    String dob;
    int sHistory;
    String sHistoryType;
    String name;
    int everydayUse;
    long lastUsed;
    int weeklyUsed;
    int numberExceeded;

    public User(String dob, int sHistory, String sHistoryType, String name) {
        uId = UUID.randomUUID().toString();
        this.dob = dob;
        this.sHistory = sHistory;
        this.sHistoryType = sHistoryType;
        this.name = name;
    }

    public User(String uId, String dob, int sHistory, String sHistoryType, String name, int everydayUse, long lastUsed, int weeklyUsed, int numberExceeded) {
        this.uId = uId;
        this.dob = dob;
        this.sHistory = sHistory;
        this.sHistoryType = sHistoryType;
        this.name = name;
        this.everydayUse = everydayUse;
        this.lastUsed = lastUsed;
        this.weeklyUsed = weeklyUsed;
        this.numberExceeded = numberExceeded;
    }




    public int getWeeklyUsed() {
        return weeklyUsed;
    }

    public void setWeeklyUsed(int weeklyUsed) {
        this.weeklyUsed = weeklyUsed;
    }

    public int getNumberExceeded() {
        return numberExceeded;
    }

    public void setNumberExceeded(int numberExceeded) {
        this.numberExceeded = numberExceeded;
    }

    public int getEverydayUse() {
        return everydayUse;
    }

    public void setEverydayUse(int everydayUse) {
        this.everydayUse = everydayUse;
    }

    public long getLastUsed() {
        return lastUsed;
    }

    public void setLastUsed(String lastUsed) {
        this.lastUsed = new Date().getTime();
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
