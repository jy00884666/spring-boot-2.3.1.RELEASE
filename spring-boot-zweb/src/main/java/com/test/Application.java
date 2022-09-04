package com.test;

import com.test.bean.Person;
import com.test.utils.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/*放置在Springboot启动类上，表明该类是开启Springboot容器的入口，它是一个复合注解。里面包含了包扫描，自动注入，配置注入的功能
 * @SringBootConfiguration 声明配置类
 * @EnableAutoConfiguration 扫描读取.properties配置
 * @ComponentScan 扫描路径,但只会扫描该类所在目录以及子目录,如需手动指定则需要添加属性 (scanBasePackages = {"com.test", "com.utils"})*/
@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		// 打印默认编码
		System.out.println("打印默认编码:" + System.getProperty("file.encoding"));
		
		// 启动类入口
		ConfigurableApplicationContext context = SpringApplication.run(Application.class);
		// 从 SpringBoot 容器中获取对象
		Person person = context.getBean(Person.class);
		person.setName("aaa");
		person.setSex("18");
		System.out.println("person=" + person);
		
		// 超出目录,需要用 scanBasePackages 属性才能扫描到,也可以通过@Bean的方式
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
