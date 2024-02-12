package by.SpringBoot.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Component
@Aspect
public class LoginAspect {

    Logger logger = Logger.getLogger(LoginAspect.class.getName());
    @Around("@annotation(by.SpringBoot.annotation.ToLog)")
    public Object loginfo1(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        logger.info("Name method: " + methodName + " args: " + Arrays.asList(arguments));
        Object procced = joinPoint.proceed();
        logger.info("arguments after method call: " + procced);
        return procced;
    }
    @Around("execution(* by.SpringBoot.service.*.*(..))")
    public Object loginfo2(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long end = System.currentTimeMillis();
        logger.info("method running time "+methodName+": "+(end - start)+" ms");
        return proceed;
    }
}
