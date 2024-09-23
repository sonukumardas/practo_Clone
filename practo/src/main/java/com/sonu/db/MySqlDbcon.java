package com.sonu.db;

import java.sql.Connection;
import java.sql.DriverManager;



public class MySqlDbcon {
	
	public static Connection getDbConnection() {
		Connection connection = null;
		try {
			Class.forName(DbConstants.DRIVER_CLASS);
			connection = DriverManager.getConnection(DbConstants.URL, DbConstants.DB_NAME,DbConstants.DB_PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

}
