package service;

import domain.User;
import enums.UserStatusEnum;

import java.util.*;

public interface UserService{
    List<User> USERS = new ArrayList<>();

    User register(User user);
    User login(String username, String password);
    User login(String email);
    String delete(Integer userId);
    String delete(String username,String password);
    String changeUsername(Integer userId, String username);
    String changeStatus(Integer userId, UserStatusEnum newStatus);
    String changeStatus(Integer userId, UserStatusEnum newStatus,Integer facultyId,Integer groupId);
    String changeEmail(Integer userId,String newEmail);
    String changePassword(Integer userId,String password);
    String confirmationByEmail(String email);
    Boolean isValidUsername(String username);
    Boolean isValidEmail(String email);
    void showAllUsers();
}
