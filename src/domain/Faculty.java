package domain;

public class Faculty {
    private int sequence =0;
    {
        sequence++;
    }
    private int facultyId = sequence;
    private String facultyName;

    public Faculty(String facultyName) {
        this.facultyName = facultyName;
    }

    public Integer getFacultyId() {
        return facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyId=" + facultyId +
                ", facultyName='" + facultyName +
                '}';
    }
}
