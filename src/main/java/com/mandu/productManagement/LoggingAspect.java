package com.mandu.productManagement;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//@Aspect is used to annotate that this class is an Aspect
//An aspect is a class that implements cross-cutting concerns. These are the aspects of the application that affect multiple classes.
//@Component is used to indicate that this class is a Spring component
@Aspect
@Component
public class LoggingAspect {

    //In the below line, we are creating a logger object with the name "LoggingAspect"
    //The LoggerFactory.getLogger method is used to get a logger object
    //Syntax for the LoggerFactory.getLogger method is LoggerFactory.getLogger(<class name>.class)
    public static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
    //@Before is used to indicate that this method should be executed before the getAllProducts method is called
    //Syntax for the @Before annotation is @Before("execution(public * <package>.<class>.<method>())")
    @Before("execution(public * com.mandu.productManagement.service.ProductService.getAllProducts())")
    public void logBefore(){
        //In the below line, we are logging a message using the logger object
        LOGGER.info("method called getAllProducts");
    }

    @AfterReturning("execution(public * com.mandu.productManagement.service.ProductService.getAllProducts())")
    public void logAfter(){
        //In the below line, we are logging a message using the logger object
        LOGGER.info("method getAllProducts executed");
    }

    //@AfterThrow is used to indicate that this method should be executed after an exception is thrown in the getAllProducts method
    @AfterThrowing("execution(public * com.mandu.productManagement.service.ProductService.getAllProducts())")
    public void logIssue(){
        //In the below line, we are logging a message using the logger object
        LOGGER.info("Issue in getAllProducts method");
    }
}
