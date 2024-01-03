package service;

import domain.Group;

import java.util.ArrayList;
import java.util.List;

public interface GroupService {
    List<Group> GROUPS = new ArrayList<>();
    String addGroup(Group group);
    String deleteGroup(Integer groupId);
    String addSubject(Integer groupId, Integer subjectId);
    String removeSubject(Integer groupId,Integer subjectId);
    void showSubjects(Integer groupId);
    void showAllGroups();
}
