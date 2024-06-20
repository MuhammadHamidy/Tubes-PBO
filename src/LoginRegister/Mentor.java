package LoginRegister;

import java.util.ArrayList;
import java.util.Scanner;

public class Mentor extends User {
    private String courseSelection;
    private String educationBackground;
    private String certificate;
    static ArrayList<Mentor> mentors = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public Mentor(String firstName, String lastName, String birthDate, String email, String password, String phoneNumber,
                  String courseSelection, String educationBackground, String certificate) {
        super(firstName, lastName, birthDate, email, password, phoneNumber);
        this.courseSelection = courseSelection;
        this.educationBackground = educationBackground;
        this.certificate = certificate;
    }

    public Mentor() {
        // Default constructor
    }

    @Override
    public void register() {
        System.out.println("=== Register as Mentor ===");
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Birth Date: ");
        String birthDate = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Course Selection: ");
        String courseSelection = scanner.nextLine();
        System.out.print("Education Background: ");
        String educationBackground = scanner.nextLine();
        System.out.print("Certificate: ");
        String certificate = scanner.nextLine();

        Mentor newMentor = new Mentor(firstName, lastName, birthDate, email, password, phoneNumber, courseSelection, educationBackground, certificate);
        mentors.add(newMentor);
        System.out.println("Registration successful! Please wait for selection confirmation via email.");
    }

    @Override
    public boolean login(String email, String password) {
        System.out.println("=== Mentor Login ===");
        System.out.print("Email: ");
        email = scanner.nextLine();
        System.out.print("Password: ");
        password = scanner.nextLine();

        for (Mentor mentor : mentors) {
            if (mentor.email.equals(email) && mentor.password.equals(password)) {
                System.out.println("Login successful! Welcome, " + mentor.firstName);
                return true;
            }
        }
        System.out.println("Invalid email or password. Please try again.");
        return false;
    }

    public static void main(String[] args) {
        Mentor mentorSystem = new Mentor();

        while (true) {
            System.out.println("1. Register as Mentor");
            System.out.println("2. Login as Mentor");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    mentorSystem.register();
                    break;
                case 2:
                    mentorSystem.login("", ""); // Empty strings to match method signature
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
}