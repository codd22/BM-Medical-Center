package codd.major.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import codd.major.dao.LoginDao;
import codd.major.model.LoginModel;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		LoginModel obj=new LoginModel();
		obj.setUsername(username);
		obj.setPassword(password);
		
		String sql="select * from login_table where Username=? and Password=?;";
		String sql1="select DeptName from dept_table where Id=?;";
		
		LoginDao o=new LoginDao();
		String msg=o.validateUser(sql,obj);
		String desg=o.GetDesg(sql1);
		String uname=o.UserName(sql,obj);
		if(msg.equals("success"))
		{	
			HttpSession session=request.getSession();
			session.setAttribute("UNAME",uname);
			session.setAttribute("DESG",desg);
			switch(desg)
			{
			case "Admin":
			response.sendRedirect("adminpanel.jsp");
				break;
			case "Physician":
				session.setAttribute("SPEC",o.GetSpec());//Assign physician Speciality to "SPEC" variable
				response.sendRedirect("physpanel.jsp");
				break;
			case "Lab Assistant":
				response.sendRedirect("labpanel.jsp");
				break;
			case "Front Office Assistant":
				response.sendRedirect("frontpanel.jsp");
				break;
			}
		}
		else
		{
			response.sendRedirect("Login.jsp?error=User Credentials are incorrect");
		}
	}
}
