package codd.major.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codd.major.dao.MessageDao;
import codd.major.model.MessageModel;


@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//--------------------------
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
		//--------------------------
		
		String Name=request.getParameter("FirstName");
		String Email=request.getParameter("Email");
		String Number=request.getParameter("Number");
		String Message=request.getParameter("Message");
		String Date=dateFormat.format(date);
		
		MessageModel ob1=new MessageModel();
		ob1.setName(Name);
		ob1.setEmail(Email);
		ob1.setNumber(Number);
		ob1.setMessage(Message);
		ob1.setDate(Date);
		
		String sql="insert into Message(Name,Email,Number,Message,Date) values(?,?,?,?,?)";
		MessageDao ob2=new MessageDao();
		String msg=ob2.MessageGet(sql,ob1);
		if(msg.equals("success"))
		{
			System.out.println("get");
			response.sendRedirect("index.jsp");
		}
		else
		{
			System.out.println("error");
			response.sendRedirect("index.jsp");
		}
	}
}
