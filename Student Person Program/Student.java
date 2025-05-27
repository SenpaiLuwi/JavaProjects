package Act8;

class Student extends Person {
	//Declaration of instance variables
    private int studID;
    private String major;
    private int nos;

    //Declaration of the constructor for the "Student"
    public Student(String name, int yob, int studID, String major, int nos) {
        super(name, yob);
        this.studID = studID;
        this.major = major;
        this.nos = nos;
    }

    //Instance variable of StudID
    public int getStudID() {
        return this.studID;
    }

    //Instance variable of Major
    public String getMajor() {
        return this.major;
    }

    //Instance variable of NOS
    public int getNos() {
        return this.nos;
    }
    
    //Instance variable of StudID
    public void setStudID(int studID) {
        this.studID = studID;
    }

    //Instance variable of Major
    public void setMajor(String major) {
        this.major = major;
    }

   
    //Prints the Student Info
    public void printInfo() {
        super.printInfo();
        System.out.println("Student ID: \t\t\t\t\t" + this.studID);
        System.out.println("Major: \t\t\t\t\t\t" + this.major);
        System.out.println("Total Number of Students:\t\t" + this.nos);
        System.out.println("Number of students: \t\t\t" + (++this.nos));
    }
}
