package net.queries.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.classes.ClientBean;
import net.util.DbUtil;

public class SellerRegisterDao {
    private Connection connection;
	public SellerRegisterDao() {
		connection = DbUtil.getConnection();
	}
	
	public  int RegisterSeller(ClientBean registerBean) throws ClassNotFoundException{
		int status=0;
		 try (
	            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO USERS (username, name, surname, password, property) VALUES (?,?,?,?,'Seller')");		
	            ){
			 	//TABLE USERS
			 	preparedStatement.setString(1, registerBean.getUsername());
	            preparedStatement.setString(2, registerBean.getName());
	            preparedStatement.setString(3, registerBean.getSurname());
	            preparedStatement.setString(4, registerBean.getPassword());			 		            
	            
	            System.out.println(preparedStatement);
	            status = preparedStatement.executeUpdate();            	          
	            
		 }catch(SQLException e){
			 printSQLException(e);
		 }
		return status;
	}
	private static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
