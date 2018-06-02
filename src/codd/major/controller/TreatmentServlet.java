package codd.major.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import codd.major.dao.TreatmentDao;
import codd.major.model.TreatmentModel;

@WebServlet("/TreatmentServlet")
public class TreatmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//+++++++++++++++++++++++ (TASK create session object)++++++++++++++++++++++++
		HttpSession session=request.getSession();
		TreatmentModel obj=new TreatmentModel();
		//+++++++++++++++++++++++ (TASK 1 Generate Local Date)++++++++++++++++++++++++
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate localDate = LocalDate.now();
				System.out.println(dtf.format(localDate));
		//+++++++++++++++++++++++ (TASK 2 Get value)++++++++++++++++++++++++		
		 String patientid=request.getParameter("PatientID");
		 String physpeciality=(String) session.getAttribute("SPEC");
		 String labtest=request.getParameter("LabTest");
	     String appointment=request.getParameter("Appointment");
	     String description=request.getParameter("Description");
	     String date=dtf.format(localDate);
	     
	     
	     
	     obj.setPatientId(patientid);
	     obj.setPhySpeciality(physpeciality);
	   //----------------------------[Patient Test Charges]-------------------------------------------------------//
		 String sql1 = "select Charges from physpeciality where Physician_Field=?";
		 int price =TreatmentDao.testPrice(sql1, obj);
		 //---------------------------------------------------------------------------------------------------//

	     obj.setPrice(price);
	     obj.setLabTest(labtest);
	     obj.setNextAppointent(appointment);
	     obj.setDescription(description);
	     obj.setDate(date);
	     
	    String sql="insert into treatment_summary(PId,PhySpec,LabTest,NextApp,Description,Date) values(?,?,?,?,?,?);";
	    String sql2 = "insert into patientcharges(PatientId,Service,Cost) values(?,?,?);"; 
	    TreatmentDao obj1=new TreatmentDao();
	    String msg=obj1.InsertData(sql, obj);
	    if(msg.equals("success"))
	    {	try {
			if((TreatmentDao.insertTestCharges(sql2, obj)).equals("success"))
				response.sendRedirect("physpanel.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    }
	    else
	    {
	    	response.sendRedirect("PhysicianForm.jsp?error=fails");
	    }   
	}

}
