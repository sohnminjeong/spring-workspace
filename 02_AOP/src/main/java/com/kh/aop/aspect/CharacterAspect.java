package com.kh.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//일반적인 자바 클래스가 아니라 애스팩트임을 나타낸다.
@Aspect
public class CharacterAspect {	
	// @Pointcut으로 필요할 때마다 참조할 수 있는 포인트커트를 정의한다.
	// 설명 : 포인트 커트를 한 번만 정의하고 필요할 때마다 참조할 수 있는 @Pointcut 어노테이션을 제공한다.
	@Pointcut("execution(* com.kh.aop.character.Character.quest(..)) && args(questName)")
	public void questPointcut(String questName) {}
	
	@Before("execution(* com.kh.aop.character.Character.quest(..))")
	public void beforeQuest(JoinPoint jp) {
		// 퀘스트를 수행하기 전에 필요한 부가 작업들 수행
		String questName = (String) jp.getArgs()[0];
		System.out.println(questName + " 퀘스트 준비 중..");
	}
	
	@After("execution(* com.kh.aop.character.Character.quest(..))")
	public void afterQuest() {
		// 퀘스트 수행 결과에 상관없이 필요한 부가 작업을 수행
		System.out.println("퀘스트 수행 완료..");
	}
	
	@AfterReturning(
		value = "questPointcut(questName)", 
		returning = "result"
	)
	public void questSuccess(String questName, String result) {
		// 퀘스트 수행 완료 후에 필요한 부가 작업을 수행한다.
		System.out.println(result);		
		System.out.println(questName + " 퀘스트 수행 완료..");
	}
	
	@AfterThrowing(
		value = "questPointcut(questName)",
		throwing = "exception"
	)
	public void questFail(String questName, Exception exception) {
		// 퀘스트 수행 중에 예외를 던졌을 때 필요한 부가 작업을 수행한다.
		System.out.println(exception.getMessage());
		System.out.println(questName + " 수행 중 에러가 발생하였습니다.");
	}
	
	/*
	@Around("execution(* com.kh.aop.character.Character.quest(..))")
	public String questAdvice(ProceedingJoinPoint jp) {
		String result = null;
		String questName = "<" + (String) jp.getArgs()[0] + ">";
		
		try {
			// before 어드바이스에 대한 기능을 수행
			System.out.println(questName + " 퀘스트 준비중..");
			
			// 타겟 객체의 메소드를 실행시킨다.
//			jp.proceed();
			
			// 타겟 객체의 메소드에 리턴값이 있을 경우 
//			result = (String) jp.proceed();
			
			// 타겟 객체의 메소드에 파라미터 값을 변경해서 전달해줄 경우
			result = (String) jp.proceed(new Object[] { questName });
			
			// after-returning 어드바이스에 대한 기능을 수행
			System.out.println(questName + " 퀘스트 수행 완료..");	
		} catch (Throwable e) {
			// after-throwing 어드바이스에 대한 기능을 수행
//			System.out.println(e.getMessage());
			System.out.println(questName + " 수행 중 에러가 발생하였습니다.");
		}
		
		return result;
	}
	*/

	@Around("execution(* com.kh.aop.weapon.Weapon.attack())")
	public String attackAdvice(ProceedingJoinPoint jp) {
		String result = null;
		
		try {
			System.out.println("공격을 준비중 입니다.");
			
			result = (String) jp.proceed();
			
			System.out.println(result);
			System.out.println("공격을 성공했습니다.");
		} catch (Throwable e) {
			System.out.println("에러가 발생하였습니다..");
		}
		
		return result;
	}
}