package HalamanUtama;

public class Kursus {
    private String nama;
    private String deskripsiSingkat;
    private String status;
    private String deskripsiLengkap;
    private String silabus;

    public Kursus(String nama, String deskripsiSingkat, String status, String deskripsiLengkap, String silabus) {
        this.nama = nama;
        this.deskripsiSingkat = deskripsiSingkat;
        this.status = status;
        this.deskripsiLengkap = deskripsiLengkap;
        this.silabus = silabus;
    }

    public String getNama() {
        return nama;
    }

    public String getDeskripsiSingkat() {
        return deskripsiSingkat;
    }

    public String getStatus() {
        return status;
    }

    public String getDeskripsiLengkap() {
        return deskripsiLengkap;
    }

    public String getSilabus() {
        return silabus;
    }

    @Override
    public String toString() {
        return "Nama: " + nama + "\nDeskripsi: " + deskripsiSingkat + "\nStatus: " + status;
    }
}
