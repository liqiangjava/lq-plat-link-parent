package com.lq.plat.link.aspect;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Method;
import java.util.Collection;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/8/15
 */
@Component
@Aspect
public class SysNotifyAspect {

    protected static final Logger LOGGER = LoggerFactory.getLogger(SysNotifyAspect.class);

    @Around("@annotation(com.lq.plat.link.aspect.ServiceSysNotify)")
    public Object sysNotifyInvoke(ProceedingJoinPoint pjp) throws Throwable {
        return doNotify(pjp);
    }



    protected Object doNotify(ProceedingJoinPoint pjp) throws Throwable {
        if(LOGGER.isInfoEnabled()) {
            LOGGER.info("*****调用服务:"+pjp.getSignature().toLongString()+"*****");


            for (Object arg : pjp.getArgs()) {
                printObj(arg, "服务参数:");
            }
            try {
                Object retVal = pjp.proceed();
                printObj(retVal, "返回结果:");

                //返回结果，
                String targetName = pjp.getTarget().getClass().getName();
                String methodName = pjp.getSignature().getName();
                Object[] arguments = pjp.getArgs();
                Class targetClass = Class.forName(targetName);
                Method[] methods = targetClass.getMethods();
                for (Method method : methods) {
                    if (method.getName().equals(methodName)) {
                        Class[] clazzs = method.getParameterTypes();
                        if (clazzs.length == arguments.length) {
                            //事件
                            String event = method.getAnnotation(ServiceSysNotify.class).event();
                            //状态
                            String status = method.getAnnotation(ServiceSysNotify.class).status();




                            break;
                        }
                    }
                }





                return retVal;
            } catch (Throwable e) {
                LOGGER.info("抛出异常", e);
                throw e;
            } finally {
                LOGGER.info("*****调用服务结束*****");
            }
        }
        return pjp.proceed();
    }

    /**
     * 记录参数
     * @param arg
     * @param prefix
     * @author zhailiang
     * @since 2016年12月19日
     */
    @SuppressWarnings("rawtypes")
    void printObj(Object arg, String prefix) {
        if(arg != null) {
            if(arg.getClass().isArray()) {
                if(ArrayUtils.isNotEmpty((Object[]) arg)) {
                    Object[] args = (Object[]) arg;
                    for (Object object : args) {
                        printObj(object, prefix);
                    }
                }
            }else if(arg instanceof Collection) {
                if(CollectionUtils.isNotEmpty((Collection) arg)) {
                    Collection collection = (Collection) arg;
                    for (Object object : collection) {
                        printObj(object, prefix);
                    }
                }
            }

            if(ClassUtils.isPrimitiveOrWrapper(arg.getClass())){
                LOGGER.info(prefix+arg.toString());
            }else if(arg instanceof String) {
                LOGGER.info(prefix+(String)arg);
            }else{
                LOGGER.info(prefix+ ReflectionToStringBuilder.toString(arg));
            }
        }else{
            LOGGER.info(prefix+" null");
        }
    }
}
