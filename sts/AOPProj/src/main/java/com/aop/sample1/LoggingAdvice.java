package com.aop.sample1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class LoggingAdvice implements MethodInterceptor {
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		String methodName = invocation.getMethod().getName();
		StopWatch sw = new StopWatch();
		sw.start(methodName);
		System.out.println("[LOG] METHOD: "+methodName+" is calling.");
		Object rtnObj = invocation.proceed(); // sayHello 실행
		sw.stop();
		
		System.out.println("[LOG] METHOD: "+methodName+" was called.");
		System.out.println("[LOG] 처리 시간"+sw.getTotalTimeMillis()/1000+"초");
		return rtnObj;
	}
}
