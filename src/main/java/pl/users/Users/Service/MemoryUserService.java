package pl.users.Users.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import pl.users.Users.Entity.User;


@Service
public class MemoryUserService {

private List<User> list;
	
	public MemoryUserService() {
		list = new ArrayList<>();
		list.add(new User("nick1", "haslo", "imie1", "nazwisko1", "14-11-2017"));
		list.add(new User("nick2", "haslo", "imie2", "nazwisko2", "07-01-2007"));
		list.add(new User("nick3", "haslo", "imie3", "nazwisko3", "15-10-2011"));
	}
	
	public List<User> getList() {
		return list;
	}
	
	public void setList(List<User> list) {
		this.list = list;
	}
	
	public User getUserByNickname(String nickname) {
		for (User user : list) {
			if (user.getNickname().equals(nickname))
				return user;
		}
		return null;
	}
	
	public void addUser(User user) {
		list.add(user);
	}
	
	public void editUser(int index, User user) {
		list.set(index, user);
	}
	
	public void deleteUser(User user) {
		list.remove(user);
	}
}
