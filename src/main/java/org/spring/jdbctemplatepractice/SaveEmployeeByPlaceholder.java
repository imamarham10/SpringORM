package org.spring.jdbctemplatepractice;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SaveEmployeeByPlaceholder {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id, name, salary and designation to save employee");
		int id = sc.nextInt();
		String name = sc.next();
		double salary = sc.nextDouble();
		String desg = sc.next();
		
		String qry = "insert into employee values(?,?,?,?)";
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-orm-file.xml");
		JdbcTemplate template = context.getBean("jdbcTemplate",JdbcTemplate.class);
		int rows = template.update(qry, id,name,salary,desg);
		System.out.println(rows + " rows inserted");
		((ClassPathXmlApplicationContext)context).close();
		
		
	}
}
