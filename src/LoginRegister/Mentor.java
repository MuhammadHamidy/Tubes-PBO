package LoginRegister;

import Kursus.Kursus;
import Kursus.Tugas;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Mentor extends User implements Auth, ShowDashboard {
    private String courseSelection;
    private String educationBackground;
    private String certificate;
    static ArrayList<Mentor> mentors = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    private ArrayList<Kursus> kursusList;

    public Mentor() {
        // Default constructor
        this.kursusList = new ArrayList<>();
    }

    @Override
    public void register() {
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Age: ");
        int age = Integer.parseInt(scanner.nextLine());
        if (age < 18) {
            System.out.println("Registration failed. Age must be 18 or older.");
            return;
        }
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

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.courseSelection = courseSelection;
        this.educationBackground = educationBackground;
        this.certificate = certificate;
        mentors.add(this);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("mentor.txt", true))) {
            writer.write(firstName + "," + lastName + "," + age + "," + email + "," + password + "," + phoneNumber + "," + courseSelection + "," + educationBackground + "," + certificate);
            writer.newLine();
            System.out.println("Mentor registered successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while registering the mentor.");
            e.printStackTrace();
        }
    }

    @Override
    public boolean login(String email, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("mentor.txt"))) {
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
                    this.courseSelection = details[6];
                    this.educationBackground = details[7];
                    this.certificate = details[8];
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
        while (true) {
            System.out.println("=== Mentor Dashboard ===");
            System.out.println("1. See Syllabus");
            System.out.println("2. Add Module");
            System.out.println("3. Remove Module");
            System.out.println("4. Exit Dashboard");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    seeSyllabus();
                    break;
                case 2:
                    addModule();
                    break;
                case 3:
                    removeModule();
                    break;
                case 4:
                    System.out.println("Exiting Dashboard...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void seeSyllabus() {
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

    private void addModule() {
        System.out.print("Enter module name to add: ");
        String moduleName = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("modul.txt", true))) {
            writer.write(this.courseSelection + "," + moduleName);
            writer.newLine();
            System.out.println("Module added successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while adding the module.");
            e.printStackTrace();
        }
    }

    private void removeModule() {
        System.out.print("Enter module name to remove: ");
        String moduleName = scanner.nextLine();

        File inputFile = new File("modul.txt");
        File tempFile = new File("modul_temp.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            String line;
            boolean moduleFound = false;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                if (details[0].equals(this.courseSelection) && details[1].equals(moduleName)) {
                    moduleFound = true;
                    continue;
                }
                writer.write(line);
                writer.newLine();
            }

            if (moduleFound) {
                System.out.println("Module removed successfully!");
            } else {
                System.out.println("Module not found.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while removing the module.");
            e.printStackTrace();
        }

        // Replace the original file with the updated file
        if (!inputFile.delete()) {
            System.out.println("Could not delete original file.");
            return;
        }
        if (!tempFile.renameTo(inputFile)) {
            System.out.println("Could not rename temporary file.");
        }
    }

    public void kelolaModul() {
        // Implementation for managing modules
    }

    public void beriTugas(Kursus kursus) {
        System.out.println("=== Beri Tugas ===");
        System.out.print("Judul: ");
        String judul = scanner.nextLine();
        System.out.print("Deskripsi: ");
        String deskripsi = scanner.nextLine();
        System.out.print("Batas Waktu (DD/MM/YY): ");
        String batasWaktu = scanner.nextLine();

        Tugas tugas = new Tugas(judul, deskripsi, batasWaktu);
        kursus.addTugas(tugas);
        System.out.println("Tugas berhasil disimpan dan diunggah.");
    }

    public void hapusTugas(Kursus kursus, String judulTugas) {
        // Implementation for deleting tasks
    }

    public void tampilkanDetailTugas(Tugas tugas) {
        // Implementation for displaying task details
    }
}