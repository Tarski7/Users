package pl.users.Users.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.users.Users.Entity.Group;
import pl.users.Users.Service.MemoryGroupService;

@RestController
@RequestMapping("/groups")
public class GroupController {

	@RequestMapping("/hello")
    public String hello(){
        return "{hello: World}";
    }
	
	@RequestMapping("/helloGroup")
	public Group helloGroup() {
		return new Group("Group");
	}
	
	@Autowired
	MemoryGroupService memoryGroupService;
	
	@RequestMapping("/getGroups")
	public List<Group> getGroups() {
		return memoryGroupService.getList();
	}
	
	@RequestMapping("/getGroup/{name}")
	public Group getGroupByName(@PathVariable String name) {
		return memoryGroupService.getGroupByName(name);
	}
	
	@RequestMapping("/addGroup/{name}")
	public String addGroup(@PathVariable String name) {
		Group group = new Group(name);
		memoryGroupService.addGroup(group);
		return "Group has been added!";
	}
	
	@RequestMapping("/editGroup/{name}")
	public String editGroup(@PathVariable String name) {
		Group group = memoryGroupService.getGroupByName(name);
		int index = memoryGroupService.getList().indexOf(group);
		Group newGroup = new Group(name);
		memoryGroupService.editGroup(index, newGroup);
		return "Group has been edited!";
	}
	
	@RequestMapping("/deleteGroup/{name}")
	public String deleteGroup(@PathVariable String name) {
		Group group = memoryGroupService.getGroupByName(name);
		memoryGroupService.deleteGroup(group);
		return "Group has been deleted!";
	}
}
