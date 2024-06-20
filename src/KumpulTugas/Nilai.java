package KumpulTugas;

import java.util.ArrayList;
import java.util.Date;

public class Nilai {
    private Peserta peserta;
    private int nilai;
    private String feedback;

    public Nilai(Peserta peserta, int nilai, String feedback) {
        this.peserta = peserta;
        this.nilai = nilai;
        this.feedback = feedback;
    }

    public Peserta getPeserta() {
        return peserta;
    }

    public int getNilai() {
        return nilai;
    }

    public String getFeedback() {
        return feedback;
    }
}