package org.spring.jdbctemplatepractice;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public class FetchEmployeeById {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-orm-file.xml");
		JdbcTemplate template = context.getBean("jdbcTemplate",JdbcTemplate.class);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee id");
		int id = sc.nextInt();
		String qry = "select * from employee where id=?";
		
		ResultSetExtractor<String> rse = rs->{
			boolean flag = false;
			if(rs.next()) {
				flag = true;
				System.out.println("Id: " + rs.getInt(1));
				System.out.println("Name: " + rs.getString(2));
				System.out.println("Salary: " + rs.getDouble(3));
				System.out.println("Designation: " + rs.getString(4));
				return "Employee Found";
			}else {
				return "Invalid Employee id";
			}
		};
		String message = template.query(qry,new Object[] {id} ,rse);
		System.out.println(message);
	}
}
