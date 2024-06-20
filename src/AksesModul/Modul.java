package AksesModul;

import java.util.ArrayList;
import java.util.List;

public class Modul {
    private String judul;
    private boolean sudahDipelajari;

    public Modul(String judul) {
        this.judul = judul;
        this.sudahDipelajari = false;
    }

    public String getJudul() {
        return judul;
    }

    public boolean isSudahDipelajari() {
        return sudahDipelajari;
    }

    public void setSudahDipelajari(boolean sudahDipelajari) {
        this.sudahDipelajari = sudahDipelajari;
    }
}
