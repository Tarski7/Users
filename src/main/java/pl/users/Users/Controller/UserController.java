package pl.users.Users.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.users.Users.Entity.User;
import pl.users.Users.Service.MemoryUserService;


@RestController
@RequestMapping("/users")
public class UserController {

	@RequestMapping("/hello")
    public String hello(){
        return "{hello: World}";
    }
	
	@RequestMapping("/helloUser")
	public User helloUser() {
		return new User("nick", "haslo", "imie", "nazwisko", "15-08-2008");
	}
	
	@Autowired
	MemoryUserService memoryUserService;
	
	//@RequestMapping("/getUsers")
	//@RequestMapping("/")
	@GetMapping("/")
	public List<User> getUsers() {
		return memoryUserService.getList();
	}
	
	//@RequestMapping("/getUser/{nickname}")
	//@RequestMapping("/{nickname}")
	@GetMapping("/{nickname}")
	public User getUserByNickname(@PathVariable String nickname) {
		return memoryUserService.getUserByNickname(nickname);
	}
	
	//@PostMapping("/addUser")
	@PostMapping("/")
	public User addUser(@RequestBody User user) {
		memoryUserService.addUser(user);
		
		return new User();
	}
	/*@RequestMapping("/addUser/{nickname}/{password}/{firstName}/{lastName}/{dateOfBirth}")
	public String addUser(@PathVariable String nickname, @PathVariable String password,
						  @PathVariable String firstName, @PathVariable String lastName,
						  @PathVariable String dateOfBirth) {
		User user = new User(nickname, password, firstName, lastName, dateOfBirth);
		memoryUserService.addUser(user);
		return "User has been added!";
	}*/
	
	@RequestMapping("/editUser/{nickname}/{password}/{firstName}/{lastName}/{dateOfBirth}")
	public String editUser(@PathVariable String nickname, @PathVariable String password,
			  				@PathVariable String firstName, @PathVariable String lastName,
			  				@PathVariable String dateOfBirth) {
		User user = memoryUserService.getUserByNickname(nickname);
		int index = memoryUserService.getList().indexOf(user);
		User newUser = new User(nickname, password, firstName, lastName, dateOfBirth);
		memoryUserService.editUser(index, newUser);
		return "User has been edited!";
	}
	
	//@RequestMapping("/deleteUser/{nickname}")
	//@RequestMapping("/{nickname}")
	@DeleteMapping("/{nickname}")
	public String deleteUser(@PathVariable String nickname) {
		User user = memoryUserService.getUserByNickname(nickname);
		memoryUserService.deleteUser(user);
		return "User has been deleted!";
	}
	
}
