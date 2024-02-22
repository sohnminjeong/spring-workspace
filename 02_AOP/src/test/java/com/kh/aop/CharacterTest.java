package com.kh.aop;

import com.kh.aop.character.Character;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
class CharacterTest {
	/*
	 * AOP 용어 정리
	 * 
	 * 1. Aspect(애스펙트)
	 *  - AOP 횡단 관심사(한 애플리케이션의 여러 부분에 공통적으로 사용하고 있는 기능)를 애스펙트라는 특별한 클래스로 모듈화해서 관리한다.
	 *  - 애스펙트는 어드바이스와 포인트 커트를 합친 것이다.
	 *    
	 * 2. JoinPoint(조인 포인트)
	 *  - 어드바이스를 적용할 수 있는 모든 지점을 조인 포인트라고 한다.
	 *  - 즉, 조인 포인트는 애플리케이션 실행에 어드바이스를 끼워 넣을 수 있는 지점(Point)를 말한다.
	 *    (메소드 호출 지점이나 예외 발생, 필드 값 수정 등에 지점을 조인 포인트라 한다.)
	 *    
	 * 3. Advice(어드바이스)
	 *  - 애스펙트가 해야하는 작업을 AOP 용어로 어드바이스라고 한다.
	 *  - 애스펙트가 해야하는 작업(공통적으로 사용하고 있는 기능)과 언제 그 작업을 수행해야 하는지 정의하는 것을 말한다.
	 *  - Spring Aspect는 5 종류의 어드바이스를 가진다.
	 *    before : 어드바이스 대상 메소드가 호출되기 전에 어드바이스 기능을 수행한다.
	 *    after : 결과와 상관없이 어드바이스 대상 메소드가 완료된 후에 어드바이스 기능을 수행한다.
	 *    after-returning : 어드바이스 대상 메소드가 성공적으로 완료된 후에 어드바이스 기능을 수행한다.
	 *    after-throwing : 어드바이스 대상 메소드가 예외를 던진 후에 어드바이스 기능을 수행한다.
	 *    around : 어드바이스 대상 메소드를 감싸서 어드바이스 대상 메소드 호출 전과 후에 어드바이스 기능을 수행한다.
	 * 
	 * 4. PointCut(포인트 커트)
	 *  - 어드바이스가 적용될 조인 포인트의 영역을 좁히는 일을 한다.
	 *  - 어드바이스는 애스펙트가 해야 하는 '작업'과 '언제'그 작업을 수행해야 하는지 정의하는 것이라면 포인트 커트는 '어디에' 어드바이스를 적용할지 정의하는 것이다. 
	 *  - 포인트 커트를 지정하기 위해서는 AspectJ 포인트 커트 표현식을 통해서 지정해 줄 수 있다.
	 * 
	 * 5. Weaving(위빙)
	 *  - 타겟 객체에 에스팩트를 적용해서 새로운 프록시 객체를 생성하는 것을 의미한다.
	 * 
	 * 		컴파일 시간
	 *			타킷 클래스가 컴파일 될 때 애스펙트가 위빙되며, 별도의 컴파일러가 필요하다. 
	 *			AspectJ의 위빙 컴파일러는 이러한 목적으로 사용된다.
	 *		클래스로드 시간
	 *			클래스가 JVM에 로드될 때 애스펙트가 위빙된다.
	 *			애플리케이션에서 사용되기 전에 타깃 클래스의 바이트 코드를 인핸스하는 특별한 ClassLoader가 필요하다.
	 *			AspectJ 5의 로드 시간 위빙(LTW, Load-Time Weaving) 기능을 사용하면 클래스로드 시간에 위빙된다.
	 *			*인핸스 : 바이트코드 엔지니어링 기술에서 많이 사용되는 표현으로, 소스코드가 아닌 컴파일된 바이트 코드에 직접 메소드나 멤버 변수등을 추가하는 것을 말한다.
	 *		실행 시간
	 *			애플리케이션 실행 중에 애스펙트가 위빙된다.
	 *			보통 타깃 객체에 호출을 위임하는 구조의 프록시 객체를 위빙 중에 AOP 컨테이너가 동적으로 만들어 낸다.
	 *			스프링 AOP가 애스펙트가 위빙되는 방식이다.
	 *
	 *	* 어드바이스는 애플리케이션의 여러 객체에 적용해야 할 공통 동작을 정의한 것이고, 
	 *    조인 포인트는 애플리케이션 실행 흐름 내의 모든 지점을 의미하며, 포인트 커트는 어디(어떤 조인포인트)에 어드바이스가 적용돼야 하는지 나타낸다.
	 *    즉, 포인트 커트는 어드바이스 대상이 될 조인 포인트를 정의한 것이다.
	 * 
	 *  * 포인트 커트 표현식
	 *   - 스프링 AOP에서 포인트 커트는 AspectJ의 포인트 커트 표현식을 이용해서 정의한다.
	 *     설명 : 포인트 커트는 애스펙트의 어드바이스를 적용할 조인 포인트를 지정하는 데 사용한다.
	 *   - 스프링 AOP에서 지원되는 AspectJ 포인트 커트 지정자
	 *     execution([접근지정자] 리턴타입 [클래스이름].메소드명(파라미터))
	 *      메소드 실행에 대한 포인트 커드 지정자이다.
	 *      접근 지정자 : public, private 값을 적어준다. (생략 가능)
	 *      리턴 타입 : 메소드의 반환값을 의미한다.
	 *      클래스 이름 : 클래스의 풀 패키지명이 포함된 이름
	 *      " * " : 모든 값을 표현한다.
	 *      " .. " : 0개 이상을 의미한다.
	 *     args() : 대상 메소드에 전달되는 파라미터 값을 어드바이스에 전달하기 위한 지정자이다.
	 *     bean(빈ID) : 어드바이스를 적용할 빈의 ID를 지정할 수 있다.
	 *     @annotation : 주어진 어노테이션을 갖는 조인 포인트를 정의한다.
	 *     
	 */
	
	@Autowired(required = false)
	private Character character;
	
	@Test
	void test() {
	}
	
	@Test
	void create() {		
		assertThat(character).isNotNull();
		assertThat(character.getWeapon()).isNotNull();
	}
	
	@Test
	void questTest() throws Exception {
		assertThat(character.quest("일시점검"));
	}
	
}