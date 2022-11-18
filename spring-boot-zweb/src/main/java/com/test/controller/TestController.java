package com.test.controller;

import com.test.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	private static Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping("/test")
	public String test() {
		logger.info("测试进入/test controller方法");
		return "hello word!!!";
	}
	
}
