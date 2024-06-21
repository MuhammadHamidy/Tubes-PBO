// // File Path: C:/Users/OWNER/IdeaProjects/EDUBRIDGE/src/Main.java
// import LoginRegister.Peserta;
// import LoginRegister.Mentor;
// import java.util.Scanner;

// public class Main {
//     static Scanner scanner = new Scanner(System.in);

//     public static void main(String[] args) {
//         while (true) {
//             System.out.println("1. Register as Peserta");
//             System.out.println("2. Login as Peserta");
//             System.out.println("3. Reset Peserta Password");
//             System.out.println("4. Display Peserta Registered Courses");
//             System.out.println("5. Register as Mentor");
//             System.out.println("6. Login as Mentor");
//             System.out.println("7. Exit");
//             System.out.print("Choose an option: ");
//             int choice = Integer.parseInt(scanner.nextLine());

//             switch (choice) {
//                 case 1:
//                     new Peserta().register();
//                     break;
//                 case 2:
//                     new Peserta().login("", ""); // Empty strings to match method signature
//                     break;
//                 case 3:
//                     new Peserta().resetPassword();
//                     break;
//                 case 4:
//                     new Peserta().displayRegisteredCourses();
//                     break;
//                 case 5:
//                     new Mentor().register();
//                     break;
//                 case 6:
//                     new Mentor().login("", ""); // Empty strings to match method signature
//                     break;
//                 case 7:
//                     System.exit(0);
//             }
//         }
//     }
// }