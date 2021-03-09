package com.aop.sample3;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class LoggingSample {
	
	@Around("execution(* sayHello())")
	public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = pjp.getKind();
		StopWatch sw = new StopWatch();
		sw.start(methodName);
		System.out.println("[LOG] METHOD: "+methodName+" is calling.");
		Object rtnObj = pjp.proceed(); // sayHello 실행
		sw.stop();
		
		System.out.println("[LOG] METHOD: "+methodName+" was called.");
		System.out.println("[LOG] 처리 시간 "+sw.getTotalTimeMillis()/1000+"초");
		return rtnObj;
	}
}
