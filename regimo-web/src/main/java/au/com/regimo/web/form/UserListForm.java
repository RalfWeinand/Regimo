package au.com.regimo.web.form;

import au.com.regimo.core.domain.User;
import au.com.regimo.core.utils.BeanUtilsExtend;

public class UserListForm {

	private Long id;
	
	private String username;
    
    private String firstName;

    private String lastName;
    
	private String email;

	public UserListForm(User user) {
		this();
		BeanUtilsExtend.copyPropertiesWithoutNull(user, this);
	}
	
	public UserListForm() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
