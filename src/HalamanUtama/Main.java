package HalamanUtama;

public class Main {
    public static void main(String[] args) {
        Dashboard dashboard = new Dashboard("Info EduBridge");

        Kursus kursus1 = new Kursus("Kursus 1", "Deskripsi Singkat Kursus 1", "Tersedia", "Deskripsi Lengkap Kursus 1", "Silabus Kursus 1.pdf");
        Kursus kursus2 = new Kursus("Kursus 2", "Deskripsi Singkat Kursus 2", "Penuh", "Deskripsi Lengkap Kursus 2", "Silabus Kursus 2.pdf");

        dashboard.kursusList.add(kursus1);
        dashboard.kursusList.add(kursus2);

        dashboard.tampilkanInfoEduBridge();
        dashboard.tampilkanListKursus();

        // Contoh menampilkan detail kursus
        dashboard.tampilkanDetailKursus(kursus1);

        // Contoh pendaftaran peserta
        dashboard.pendaftaranPeserta();

        // Contoh pendaftaran mentor
        dashboard.pendaftaranMentor();

        // Contoh login peserta
        dashboard.loginPeserta();

        // Contoh login mentor
        dashboard.loginMentor();

        // Contoh daftar peserta
        dashboard.daftarPeserta();

        // Contoh daftar mentor
        dashboard.daftarMentor();
    }
}
