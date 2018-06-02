package codd.major.model;

public class LabTestModel 
{
private String id;
private String test;
private String physician;
private int price;
private String result;
private String description;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getTest() {
	return test;
}
public void setTest(String test) {
	this.test = test;
}
public String getResult() {
	return result;
}
public void setResult(String result) {
	this.result = result;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getPhysician() {
	return physician;
}
public void setPhysician(String physician) {
	this.physician = physician;
}

}
