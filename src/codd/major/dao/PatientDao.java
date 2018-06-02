package codd.major.dao;

import java.sql.Connection;

import codd.major.model.PatRegModel;

import com.mysql.jdbc.PreparedStatement;

public class PatientDao
{
	public static  Connection con=DB.Create("majorproject");
	public static String InsertUser(PatRegModel obj,String sql)
	{
		try
		{
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ps.setString(1,obj.getPatientid());
			ps.setString(2,obj.getFname());
			ps.setString(3, obj.getLname());
			ps.setString(4, obj.getGender());
			ps.setString(5, obj.getDob());
			ps.setString(6,obj.getPhysicalinjury());
			ps.setString(7, obj.getInternalinjury());
			ps.setString(8, obj.getBiologicalinjury());
			ps.setString(9,obj.getProblem());
			ps.setString(10, obj.getPhoneno());
			ps.setString(11, obj.getPrimaryphysician());
			ps.setString(12,obj.getReferphysician());
			ps.setString(13,obj.getParentname());
			ps.setString(14, obj.getRelation());
			ps.setString(15, obj.getEmailid());
			ps.setString(16, obj.getAddress());
			ps.setString(17, obj.getCountry());
			ps.setString(18, obj.getState());
			ps.setString(19, obj.getCity());
			ps.setString(20, obj.getZipcode());
			ps.setString(21,obj.getDate());
			
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
			System.out.println(e.toString());
			
		}
		
		return "error";
	}
}
