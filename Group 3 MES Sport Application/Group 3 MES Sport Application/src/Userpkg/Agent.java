//Amoya Jordan - 2302539
package Userpkg;

import java.io.Serializable;

// Attributes specific to Agent class
public class Agent implements Serializable {
    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;

    // Constructor for Agent class
    public Agent(String fName, String lName) {
        this.firstName = fName;
        this.lastName = lName;
    }

    public Agent() {
    }; // Default Constructor

    // Getters and Setters for Agent class
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
