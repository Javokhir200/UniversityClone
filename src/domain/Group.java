package domain;

public class Group {
    static int sequence = 0;
    {
        sequence++;
    }
    private String name;
    private int groupId = sequence;
    private int facultyId;

    public Group(int facultyId, String name) {
        this.facultyId = facultyId;
        this.name = name;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public Integer getFacultyId() {
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

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", groupId=" + groupId +
                ", facultyId=" + facultyId +
                '}';
    }
}
