package net.queries.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import net.classes.PlanBean;
import net.util.DbUtil;

public class PlanCreateDao {
    private  Connection connection;
	public PlanCreateDao() {
    	connection = DbUtil.getConnection();
	}
	
	public  int PlanCreate(PlanBean planBean) throws ClassNotFoundException{
		int status=0;
		 try (
	            PreparedStatement preparedStatement  = connection.prepareStatement("INSERT INTO programs ( sms, data, speech_time, price) VALUES (?,?,?,?)");
	            ){

			 	preparedStatement.setString(1, planBean.getSms());
	            preparedStatement.setString(2, planBean.getData()+"MB");
	            preparedStatement.setString(3, planBean.getAirTime()+"'");
	            preparedStatement.setString(4, planBean.getPrice());			 		            

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
