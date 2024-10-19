//Lashawn Green (2305250)

package Userpkg;

public class Association extends User {
    private static final long serialVersionUID = 1L;
    protected String name;
    protected int id;
    protected int clubNumber;
    protected String address;
    protected String sport; // for the purpose of the admin login instructions
    protected float salary; // for the money they receive from clubs

    public Association() {
        clubNumber = 0;
        salary = 0.0f;
    };

    public Association(String Username, String Password, String name, int ID, int clubNumber, String address,
            String sport, float Salary) {
        super(Username, Password);
        this.name = name;
        this.id = ID;
        this.clubNumber = clubNumber;
        this.address = address;
        this.sport = sport;
        this.salary = Salary;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getClubNumber() {
        return clubNumber;
    }

    public void setClubNumber(int clubNumber) {
        this.clubNumber = clubNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}