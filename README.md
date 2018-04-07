# 一套 “想当然” 的 IOC 框架

[TOC]

## 1 缘起

> 一直对 java 的自定义注解 还有 spring 的 ioc 理解不深刻， 所以打算实现一个简单的 ioc 目的是用于学习 自定义注解 和 反射。


## 2 实现后的效果

### 2.1 配置 bean
```
package org.ioc.config;

import org.ioc.annotation.Bean;
import org.ioc.annotation.Config;
import org.ioc.pojo.SqlServerJdbcConfig;

/**
 * @Author: huangwenjun
 * @Description:
 * @Date: Created in 17:03  2018/4/4
 **/
@Config
public class DemoConfig {

	@Bean
	public SqlServerJdbcConfig getSqlServerJdbcConfig() {
		return new SqlServerJdbcConfig("root", "123", "url...", "driver...");
	}
}

```

### 2.2 获取 beanMap

> （beanMap中含有 上面配置的实例）

```
public static void main(String[] args) throws Exception {
		System.out.println(ApplicationContext.getBeanMap());
}
```

## 3 思路


```
// 指定扫包路径
// 获取 config  注解的类
// 获取 bean 注解方法， 并且执行放入 beanMap 中
// 调用方法获取实例
```

## 4 包结构图

```
org.ioc
    -- annotation
        -- Bean
        -- Config
    -- config
        -- DemoConfig
    -- pojo
        -- SqlserverJdbcConfig
    -- util
        ClassUtil
        ReflectionUtil
        StringUtil
    ApplicaitonContext
```

## 5 核心 code


```
package org.ioc;

import org.ioc.annotation.Bean;
import org.ioc.annotation.Config;
import org.ioc.util.ClassUtil;
import org.ioc.util.ReflectionUtil;

import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: huangwenjun
 * @Description:
 * @Date: Created in 17:00  2018/4/4
 **/
public class ApplicationContext {

	private static ConcurrentHashMap<String, Object> beanMap = new ConcurrentHashMap<>();

	static {
		initConfigBeanMap();
	}

	/**
	 * 初始化 容器
	 */
	public static void initConfigBeanMap() {
		try {
			Set<Class<?>> classSet = ClassUtil.getClassSet("org.ioc.config");

			for (Class clazz : classSet) {
				if (clazz.isAnnotationPresent(Config.class)) {
					Object beanConfig = ReflectionUtil.newInstance(clazz);
					// 判断是否是配置类
					Method[] methods = clazz.getMethods();

					for(Method method : methods) {
						if (method.isAnnotationPresent(Bean.class)) {
							// 判断是否是 获取 bean 的方法
							Object bean = ReflectionUtil.invokeMethod(beanConfig, method, null);

							if (bean != null) {
								beanMap.put(method.getName(), bean);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ConcurrentHashMap<String, Object> getBeanMap() {
		return beanMap;
	}

	public static void main(String[] args) throws Exception {
		// 指定扫包路径
		// 获取 config  注解的类
		// 获取 bean 注解方法， 并且执行放入 beanMap 中
		// 调用方法获取实例

		System.out.println(ApplicationContext.getBeanMap());
	}
}

```



    





