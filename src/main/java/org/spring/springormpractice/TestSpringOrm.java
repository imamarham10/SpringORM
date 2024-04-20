package org.spring.springormpractice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;


public class TestSpringOrm {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-orm-file.xml");
		HibernateTemplate hibernateTemplate = context.getBean("hibernateTemplate",HibernateTemplate.class);
		System.out.println(hibernateTemplate);
	}
}
