package com.neusoft.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Description: 数据库工具类-测试用 可删除
 * 
 * @author: neuedu
 * 
 * @date: 2023-12-06
 * 
 */
public class DBUtils {

	private static String url;
	private static String user;
	private static String pawd;

	// 静态代码块
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// mysql8.x
			// Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 属性类 用来读取属性文件
		Properties p = new Properties();
		try {
			p.load(DBUtils.class.getResourceAsStream("DBConfig.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String host = p.getProperty("host");
		String port = p.getProperty("port");
		String db = p.getProperty("db");
		user = p.getProperty("user");
		pawd = p.getProperty("pawd");
		url = "jdbc:mysql://" + host + ":" + port + "/" + db + "?useUnicode=true&characterEncoding=utf-8";
		// Mysql8
		// url =
		// "jdbc:mysql://"+host+":"+port+"/"+db+"?useSSL=false&serverTimezone=Hongkong&characterEncoding=utf-8&autoReconnect=true";
	}

	/**
	 * @Description: 获取连接的方法
	 * @param: 无
	 * @return: 连接对象
	 * @exception: SQLException
	 */
	public static Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(url, user, pawd);
		return conn;
	}

	/**
	 * @Description: 释放资源的方法(关闭)
	 * @param: 记录集类
	 * @param: 声明类  连接类
	 * @param: 连接类
	 * @return: 无
	 * @exception: SQLException
	 */
	public static void close(ResultSet rs, Statement st, Connection conn) {
		try {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} finally {
			try {
				if (st != null) {
					try {
						st.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static void main(String[] args) throws SQLException {
		System.out.println(getConnection());
	}
}
