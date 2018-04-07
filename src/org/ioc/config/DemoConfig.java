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
