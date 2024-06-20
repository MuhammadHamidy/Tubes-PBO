import java.util.Scanner;

import AksesModul.*;
import HalamanUtama.*;
import HalamanUtama.Kursus;
import KumpulTugas.*;
import KumpulTugas.Peserta;
import LoginRegister.*;
import LoginRegister.User;
import LoginRegister.Mentor;
import ModulBelajar.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        Mentor mentorSystem = new Mentor();
        Peserta pesertaSystem = new Peserta(null);

        while (!exit) {
            System.out.println("========== EDU BRIDGE ==========");
            System.out.println("******** Membantu Talenta Digital Masa Depan ********");
            System.out.println("==== 1. List Kursus ====");
            System.out.println("==== 2. Daftar sebagai Peserta ====");
            System.out.println("==== 3. Daftar sebagai Mentor ====");
            System.out.println("==== 4. Login sebagai Peserta ====");
            System.out.println("==== 5. Login sebagai Mentor ====");
            System.out.print("Pilihan: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Dashboard dashboard = new Dashboard("Info EduBridge");

                    Kursus kursus1 = new Kursus("Kursus 1", "Deskripsi Singkat Kursus 1", "Tersedia", "Deskripsi Lengkap Kursus 1", "Silabus Kursus 1.pdf");
                    Kursus kursus2 = new Kursus("Kursus 2", "Deskripsi Singkat Kursus 2", "Penuh", "Deskripsi Lengkap Kursus 2", "Silabus Kursus 2.pdf");
    
                    dashboard.kursusList.add(kursus1);
                    dashboard.kursusList.add(kursus2);

                    dashboard.tampilkanListKursus();
                    System.out.println();

                    System.out.println("1. Detail Kursus 1");
                    System.out.println("2. Detail Kursus 2");
                    System.out.print("Pilihan: ");
                    int choiceKursus = scanner.nextInt();

                    switch (choiceKursus) {
                        case 1:
                            dashboard.tampilkanDetailKursus(kursus1);
                            break;
                    
                        case 2:
                            dashboard.tampilkanDetailKursus(kursus2);
                            break;
                        default:
                            System.out.println("Tidak Valid!");
                            break;
                    }

                    System.out.println();

                case 2:
                    // pesertaSystem.register();
                    // mentorSystem.register();
                    break;

                case 3:
                    // pesertaSystem.register();
                    mentorSystem.register();
                    break;

                case 4:
                    // pesertaSystem.login();
                    break;

                case 5:
                    boolean isTrue = true;
                    while (!isTrue) {
                        mentorSystem.login(null, null);
                    }
                    
                    break;

        
                default:
                break;
            }
        }
    }
}


































































// import javafx.application.Application;
// import javafx.event.ActionEvent;
// import javafx.event.EventHandler;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.layout.StackPane;
// import javafx.stage.Stage;
 
// public class Main extends Application {
//     @Override
//     public void start(Stage primaryStage) {
//         Button btn = new Button();
//         btn.setText("Say 'Hello World'");
//         btn.setOnAction(new EventHandler<ActionEvent>() {
 
//             @Override
//             public void handle(ActionEvent event) {
//                 System.out.println("Hello World!");
//             }
//         });
        
//         StackPane root = new StackPane();
//         root.getChildren().add(btn);
  
//   /*
//   Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
//   Scene scene = new Scene(root);
//   */
  
//   Scene scene = new Scene(root, 300, 250);
  
//   primaryStage.setTitle("EduBridge");
//         primaryStage.setScene(scene);
//         primaryStage.show();
//     }
 
//  public static void main(String[] args) {
//         launch(args);

//         // main dari package peserta di class assignment system
//         AssignmentSystem system = new AssignmentSystem();
//         system.assignments.add(new Assignment("Math Homework", "Solve probles 1-10", new Date(), "not started"));
//         system.assignments.add(new Assignment("Science Project", "Build Volcano", new Date(), "not started"));

//         Scanner scanner = new Scanner(System.in);

//         while (true) {
//             system.displayMenu();
//             int choice = scanner.nextInt();
//             switch (choice) {
//                 case 1:
//                     system.listAssignments();
//                     break;

//                 case 2:
//                     System.out.println("Enter Assignment index: ");
//                     int index = scanner.nextInt();
//                     system.viewAssignmentDetails(index - 1);
//                     break;

//                 case 3:
//                     System.out.println("Enter assignment index: ");
//                     index = scanner.nextInt();
//                     System.out.println("Enter file name: ");
//                     String fileName = scanner.next();
//                     System.out.println("Enter File Type: ");
//                     String fileType = scanner.next();
//                     System.out.println("Enter File Size: ");
//                     long fileSize = scanner.nextLong();
//                     system.submitAssignment(index - 1, fileName, fileType, fileSize);
//                     break;

//                 case 4:
//                     System.out.println("Enter assignment index: ");
//                     index = scanner.nextInt();
//                     System.out.println("Enter file name: ");
//                     fileName = scanner.next();
//                     System.out.println("Enter File Type: ");
//                     fileType = scanner.next();
//                     System.out.println("Enter File Size: ");
//                     fileSize = scanner.nextLong();
//                     system.editSubmission(
//                         - 1, fileName, fileType, fileSize);
//                     break;

//                 case 5:
//                     System.out.println("Exiting...");
//                     return;

//                 default:
//                     System.out.println("Invalid choice!");
//                     break;
//             }
//         }
//     }
// }