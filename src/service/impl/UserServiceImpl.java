package service.impl;

import domain.User;
import enums.UserStatusEnum;
import service.UserService;

import java.util.Properties;

public class UserServiceImpl implements UserService {
    @Override
    public User register(User user, String password) {
        return  null;
        //nullga tekshirib mapga qo'shib qoysa boldi
    }

    @Override
    public User login(String email, String password) {
        //nullga tekshirib mapdan userni olib qaytarvorsa boldi
        return null;
    }

    @Override
    public String delete(Integer userId) {
        return null;//o'chirish
    }

    @Override
    public String changeStatus(Integer userId, UserStatusEnum newStatus) {
        return null;
    }

    @Override
    public String changeEmail(Integer userId, String newEmail) {
        return null;
    }

    public static Integer isOwnerOfEmail(String email) {
        /*Properties properties = new Properties();
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");*/
        return 1111;//hozricha
    }

    @Override
    public void showAllUsers() {
        //show method in here
    }
}
