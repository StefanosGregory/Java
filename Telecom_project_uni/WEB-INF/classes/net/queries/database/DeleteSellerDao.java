package net.queries.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.classes.ClientBean;
import net.util.DbUtil;

public class DeleteSellerDao {
    private Connection connection;
    
    public DeleteSellerDao() {
    	connection = DbUtil.getConnection();
    }
	
	public int delete(ClientBean e) {
		int status=0;
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM USERS WHERE username= ?");														
				preparedStatement.setString(1, e.getUsername());
				status = preparedStatement.executeUpdate();
				System.out.println(preparedStatement);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return status;
	}
	
    public List<ClientBean> getAllSellers(){  
        List<ClientBean> list = new ArrayList<ClientBean>();  
          
        try{   
            PreparedStatement ps=connection.prepareStatement("select * from users  where property = 'Seller'");
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                ClientBean e=new ClientBean();  
                e.setUsername(rs.getString(1)); 
                e.setName(rs.getString(2));  
                e.setSurname(rs.getString(3));  
                list.add(e);
                System.out.println("Seller: "+rs.getString(1));
            }    
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
    
	
	
}
