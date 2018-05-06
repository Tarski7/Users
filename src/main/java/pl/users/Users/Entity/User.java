package pl.users.Users.Entity;

public class User {

	private String nickname;
	private String password;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	
	public User() {
		
	}
	
	public User(String nickname, String password, String firstName, String lastName, String dateOfBirth) {
		this.nickname = nickname;
		//setPassword(password);
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}

	public String getPassword() {
		return password;
	}

	/*public void setPassword(String password) {
		this.password = BCrypt.hashpw(password, BCrypt.gensalt());
	}*/

	public String getNickname() {
		return nickname;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}
	
	/*public boolean isPasswordCorrect(String password) {	
		return BCrypt.checkpw(password, this.password);
	}*/

	@Override
	public String toString() {
		return "User [nickname=" + nickname + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", dateOfBirth=" + dateOfBirth + "]";
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
}
