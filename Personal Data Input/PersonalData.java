package Act6;

public class PersonalData {
String firstname; 
String middleintial;
String lastname;
int age;
String gender;
String birthdate;
String birthplace;
String religion;
String civilstatus;

String street;
String city;
String province;
String email;
String contact;

String SSS;
String Tin;
String pagibig;
String philhealth;
	
	
	
PersonalData(String firstname, String middleintial, String lastname, int age, String gender,
			String birthdate, String birthplace, String religion, String civilstatus, String street, String city,
			String province, String email, String contact, String sSS, String tin, String pagibig, String philhealth) {
	
		this.firstname = firstname;
		this.middleintial = middleintial;
		this.lastname = lastname;
		this.age = age;
		this.gender = gender;
		this.birthdate = birthdate;
		this.birthplace = birthplace;
		this.religion = religion;
		this.civilstatus = civilstatus;
		
		this.street = street;
		this.city = city;
		this.province = province;
		this.email = email;
		this.contact = contact;
		
		this.SSS = sSS;
		this.Tin = tin;
		this.pagibig =pagibig;
		this.philhealth = philhealth;
	}

public void PrintPersonalData() {
	System.out.println();
	System.out.println(
"---------------------------------------PERSONAL DATA---------------------------------------");
	System.out.println("Name: " + firstname + " " + middleintial + " " + lastname);
	System.out.println("Age: " + age);
	System.out.println("Gender: " + gender);
	System.out.println("Date of Birth: " + birthdate);
	System.out.println("Place of Birth: " + birthplace);
	System.out.println("Religion: " + religion);
	System.out.println("Civil Status: " + civilstatus);
	
	System.out.println();
	
	System.out.println(
"---------------------------------------CONTACT INFORMATION---------------------------------------");
	System.out.println("Address: " + street + " " + city + " " + province);
	System.out.println("Email: " + email);
	System.out.println("Contact Number: " + contact);
	
	System.out.println();
	
	System.out.println(
"---------------------------------------GOVERNMENT ID---------------------------------------");
	System.out.println("SSS Number: " + SSS);
	System.out.println("TIN Number: " + Tin);
	System.out.println("Pag-Ibig Number: " +pagibig);
	System.out.println("PhilHealth Number: " + philhealth);
}
}
