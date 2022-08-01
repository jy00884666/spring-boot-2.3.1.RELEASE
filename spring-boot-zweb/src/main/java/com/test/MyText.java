package com.test;

import com.test.bean.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyText {
	
	public static void main(String[] args) {
		// 创建Spring容器
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Person.class);
		// 获取对象Bean,对象中可以没有 @Component 注解
		Person person = (Person) context.getBean("person");
		System.out.println("person:" + person);
	}
	
}
