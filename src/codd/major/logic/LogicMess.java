package codd.major.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import codd.major.dao.DB;

public class LogicMess 
{
	public static ResultSet MessFetch()
	{
		Connection con=DB.Create("majorproject");
		String sql="select * from Message;";
		try{
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		if(rs!=null)
		return rs;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
