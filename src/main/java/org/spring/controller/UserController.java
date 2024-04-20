package org.spring.controller;

import java.util.Scanner;

import org.spring.dao.UserDao;
import org.spring.dto.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserController {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-orm-file.xml");
		UserDao userDao = context.getBean("userDao",UserDao.class);

		System.out.println("1.Save user\n2.Update user\n3.Find user by id\n4.Delete user by id\n5.Verify user by phone and password"
				+ "\n6.Verify user by email and password\n7.Verify user by id and password\n8.Find user by Name\n9.Find user by phone"
				+ "\n10.Find user by email");
		Scanner sc = new Scanner(System.in);
		while(true) {
			switch(sc.nextInt()) {
			case 1: {
				System.out.println("Enter name, email, phone and password");
				User user = new User();
				user.setName(sc.next());
				user.setEmail(sc.next());
				user.setPhone(sc.nextLong());
				user.setPassword(sc.next());
				user = userDao.saveUser(user);
				System.out.println("User saved with id: " + user.getId());
				break;
			}
			case 2: {
				System.out.println("Enter user id to update");
				int id = sc.nextInt();
				User user = new User();
				System.out.println("Enter name, email, phone and password");
				user.setId(id);
				user.setName(sc.next());
				user.setEmail(sc.next());
				user.setPhone(sc.nextLong());
				user.setPassword(sc.next());
				user = userDao.updateUser(user, id);
				System.out.println("User updated with id: " + id);
				break;
			}
			case 3: {
				System.out.println("Enter id to find user");
				int id = sc.nextInt();
				User user = userDao.findUserById(id);

				System.out.println(user);
				break;
			}
			case 4: {
				System.out.println("Enter id to delete user");
				int id = sc.nextInt();
				if(userDao.deleteUserById(id)==true) {
					System.out.println("User deleted with id: "+id);
				}else {
					System.out.println("Invalid user id");
				}
				break;
			}
			case 5: {
				System.out.println("Enter user phone and password");
				User user = userDao.verifyUser(sc.nextLong(), sc.next());
				if(user!=null) {
					System.out.println("User verified with id: " + user.getId());
				}else {
					System.out.println("Invalid credentials");
				}
				break;
			}
			case 6:{
				System.out.println("Enter user email and password");
				User user = userDao.verifyUser(sc.next(), sc.next());
				if(user!=null) {
					System.out.println("User verified with id: " + user.getId());
				}else {
					System.out.println("Invalid credentials");
				}
				break;
			}
			case 7:{
				System.out.println("Enter user id and password");
				User user = userDao.verifyUser(sc.nextInt(), sc.next());
				if(user!=null) {
					System.out.println("User verified with id: " + user.getId());
				}else {
					System.out.println("Invalid credentials");
				}
				break;
			}
			case 8:{
				System.out.println("Enter name to find user");
				User user = userDao.findUserByName(sc.next());
				if(user!=null) {
					System.out.println("User found with id: " + user.getId());
					System.out.println(user);
				}else {
					System.out.println("Invalid credentials");
				}
				break;
			}
			case 9: {
				System.out.println("Enter phone to find user");
				User user = userDao.findUserByPhone(sc.nextLong());
				if(user!=null) {
					System.out.println("User found with id: " + user.getId());
					System.out.println(user);
				}else {
					System.out.println("Invalid credentials");
				}
				break;
			}
			case 10:{
				System.out.println("Enter email to find user");
				User user = userDao.findUserByEmail(sc.next());
				if(user!=null) {
					System.out.println("User found with id: " + user.getId());
					System.out.println(user);
				}else {
					System.out.println("Invalid credentials");
				}
				break;
			}
			default: {
				sc.close();
				((ClassPathXmlApplicationContext) context).close();
				System.out.println("Invalid choice");
			}
			}
		}
	}
}
