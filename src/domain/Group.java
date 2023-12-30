package domain;

import java.util.LinkedHashSet;
import java.util.Set;

public class Group {
    private  int sequence = 0;
    {
        sequence++;
    }
    private int groupId = sequence;
    private String name;
    private Set <String> subjects = new LinkedHashSet<>();

    public Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<String> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", name='" + name + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
