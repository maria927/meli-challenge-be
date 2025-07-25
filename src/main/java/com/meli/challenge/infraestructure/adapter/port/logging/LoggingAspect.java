package com.meli.challenge.infraestructure.adapter.port.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("@annotation(loggable)")
    public Object logMethodExecution(ProceedingJoinPoint joinPoint, Loggable loggable) throws Throwable {
        String methodName = joinPoint.getSignature().toShortString();
        logger.info(loggable.value());
        logger.info("Iniciando método: {}", methodName);
        logger.debug("Argumentos: {}", Arrays.toString(joinPoint.getArgs()));

        try {
            Object result = joinPoint.proceed();
            logger.info("Finalizó método: {}", methodName);
            logger.debug("Resultado: {}", result);
            return result;
        } catch (Exception e) {
            logger.error("Excepción en método: {}", methodName, e);
            throw e;
        }
    }
}

