package AksesModul;

import java.util.ArrayList;
import java.util.List;

class Peserta {
    private String nama;
    private List<Kursus> kursusDiikuti;

    public Peserta(String nama) {
        this.nama = nama;
        this.kursusDiikuti = new ArrayList<>();
    }

    public void ikutiKursus(Kursus kursus) {
        kursusDiikuti.add(kursus);
    }

    public List<Kursus> getKursusDiikuti() {
        return kursusDiikuti;
    }

    public void aksesModul(Modul modul) {
        // implementasi akses modul
    }

    public void downloadModul(Modul modul) {
        // implementasi download modul
    }

    public void markedAsDipelajari(Modul modul) {
        modul.setSudahDipelajari(true);
    }
}
