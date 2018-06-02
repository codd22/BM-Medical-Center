package codd.major.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/InvoiceServlet")
public class InvoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InvoiceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Pid = request.getParameter("Pid");
		HttpSession session=request.getSession();
		session.setAttribute("PId",Pid);
		response.sendRedirect("Invoice1.jsp");
	}

}
