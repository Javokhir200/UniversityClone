package domain;

public class Grade {
    private int studentId;
    private int teacherId;
    private double grade;
    private int subjectId;

    public Grade(int studentId, int teacherId, double grade, int subjectId) {
        this.studentId = studentId;
        this.teacherId = teacherId;
        this.grade = grade;
        this.subjectId = subjectId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }
}
