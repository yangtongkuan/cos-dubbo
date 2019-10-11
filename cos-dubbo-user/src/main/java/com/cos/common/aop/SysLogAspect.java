package com.cos.common.aop;

import com.cos.cloud.common.tools.DateUtils;
import com.cos.cloud.user.web.task.SysLogAsyncTask;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class SysLogAspect {

    @Autowired
    private SysLogAsyncTask sysLogAsyncTask;

    /**
     * 配置织入点
     */
    @Pointcut("@annotation(com.cos.cloud.common.ann.SysLog)")
    public void sysLogPointCut() {
    }

    @Around("sysLogPointCut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        long beginTime = DateUtils.getCurrentTimeMillis();
        Object res = joinPoint.proceed();
        sysLogAsyncTask.saveSysLog(joinPoint, request, res, beginTime, DateUtils.getCurrentTimeMillis());
        return res;
    }
}
