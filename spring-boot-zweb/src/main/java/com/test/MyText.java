package com.test;

import com.test.bean.Person;
import com.test.utils.StringUtils;
import com.test.utils.UrlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/*SpringMVC 测试,跑SpringBoot用Application.java*/
public class MyText {
	
	private static Logger logger = LoggerFactory.getLogger(MyText.class);
	
	public static void main(String[] args) {
		// 打印默认编码
		System.out.println("打印默认编码:" + System.getProperty("file.encoding"));
		
		// Bean应用测试
		//beanApply();
		
		// 模拟post请求
		//sendpost();
		
		
	}
	
	/**
	 * 模拟post请求
	 */
	private static void sendpost() {
		String message = null;
		try {
			message = UrlUtil.sendPost("http://localhost:8080/sayHello", "who= aimeili");
		} catch (Exception e) {
			logger.error("模拟post请求异常", e);
		}
		logger.info("模拟post请求返回结果{}", message);
	}
	
	/**
	 * Bean应用测试
	 */
	public static void beanApply() {
		// 创建Spring容器
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		// 获取对象Bean,创建Spirng容易若传入Person.class,则Person对象中可以没有 @Component 注解
		Person person = (Person) context.getBean("person");
		person.setName("aaa");
		person.setSex("18");
		System.out.println("person:" + person);
		
		// 创建容器为传入StringUtils,所以StringUtils中必须有@Component 注解
		StringUtils stringUtils = context.getBean(StringUtils.class);
		System.out.println("stringUtils=" + stringUtils);
		
	}
	
	/*@Bean
	public StringUtils getStringUtils() throws Exception {
		// 创建对象
		System.out.println("创建StringUtils");
		return StringUtils.class.newInstance();
	}*/
	
}
