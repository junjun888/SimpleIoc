package org.ioc.pojo;

/**
 * @Author: huangwenjun
 * @Description:
 * @Date: Created in 17:03  2018/4/4
 **/
public class SqlServerJdbcConfig {

	private String username;

	private String password;

	private String url;

	private String driver;

	public SqlServerJdbcConfig(String username, String password, String url, String driver) {
		this.username = username;
		this.password = password;
		this.url = url;
		this.driver = driver;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}
}
