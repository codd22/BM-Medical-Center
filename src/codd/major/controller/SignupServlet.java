package codd.major.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codd.major.dao.SignupDao;
import codd.major.model.SignupModel;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignupServlet() {
        super();
            }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		int designation=Integer.parseInt(request.getParameter("designation"));
		String username=request.getParameter("username");
		String password=request.getParameter("pass");
		
		SignupModel ob1=new SignupModel();
		ob1.setName(name);
		ob1.setEmail(email);
		ob1.setDesignation(designation);
		ob1.setUsername(username);
		ob1.setPassword(password);

		String sql="insert into login_table(Name,EmailId,DeptId,Username,password) values(?,?,?,?,?)";
		SignupDao ob2=new SignupDao();
		String msg=ob2.RegisterData(sql, ob1);
		if(msg.equals("register"))
		{
			response.sendRedirect("adminpanel.jsp");
		}
		else
		{
				out.println("<script type=\"text/javascript\">");
			   out.println("alert('Registration is Incomplete');");
			   out.println("location='SignupNew.jsp';");
			   out.println("</script>");
		}
		out.print("hello");
	}

}
