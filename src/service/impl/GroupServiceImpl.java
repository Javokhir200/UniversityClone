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
    public String addSubject(Integer groupId, Integer subjectId) {
        return subjectService.addSubjectFromGroupById(groupId, subjectId);
    }

    @Override
    public String removeSubject(Integer groupId, Integer subjectId) {
        return subjectService.removeSubjectFromGroupById(groupId,subjectId);
    }

    @Override
    public void showSubjects(Integer groupId) {
        subjectService.showSubjectsByGroupId(groupId);
    }
}
