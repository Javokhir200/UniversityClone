package domain;

import java.util.LinkedHashSet;
import java.util.Set;

public class Group {
    private  int sequence = 0;
    {
        sequence++;
    }
    private int groupId = sequence;
    private int facultyId;
    private String name;
    private Set <String> SUBJECTS = new LinkedHashSet<>();

    public Group(int facultyId, String name) {
        this.facultyId = facultyId;
        this.name = name;
    }

    public Integer getGroupId() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getSUBJECTS() {
        return SUBJECTS;
    }

    public void setSUBJECTS(Set<String> SUBJECTS) {
        this.SUBJECTS = SUBJECTS;
    }

}
