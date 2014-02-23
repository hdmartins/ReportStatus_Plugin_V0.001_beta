package br.com.app.dao.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactorySQLite 
{
	private Connection connDbSQLite = null ;
	private static String urlSQLite = "jdbc:sqlite:C:\\Eclipse\\Database\\ReportStatus_v0.01_beta.db3";
	
	public ConnectionFactorySQLite() throws SQLException
	{
		// TODO Auto-generated constructor stub
		this.connDbSQLite = DriverManager.getConnection(urlSQLite);
	}
	
	public Connection getConnDB() 
	{
		return this.connDbSQLite;
	}
	
	public void closeConnDB(Connection connection) throws SQLException 
	{
		connection.close();
	}
}
