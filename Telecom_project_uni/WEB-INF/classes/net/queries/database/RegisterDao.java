package net.queries.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import net.classes.ClientBean;
import net.util.DbUtil;

public class RegisterDao {
    private  Connection connection;
	public RegisterDao() {
    	connection = DbUtil.getConnection();
	}
	
	public  int RegisterClient(ClientBean registerBean) throws ClassNotFoundException{
		int status=0;
		 try (
	            PreparedStatement preparedStatement  = connection.prepareStatement("INSERT INTO USERS (username, name, surname, password, property) VALUES (?,?,?,?,'Client')");
				PreparedStatement preparedStatement2 = connection.prepareStatement ("INSERT INTO CLIENTS(username, afm, phone_number, program_id) VALUES (?,?,?,?)");
				PreparedStatement preparedStatement3 = connection.prepareStatement ("INSERT INTO PHONENUMBERS(phone_number, area, type) VALUES (?,?,'Cellphone')");
	            ){
			 	//TABLE USERS
			 	preparedStatement.setString(1, registerBean.getUsername());
	            preparedStatement.setString(2, registerBean.getName());
	            preparedStatement.setString(3, registerBean.getSurname());
	            preparedStatement.setString(4, registerBean.getPassword());			 		            
	            //TABLE CLIENTS
	            preparedStatement2.setString(1, registerBean.getUsername());
	            preparedStatement2.setFloat(2, registerBean.getAfm());
	            preparedStatement2.setString(3, registerBean.getPhoneNumber());
	            preparedStatement2.setInt(4, registerBean.getPlan());
	            //TABLE PHONENUMBERS
	            preparedStatement3.setString(1, registerBean.getPhoneNumber());
	            preparedStatement3.setString(2, registerBean.getArea());
	            
	            System.out.println(preparedStatement);
	            System.out.println(preparedStatement2);
	            System.out.println(preparedStatement3);
	            status = preparedStatement.executeUpdate();
	            status = preparedStatement2.executeUpdate();
	            status = preparedStatement3.executeUpdate();	            	            	          
	            
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
