package ru.trandefil.sc.model;

import lombok.Getter;
import lombok.Setter;

import java.util.EnumSet;
import java.util.Set;

@Getter
@Setter
public class User extends AbstractEntity {

    private String userName;

    private String password;

    private Set<Role> roles;

    public User(String id, String userName, String password, Role role, Role... roles) {
        super(id);
        this.userName = userName;
        this.password = password;
        this.roles = EnumSet.of(role, roles);
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
