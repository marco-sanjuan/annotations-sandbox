package com.marco.annotationssandbox.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.*;

@Aspect
@Component
@Slf4j
public class LogLapseAspect {

    @Around("@annotation(LogLapse)")
    public Object logLapse(ProceedingJoinPoint joinPoint) throws Throwable {

        Instant start = Instant.now();

        Object result = joinPoint.proceed();

        Duration duration = Duration.between(start, Instant.now());
        log.info(">>>  {}: {}", joinPoint.getSignature().getName(),  duration);
        return result;
    }
}
