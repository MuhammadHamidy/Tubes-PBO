package HalamanUtama;

import java.util.ArrayList;

public class Dashboard {
    private String infoEduBridge;
    public ArrayList<Kursus> kursusList;

    public Dashboard(String infoEduBridge) {
        this.infoEduBridge = infoEduBridge;
        this.kursusList = new ArrayList<>();
    }

    public void tampilkanInfoEduBridge() {
        System.out.println("Info EduBridge: " + infoEduBridge);
    }

    public void tampilkanListKursus() {
        System.out.println("Daftar Kursus:");
        for (Kursus kursus : kursusList) {
            System.out.println(kursus);
        }
    }

    public void tampilkanDetailKursus(Kursus kursus) {
        System.out.println("Detail Kursus:");
        System.out.println("Nama: " + kursus.getNama());
        System.out.println("Deskripsi Singkat: " + kursus.getDeskripsiSingkat());
        System.out.println("Status: " + kursus.getStatus());
        System.out.println("Deskripsi Lengkap: " + kursus.getDeskripsiLengkap());
        System.out.println("Silabus: " + kursus.getSilabus());
    }

    public void pendaftaranPeserta() {
        System.out.println("Pendaftaran Peserta Berhasil.");
    }

    public void pendaftaranMentor() {
        System.out.println("Pendaftaran Mentor Berhasil.");
    }

    public void loginPeserta() {
        System.out.println("Login Peserta Berhasil.");
    }

    public void loginMentor() {
        System.out.println("Login Mentor Berhasil.");
    }

    public void daftarPeserta() {
        System.out.println("Daftar Peserta.");
    }

    public void daftarMentor() {
        System.out.println("Daftar Mentor.");
    }
}
