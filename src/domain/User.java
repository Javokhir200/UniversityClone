package domain;

import enums.UserStatusEnum;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int UserId;
    private String fullName;
    private int facultyId;
    private int groupId;
    private UserStatusEnum status;
    private int gpa;
    private List<Grade> GRADES = new ArrayList<>();

    public User(int userId, String fullName, int facultyId, int groupId, UserStatusEnum status, int gpa) {
        UserId = userId;
        this.fullName = fullName;
        this.facultyId = facultyId;
        this.groupId = groupId;
        this.status = status;
        this.gpa = gpa;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public int getUserId() {
        return UserId;
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

    public int getGpa() {
        return gpa;
    }

    public void setGpa(int gpa) {
        this.gpa = gpa;
    }

    public List<Grade> getGRADES() {
        return GRADES;
    }

    public void setGRADES(Grade grade) {
        GRADES.add(grade);
    }
}
