package org.shinomin.menjin.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App01
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Connection conn = null;
		String url = "jdbc:jtds:sqlserver://192.168.2.3:1433/menjin";
		String username = "test1";
		String password = "123456";
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		conn = DriverManager.getConnection(url, username, password);
		conn.close();
		// jdbc:jtds:<server_type>://<server>[:<port>][/<database>][;<property>=<value>[;...]]

	}
}
