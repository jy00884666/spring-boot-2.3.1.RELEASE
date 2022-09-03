package com.test.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

/*把普通pojo实例化到spring容器中,相当于配置文件中的 <bean id="" class=""/> */
@Component
@Data
public class Person {
	
	private String name;
	
	private String sex;
	
	
}
