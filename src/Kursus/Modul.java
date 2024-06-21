    package Kursus;

    public class Modul {
        private String judulModul;
        private String deskripsiModul;
        private String filePath;

        public Modul(String judulModul, String deskripsiModul, String filePath) {
            this.judulModul = judulModul;
            this.deskripsiModul = deskripsiModul;
            this.filePath = filePath;
        }

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

        public String getFilePath() {
            return filePath;
        }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }
    }