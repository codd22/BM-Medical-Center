package codd.major.model;

public class TreatmentModel
{
	private String PatientId;
	private String PhySpeciality;
	private int Price;
	private String LabTest;
	private String Description;
	private String NextAppointent;
	private String Date;
	public String getPatientId() {
		return PatientId;
	}
	public void setPatientId(String patientId) {
		PatientId = patientId;
	}
	public String getPhySpeciality() {
		return PhySpeciality;
	}
	public void setPhySpeciality(String phySpeciality) {
		PhySpeciality = phySpeciality;
	}
	public String getLabTest() {
		return LabTest;
	}
	public void setLabTest(String labTest) {
		LabTest = labTest;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getNextAppointent() {
		return NextAppointent;
	}
	public void setNextAppointent(String nextAppointent) {
		NextAppointent = nextAppointent;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
}
