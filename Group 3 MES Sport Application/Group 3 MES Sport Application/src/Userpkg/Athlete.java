//Sherika Smith - 2302729

package Userpkg;

import java.util.List;

public class Athlete extends User { // attributes
    private static final long serialVersionUID = 1L;
    protected int trn;
    protected String firstName;
    protected String middleName;
    protected String lastName;
    protected char gender;
    protected String dob;
    protected float height;
    protected float weight;
    protected String nationality;
    protected Club club;
    protected Sponsor sponsor;
    protected String clubPassword;
    protected Coach coach;
    protected Agent agent;

    public Athlete(String Username, String Password, int TRN, String FirstName, String MiddleName, String LastName,
            char Gender, String DOB, float Height, float Weight, String Nationality, Coach Coach, Club Club,
            Sponsor Sponsor, Agent agent, String ClubPassword) {
        super(Username, Password);
        this.trn = TRN;
        this.firstName = FirstName;
        this.middleName = MiddleName;
        this.lastName = LastName;
        this.gender = Gender;
        this.dob = DOB;
        this.height = Height;
        this.weight = Weight;
        this.nationality = Nationality;
        this.coach = Coach;
        this.club = Club;
        this.sponsor = Sponsor;
        this.agent = agent;
        this.clubPassword = ClubPassword;
    }

    public Athlete() {
        this.clubPassword = "sportsForLife2024";
    };

    public Boolean ClubLogin(List<Athlete> userList, int trn, String clubPassword) {
        for (Athlete user : userList) {
            if (user.getTRN() == trn && user.getClubPassword().equals(clubPassword)) {
                return true;
            }
        }
        return false;
    }

    public void PayFees() {
        if (sponsor != null) {
            if (club != null) {
                float amount = sponsor.getAmount();
                float fees = (amount * 0.10f);
                club.setSalary(club.getSalary() + fees);
                sponsor.setAmount(sponsor.getAmount() - fees);
            } else if (club == null && coach != null) {
                float amount = sponsor.getAmount();
                float fees = (amount * 0.10f);
                coach.setCommission(coach.getCommission() + fees);
                sponsor.setAmount(sponsor.getAmount() - fees);
            }
        }
    }

    public void setFullName() {
        String fullName = firstName + " " + middleName + " " + lastName;
        sponsor.setAthleteName(fullName);
    }

    public String getName() {
        String fullName = firstName + " " + middleName + " " + lastName;
        return fullName;
    }

    // Getters and Setters
    public int getTRN() {
        return trn;
    }

    public void setTRN(int TRN) {
        this.trn = TRN;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String FirstName) {
        this.firstName = FirstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String MiddleName) {
        this.middleName = MiddleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String LastName) {
        this.lastName = LastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char Gender) {
        this.gender = Gender;
    }

    public String getDOB() {
        return dob;
    }

    public void setDOB(String DOB) {
        this.dob = DOB;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float Height) {
        this.height = Height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float Weight) {
        this.weight = Weight;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String Nationality) {
        this.nationality = Nationality;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club Club) {
        this.club = Club;
    }

    public Sponsor getSponsor() {
        return sponsor;
    }

    public void setSponsor(Sponsor Sponsor) {
        this.sponsor = Sponsor;
    }

    public String getClubPassword() {
        return clubPassword;
    }

    public void setClubPassword(String ClubPassword) {
        this.clubPassword = ClubPassword;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach Coach) {
        this.coach = Coach;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent Agent) {
        this.agent = Agent;
    }
}