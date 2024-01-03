package service;

import domain.User;
import enums.UserStatusEnum;

import java.util.LinkedHashSet;
import java.util.Set;

public interface UserService{
    Set<User> USERS = new LinkedHashSet<>();

    User register(User user);
    User login(String password, String username);
    String delete(Integer userId);
    String changeStatus(Integer userId, UserStatusEnum newStatus);
    String changeUsername(Integer userId,String newUsername);
    String changePassword(Integer userId,String newPassword);
    void showAllUsers();
}
