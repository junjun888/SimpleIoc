package org.ioc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: huangwenjun
 * @Description:
 * @Date: Created in 17:02  2018/4/4
 **/
@Retention(RetentionPolicy.RUNTIME)//保留时间长短
@Target(value = {ElementType.METHOD})//使用范围 方法
public @interface Bean {
}
