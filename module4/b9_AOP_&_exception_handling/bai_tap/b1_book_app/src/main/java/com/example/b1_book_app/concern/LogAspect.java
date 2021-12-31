package com.example.b1_book_app.concern;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.logging.Logger;

@Aspect
@Component
public class LogAspect {
    //aspect ->advice -> pointcut -> joinPoint
    private Logger logger = Logger.getLogger(LogAspect.class.getName());
    private static int action;

    @AfterReturning("execution(* com.example.bookloanapp.service.BookService.save(..))")
    public void getBookLogAfterRunning(JoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info("End call " + methodName);
        logger.info("Trạng thái " + LocalDateTime.now());
    }

    @AfterReturning("execution(* com.example.bookloanapp.service.*.*(..))")
    public void getLibraryLogAfterRunning(JoinPoint joinPoint) throws Throwable {
        action++;
        String methodName = joinPoint.getSignature().getName();
        logger.info("End call " + methodName);
        logger.info("Số lượng " + action);
    }
}
