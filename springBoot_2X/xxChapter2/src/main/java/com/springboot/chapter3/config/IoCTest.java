package com.springboot.chapter3.config;

import com.springboot.chapter3.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springboot.chapter3.pojo.definition.Person;


public class IoCTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//		Person person = ctx.getBean(Person.class);
//		person.service();

		User user = ctx.getBean(User.class);
		System.out.println(user.toString());


		ctx.close();
	}
}