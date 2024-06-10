import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
  
  /*
  Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
  Scene scene = new Scene(root);
  */
  
  Scene scene = new Scene(root, 300, 250);
  
  primaryStage.setTitle("EduBridge");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 
 public static void main(String[] args) {
        launch(args);

        // main dari package peserta di class assignment system
        AssignmentSystem system = new AssignmentSystem();
        system.assignments.add(new Assignment("Math Homework", "Solve probles 1-10", new Date(), "not started"));
        system.assignments.add(new Assignment("Science Project", "Build Volcano", new Date(), "not started"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            system.displayMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    system.listAssignments();
                    break;

                case 2:
                    System.out.println("Enter Assignment index: ");
                    int index = scanner.nextInt();
                    system.viewAssignmentDetails(index - 1);
                    break;

                case 3:
                    System.out.println("Enter assignment index: ");
                    index = scanner.nextInt();
                    System.out.println("Enter file name: ");
                    String fileName = scanner.next();
                    System.out.println("Enter File Type: ");
                    String fileType = scanner.next();
                    System.out.println("Enter File Size: ");
                    long fileSize = scanner.nextLong();
                    system.submitAssignment(index - 1, fileName, fileType, fileSize);
                    break;

                case 4:
                    System.out.println("Enter assignment index: ");
                    index = scanner.nextInt();
                    System.out.println("Enter file name: ");
                    fileName = scanner.next();
                    System.out.println("Enter File Type: ");
                    fileType = scanner.next();
                    System.out.println("Enter File Size: ");
                    fileSize = scanner.nextLong();
                    system.editSubmission(
                        - 1, fileName, fileType, fileSize);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }
}