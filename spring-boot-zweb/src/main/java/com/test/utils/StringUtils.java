package com.test.utils;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*把普通pojo实例化到spring容器中,相当于配置文件中的 <bean id="" class=""/> */
@Component
public class StringUtils extends org.apache.commons.lang.StringUtils {
	
	/*如果传入“null”返回true*/
	public static boolean isBlankContNull(Object strName) {
		if (strName == null) {
			return true;
		}
		if ("null".equals(strName + "")) {
			return true;
		}
		String str = (String) strName;
		return org.apache.commons.lang.StringUtils.isBlank(str);
	}
	
	/*如果传入“null”返回false*/
	public static boolean isBlank(Object strName) {
		if (strName == null) {
			return true;
		}
		String str = (String) strName;
		return org.apache.commons.lang.StringUtils.isBlank(str);
	}
	
	/*判断字符串是否为数值*/
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("-?[0-9]+(.[0-9]+)?");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}
	
}
