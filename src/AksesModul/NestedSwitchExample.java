package AksesModul;

import java.util.Scanner;

public class NestedSwitchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Menu Pilihan Hari:");
            System.out.println("1. Senin");
            System.out.println("2. Selasa");
            System.out.println("3. Rabu");
            System.out.println("4. Kamis");
            System.out.println("5. Keluar");
            System.out.print("Masukkan angka (1-5): ");
            int day = scanner.nextInt();

            switch (day) {
                case 1:
                    System.out.println("Anda memilih: Senin");
                    System.out.println("Aktivitas pada Senin:");
                    System.out.println("1. Kerja");
                    System.out.println("2. Olahraga");
                    System.out.print("Pilih aktivitas (1-2): ");
                    int activitySenin = scanner.nextInt();
                    switch (activitySenin) {
                        case 1:
                            System.out.println("Anda memilih: Kerja pada Senin");
                            break;
                        case 2:
                            System.out.println("Anda memilih: Olahraga pada Senin");
                            break;
                        default:
                            System.out.println("Pilihan aktivitas tidak valid!");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Anda memilih: Selasa");
                    System.out.println("Aktivitas pada Selasa:");
                    System.out.println("1. Belajar");
                    System.out.println("2. Rekreasi");
                    System.out.print("Pilih aktivitas (1-2): ");
                    int activitySelasa = scanner.nextInt();
                    switch (activitySelasa) {
                        case 1:
                            System.out.println("Anda memilih: Belajar pada Selasa");
                            break;
                        case 2:
                            System.out.println("Anda memilih: Rekreasi pada Selasa");
                            break;
                        default:
                            System.out.println("Pilihan aktivitas tidak valid!");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Anda memilih: Rabu");
                    System.out.println("Aktivitas pada Rabu:");
                    System.out.println("1. Membaca");
                    System.out.println("2. Menulis");
                    System.out.print("Pilih aktivitas (1-2): ");
                    int activityRabu = scanner.nextInt();
                    switch (activityRabu) {
                        case 1:
                            System.out.println("Anda memilih: Membaca pada Rabu");
                            break;
                        case 2:
                            System.out.println("Anda memilih: Menulis pada Rabu");
                            break;
                        default:
                            System.out.println("Pilihan aktivitas tidak valid!");
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Anda memilih: Kamis");
                    System.out.println("Aktivitas pada Kamis:");
                    System.out.println("1. Memasak");
                    System.out.println("2. Berkebun");
                    System.out.print("Pilih aktivitas (1-2): ");
                    int activityKamis = scanner.nextInt();
                    switch (activityKamis) {
                        case 1:
                            System.out.println("Anda memilih: Memasak pada Kamis");
                            break;
                        case 2:
                            System.out.println("Anda memilih: Berkebun pada Kamis");
                            break;
                        default:
                            System.out.println("Pilihan aktivitas tidak valid!");
                            break;
                    }
                    break;
                case 5:
                    System.out.println("Keluar dari program...");
                    exit = true;
                    break;
                default:
                    System.out.println("Angka tidak valid! Masukkan angka antara 1 dan 5.");
                    break;
            }
            System.out.println();  // Menambahkan baris kosong untuk pemisah antar iterasi
        }

        scanner.close();
    }
}
