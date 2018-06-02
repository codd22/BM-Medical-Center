package codd.major.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codd.major.dao.DeleteDao;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String msg=null;
	 DeleteDao obj=new DeleteDao();	
     String[] id=request.getParameterValues("id");
    	 String sql="delete from login_table where EmailId=?";
    	 System.out.println(id[0]);
    	 msg=obj.DeleteUserById(sql,id[0]);
     if(msg.equals("success"))
	    {
	    	response.sendRedirect("LoginDelete.jsp");
	    }
	    else
	    {
	    	response.sendRedirect("LoginDelete.jsp?error=fails");
	    }
     		
		
	}

}
