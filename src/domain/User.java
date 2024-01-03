package domain;

import enums.UserStatusEnum;

import java.util.List;

public class User {
    int sequence = 0;
    {
        sequence++;
    }
    private int userId = sequence;
    private String fullName;
    private String password;
    private String username;
    private int facultyId;
    private int groupId;
    private UserStatusEnum status;

    public User(String fullName, String password, String username, UserStatusEnum status) {
        this.fullName = fullName;
        this.password = password;
        this.username = username;
        this.status = status;
    }//user faqat guest bo'lib qo'shiladi rektor set qiladi teacher or student ekanini

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public UserStatusEnum getStatus() {
        return status;
    }

    public void setStatus(UserStatusEnum status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", fullName='" + fullName + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", facultyId=" + facultyId +
                ", groupId= G" + groupId +
                ", status=" + status +
                '}';
    }
}
