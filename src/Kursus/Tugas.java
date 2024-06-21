package Kursus;

import java.util.ArrayList;

public class Tugas {
    private String judul;
    private String deskripsi;
    private String batasWaktu;
    private ArrayList<String> fileTerkait;
    private int jumlahPesertaMengumpulkan;
    private int jumlahPesertaBelumMengumpulkan;
    private boolean selesai;
    private String kriteriaPenilaian;
    private ArrayList<String> jawabanList;

    public Tugas(String judul, String deskripsi, String batasWaktu) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.batasWaktu = batasWaktu;
        this.fileTerkait = new ArrayList<>();
        this.jumlahPesertaMengumpulkan = 0;
        this.jumlahPesertaBelumMengumpulkan = 0;
        this.selesai = false;
        this.kriteriaPenilaian = "";
        this.jawabanList = new ArrayList<>();
    }

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

    public String getBatasWaktu() {
        return batasWaktu;
    }

    public void setBatasWaktu(String batasWaktu) {
        this.batasWaktu = batasWaktu;
    }

    public ArrayList<String> getFileTerkait() {
        return fileTerkait;
    }

    public void addFileTerkait(String filePath) {
        this.fileTerkait.add(filePath);
    }

    public int getJumlahPesertaMengumpulkan() {
        return jumlahPesertaMengumpulkan;
    }

    public void setJumlahPesertaMengumpulkan(int jumlahPesertaMengumpulkan) {
        this.jumlahPesertaMengumpulkan = jumlahPesertaMengumpulkan;
    }

    public int getJumlahPesertaBelumMengumpulkan() {
        return jumlahPesertaBelumMengumpulkan;
    }

    public void setJumlahPesertaBelumMengumpulkan(int jumlahPesertaBelumMengumpulkan) {
        this.jumlahPesertaBelumMengumpulkan = jumlahPesertaBelumMengumpulkan;
    }

    public boolean isSelesai() {
        return selesai;
    }

    public void setSelesai(boolean selesai) {
        this.selesai = selesai;
    }

    public String getKriteriaPenilaian() {
        return kriteriaPenilaian;
    }

    public void setKriteriaPenilaian(String kriteriaPenilaian) {
        this.kriteriaPenilaian = kriteriaPenilaian;
    }

    public ArrayList<String> getJawabanList() {
        return jawabanList;
    }

    public void addJawaban(String jawaban) {
        this.jawabanList.add(jawaban);
    }
}