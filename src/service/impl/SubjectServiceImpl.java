package service.impl;

import domain.Subject;
import service.SubjectService;

import java.util.Set;

public class SubjectServiceImpl implements SubjectService {
    @Override
    public String addSubject(Subject subject) {
        for (Subject sub:SUBJECTS){
            if(sub.getSubjectId().equals(subject.getSubjectId())){
                return "Subject already exist !!!";
            }
        }
        SUBJECTS.add(subject);
        return "Subject added  successfully !!!";
    }

    @Override
    public String removeSubject(Integer subjectId) {
        for (Subject subject:SUBJECTS){
            if(subject.getSubjectId().equals(subjectId)){
                SUBJECTS.remove(subjectId);
                return "Subject removed successfully !!!";
            }
        }
        return "Subject isn't exist !!!";
    }

    @Override
    public String removeSubjectFromGroupById(Integer groupId, Integer subjectId) {
        for (Subject subject:SUBJECTS){
            if (subject.getSubjectId().equals(subjectId)){
                for (Integer grId : subject.getGroupsID()){
                    if (grId.equals(groupId)){
                        Set<Integer>  set = subject.getGroupsID();
                        if (set.remove(groupId)) {
                            subject.setGroupsID(set);
                            return subject.getSubjectName() + " is removed from G" + groupId;
                        }
                    }
                }
            }
            return "Subject in " + subjectId + " is not added to G" + groupId;
        }
        return "Subject is not exist in " + subjectId;
    }

    @Override
    public String addSubjectFromGroupById(Integer groupId, Integer subjectId) {
        for (Subject subject:SUBJECTS){
            if (subject.getSubjectId().equals(subjectId)){
                for (Integer grId : subject.getGroupsID()){
                    if (grId.equals(groupId)){
                        return "Subject in " + subjectId + " is already exist in G" + groupId;
                    }
                }
                Set<Integer> set = subject.getGroupsID();
                set.add(subjectId);
                subject.setGroupsID(set);
                return "Subject in " + subjectId + " is added successfully to  G" + groupId;
            }
            return "Subject in " + subjectId + " is not added to G" + groupId;
        }
        return "Subject is not exist in " + subjectId;
    }

    public static void showSubjects(){
        System.out.println("=====Subjects=====");
        for (Subject subject:SUBJECTS){
            System.out.println(subject.toString());
        }
        System.out.println("==================");
    }
    public void showSubjectsByGroupId(Integer groupId){
        int i=1;
        for (Subject subject : SUBJECTS){
            for (Integer grId:subject.getGroupsID()){
                if(grId.equals(groupId)){
                    System.out.println(i + ") " + subject.getSubjectName());
                    i++;
                }
            }
        }
    }
}
