package net.queries.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.classes.ClientBean;
import net.util.DbUtil;

public class EditSellerDao {
    private  Connection connection;
    
    public EditSellerDao() {
    	connection = DbUtil.getConnection();
    }

	
	  public  int update(ClientBean e){  
	        int status=0;  
	        try{  
	            PreparedStatement ps=connection.prepareStatement("update users set name = ?, surname = ?, password = ? where username = ? ");
	            ps.setString(1,e.getName());  
	            ps.setString(2,e.getSurname());
	            ps.setString(3,e.getPassword());
	            System.out.println( e.getUsername());
	            ps.setString(4, e.getUsername());
	            status=ps.executeUpdate();
	            System.out.print(ps);
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	
	  public ClientBean getSellerByUsername(String username){  
	        ClientBean e = new ClientBean();  
	          
	        try{  
	            PreparedStatement ps=connection.prepareStatement("select * from users where username = ? ");  
	            ps.setString(1,username);  
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	            	 e.setUsername(rs.getString(1));             
	                 e.setName(rs.getString(2));  
	                 e.setSurname(rs.getString(3));  
	                 e.setPassword(rs.getString(4));  
	                 e.setProperty("Seller");
	            }   
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return e;  
	    }  
	  
    public List<ClientBean> getAllSellers(){  
        List<ClientBean> list = new ArrayList<ClientBean>();  
          
        try{  
            PreparedStatement ps=connection.prepareStatement("select * from users where property = 'Seller'");
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                ClientBean e=new ClientBean();  
                e.setUsername(rs.getString(1)); 
                e.setName(rs.getString(2));  
                e.setSurname(rs.getString(3));  
                e.setPassword(rs.getString(4));  
                e.setProperty("Seller"); 

                list.add(e);
                System.out.println("Seller: "+rs.getString(1));
            }  
 
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
	
}
