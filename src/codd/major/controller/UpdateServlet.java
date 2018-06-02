package codd.major.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codd.major.dao.UpdateDao;
import codd.major.model.SignupModel;

@WebServlet("/UpdateServlet")
@MultipartConfig(maxFileSize = 16177215)
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
			response.setContentType("text/html");
			
			

			
			 String name=request.getParameter("name");
			 String email=request.getParameter("email");
		     int designation=Integer.parseInt(request.getParameter("designation"));
		     String username=request.getParameter("username");
		     String password=request.getParameter("password");
		     System.out.println(name);
		     System.out.println(email);
		     System.out.println(designation);
		     System.out.println(username);
		     System.out.println(password);
		     
		     
		     SignupModel obj=new SignupModel();
		     obj.setName(name);
		     obj.setEmail(email);
		     obj.setDesignation(designation);
		     obj.setUsername(username);
		     obj.setPassword(password);
		     
		     
		    String sql="update login_table set Name=?,DeptId=?,Username=?,Password=? where EmailId=?";
		     
		    UpdateDao obj1=new UpdateDao();
		    String msg=obj1.UpdateData(sql,obj);
		    if(msg.equals("success"))
		    {
		    	response.sendRedirect("LoginUpdate.jsp");
		    }
		    else
		    {
		    	response.sendRedirect("LoginUpdate.jsp?error=fails");
		    }
		     

		
		
		
	}

}
