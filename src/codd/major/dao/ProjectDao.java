package codd.major.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProjectDao {

	public static  Connection con=DB.Create("majorproject");
	public ResultSet fetchUserPicByEmail(String sql,String email)
	{
		
		ResultSet rs=null;
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,email);
			rs=ps.executeQuery();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rs;
	}
	public ResultSet FetchDetail(String sql,String uname)
	{
		
		ResultSet rs=null;
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,uname);
			rs=ps.executeQuery();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet fetchAllUser(String sql)
	{
		
		ResultSet rs=null;
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
		    rs=ps.executeQuery();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rs;
	}
	public String DeleteUserById(String sql,String id)
	{
		
		
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,id);
		    int i=ps.executeUpdate();
		    if(i==1)
		    {
		    	return "success";
		    }
		    else
		    {
		    	return "fail";
		    }
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return "";
  }
	
	
	
	public static void main(String[] args) {
	
		
		
		

	}

}
