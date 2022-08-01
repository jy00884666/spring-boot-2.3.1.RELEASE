package com.test.bean;

import org.springframework.stereotype.Component;

/*把普通pojo实例化到spring容器中,相当于配置文件中的 <bean id="" class=""/> */
@Component
public class Person {
	
	private String name;
	
	private String sex;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", sex='" + sex + '\'' +
				'}';
	}
}
