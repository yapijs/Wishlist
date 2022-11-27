package com.example.users;

import com.example.users.dto.UserList;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "Accepts object containing list of users")
    @PostMapping("/add")
    public String getUserList(@Valid @RequestBody UserList userList) {
        return service.createUsernameString(userList);
    }

}
