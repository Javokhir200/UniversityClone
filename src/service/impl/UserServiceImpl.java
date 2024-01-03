package service.impl;

import domain.User;
import enums.UserStatusEnum;
import service.UserService;

public class UserServiceImpl implements UserService {
    {
        User user = new User("Javokhir", "J001", "javokhir_dev01", UserStatusEnum.REKTOR);
        USERS.add(user);
    }

    @Override
    public User register(User user) {
        if (isExist(user.getUsername())) {
            return null;
        }
        USERS.add(user);
        return user;
    }

    @Override
    public String delete(Integer userId) {
        for (User user : USERS) {
            if (user.getUserId().equals(userId)) {
                USERS.remove(user);
                return "U" + user.getUserId() + " is deleted !!!";
            }
        }
        return "U" + userId + " is not found !!!";
    }

    @Override
    public String changeStatus(Integer userId, UserStatusEnum newStatus) {
        for (User user : USERS) {
            if (user.getUserId().equals(userId)) {
                user.setStatus(newStatus);
                return "U" + userId + " status rised up to " + newStatus + " !!!";
            }
        }
        return "U" + userId + " is not found !!!";
    }

    @Override
    public User login(String password, String username) {
        for (User user : USERS) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public String changeUsername(Integer userId, String newUsername) {
        for (User user : USERS) {
            if (user.getUserId().equals(userId)) {
                user.setUsername(newUsername);
                return "U" + userId + "'s username changed successfully !!!";
            }
        }
        return "U" + userId + " is not found !!!";
    }

    @Override
    public String changePassword(Integer userId, String newPassword) {
        for (User user : USERS) {
            if (user.getUserId().equals(userId)) {
                user.setPassword(newPassword);
                return "U" + userId + "'s password changed successfully !!!";
            }
        }
        return "U" + userId + " is not found !!!";
    }

    @Override
    public void showAllUsers() {
        for (User us: USERS) {
            System.out.println(us);
        }
    }

    private boolean isExist(String username) {
        for (User user : USERS) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
}
