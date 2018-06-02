package codd.major.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import codd.major.model.LoginModel;

public class LoginDao 
{
	public String uname;
	public int deptid;
	public String email;
	ResultSet rs;
	public static  Connection con=DB.Create("majorproject");
//-----------------------------[method to validate login user]-----------------------------------//
	public String validateUser(String sql,LoginModel obj)
	{
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,obj.getUsername());
			ps.setString(2,obj.getPassword());
			rs=ps.executeQuery();
			if(rs.next())
			{
				deptid=rs.getInt(3);
				email=rs.getString(2);
				return "success";
			}
			else
			{
				return "fails";
			}
		}catch(Exception e)
		{
		System.out.println(e.getMessage()+"LoginDao validateUser");
		}
		return "fails";
	}

	//-----------------------------[]-----------------------------------//	
	public String getSpec(LoginModel obj){
		try
		{
			PreparedStatement ps=con.prepareStatement("select speciality from specialitydesc,login_table where specialitydesc.emailid=login_table.EmailId and Username=? and Password=?;");
			ps.setString(1,obj.getUsername());
			ps.setString(2,obj.getPassword());
			rs=ps.executeQuery();
			if(rs.next())
			{
				return rs.getString(1);
			}
			else
			{
				return "fails";
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage()+"LoginDao getSpec");
		}
		return "fails";
		
	}
	
	//-----------------------------[method to get Designation name]-----------------------------------//	
	public String GetDesg(String sql)
	{
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, deptid);
			rs=ps.executeQuery();
			if(rs.next())
			{
				return rs.getString(1);
			}
			else
			{
				return "fails";
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage()+"LoginDao GetDesg");
		}
		return "fails";
	}
	
	//-----------------------------[method to get Physician Speciality]-----------------------------------//	
	public String GetSpec()
	{
		try
		{
			PreparedStatement ps=con.prepareStatement("select physpeciality.Physician_Field from list,physpeciality where list.SpecialityId=physpeciality.Id and list.emailid=?;");
			ps.setString(1,email);
			rs=ps.executeQuery();
			if(rs.next())
			{
				return rs.getString(1);
			}
			else
			{
				return "fails";
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage()+"LoginDao GetSpec");
		}
		return "fails";
	}
	
	//-----------------------------[method to get user name ]-----------------------------------//	
	public String UserName(String sql,LoginModel obj)
	{
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,obj.getUsername());
			ps.setString(2,obj.getPassword());
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				uname=rs.getString(1);
				return uname;
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage()+"LoginDao UserName");
		}
		return "fails";
	}
	
}
