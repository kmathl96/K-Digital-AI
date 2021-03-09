package com.di.sample2;

public class MessageBeanKr extends MessageBean {
	@Override
	public void sayHello(String name) {
		System.out.println("안녕하세요, "+name+"씨!");
	}
}
