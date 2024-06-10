package Mentor;
import java.util.ArrayList;
import java.util.Scanner;

public class Tugas {
    private String judul;
    private String deskripsi;
    private String batasWaktu;
    private String instruksi;
    private String kriteriaPenilaian;
    private ArrayList<String> fileTerkait;
    private boolean dipublikasi;
    private ArrayList<String> pesertaYangSudahKumpul;
    private ArrayList<String> pesertaYangBelumKumpul;
    private Scanner scanner;

    public Tugas() {
        fileTerkait = new ArrayList<>();
        pesertaYangSudahKumpul = new ArrayList<>();
        pesertaYangBelumKumpul = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void tampilkanMenuBeriTugas() {
        System.out.println("===== MENU BERI TUGAS =====");
        System.out.println("1. Buat Tugas Baru");
        System.out.println("2. Edit Tugas");
        System.out.println("3. Hapus Tugas");
        System.out.println("4. Publikasikan Tugas");
        System.out.println("5. Keluar");
        System.out.print("Pilihan Anda: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // Membersihkan buffer
        switch (pilihan) {
            case 1:
                buatTugasBaru();
                break;
            case 2:
                editTugas();
                break;
            case 3:
                hapusTugas();
                break;
            case 4:
                publikasikanTugas();
                break;
            case 5:
                System.out.println("Terima kasih!");
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    public void buatTugasBaru() {
        System.out.println("===== BUAT TUGAS BARU =====");
        System.out.print("Judul: ");
        judul = scanner.nextLine();
        System.out.print("Deskripsi: ");
        deskripsi = scanner.nextLine();
        System.out.print("Batas Waktu (contoh: 10 Juni 2024): ");
        batasWaktu = scanner.nextLine();
        System.out.print("Instruksi: ");
        instruksi = scanner.nextLine();
        System.out.print("Kriteria Penilaian: ");
        kriteriaPenilaian = scanner.nextLine();
        System.out.print("Apakah ingin publikasikan tugas? (Ya/Tidak): ");
        String publikasi = scanner.nextLine();
        dipublikasi = publikasi.equalsIgnoreCase("Ya");
        System.out.println("Tugas berhasil dibuat!");
    }

    public void editTugas() {
        System.out.println("===== EDIT TUGAS =====");
        // Implementasi edit tugas disini
        System.out.print("Masukkan judul tugas yang ingin di-edit: ");
        String judulTugas = scanner.nextLine();
        if (judulTugas.equalsIgnoreCase(judul)) {
            System.out.print("Deskripsi baru: ");
            deskripsi = scanner.nextLine();
            System.out.print("Batas waktu baru: ");
            batasWaktu = scanner.nextLine();
            System.out.print("Instruksi baru: ");
            instruksi = scanner.nextLine();
            System.out.print("Kriteria Penilaian baru: ");
            kriteriaPenilaian = scanner.nextLine();
            System.out.println("Tugas berhasil di-edit!");
        } else {
            System.out.println("Tugas tidak ditemukan.");
        }
    }

    public void hapusTugas() {
        System.out.println("===== HAPUS TUGAS =====");
        // Implementasi hapus tugas disini
        System.out.print("Masukkan judul tugas yang ingin dihapus: ");
        String judulTugas = scanner.nextLine();
        if (judulTugas.equalsIgnoreCase(judul)) {
            judul = null;
            deskripsi = null;
            batasWaktu = null;
            instruksi = null;
            kriteriaPenilaian = null;
            dipublikasi = false;
            System.out.println("Tugas berhasil dihapus!");
        } else {
            System.out.println("Tugas tidak ditemukan.");
        }
    }

    public void publikasikanTugas() {
        System.out.println("===== PUBLIKASIKAN TUGAS =====");
        // Implementasi publikasikan tugas disini
        System.out.print("Masukkan judul tugas yang ingin dipublikasikan: ");
        String judulTugas = scanner.nextLine();
        if (judulTugas.equalsIgnoreCase(judul)) {
            dipublikasi = true;
            System.out.println("Tugas berhasil dipublikasikan!");
        } else {
            System.out.println("Tugas tidak ditemukan.");
        }
    }

    public void berikanNilaiDanFeedback() {
        System.out.println("===== BERIKAN NILAI DAN FEEDBACK =====");
        public void berikanNilaiDanFeedback() {
        System.out.println("===== BERIKAN NILAI DAN FEEDBACK =====");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan judul tugas yang ingin dinilai dan diberi feedback: ");
        String judulTugas = scanner.nextLine();
        boolean tugasDitemukan = false;
        
        // Iterasi melalui daftar tugas untuk mencari tugas dengan judul yang sesuai
        for (Tugas tugas : daftarTugas) {
            if (tugas.getJudul().equalsIgnoreCase(judulTugas)) {
                tugasDitemukan = true;
                // Menampilkan detail tugas
                tugas.tampilkanDetailTugas();
                
                // Menanyakan kepada mentor untuk memberikan nilai
                System.out.print("Masukkan nilai untuk tugas ini: ");
                int nilai = scanner.nextInt();
                scanner.nextLine(); // Membersihkan buffer
                
                // Menanyakan kepada mentor untuk memberikan feedback
                System.out.print("Masukkan feedback untuk tugas ini: ");
                String feedback = scanner.nextLine();
                
                // Menyimpan nilai dan feedback pada tugas
                tugas.setNilai(nilai);
                tugas.setFeedback(feedback);
                
                System.out.println("Nilai dan feedback berhasil disimpan untuk tugas ini.");
                break;
            }
        }
        
        // Jika tugas tidak ditemukan, tampilkan pesan kesalahan
        if (!tugasDitemukan) {
            System.out.println("Tugas dengan judul tersebut tidak ditemukan.");
        }
    }

    public void tampilkanDetailTugas() {
        System.out.println("===== DETAIL TUGAS =====");
        System.out.println("Judul: " + judul);
        System.out.println("Deskripsi: " + deskripsi);
        System.out.println("Batas Waktu: " + batasWaktu);
        System.out.println("Instruksi: " + instruksi);
        System.out.println("Kriteria Penilaian: " + kriteriaPenilaian);
    }

    public void catatStatusPengumpulanTugas(String peserta, boolean sudahKumpul) {
        if (sudahKumpul) {
            pesertaYangSudahKumpul.add(peserta);
        } else {
            pesertaYangBelumKumpul.add(peserta);
        }
    }

    public void tampilkanStatusPengumpulanTugas() {
        System.out.println("===== STATUS PENGUMPULAN TUGAS =====");
        System.out.println("Jumlah Peserta yang Sudah Mengumpulkan: " + pesertaYangSudahKumpul.size());
        System.out.println("Jumlah Peserta yang Belum Mengumpulkan: " + pesertaYangBelumKumpul.size());
    }
}

