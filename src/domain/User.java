package domain;

import enums.UserStatusEnum;

import java.util.List;

public class User {
    static int sequence = 0;
    {
        sequence++;
    }
    private int userId = sequence;
    private String fullName;
    private String email;
    private String username;
    private String localPassword;
    private int groupId;
    private int facultyId;

    public User(String fullName, String email, String username, String localPassword, UserStatusEnum status) {
        this.fullName = fullName;
        this.email = email;
        this.username = username;
        this.localPassword = localPassword;
        this.status = status;
    }
    public User(String fullName, String email, String username,Integer groupId,Integer facultyId, String localPassword, UserStatusEnum status) {
        this.fullName = fullName;
        this.email = email;
        this.username = username;
        this.localPassword = localPassword;
        this.status = status;
        this.groupId = groupId;
        this.facultyId = facultyId;
    }

    private UserStatusEnum status;



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

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public UserStatusEnum getStatus() {
        return status;
    }

    public void setStatus(UserStatusEnum status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocalPassword() {
        return localPassword;
    }

    public void setLocalPassword(String localPassword) {
        this.localPassword = localPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        if (status.equals(UserStatusEnum.STUDENT)){
            return "User{" +
                    "userId=" + userId +
                    ", fullName='" + fullName + '\'' +
                    ", email='" + email + '\'' +
                    ", username='" + username + '\'' +
                    ", password='" + localPassword + '\'' +
                    ", groupId=" + groupId +
                    ", facultyId=" + facultyId +
                    ", status=" + status +
                    '}';
        }else{
            return "User{" +
                    "userId=" + userId +
                    ", fullName='" + fullName + '\'' +
                    ", email='" + email + '\'' +
                    ", username='" + username + '\'' +
                    ", password='" + localPassword + '\'' +
                    ", status=" + status +
                    '}';
        }
    }
}
