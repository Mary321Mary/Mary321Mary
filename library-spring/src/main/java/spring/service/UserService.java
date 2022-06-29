package spring.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.UserDetailsImpl;
import spring.dao.UserDao;
import spring.models.User;

@Service
@Transactional
public class UserService implements UserDetailsService {
	
    private UserDao userDao;
    
    public UserService(UserDao userDao) {
    	this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
		return UserDetailsImpl.build(user);
    }
}
