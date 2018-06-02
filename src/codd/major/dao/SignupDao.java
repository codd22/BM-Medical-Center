package codd.major.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import codd.major.model.SignupModel;

public class SignupDao 
{ 
	Connection con=DB.Create("majorproject");
	
	public String RegisterData(String sql,SignupModel obj)
	{
		try{
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,obj.getName());
		ps.setString(2,obj.getEmail());
		ps.setInt(3,obj.getDesignation());
		ps.setString(4,obj.getUsername());
		ps.setString(5,obj.getPassword());
		int i=ps.executeUpdate();
		if(i==1)
		{
			return "register";
		}
		}catch(Exception e)
		{
			return "fail";
		}
		return"error";
	}
	
}
