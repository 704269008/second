package com.jns.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {
    Log log= LogFactory.getLog(LoggerAspect.class);
    public Object logBase(ProceedingJoinPoint joinPoint,String name) throws Throwable {
        long time=System.currentTimeMillis();
        Object object=joinPoint.proceed();
        time=System.currentTimeMillis()-time;
        log.info(name+" "+joinPoint.getSignature().getName()+" run time: "+time+"ms");
        return object;
    }

    @Around(value = "execution(* com.jns.controller.ManagerController.*(..))")
    public Object managerController(ProceedingJoinPoint joinPoint) throws Throwable {
        return logBase(joinPoint,"controller");
    }

    @Around(value = "execution(* com.jns.service.impl.ManagerServiceImpl.*(..))")
    public Object managerService(ProceedingJoinPoint joinPoint) throws Throwable {
        return logBase(joinPoint,"service");
    }

    @Around(value = "execution(* com.jns.controller.PhotoController.*(..))")
    public Object photoController(ProceedingJoinPoint joinPoint) throws Throwable {
        return logBase(joinPoint,"controller");
    }

    @Around(value = "execution(* com.jns.service.impl.PhotoServiceImpl.*(..))")
    public Object photoService(ProceedingJoinPoint joinPoint) throws Throwable {
        return logBase(joinPoint,"service");
    }
}
