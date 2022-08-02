package com.test;

import com.test.bean.Person;
import com.test.utils.StringUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyText {
	
	public static void main(String[] args) {
		// 打印默认编码
		System.out.println("打印默认编码:" + System.getProperty("file.encoding"));
		
		// 创建Spring容器
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		// 获取对象Bean,创建Spirng容易若传入Person.class,则Person对象中可以没有 @Component 注解
		Person person = (Person) context.getBean("person");
		System.out.println("person:" + person);
		
		// 创建容器为传入StringUtils,所以StringUtils中必须有@Component 注解
		StringUtils stringUtils = context.getBean(StringUtils.class);
		System.out.println("stringUtils=" + stringUtils);
	}
	
}
