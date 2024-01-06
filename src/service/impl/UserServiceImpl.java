package service.impl;

import domain.User;
import enums.UserStatusEnum;
import service.UserService;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.Random;

public class UserServiceImpl implements UserService {
    static{
        USERS.add(new User("A","A","a",1,1,"a",UserStatusEnum.STUDENT));
        USERS.add(new User("B","B","b",1,1,"b",UserStatusEnum.STUDENT));
        USERS.add(new User("C","C","c",1,1,"c",UserStatusEnum.STUDENT));
        USERS.add(new User("D","D","d","d",UserStatusEnum.GUEST));
        USERS.add(new User("R","R","r","r",UserStatusEnum.REKTOR));
    }
    @Override
    public User register(User user) {
        if(user != null) {
            USERS.add(user);
            return  user;
        }
        return null;
    }

    @Override
    public User login(String username, String password) {
        for (User user:USERS){
            if(user.getUsername().equals(username) && user.getLocalPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    @Override
    public User login(String email) {
        for (User user: USERS){
            if (user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }

    @Override
    public String delete(Integer userId) {
        for (User user:USERS){
            if (user.getUserId().equals(userId)){
                USERS.remove(user);
                return "U[" + userId + "] removed successfully";
            }
        }
        return "U[" + userId +  "] is not exist !!!";
    }

    @Override
    public String delete(String username, String password) {//todo done
        for (User user:USERS){
            if (user.getUsername().equals(username)){
                if(user.getLocalPassword().equals(password)){
                    USERS.remove(user);
                    return "Your account deleted successfully !!!";
                }else{
                    return "Incorrect password !!!";
                }
            }
        }
        return  "Incorrect username !!!";
    }//todo done !!!

    @Override
    public String changeStatus(Integer userId, UserStatusEnum newStatus) {//todo done
        for (User user:USERS){
            if(user.getUserId().equals(userId)){
                if(Objects.isNull(newStatus)){
                    return "This status is not exist !!!";
                }else{
                    if(!user.getStatus().equals(newStatus)){
                        user.setStatus(newStatus);
                        return  "U[" + userId +"]'s status rised to " + newStatus;
                    }else{
                        return  "U[" + userId +"]'s status same as " + newStatus;
                    }
                }
            }
        }
        return "U[" + userId + "] is not exist !!!";
    }//todo done !!!

    @Override
    public String changeStatus(Integer userId, UserStatusEnum newStatus, Integer facultyId, Integer groupId) {
        for (User user:USERS){
            if(user.getUserId().equals(userId)){
                if(Objects.isNull(newStatus)){
                    return "This status is not exist !!!";
                }else{
                    if(!user.getStatus().equals(newStatus)){
                        user.setStatus(newStatus);
                        user.setGroupId(groupId);
                        user.setFacultyId(facultyId);
                        return  "U[" + userId +"]'s status rised to " + newStatus;
                    }else{
                        return  "U[" + userId +"]'s status same as " + newStatus;
                    }
                }
            }
        }
        return "U[" + userId + "] is not exist !!!";
    }

    @Override
    public String changeUsername(Integer userId, String username) {
        for (User user:USERS){
            if(user.getUserId().equals(userId)){
                if (isValidUsername(username)){
                    user.setUsername(username);
                    return "Your username changed successfully !!!";
                }else{
                    System.out.println("This username already exist !!!");
                }
            }
        }
        return "U[" + userId + "] is not exist !!!";
    }

    @Override
    public String changeEmail(Integer userId, String newEmail) {
        for (User user:USERS){
            if (user.getUserId().equals(userId)){
                user.setEmail(newEmail);
                return "Your email changed successfully !!!";
            }
        }
        return "Bo'lishi mumkin emas !!!";
    }

    @Override
    public String changePassword(Integer userId, String newPassword) {
        for (User user:USERS){
            if (user.getUserId().equals(userId)){
                user.setLocalPassword(newPassword);
                return "Your password changed successfully !!!";
            }
        }
        return "User is not exist in this id !!!";
    }

    @Override
    public Boolean isValidUsername(String username) {
        for (User user: USERS){
            if (user.getUsername().equals(username)){
                return false;
            }
        }
        return true;
    }

    @Override
    public Boolean isValidEmail(String email) {
        for (User user: USERS){
            if (user.getEmail().equals(email)){
                return false;
            }
        }
        return true;
    }

    @Override
    public String confirmationByEmail(String email) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465"); // Use the appropriate port for TLS
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        String username = "javokhirganiboyev2004@gmail.com";
        String password = "rnyxicwmzqrvboqx";
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        });
        String code = null;
        try{
        MimeMessage  sms = new MimeMessage(session);
        code = "" + (int)(Math.random()*900000+100000);
        sms.setSubject("Confirmation !!!");
        sms.setContent(String.format("<h1 >Your authentification code: %s</h1>",code),"text/html");
        sms.setFrom(new InternetAddress(username));
        sms.setRecipient(Message.RecipientType.TO,new InternetAddress("javokhir.nw.nw@gmail.com"));
        Transport.send(sms);
        System.out.println("success !!!");}
        catch (Exception e){
            System.out.println("Error in somewhere !!!");
        }
        return code;
    }

    @Override
    public void showAllUsers() {
        System.out.println("=============USERS================");
        for (User user:USERS){
            System.out.println(user.toString());
        }
        System.out.println("==================================");
    }
}
