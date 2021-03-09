package com.di.sample3;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

@SpringBootApplication
public class DiProjApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("beans1.xml");
		MessageBean bean = ctx.getBean("messageBean", MessageBean.class);
		bean.sayHello("Spring");
	}

}
