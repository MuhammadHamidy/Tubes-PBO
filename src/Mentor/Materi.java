package Mentor;

import java.util.ArrayList;
import java.util.Scanner;

public class Materi {
    private String judul;
    private String deskripsi;
    private String file;

    public Materi(String judul, String deskripsi, String file) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.file = file;
    }

    //Get & Set
    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}

public class KelolaMateri {
    private ArrayList<Materi> listMateri;
    private Scanner scanner;

    public KelolaMateri() {
        listMateri = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Menampilkan menu "Kelola Materi"
    public void tampilkanMenuKelolaMateri() {
        System.out.println("===== MENU KELOLA MATERI =====");
        System.out.println("1. Tampilkan List Materi");
        System.out.println("2. Unggah Materi Baru");
        System.out.println("3. Keluar");
        System.out.print("Pilihan Anda: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // Membersihkan buffer
        switch (pilihan) {
            case 1:
                tampilkanListMateri();
                break;
            case 2:
                unggahMateriBaru();
                break;
            case 3:
                System.out.println("Terima kasih!");
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    // Metode untuk menampilkan list materi yang sudah ada
    public void tampilkanListMateri() {
        System.out.println("===== LIST MATERI =====");
        if (listMateri.isEmpty()) {
            System.out.println("Belum ada materi.");
        } else {
            for (int i = 0; i < listMateri.size(); i++) {
                Materi materi = listMateri.get(i);
                System.out.println("Materi " + (i + 1));
                System.out.println("Judul: " + materi.getJudul());
                System.out.println("Deskripsi: " + materi.getDeskripsi());
                System.out.println("File: " + materi.getFile());
                System.out.println();
            }
        }
    }

    // Metode untuk mengunggah materi baru
    public void unggahMateriBaru() {
        System.out.println("===== UNGGAH MATERI BARU =====");
        System.out.print("Judul: ");
        String judul = scanner.nextLine();
        System.out.print("Deskripsi (maksimal 500 kata): ");
        String deskripsi = scanner.nextLine();
        System.out.print("Nama file (format mp4, resolusi min 480p, ukuran <2 GB): ");
        String file = scanner.nextLine();
        // Validasi file
        if (validasiFile(file)) {
            Materi materiBaru = new Materi(judul, deskripsi, file);
            listMateri.add(materiBaru);
            System.out.println("Materi berhasil diunggah!");
        } else {
            System.out.println("File tidak valid. Uplad gagal.");
        }
    }

    // Metode untuk validasi file
    private boolean validasiFile(String file) {
        // Untuk sementara, validasi hanya dilakukan berdasarkan format file
        if (file.endsWith(".mp4")) {
            return true;
        } else {
            return false;
        }
    }

    // Metode untuk mengedit materi yang sudah ada
    public void editMateri(int index) {
        System.out.println("===== EDIT MATERI =====");
        Materi materi = listMateri.get(index);
        System.out.print("Judul baru: ");
        String judulBaru = scanner.nextLine();
        System.out.print("Deskripsi baru (maksimal 500 kata): ");
        String deskripsiBaru = scanner.nextLine();
        System.out.print("Nama file baru (format mp4, resolusi min 480p, ukuran <2 GB): ");
        String fileBaru = scanner.nextLine();
        // Validasi file
        if (validasiFile(fileBaru)) {
            materi.setJudul(judulBaru);
            materi.setDeskripsi(deskripsiBaru);
            materi.setFile(fileBaru);
            System.out.println("Materi berhasil diubah!");
        } else {
            System.out.println("File tidak valid. Perubahan gagal.");
        }
    }

    // Metode untuk menghapus materi yang sudah ada
    public void hapusMateri(int index) {
        System.out.println("===== HAPUS MATERI =====");
        Materi materi = listMateri.get(index);
        System.out.println("Apakah Anda yakin ingin menghapus materi dengan judul '" + materi.getJudul() + "'? (Ya/Tidak)");
        String konfirmasi = scanner.nextLine();
        if (konfirmasi.equalsIgnoreCase("Ya")) {
            listMateri.remove(index);
            System.out.println("Materi berhasil dihapus.");
        } else {
            System.out.println("Penghapusan dibatalkan.");
        }
    }
}
