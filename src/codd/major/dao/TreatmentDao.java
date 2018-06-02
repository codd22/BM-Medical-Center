package codd.major.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import codd.major.model.TreatmentModel;

public class TreatmentDao
{
	static Connection con=DB.Create("majorproject");
	
	public String InsertData(String sql,TreatmentModel obj)
	{
		try{
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,obj.getPatientId());
		ps.setString(2,obj.getPhySpeciality());
		ps.setString(3,obj.getLabTest());
		ps.setString(4,obj.getNextAppointent());
		ps.setString(5,obj.getDescription());
		ps.setString(6,obj.getDate());
		int i=ps.executeUpdate();
		if(i==1)
		{
			return "success";
		}
		}catch(Exception e)
		{
			System.out.println(e.getMessage()+"TreatmentDao InsertData");
			return "fails";
		}
		return"fails";
	}
	
	public static ResultSet FetchData1(String sql,String id)
	{
		try{
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,id);
		ResultSet rs=ps.executeQuery();
		if(rs!=null)
		return rs;
		}catch(Exception e)
		{
			System.out.println(e.getMessage()+"TreatmentDao FetchData1");
		}
		return null;
	}
	
	public static int testPrice(String sql,TreatmentModel obj){
		try
		{
		PreparedStatement ps=(PreparedStatement)con.prepareStatement(sql);
		ps.setString(1,obj.getPhySpeciality());
		ResultSet rs=ps.executeQuery();
		if(rs.next())
			return rs.getInt(1);
		}catch(Exception e)
		{
			System.out.println(e.getMessage()+"TreatmentDao testPrice");
			return (Integer) null;
		}
		return (Integer) null;
	}
	
	public static String insertTestCharges(String sql,TreatmentModel obj) throws SQLException
	{
		try
		{
		PreparedStatement ps=(PreparedStatement)con.prepareStatement(sql);
		ps.setString(1,obj.getPatientId());
		ps.setString(2,obj.getPhySpeciality());
		ps.setInt(3,obj.getPrice());
		int i=ps.executeUpdate();
		if(i==1)
			return "success";
		}catch(Exception e)
		{
			System.out.println(e.getMessage()+"TreatmentDao insertTestCharges");
			return "fail";
		}
		return null;
		
	}

}
