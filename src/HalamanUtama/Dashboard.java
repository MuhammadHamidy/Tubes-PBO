package HalamanUtama;

import LoginRegister.Mentor;
import LoginRegister.Peserta;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Dashboard {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("====== Welcome to EduBridge ===========");
        System.out.println("Membantu Talenta Digital Masa Depan! Jadikan hari ini sebagai langkah pertama menuju masa depan gemilang dengan belajar keterampilan baru.");
        while (true) {
            System.out.println("\n1. Login Sebagai Peserta");
            System.out.println("2. Login Sebagai Mentor");
            System.out.println("3. Daftar Sebagai Peserta");
            System.out.println("4. Daftar Sebagai Mentor");
            System.out.println("5. Lihat Semua Kursus");
            System.out.println("6. Exit");
            System.out.print("Pilih opsi: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    loginPeserta();
                    break;
                case 2:
                    loginMentor();
                    break;
                case 3:
                    registerPeserta();
                    break;
                case 4:
                    registerMentor();
                    break;
                case 5:
                    lihatSemuaKursus();
                    break;
                case 6:
                    System.out.println("Terima kasih telah menggunakan EduBridge. Sampai jumpa!");
                    return;
                default:
                    System.out.println("Opsi tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void loginPeserta() {
        Peserta peserta = new Peserta();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        if (peserta.login(email, password)) {
            System.out.println("Login berhasil!");
            peserta.showDashboard();
        } else {
            System.out.println("Login gagal. Silakan coba lagi.");
        }
    }

    private static void loginMentor() {
        Mentor mentor = new Mentor();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        if (mentor.login(email, password)) {
            System.out.println("Login berhasil!");
            mentor.showDashboard();
        } else {
            System.out.println("Login gagal. Silakan coba lagi.");
        }
    }

    private static void registerPeserta() {
        Peserta peserta = new Peserta();
        peserta.register();
    }

    private static void registerMentor() {
        Mentor mentor = new Mentor();
        mentor.register();
    }

    private static void lihatSemuaKursus() {
        try (BufferedReader reader = new BufferedReader(new FileReader("kursus.txt"))) {
            String line;
            System.out.println("=== Daftar Semua Kursus ===");
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                System.out.println("Nama Kursus: " + details[0]);
                System.out.println("Deskripsi Singkat: " + details[1]);
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the kursus.txt file.");
            e.printStackTrace();
        }
    }
}