package com.lq.plat.link.aspect;

import java.lang.annotation.*;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/8/15
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServiceSysNotify {

     String event() default ""; //业务事件
     String status() default ""; //事件状态

}
