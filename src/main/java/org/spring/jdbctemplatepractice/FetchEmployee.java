package org.spring.jdbctemplatepractice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public class FetchEmployee {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-orm-file.xml");
		JdbcTemplate template = context.getBean("jdbcTemplate",JdbcTemplate.class);
		String qry = "select * from employee";
		
		ResultSetExtractor<String> rse = rs->{
			boolean flag = false;
			while(rs.next()) {
				flag = true;
				System.out.println("Id: " + rs.getInt(1));
				System.out.println("Name: " + rs.getString(2));
				System.out.println("Salary: " + rs.getDouble(3));
				System.out.println("Designation: " + rs.getString(4));
			}
			if(flag==false) {
				return "No employee present in database";
			}
			return "Employee found";
		};
		String message = template.query(qry, rse);
		System.out.println(message);
	}
}
