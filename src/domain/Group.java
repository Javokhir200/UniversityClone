package domain;

public class Group {
    private  int sequence = 0;
    {
        sequence++;
    }
    private int groupId = sequence;
    private String name;

    public Group(String name) {
        this.name = name;
    }
}
