package com.teamsupercat.roupangbackend.common;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.concurrent.Semaphore;

@Aspect
@Component
public class ConcurrencyControlAspect {

    private final Semaphore semaphore = new Semaphore(1); // 최대 1개의 스레드 허용

    @Pointcut("execution(* com.teamsupercat.roupangbackend.service.MemberService.*(..))")
    private void serviceMethods() {}

    @Before("serviceMethods()")
    public void beforeServiceMethod(JoinPoint joinPoint) throws InterruptedException {
        System.out.println("메서드 실행이전에 쓰레드 획득");
        semaphore.acquire(); // 스레드 진입을 시도하고, 허용 가능한 수를 넘으면 블록
    }

    @After("serviceMethods()")
    public void afterServiceMethod(JoinPoint joinPoint) {
        System.out.println("메서드 실행이후에 쓰레드 반환");
        semaphore.release(); // 스레드가 메서드 실행을 마치면 Semaphore 해제하여 다음 스레드 진입을 허용
    }
}