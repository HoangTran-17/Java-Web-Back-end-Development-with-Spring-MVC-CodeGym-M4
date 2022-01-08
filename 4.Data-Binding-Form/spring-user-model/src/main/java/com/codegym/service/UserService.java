package com.codegym.service;

import com.codegym.model.Login;
import com.codegym.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
private static List<User> userList;

    static {
        userList = new ArrayList<>();
        
        User user1 = new User();
        user1.setAccount("Hoang Tran");
        user1.setAge(25);
        user1.setEmail("hoangtran@gmail.com");
        user1.setPassword("12345");
        user1.setName("Trần Nhật Hoàng");
        userList.add(user1);
        
        User user2 = new User();
        user2.setAccount( "Tien Tran");
        user2.setAge(18);
        user2.setEmail("tientran@gmail.com");
        user2.setPassword("2345");
        user2.setName("Trần Quang Tiến");
        userList.add(user2);
        
        User user3 = new User("Huu Tran","1235","Trần Ngọc Hữu","huutran@gmail.com",26);
        userList.add(user3);
    }

    public static User checkLogin(Login login) {
        for (User user: userList) {
            if (user.getAccount().equals(login.getAccount()) && user.getPassword().equals(login.getPassword())) {
                return user;
            }
        }
        return null;
    }
}
