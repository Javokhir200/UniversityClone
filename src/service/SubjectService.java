package service;

import domain.Subject;

import java.util.LinkedHashSet;
import java.util.Set;

public interface SubjectService {
    Set<Subject> SUBJECTS = new LinkedHashSet<>();
    String addSubject(Subject subject);
    String removeSubject(Integer subjectId);
    Subject getSubjectById(Integer subjectId);
    void showSubjects();
}
