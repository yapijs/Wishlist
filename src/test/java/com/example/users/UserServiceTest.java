package com.example.users;

import com.example.users.domain.User;
import com.example.users.dto.UserList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    UserService service;


    @Test
    public void testConvertListToString() {

        List<User> userList = new ArrayList<>();
        User user1 = new User("user", 15709, "johnsmith", "jsmith@example.com");
        User user2 = new User("user", 15710, "peterbrown", "pbrown@example.com");
        userList.add(user1);
        userList.add(user2);
        UserList userListObject = new UserList(userList);

        String result = service.createUserStringFromUsers(userListObject);
        Assertions.assertEquals("johnsmith, peterbrown", result);
    }

    @Test
    public void testConvertListToStringWithBlankUsernames() {

        List<User> userList = new ArrayList<>();
        User user1 = new User("user", 15709, "", "jsmith@example.com");
        User user2 = new User("user", 15710, "peterbrown", "pbrown@example.com");
        User user3 = new User("user", 15711, null, "noname@example.com");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        UserList userListObject = new UserList(userList);

        String result = service.createUserStringFromUsers(userListObject);
        Assertions.assertEquals("peterbrown", result);
    }
}
