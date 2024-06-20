package KumpulTugas;

import java.util.ArrayList;
import java.util.Date;

public class Tugas {
    private String judul;
    private String deskripsi;
    private Date batasWaktu;
    private ArrayList<File> fileTugas;
    private ArrayList<Peserta> peserta;
    private ArrayList<Nilai> nilai;

    public Tugas(String judul, String deskripsi, Date batasWaktu) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.batasWaktu = batasWaktu;
        this.fileTugas = new ArrayList<>();
        this.peserta = new ArrayList<>();
        this.nilai = new ArrayList<>();
    }

    public void tambahFileTugas(File file) {
        this.fileTugas.add(file);
    }

    public void tambahPeserta(Peserta peserta) {
        this.peserta.add(peserta);
    }

    public void tambahNilai(Nilai nilai) {
        this.nilai.add(nilai);
    }

    public void editTugas(String judul, String deskripsi, Date batasWaktu) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.batasWaktu = batasWaktu;
    }

    public void hapusTugas() {
        this.fileTugas.clear();
        this.peserta.clear();
        this.nilai.clear();
    }

    public void publikasiTugas() {
        // Logika publikasi tugas
    }

    public void hapusTugasPeserta(Peserta peserta) {
        this.peserta.remove(peserta);
    }

    public void memberikanNilai(Peserta peserta, int nilai, String feedback) {
        Nilai nilaiPeserta = new Nilai(peserta, nilai, feedback);
        this.nilai.add(nilaiPeserta);
    }

    public void hapusNilai(Peserta peserta) {
        for (int i = 0; i < this.nilai.size(); i++) {
            if (this.nilai.get(i).getPeserta().equals(peserta)) {
                this.nilai.remove(i);
                break;
            }
        }
    }

    public String getJudul() {
        return judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public Date getBatasWaktu() {
        return batasWaktu;
    }

    public ArrayList<File> getFileTugas() {
        return fileTugas;
    }

    public ArrayList<Peserta> getPeserta() {
        return peserta;
    }

    public ArrayList<Nilai> getNilai() {
        return nilai;
    }
}

