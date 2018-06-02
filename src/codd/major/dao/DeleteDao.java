package codd.major.dao;

import java.sql.Connection;

import com.mysql.jdbc.PreparedStatement;

public class DeleteDao 
{
	public String DeleteUserById(String sql,String id)
	{
		Connection con=DB.Create("majorproject");
		try
		{
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
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

}
