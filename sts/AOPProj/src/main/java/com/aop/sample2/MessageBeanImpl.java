package com.aop.sample2;

public class MessageBeanImpl implements MessageBean {
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void sayHello() {
		System.out.println("Hello, "+name+"!");
	}
}
