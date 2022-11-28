package com.shtrudell.model;

import lombok.Data;

@Data
public class User {

    private int id;
    private String login;
    private byte[] passw;

    public User(String name, byte[] password) {
        this.login = name;
        this.passw = password;
    }

}

