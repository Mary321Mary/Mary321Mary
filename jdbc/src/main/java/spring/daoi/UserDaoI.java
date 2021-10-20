package spring.daoi;

import spring.models.User;

public interface UserDaoI {

	public User findByEmail(String email);
}
