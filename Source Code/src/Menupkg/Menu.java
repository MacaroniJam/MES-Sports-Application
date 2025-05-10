//Joel Henry (everything other than what Sherika did) - 2300087
// Sherika Smith (MinistryPrograms(), Nationality(), Demographics(), Salary()) - 2302729
package Menupkg;

import Userpkg.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import FileManagerpkg.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.table.DefaultTableModel;

public class Menu extends JFrame {

    private int adminLevel = 0;
    private User currentUser = new User();
    private Association association = new Association();
    private Club club = new Club();
    private Coach coach = new Coach();
    private Athlete athlete = new Athlete();
    private Sponsor sponsor = new Sponsor();
    private Association associationUser = new Association();
    private Club clubUser = new Club();
    private Coach coachUser = new Coach();
    private Athlete athleteUser = new Athlete();
    private Administrator admin = new Administrator();
    private String username;
    private String password;
    private FileManager fileManager = new FileManager();
    private List<Association> associationList = new ArrayList<>();
    private List<Club> clubList = new ArrayList<>();
    private List<Coach> coachList = new ArrayList<>();
    private List<Sponsor> sponsorList = new ArrayList<>();
    private List<Athlete> athleteList = new ArrayList<>();

    // User Select Menu
    private JPanel userSelectPanel = new JPanel();
    private JButton adminButton = new JButton("Admin");
    private JButton associationButton = new JButton("Association");
    private JButton clubButton = new JButton("Club");
    private JButton coachButton = new JButton("Coach");
    private JButton athleteButton = new JButton("Athlete");

    // Login Menu
    private JPanel loginPanel = new JPanel();
    private JTextField usernameField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JButton loginButton = new JButton("Login");
    private JButton backButton = new JButton("Back");
    private int attempts = 3;
    private Boolean loggedIn = false;

    // Sports Menu
    private JPanel sportsMenuPanel = new JPanel();

    // Main Menu
    private JPanel mainMenuPanel = new JPanel();
    private JButton systemManagementButton = new JButton("System Management");
    private JButton ministryProgramsButton = new JButton("Ministry Programs");
    private JButton sportsEventsButton = new JButton("Sports Events");
    private JButton salaryButton = new JButton("Salary");
    private JButton demographicsButton = new JButton("Demographics");
    private JButton clubsButton = new JButton("Clubs");
    private JButton nationalityButton = new JButton("Nationality");
    private JButton sponsorshipButton = new JButton("Sponsorship");
    private JButton logoutButton = new JButton("Logout");

    // System Management Menu
    private JPanel systemManagementPanel = new JPanel();
    // Admin Menu
    private JPanel adminMenuPanel = new JPanel();
    private JButton createButton = new JButton("Create");
    private JButton editButton = new JButton("Edit");
    private JButton deleteButton = new JButton("Delete");

    private JButton sponsorButton = new JButton("Sponsor");
    private JPanel createAccountMenuPanel = new JPanel();
    private JPanel editAccountMenuPanel = new JPanel();
    private JPanel deleteAccountMenuPanel = new JPanel();

    private JTextField passwordField1 = new JTextField();
    private JTextField clubPasswordField = new JTextField();
    private JTextField nameField = new JTextField();
    private JTextField idField = new JTextField();
    private JTextField addressField = new JTextField();
    private JTextField sportField = new JTextField();
    private JTextField colourField = new JTextField();
    private JTextField nameField1 = new JTextField();
    private JTextField nameField2 = new JTextField();
    private JTextField genderField = new JTextField();
    private JFormattedTextField dateField;
    private JFormattedTextField dateField1;
    private JTextField heightField = new JTextField();
    private JTextField weightField = new JTextField();
    private JTextField nationalityField = new JTextField();
    private JTextField nameField3 = new JTextField();
    private JTextField nameField4 = new JTextField();
    private JTextField amountField = new JTextField();

    private JComboBox<String> coachDropdown;
    private JComboBox<String> associationDropdown;
    private JComboBox<String> sponsorDropdown;
    private JComboBox<String> clubDropdown;
    private JComboBox<String> athleteDropdown;

    // Ministry Programs Menu
    private JPanel ministryPanel = new JPanel();

    // sports event
    private JPanel eventsPanel = new JPanel();
    private String sport = "";

    // Salary Menu
    private JPanel salaryPanel = new JPanel();

    // Sponsor
    private JPanel sponsorPanel = new JPanel();

    // Club
    private JPanel clubPanel = new JPanel();
    private JPanel clubLoginPanel = new JPanel();
    private JTextArea textArea = new JTextArea(20, 40);

    // Nationality
    private JPanel nationalityPanel = new JPanel();

    // Demographics
    private JPanel demographicsPanel = new JPanel();

    public Menu() {
        setTitle("MES Sport Application");

        loginPanel.setPreferredSize(new Dimension(400, 200));
        userSelectPanel.setPreferredSize(new Dimension(400, 200));
        sportsMenuPanel.setPreferredSize(new Dimension(400, 200));
        mainMenuPanel.setPreferredSize(new Dimension(400, 200));
        systemManagementPanel.setPreferredSize(new Dimension(400, 200));
        adminMenuPanel.setPreferredSize(new Dimension(400, 200));
        createAccountMenuPanel.setPreferredSize(new Dimension(400, 200));
        editAccountMenuPanel.setPreferredSize(new Dimension(400, 200));
        deleteAccountMenuPanel.setPreferredSize(new Dimension(400, 200));
        ministryPanel.setPreferredSize(new Dimension(400, 200));
        eventsPanel.setPreferredSize(new Dimension(400, 200));
        salaryPanel.setPreferredSize(new Dimension(400, 200));
        sponsorPanel.setPreferredSize(new Dimension(400, 200));
        clubPanel.setPreferredSize(new Dimension(400, 200));
        clubLoginPanel.setPreferredSize(new Dimension(400, 200));
        demographicsPanel.setPreferredSize(new Dimension(400, 200));
        nationalityPanel.setPreferredSize(new Dimension(400, 200));

        UserSelectMenu();

        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void setFileManager(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    public void setAssociationList() {
        associationList = fileManager.getAssociationList();
    }

    public void setClubList() {
        clubList = fileManager.getClubList();
    }

    public void setCoachList() {
        coachList = fileManager.getCoachList();
    }

    public void setSponsorList() {
        sponsorList = fileManager.getSponsorList();
    }

    public void setAthleteList() {
        athleteList = fileManager.getAthleteList();
    }

    private void setCoachDropdown() {
        List<Coach> c = fileManager.getCoachList();
        String[] coaches = new String[c.size()];
        for (int i = 0; i < c.size(); i++) {
            coaches[i] = c.get(i).getName();
        }
        coachDropdown = new JComboBox<String>(coaches);
    }

    private void setAssociationDropdown() {
        List<Association> a = fileManager.getAssociationList();
        String[] associations = new String[a.size()];
        for (int i = 0; i < a.size(); i++) {
            associations[i] = a.get(i).getName();
        }
        associationDropdown = new JComboBox<String>(associations);
    }

    private void setSponsorDropdown() {
        List<Sponsor> s = fileManager.getSponsorList();
        String[] sponsors = new String[s.size()];
        for (int i = 0; i < s.size(); i++) {
            sponsors[i] = s.get(i).getName();
        }
        sponsorDropdown = new JComboBox<String>(sponsors);

    }

    private void setClubDropdown() {
        List<Club> c = fileManager.getClubList();
        String[] clubs = new String[c.size()];
        for (int i = 0; i < c.size(); i++) {
            clubs[i] = c.get(i).getName();
        }
        clubDropdown = new JComboBox<String>(clubs);
    }

    private void setAthleteDropdown() {
        List<Athlete> a = fileManager.getAthleteList();
        String[] athletes = new String[a.size()];
        for (int i = 0; i < a.size(); i++) {
            athletes[i] = a.get(i).getName();
        }
        athleteDropdown = new JComboBox<String>(athletes);
    }

    private int findAssociation(String name) {
        setAssociationList();
        int index = 0; // Initialize index to 0
        for (Association obj : associationList) {
            if (obj.getName().equals(name)) {
                break;
            }
            index++;
        }
        return index;
    }

    private int findCoach(String name) {
        setCoachList();
        int index = 0; // Initialize index to 0
        for (Coach obj : coachList) {
            if (obj.getName().equals(name)) {
                break;
            }
            index++;
        }
        return index;
    }

    private int findSponsor(String name) {
        setSponsorList();
        int index = 0; // Initialize index to 0
        for (Sponsor obj : sponsorList) {
            if (obj.getName().equals(name)) {
                break;
            }
            index++;
        }
        return index;
    }

    private int findClub(String name) {
        setClubList();
        int index = 0; // Initialize index to 0
        for (Club obj : clubList) {
            if (obj.getName().equals(name)) {
                break;
            }
            index++;
        }
        return index;
    }

    private int findAthlete(String name) {
        setAthleteList();
        int index = 0; // Initialize index to 0
        for (Athlete obj : athleteList) {
            if (obj.getName().equals(name)) {
                break;
            }
            index++;
        }
        return index;
    }

    public void FindCriteria() {
        switch (adminLevel) {
            case 0:
                sport = athleteUser.getClub().getAssociation().getSport();
                break;
            case 2:
                sport = clubUser.getAssociation().getSport();
                break;
            case 3:
                sport = associationUser.getSport();
                break;
        }
    }

    private void addEvents(String eventTitle, String... eventDetails) {
        eventsPanel.add(new JLabel(eventTitle, SwingConstants.CENTER));
        for (String detail : eventDetails) {
            eventsPanel.add(new JLabel(detail, SwingConstants.CENTER));
        }
    }

    // counts athletes without a club
    public static int countNoClub(List<Athlete> athleteList) {
        int athletesNC = 0;
        for (Athlete athlete : athleteList) {
            if (athlete.getClub() == null) {
                athletesNC++;
            }
        }
        return athletesNC;
    }

    // returns all athletes
    public static int countAllAthletes(List<Athlete> athleteList) {
        int athletes = 0;
        for (Athlete athlete : athleteList) {
            if (athlete.getName() != null || !athlete.getName().isEmpty()) {
                athletes++;
            }
        }
        return athletes;
    }

    // returns athletes with sponsorship
    public static int withSponsorship(List<Athlete> athleteList) {
        int withS = 0;
        for (Athlete athlete : athleteList) {
            if (athlete.getSponsor() != null || !athlete.getSponsor().getName().isEmpty()) {
                withS++;
            }
        }
        return withS;
    }

    // returns atheletes without sponsorship
    public static int withoutSponsorship(List<Athlete> athleteList) {
        int without = 0;
        for (Athlete athlete : athleteList) {
            if (athlete.getSponsor().getName().isEmpty() || athlete.getSponsor() == null) {
                without++;
            }
        }
        return without;
    }

    // counts athletes in association
    public static int countAthletes(List<Athlete> athleteList) {
        int athletes = 0;
        for (Athlete athlete : athleteList) {
            if ((athlete.getClub().getAssociation() != null
                    || !athlete.getClub().getAssociation().getName().isEmpty())) {
                athletes++;
            }
        }
        return athletes;
    }

    private static MaskFormatter createMaskFormatter(String format) {
        MaskFormatter maskFormatter = null;
        try {
            maskFormatter = new MaskFormatter(format);
            maskFormatter.setPlaceholderCharacter('_'); // Use '_' as a placeholder for empty positions
            maskFormatter.setValidCharacters("0123456789"); // Accept only digits for month and day
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return maskFormatter;
    }

    private void UserLogin() {
        loggedIn = false;
        attempts = 3;
        currentUser = new User();
        userSelectPanel.setVisible(false);
        loginPanel.setVisible(true);
        LoginMenu();
    }

    private void UserSelectMenu() {
        userSelectPanel.setLayout(new GridLayout(0, 1));
        userSelectPanel.removeAll();
        userSelectPanel.add(new JLabel("WELCOME TO THE MES Sport Application", SwingConstants.CENTER));

        ActionListener loginAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                switch (button.getText()) {
                    case "Admin":
                        adminLevel = 4;
                        userSelectPanel.setVisible(false);
                        loginPanel.setVisible(true);
                        UserLogin();
                        break;
                    case "Association":
                        adminLevel = 3;
                        associationUser = new Association();
                        userSelectPanel.setVisible(false);
                        loginPanel.setVisible(true);
                        UserLogin();
                        break;
                    case "Club":
                        adminLevel = 2;
                        clubUser = new Club();
                        userSelectPanel.setVisible(false);
                        loginPanel.setVisible(true);
                        UserLogin();
                        break;
                    case "Coach":
                        adminLevel = 1;
                        coachUser = new Coach();
                        userSelectPanel.setVisible(false);
                        loginPanel.setVisible(true);
                        UserLogin();
                        break;
                    case "Athlete":
                        adminLevel = 0;
                        athleteUser = new Athlete();
                        userSelectPanel.setVisible(false);
                        loginPanel.setVisible(true);
                        UserLogin();
                        break;
                }
            }
        };

        adminButton.addActionListener(loginAction);
        userSelectPanel.add(adminButton);

        associationButton.addActionListener(loginAction);
        userSelectPanel.add(associationButton);

        clubButton.addActionListener(loginAction);
        userSelectPanel.add(clubButton);

        coachButton.addActionListener(loginAction);
        userSelectPanel.add(coachButton);

        athleteButton.addActionListener(loginAction);
        userSelectPanel.add(athleteButton);

        add(userSelectPanel);
    }

    private void LoginMenu() {
        loginPanel.setLayout(new GridLayout(0, 1));
        loginPanel.removeAll();
        loginPanel.add(new JLabel("User Login", SwingConstants.CENTER));

        loginPanel.add(new JLabel("Username:"));
        loginPanel.add(usernameField);
        loginPanel.add(new JLabel("Password:"));
        loginPanel.add(passwordField);
        usernameField.setText("");
        passwordField.setText("");

        loginPanel.add(loginButton);
        JButton backButton = new JButton("Back");
        loginPanel.add(backButton);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginPanel.setVisible(false);
                userSelectPanel.setVisible(true);
                currentUser = new User();
                adminLevel = 0;
                UserSelectMenu();
            }
        });

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                username = usernameField.getText();
                password = new String(passwordField.getPassword());
                switch (adminLevel) {
                    case 0:
                        currentUser = (User) athleteUser.Login(fileManager.getAthleteList(), username, password);
                        break;
                    case 1:
                        currentUser = (User) coachUser.Login(fileManager.getCoachList(), username, password);
                        break;
                    case 2:
                        currentUser = (User) clubUser.Login(fileManager.getClubList(), username, password);
                        break;
                    case 3:
                        currentUser = (User) associationUser.Login(fileManager.getAssociationList(), username,
                                password);
                        break;
                    case 4:
                        currentUser = admin;
                        break;
                }

                if (currentUser != null) {
                    if ((currentUser.getUsername().equals(username))
                            || (adminLevel == 4 && username.equals(currentUser.getUsername())
                                    && password.equals(currentUser.getPassword()))) {

                        switch (adminLevel) {
                            case 0:
                                for (Athlete athlete : fileManager.getAthleteList()) {
                                    if (athlete.getUsername().equals(username)) {
                                        athleteUser = athlete;
                                        break;
                                    }
                                }
                                break;
                            case 1:
                                for (Coach coach : fileManager.getCoachList()) {
                                    if (coach.getUsername().equals(username)) {
                                        coachUser = coach;
                                        break;
                                    }
                                }
                                break;
                            case 2:
                                for (Club club : fileManager.getClubList()) {
                                    if (club.getUsername().equals(username)) {
                                        clubUser = club;
                                        break;
                                    }
                                }
                                break;
                            case 3:
                                for (Association association : fileManager.getAssociationList()) {
                                    if (association.getUsername().equals(username)) {
                                        associationUser = association;
                                        break;
                                    }
                                }
                                break;
                        }

                        if (!loggedIn) {
                            JOptionPane.showMessageDialog(Menu.this, "Login Successful!", "Success",
                                    JOptionPane.INFORMATION_MESSAGE);
                            loggedIn = true;
                        }

                        if (adminLevel == 4) {
                            loginPanel.setVisible(false);
                            sportsMenuPanel.setVisible(true);
                            SportsMenu();
                        } else {
                            loginPanel.setVisible(false);
                            mainMenuPanel.setVisible(true);
                            MainMenu();
                        }

                    }
                } else {
                    attempts--;
                    if (attempts == 0) {
                        JOptionPane.showMessageDialog(Menu.this, "Incorrect username or password.", "Login Error",
                                JOptionPane.ERROR_MESSAGE);
                        System.exit(1);
                    } else {
                        JOptionPane.showMessageDialog(Menu.this,
                                "Invalid username or password. Attempts remaining: " + attempts,
                                "Error", JOptionPane.ERROR_MESSAGE);
                        usernameField.setText("");
                        passwordField.setText("");
                    }

                }
            }
        });

        add(loginPanel);
    }

    private void SportsMenu() {
        sportsMenuPanel.setLayout(new GridLayout(0, 1));

        sportsMenuPanel.removeAll();

        sportsMenuPanel.add(new JLabel("SPORTS", SwingConstants.CENTER));
        sportsMenuPanel.add(new JLabel("Choose the sport you want to access", SwingConstants.CENTER));

        for (Association association : fileManager.getAssociationList()) {
            JButton button = new JButton(association.getSport());
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JButton clickedButton = (JButton) e.getSource();
                    sport = clickedButton.getText();
                    sportsMenuPanel.setVisible(false);
                    mainMenuPanel.setVisible(true);
                    MainMenu();
                }
            });
            sportsMenuPanel.add(button); // Add button to the panel
        }

        JButton backButton = new JButton("Back");
        sportsMenuPanel.add(backButton);

        backButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                sportsMenuPanel.setVisible(false);
                userSelectPanel.setVisible(true);
                currentUser = new User();
                adminLevel = 0;
                UserSelectMenu();
            }

        });

        add(sportsMenuPanel);
    }

    private void MainMenu() {
        mainMenuPanel.setLayout(new GridLayout(0, 1));

        mainMenuPanel.removeAll();

        mainMenuPanel.add(new JLabel("MAIN MENU", SwingConstants.CENTER));

        ActionListener mainMenuAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                switch (button.getText()) {
                    case "System Management":
                        mainMenuPanel.setVisible(false);
                        systemManagementPanel.setVisible(true);
                        SystemManagementMenu();
                        break;

                    case "Ministry Programs":
                        mainMenuPanel.setVisible(false);
                        ministryPanel.setVisible(true);
                        MinistryPrograms();
                        break;

                    case "Sports Events":
                        mainMenuPanel.setVisible(false);
                        eventsPanel.setVisible(true);
                        SportsEvents();
                        break;

                    case "Salary":
                        mainMenuPanel.setVisible(false);
                        salaryPanel.setVisible(true);
                        Salary();
                        break;

                    case "Demographics":
                        mainMenuPanel.setVisible(false);
                        demographicsPanel.setVisible(true);
                        Demographics();
                        break;

                    case "Clubs":
                        if (adminLevel == 0) {
                            mainMenuPanel.setVisible(false);
                            clubLoginPanel.setVisible(true);
                            ClubLogin();
                        } else {
                            mainMenuPanel.setVisible(false);
                            clubPanel.setVisible(true);
                            Clubs();
                        }

                        break;

                    case "Nationality":
                        Nationality();
                        mainMenuPanel.setVisible(false);
                        nationalityPanel.setVisible(true);
                        break;

                    case "Sponsorship":
                        Sponsorship();
                        mainMenuPanel.setVisible(false);
                        break;

                    case "Logout":
                        mainMenuPanel.setVisible(false);
                        userSelectPanel.setVisible(true);
                        currentUser = new User();
                        adminLevel = 0;
                        UserSelectMenu();
                        break;
                }
            }
        };

        if (adminLevel == 4) {
            systemManagementButton.addActionListener(mainMenuAction);
            mainMenuPanel.add(systemManagementButton);
        }

        ministryProgramsButton.addActionListener(mainMenuAction);
        mainMenuPanel.add(ministryProgramsButton);

        if (adminLevel != 1) {
            sportsEventsButton.addActionListener(mainMenuAction);
            mainMenuPanel.add(sportsEventsButton);
        }

        // Admin and Athlete wouldnt have anything to show for salary
        if (adminLevel >= 1 && adminLevel <= 3) {
            salaryButton.addActionListener(mainMenuAction);
            mainMenuPanel.add(salaryButton);
        }

        demographicsButton.addActionListener(mainMenuAction);
        mainMenuPanel.add(demographicsButton);

        if (adminLevel == 0 || adminLevel >= 2) {
            // Athelete and Club sees info for their club
            // admin sees all clubs and info
            clubsButton.addActionListener(mainMenuAction);
            mainMenuPanel.add(clubsButton);
        }

        nationalityButton.addActionListener(mainMenuAction);
        mainMenuPanel.add(nationalityButton);

        if (adminLevel == 0) {
            sponsorshipButton.addActionListener(mainMenuAction);
            mainMenuPanel.add(sponsorshipButton);
        }

        logoutButton.addActionListener(mainMenuAction);
        mainMenuPanel.add(logoutButton);

        add(mainMenuPanel);
    }

    private void SystemManagementMenu() {
        systemManagementPanel.setLayout(new GridLayout(0, 1));

        systemManagementPanel.removeAll();

        systemManagementPanel.add(new JLabel("SYSTEM MANAGEMENT", SwingConstants.CENTER));
        systemManagementPanel.add(new JLabel("Choose the User type you plan to manipulate", SwingConstants.CENTER));

        JButton associationButton = new JButton("Association");
        JButton clubButton = new JButton("Club");
        JButton coachButton = new JButton("Coach");
        JButton athleteButton = new JButton("Athlete");

        ActionListener systemManagementAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                switch (button.getText()) {
                    case "Association":
                        systemManagementPanel.setVisible(false);
                        adminMenuPanel.setVisible(true);
                        AdminMenu(button.getText());
                        break;
                    case "Club":
                        systemManagementPanel.setVisible(false);
                        adminMenuPanel.setVisible(true);
                        AdminMenu(button.getText());
                        break;
                    case "Coach":
                        systemManagementPanel.setVisible(false);
                        adminMenuPanel.setVisible(true);
                        AdminMenu(button.getText());
                        break;
                    case "Athlete":
                        systemManagementPanel.setVisible(false);
                        adminMenuPanel.setVisible(true);
                        AdminMenu(button.getText());
                        break;
                    case "Sponsor":
                        systemManagementPanel.setVisible(false);
                        adminMenuPanel.setVisible(true);
                        AdminMenu(button.getText());
                        break;
                    case "Back":
                        systemManagementPanel.setVisible(false);
                        mainMenuPanel.setVisible(true);
                        MainMenu();
                        break;
                }
            }
        };

        associationButton.addActionListener(systemManagementAction);
        systemManagementPanel.add(associationButton);

        clubButton.addActionListener(systemManagementAction);
        systemManagementPanel.add(clubButton);

        coachButton.addActionListener(systemManagementAction);
        systemManagementPanel.add(coachButton);

        athleteButton.addActionListener(systemManagementAction);
        systemManagementPanel.add(athleteButton);

        sponsorButton.addActionListener(systemManagementAction);
        systemManagementPanel.add(sponsorButton);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(systemManagementAction);
        systemManagementPanel.add(backButton);

        add(systemManagementPanel);
    }

    private void AdminMenu(String user) {
        adminMenuPanel.setLayout(new GridLayout(0, 1));
        adminMenuPanel.removeAll();
        adminMenuPanel.add(new JLabel("ADMIN MENU", SwingConstants.CENTER));

        ActionListener adminAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                switch (button.getText()) {
                    case "Create":
                        CreateAccountMenu(user);
                        adminMenuPanel.setVisible(false);
                        createAccountMenuPanel.setVisible(true);
                        break;
                    case "Edit":
                        EditAccountMenu(user);
                        adminMenuPanel.setVisible(false);
                        editAccountMenuPanel.setVisible(true);
                        break;
                    case "Delete":
                        DeleteAccountMenu(user);
                        adminMenuPanel.setVisible(false);
                        deleteAccountMenuPanel.setVisible(true);
                        break;
                    case "Back":
                        systemManagementPanel.setVisible(false);
                        mainMenuPanel.setVisible(true);
                        break;
                }
            }
        };

        createButton.addActionListener(adminAction);
        adminMenuPanel.add(createButton);

        editButton.addActionListener(adminAction);
        adminMenuPanel.add(editButton);

        deleteButton.addActionListener(adminAction);
        adminMenuPanel.add(deleteButton);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(adminAction);
        adminMenuPanel.add(backButton);

        add(adminMenuPanel);
    }

    private void CreateAccountMenu(String user) {
        createAccountMenuPanel.setLayout(new GridLayout(0, 2));
        createAccountMenuPanel.removeAll();
        setCoachDropdown();
        setAssociationDropdown();
        setClubDropdown();
        setSponsorDropdown();

        coach = new Coach();
        club = new Club();
        association = new Association();
        sponsor = new Sponsor();
        JButton createButton = new JButton("Create");

        switch (user) {
            case "Association":
                createAccountMenuPanel.add(new JLabel("Username:", SwingConstants.LEFT));
                createAccountMenuPanel.add(usernameField);
                createAccountMenuPanel.add(new JLabel("Password:", SwingConstants.LEFT));
                createAccountMenuPanel.add(passwordField1);
                createAccountMenuPanel.add(new JLabel("ID:", SwingConstants.LEFT));
                createAccountMenuPanel.add(idField);
                idField.setDocument(new IntegerDocument());
                createAccountMenuPanel.add(new JLabel("Name:", SwingConstants.LEFT));
                createAccountMenuPanel.add(nameField);
                // Club number will be left out as i want it to be calculated on the amount of
                // clubs actually present. Thus, a club will have to be made then associated to
                // an association to be able to count in number of clubs.

                createAccountMenuPanel.add(new JLabel("Address:", SwingConstants.LEFT));
                createAccountMenuPanel.add(addressField);
                createAccountMenuPanel.add(new JLabel("Sport:", SwingConstants.LEFT));
                createAccountMenuPanel.add(sportField);
                // I think Salary should be something that is determined by the amount of money
                // sent to the association

                createButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        association.setUsername(usernameField.getText());
                        association.setPassword(passwordField1.getText());
                        association.setName(nameField.getText());
                        association.setID(Integer.parseInt(idField.getText()));
                        association.setAddress(addressField.getText());
                        association.setSport(sportField.getText());
                        fileManager.addAssociation(association);
                        JOptionPane.showMessageDialog(Menu.this, "Account Created", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                        createAccountMenuPanel.setVisible(false);
                        mainMenuPanel.setVisible(true);
                        MainMenu();
                    }
                });
                break;

            case "Club":
                createAccountMenuPanel.add(new JLabel("Username:", SwingConstants.LEFT));
                createAccountMenuPanel.add(usernameField);
                createAccountMenuPanel.add(new JLabel("Password:", SwingConstants.LEFT));
                createAccountMenuPanel.add(passwordField1);
                createAccountMenuPanel.add(new JLabel("Code:", SwingConstants.LEFT));
                createAccountMenuPanel.add(idField);
                idField.setDocument(new IntegerDocument());
                createAccountMenuPanel.add(new JLabel("Name:", SwingConstants.LEFT));
                createAccountMenuPanel.add(nameField);
                createAccountMenuPanel.add(new JLabel("Colour:", SwingConstants.LEFT));
                createAccountMenuPanel.add(colourField);
                // TotaMembership will be calculated based on the number of athletes added to
                // the club.
                createAccountMenuPanel.add(new JLabel("President:", SwingConstants.LEFT));
                createAccountMenuPanel.add(nameField1);
                createAccountMenuPanel.add(new JLabel("Coach:", SwingConstants.LEFT));
                createAccountMenuPanel.add(coachDropdown);
                createAccountMenuPanel.add(new JLabel("Association:", SwingConstants.LEFT));
                createAccountMenuPanel.add(associationDropdown);

                createButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        club.setUsername(usernameField.getText());
                        club.setPassword(passwordField1.getText());
                        club.setName(nameField.getText());
                        club.setCode(Integer.parseInt(idField.getText()));
                        club.setColour(colourField.getText());
                        club.setPresident(nameField1.getText());
                        String selectedObjectName = (String) coachDropdown.getSelectedItem();
                        // Find the object with the selected name
                        for (Coach obj : fileManager.getCoachList()) {
                            if (obj.getName().equals(selectedObjectName)) {
                                coach = obj;
                                break;
                            }
                        }
                        club.setHeadCoach(coach);
                        selectedObjectName = (String) associationDropdown.getSelectedItem();
                        int i = findAssociation(selectedObjectName);

                        association = associationList.get(i);

                        // Set the total membership of the association
                        association.setClubNumber(association.getClubNumber() + 1);

                        // Replace the association in the list at the same index
                        fileManager.editAssociation(association, i);
                        setAssociationList();

                        club.setAssociation(association);
                        fileManager.addClub(club);
                        JOptionPane.showMessageDialog(Menu.this, "Account Created", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                        createAccountMenuPanel.setVisible(false);
                        mainMenuPanel.setVisible(true);
                        MainMenu();
                    }
                });
                break;

            case "Coach":
                createAccountMenuPanel.add(new JLabel("Username:", SwingConstants.LEFT));
                createAccountMenuPanel.add(usernameField);
                createAccountMenuPanel.add(new JLabel("Password:", SwingConstants.LEFT));
                createAccountMenuPanel.add(passwordField1);
                createAccountMenuPanel.add(new JLabel("TRN:", SwingConstants.LEFT));
                createAccountMenuPanel.add(idField);
                idField.setDocument(new IntegerDocument());
                createAccountMenuPanel.add(new JLabel("Fisrt Name:", SwingConstants.LEFT));
                createAccountMenuPanel.add(nameField);
                createAccountMenuPanel.add(new JLabel("Middle Name:", SwingConstants.LEFT));
                createAccountMenuPanel.add(nameField1);
                createAccountMenuPanel.add(new JLabel("Last Name:", SwingConstants.LEFT));
                createAccountMenuPanel.add(nameField2);
                createAccountMenuPanel.add(new JLabel("Gender (M/F):", SwingConstants.LEFT));
                genderField.setDocument(new CharDocument());
                createAccountMenuPanel.add(genderField);
                createAccountMenuPanel.add(new JLabel("Employment Date (MM/DD/YYYY):", SwingConstants.LEFT));
                dateField = new JFormattedTextField(createMaskFormatter("##/##/####"));
                createAccountMenuPanel.add(dateField);
                createAccountMenuPanel.add(new JLabel("Seperation Date (MM/DD/YYYY):", SwingConstants.LEFT));
                dateField1 = new JFormattedTextField(createMaskFormatter("##/##/####"));
                createAccountMenuPanel.add(dateField1);

                // Commision will be calculated based on the amount of money sent to the coach.
                createButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        coach.setUsername(usernameField.getText());
                        coach.setPassword(passwordField1.getText());
                        coach.setTRN(Integer.parseInt(idField.getText()));
                        coach.setFirstName(nameField.getText());
                        coach.setMiddleName(nameField1.getText());
                        coach.setLastName(nameField2.getText());
                        coach.setGender(genderField.getText().charAt(0));
                        coach.setEmp_Date(dateField.getText());
                        coach.setSep_Date(dateField1.getText());
                        fileManager.addCoach(coach);
                        JOptionPane.showMessageDialog(Menu.this, "Account Created", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                        createAccountMenuPanel.setVisible(false);
                        mainMenuPanel.setVisible(true);
                        MainMenu();
                    }
                });
                break;

            case "Athlete":
                clubDropdown.addItem("None");
                coachDropdown.addItem("None");
                sponsorDropdown.addItem("None");
                createAccountMenuPanel.add(new JLabel("Username:", SwingConstants.LEFT));
                createAccountMenuPanel.add(usernameField);
                createAccountMenuPanel.add(new JLabel("Password:", SwingConstants.LEFT));
                createAccountMenuPanel.add(passwordField1);
                createAccountMenuPanel.add(new JLabel("Club Password:", SwingConstants.LEFT));
                createAccountMenuPanel.add(clubPasswordField);
                createAccountMenuPanel.add(new JLabel("TRN:", SwingConstants.LEFT));
                idField.setDocument(new IntegerDocument());
                createAccountMenuPanel.add(idField);
                createAccountMenuPanel.add(new JLabel("First Name:", SwingConstants.LEFT));
                createAccountMenuPanel.add(nameField);
                createAccountMenuPanel.add(new JLabel("Middle Name:", SwingConstants.LEFT));
                createAccountMenuPanel.add(nameField1);
                createAccountMenuPanel.add(new JLabel("Last Name:", SwingConstants.LEFT));
                createAccountMenuPanel.add(nameField2);
                createAccountMenuPanel.add(new JLabel("Gender (M/F):", SwingConstants.LEFT));
                genderField.setDocument(new CharDocument());
                createAccountMenuPanel.add(genderField);
                createAccountMenuPanel.add(new JLabel("Date of Birth (MM/DD/YYYY):", SwingConstants.LEFT));
                dateField = new JFormattedTextField(createMaskFormatter("##/##/####"));
                createAccountMenuPanel.add(dateField);
                createAccountMenuPanel.add(new JLabel("Height (cm):", SwingConstants.LEFT));
                heightField.setDocument(new FloatDocument());
                createAccountMenuPanel.add(heightField);
                createAccountMenuPanel.add(new JLabel("Weight (kg):", SwingConstants.LEFT));
                weightField.setDocument(new FloatDocument());
                createAccountMenuPanel.add(weightField);
                createAccountMenuPanel.add(new JLabel("Nationality:", SwingConstants.LEFT));
                createAccountMenuPanel.add(nationalityField);
                createAccountMenuPanel.add(new JLabel("Coach:", SwingConstants.LEFT));
                createAccountMenuPanel.add(coachDropdown);
                createAccountMenuPanel.add(new JLabel("Club:", SwingConstants.LEFT));
                createAccountMenuPanel.add(clubDropdown);
                createAccountMenuPanel.add(new JLabel("Sponsor:", SwingConstants.LEFT));
                createAccountMenuPanel.add(sponsorDropdown);

                createButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // used as the values for the index of classes within the athlete creation
                        // section as that would be the trigger that updates the rest of the classes
                        // concerning their salary by setting off each one of their salary functions
                        int a = 0, b = 0, c = 0;
                        athlete.setUsername(usernameField.getText());
                        athlete.setPassword(passwordField1.getText());
                        athlete.setClubPassword(clubPasswordField.getText());
                        athlete.setTRN(Integer.parseInt(idField.getText()));
                        athlete.setFirstName(nameField.getText());
                        athlete.setMiddleName(nameField1.getText());
                        athlete.setLastName(nameField2.getText());
                        athlete.setGender(genderField.getText().charAt(0));
                        athlete.setDOB(dateField.getText());
                        athlete.setHeight(Float.parseFloat(heightField.getText()));
                        athlete.setWeight(Float.parseFloat(weightField.getText()));
                        athlete.setNationality(nationalityField.getText());
                        Agent agent = new Agent(nameField3.getText(), nameField4.getText());
                        athlete.setAgent(agent);

                        String selectedObjectName = (String) sponsorDropdown.getSelectedItem();

                        if (sponsorDropdown.getSelectedItem().equals("None")) {
                            sponsor = new Sponsor();
                        } else {
                            a = findSponsor(selectedObjectName);

                            sponsor = sponsorList.get(a);
                            LocalDate currentDate = LocalDate.now();

                            // Define the desired date format
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

                            // Format the current date as a string
                            String todayDate = currentDate.format(formatter);
                            sponsor.setSponsorshipDate(todayDate);
                        }
                        athlete.setSponsor(sponsor);

                        selectedObjectName = (String) coachDropdown.getSelectedItem();
                        if (coachDropdown.getSelectedItem().equals("None")) {
                            coach = new Coach();
                        } else {
                            b = findCoach(selectedObjectName);

                            coach = coachList.get(b);
                        }
                        athlete.setCoach(coach);

                        selectedObjectName = (String) clubDropdown.getSelectedItem();
                        if (clubDropdown.getSelectedItem().equals("None")) {
                            club = new Club();
                        } else {
                            c = findClub(selectedObjectName);

                            club = clubList.get(c);
                        }
                        athlete.setClub(club);

                        athlete.setFullName();
                        athlete.PayFees();
                        club = athlete.getClub();
                        club.setTotalMembership(club.getTotalMembership() + 1);

                        if (athlete.getSponsor() != null || !athlete.getSponsor().getName().isEmpty()) {
                            selectedObjectName = club.getHeadCoach().getName();
                            int i = findCoach(selectedObjectName);
                            club.setHeadCoach(coachList.get(i));
                            club.PayFees();
                            fileManager.editCoach(club.getHeadCoach(), i);
                        }

                        fileManager.editClub(club, c);
                        fileManager.editCoach(athlete.getCoach(), b);
                        fileManager.editSponsor(athlete.getSponsor(), a);
                        fileManager.addAthlete(athlete);
                        JOptionPane.showMessageDialog(Menu.this, "Account Created", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                        createAccountMenuPanel.setVisible(false);
                        mainMenuPanel.setVisible(true);
                        MainMenu();
                    }
                });
                break;

            case "Sponsor":
                createAccountMenuPanel.add(new JLabel("Name:", SwingConstants.LEFT));
                createAccountMenuPanel.add(nameField);

                // sponsor date and athlete name determines on added athlete
                createAccountMenuPanel.add(new JLabel("Amount:", SwingConstants.LEFT));
                amountField.setDocument(new FloatDocument());
                createAccountMenuPanel.add(amountField);

                createButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        sponsor.setName(nameField.getText());
                        sponsor.setAmount(Float.parseFloat(amountField.getText()));
                        fileManager.addSponsor(sponsor);
                        JOptionPane.showMessageDialog(Menu.this, "Account Created", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                        createAccountMenuPanel.setVisible(false);
                        mainMenuPanel.setVisible(true);
                        MainMenu();
                    }
                });

                break;
        }

        createAccountMenuPanel.add(createButton);

        JButton backButton = new JButton("Back");
        createAccountMenuPanel.add(backButton);
        backButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                createAccountMenuPanel.setVisible(false);
                mainMenuPanel.setVisible(true);
                MainMenu();
            }

        });

        // Add the main panel to your container
        add(createAccountMenuPanel);

        // Revalidate and repaint the container
        revalidate();
        repaint();
    }

    private void EditAccountMenu(String user) {
        editAccountMenuPanel.setLayout(new GridLayout(0, 1));
        editAccountMenuPanel.removeAll();
        editAccountMenuPanel.add(new JLabel("EDIT ACCOUNT", SwingConstants.CENTER));
        setCoachDropdown();
        setAssociationDropdown();
        setClubDropdown();
        setSponsorDropdown();
        setAthleteDropdown();

        coach = new Coach();
        club = new Club();
        association = new Association();
        sponsor = new Sponsor();

        JButton editButton = new JButton("Edit");

        switch (user) {
            case "Association":
                editAccountMenuPanel.add(associationDropdown);
                editAccountMenuPanel.add(new JLabel("Username:"));
                editAccountMenuPanel.add(usernameField);
                editAccountMenuPanel.add(new JLabel("Password:"));
                editAccountMenuPanel.add(passwordField1);
                editAccountMenuPanel.add(new JLabel("ID:"));
                editAccountMenuPanel.add(idField);
                idField.setDocument(new IntegerDocument());
                editAccountMenuPanel.add(new JLabel("Name:"));
                editAccountMenuPanel.add(nameField);
                editAccountMenuPanel.add(new JLabel("Address:"));
                editAccountMenuPanel.add(addressField);
                editAccountMenuPanel.add(new JLabel("Sport:"));
                editAccountMenuPanel.add(sportField);

                associationDropdown.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String selectedObjectName = (String) associationDropdown.getSelectedItem();
                        int i = findAssociation(selectedObjectName);

                        association = associationList.get(i);

                        usernameField.setText(association.getUsername());
                        passwordField1.setText(association.getPassword());
                        idField.setText(String.valueOf(association.getID()));
                        nameField.setText(association.getName());
                        addressField.setText(association.getAddress());
                        sportField.setText(association.getSport());
                    }
                });

                editButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int i = findAssociation(associationDropdown.getSelectedItem().toString());
                        association.setUsername(usernameField.getText());
                        association.setPassword(passwordField1.getText());
                        association.setID(Integer.parseInt(idField.getText()));
                        association.setName(nameField.getText());
                        association.setAddress(addressField.getText());
                        association.setSport(sportField.getText());
                        fileManager.editAssociation(association, i);
                        JOptionPane.showMessageDialog(Menu.this, "Account Edited", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                        editAccountMenuPanel.setVisible(false);
                        mainMenuPanel.setVisible(true);
                        MainMenu();
                    }
                });
                break;

            case "Club":
                editAccountMenuPanel.add(clubDropdown);
                editAccountMenuPanel.add(new JLabel("Username:"));
                editAccountMenuPanel.add(usernameField);
                editAccountMenuPanel.add(new JLabel("Password:"));
                editAccountMenuPanel.add(passwordField1);
                editAccountMenuPanel.add(new JLabel("Code:"));
                editAccountMenuPanel.add(idField);
                idField.setDocument(new IntegerDocument());
                editAccountMenuPanel.add(new JLabel("Name:"));
                editAccountMenuPanel.add(nameField);
                editAccountMenuPanel.add(new JLabel("Colour:"));
                editAccountMenuPanel.add(colourField);
                editAccountMenuPanel.add(new JLabel("President:"));
                editAccountMenuPanel.add(nameField1);
                editAccountMenuPanel.add(new JLabel("Coach:"));
                editAccountMenuPanel.add(coachDropdown);
                editAccountMenuPanel.add(new JLabel("Association:"));
                editAccountMenuPanel.add(associationDropdown);
                clubDropdown.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String selectedObjectName = (String) sponsorDropdown.getSelectedItem();
                        int i = findClub(selectedObjectName);

                        club = clubList.get(i);
                        usernameField.setText(club.getUsername());
                        passwordField1.setText(club.getPassword());
                        idField.setText(String.valueOf(club.getCode()));
                        nameField.setText(club.getName());
                        colourField.setText(club.getColour());
                        coachDropdown.setSelectedItem(club.getHeadCoach().getName());
                        associationDropdown.setSelectedItem(club.getAssociation().getName());
                    }
                });

                editButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int i = findClub(clubDropdown.getSelectedItem().toString());
                        club.setUsername(usernameField.getText());
                        club.setPassword(passwordField1.getText());
                        club.setCode(Integer.parseInt(idField.getText()));
                        club.setName(nameField.getText());
                        club.setColour(colourField.getText());
                        String selectedObjectName = (String) coachDropdown.getSelectedItem();
                        // Find the object with the selected name
                        for (Coach obj : fileManager.getCoachList()) {
                            if (obj.getName().equals(selectedObjectName)) {
                                coach = obj;
                                break;
                            }
                        }
                        club.setHeadCoach(coach);

                        String test = associationDropdown.getSelectedItem().toString();

                        if (!club.getAssociation().getName().equals(test)) {
                            int j = findAssociation(club.getAssociation().getName());
                            association = associationList.get(i);
                            association.setClubNumber(association.getClubNumber() - 1);
                            fileManager.editAssociation(association, j);

                            int a = findAssociation(test);
                            association = associationList.get(a);
                            association.setClubNumber(association.getClubNumber() + 1);
                            fileManager.editAssociation(association, a);
                            club.setAssociation(association);
                        }

                        fileManager.editClub(club, i);
                        JOptionPane.showMessageDialog(Menu.this, "Account Edited", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                        editAccountMenuPanel.setVisible(false);
                        mainMenuPanel.setVisible(true);
                        MainMenu();
                    }
                });

                break;

            case "Coach":
                editAccountMenuPanel.add(coachDropdown);
                editAccountMenuPanel.add(new JLabel("Username:"));
                editAccountMenuPanel.add(usernameField);
                editAccountMenuPanel.add(new JLabel("Password:"));
                editAccountMenuPanel.add(passwordField1);
                editAccountMenuPanel.add(new JLabel("TRN:"));
                editAccountMenuPanel.add(idField);
                idField.setDocument(new IntegerDocument());
                editAccountMenuPanel.add(new JLabel("First Name:"));
                editAccountMenuPanel.add(nameField);
                editAccountMenuPanel.add(new JLabel("Middle Name:"));
                editAccountMenuPanel.add(nameField1);
                editAccountMenuPanel.add(new JLabel("Last Name:"));
                editAccountMenuPanel.add(nameField2);
                editAccountMenuPanel.add(new JLabel("Gender (M/F):"));
                genderField.setDocument(new CharDocument());
                editAccountMenuPanel.add(genderField);
                editAccountMenuPanel.add(new JLabel("Employment Date (MM/DD/YYYY):"));
                dateField = new JFormattedTextField(createMaskFormatter("##/##/####"));
                editAccountMenuPanel.add(dateField);
                editAccountMenuPanel.add(new JLabel("Seperation Date (MM/DD/YYYY):"));
                dateField1 = new JFormattedTextField(createMaskFormatter("##/##/####"));
                editAccountMenuPanel.add(dateField1);

                coachDropdown.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String selectedObjectName = (String) coachDropdown.getSelectedItem();
                        int i = findCoach(selectedObjectName);
                        coach = coachList.get(i);

                        usernameField.setText(coach.getUsername());
                        passwordField1.setText(coach.getPassword());
                        idField.setText(String.valueOf(coach.getTRN()));
                        nameField.setText(coach.getFirstName());
                        nameField1.setText(coach.getMiddleName());
                        nameField2.setText(coach.getLastName());
                        genderField.setText(String.valueOf(coach.getGender())); // Convert char to string
                        dateField.setText(coach.getEmp_Date());
                        dateField1.setText(coach.getSep_Date());
                    }
                });

                editButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int i = findCoach(coachDropdown.getSelectedItem().toString());
                        coach.setUsername(usernameField.getText());
                        coach.setPassword(passwordField1.getText());
                        coach.setTRN(Integer.parseInt(idField.getText()));
                        coach.setFirstName(nameField.getText());
                        coach.setMiddleName(nameField1.getText());
                        coach.setLastName(nameField2.getText());
                        coach.setGender(genderField.getText().charAt(0));
                        coach.setEmp_Date(dateField.getText());
                        coach.setSep_Date(dateField1.getText());
                        fileManager.editCoach(coach, i);
                        JOptionPane.showMessageDialog(Menu.this, "Account Edited", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                        editAccountMenuPanel.setVisible(false);
                        mainMenuPanel.setVisible(true);
                        MainMenu();
                    }
                });
                break;

            case "Athlete":

                clubDropdown.addItem("None");
                coachDropdown.addItem("None");
                sponsorDropdown.addItem("None");
                editAccountMenuPanel.add(athleteDropdown);
                editAccountMenuPanel.add(new JLabel("Username:"));
                editAccountMenuPanel.add(usernameField);
                editAccountMenuPanel.add(new JLabel("Password:"));
                editAccountMenuPanel.add(passwordField1);
                editAccountMenuPanel.add(new JLabel("Club Password:"));
                editAccountMenuPanel.add(clubPasswordField);
                editAccountMenuPanel.add(new JLabel("TRN:"));
                editAccountMenuPanel.add(idField);
                idField.setDocument(new IntegerDocument());
                editAccountMenuPanel.add(new JLabel("First Name:"));
                editAccountMenuPanel.add(nameField);
                editAccountMenuPanel.add(new JLabel("Middle Name:"));
                editAccountMenuPanel.add(nameField1);
                editAccountMenuPanel.add(new JLabel("Last Name:"));
                editAccountMenuPanel.add(nameField2);
                editAccountMenuPanel.add(new JLabel("Gender (M/F):"));
                genderField.setDocument(new CharDocument());
                editAccountMenuPanel.add(genderField);
                editAccountMenuPanel.add(new JLabel("Date of Birth (MM/DD/YYYY):"));
                dateField = new JFormattedTextField(createMaskFormatter("##/##/####"));
                editAccountMenuPanel.add(dateField);
                editAccountMenuPanel.add(new JLabel("Height (cm):"));
                editAccountMenuPanel.add(heightField);
                editAccountMenuPanel.add(new JLabel("Weight (kg):"));
                editAccountMenuPanel.add(weightField);
                editAccountMenuPanel.add(new JLabel("Nationality:"));
                editAccountMenuPanel.add(nationalityField);
                editAccountMenuPanel.add(new JLabel("Agent First Name:"));
                editAccountMenuPanel.add(nameField3);
                editAccountMenuPanel.add(new JLabel("Agent Last Name:"));
                editAccountMenuPanel.add(nameField4);
                editAccountMenuPanel.add(new JLabel("Coach:"));
                editAccountMenuPanel.add(coachDropdown);
                editAccountMenuPanel.add(new JLabel("Club:"));
                editAccountMenuPanel.add(clubDropdown);
                editAccountMenuPanel.add(new JLabel("Sponsor:"));
                editAccountMenuPanel.add(sponsorDropdown);

                athleteDropdown.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String selectedObjectName = (String) athleteDropdown.getSelectedItem();
                        int i = findAthlete(selectedObjectName);
                        athlete = athleteList.get(i);
                        usernameField.setText(athlete.getUsername());
                        passwordField1.setText(athlete.getPassword());
                        clubPasswordField.setText(athlete.getClubPassword());
                        idField.setText(String.valueOf(athlete.getTRN()));
                        nameField.setText(athlete.getFirstName());
                        nameField1.setText(athlete.getMiddleName());
                        nameField2.setText(athlete.getLastName());
                        genderField.setText(String.valueOf(athlete.getGender()));
                        dateField.setText(athlete.getDOB());
                        heightField.setText(String.valueOf(athlete.getHeight())); // Convert float to string
                        weightField.setText(String.valueOf(athlete.getWeight()));
                        nationalityField.setText(athlete.getNationality());
                        nameField3.setText(athlete.getAgent().getFirstName());
                        nameField4.setText(athlete.getAgent().getLastName());
                        coachDropdown.setSelectedItem(athlete.getCoach().getName());
                        clubDropdown.setSelectedItem(athlete.getClub().getName());
                        sponsorDropdown.setSelectedItem(athlete.getSponsor().getName());
                    }
                });

                editButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // used as the values for the index of classes within the athlete creation
                        // section as that would be the trigger that updates the rest of the classes
                        // concerning their salary by setting off each one of their salary functions
                        int a = 0, b = 0, c = 0;
                        int i = findAthlete(athleteDropdown.getSelectedItem().toString());
                        athlete.setUsername(usernameField.getText());
                        athlete.setPassword(passwordField1.getText());
                        athlete.setClubPassword(clubPasswordField.getText());
                        athlete.setTRN(Integer.parseInt(idField.getText()));
                        athlete.setFirstName(nameField.getText());
                        athlete.setMiddleName(nameField1.getText());
                        athlete.setLastName(nameField2.getText());
                        athlete.setGender(genderField.getText().charAt(0));
                        athlete.setDOB(dateField.getText());
                        athlete.setHeight(Float.parseFloat(heightField.getText()));
                        athlete.setWeight(Float.parseFloat(weightField.getText()));
                        athlete.setNationality(nationalityField.getText());
                        Agent agent = new Agent(nameField3.getText(), nameField4.getText());
                        athlete.setAgent(agent);

                        String selectedObjectName = (String) sponsorDropdown.getSelectedItem();

                        if (sponsorDropdown.getSelectedItem().equals("None")) {
                            sponsor = new Sponsor();
                        } else {
                            a = findSponsor(selectedObjectName);

                            sponsor = sponsorList.get(a);
                            LocalDate currentDate = LocalDate.now();

                            // Define the desired date format
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

                            // Format the current date as a string
                            String todayDate = currentDate.format(formatter);
                            sponsor.setSponsorshipDate(todayDate);
                        }
                        athlete.setSponsor(sponsor);

                        selectedObjectName = (String) coachDropdown.getSelectedItem();
                        if (coachDropdown.getSelectedItem().equals("None")) {
                            coach = new Coach();
                        } else {
                            b = findCoach(selectedObjectName);
                            coach = coachList.get(b);
                        }
                        athlete.setCoach(coach);

                        selectedObjectName = (String) clubDropdown.getSelectedItem();
                        if (clubDropdown.getSelectedItem().equals("None")) {
                            club = new Club();
                        } else {
                            c = findClub(selectedObjectName);

                            club = clubList.get(c);
                        }

                        athlete.setClub(club);

                        athlete.setFullName();
                        athlete.PayFees();
                        club = athlete.getClub();
                        club.setTotalMembership(club.getTotalMembership() + 1);

                        if (athlete.getSponsor() != null || !athlete.getSponsor().getName().isEmpty()) {
                            selectedObjectName = club.getHeadCoach().getName();
                            int d = findCoach(selectedObjectName);
                            club.setHeadCoach(coachList.get(d));
                            club.PayFees();
                            fileManager.editCoach(club.getHeadCoach(), d);
                        }

                        fileManager.editClub(club, c);
                        fileManager.editCoach(athlete.getCoach(), b);
                        fileManager.editSponsor(athlete.getSponsor(), a);
                        fileManager.editAthlete(athlete, i);

                        JOptionPane.showMessageDialog(Menu.this, "Account Edited", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                        editAccountMenuPanel.setVisible(false);
                        mainMenuPanel.setVisible(true);
                        MainMenu();
                    }
                });
                break;

            case "Sponsor":
                editAccountMenuPanel.add(sponsorDropdown);
                editAccountMenuPanel.add(new JLabel("Name:"));
                editAccountMenuPanel.add(nameField);
                editAccountMenuPanel.add(new JLabel("Amount:"));
                amountField.setDocument(new FloatDocument());
                editAccountMenuPanel.add(amountField);
                sponsorDropdown.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String selectedObjectName = (String) sponsorDropdown.getSelectedItem();
                        int i = findSponsor(selectedObjectName);

                        sponsor = sponsorList.get(i);

                        nameField.setText(sponsor.getName());
                        amountField.setText(String.valueOf(sponsor.getAmount()));
                    }
                });

                editAccountMenuPanel.add(editButton);

                editButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int i = findSponsor(sponsorDropdown.getSelectedItem().toString());
                        sponsor.setName(nameField.getText());
                        sponsor.setAmount(Float.parseFloat(amountField.getText()));
                        fileManager.editSponsor(sponsor, i);
                        JOptionPane.showMessageDialog(Menu.this, "Account Edited", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                        editAccountMenuPanel.setVisible(false);
                        mainMenuPanel.setVisible(true);
                        MainMenu();
                    }
                });
                break;

        }
        editAccountMenuPanel.add(editButton);
        JButton backButton = new JButton("Back");
        editAccountMenuPanel.add(backButton);
        backButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                editAccountMenuPanel.setVisible(false);
                mainMenuPanel.setVisible(true);
                MainMenu();
            }

        });
        add(editAccountMenuPanel);

    }

    private void DeleteAccountMenu(String user) {
        deleteAccountMenuPanel.setLayout(new GridLayout(0, 1));
        deleteAccountMenuPanel.removeAll();
        deleteAccountMenuPanel.add(new JLabel("DELETE ACCOUNT", SwingConstants.CENTER));
        JButton deleteButton = new JButton("Delete");

        switch (user) {
            case "Association":
                deleteAccountMenuPanel.add(new JLabel("Deleting Association:"));
                deleteAccountMenuPanel.add(associationDropdown);
                deleteButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String selectedObjectName = (String) associationDropdown.getSelectedItem();
                        int i = findAssociation(selectedObjectName);
                        fileManager.removeAssociation(associationList.get(i));
                    }
                });
                break;

            case "Club":
                deleteAccountMenuPanel.add(new JLabel("Deleting Club:"));
                deleteAccountMenuPanel.add(clubDropdown);
                deleteButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String selectedObjectName = (String) clubDropdown.getSelectedItem();
                        int i = findClub(selectedObjectName);
                        fileManager.removeClub(clubList.get(i));
                    }
                });
                break;

            case "Coach":
                deleteAccountMenuPanel.add(new JLabel("Deleting Coach:"));
                deleteAccountMenuPanel.add(coachDropdown);
                deleteButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String selectedObjectName = coachDropdown.getSelectedItem().toString();
                        int i = findCoach(selectedObjectName);
                        fileManager.removeCoach(coachList.get(i));
                    }
                });
                break;

            case "Athlete":
                deleteAccountMenuPanel.add(new JLabel("Deleting Athlete:"));
                deleteAccountMenuPanel.add(athleteDropdown);
                deleteButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String selectedObjectName = (String) athleteDropdown.getSelectedItem();
                        int i = findAthlete(selectedObjectName);
                        fileManager.removeAthlete(athleteList.get(i));
                    }
                });
                break;

            case "Sponsor":
                deleteAccountMenuPanel.add(new JLabel("Deleting Sponsor:"));
                deleteAccountMenuPanel.add(sponsorDropdown);
                deleteButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String selectedObjectName = (String) sponsorDropdown.getSelectedItem();
                        int i = findSponsor(selectedObjectName);
                        fileManager.removeSponsor(sponsorList.get(i));
                    }
                });
                break;

        }
        deleteAccountMenuPanel.add(deleteButton);
        JButton backButton = new JButton("Back");
        deleteAccountMenuPanel.add(backButton);
        backButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                deleteAccountMenuPanel.setVisible(false);
                mainMenuPanel.setVisible(true);
                MainMenu();
            }

        });
        add(deleteAccountMenuPanel);
    }

    public void MinistryPrograms() {
        ministryPanel.setLayout(new GridLayout(0, 1));
        ministryPanel.removeAll();
        ministryPanel.add(new JLabel("Ministry Panel", SwingConstants.CENTER));

        ministryPanel.add(new JLabel("National Seminar - 13/04/2024  ", SwingConstants.LEFT));
        ministryPanel.add(new JLabel("Liscensing Events for Coaches - 18/05/2025 ", SwingConstants.LEFT));
        ministryPanel.add(new JLabel("Liscensing Events for Athlete - 09/09/2024 ", SwingConstants.LEFT));
        ministryPanel.add(new JLabel("Training Workshop- 10/04/2024 ", SwingConstants.LEFT));
        ministryPanel.add(new JLabel("Coaching Workshop- 06/12/2024 ", SwingConstants.LEFT));
        ministryPanel.add(new JLabel("Anti-Doping Workshop- 05/11/2025 ", SwingConstants.LEFT));

        JButton backButton = new JButton("Back");
        ministryPanel.add(backButton);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ministryPanel.setVisible(false);
                mainMenuPanel.setVisible(true);
                MainMenu();
            }
        });

        add(ministryPanel);

    }

    public void SportsEvents() {
        eventsPanel.setLayout(new GridLayout(0, 1));
        eventsPanel.removeAll();
        eventsPanel.add(new JLabel("Sporting Events", SwingConstants.CENTER));
        if ((adminLevel == 0 && !athleteUser.getClub().getName().isEmpty()) || (adminLevel > 1)) {
            FindCriteria();
        }

        if (sport != null || !sport.isEmpty()) {
            if (sport.equalsIgnoreCase("Basketball")) {
                addEvents("Basketball Events", "1. Basketball Game - Date: 10/07/2024",
                        "2. Basketball Game - Date: 15/10/2024");
            } else if (sport.equalsIgnoreCase("Football")) {
                addEvents("Football Events", "1. Football Game - Date: 11/04/2024",
                        "2. Football Game - Date: 03/10/2024");
            } else if (sport.equalsIgnoreCase("Netball")) {
                addEvents("Netball Events", "1. Netball Game - Date: 10/09/2025",
                        "2. Netball Game - Date: 09/10/2025");
            } else if (sport.equalsIgnoreCase("Track and Field")) {
                addEvents("Track and Field Events", "1. Track and Field Game - Date: 26/05/2024",
                        "2. Track and Field Game - Date: 10/06/2024");
            } else if (sport.equalsIgnoreCase("Cricket")) {
                addEvents("Cricket Events", "1. Cricket Game - Date: 16/07/2025",
                        "2. Cricket Game - Date: 10/05/2025");
            }
        }

        JScrollPane scrollBar = new JScrollPane(eventsPanel); // Wrap ministryPanel with a scroll pane
        add(scrollBar, BorderLayout.CENTER);
        JButton backButton = new JButton("Back");
        eventsPanel.add(backButton);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eventsPanel.setVisible(false);
                mainMenuPanel.setVisible(true);
                MainMenu();
            }
        });

        add(eventsPanel);
    }

    public void Salary() {
        salaryPanel.setLayout(new GridLayout(0, 1));
        salaryPanel.removeAll();
        salaryPanel.add(new JLabel("Salary", SwingConstants.CENTER));

        float salary;
        float yearSalary;
        switch (adminLevel) {
            case 1: // for coach
                salary = coachUser.getCommission();
                yearSalary = salary * 12;
                salaryPanel
                        .add(new JLabel("Commission for Coach per Month: $" + String.format("%.2f", salary),
                                SwingConstants.LEFT));
                salaryPanel.add(
                        new JLabel("Commission for Coach per Year: $" + String.format("%.2f", yearSalary),
                                SwingConstants.LEFT));
                break;
            case 2: // for club
                salary = clubUser.getSalary();
                yearSalary = salary * 12;
                salaryPanel
                        .add(new JLabel("Salary for Club per Month: $" + String.format("%.2f", salary),
                                SwingConstants.LEFT));
                salaryPanel
                        .add(new JLabel("Salary for Club per Year: %" + String.format("%.2f", yearSalary),
                                SwingConstants.LEFT));
                break;
            case 3: // for association
                salary = associationUser.getSalary();
                yearSalary = salary * 12;
                salaryPanel
                        .add(new JLabel("Salary for Club per Month: $" + String.format("%.2f", salary),
                                SwingConstants.LEFT));
                salaryPanel
                        .add(new JLabel("Salary for Club per Year: %" + String.format("%.2f", yearSalary),
                                SwingConstants.LEFT));
                break;
        }

        JButton backButton = new JButton("Back");
        salaryPanel.add(backButton);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salaryPanel.setVisible(false);
                mainMenuPanel.setVisible(true);
                MainMenu();
            }
        });
        add(salaryPanel);
    }

    private void Nationality() {
        nationalityPanel.setLayout(new GridLayout(0, 1));
        nationalityPanel.removeAll();
        nationalityPanel.add(new JLabel("Nationality", SwingConstants.CENTER));

        athleteList = fileManager.getAthleteList();
        List<String> uniqueNationalities = new ArrayList<>();

        for (Athlete athlete : athleteList) {
            String nationality = athlete.getNationality();
            if (nationality != null && !uniqueNationalities.contains(nationality)) {
                uniqueNationalities.add(nationality);
            }
        }

        // Iterate over the unique nationalities and count occurrences in the athlete
        // list
        for (String nationality : uniqueNationalities) {
            int count = 0;
            for (Athlete athlete : athleteList) {
                if (nationality.equals(athlete.getNationality())) {
                    count++;
                }
            }

            nationalityPanel.add(new JLabel(nationality + ": " + count));

            JScrollPane scrollPane = new JScrollPane(nationalityPanel);
            add(scrollPane, BorderLayout.CENTER);

            JButton backButton = new JButton("Back");
            nationalityPanel.add(backButton);
            backButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    nationalityPanel.setVisible(false);
                    mainMenuPanel.setVisible(true);
                    MainMenu();
                }
            });
        }
        add(nationalityPanel);
    }

    public void Demographics() {
        // Create the demographics panel
        demographicsPanel.setLayout(new GridLayout(0, 1));
        demographicsPanel.removeAll();
        demographicsPanel.add(new JLabel("Demographics", SwingConstants.CENTER));

        // Iterate over the association list
        for (Association association : fileManager.getAssociationList()) {
            // Retrieve the required data for each association
            String associationName = association.getName();
            int numAthletes = countAllAthletes(fileManager.getAthleteList()); // Overall count
            int numWithSponsorship = withSponsorship(fileManager.getAthleteList()); // With sponsorship count
            int numWithoutSponsorship = withoutSponsorship(fileManager.getAthleteList()); // Without sponsorship count
            int numInFederation = countAthletes(fileManager.getAthleteList()); // Num athletes in Association
            int numUnattached = countNoClub(fileManager.getAthleteList()); // Num of athletes without a club

            // Create separate JLabels for each piece of information
            JLabel associationLabel = new JLabel("Association: " + associationName);
            JLabel numAthletesLabel = new JLabel("Number of Athletes: " + numAthletes);
            JLabel withSponsorshipLabel = new JLabel("With Sponsorship: " + numWithSponsorship);
            JLabel withoutSponsorshipLabel = new JLabel("Without Sponsorship: " + numWithoutSponsorship);
            JLabel inFederationLabel = new JLabel("In Federation: " + numInFederation);
            JLabel unattachedAthletesLabel = new JLabel("Unattached Athletes: " + numUnattached);

            demographicsPanel.add(associationLabel);
            demographicsPanel.add(numAthletesLabel);
            demographicsPanel.add(withSponsorshipLabel);
            demographicsPanel.add(withoutSponsorshipLabel);
            demographicsPanel.add(inFederationLabel);
            demographicsPanel.add(unattachedAthletesLabel);

        }

        // Define column headers
        String[] columnHeaders = { "Coach Name", "Number of Athletes" };

        // Initialize data array with the size of coach list
        Object[][] data = new Object[fileManager.getCoachList().size()][2];

        // Iterate through coach list
        for (int i = 0; i < fileManager.getCoachList().size(); i++) {
            Coach coach = fileManager.getCoachList().get(i);
            String coachName = coach.getName();

            // Count the number of athletes coached by this coach
            int numAthletesCoached = 0;
            for (Athlete athlete : fileManager.getAthleteList()) {
                if (athlete.getCoach().getName().equals(coachName)) {
                    numAthletesCoached++;
                }
            }

            // Add coach name and number of athletes to data array
            data[i][0] = coachName;
            data[i][1] = numAthletesCoached;
        }

        // Create table model with data and column headers
        DefaultTableModel model = new DefaultTableModel(data, columnHeaders);

        // Create JTable with the model
        JTable table = new JTable(model);
        demographicsPanel.add(table);

        JButton backButton = new JButton("Back");
        demographicsPanel.add(backButton);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                demographicsPanel.setVisible(false);
                mainMenuPanel.setVisible(true);
                MainMenu();
            }
        });

        add(demographicsPanel);
    }

    public void Sponsorship() {
        sponsorPanel.setLayout(new GridLayout(0, 1));
        sponsorPanel.removeAll();
        sponsorPanel.add(new JLabel("Available Sponsors", SwingConstants.CENTER));

        for (Sponsor sponsor : fileManager.getSponsorList()) {
            if (sponsor.getAthleteName() == null) {
                // Create a label to display sponsor details
                JLabel sponsorLabel = new JLabel("Name: " + sponsor.getName() + ", Amount: $" + sponsor.getAmount());
                sponsorPanel.add(sponsorLabel);
            } else if (sponsor.getAthleteName() != null) {
                if (sponsor.getAthleteName().isEmpty()) {
                    // Create a label to display sponsor details
                    JLabel sponsorLabel = new JLabel(
                            "Name: " + sponsor.getName() + ", Amount: $" + sponsor.getAmount());
                    sponsorPanel.add(sponsorLabel);
                }
            }

        }

        JButton backButton = new JButton("Back");
        sponsorPanel.add(backButton);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sponsorPanel.setVisible(false);
                mainMenuPanel.setVisible(true);
                MainMenu();
            }
        });

        add(sponsorPanel);
    }

    private void ClubLogin() {
        clubLoginPanel.setLayout(new GridLayout(0, 1));
        clubLoginPanel.removeAll();
        clubLoginPanel.add(new JLabel("MAIN MENU", SwingConstants.CENTER));

        clubLoginPanel.add(new JLabel("TRN:"));
        clubLoginPanel.add(usernameField);
        usernameField.setDocument(new IntegerDocument());
        clubLoginPanel.add(new JLabel("Password:"));
        clubLoginPanel.add(passwordField);
        usernameField.setText("");
        passwordField.setText("");

        JButton loginButton = new JButton("Login");
        clubLoginPanel.add(loginButton);
        JButton backButton = new JButton("Back");
        clubLoginPanel.add(backButton);

        attempts = 3;
        loggedIn = false;

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clubLoginPanel.setVisible(false);
                mainMenuPanel.setVisible(true);
                MainMenu();
            }
        });

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Boolean test;
                username = usernameField.getText();
                password = new String(passwordField.getPassword());
                test = athleteUser.ClubLogin(fileManager.getAthleteList(), Integer.parseInt(username), password);

                if (test == true) {
                    if (!loggedIn) {
                        JOptionPane.showMessageDialog(Menu.this, "Login Successful!", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                        loggedIn = true;
                    }

                    clubLoginPanel.setVisible(false);
                    clubPanel.setVisible(true);
                    Clubs();

                } else {
                    attempts--;
                    if (attempts == 0) {
                        JOptionPane.showMessageDialog(Menu.this, "Incorrect username or password.", "Login Error",
                                JOptionPane.ERROR_MESSAGE);
                        System.exit(1);
                    } else {
                        JOptionPane.showMessageDialog(Menu.this,
                                "Invalid username or password. Attempts remaining: " + attempts,
                                "Error", JOptionPane.ERROR_MESSAGE);
                        usernameField.setText("");
                        passwordField.setText("");
                    }

                }
            }
        });
        add(clubLoginPanel);
    }

    private void Clubs() {
        clubPanel.setLayout(new GridLayout(0, 1));
        clubPanel.removeAll();
        clubPanel.add(new JLabel("Clubs", SwingConstants.CENTER));
        switch (adminLevel) {
            case 0:
                club = athleteUser.getClub();
                textArea.append("Club Name: " + club.getName() + "\n");
                textArea.append("Club Code: " + club.getCode() + "\n");
                textArea.append("Club Colour: " + club.getColour() + "\n");
                textArea.append("Total Membership: " + club.getTotalMembership() + "\n");
                textArea.append("President: " + club.getPresident() + "\n");
                textArea.append("Head Coach: " + club.getHeadCoach().getName() + "\n");
                textArea.append("Association: " + club.getAssociation().getName() + "\n\n");

                // Display list of athletes in the club
                textArea.append("Athletes:\n");
                for (Athlete athlete : fileManager.getAthleteList()) {
                    if (athlete.getClub() != null
                            && athlete.getClub().getName().equals(athleteUser.getClub().getName())) {
                        textArea.append("- " + athlete.getName() + "\n");
                    }
                }
                clubPanel.add(new JScrollPane(textArea));
                break;

            case 2:
                textArea.append("Club Name: " + clubUser.getName() + "\n");
                textArea.append("Club Code: " + clubUser.getCode() + "\n");
                textArea.append("Club Colour: " + clubUser.getColour() + "\n");
                textArea.append("Total Membership: " + clubUser.getTotalMembership() + "\n");
                textArea.append("President: " + clubUser.getPresident() + "\n");
                textArea.append("Head Coach: " + clubUser.getHeadCoach().getName() + "\n");
                textArea.append("Association: " + clubUser.getAssociation().getName() + "\n\n");

                // Display list of athletes in the club
                textArea.append("Athletes:\n");
                for (Athlete athlete : fileManager.getAthleteList()) {
                    if (athlete.getClub() != null && athlete.getClub().getName().equals(clubUser.getName())) {
                        textArea.append("- " + athlete.getName() + "\n");
                    }
                }
                clubPanel.add(new JScrollPane(textArea));
                break;

            case 3:
                for (Club club : fileManager.getClubList()) {
                    if (club.getAssociation().getName().equals(associationUser.getName())) {
                        textArea.append("Club Name: " + club.getName() + "\n");
                        textArea.append("Club Code: " + club.getCode() + "\n");
                        textArea.append("Club Colour: " + club.getColour() + "\n");
                        textArea.append("Total Membership: " + club.getTotalMembership() + "\n");
                        textArea.append("President: " + club.getPresident() + "\n");
                        textArea.append("Head Coach: " + club.getHeadCoach().getName() + "\n");
                        textArea.append("Association: " + club.getAssociation().getName() + "\n\n");

                        // Display list of athletes in the club
                        textArea.append("Athletes:\n");
                        for (Athlete athlete : fileManager.getAthleteList()) {
                            if (athlete.getClub() != null && athlete.getClub().getName().equals(club.getName())) {
                                textArea.append("- " + athlete.getName() + "\n");
                            }
                        }
                        textArea.append("\n");
                    }
                }
                clubPanel.add(new JScrollPane(textArea));
                break;

            case 4:
                for (Association a : fileManager.getAssociationList()) {
                    if (a.getSport().equals(sport)) {
                        association = a;
                    }
                }

                for (Club club : fileManager.getClubList()) {
                    if (club.getAssociation().getName().equals(association.getName())) {
                        textArea.append("Club Name: " + club.getName() + "\n");
                        textArea.append("Club Code: " + club.getCode() + "\n");
                        textArea.append("Club Colour: " + club.getColour() + "\n");
                        textArea.append("Total Membership: " + club.getTotalMembership() + "\n");
                        textArea.append("President: " + club.getPresident() + "\n");
                        textArea.append("Head Coach: " + club.getHeadCoach().getName() + "\n");
                        textArea.append("Association: " + club.getAssociation().getName() + "\n\n");

                        // Display list of athletes in the club
                        textArea.append("Athletes:\n");
                        for (Athlete athlete : fileManager.getAthleteList()) {
                            if (athlete.getClub() != null && athlete.getClub().getName().equals(club.getName())) {
                                textArea.append("- " + athlete.getName() + "\n");
                            }
                        }
                        textArea.append("\n");
                    }
                }
                clubPanel.add(new JScrollPane(textArea));
                break;
        }

        clubPanel.add(backButton);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clubPanel.setVisible(false);
                mainMenuPanel.setVisible(true);
                MainMenu();
            }
        });

        add(clubPanel);
        revalidate(); // Revalidate the container to ensure proper layout
        repaint(); // Repaint the container to update its appearance
    }

}

// ALLOWS FOR TEXT FIELDS TO ONLY ACCEPT CHARS
class CharDocument extends PlainDocument {
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (str == null || str.length() != 1) {
            return;
        }

        super.insertString(offs, str, a);
    }
}

// ALLOWS FOR TEXT FIELDS TO ONLY ACCEPT INTEGERS
class IntegerDocument extends PlainDocument {
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (str == null) {
            return;
        }

        try {
            Integer.parseInt(str);
            super.insertString(offs, str, a);
        } catch (NumberFormatException e) {
            // Ignore if not a valid integer
        }
    }
}

// ALLOWS FOR TEXT FIELDS TO ONLY ACCEPT FLOATS
class FloatDocument extends PlainDocument {
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (str == null) {
            return;
        }

        String currentText = getText(0, getLength());
        String beforeOffset = currentText.substring(0, offs);
        String afterOffset = currentText.substring(offs);
        String newText = beforeOffset + str + afterOffset;

        // Allow digits, a single dot, or an optional negative sign at the beginning
        if (isValidFloat(newText)) {
            super.insertString(offs, str, a);
        }
    }

    private boolean isValidFloat(String str) {
        // Allow empty string or a single dot
        if (str.isEmpty() || str.equals(".")) {
            return true;
        }

        // Allow an optional negative sign at the beginning
        if (str.startsWith("-")) {
            str = str.substring(1);
        }

        // Allow digits, but only a single dot
        boolean dotSeen = false;
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                if (c == '.' && !dotSeen) {
                    dotSeen = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}