package codd.major.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import codd.major.model.ForgetModel;

public class ForgetDao 
{
	/*public static  String jdbcurl="jdbc:mysql://localhost:3306/majorpro";
	public static  String driver="com.mysql.jdbc.Driver";
	public static  String mysqlusername="root";
	public static  String mysqlpassword="tiger";*/
	
	public static Connection con=DB.Create("majorproject");

	
	/*static 
	{
		try
		{
			Class.forName(driver);
			con=DriverManager.getConnection(jdbcurl, mysqlusername, mysqlpassword);
		    System.out.println("connected");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		
	}*/
	
	//----method for checking
	public boolean checked1(String sql,ForgetModel obj)
    {   boolean b1=false;
        try 
        {
        	PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
            ps.setString(1,obj.getUsername1());
            ps.setString(2,obj.getEmailid());
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
               b1=true; 
            }
        }catch(Exception e)
            {
            	b1=false;
            }
        return b1;
    }
	
	//---------Password Update Method
    public String PasswordUpdate(String pass,String sql,ForgetModel obj)
    {
      try
      {
    	  PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
          ps.setString(1,pass);
          ps.setString(2,obj.getUsername1() );
          ps.setString(3,obj.getEmailid());
          int i=ps.executeUpdate();
          if(i==1)
          {
        	  return "Update";
          }
          else
          {
        	  return "Fail";
          }
      }catch(Exception e)
      {
    	  return "error"+e.getMessage();
      }
    }

}
