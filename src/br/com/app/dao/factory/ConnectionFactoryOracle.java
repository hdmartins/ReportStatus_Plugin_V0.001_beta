package br.com.app.dao.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactoryOracle 
{
	private Connection connDbOracle = null ;
	private static final String urlOracleXE  = "jdbc:oracle:thin:@//localhost:1521/xe";
	private static final String userOracleXE = "contrPedidos";
	private static final String passOracleXE = "QWEasd123";
	
	public ConnectionFactoryOracle() throws SQLException 
	{
		// TODO Auto-generated constructor stub
		System.out.println("Conecatando na base : "+urlOracleXE);
		this.connDbOracle = DriverManager.getConnection(urlOracleXE, userOracleXE, passOracleXE);
	}
	
	public Connection getConnection() 
	{
		return this.connDbOracle;
	}
	
	public void closeConnection(Connection c) throws SQLException
	{
		c.close();
	}

}
