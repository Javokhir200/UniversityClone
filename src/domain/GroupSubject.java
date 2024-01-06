package domain;

public class GroupSubject {
    private static int sequence = 0;
    {
        sequence++;
    }
    private int grSubId = sequence;
    private int groupId;
    private int subjectId;

    public GroupSubject(int groupId, int subjectId) {
        this.groupId = groupId;
        this.subjectId = subjectId;
    }

    public Integer getGrSubId() {
        return grSubId;
    }

    public void setGrSubId(int grSubId) {
        this.grSubId = grSubId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }
}
