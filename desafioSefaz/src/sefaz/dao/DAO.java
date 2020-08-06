package sefaz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO {
	public static Statement stmtObj;
    public static Connection connObj;
    public static ResultSet resultSetObj;
    public static PreparedStatement pstmt;
 
    public static Connection getConnection(){  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");     
            String db_url ="jdbc:mysql://localhost:3306/sgad?useTimezone=true&serverTimezone=UTC",
                    db_userName = "root",
                    db_password = "servidor";
            connObj = DriverManager.getConnection(db_url,db_userName,db_password);  
        } catch(Exception sqlException) {  
            sqlException.printStackTrace();
        }  
        return connObj;
    }
}
