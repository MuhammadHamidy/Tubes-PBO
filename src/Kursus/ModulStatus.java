package Kursus;

public class ModulStatus {
    private String modulTitle;
    private String status; // "sudah dipelajari" or "belum dipelajari"

    public ModulStatus(String modulTitle, String status) {
        this.modulTitle = modulTitle;
        this.status = status;
    }

    public String getModulTitle() {
        return modulTitle;
    }

    public void setModulTitle(String modulTitle) {
        this.modulTitle = modulTitle;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}