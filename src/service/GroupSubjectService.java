package service;

import domain.GroupSubject;
import domain.Subject;

import java.util.ArrayList;
import java.util.List;

public interface GroupSubjectService {
    List<GroupSubject> GROUP_SUBJECTS = new ArrayList<>();
    String addSubjectToGroup(Integer groupId,Integer subjectId);
    String removeSubjectFromGroup(Integer groupId,Integer subjectId);
    void showAllSubjectsByGroupId(Integer groupId);
}
