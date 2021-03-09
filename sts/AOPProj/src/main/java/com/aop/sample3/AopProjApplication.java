package com.aop.sample3;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

@SpringBootApplication
public class AopProjApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("beans3.xml");
		MessageBean bean = (MessageBean)ctx.getBean("targetBean");
		bean.sayHello();
	}

}
