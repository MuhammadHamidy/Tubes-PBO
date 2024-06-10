package Peserta;

import java.util.*;

class Assignment {
    String title;
    String description;
    Date dueDate;
    String status; //"belum mulai" //dalam proses // telah dikumpul

    public Assignment(String title, String description, Date dueDate, String status) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
    }

    public void displayDetails(){
        System.out.println("Tile: " + title);
        System.out.println("Description: " + description);
        System.out.println("Due Date: " + dueDate);
        System.out.println("Stasut: " + status);
    }
}

class Submission {
    String fileName;
    String fileType;
    long fileSize; //Bytes

    public Submission(String fileName, String fileType, long fileSize) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileSize = fileSize;
    }

    public boolean validate(){
        List<String> allowedFileTypes = Arrays.asList("mp3", "mp4", "jpg", "pdf", "zip", "xlsx");

        if(!allowedFileTypes.contains(fileType)){
            System.out.println("Invalid file type!");
            return false;
        }
        if(fileSize > 10485760) { //maks file 10MB
            System.out.println("File size exceeds limit!");
            return false;
        } 
        return true;
    }
}

//assingment method
public class AssignmentSystem{
    List<AssignmentSystem> assignments = new ArrayList<>();
    Map<String, Submission> submissions = new HashMap<>();

    public void displayMenu(){
        System.out.println("1. List Assignments");
        System.out.println("2. View Assignments Details");
        System.out.println("3. Submit Assignment");
        System.out.println("4. Edit Submission");
        System.out.println("5. Exit");
    }

    public void listAssignments(){
        for(int i = 0; i < assignments.size(); i++) {
            System.out.println((i + 1) + ". " + assignments.get(i).title);
        }
    }

    public void viewAssignmentDetails(int index) {
        if(index < 0 || index >= assignments.size()){
            System.out.println("Invalid assignment index!");
        }
        assignments.get(index).displayDetails();
    }

    public void submitAssignment(int index, String fileName, String fileType, long fileSize) {
        if (index < 0   || index >= assignments.size()) {
            System.out.println("Invalis assignment index");
            return;
        }
        Submission submission = new Submission(fileName, fileType, fileSize);
        if(submission.validate()) {
            submissions.put(assignments.get(index).title, submission);
            assignments.get(index).status = "telah dikumpul";
            System.out.println("Submission Successful");
        }
    }

    // public void editSubmission(int index, String fileName, String fileType, long fileSize){
    //     if (index < 0 || index >= assignments.size()){
    //         System.out.println("Invalid assignment index!");
    //         return;
    //     }
    //     if(!submissions.containsKey(assignments.get(index).title)){
    //         System.out.println("No submission to edit!");
    //         return;
    //     }
    //     Submission submission = new Submission(fileName, fileType, fileSize);
    //     if (submission.validate()){
    //         submissions.put(assignments.get(index).title, submission);
    //         System.out.println("Submission edited Successful!");
    //     }
    // }

    // public static void main(String[] args) {
    //     AssignmentSystem system = new AssignmentSystem();
    //     system.assignments.add(new Assignment("Math Homework", "Solve probles 1-10", new Date(), "not started"));
    //     system.assignments.add(new Assignment("Science Project", "Build Volcano", new Date(), "not started"));

    //     Scanner scanner = new Scanner(System.in);

    //     while (true) {
    //         system.displayMenu();
    //         int choice = scanner.nextInt();
    //         switch (choice) {
    //             case 1:
    //                 system.listAssignments();
    //                 break;

    //             case 2:
    //                 System.out.println("Enter Assignment index: ");
    //                 int index = scanner.nextInt();
    //                 system.viewAssignmentDetails(index - 1);
    //                 break;

    //             case 3:
    //                 System.out.println("Enter assignment index: ");
    //                 index = scanner.nextInt();
    //                 System.out.println("Enter file name: ");
    //                 String fileName = scanner.next();
    //                 System.out.println("Enter File Type: ");
    //                 String fileType = scanner.next();
    //                 System.out.println("Enter File Size: ");
    //                 long fileSize = scanner.nextLong();
    //                 system.submitAssignment(index - 1, fileName, fileType, fileSize);
    //                 break;

    //             case 4:
    //                 System.out.println("Enter assignment index: ");
    //                 index = scanner.nextInt();
    //                 System.out.println("Enter file name: ");
    //                 fileName = scanner.next();
    //                 System.out.println("Enter File Type: ");
    //                 fileType = scanner.next();
    //                 System.out.println("Enter File Size: ");
    //                 fileSize = scanner.nextLong();
    //                 system.editSubmission(
    //                     - 1, fileName, fileType, fileSize);
    //                 break;

    //             case 5:
    //                 System.out.println("Exiting...");
    //                 return;

    //             default:
    //                 System.out.println("Invalid choice!");
    //                 break;
    //         }
    //     }
    // }
}


