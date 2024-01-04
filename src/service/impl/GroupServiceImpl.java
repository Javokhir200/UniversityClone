package service.impl;


import domain.Group;
import service.GroupService;

public class GroupServiceImpl implements GroupService {
    static SubjectServiceImpl subjectService = new SubjectServiceImpl();
    @Override
    public String addGroup(Group group) {
        GROUPS.add(group);
        return group.getName() + " group added successfully !!!";
    }

    @Override
    public String deleteGroup(Integer groupId) {
        for (Group group : GROUPS){
            if (group.equals(groupId)){
                return "G" + groupId + " deleted successfully !!!";
            }
        }
        return "Group is not exist in " + "G" + groupId + " id";
    }

    @Override
    public Group getGroupById(Integer groupId) {
        return null;
    }

    @Override
    public void showAllGroups() {
        for (Group group : GROUPS) {
            System.out.println(group);
        }
    }
}
