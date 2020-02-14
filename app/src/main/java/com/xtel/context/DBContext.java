package com.xtel.context;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBContext {
	public  Connection getConnection() throws Exception {
		String url = null;
		if (instance == null || instance.trim().isEmpty()) {
			url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;
		}
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(url, username, password);
	}
	

	private final String serverName = "localhost";
	private final String portNumber = "1521";
	private final String sid = "orcl";
	private final String instance = "";// LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE
	private final String username = "vietlot";
	private final String password = "hoi1999bac";
}
