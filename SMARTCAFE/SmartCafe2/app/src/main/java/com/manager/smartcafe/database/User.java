package com.manager.smartcafe.database;

public class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private String phoneNo;
    private int wallet;

    public int getWallet() {
        return wallet;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public User(String id, String name, String email, String password, String phoneNo,int wallet) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNo = phoneNo;
        this.wallet = wallet;
    }

    public User() {
    }
}
