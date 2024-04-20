package org.spring.jdbctemplatepractice;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class UpdateEmployee {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id, name, salary and designation to update employee");
		int id = sc.nextInt();
		String name = sc.next();
		double salary = sc.nextDouble();
		String desg = sc.next();
		
		String qry = "update employee set name=?, salary=?,designation=? where id=?";
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-orm-file.xml");
		JdbcTemplate template = context.getBean("jdbcTemplate",JdbcTemplate.class);
		int rows = template.update(qry,name,salary,desg,id);
		System.out.println(rows + " rows updated");
		((ClassPathXmlApplicationContext)context).close();
	}
}
