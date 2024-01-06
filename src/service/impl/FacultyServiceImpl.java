package service.impl;

import domain.Faculty;
import service.FacultyService;

public class FacultyServiceImpl implements FacultyService {
    static {
        FACULTIES.add(new Faculty("Iqtisod"));
        FACULTIES.add(new Faculty("Filologiya"));
    }
    @Override
    public String addFaculty(Faculty faculty) {
        for (Faculty faculty1:FACULTIES){
            if (faculty1.getFacultyName().equals(faculty.getFacultyName())){
                return faculty.getFacultyName() + " is already exist !!!";
            }
        }
        System.out.printf("temp");
        FACULTIES.add(faculty);
        return faculty.getFacultyName() + " is added successfully !!!";
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
        for (Faculty faculty:FACULTIES){
            if (faculty.getFacultyId().equals(facultyId)){
                return faculty;
            }
        }
        return null;
    }

    @Override
    public void showAllFaculties(){
        for (Faculty faculty:FACULTIES){
            System.out.println(faculty.toString());
        }
    }
}
