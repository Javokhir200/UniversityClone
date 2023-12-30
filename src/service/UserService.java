package service;

import domain.User;
import enums.UserStatusEnum;

import java.util.LinkedHashSet;
import java.util.Set;

public interface UserService{
    Set<User> USERS = new LinkedHashSet<>();

    User add(User user);
    User login(String username,String password);
    String delete(Integer userId);
    String changeStatus(Integer userId, UserStatusEnum newStatus);
    boolean isExist(String username);
    String changeUsername(Integer userId,String newUsername);
    String changePassword(Integer userId,String newPassword);
}
