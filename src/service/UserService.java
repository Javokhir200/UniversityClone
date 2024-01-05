package service;

import domain.User;
import enums.UserStatusEnum;

import java.util.*;

public interface UserService{
    List<User> USERS = new ArrayList<>();

    User register(User user);
    User login(String username, String password);
    String delete(Integer userId);
    String delete(String username,String password);
    String changeStatus(Integer userId, UserStatusEnum newStatus);
    String changeEmail(Integer userId,String newEmail);
    void showAllUsers();
}
