package service.impl;

import domain.Subject;
import service.SubjectService;

import java.util.Set;

public class SubjectServiceImpl implements SubjectService {
    static {
        SUBJECTS.add(new Subject("Math"));
        SUBJECTS.add(new Subject("Physics"));
        SUBJECTS.add(new Subject("Biology"));
    }
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
                SUBJECTS.remove(subject);
                return "Subject removed successfully !!!";
            }
        }
        return "Subject isn't exist !!!";
    }

    @Override
    public Subject getSubjectById(Integer subjectId) {
        for (Subject subject:SUBJECTS){
            if(subjectId.equals(subject.getSubjectId())){
                return subject;
            }
        }
        return null;
    }

    @Override
    public void showSubjects() {
        System.out.println("=====Subjects=====");
        for (Subject subject:SUBJECTS){
            System.out.println(subject.toString());
        }
        System.out.println("==================");
    }
}
