package com.xy.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Slf4j
@Component
public class LogAspectAop {

    // 可通过自定义注解或者使用requestMapping注解进行接口出入参拦截
    @Pointcut("@annotation(com.xy.aop.LogAspect) || @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void annotationPointcut() {

    }

    @Before("annotationPointcut()")
    public void beforePointcut(JoinPoint joinPoint) {
        log.info("请求开始 {}, 入参参数:{}", requestUrl(), joinPoint.getArgs());
    }

    /**
     * 在切入点return内容之后切入内容（可以用来对处理返回值做一些加工处理）
     *
     * @param joinPoint
     */
    @AfterReturning(value = "annotationPointcut()", returning = "returnVal")
    public void doAfterReturning(JoinPoint joinPoint, Object returnVal) {
        log.info("请求结束 {}, 响应参数:{}", requestUrl(), returnVal);
    }

//    private void commonLog(JoinPoint joinPoint) {
//        // 接收到请求，记录请求内容／
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//
//        // 记录下请求内容
//        log.info("请求地址 : {}", request.getRequestURL().toString());
//        log.info("HTTP METHOD : {}", request.getMethod());
//        log.info("CLASS_METHOD : {}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//    }

    private String requestUrl() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        return request.getRequestURL().toString();
    }
}
