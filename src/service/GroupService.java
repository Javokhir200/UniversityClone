package service;

import domain.Group;

import java.util.ArrayList;
import java.util.List;

public interface GroupService {
    List<Group> GROUPS = new ArrayList<>();
    String addGroup(Group group);
    String deleteGroup(Integer facultyId,Integer groupId);
    Group getGroupById(Integer groupId);
    void showAllGroupsByFacultyId(Integer facultyId);
}
