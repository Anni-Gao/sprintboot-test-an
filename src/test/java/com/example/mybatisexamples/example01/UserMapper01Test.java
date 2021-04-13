package com.example.mybatisexamples.example01;

import com.example.mybatisexamples.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(value = false)
public class UserMapper01Test {

    @Autowired
    private UserMapper01 userMapper01;

    @Test
    public void test_addUser() {
        User user = new User();
            user.setName("A");
            user.setCompany("nefu");
            userMapper01.insert(user);
    }

    public void test_deleteUser() {
        List<User> users = userMapper01.listByCompany("nefu");
        for (User user : users) {
            log.debug(user.getName());
        }
    }


}
