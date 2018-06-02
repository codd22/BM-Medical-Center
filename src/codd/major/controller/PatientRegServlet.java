package codd.major.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codd.major.dao.PatientDao;
import codd.major.logic.LogicCore;
import codd.major.model.PatRegModel;

@WebServlet("/PatientRegServlet")
public class PatientRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PatientRegServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		//+++++++++++++++++++++++ (TASK 1 Generate Local Date)++++++++++++++++++++++++
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		System.out.println(dtf.format(localDate));
		//+++++++++++++++++++++++ (TASK 1 Generate Patient ID)++++++++++++++++++++++++
		String fname=request.getParameter("FName");
		String lname=request.getParameter("LName");
		String patientid=LogicCore.getPatientIdBy(fname, "", lname);
		//+++++++++++++++++++++++ (TASK 1 FETCH ALL VALUES)++++++++++++++++++++++++
		
		String gender=request.getParameter("Gender");
		String dob=request.getParameter("Dob");
		String physicalinjury=request.getParameter("PhyInjury");
		String internalinjury=request.getParameter("IInjury");
		String biologicalinjury=request.getParameter("BInjury");
		String problem=request.getParameter("Problem");
		String phoneno=request.getParameter("PNumber");
		String primaryphysician=request.getParameter("PPhysician");
		String parentname=request.getParameter("PName");
		String relation=request.getParameter("Relation");
		String emailid=request.getParameter("EmailID");
		String address=request.getParameter("Address");
		String country=request.getParameter("Country");
		String state=request.getParameter("State");
		String city=request.getParameter("City");
		String referphysician=request.getParameter("RPhysician");
		String zipcode=request.getParameter("PinCode");
		String date=dtf.format(localDate);
		System.out.println(date);
		
		//++++++++++++++++++++++++++ TASK 2 (SET VALUES INSIDE MODEL CLASS)+++++++++++++++++
		
		PatRegModel obj=new PatRegModel();
		obj.setPatientid(patientid);
		obj.setFname(fname);
		obj.setLname(lname);
		obj.setGender(gender);
		obj.setDob(dob);
		obj.setPhysicalinjury(physicalinjury);
		obj.setInternalinjury(internalinjury);
		obj.setBiologicalinjury(biologicalinjury);
		obj.setProblem(problem);
		obj.setPhoneno(phoneno);
		obj.setPrimaryphysician(primaryphysician);
		obj.setParentname(parentname);
		obj.setRelation(relation);
		obj.setEmailid(emailid);
		obj.setAddress(address);
		obj.setCountry(country);
		obj.setState(state);
		obj.setCity(city);
		obj.setReferphysician(referphysician);
		obj.setZipcode(zipcode);
		obj.setDate(date);
				
		//++++++++++++++++++++++ TASK 3 (CALL DAO) +++++++++++++++++++++++++++++++++++++++++++++++
		
		String sql="insert into patientreg(Patient_Id,First_Name,Last_Name,Gender,Dob,Physical_Injury,Internal_Injury,Biological_Injury,Problem,Phone_No,Primary_Physician,Refer_Physician,Parent_Name,Relation,EmailId,Address,Country,State,City,Zip_Code,Date_Of_Register)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String msg=PatientDao.InsertUser(obj,sql);
		if(msg.equals("success"))
		{
			System.out.println("SUCCESS");
			response.sendRedirect("frontpanel.jsp");
			
		}
		
		
		else
		{
			System.out.println("FAIL");
			response.sendRedirect("PatientReg.jsp");
			
		
		}
		
		
		
		
		
		//++++++++++++++++++++++END OF DATABASE CONNECTION

		}
	}

