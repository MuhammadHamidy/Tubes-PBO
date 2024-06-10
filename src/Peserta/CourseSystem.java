package Peserta;

import java.util.*;
import java.util.stream.Collectors;

class CourseMaterial {
    String title;
    String description;
    String format; // mp4, pdf, pptx
    boolean accessed;

    public CourseMaterial(String title, String description, String format) {
        this.title = title;
        this.description = description;
        this.format = format;
        this.accessed = false;
    }

    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Format: " + format);
        System.out.println("Accessed: " + (accessed ? "Yes" : "No"));
    }

    public void download() {
        System.out.println("Downloading " + title + " in " + format + " format.");
    }

    public void playVideo() {
        if (format.equals("mp4")) {
            System.out.println("Playing video: " + title);
        } else {
            System.out.println("This material is not a video.");
        }
    }

    public void markAsAccessed() {
        this.accessed = true;
    }
}

class Course {
    String name;
    List<CourseMaterial> materials = new ArrayList<>();

    public Course(String name) {
        this.name = name;
    }

    public void addMaterial(CourseMaterial material) {
        materials.add(material);
    }

    public List<CourseMaterial> searchMaterials(String query) {
        return materials.stream()
                .filter(material -> material.title.contains(query) || material.description.contains(query))
                .collect(Collectors.toList());
    }

    public List<CourseMaterial> filterMaterials(String format) {
        return materials.stream()
                .filter(material -> material.format.equals(format))
                .collect(Collectors.toList());
    }

    public void displayMaterials() {
        for (int i = 0; i < materials.size(); i++) {
            System.out.println((i + 1) + ". " + materials.get(i).title + " (" + materials.get(i).format + ")");
        }
    }

    public void displayMaterialDetails(int index) {
        if (index < 0 || index >= materials.size()) {
            System.out.println("Invalid material index!");
            return;
        }
        materials.get(index).displayDetails();
    }

    public void downloadMaterial(int index) {
        if (index < 0 || index >= materials.size()) {
            System.out.println("Invalid material index!");
            return;
        }
        materials.get(index).download();
    }

    public void playVideoMaterial(int index) {
        if (index < 0 || index >= materials.size()) {
            System.out.println("Invalid material index!");
            return;
        }
        materials.get(index).playVideo();
    }

    public void markMaterialAsAccessed(int index) {
        if (index < 0 || index >= materials.size()) {
            System.out.println("Invalid material index!");
            return;
        }
        materials.get(index).markAsAccessed();
    }
}

public class CourseSystem {
    List<Course> courses = new ArrayList<>();
    Set<String> registeredUsers = new HashSet<>();

    public void displayMenu() {
        System.out.println("1. List Courses");
        System.out.println("2. View Course Materials");
        System.out.println("3. Search Materials");
        System.out.println("4. Filter Materials");
        System.out.println("5. Download Material");
        System.out.println("6. Play Video Material");
        System.out.println("7. Mark Material as Accessed");
        System.out.println("8. Exit");
    }

    public void listCourses() {
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i).name);
        }
    }

    public void viewCourseMaterials(int courseIndex) {
        if (courseIndex < 0 || courseIndex >= courses.size()) {
            System.out.println("Invalid course index!");
            return;
        }
        courses.get(courseIndex).displayMaterials();
    }

    public void searchMaterials(int courseIndex, String query) {
        if (courseIndex < 0 || courseIndex >= courses.size()) {
            System.out.println("Invalid course index!");
            return;
        }
        List<CourseMaterial> results = courses.get(courseIndex).searchMaterials(query);
        for (CourseMaterial material : results) {
            material.displayDetails();
        }
    }

    public void filterMaterials(int courseIndex, String format) {
        if (courseIndex < 0 || courseIndex >= courses.size()) {
            System.out.println("Invalid course index!");
            return;
        }
        List<CourseMaterial> results = courses.get(courseIndex).filterMaterials(format);
        for (CourseMaterial material : results) {
            material.displayDetails();
        }
    }

    public void downloadMaterial(int courseIndex, int materialIndex) {
        if (courseIndex < 0 || courseIndex >= courses.size()) {
            System.out.println("Invalid course index!");
            return;
        }
        courses.get(courseIndex).downloadMaterial(materialIndex);
    }

    public void playVideoMaterial(int courseIndex, int materialIndex) {
        if (courseIndex < 0 || courseIndex >= courses.size()) {
            System.out.println("Invalid course index!");
            return;
        }
        courses.get(courseIndex).playVideoMaterial(materialIndex);
    }

    public void markMaterialAsAccessed(int courseIndex, int materialIndex) {
        if (courseIndex < 0 || courseIndex >= courses.size()) {
            System.out.println("Invalid course index!");
            return;
        }
        courses.get(courseIndex).markMaterialAsAccessed(materialIndex);
    }

    public static void main(String[] args) {
        CourseSystem system = new CourseSystem();

        Course math = new Course("Math");
        math.addMaterial(new CourseMaterial("Algebra Lecture", "Lecture on Algebra basics", "mp4"));
        math.addMaterial(new CourseMaterial("Calculus Book", "Comprehensive Calculus textbook", "pdf"));
        system.courses.add(math);

        Course science = new Course("Science");
        science.addMaterial(new CourseMaterial("Physics Experiment", "How to conduct Physics experiments", "pptx"));
        science.addMaterial(new CourseMaterial("Chemistry Lecture", "Lecture on Chemistry", "mp4"));
        system.courses.add(science);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            system.displayMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    system.listCourses();
                    break;

                case 2:
                    System.out.println("Enter course index: ");
                    int courseIndex = scanner.nextInt();
                    system.viewCourseMaterials(courseIndex - 1);
                    break;

                case 3:
                    System.out.println("Enter course index: ");
                    courseIndex = scanner.nextInt();
                    System.out.println("Enter search query: ");
                    String query = scanner.next();
                    system.searchMaterials(courseIndex - 1, query);
                    break;

                case 4:
                    System.out.println("Enter course index: ");
                    courseIndex = scanner.nextInt();
                    System.out.println("Enter material format to filter (mp4, pdf, pptx): ");
                    String format = scanner.next();
                    system.filterMaterials(courseIndex - 1, format);
                    break;

                case 5:
                    System.out.println("Enter course index: ");
                    courseIndex = scanner.nextInt();
                    System.out.println("Enter material index: ");
                    int materialIndex = scanner.nextInt();
                    system.downloadMaterial(courseIndex - 1, materialIndex - 1);
                    break;

                case 6:
                    System.out.println("Enter course index: ");
                    courseIndex = scanner.nextInt();
                    System.out.println("Enter material index: ");
                    materialIndex = scanner.nextInt();
                    system.playVideoMaterial(courseIndex - 1, materialIndex - 1);
                    break;

                case 7:
                    System.out.println("Enter course index: ");
                    courseIndex = scanner.nextInt();
                    System.out.println("Enter material index: ");
                    materialIndex = scanner.nextInt();
                    system.markMaterialAsAccessed(courseIndex - 1, materialIndex - 1);
                    break;

                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }
}
