package codd.major.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import codd.major.dao.TestDao;
import codd.major.model.LabTestModel;

@WebServlet("/LabTestServlet")
public class LabTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LabTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		LabTestModel obj=new LabTestModel();
	String id=session.getAttribute("Pid").toString();
	String physician=request.getParameter("PhyName");
	String test=request.getParameter("TestName");
	String result=request.getParameter("Result");
	String description=request.getParameter("Description");
	
	obj.setId(id);
	obj.setTest(test);
	//----------------------------[Patient Test Charges]-------------------------------------------------------//
		 String sql1 = "select Test_Price from lab_test where Test_Name=?";
		 int price =TestDao.testPrice(sql1, obj);
	//---------------------------------------------------------------------------------------------------//
	obj.setPhysician(physician);	 
	obj.setPrice(price);
	obj.setResult(result);
	obj.setDescription(description);
	String sql="insert into LabTestData(Pid,Test,Physician,Result,Description) values(?,?,?,?,?);";
	String sql2 = "insert into patientcharges(PatientId,Service,Cost) values(?,?,?);";
	try {
		String msg=TestDao.Insert(sql, obj);
		if(msg.equals("success"))
			if((TestDao.insertTestCharges(sql2, obj)).equals("success"))
			response.sendRedirect("labpanel.jsp");
		else
			response.sendRedirect("LabTestPanel.jsp");
	}
	catch (SQLException e) 
	{
			e.printStackTrace();
	}
	
	}

}
