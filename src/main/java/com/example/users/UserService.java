package com.example.users;

import com.example.users.domain.User;
import com.example.users.dto.UserList;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserService {

    public UserService() {
    }

    public String createUsernameString(UserList userList) {
        return userList.getUsers().stream()
                .map(User::getName)
                .collect(Collectors.joining(", ")).concat(";");
    }
}
