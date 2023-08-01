package util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionFactory {
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/db_TodoApp";
    public static final String USER = "root";
    public static final String PASS = "Leticia2205!";
    
    public static Connection getConnection() {
	Connection connection = null;
		
	try {
            Class.forName(DRIVER);
	} catch (ClassNotFoundException e) {
            e.printStackTrace();
	}
		
	try {
            connection = DriverManager.getConnection(URL, USER, PASS);
	} catch (SQLException e) {
            e.printStackTrace();
	}
		
	return connection;
    }
    
    public static void closeConnection(Connection connection) {
        try {
            if(connection != null) {
                connection.close();
            }
        } catch(Exception e) {
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados.");
        }
    }
    
    public static void closeConnection(Connection connection, PreparedStatement statement) {
        try {
            if(connection != null) {
                connection.close();
            }
            if(statement != null) {
                statement.close();
            }
        } catch(Exception e) {
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados.");
        }
    }
    
    public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultset) {
        try {
            if(connection != null) {
                connection.close();
            }
            if(statement != null) {
                statement.close();
            }
            if(resultset != null) {
                resultset.close();
            }
        } catch(Exception e) {
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados.");
        }
    }
}
