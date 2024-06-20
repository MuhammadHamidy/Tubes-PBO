package ModulBelajar;

import java.util.ArrayList;
import java.util.List;

public class KelolaModul {
    private List<Modul> daftarModul;

    public KelolaModul() {
        daftarModul = new ArrayList<>();
    }

    public void tambahModul(Modul modul) {
        daftarModul.add(modul);
    }

    public void editModul(int index, Modul modul) {
        daftarModul.set(index, modul);
    }

    public void hapusModul(int index) {
        daftarModul.remove(index);
    }

    public Modul getModul(int index) {
        return daftarModul.get(index);
    }

    public int getJumlahModul() {
        return daftarModul.size();
    }
}