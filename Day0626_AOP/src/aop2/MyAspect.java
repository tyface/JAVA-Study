package aop2;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
	/*
	 * 공통 관심사항 모듈이 작성될 클래스 실제로 작성되는 내용(코드) >> advice advice의 종류 : before : target 수행
	 * 전 실행될 코드 after : target 수행 후 실행될 코드 after-returning : target이 정상적으로 종료 되면 실행될
	 * 코드 after-throwing : target이 비정상적으로 종료 되면 실행될 코드 around : target 앞뒤로 실행 될 코드를
	 * 정의
	 *
	 */

	public void before() {
		System.out.println("지하철을 탑니다.");
	}

	public void after() {
		System.out.println("씻고 잠을 잔다.");
	}

	public void afterReturning() {
		System.out.println("계산하고 집에 온다.");
	}

	public void afterThrowing() {
		System.out.println("하던 일을 멈추고 집에 간다.");
	}

	public void around(ProceedingJoinPoint jp) {
		// 타겟 메서드 실행 전후를 직접 관리

		try {
			before();
			jp.proceed();
			afterReturning();
		} catch (Throwable e) {
			e.printStackTrace();
			afterThrowing();
		} finally {
			after();
		}
	}
}
