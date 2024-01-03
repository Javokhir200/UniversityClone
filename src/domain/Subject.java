package domain;

import java.util.HashSet;
import java.util.Set;

public class Subject {
    private int counter = 0;
    {
        counter++;
    }
    private Integer subjectId = counter;
    private String subjectName;
    private Set<Integer> groupsID = new HashSet<>();

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Set<Integer> getGroupsID() {
        return groupsID;
    }

    public void setGroupsID(Set<Integer> groupsID) {
        this.groupsID = groupsID;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", groups=" + groupsID +
                '}';
    }
}
