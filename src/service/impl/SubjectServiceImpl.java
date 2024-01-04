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
    public Subject getSubjectById(Integer subjectId) {
        return null;
    }

    public static void showSubjects(){
        System.out.println("=====Subjects=====");
        for (Subject subject:SUBJECTS){
            System.out.println(subject.toString());
        }
        System.out.println("==================");
    }

}
