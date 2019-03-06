package ru.trandefil.sc.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends AbstractEntity {

    private String userName;

    private String password;

    public User(String id, String userName) {
        super(id);
        this.userName = userName;
    }

}
