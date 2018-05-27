package com.terrabird.aspect;

/**
 * @author Praveer Das
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author Praveer Das
 */
@Aspect
@Configuration
public class LoggingAspect {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.terrabird.dao.ServiceTypeDAO.*(..))")
    public void logBeforeDAOMethods() {}
    @Pointcut("execution(* com.terrabird.dao.ServiceTypeDAO.*(..))")
    public void logAfterDAOMethods() {}


    @Before("logBeforeDAOMethods()")
    public void logEntryAdvice(JoinPoint joinPoint) {
        log.info(joinPoint.getTarget().getClass().getName() + " :: " + joinPoint.getSignature().getName());
        log.info("Agruments Passed=" + Arrays.toString(joinPoint.getArgs()));
    }

    @After("logAfterDAOMethods()")
    public void logExitAdvice(JoinPoint joinPoint) {
        log.info(joinPoint.getTarget().getClass().getName() + " :: " + joinPoint.getSignature().getName() + " exited.");
    }

}
