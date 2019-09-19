package db_connect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import holders.LogFileHolder;
 

public class FilesServlet extends HttpServlet {
 
	private static String url = "jdbc:mysql://localhost/in_out_log?serverTimezone=Europe/Moscow&useSSL=false";
    private static String username = "root";
    private static String password = "123456";
    
	public static String datetime;
	public static String filename;
	public static String inout;
	
    
    public FilesServlet(String datetime, String filename, String inout) {
    	FilesServlet.datetime = datetime;
    	FilesServlet.filename = filename;
    	FilesServlet.inout = inout;
    }
    
	public static int insert() {
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "INSERT INTO table_emulator (data, filename, folder) Values (?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, datetime);
                    preparedStatement.setString(2, filename);
                    preparedStatement.setString(3, inout);                      
                    return  preparedStatement.executeUpdate();
                }
            }
        } catch(Exception ex){
            System.out.println(ex);
        }
		return 0;
    }
}