package com.codegym.logger;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    @AfterThrowing(pointcut = "execution(public * com.codegym.service.CustomerService.findAll(..))")
    public void log() {

    }
    public void error() {
        System.out.printf("[CMS] ERROR!%n");
    }
}
