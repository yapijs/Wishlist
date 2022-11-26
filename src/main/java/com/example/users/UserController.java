package com.example.users;

import com.example.users.dto.UserList;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public String getUserList(@Valid @RequestBody UserList userList) {
        return service.createUserStringFromUsers(userList);
    }

}
