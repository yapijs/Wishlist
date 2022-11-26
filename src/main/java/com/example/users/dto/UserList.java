package com.example.users.dto;

import com.example.users.domain.User;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

public class UserList {
    @Valid
    @NotNull
    List<User> users;

    public UserList(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public UserList() {
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserList userList = (UserList) o;
        return Objects.equals(this.users, userList.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }

    @Override
    public String toString() {
        return "Users{" +
                "userList=" + users +
                '}';
    }
}
