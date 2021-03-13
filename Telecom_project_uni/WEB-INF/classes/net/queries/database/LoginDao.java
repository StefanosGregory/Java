package net.queries.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.util.DbUtil;

import net.classes.LoginBean;


public class LoginDao {
    private Connection connection;

    public LoginDao() {
    	connection = DbUtil.getConnection();
    }
    
    public boolean validate(LoginBean loginBean) throws ClassNotFoundException {

        boolean status = false;

        try  {        	
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where username = ? and password = ? ");
            preparedStatement.setString(1, loginBean.getUsername());
            preparedStatement.setString(2, loginBean.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            printSQLException(e);
        }
        return status;
    }
    
    public String propertyCheck(LoginBean loginBean,String username, String password) throws ClassNotFoundException {
        String property = "";

        try (
            PreparedStatement preparedStatement = connection.prepareStatement("select property from users where username = ? and password = ? ")) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            property = rs.getString(1);
            System.out.println("Property of "+username+": "+property);
            rs.close();
            return property;

        } catch (SQLException e) {
            printSQLException(e);
        }
        return property;
    }

    private void printSQLException(SQLException ex) {
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