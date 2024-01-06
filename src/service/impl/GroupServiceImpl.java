package service.impl;


import domain.Group;
import service.FacultyService;
import service.GroupService;

public class GroupServiceImpl implements GroupService {
    static {
        GROUPS.add(new Group(1,"AXB-1"));
        GROUPS.add(new Group(2,"ATF-1"));
        GROUPS.add(new Group(2,"FTF-1"));
        GROUPS.add(new Group(1,"AXB-4"));
    }
    @Override
    public String addGroup(Group group) {
        FacultyService facultyService = new FacultyServiceImpl();
        for (Group group1:GROUPS){
            if (group.getName().equals(group1.getName()) && group1.getFacultyId().equals(group.getFacultyId())){
                return "This group is already exist in " + facultyService.getFacultyById(group.getFacultyId()).getFacultyName();
            }
        }
        GROUPS.add(group);
        return group.getName() + " added to successfully !!!";
    }

    @Override
    public String deleteGroup(Integer facultyId, Integer groupId) {
        for (Group group : GROUPS){
            if (group.getGroupId().equals(groupId)){
                if (facultyId.equals(group.getFacultyId())){
                    GROUPS.remove(group);
                    return "G" + groupId + " deleted successfully !!!";
                }else{
                    return "This group is not is this faculty !!!";
                }
            }
        }
        return "Group is not exist in " + "G" + groupId + " id";
    }

    @Override
    public Group getGroupById(Integer groupId) {
        for (Group gr:GROUPS){
            if (gr.getGroupId().equals(groupId)){
                return gr;
            }
        }
        return null;
    }

    @Override
    public void showAllGroupsByFacultyId(Integer facultyId) {
        for (Group group : GROUPS) {
            if (group.getFacultyId().equals(facultyId)){
                System.out.println(group);
            }
        }
    }
}
