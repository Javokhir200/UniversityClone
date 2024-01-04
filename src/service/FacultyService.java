package service;

import domain.Faculty;

import java.util.LinkedHashSet;
import java.util.Set;

public interface FacultyService {
    Set<Faculty> FACULTIES = new LinkedHashSet<>();
    String addFaculty(Faculty faculty);
    String removeFaculty(Integer facultyId);
    Faculty getFacultyById(Integer facultyId);
    void showAllFaculties();
}
