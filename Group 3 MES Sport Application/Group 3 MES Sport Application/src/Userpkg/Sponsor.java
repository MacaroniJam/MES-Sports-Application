// Ronaldo Blake - 2301520
package Userpkg;

import java.io.Serializable;

public class Sponsor implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String sponsorshipDate;
    private String athleteName;
    private float amount;

    public Sponsor(String name, String sponsorshipDate, String AthleteName, float Amount) {
        this.name = name;
        this.sponsorshipDate = sponsorshipDate;
        this.athleteName = AthleteName;
        this.amount = Amount;
    }

    public Sponsor() {
        amount = 0.00f;
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSponsorshipDate() {
        return sponsorshipDate;
    }

    public void setSponsorshipDate(String sponsorshipDate) {
        this.sponsorshipDate = sponsorshipDate;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public void setAthleteName(String athleteName) {
        this.athleteName = athleteName;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
