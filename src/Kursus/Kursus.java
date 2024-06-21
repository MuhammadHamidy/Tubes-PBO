package Kursus;

import java.util.ArrayList;

public class Kursus {
    private String nama;
    private String deskripsiSingkat;
    private String status;
    private String deskripsiLengkap;
    private String silabus;
    private ArrayList<Modul> modulList;
    private ArrayList<Tugas> tugasList;

    public Kursus(String nama, String deskripsiSingkat, String status, String deskripsiLengkap, String silabus) {
        this.nama = nama;
        this.deskripsiSingkat = deskripsiSingkat;
        this.status = status;
        this.deskripsiLengkap = deskripsiLengkap;
        this.silabus = silabus;
        this.modulList = new ArrayList<>();
        this.tugasList = new ArrayList<>();
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

    public ArrayList<Modul> getModulList() {
        return modulList;
    }

    public ArrayList<Tugas> getTugasList() {
        return tugasList;
    }

    public void addModul(Modul modul) {
        modulList.add(modul);
    }

    public void removeModul(Modul modul) {
        modulList.remove(modul);
    }

    public void addTugas(Tugas tugas) {
        tugasList.add(tugas);
    }

    public void removeTugas(Tugas tugas) {
        tugasList.remove(tugas);
    }

    @Override
    public String toString() {
        return "Nama: " + nama + "\nDeskripsi: " + deskripsiSingkat + "\nStatus: " + status;
    }
}