package service.impl;

import domain.User;
import enums.UserStatusEnum;
import service.UserService;

import java.util.Map;
import java.util.Properties;

public class UserServiceImpl implements UserService {
    @Override
    public User register(User user) {
        if(user != null) {
            USERS.add(user);
            return  user;
        }
        return null;
        //nullga tekshirib mapga qo'shib qoysa boldi
    }

    @Override
    public User login(String username, String password) {
        //nullga tekshirib mapdan userni olib qaytarvorsa boldi

        return null;
    }

    @Override
    public String delete(Integer userId) {
        USERS.remove(userId);
        return userId + " has successfully deleted";
     //o'chirish
    }


    @Override
    public String changeStatus(Integer userId, UserStatusEnum newStatus) {
        for (Map.Entry<User, Integer> userIntegerEntry : USERS.entrySet()) {
            if(userId.equals(userIntegerEntry.getValue())) {
                userIntegerEntry.getKey().setStatus(newStatus);
            }
        }

        return "Successfully changed";
    }

    @Override
    public String changeEmail(Integer userId, String newEmail) {

        return null;
    }

    public static String isOwnerOfEmail(String email) {
        return null;
    }

    @Override
    public void showAllUsers() {
        for (Map.Entry<User, Integer> userIntegerEntry : USERS.entrySet()) {
            System.out.println(userIntegerEntry.toString());
        }
        //show method in here
    }
}
