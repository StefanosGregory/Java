package net.queries.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.classes.PlanBean;
import net.util.DbUtil;

public class PlanDeleteDao {
    private  Connection connection;
    
    public PlanDeleteDao() {
    	connection = DbUtil.getConnection();
    }

	
	  public int delete(PlanBean e){  
	        int status=0;  
	        try{  
	            PreparedStatement ps=connection.prepareStatement("delete from programs where program_id = ? ");
	            ps.setInt(1,e.getPlan());
	            status=ps.executeUpdate();
	            System.out.print(ps);
	        }catch(Exception ex){ex.printStackTrace();}      
	        return status;  
	    }  
	

	  
    public List<PlanBean> getAllPlans(){  
        List<PlanBean> list = new ArrayList<PlanBean>();  
          
        try{  
            PreparedStatement ps=connection.prepareStatement("select * from programs ;");
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){ 
            	
            	PlanBean planBean=new PlanBean();  
            	planBean.setPlan(rs.getInt(1)); 
            	planBean.setSms(rs.getString(2));
            	planBean.setData(rs.getString(3));  
            	planBean.setAirTime(rs.getString(4));  
            	planBean.setPrice(rs.getString(5));  
                list.add(planBean);
                System.out.println("Plan: "+rs.getInt(1));
            }  
 
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
	
}
