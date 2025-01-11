//Amoya Jordan - 2302539

package Userpkg;

public class Club extends User {
    protected static final long serialVersionUID = 1L;
    protected int code;
    protected String name;
    protected String colour;
    protected int totalMembership;
    protected String president;
    protected Coach headCoach;
    protected Association association;
    protected float salary;

    public Club(String Username, String Password, int Code, String Name, String Colour, int TotalMembership,
            String President, Coach HeadCoach, Association Association, float Salary) {
        super(Username, Password); // calls superclass constructor
        // initializing additional properties specific to Club class
        this.code = Code;
        this.name = Name;
        this.colour = Colour;
        this.totalMembership = TotalMembership;
        this.president = President;
        this.headCoach = HeadCoach;
        this.association = Association;
        this.salary = Salary;
    }

    public Club() {
        totalMembership = 0;
    }; // Default Constructor

    // Setters
    public void setCode(int code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setTotalMembership(int totalMembership) {
        this.totalMembership = totalMembership;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public void setHeadCoach(Coach headCoach) {
        this.headCoach = headCoach;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    // Getters
    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getColour() {
        return colour;
    }

    public int getTotalMembership() {
        return totalMembership;
    }

    public String getPresident() {
        return president;
    }

    public Coach getHeadCoach() {
        return headCoach;
    }

    public Association getAssociation() {
        return association;
    }

    public float getSalary() {
        return salary;
    }

    // Method for club class

    public void PayFees() {
        float fees = (salary * 0.05f);
        salary = salary - fees;
        headCoach.setCommission(headCoach.getCommission() + fees);

        fees = (salary * 0.01f);
        salary = salary - fees;
        association.setSalary(association.getSalary() + fees);
    }

}
