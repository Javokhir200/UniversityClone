package service.impl;

import domain.Faculty;
import service.FacultyService;

public class FacultyServiceImpl implements FacultyService {
    @Override
    public String addFaculty(Faculty faculty) {
        FACULTIES.add(faculty);
        return faculty.getFacultyName() + " added successfully !!!";
    }

    @Override
    public String removeFaculty(Integer facultyId) {
        for (Faculty faculty:FACULTIES){
            if (faculty.getFacultyId().equals(facultyId)){
                FACULTIES.remove(faculty);
                return "Faculty in " + facultyId + " removed successfully !!!";
            }
        }
        return "Faculty is not exist in " + facultyId;
    }

    @Override
    public Faculty getFacultyById(Integer facultyId) {
        return null;
    }

    @Override
    public void showAllFaculties(){
        for (Faculty faculty:FACULTIES){
            System.out.println(faculty.toString());
        }
    }
}
