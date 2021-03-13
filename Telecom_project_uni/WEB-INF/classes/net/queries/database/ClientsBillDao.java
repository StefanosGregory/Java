package net.queries.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.classes.ClientBean;
import net.util.DbUtil;

public class ClientsBillDao {
    private Connection connection;
	
    public ClientsBillDao() {
    	connection = DbUtil.getConnection();
    }
	
	  public int pay(ClientBean e){  
	        int status=0;  
	        try{  
	            PreparedStatement ps=connection.prepareStatement("update bills set status = '1' where phone_number = ? and month = ? ");
	            ps.setString(1,e.getPhoneNumber());  
	            ps.setInt(2,e.getMonthBill());
	            status=ps.executeUpdate();
	            System.out.print(ps);
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    } 
	
	   public List<ClientBean> getAllClients(){  
	        List<ClientBean> list = new ArrayList<ClientBean>();  
	          
	        try{    
	            PreparedStatement ps=connection.prepareStatement("select * from clients join phonenumbers using (phone_number);");
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	                ClientBean e=new ClientBean();  
	                e.setUsername(rs.getString(2)); 
	                e.setPhoneNumber(rs.getString(1));
	                e.setPlan(rs.getInt(4));
	                list.add(e);
	                System.out.println("Client: "+rs.getString(1));
	            }  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }  
	   
	   public List<ClientBean> getAllStatus(String phone){  
	        List<ClientBean> list = new ArrayList<ClientBean>();  
	          
	        try{  
	            PreparedStatement ps=connection.prepareStatement("select * from bills where phone_number = ? ;");
	            ps.setString(1, phone);
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	                ClientBean e=new ClientBean();  
	                e.setMonthBill(rs.getInt(2));
	                if(rs.getInt(3) == 1) {
	                	e.setStatus("Paid");}
	                else {
	                	e.setStatus("Pending");
	                }
	                
	                list.add(e);
	            } 
	            ps.close();
	            rs.close();
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }
	   
	   public List<ClientBean> getAllCall(String phone, int month){  
	        List<ClientBean> list = new ArrayList<ClientBean>();  
	          
	        try{  
	            PreparedStatement ps=connection.prepareStatement("select * from calls where phone_number = ? and month = ? ;");
	            ps.setString(1, phone);
	            ps.setInt(2, month);
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){
	                ClientBean e=new ClientBean();  	                
	                e.setCall_id(rs.getInt(1));
	                e.setCall_duration(rs.getInt(3)); 
	                list.add(e);
	            }   
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }
	   
	   public List<ClientBean> getAllClientCalls(String phone){  
	        List<ClientBean> list = new ArrayList<ClientBean>();  
	          
	        try{  
	            PreparedStatement ps=connection.prepareStatement("select * from calls where phone_number = ? ;");
	            ps.setString(1, phone);
	            ResultSet rs=ps.executeQuery();
	            while(rs.next()){
	                ClientBean e=new ClientBean();  	                
	                e.setCall_id(rs.getInt(1));
	                e.setMonthBill(rs.getInt(2));
	                e.setCall_duration(rs.getInt(3)); 
	                list.add(e);
	            }   
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }
	   
	   public ClientBean getPhoneNumberByUSername(String Username){
	        ClientBean e = new ClientBean();
	        try{    
	            PreparedStatement ps=connection.prepareStatement("select * from clients where username = ? ;");
	            ps.setString(1, Username);
	            ResultSet rs=ps.executeQuery();
	            if(rs.next()){
	            		e.setPhoneNumber(rs.getString(3));
	            	}
	            System.out.println("Client's phone: "+rs.getString(3));
	        }catch(Exception ex){ex.printStackTrace();}  
	         
	        return e ;  
	    }
}

