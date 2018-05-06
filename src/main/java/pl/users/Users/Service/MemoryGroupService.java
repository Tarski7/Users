package pl.users.Users.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import pl.users.Users.Entity.Group;


@Service
public class MemoryGroupService {

private List<Group> list;
	
	public MemoryGroupService() {
		list = new ArrayList<>();
		list.add(new Group("Group 1"));
		list.add(new Group("Group 2"));
		list.add(new Group("Group 3"));
		list.add(new Group("Group 4"));
		list.add(new Group("Group 5"));
	}

	public List<Group> getList() {
		return list;
	}

	public void setList(List<Group> list) {
		this.list = list;
	}
	
	public Group getGroupByName(String name) {
		for (Group group : list) {
			if (group.getName().equals(name))
				return group;
		}
		return null;
	}
	
	public void addGroup(Group group) {
		list.add(group);
	}
	
	public void editGroup(int index, Group group) {
		list.set(index, group);
	}
	
	public void deleteGroup(Group group) {
		list.remove(group);
	}
}
