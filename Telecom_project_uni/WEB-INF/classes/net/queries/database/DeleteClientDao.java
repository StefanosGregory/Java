package net.queries.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.classes.ClientBean;
import net.util.DbUtil;

public class DeleteClientDao {
    private Connection connection;
    
    public DeleteClientDao() {
    	connection = DbUtil.getConnection();
    }
	
	public int delete(ClientBean e) {
		int status=0;
		try {
			
			PreparedStatement preparedStatement1 = connection.prepareStatement("DELETE FROM BILLS WHERE phone_number= ?");
	        PreparedStatement preparedStatement2 = connection.prepareStatement("DELETE FROM CALLS WHERE phone_number= ?");
			PreparedStatement preparedStatement3 = connection.prepareStatement("DELETE FROM PHONENUMBERS WHERE phone_number= ?");
			PreparedStatement preparedStatement4 = connection.prepareStatement("DELETE FROM CLIENTS WHERE username= ?");
			PreparedStatement preparedStatement5 = connection.prepareStatement("DELETE FROM USERS WHERE username= ?");
										
				preparedStatement1.setString(1, e.getPhoneNumber());
				status = preparedStatement1.executeUpdate();
				System.out.println(preparedStatement1);
				
				preparedStatement2.setString(1, e.getPhoneNumber());
				status = preparedStatement2.executeUpdate();
				System.out.println(preparedStatement2);
				
				preparedStatement3.setString(1, e.getPhoneNumber());
				status = preparedStatement3.executeUpdate();
				System.out.println(preparedStatement3);
				
				preparedStatement4.setString(1, e.getUsername());
				status = preparedStatement4.executeUpdate();
				System.out.println(preparedStatement4);
				
				preparedStatement5.setString(1, e.getUsername());
				status = preparedStatement5.executeUpdate();
				System.out.println(preparedStatement5);												
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return status;
	}
	
    public List<ClientBean> getAllClients(){  
        List<ClientBean> list = new ArrayList<ClientBean>();  
          
        try{   
            PreparedStatement ps=connection.prepareStatement("select * from clients inner join users using (username) where property = 'Client'");
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                ClientBean e=new ClientBean();  
                e.setUsername(rs.getString(1)); 
                e.setPhoneNumber(rs.getString(3));
                e.setName(rs.getString(5));  
                e.setSurname(rs.getString(6));  


                list.add(e);
                System.out.println("Client: "+rs.getString(1));
            }    
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
    
	
	
}
