//Jason White - 2304736

package Userpkg;

public class Coach extends User {
    protected static final long serialVersionUID = 1L;
    protected int trn;
    protected String firstName;
    protected String middleName;
    protected String lastName;
    protected char gender;
    protected String dob;
    protected String emp_Date;
    protected String sep_Date;
    protected float commission;

    public Coach() {
    }

    public Coach(String Username, String Password, int Trn, String Fname, String MName, String Lname, char Gender,
            String DOB, String Emp_Date, String Sep_Date, float Commission) {
        super(Username, Password);
        this.trn = Trn;
        this.firstName = Fname;
        this.middleName = MName;
        this.lastName = Lname;
        this.gender = Gender;
        this.dob = DOB;
        this.emp_Date = Emp_Date;
        this.sep_Date = Sep_Date;
        this.commission = Commission;
    }

    public int getTRN() {
        return trn;
    }

    public void setTRN(int trn) {
        this.trn = trn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmp_Date() {
        return emp_Date;
    }

    public void setEmp_Date(String emp_Date) {
        this.emp_Date = emp_Date;
    }

    public String getSep_Date() {
        return sep_Date;
    }

    public void setSep_Date(String sep_Date) {
        this.sep_Date = sep_Date;
    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }

    public String getName() {
        String fullname = firstName + " " + middleName + " " + lastName;
        return fullname;
    }

}
