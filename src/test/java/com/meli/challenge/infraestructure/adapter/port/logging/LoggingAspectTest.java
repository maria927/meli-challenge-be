package com.meli.challenge.infraestructure.adapter.port.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LoggingAspectTest {

    @Mock
    Signature signature;

    @Mock
    ProceedingJoinPoint joinPoint;

    @Mock
    Loggable loggable;

    @InjectMocks
    LoggingAspect aspect;

    @Test
    void logSuccessfulFlowWhenResponseIsOk() throws Throwable {

        Object expectedResult = "mock result";
        String[] args = {"arg1", "arg2"};

        when(signature.toShortString()).thenReturn("loggable");
        when(joinPoint.getSignature()).thenReturn(signature);
        when(joinPoint.getArgs()).thenReturn(args);
        when(joinPoint.proceed()).thenReturn(expectedResult);
        when(loggable.value()).thenReturn("Loggable value");


        Object actualResult = aspect.logMethodExecution(joinPoint, loggable);


        assertEquals(expectedResult, actualResult);
    }

    @Test
    void logSuccessfulFlowWhenResponseHasException() throws Throwable {

        RuntimeException exception = new RuntimeException("error");
        when(signature.toShortString()).thenReturn("loggable");
        when(joinPoint.getSignature()).thenReturn(signature);
        when(joinPoint.getArgs()).thenReturn(new Object[]{});
        when(joinPoint.proceed()).thenThrow(exception);
        when(loggable.value()).thenReturn("Loggable with error");


        RuntimeException thrown = assertThrows(RuntimeException.class,
                () -> aspect.logMethodExecution(joinPoint, loggable));
        assertEquals("error", thrown.getMessage());
    }
}
