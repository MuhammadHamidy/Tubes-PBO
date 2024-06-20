package LoginRegister;

import java.util.ArrayList;
import java.util.Scanner;

public class Peserta extends User {
    private String profession;
    private String reasonForJoining;
    private ArrayList<String> registeredCourses;
    static ArrayList<Peserta> pesertaList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public Peserta(String firstName, String lastName, String birthDate, String email, String password, String phoneNumber, String profession, String reasonForJoining) {
        super(firstName, lastName, birthDate, email, password, phoneNumber);
        this.profession = profession;
        this.reasonForJoining = reasonForJoining;
        this.registeredCourses = new ArrayList<>();
    }

    public Peserta() {
        // Default constructor
    }

    @Override
    public void register() {
        System.out.println("=== Register as Peserta ===");
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
        System.out.print("Profession: ");
        String profession = scanner.nextLine();
        System.out.print("Reason for Joining: ");
        String reasonForJoining = scanner.nextLine();

        Peserta newPeserta = new Peserta(firstName, lastName, birthDate, email, password, phoneNumber, profession, reasonForJoining);
        pesertaList.add(newPeserta);
        System.out.println("Registration successful!");
    }

    @Override
    public boolean login(String email, String password) {
        System.out.println("=== Peserta Login ===");
        System.out.print("Email: ");
        email = scanner.nextLine();
        System.out.print("Password: ");
        password = scanner.nextLine();

        for (Peserta peserta : pesertaList) {
            if (peserta.email.equals(email) && peserta.password.equals(password)) {
                System.out.println("Login successful! Welcome, " + peserta.firstName);
                return true;
            }
        }
        System.out.println("Invalid email or password. Please try again.");
        return false;
    }

    public void resetPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your email to reset the password:");
        String inputEmail = scanner.nextLine();

        for (Peserta peserta : pesertaList) {
            if (peserta.email.equals(inputEmail)) {
                System.out.println("Email verified. Enter new password:");
                String newPassword = scanner.nextLine();
                peserta.password = newPassword;
                System.out.println("Password reset successful.");
                return;
            }
        }
        System.out.println("Error: Email not recognized.");
    }

    public void displayRegisteredCourses() {
        System.out.println("Registered Courses:");
        for (String course : registeredCourses) {
            System.out.println(course);
        }
    }

    public static void main(String[] args) {
        Peserta pesertaSystem = new Peserta();

        while (true) {
            System.out.println("1. Register as Peserta");
            System.out.println("2. Login as Peserta");
            System.out.println("3. Reset Password");
            System.out.println("4. Display Registered Courses");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    pesertaSystem.register();
                    break;
                case 2:
                    pesertaSystem.login("", ""); // Empty strings to match method signature
                    break;
                case 3:
                    pesertaSystem.resetPassword();
                    break;
                case 4:
                    pesertaSystem.displayRegisteredCourses();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}