package net.queries.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.classes.ClientBean;
import net.util.DbUtil;

public class EditClientDao {
    private  Connection connection;
    
    public EditClientDao() {
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
	            PreparedStatement ps1=connection.prepareStatement("update clients set program_id = ? where username = ? "); 
	            ps1.setInt(1, e.getPlan());
	            ps1.setString(2, e.getUsername());
	            status=ps.executeUpdate();
	            status=ps1.executeUpdate();  
	            System.out.print(ps);
	            System.out.println(ps1);
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	
	  public ClientBean getCleintByUsername(String username){  
	        ClientBean e = new ClientBean();  
	          
	        try{  
	            PreparedStatement ps=connection.prepareStatement("select * from clients inner join users using (username) where username = ? ");  
	            ps.setString(1,username);  
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	            	 e.setUsername(rs.getString(1)); 
	                 e.setAfm(rs.getFloat(2));
	                 e.setPhoneNumber(rs.getString(3));
	                 e.setPlan(rs.getInt(4));
	                 e.setName(rs.getString(5));  
	                 e.setSurname(rs.getString(6));  
	                 e.setPassword(rs.getString(7));  
	                 e.setProperty(rs.getString(8));
	            }   
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return e;  
	    }  
	  
    public List<ClientBean> getAllClients(){  
        List<ClientBean> list = new ArrayList<ClientBean>();  
          
        try{  
            PreparedStatement ps=connection.prepareStatement("select * from clients inner join users using (username) where property = 'Client'");
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                ClientBean e=new ClientBean();  
                e.setUsername(rs.getString(1)); 
                e.setAfm(rs.getFloat(2));
                e.setPhoneNumber(rs.getString(3));
                e.setPlan(rs.getInt(4));
                e.setName(rs.getString(5));  
                e.setSurname(rs.getString(6));  
                e.setPassword(rs.getString(7));  
                e.setProperty(rs.getString(8)); 

                list.add(e);
                System.out.println("Client: "+rs.getString(1));
            }  
 
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
	
}
