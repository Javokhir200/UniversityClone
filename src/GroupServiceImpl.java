package impl;

import domain.Group;
import service.GroupService;

public class GroupServiceImpl implements GroupService {
    @Override
    public Group add(Group group) {
        GROUP_SET.add(group);
        return group;
    }

    @Override
    public String delete(Integer groupId) {
        GROUP_SET.removeIf(group -> group.getGroupId() == groupId);
        return "Deleted successfully";
    }
}
