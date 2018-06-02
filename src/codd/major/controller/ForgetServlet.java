package codd.major.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codd.major.dao.ForgetDao;
import codd.major.logic.logic1;
import codd.major.model.ForgetModel;


@WebServlet("/ForgetServlet")
public class ForgetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ForgetServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String emailid=request.getParameter("emailid");
		
		ForgetModel ob1=new ForgetModel();
		ob1.setUsername1(username);
		ob1.setEmailid(emailid);
		
		String pass=logic1.getSaltString();
		String sql="select * from login_table where Username=? and EmailId=?";
		String sql1="update login_table set Password=? where Username=? and EmailId=?";
		
		ForgetDao ob2=new ForgetDao();
		if(ob2.checked1(sql, ob1))
		{
			if(logic1.send(ob1, pass))
			ob2.PasswordUpdate(pass, sql1, ob1);
			response.sendRedirect("Login.jsp");
		}
		else
		{
			response.sendRedirect("ForgetPage.jsp?error=User credentials are invalid ");
		}
	}
}
