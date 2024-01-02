package impl;

import domain.Faculty;
import service.FacultyService;

public class FacultyServiceImpl implements FacultyService {
    @Override
    public Faculty add(Faculty faculty) {
        FACULTY_LIST.add(faculty);
        return faculty;
    }

    @Override
    public String edit(Integer facultyId, String newName) {
        for(Faculty faculty : FACULTY_LIST) {
            if(faculty.getFacultyId() == facultyId) {
                faculty.setFacultyName(newName);
            }
        }
        return "Updated successfully!";
    }

    @Override
    public Faculty remove(Faculty faculty) {
        for(Faculty faculty1 : FACULTY_LIST) {
            if(faculty.getFacultyId() == faculty1.getFacultyId()) {
                FACULTY_LIST.remove(faculty1);
            }
        }
        return faculty;
    }
}
