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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


class Student {
    private String studentId;
    private String name;
    private int age;
    private String previousSchool;
    private String email;
    private String program;

    public Student(String studentId, String name, int age, String previousSchool, String email, String program) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.previousSchool = previousSchool;
        this.email = email;
        this.program = program;
    }

    // Getters and setters

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
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
}

class Subject {
    private String name;

    public Subject(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }

    // Getter
}

class EnrollmentSystem {
    private Map<String, Student> students = new HashMap<>();
    private Map<String, List<Subject>> studentSubjects = new HashMap<>();
    private List<Subject> bsitSubjects = new ArrayList<>();
    private List<Subject> bscsSubjects = new ArrayList<>();

    public EnrollmentSystem() {
        // Initialize subjects for each program
        bsitSubjects.add(new Subject("Object Oriented Programming"));
        bsitSubjects.add(new Subject("Data Structures and Algorithms"));

        bscsSubjects.add(new Subject("Object Oriented Programming"));
        bscsSubjects.add(new Subject("Data Structures and Algorithms"));
    }

    public void enrollNewStudent(Scanner scanner) {
        

        System.out.println("Enter student information:");

        // Validate the name input
        String name;
        while (true) {
            System.out.print("Name: ");
            name = scanner.nextLine();

            // Check if the name contains only letters
            if (name.matches("[a-zA-Z]+")) {
                break;  // Exit the loop if the input is valid
            } else {
                System.out.println("Invalid input. Please enter only letters for the name.");
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
            System.out.print("Program (BSIT or BSCS): ");
            program = scanner.nextLine();

            // Check if the program is either BSIT or BSCS (case-insensitive)
            if (program.equalsIgnoreCase("BSIT") || program.equalsIgnoreCase("BSCS")) {
                break;  // Exit the loop if the input is valid
            } else {
                System.out.println("Invalid input. Please enter BSIT or BSCS.");
            }
        }

        // Generate a unique student ID (you might want to implement a more robust ID generation)
        String studentId = "S" + (students.size() + 1);

        // Create and store the new student
        Student newStudent = new Student(studentId, name, age, previousSchool, email, program);
        students.put(studentId, newStudent);

        // Automatically enroll the new student in subjects based on the program
        enrollStudentInSubjects(newStudent);
        System.out.println("Enrollment successful. Student ID: " + studentId);
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

    public void enrollOldStudent(Scanner scanner) {

        System.out.print("Enter your student ID: ");
        String studentId = scanner.nextLine();

        if (students.containsKey(studentId)) {
            Student oldStudent = students.get(studentId);

            System.out.print("Are you a regular or irregular student? ");
            String enrollmentType = scanner.nextLine();

            if (enrollmentType.equalsIgnoreCase("regular")) {
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
            } else if (enrollmentType.equalsIgnoreCase("irregular")) {
                enrollOldStudentIrregular(oldStudent, scanner);
            } else {
                System.out.println("Invalid enrollment type.");
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

    private void enrollStudentInSubjects(Student student) {
        // Enroll the student in subjects based on the program
        if (student.getProgram().equalsIgnoreCase("BSIT")) {
            studentSubjects.put(student.getStudentId(), bsitSubjects);
        } else if (student.getProgram().equalsIgnoreCase("BSCS")) {
            studentSubjects.put(student.getStudentId(), bscsSubjects);
        } else {
            System.out.println("Invalid program.");
        }
    }
     public void displayProgramsAndSubjects(Scanner scanner) {
        System.out.println("Programs and Subjects:");
        System.out.println("1. (BSIT) Bachelor of Science in Information Technology");
        System.out.println("   - Object Oriented Programming");
        System.out.println("   - Data Structures and Algorithms");
        System.out.println("2. (BSCS) Bachelor of Science in Computer Science");
        System.out.println("   - Object Oriented Programming");
        System.out.println("   - Data Structures and Algorithms");
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
        System.out.println("\nPlease wait for a moment...");
        System.out.print("\nHello :> I can help you with these lists: \n\n[1] About us\n[2] Requirements for new or transferee students\n\n");
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
        System.out.println("\nPlease wait for a moment...");
        System.out.println("STI HISTORY\nFrom its humble beginnings on August 21, 1983 \nas a computer training center with only two campuses, \n" +
                "STI now has campuses all over the Philippines and has diversified \n" +
                "into ICT-enhanced programs in Information Technology, \n" +
                "Business and Management, Tourism and Hospitality Management, \n" +
                "Engineering, and Arts and Sciences.");
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
    

    private void requirements(Scanner scanner){
        System.out.println("\nPlease wait for a moment...");
        System.out.println("\nAre you a new student or transferee student? :>\n[1] New student\n[2] Transferee student\n[3] Main Menu");
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
                        mainMenu();
                        break;
                    default:
                        System.out.println("\nOops! That is not in the option; please try to choose again. :>");
                        break;
                }

                if (choice >= 1 && choice <= 3) {
                    break; // Exit the loop if a valid choice was made
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 3.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }

    private void newStudentRequirements(Scanner scanner) {

        System.out.println("\nHere are the requirements for new students :>\n\n" +
                "- Original Form 138 / SF9-SHS (Learner's Progress Report Card)\n" +
                "- Original Form 137 / SF10-SHS (Learner's Permanent Academic Record)\n" +
                "- PSA Issued Birth Certificate");
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

    private void transfereeStudentRequirements(Scanner scanner) {
        System.out.println("Here are the requirements for transferee students:" +
                "- Certificate of Transfer (Honorable Dismissal)\n" +
                "- Official Transcript of Records\n" +
                "- PSA Issued Birth Certificate");
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

    public void studentDatabase(Scanner scanner) {
    System.out.println("Enrolled Students by Program:");

    for (Map.Entry<String, Student> entry : students.entrySet()) {
        Student student = entry.getValue();
        System.out.println("Student ID: " + student.getStudentId());
        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());
        System.out.println("Previous School: " + student.getPreviousSchool());
        System.out.println("Email: " + student.getEmail());
        System.out.println("Program: " + student.getProgram());
        System.out.println("Enrolled Subjects: " + studentSubjects.get(student.getStudentId()));
        System.out.println("-------------------------");
    }

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

    public void showStudentsEnrolledByProgram(Scanner scanner) {
        System.out.println("Students Enrolled by Program:");

        Set<String> allPrograms = new HashSet<>(Arrays.asList("BSIT", "BSCS")); // Add more programs if needed

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

    public void showStudentsEnrolledBySubjects(Scanner scanner) {
        System.out.println("Students Enrolled by Subjects:");
        Set<String> allSubjects = new HashSet<>(Arrays.asList("Object Oriented Programming", "Data Structures and Algorithms"));
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



    // Getters for testing purposes
    public Map<String, Student> getStudents() {
        return students;
    }

    public Map<String, List<Subject>> getStudentSubjects() {
        return studentSubjects;
    }
    public void mainMenu() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
    System.out.println("Hogwarts Enrollment System");
    System.out.println("1. Enroll New Student");
    System.out.println("2. Enroll Old Student");
    System.out.println("3. Show Programs and Subjects");
    System.out.println("4. Student Database");
    System.out.println("5. Show Students Enrolled by Program");
    System.out.println("6. Show Students Enrolled by Subjects");
    System.out.println("7. Inquiry");
    System.out.println("8. Exit");
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
                showStudentsEnrolledByProgram(scanner);
                break;
            case 6:
                showStudentsEnrolledBySubjects(scanner);
                break;
            case 7:
                inquiry(scanner);
                break;
            case 8:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    } else {
        System.out.println("Invalid input. Please enter a number.");
        scanner.nextLine(); // Consume the invalid input
    }
}
}
    
}

public class RunEnrollmentSystem {
    public static void main(String[] args) {
        EnrollmentSystem enrollmentSystem = new EnrollmentSystem();
        enrollmentSystem.mainMenu();

    }
}