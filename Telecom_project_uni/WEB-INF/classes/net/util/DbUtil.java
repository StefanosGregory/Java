package net.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DbUtil {

    private static Connection connection = null;
    
    public static Connection getConnection() {
        if (connection != null)
            return connection;
    else {
    	try {
            Class.forName("com.mysql.jdbc.Driver");
       		 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbphonemanager?useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false", "root", "$99281928Stef$");

    	}catch(Exception e) {
            e.printStackTrace();
    }
    	return connection;
    }
  }
    
}
