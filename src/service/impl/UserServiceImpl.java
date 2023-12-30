package service.impl;

import domain.User;
import enums.UserStatusEnum;
import service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public User add(User user) {
        if(isExist(user.getUsername())){
            return null;
        }
        USERS.add(user);
        return user;
    }

    @Override
    public String delete(Integer userId) {
        for (User user:USERS){
            if (user.getUserId().equals(userId)){
                USERS.remove(user);
                return  "U" + user.getUserId() + " is deleted !!!";
            }
        }
        return "U" + userId + " is not found !!!";
    }

    @Override
    public String changeStatus(Integer userId, UserStatusEnum newStatus) {
        for (User user : USERS){
            if(user.getUserId().equals(userId)){
                user.setStatus(newStatus);
                return "U" + userId + " status rised up to " + newStatus + " !!!";
            }
        }
        return "U" + userId + " is not found !!!";
    }

    @Override
    public User login(String username, String password) {
        for (User user:USERS){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean isExist(String username) {
        for(User user:USERS){
            if(user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
}
