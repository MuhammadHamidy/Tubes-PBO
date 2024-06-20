package AksesModul;

import java.util.ArrayList;
import java.util.List;

public class Kursus {
    private String namaKursus;
    private List<Modul> daftarModul;

    public Kursus(String namaKursus) {
        this.namaKursus = namaKursus;
        this.daftarModul = new ArrayList<>();
    }

    public void tambahModul(Modul modul) {
        daftarModul.add(modul);
    }

    public List<Modul> getDaftarModul() {
        return daftarModul;
    }
}