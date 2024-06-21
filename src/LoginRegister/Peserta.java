package LoginRegister;

import Kursus.Kursus;
import Kursus.ModulStatus;
import Kursus.Tugas;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Peserta extends User implements Auth, ShowDashboard {
    private String profession;
    private String reasonForJoining;
    private String courseSelection;
    private ArrayList<String> registeredCourses;
    static ArrayList<Peserta> pesertaList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    private ArrayList<ModulStatus> modulStatusList;

    public Peserta() {
        // Default constructor
        this.registeredCourses = new ArrayList<>();
        this.modulStatusList = new ArrayList<>();
    }

    @Override
    public void register() {
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Age: ");
        int age = Integer.parseInt(scanner.nextLine());
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
        System.out.print("Course Selection: ");
        String courseSelection = scanner.nextLine();

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.profession = profession;
        this.reasonForJoining = reasonForJoining;
        this.courseSelection = courseSelection;
        pesertaList.add(this);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("peserta.txt", true))) {
            writer.write(firstName + "," + lastName + "," + age + "," + email + "," + password + "," + phoneNumber + "," + profession + "," + reasonForJoining + "," + courseSelection);
            writer.newLine();
            System.out.println("Peserta registered successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while registering the peserta.");
            e.printStackTrace();
        }
    }

    @Override
    public boolean login(String email, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("peserta.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                if (details[3].equals(email) && details[4].equals(password)) {
                    this.firstName = details[0];
                    this.lastName = details[1];
                    this.age = Integer.parseInt(details[2]);
                    this.email = details[3];
                    this.password = details[4];
                    this.phoneNumber = details[5];
                    this.profession = details[6];
                    this.reasonForJoining = details[7];
                    this.courseSelection = details[8];
                    System.out.println("Login successful!");
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while logging in.");
            e.printStackTrace();
        }
        System.out.println("Login failed. Please try again.");
        return false;
    }

    @Override
    public void resetPassword() {
        // Implementation for resetting password
    }

    @Override
    public void showDashboard() {
        System.out.println("=== Peserta Dashboard ===");
        System.out.println("Course Selection: " + this.courseSelection);
        System.out.println("Modules:");
        try (BufferedReader reader = new BufferedReader(new FileReader("modul.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                if (details[0].equals(this.courseSelection)) {
                    System.out.println("- " + details[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the modul.txt file.");
            e.printStackTrace();
        }
    }

    public void displayRegisteredCourses() {
        // Implementation for displaying registered courses
    }

    public void aksesModul(Kursus kursus) {
        // Implementation for accessing modules
    }

    public void cariModul(Kursus kursus, String judul) {
        // Implementation for searching modules
    }

    public void updateModulStatus(String judulModul, String status) {
        // Implementation for updating module status
    }

    public void aksesTugas(Kursus kursus) {
        // Implementation for accessing tasks
    }

    public void tampilkanListTugas(Kursus kursus) {
        // Implementation for displaying task list
    }

    public void lihatDetailTugas(Kursus kursus, String judulTugas) {
        // Implementation for viewing task details
    }

    public void kumpulkanTugas(Kursus kursus, String judulTugas) {
        // Implementation for submitting tasks
    }

    private boolean validateFile(String filePath) {
        // Implementation for validating file
        return true; // Placeholder
    }
}