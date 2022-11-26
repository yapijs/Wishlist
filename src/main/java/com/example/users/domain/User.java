package com.example.users.domain;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class User {
    @NotBlank
    private String type;
    @NotNull
    @Min(0)
    private long id;
    @NotBlank
    private String name;
    @NotNull
    @Email
    private String email;

    public User(String type, long id, String name, String email) {
        this.type = type;
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public User() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "type='" + type + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(type, user.type) && Objects.equals(name, user.name) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, id, name, email);
    }
}
