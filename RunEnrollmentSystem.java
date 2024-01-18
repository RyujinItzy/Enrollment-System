/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package enrollment;

/**
 *
 * @author Jyann 2
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;




class Subject {
    private String name;

    public Subject(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }

}
 class Student {
    private String studentId;
    private String firstName;
    private String middleInitial;
    private String lastName;
    private int age;
    private String previousSchool;
    private String email;
    private String program;

    public Student(String studentId, String firstName, String middleInitial, String lastName, int age, String previousSchool, String email, String program) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.age = age;
        this.previousSchool = previousSchool;
        this.email = email;
        this.program = program;
    }

    // Getters and setters

    public String getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPreviousSchool() {
        return previousSchool;
    }

    public String getEmail() {
        return email;
    }

    public String getProgram() {
        return program;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPreviousSchool(String previousSchool) {
        this.previousSchool = previousSchool;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleInitial='" + middleInitial + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", previousSchool='" + previousSchool + '\'' +
                ", email='" + email + '\'' +
                ", program='" + program + '\'' +
                '}';
    }
}

class EnrollmentSystem {
    private Map<String, Student> students = new HashMap<>();
    private Map<String, List<Subject>> studentSubjects = new HashMap<>();
    
    private List<Subject> bsitSubjects = new ArrayList<>();
    private List<Subject> bscsSubjects = new ArrayList<>();
    private List<Subject> bshmSubjects = new ArrayList<>();
    private List<Subject> bscmSubjects = new ArrayList<>();
    private List<Subject> bstmSubjects = new ArrayList<>();
    
    private List<Subject> bsaSubjects = new ArrayList<>();
    private List<Subject> bsbaSubjects = new ArrayList<>();
    private List<Subject> bsmaSubjects = new ArrayList<>();
    private List<Subject> bsaisSubjects = new ArrayList<>();
    private List<Subject> bscpeSubjects = new ArrayList<>();
    private int studentIdCounter = 0;

    //1
    
    public EnrollmentSystem() {
        // Initialize subjects for each program
        bsitSubjects.add(new Subject("Object Oriented Programming"));
        bsitSubjects.add(new Subject("Data Structures and Algorithms"));

        bscsSubjects.add(new Subject("Object Oriented Programming"));
        bscsSubjects.add(new Subject("Data Structures and Algorithms"));
        
        bshmSubjects.add(new Subject("Introduction to Hospitality Management"));
        bshmSubjects.add(new Subject("Theories and Practices in Management"));
        
        bscmSubjects.add(new Subject("Culinary Nutrition"));
        bscmSubjects.add(new Subject("Fundamentals of Food Services Operations"));
        
        bstmSubjects.add(new Subject("Principles of Tourism 1"));
        bstmSubjects.add(new Subject("Principles of Management"));
        
        bsaSubjects.add(new Subject("Financial Accounting and Reporting"));
        bsaSubjects.add(new Subject("Conceptual Framework & Accounting standards"));
        
        bsbaSubjects.add(new Subject("Basic Financial Accounting"));
        bsbaSubjects.add(new Subject("Financial Management"));
        
        bsmaSubjects.add(new Subject("Understanding the self"));
        bsmaSubjects.add(new Subject("Reading in Philippine History"));
        
        bsaisSubjects.add(new Subject("Intermediate Accounting 1"));
        bsaisSubjects.add(new Subject("Law on Obligations and Contracts"));
        
        bscpeSubjects.add(new Subject("Computer Engineering as a Discipline"));
        bscpeSubjects.add(new Subject("Chemistry for Engineers"));
    }

    public void enrollNewStudent(Scanner scanner) {
        
        System.out.println("-------------------------");
        System.out.println("Enter student information:");

        // Validate the name input
        String firstName;
        while (true) {
            System.out.print("First Name: ");
            firstName = scanner.nextLine();

            // Check if the name contains only letters
            if (firstName.matches("[a-zA-Z]+")) {
                break;  // Exit the loop if the input is valid
            } else {
                System.out.println("Invalid input. Please enter only letters for the first name.");
            }
        }
        String lastName;
        while (true) {
            System.out.print("Last Name: ");
            lastName = scanner.nextLine();

            // Check if the name contains only letters
            if (lastName.matches("[a-zA-Z]+")) {
                break;  // Exit the loop if the input is valid
            } else {
                System.out.println("Invalid input. Please enter only letters for the last name.");
            }
        }
        String middleInitial;
        while (true) {
            System.out.print("Middle Initial (one capital letter): ");
            middleInitial = scanner.nextLine();

            if (middleInitial.matches("[a-zA-Z]+")) {
                break;  // Exit the loop if the input is valid
            } else {
                System.out.println("Invalid input. Please enter a single capital letter for the middle initial.");
            }
        }

        // Validate the age input
        int age;
        while (true) {
            System.out.print("Age: ");
            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
                scanner.nextLine(); // Consume the newline
                break;  // Exit the loop if the input is a valid integer
            } else {
                System.out.println("Invalid input. Please enter a valid number for age.");
                scanner.nextLine(); // Consume the invalid input
            }
        }

        // Validate the previous school input (allow any characters)
        System.out.print("Previous School: ");
        String previousSchool = scanner.nextLine();

        // Validate the email input (basic email format validation)
        String email;
        while (true) {
            System.out.print("Email: ");
            email = scanner.nextLine();

            // Check if the email has a basic valid format
            if (email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
                break;  // Exit the loop if the input is valid
            } else {
                System.out.println("Invalid input. Please enter a valid email address.");
            }
        }

        // Validate the program input
        String program;
        while (true) {
            System.out.print("Program (ex. BSIT) : ");
            program = scanner.nextLine();

            // Check if the program is either BSIT or BSCS (case-insensitive)
            if (program.equalsIgnoreCase("BSIT") || program.equalsIgnoreCase("BSCS") || program.equalsIgnoreCase("BSHM")
                    || program.equalsIgnoreCase("BSCM") || program.equalsIgnoreCase("BSTM")||program.equalsIgnoreCase("BSA")
                    || program.equalsIgnoreCase("BSBA")|| program.equalsIgnoreCase("BSMA")|| program.equalsIgnoreCase("BSAIS")
                    || program.equalsIgnoreCase("BSCpE")) {
                break;  // Exit the loop if the input is valid
            } else {
                System.out.println("Invalid input. Please enter valid input.");
            }
        }
        
        System.out.print("Are you a regular (R) or irregular (I) student? ");
        String enrollmentType = scanner.nextLine().toUpperCase(); // Convert to uppercase for case-insensitivity
        System.out.println("-------------------------");
        
            if (enrollmentType.equals("R")) {
            studentIdCounter++;
            String studentId = generateStudentId();
            Student newStudent = new Student(studentId, firstName,middleInitial, lastName, age, previousSchool, email, program);
            students.put(studentId, newStudent);
            enrollStudentInSubjects(newStudent);
            System.out.println("Enrollment successful. Student ID: " + studentId);
            displayStudentInformation(newStudent);
            System.out.println("-------------------------");
            System.out.println("Press 1 to go back to the main menu:");
            int choice;
            while (true) {
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline

                    if (choice == 1) {
                        mainMenu();
                        break;
                    } else {
                        System.out.println("\nOops! That is not in the option; please try to choose again. :>");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input
                }
            }
        } else if (enrollmentType.equals("I")) {
            
            studentIdCounter++;
            String studentId = generateStudentId();
            Student newStudent = new Student(studentId, firstName,middleInitial, lastName, age, previousSchool, email, program);
            students.put(studentId, newStudent);
            enrollStudentInSubjects(newStudent);
            enrollOldStudentIrregular(newStudent, scanner);
        } else {
            System.out.println("Invalid enrollment type. Please enter 'R' for regular or 'I' for irregular.");
        }
    }
     private String generateStudentId() {
        return "S" + studentIdCounter;
    }
     public void enrollOldStudent(Scanner scanner) {
    System.out.println("-------------------------");
    System.out.print("Enter your student ID: ");
    String studentId = scanner.nextLine();

    if (students.containsKey(studentId)) {
        Student oldStudent = students.get(studentId);

        System.out.print("Are you a regular (R) or irregular (I) student? ");
        String enrollmentType = scanner.nextLine().toUpperCase(); // Convert to uppercase for case-insensitivity
        System.out.println("-------------------------");

        if (enrollmentType.equals("R")) {
            enrollStudentInSubjects(oldStudent);
            System.out.println("Enrollment successful for regular student.");
            System.out.println("-------------------------");
            System.out.println("Press 1 to go back to the main menu:");
            int choice;
            while (true) {
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline

                    if (choice == 1) {
                        mainMenu();
                        break;
                    } else {
                        System.out.println("\nOops! That is not in the option; please try to choose again. :>");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input
                }
            }
        } else if (enrollmentType.equals("I")) {
            enrollOldStudentIrregular(oldStudent, scanner);
        } else {
            System.out.println("Invalid enrollment type. Please enter 'R' for regular or 'I' for irregular.");
        }
    } else {
        System.out.println("Student ID not found. Please enroll as a new student first.");
    }
    System.out.println("-------------------------");
}

    public void enrollOldStudentIrregular(Student student, Scanner scanner) {
    System.out.println("Subjects available for enrollment:");
    List<Subject> programSubjects = studentSubjects.get(student.getStudentId());

    for (int i = 0; i < programSubjects.size(); i++) {
        System.out.println((i + 1) + ". " + programSubjects.get(i));
    }

    System.out.println("Enter the numbers of subjects you want to enroll in (comma-separated):");
    String subjectsInput = scanner.nextLine();

    // Validate that the input contains only commas and numbers
    if (!subjectsInput.matches("^[\\d,]+$")) {
        System.out.println("Invalid input. Please enter numbers separated by commas.");
        // Handle the error or prompt the user to enter the input again
        return;
    }

    String[] subjectNumbers = subjectsInput.split(",");
    List<Subject> selectedSubjects = new ArrayList<>();

    for (String number : subjectNumbers) {
        int index = Integer.parseInt(number.trim()) - 1;
        if (index >= 0 && index < programSubjects.size()) {
            selectedSubjects.add(programSubjects.get(index));
        }
    }

    studentSubjects.put(student.getStudentId(), selectedSubjects);
    System.out.println("Enrollment successful for irregular student.");
    displayStudentInformation(student);
    System.out.println("-------------------------");
    System.out.println("Press 1 to go back to the main menu:");

    int choice;
    while (true) {
        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            if (choice == 1) {
                mainMenu();
                break;
            } else {
                System.out.println("\nOops! That is not in the option; please try to choose again. :>");
            }
        } else {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // Consume the invalid input
        }
    }
}
//2
    private void enrollStudentInSubjects(Student student) {
        // Enroll the student in subjects based on the program
        if (student.getProgram().equalsIgnoreCase("BSIT")) {
            studentSubjects.put(student.getStudentId(), bsitSubjects);
        } else if (student.getProgram().equalsIgnoreCase("BSCS")) {
            studentSubjects.put(student.getStudentId(), bscsSubjects);
        } else if (student.getProgram().equalsIgnoreCase("BSHM")){
            studentSubjects.put(student.getStudentId(), bshmSubjects);
        }
        else if (student.getProgram().equalsIgnoreCase("BSCM")){
                studentSubjects.put(student.getStudentId(),bscmSubjects);
        }
        else if(student.getProgram().equalsIgnoreCase("BSTM")){
            studentSubjects.put(student.getStudentId(),bstmSubjects);
        }
        else if(student.getProgram().equalsIgnoreCase("BSA")){
            studentSubjects.put(student.getStudentId(),bsaSubjects);
        }
        else if(student.getProgram().equalsIgnoreCase("BSBA")){
            studentSubjects.put(student.getStudentId(),bsbaSubjects);
        }
        else if(student.getProgram().equalsIgnoreCase("BSMA")){
            studentSubjects.put(student.getStudentId(),bsmaSubjects);
        }
        else if(student.getProgram().equalsIgnoreCase("BSAIS")){
            studentSubjects.put(student.getStudentId(),bsaisSubjects);
        }
        else if(student.getProgram().equalsIgnoreCase("BSCpE")){
            studentSubjects.put(student.getStudentId(),bscpeSubjects);
        }
        else {
            System.out.println("Invalid program.");
        }
    }
     public void displayProgramsAndSubjects(Scanner scanner) {
        System.out.println("-------------------------");
        System.out.println("Information and Communications technology:");
        System.out.println("Tourism Management");
        System.out.println("1. (BSIT) Bachelor of Science in Information Technology");
        System.out.println("   - Object Oriented Programming");
        System.out.println("   - Data Structures and Algorithms");
        System.out.println("2. (BSCS) Bachelor of Science in Computer Science");
        System.out.println("   - Object Oriented Programming");
        System.out.println("   - Data Structures and Algorithms");
        System.out.println("Hospitality Management");
        System.out.println("3. (BSHM) Bachelor of Science in Hospitality Management");
        System.out.println("   - Introduction to Hospitality Management");
        System.out.println("   - Theories and practices in Management");
        System.out.println("4. (BSCM) Bachelor of Science in Culinary Management");
        System.out.println("   - Culinary Nutrition");
        System.out.println("   - Fundamentals of food service operations");
        System.out.println("Tourism Management");
        System.out.println("5. (BSTM) Bachelor of Science in Tourism Management");
        System.out.println("   - Principles of Tourism 1");
        System.out.println("   - Principles of Management");
        System.out.println("Business & Management");
        System.out.println("6. (BSA) Bachelor of Science in Accountancy");
        System.out.println("   - Financial Accounting and Reporting");
        System.out.println("   - Conceptual Framework & Accounting standards");
        System.out.println("7. (BSBA) Bachelor of Science in Business Administration");
        System.out.println("   - Basic Financial Accounting");
        System.out.println("   - Financial Management");
        System.out.println("8. (BSMA) Bachelor of Science in Management Accounting");
        System.out.println("   - Understanding the self");
        System.out.println("   - Reading in Philippine History");
        System.out.println("9. (BSAIS) Bachelor of Science in Accounting Information Systems");
        System.out.println("   - Intermediate Accounting 1");
        System.out.println("   - Law on Obligations and Contracts");
        System.out.println("Engineering");
        System.out.println("10. (BSCpE) Bachelor of Science in Computer Engineering");
        System.out.println("   - Computer Engineering as a Discipline");
        System.out.println("   - Chemistry for Engineers");
        
        System.out.println("-------------------------");
        System.out.println("Press 1 to go back to the main menu:");
            int choice;
            while (true) {
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline

                    if (choice == 1) {
                        mainMenu();
                        break;
                    } else {
                        System.out.println("\nOops! That is not in the option; please try to choose again. :>");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input
                }
            }
    }
      public void inquiry(Scanner scanner) {
        System.out.println("-------------------------");
        System.out.print("Hello :> I can help you with these lists: \n\n[1] About us\n[2] Requirements for new or transferee students\n[3] Menu\n\n");
        System.out.print("Please choose an option so I can help you: ");

        int choice;

        while (true) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline

                switch (choice) {
                    case 1:
                        inquiryAboutUs(scanner);
                        break;
                    case 2:
                        requirements(scanner);
                        break;
                    case 3:
                        mainMenu();
                        return; // Exit the method if choice is 3
                    default:
                        System.out.println("\nOops! That is not in the option; please try to choose again. :>\n");
                        break;
                }

                if (choice >= 1 && choice <= 2) {
                    break; // Exit the loop if a valid choice was made
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 2.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }
        private void inquiryAboutUs(Scanner scanner) {
        System.out.println("-------------------------");
        System.out.println("STI HISTORY\nFrom its humble beginnings on August 21, 1983 \nas a computer training center with only two campuses, \n" +
                "STI now has campuses all over the Philippines and has diversified \n" +
                "into ICT-enhanced programs in Information Technology, \n" +
                "Business and Management, Tourism and Hospitality Management, \n" +
                "Engineering, and Arts and Sciences.");
        System.out.println("-------------------------");
        System.out.println("Press 1 to go back to the inquiry:");
        System.out.println("Press 2 to go back to the menu:");
            int choice;
            while (true) {
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline

                    if (choice == 1) {
                        inquiry(scanner);
                        break;
                    }
                    else if(choice == 2){
                        mainMenu();
                        break;
                    }else {
                        System.out.println("\nOops! That is not in the option; please try to choose again. :>");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input
                }
            }
    }
    
    private void requirements(Scanner scanner){
        System.out.println("-------------------------");
        System.out.println("Are you a new student or transferee student? :>\n[1] New student\n[2] Transferee student\n[3] Inquiry\n[4] Menu");
        System.out.print("\nPlease choose an option: ");

        int choice;

        while (true) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline

                switch (choice) {
                    case 1:
                        System.out.println("\nPlease wait for a moment...");
                        newStudentRequirements(scanner);
                        break;
                    case 2:
                        System.out.println("\nPlease wait for a moment...");
                        transfereeStudentRequirements(scanner);
                        break;
                    case 3:
                        System.out.println("\nPlease wait for a moment...");
                        inquiry(scanner);
                        break;
                    case 4:
                        System.out.println("\nPlease wait for a moment...");
                        mainMenu();
                        break;
                    default:
                        System.out.println("\nOops! That is not in the option; please try to choose again. :>");
                        break;
                }

                if (choice >= 1 && choice <= 4) {
                    break; // Exit the loop if a valid choice was made
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 4.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }
    
        private void newStudentRequirements(Scanner scanner) {
          System.out.println("-------------------------");
          System.out.println("Here are the requirements for new students :>\n\n" +
                  "- Original Form 138 / SF9-SHS (Learner's Progress Report Card)\n" +
                  "- Original Form 137 / SF10-SHS (Learner's Permanent Academic Record)\n" +
                  "- PSA Issued Birth Certificate");
          System.out.println("-------------------------");
          System.out.println("Press 1 to go back to the requirements:");
          System.out.println("Press 2 to go back to the menu:");
          int choice;

          while (true) {
              if (scanner.hasNextInt()) {
                  choice = scanner.nextInt();
                  scanner.nextLine(); // Consume the newline

                  if (choice == 1) {
                      requirements(scanner);
                      break;
                  } else if (choice == 2) {
                      mainMenu();
                      break;
                  } else {
                      System.out.println("\nOops! That is not in the option; please try to choose again. :>");
                  }
              } else {
                  System.out.println("Invalid input. Please enter a number.");
                  scanner.nextLine(); // Consume the invalid input
              }
          }
      }
        

        private void transfereeStudentRequirements(Scanner scanner) {
        System.out.println("Here are the requirements for transferee students:" +
                "- Certificate of Transfer (Honorable Dismissal)\n" +
                "- Official Transcript of Records\n" +
                "- PSA Issued Birth Certificate");
        System.out.println("-------------------------");
        System.out.println("Press 1 to go back to the requirements:");
        System.out.println("Press 2 to go back to the main menu:");
        int choice;

        while (true) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline

                if (choice == 1) {
                    requirements(scanner);
                    break;
                } else if (choice == 2) {
                    mainMenu();
                    break;
                } else {
                    System.out.println("\nOops! That is not in the option; please try to choose again. :>");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }
//3
    public void studentDatabase(Scanner scanner){
        System.out.println("-------------------------");
        System.out.println("Student database");
        System.out.println("1. View students information");
        System.out.println("2. Edit student information");
        System.out.println("3. Remove student");
        System.out.println("4. Go back to main menu");
        int choice;
        
         while (true) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline

                if (choice == 1) {
                    viewStudentInformation(scanner);
                    break;
                } else if (choice == 2) {
                    editStudentInformation(scanner);
                    break;
                } else if(choice == 3){
                    removeStudent(scanner);
                    break;
                } else if(choice == 4){
                    mainMenu();
                    break;
                }else {
                    System.out.println("\nOops! That is not in the option; please try to choose again. :>");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }
    public void viewStudentInformation(Scanner scanner){
        System.out.println("-------------------------");
        System.out.println("View Student Information");
        System.out.println("1. Show all student informaion");
        System.out.println("2. Show number of students by program");
        System.out.println("3. Show number of students by course");
        System.out.println("4. Go back to student database");
        System.out.println("5. Go back to main menu");
        int choice;
        
         while (true) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline

                if (choice == 1) {
                    showAllStudents(scanner);
                    break;
                } else if (choice == 2) {
                    showNumberOfStudentsEnrolledByProgram(scanner);
                    break;
                } else if(choice == 3){
                    showNumberOfStudentsEnrolledBySubjects(scanner);
                    break;
                } else if(choice == 4){
                    studentDatabase(scanner);
                    break;
                } else if(choice == 5){
                    mainMenu();
                    break;
                }
                else {
                    System.out.println("\nOops! That is not in the option; please try to choose again. :>");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
         
    }
    public void showAllStudents(Scanner scanner) {
    System.out.println("Show all Students:");
    System.out.println("-------------------------");

    for (Map.Entry<String, Student> entry : students.entrySet()) {
        Student student = entry.getValue();
        System.out.println("Student ID: " + student.getStudentId());
        System.out.println("First Name: " + student.getFirstName());
        System.out.println("Last Name: " + student.getLastName());
        System.out.println("Middle Initial: " + student.getMiddleInitial());
        System.out.println("Age: " + student.getAge());
        System.out.println("Previous School: " + student.getPreviousSchool());
        System.out.println("Email: " + student.getEmail());
        System.out.println("Program: " + student.getProgram());
        System.out.println("Enrolled Subjects: " + studentSubjects.get(student.getStudentId()));
        System.out.println("-------------------------");
    }

    System.out.println("Press 1 to go back to the student database:");
    int choice;
    while (true) {
        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            if (choice == 1) {
                studentDatabase(scanner);
                break;
            } else {
                System.out.println("\nOops! That is not in the option; please try to choose again. :>");
            }
        } else {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // Consume the invalid input
        }
    }
}

    public void showNumberOfStudentsEnrolledByProgram(Scanner scanner) {
        System.out.println("-------------------------");
        System.out.println("Number of Students Enrolled by Program:");

        Set<String> allPrograms = new HashSet<>(Arrays.asList("BSIT", "BSCS","BSHM","BSCM", "BSTM", "BSA", "BSBA","BSMA","BSAIS", "BSCpE")); // Add more programs if needed

        Map<String, Integer> enrolledCountByProgram = new HashMap<>();

        for (String program : allPrograms) {
            enrolledCountByProgram.put(program, 0);
        }

        for (Map.Entry<String, Student> entry : students.entrySet()) {
            Student student = entry.getValue();
            String program = student.getProgram().toUpperCase(); // Convert to uppercase
            enrolledCountByProgram.put(program, enrolledCountByProgram.get(program) + 1);
        }

        for (String program : allPrograms) {
            System.out.println(program + ": " + enrolledCountByProgram.get(program) + " students");
        }
            System.out.println("-------------------------");
            System.out.println("Press 1 to go back to the student database:");
            int choice;
            while (true) {
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline

                    if (choice == 1) {
                        studentDatabase(scanner);
                        break;
                    } else {
                        System.out.println("\nOops! That is not in the option; please try to choose again. :>");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input
                }
            }
    }

    public void showNumberOfStudentsEnrolledBySubjects(Scanner scanner) {
        System.out.println("-------------------------");
        System.out.println("Number of Students Enrolled by Subjects:");
        Set<String> allSubjects = new HashSet<>(Arrays.asList("Object Oriented Programming", "Data Structures and Algorithms", "Introduction to Hospitality Management","Theories and Practices in Management"
        , "Culinary Nutrition", "Fundamentals of Food Service Operations","Principles of Tourism 1", "Principles of Management", "Financial Accounting and Reporting","Conceptual Framework & Accounting standards"
        ,"Basic Financial Accounting","Financial Management", "Understanding the self", "Reading in Philippine History", "Intermediate Accounting 1","Law on Obligations and Contracts"
        ,"Computer Engineering as a Discipline","Chemistry for Engineers"));
        Map<String, Integer> enrolledCountBySubjects = new HashMap<>();
        
        for (String subject : allSubjects) {
            enrolledCountBySubjects.put(subject, 0);
        }
        
        for (List<Subject> subjects : studentSubjects.values()) {
            for (Subject subject : subjects) {
                String subjectName = subject.toString();
                enrolledCountBySubjects.put(subjectName, enrolledCountBySubjects.getOrDefault(subjectName, 0) + 1);
            }
        }
        for (String subject : allSubjects) {
            System.out.println(subject + ": " + enrolledCountBySubjects.get(subject) + " students");
        }
            System.out.println("-------------------------");
            System.out.println("Press 1 to go back to the student database:");
            int choice;
            while (true) {
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline

                    if (choice == 1) {
                        studentDatabase(scanner);
                        break;
                    } else {
                        System.out.println("\nOops! That is not in the option; please try to choose again. :>");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input
                }
            }
        }
        public void editStudentInformation(Scanner scanner) {
        System.out.println("-------------------------");
        System.out.print("Enter student ID to edit information: ");
        String studentId = scanner.nextLine();

        if (students.containsKey(studentId)) {
            Student student = students.get(studentId);
            System.out.println("Current Information:");
            displayStudentInformation(student);

            System.out.println("Enter new information:");

            
            System.out.print("First Name: ");
            String newFirstName;
            while (true) {
                newFirstName = scanner.nextLine();

                // Check if the name contains only letters
                if (newFirstName.matches("[a-zA-Z]+")) {
                    break;  // Exit the loop if the input is valid
                } else {
                    System.out.println("Invalid input. Please enter only letters for the name.");
                }
            }
            System.out.print("Last Name: ");
            String newLastName;
            while (true) {
                newLastName = scanner.nextLine();

                // Check if the name contains only letters
                if (newLastName.matches("[a-zA-Z]+")) {
                    break;  // Exit the loop if the input is valid
                } else {
                    System.out.println("Invalid input. Please enter only letters for the name.");
                }
            }
            System.out.print("Middle Initial (one capital letter): ");
            String middleInitial;
            while (true) {
                middleInitial = scanner.nextLine();

                // Check if the input is a single capital letter
                if (middleInitial.matches("[a-zA-Z]+")) {
                    break;  // Exit the loop if the input is valid
                } else {
                    System.out.println("Invalid input. Please enter a single capital letter for the middle initial.");
                }
            }

            System.out.print("Age: ");
            int newAge;
            while (true) {
                if (scanner.hasNextInt()) {
                    newAge = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a valid number for age.");
                    scanner.nextLine(); // Consume the invalid input
                }
            }
            System.out.print("Previous School: ");
            String newPreviousSchool = scanner.nextLine();

            // For Email
            String newEmail;
            while (true) {
                System.out.print("Email: ");
                newEmail = scanner.nextLine();

                // Check if the email has a basic valid format
                if (newEmail.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
                    break;  // Exit the loop if the input is valid
                } else {
                    System.out.println("Invalid input. Please enter a valid email address.");
                }
            }

            // For Program
            String newProgram;
            while (true) {
                System.out.print("Program (ex. BSIT): ");
                newProgram = scanner.nextLine();

                // Check if the program is either BSIT or BSCS (case-insensitive)
                if (newProgram.equalsIgnoreCase("BSIT") || newProgram.equalsIgnoreCase("BSCS") || newProgram.equalsIgnoreCase("BSHM")
                        || newProgram.equalsIgnoreCase("BSCM") || newProgram.equalsIgnoreCase("BSTM")|| newProgram.equalsIgnoreCase("BSA")
                        || newProgram.equalsIgnoreCase("BSBA")|| newProgram.equalsIgnoreCase("BSMA")|| newProgram.equalsIgnoreCase("BSAIS")
                        || newProgram.equalsIgnoreCase("BSCpE")) {
                    break;  // Exit the loop if the input is valid
                } else {
                    System.out.println("Invalid input. Please a valid input.");
                }
            }

            // Update student information
                student.setFirstName(newFirstName);
                student.setLastName(newLastName);
                student.getMiddleInitial();
                student.setAge(newAge);
                student.setPreviousSchool(newPreviousSchool);
                student.setEmail(newEmail);
                student.setProgram(newProgram);

                System.out.println("Student information updated successfully.");
                System.out.println("-------------------------");
                System.out.println("Press 1 to go back to the student database:");
                int choice;
                while (true) {
                    if (scanner.hasNextInt()) {
                        choice = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline

                        if (choice == 1) {
                            studentDatabase(scanner);
                            break;
                        } else {
                            System.out.println("\nOops! That is not in the option; please try to choose again. :>");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a number.");
                        scanner.nextLine(); // Consume the invalid input
                    }
                }
            } else {
                System.out.println("Student ID not found.");
            }
            }
        
        private void displayStudentInformation(Student student) 
        {
        System.out.println("First Name: " + student.getFirstName());
        System.out.println("Last Name: " + student.getLastName());
        System.out.println("Middle Initial: " + student.getMiddleInitial());
        System.out.println("Age: " + student.getAge());
        System.out.println("Previous School: " + student.getPreviousSchool());
        System.out.println("Email: " + student.getEmail());
        System.out.println("Program: " + student.getProgram());
        }

        public void removeStudent(Scanner scanner) {
    System.out.println("-------------------------");
    System.out.print("Enter the student ID to remove: ");
    String studentIdToRemove = scanner.nextLine();

    if (students.containsKey(studentIdToRemove)) {
        Student studentToRemove = students.get(studentIdToRemove);

        // Display student information for confirmation
        System.out.println("Are you sure you want to remove the following student?");
        System.out.println("Student ID: " + studentToRemove.getStudentId());
        System.out.println("First Name: " + studentToRemove.getFirstName());
        System.out.println("Last Name: " + studentToRemove.getLastName());
        System.out.println("Middle Initial: " + studentToRemove.getMiddleInitial());
        System.out.println("Age: " + studentToRemove.getAge());
        System.out.println("Previous School: " + studentToRemove.getPreviousSchool());
        System.out.println("Email: " + studentToRemove.getEmail());
        System.out.println("Program: " + studentToRemove.getProgram());
        System.out.println("Enrolled Subjects: " + studentSubjects.getOrDefault(studentIdToRemove, Collections.emptyList()));
        
        System.out.print("Enter 'yes' to confirm, or any other key to cancel: ");
        String confirmation = scanner.nextLine();

        if ("yes".equalsIgnoreCase(confirmation)) {
            // User confirmed, proceed with removal
            Student removedStudent = students.remove(studentIdToRemove);
            studentSubjects.remove(studentIdToRemove);

            System.out.println("Student removed successfully:");
            System.out.println("Student ID: " + removedStudent.getStudentId());
            System.out.println("First Name: " + studentToRemove.getFirstName());
            System.out.println("Last Name: " + studentToRemove.getLastName());
            System.out.println("Middle Initial: " + studentToRemove.getMiddleInitial());
            System.out.println("Age: " + removedStudent.getAge());
            System.out.println("Previous School: " + removedStudent.getPreviousSchool());
            System.out.println("Email: " + removedStudent.getEmail());
            System.out.println("Program: " + removedStudent.getProgram());
            System.out.println("Enrolled Subjects: " + studentSubjects.getOrDefault(studentIdToRemove, Collections.emptyList()));
        } else {
            System.out.println("Removal canceled by user.");
        }
    } else {
        System.out.println("Student ID not found. Unable to remove.");
    }

    System.out.println("-------------------------");
    System.out.println("Press 1 to go back to the student database:");
    int choice;
    while (true) {
        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            if (choice == 1) {
                studentDatabase(scanner);
                break;
            } else {
                System.out.println("\nOops! That is not in the option; please try to choose again. :>");
            }
        } else {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // Consume the invalid input
        }
    }
}

    // Getters for testing purposes
    public Map<String, Student> getStudents() {
        return students;
    }

    public Map<String, List<Subject>> getStudentSubjects() {
        return studentSubjects;
    }
    public void mainMenu() 
    {
    Scanner scanner = new Scanner(System.in);
    intro();
    while (true) {
    System.out.println("-------------------------");
    System.out.println("STI Enrollment System");
    System.out.println("1. Enroll New Student");
    System.out.println("2. Enroll Old Student");
    System.out.println("3. Show Programs and Subjects");
    System.out.println("4. Student Database");
    System.out.println("5. Inquiry");
    System.out.println("6. Exit");
    System.out.print("Choose an option: ");

    if (scanner.hasNextInt()) {
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        switch (choice) {
            case 1:
                enrollNewStudent(scanner);
                break;
            case 2:
                enrollOldStudent(scanner);
                break;
            case 3:
                displayProgramsAndSubjects(scanner);
                break;
            case 4:
                studentDatabase(scanner);
                break;
            case 5:
                inquiry(scanner);
                break;
            case 6:
                System.out.println("Exiting...");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    } else {
        System.out.println("Invalid input. Please enter a number.");
        scanner.nextLine(); // Consume the invalid input
    }
    }
    }
    public void intro()
    {
        System.out.println("  /$$$$$$  /$$$$$$$$ /$$$$$$                                                                           \n" +
" /$$__  $$|__  $$__/|_  $$_/                                                                           \n" +
"| $$  \\__/   | $$     | $$                                                                             \n" +
"|  $$$$$$    | $$     | $$                                                                             \n" +
" \\____  $$   | $$     | $$                                                                             \n" +
" /$$  \\ $$   | $$     | $$                                                                             \n" +
"|  $$$$$$/   | $$    /$$$$$$                                                                           \n" +
" \\______/    |__/   |______/                                                                           \n" +
"                                                                                                       \n" +
"                                                                                                       \n" +
"                                                                                                       \n" +
" /$$$$$$$$ /$$   /$$ /$$$$$$$   /$$$$$$  /$$       /$$       /$$      /$$ /$$$$$$$$ /$$   /$$ /$$$$$$$$\n" +
"| $$_____/| $$$ | $$| $$__  $$ /$$__  $$| $$      | $$      | $$$    /$$$| $$_____/| $$$ | $$|__  $$__/\n" +
"| $$      | $$$$| $$| $$  \\ $$| $$  \\ $$| $$      | $$      | $$$$  /$$$$| $$      | $$$$| $$   | $$   \n" +
"| $$$$$   | $$ $$ $$| $$$$$$$/| $$  | $$| $$      | $$      | $$ $$/$$ $$| $$$$$   | $$ $$ $$   | $$   \n" +
"| $$__/   | $$  $$$$| $$__  $$| $$  | $$| $$      | $$      | $$  $$$| $$| $$__/   | $$  $$$$   | $$   \n" +
"| $$      | $$\\  $$$| $$  \\ $$| $$  | $$| $$      | $$      | $$\\  $ | $$| $$      | $$\\  $$$   | $$   \n" +
"| $$$$$$$$| $$ \\  $$| $$  | $$|  $$$$$$/| $$$$$$$$| $$$$$$$$| $$ \\/  | $$| $$$$$$$$| $$ \\  $$   | $$   \n" +
"|________/|__/  \\__/|__/  |__/ \\______/ |________/|________/|__/     |__/|________/|__/  \\__/   |__/   \n" +
"                                                                                                       \n" +
"                                                                                                       \n" +
"                                                                                                       \n" +
"  /$$$$$$  /$$     /$$ /$$$$$$  /$$$$$$$$ /$$$$$$$$ /$$      /$$                                       \n" +
" /$$__  $$|  $$   /$$//$$__  $$|__  $$__/| $$_____/| $$$    /$$$                                       \n" +
"| $$  \\__/ \\  $$ /$$/| $$  \\__/   | $$   | $$      | $$$$  /$$$$                                       \n" +
"|  $$$$$$   \\  $$$$/ |  $$$$$$    | $$   | $$$$$   | $$ $$/$$ $$                                       \n" +
" \\____  $$   \\  $$/   \\____  $$   | $$   | $$__/   | $$  $$$| $$                                       \n" +
" /$$  \\ $$    | $$    /$$  \\ $$   | $$   | $$      | $$\\  $ | $$                                       \n" +
"|  $$$$$$/    | $$   |  $$$$$$/   | $$   | $$$$$$$$| $$ \\/  | $$                                       \n" +
" \\______/     |__/    \\______/    |__/   |________/|__/     |__/                                       \n" +
"                                                                     ");
    }
    
}

public class RunEnrollmentSystem {
    public static void main(String[] args) {
        EnrollmentSystem enrollmentSystem = new EnrollmentSystem();
        enrollmentSystem.mainMenu();
    }
}
