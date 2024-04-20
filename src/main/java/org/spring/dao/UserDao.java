package org.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.spring.dto.User;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class UserDao {
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public User saveUser(User user) {
		hibernateTemplate.save(user);
		return user;
	}
	
	@Transactional
	public User updateUser(User user, int id) {
		User dbUser = hibernateTemplate.get(User.class, id);
		if(dbUser!=null) {
			dbUser.setName(user.getName());
			dbUser.setEmail(user.getEmail());
			dbUser.setPhone(user.getPhone());
			dbUser.setPassword(user.getPassword());
			hibernateTemplate.update(dbUser);
			return dbUser;
		}else {
			return null;
		}
	}
	
	public User findUserById(int id) {
		return hibernateTemplate.get(User.class, id);
	}
	@Transactional
	public boolean deleteUserById(int id) {
		User dbUser = hibernateTemplate.get(User.class, id);
		if(dbUser!=null) {
			hibernateTemplate.delete(dbUser);
			return true;
		}else {
			return false;
		}
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public User verifyUser(long phone, String password) {
		List<User> users = (List<User>)hibernateTemplate.find("select u from User u where u.phone=?0 and u.password = ?1", phone,password);
		if(users.isEmpty()) {
			return null;
		}else {
			return users.get(0);
		}
	}
	public User verifyUser(String email, String password) {
		List<User> users = (List<User>)hibernateTemplate.find("select u from User u where u.email=?0 and u.password = ?1", email,password);
		if(users.isEmpty()) {
			return null;
		}else {
			return users.get(0);
		}
	}
	public User verifyUser(int id, String password) {
		List<User> users = (List<User>)hibernateTemplate.find("select u from User u where u.id=?0 and u.password = ?1", id,password);
		if(users.isEmpty()) {
			return null;
		}else {
			return users.get(0);
		}
	}

	public User findUserByName(String name) {
		List<User> users = (List<User>)hibernateTemplate.find("select u from User u where u.name=?0", name);
		if(users.isEmpty()) {
			return null;
		}else {
			return users.get(0);
		}
	}
	public User findUserByPhone(long phone) {
		List<User> users = (List<User>)hibernateTemplate.find("select u from User u where u.phone=?0", phone);
		if(users.isEmpty()) {
			return null;
		}else {
			return users.get(0);
		}
	}
	public User findUserByEmail(String email) {
		List<User>users = (List<User>)hibernateTemplate.findByNamedParam("select u from User u where u.email=:em", new String[] {"em"}, new Object[] {email});
//		List<User> users = (List<User>)hibernateTemplate.find("select u from User u where u.email=?0", email);
		if(users.isEmpty()) {
			return null;
		}else {
			return users.get(0);
		}
	}
}
