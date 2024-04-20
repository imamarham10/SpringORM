package org.spring.jdbctemplatepractice;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class DeleteEmployee {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id to delete employee");
		int id = sc.nextInt();
		
		String qry = "delete from employee where id=?";
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-orm-file.xml");
		JdbcTemplate template = context.getBean("jdbcTemplate",JdbcTemplate.class);
		int row = template.update(qry, id);
		System.out.println(row + " row deleted");
		((ClassPathXmlApplicationContext)context).close();
	}
}
