package domain;

public class Subject {
    private int sequence = 0;
    {
        sequence++;
    }
    private int subjectId = sequence;
    private String name;

    public Subject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
