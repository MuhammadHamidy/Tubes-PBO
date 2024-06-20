package ModulBelajar;

import java.util.ArrayList;
import java.util.List;

public class Modul {
    private String judulModul;
    private String deskripsiModul;
    private String penjelasanMateri;
    private String videoPenjelasan;

    public Modul(String judulModul, String deskripsiModul, String penjelasanMateri, String videoPenjelasan) {
        this.judulModul = judulModul;
        this.deskripsiModul = deskripsiModul;
        this.penjelasanMateri = penjelasanMateri;
        this.videoPenjelasan = videoPenjelasan;
    }

    // Getter dan setter

    public String getJudulModul() {
        return judulModul;
    }

    public void setJudulModul(String judulModul) {
        this.judulModul = judulModul;
    }

    public String getDeskripsiModul() {
        return deskripsiModul;
    }

    public void setDeskripsiModul(String deskripsiModul) {
        this.deskripsiModul = deskripsiModul;
    }

    public String getPenjelasanMateri() {
        return penjelasanMateri;
    }

    public void setPenjelasanMateri(String penjelasanMateri) {
        this.penjelasanMateri = penjelasanMateri;
    }

    public String getVideoPenjelasan() {
        return videoPenjelasan;
    }

    public void setVideoPenjelasan(String videoPenjelasan) {
        this.videoPenjelasan = videoPenjelasan;
    }
}