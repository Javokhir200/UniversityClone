package service.impl;

import domain.GroupSubject;
import service.GroupService;
import service.GroupSubjectService;
import service.SubjectService;

import java.util.Objects;

public class GroupSubjectServiceImpl implements GroupSubjectService {
        SubjectService subjectService = new SubjectServiceImpl();
        GroupService groupService = new GroupServiceImpl();
    @Override
    public String addSubjectToGroup(Integer groupId, Integer subjectId) {
        for (GroupSubject gs:GROUP_SUBJECTS){
            if (gs.getGroupId().equals(groupId)){
                if (gs.getSubjectId().equals(subjectId)){
                    return subjectService.getSubjectById(subjectId).getSubjectName() + " already exist in " +groupService.getGroupById(groupId);
                }
            else{
                    if(Objects.isNull(subjectService.getSubjectById(subjectId))){
                        return "Subject is not exist in " + subjectId;
                    }
                }}
            }
        GROUP_SUBJECTS.add(new GroupSubject(groupId,subjectId));
        return subjectService.getSubjectById(subjectId) + " added to " + groupService.getGroupById(groupId);
        }

    @Override
    public String removeSubjectFromGroup(Integer groupId, Integer subjectId) {
        for (GroupSubject gs:GROUP_SUBJECTS){
            if (gs.getGroupId().equals(groupId)){
                if (gs.getSubjectId().equals(subjectId)){
                    GROUP_SUBJECTS.remove(gs);
                    return subjectService.getSubjectById(subjectId).getSubjectName() + " removed successfully from " +groupService.getGroupById(groupId);
                }else{
                    if(Objects.isNull(subjectService.getSubjectById(subjectId))){
                        return "Subject is not exist in " + subjectId;
                    }
                }
            }
        }
        return subjectService.getSubjectById(subjectId).getSubjectName() + " is not exist in " +groupService.getGroupById(groupId);
    }

    @Override
    public void showSubjectsByGroupId(Integer groupId) {
        for (GroupSubject gs : GROUP_SUBJECTS){
            if (gs.getGroupId().equals(groupId)){
                System.out.println(subjectService.getSubjectById(gs.getSubjectId()));
            }
        }
    }
}
