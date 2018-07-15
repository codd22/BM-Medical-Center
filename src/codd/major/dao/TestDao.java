package codd.major.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import codd.major.model.LabTestModel;

import java.sql.PreparedStatement;

public class TestDao
{
static Connection con=DB.Create("majorproject");
	public static String Insert(String sql,LabTestModel obj) throws SQLException
	{
		try
		{
		PreparedStatement ps=(PreparedStatement)con.prepareStatement(sql);
		ps.setString(1,obj.getId());
		ps.setString(2,obj.getTest());
		ps.setString(3,obj.getPhysician());
		ps.setString(4,obj.getResult());
		ps.setString(5,obj.getDescription());
		int i=ps.executeUpdate();
		if(i==1)
			return "success";
		}catch(Exception e)
		{
			System.out.println(e.getMessage()+" TestDao Insert");
			return "fails";
		}
		return "fails";
		
	}
	
	public static int testPrice(String sql,LabTestModel obj){
		try
		{
		PreparedStatement ps=(PreparedStatement)con.prepareStatement(sql);
		ps.setString(1,obj.getTest());
		ResultSet rs=ps.executeQuery();
		if(rs.next())
			return rs.getInt(1);
		}catch(Exception e)
		{
			System.out.println(e.getMessage()+" TestDao testPrice");
			return (Integer) null;
		}
		return (Integer) null;
	}
	
	public static String insertTestCharges(String sql,LabTestModel obj) throws SQLException
	{
		try
		{
		PreparedStatement ps=(PreparedStatement)con.prepareStatement(sql);
		ps.setString(1,obj.getId());
		ps.setString(2,obj.getTest());
		ps.setInt(3,obj.getPrice());
		int i=ps.executeUpdate();
		if(i==1)
			return "success";
		}catch(Exception e)
		{
			System.out.println(e.getMessage()+" TestDao insertTestCharges");
			return "fails";
		}
		return null;
		
	}
}
