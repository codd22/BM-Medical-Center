package codd.major.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import codd.major.model.SignupModel;

public class UpdateDao 
{
	Connection con=DB.Create("majorproject");
	
	public String UpdateData(String sql,SignupModel obj)
	{
		try{
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,obj.getName());
		ps.setInt(2,obj.getDesignation());
		ps.setString(3,obj.getUsername());
		ps.setString(4,obj.getPassword());
		ps.setString(5,obj.getEmail());
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
