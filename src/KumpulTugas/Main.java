package KumpulTugas;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Tugas tugas = new Tugas("Tugas 1", "Deskripsi tugas 1", new Date());

        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");
        tugas.tambahFileTugas(file1);
        tugas.tambahFileTugas(file2);

        Peserta peserta1 = new Peserta("Peserta 1");
        Peserta peserta2 = new Peserta("Peserta 2");
        tugas.tambahPeserta(peserta1);
        tugas.tambahPeserta(peserta2);

        tugas.memberikanNilai(peserta1, 80, "Baik");
        tugas.memberikanNilai(peserta2, 60, "Cukup");

        System.out.println("Judul tugas: " + tugas.getJudul());
        System.out.println("Deskripsi tugas: " + tugas.getDeskripsi());
        System.out.println("Batas waktu tugas: " + tugas.getBatasWaktu());
        System.out.println("File tugas:");
        for (File file : tugas.getFileTugas()) {
            System.out.println("- " + file.getNamaFile());
        }
        System.out.println("Peserta:");
        for (Peserta peserta : tugas.getPeserta()) {
            System.out.println("- " + peserta.getNama());
        }
        System.out.println("Nilai:");
        for (Nilai nilai : tugas.getNilai()) {
            System.out.println("- Peserta: " + nilai.getPeserta().getNama());
            System.out.println("  Nilai: " + nilai.getNilai());
            System.out.println("  Feedback: " + nilai.getFeedback());
        }
    }
}