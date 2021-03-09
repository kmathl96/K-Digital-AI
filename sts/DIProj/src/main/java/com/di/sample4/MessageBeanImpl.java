package com.di.sample4;

import java.io.IOException;

public class MessageBeanImpl implements MessageBean {
	private String name;
	private String greeting;
	private Outputter outputter;
	
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	public void setOuputter(Outputter ouputter) {
		this.outputter = outputter;
	}
	public MessageBeanImpl(String name) {
		this.name = name;
	}

	@Override
	public void sayHello() {
		String message = greeting + ", " + name + "!";
		System.out.println(message);
		try {
			outputter.output(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
