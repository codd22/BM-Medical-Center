package codd.major.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import codd.major.model.MessageModel;

public class MessageDao
{	
	Connection con=DB.Create("majorproject");

	public String MessageGet(String sql,MessageModel obj)
	{
		try{
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,obj.getName());
		ps.setString(2,obj.getEmail());
		ps.setString(3,obj.getNumber());
		ps.setString(4,obj.getMessage());
		ps.setString(5,obj.getDate());
		int i=ps.executeUpdate();
		if(i==1)
		{
			return "success";
		}
		}catch(Exception e)
		{
			return "fail";
		}
		return"error";
	}
	

}
