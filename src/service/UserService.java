package service;

import domain.User;
import enums.UserStatusEnum;

import java.util.*;

public interface UserService{
    Map<User,Integer> USERS = new HashMap<>();

    User register(User user,String password);
    User login(String email, String password);
    String delete(Integer userId);
    String changeStatus(Integer userId, UserStatusEnum newStatus);
    String changeEmail(Integer userId,String newEmail);
    void showAllUsers();
}
