package Act7;

//Private class of the Employee
public class Employee {
	    private String employeeID;
	    private String lastName;
	    private String firstName;
	    private String middleInitial;
	    private double basicAllowance;
	    private double incentivePay;
	    private double houseRentAllowance;
	    private double mealAllowance;
	    private double providentFund;
	    private double professionalTax;
	    private double loan;
	    private double earnings;
	    private double deductions;
	    private double netPay;

//Constructor of the Employee
	  Employee(String employeeID, String lastName, String firstName, String middleInitial,
		                double basicAllowance, double incentivePay, double houseRentAllowance,
		                double mealAllowance, double providentFund, double professionalTax, double loan, 
		                double earnings, double deductions, double netPay) {

//Current Objects in a Method / Constructor
	this.employeeID = employeeID;
    this.lastName = lastName;
    this.firstName = firstName;
    this.middleInitial = middleInitial;
    this.basicAllowance = basicAllowance;
    this.incentivePay = incentivePay;
    this.houseRentAllowance = houseRentAllowance;
    this.mealAllowance = mealAllowance;
    this.providentFund = providentFund;
    this.professionalTax = professionalTax;
    this.loan = loan;
    this.earnings = earnings;
    this.deductions = deductions;
    this.netPay = netPay;
}


//Getters and Setters for Employee
	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	
	//Getters and Setters for Balance
	public double getBasicAllowance() {
		return basicAllowance;
	}
	public void setBasicAllowance(double basicAllowance) {
		this.basicAllowance = basicAllowance;
	}

	public double getIncentivePay() {
		return incentivePay;
	}
	public void setIncentivePay(double incentivePay) {
		this.incentivePay = incentivePay;
	}

	public double getHouseRentAllowance() {
		return houseRentAllowance;
	}
	public void setHouseRentAllowance(double houseRentAllowance) {
		this.houseRentAllowance = houseRentAllowance;
	}

	public double getMealAllowance() {
		return mealAllowance;
	}
	public void setMealAllowance(double mealAllowance) {
		this.mealAllowance = mealAllowance;
	}

	
	//Getters and Setters for Deductions
	public double getProvidentFund() {
		return providentFund;
	}
	public void setProvidentFund(double providentFund) {
		this.providentFund = providentFund;
	}

	public double getProfessionalTax() {
		return professionalTax;
	}
	public void setProfessionalTax(double professionalTax) {
		this.professionalTax = professionalTax;
	}

	public double getLoan() {
		return loan;
	}
	public void setLoan(double loan) {
		this.loan = loan;
	}


	//Getters and Setters for the Total Amount
	public double getEarnings() {
		return earnings;
	}

	public void setEarnings(double earnings) {
		this.earnings = earnings;
	}

	public double getDeductions() {
		return deductions;
	}

	public void setDeductions(double deductions) {
		this.deductions = deductions;
	}

	public double getNetPay() {
		return netPay;
	}

	public void setNetPay(double netPay) {
		this.netPay = netPay;
	}
	
	
}


