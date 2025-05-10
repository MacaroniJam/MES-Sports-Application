//Sherika Smith - 2302729
// Joel Henry - 2300087
package FileManagerpkg;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import Userpkg.*;

public class FileManager {
    private List<Association> associationList;
    private List<Athlete> athleteList;
    private List<Club> clubList;
    private List<Coach> coachList;
    private List<Sponsor> sponsorList;

    public FileManager() {
        ReadData();
    }

    public void WriteData() {
        writeToFile("Athletes.txt", "Clubs.txt", "Coaches.txt", "Associations.txt",
                "Sponsors.txt");
    }

    public void ReadData() {
        readFromFile("Athletes.txt", "Clubs.txt", "Coaches.txt", "Associations.txt",
                "Sponsors.txt");
    }

    // Method to write lists to files
    public void writeToFile(String athleteFileName, String clubFileName, String coachFileName,
            String associationFileName, String sponsorFileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(athleteFileName))) {
            oos.writeObject(athleteList);
            System.out.println("Athletes have been written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(associationFileName))) {
            oos.writeObject(associationList);
            System.out.println("Associations have been written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(coachFileName))) {
            oos.writeObject(coachList);
            System.out.println("Coachs have been written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(sponsorFileName))) {
            oos.writeObject(sponsorList);
            System.out.println("Sponsors have been written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(clubFileName))) {
            oos.writeObject(clubList);
            System.out.println("Clubs have been written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to read lists from files
    @SuppressWarnings("unchecked")
    public void readFromFile(String athleteFileName, String clubFileName, String coachFileName,
            String associationFileName, String sponsorFileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(athleteFileName))) {
            athleteList = (List<Athlete>) ois.readObject();
            System.out.println("Athletes have been read from the file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(clubFileName))) {
            clubList = (List<Club>) ois.readObject();
            System.out.println("Clubs have been read from the file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(coachFileName))) {
            coachList = (List<Coach>) ois.readObject();
            System.out.println("Coaches have been read from the file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(associationFileName))) {
            associationList = (List<Association>) ois.readObject();
            System.out.println("Association have been read from the file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(sponsorFileName))) {
            sponsorList = (List<Sponsor>) ois.readObject();
            System.out.println("Sponsors have been read from the file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Setter methods
    public void setAssociationList(List<Association> associationList) {
        this.associationList = associationList;
    }

    public void setAthleteList(List<Athlete> athleteList) {
        this.athleteList = athleteList;
    }

    public void setClubList(List<Club> clubList) {
        this.clubList = clubList;
    }

    public void setCoachList(List<Coach> coachList) {
        this.coachList = coachList;
    }

    public void setSponsorList(List<Sponsor> sponsorList) {
        this.sponsorList = sponsorList;
    }

    // Getter methods
    public List<Athlete> getAthleteList() {
        return athleteList;
    }

    public List<Club> getClubList() {
        return clubList;
    }

    public List<Coach> getCoachList() {
        return coachList;
    }

    public List<Sponsor> getSponsorList() {
        return sponsorList;
    }

    public List<Association> getAssociationList() {
        return associationList;
    }

    public void addAthlete(Athlete athlete) {
        athleteList.add(athlete);
        WriteData();
        ReadData();
    }

    public void addClub(Club club) {
        clubList.add(club);
        WriteData();
        ReadData();
    }

    public void addCoach(Coach coach) {
        coachList.add(coach);
        WriteData();
        ReadData();
    }

    public void addSponsor(Sponsor sponsor) {
        sponsorList.add(sponsor);
        WriteData();
        ReadData();
    }

    public void addAssociation(Association association) {
        associationList.add(association);
        WriteData();
        ReadData();
    }

    public void removeAthlete(Athlete athlete) {
        athleteList.remove(athlete);
        WriteData();
        ReadData();
    }

    public void removeClub(Club club) {
        clubList.remove(club);
        WriteData();
        ReadData();
    }

    public void removeCoach(Coach coach) {
        coachList.remove(coach);
        WriteData();
        ReadData();
    }

    public void removeSponsor(Sponsor sponsor) {
        sponsorList.remove(sponsor);
        WriteData();
        ReadData();
    }

    public void removeAssociation(Association association) {
        associationList.remove(association);
        WriteData();
        ReadData();
    }

    public void editAthlete(Athlete athlete, int i) {
        athleteList.set(i, athlete);
        WriteData();
        ReadData();
    }

    public void editClub(Club club, int i) {
        clubList.set(i, club);
        WriteData();
        ReadData();
    }

    public void editCoach(Coach coach, int i) {
        coachList.set(i, coach);
        WriteData();
        ReadData();
    }

    public void editSponsor(Sponsor sponsor, int i) {
        sponsorList.set(i, sponsor);
        WriteData();
        ReadData();
    }

    public void editAssociation(Association association, int i) {
        associationList.set(i, association);
        WriteData();
        ReadData();
    }

}