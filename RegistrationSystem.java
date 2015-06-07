import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.*;
import java.util.*;

public class RegistrationSystem implements Serializable {

    //For User Input
    private File studentRegistryList;
    private Scanner fileScanner;
    private Scanner userInputScanner;
    ArrayList<Student> studentList = new ArrayList<Student>();

    private int maximumStudentCapacity = 30;
    private int courseMaxSize = 10;
    private int courseCurrentSize = 0;
    private CourseList courseList;  //may or may not be right

    public static void main(String[] args) {


        RegistrationSystem builder = new RegistrationSystem();
        builder.go();

    } // end of static void

    public void go() {

        //Student Registration Begins here
        try {
          //Set up Scanner object using system.in
          userInputScanner = new Scanner(System.in);


          System.out.println("Welcome to the University of Irvine Online Registration System!");
          System.out.println("To create a new user press 1. To login press 2.");
          String menuOption = userInputScanner.next();
          int number = Integer.parseInt(menuOption); //Converts user input to an integer
          if (number == 1) {
            userRegistration();
          } else if (number == 2) {
            courseRegistration();
          } else {
            System.out.println("Invalid input. Please choose again.");
            go();
          }

          userInputScanner.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
    } //end of go()

    //*********************************To create a new User*************************************************
    public void userRegistration() {

        try {
          userInputScanner = new Scanner(System.in);

          //Prompt for User's info
          System.out.println("Please enter your first name: ");
          String userFirstName = userInputScanner.next();

          System.out.println("Please enter your last name: ");
          String userLastName = userInputScanner.next();

          System.out.println("Please enter your age: ");
          int userAge = userInputScanner.nextInt();

          System.out.println("Please enter your gender (M/F): ");
          char userGender = userInputScanner.next().charAt(0);

          System.out.println("Please enter your SSN: ");
          String userSsn = userInputScanner.next();

          System.out.println("Please enter a 5-digit student ID number:");
          String studentId = userInputScanner.next();

          //Create a new User with User's input and add to studentList
          studentList.add(new Student(userFirstName, userLastName, userAge, userGender, userSsn, studentId));

          //save user's input to file
          FileOutputStream fileOut = new FileOutputStream("studentRegistryList.ser"); // creates a serial file in ouput stream
          ObjectOutputStream out = new ObjectOutputStream(fileOut); // routes an object into the output stream
            out.writeObject(studentList); // write specified object(s) into file
          out.close();
          fileOut.close();


          //validate if ssn = unique?

          //use equals() to compare strings
          System.out.println("Thank you " + userFirstName + " " + userLastName);
          System.out.println("You have now been added to the database.");

          //Return screen to login page
          go();

          userInputScanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //*********************************To sign in a registered User*********************************
    /*public void userLogin() {
      try {
          userInputScanner = new Scanner(System.in);
          //Prompt User for login name
          System.out.println("Please enter your student ID: ");
          String login = userInputScanner.next();
          //open file and retrieve user info from database
          try {
              FileInputStream fileIn = new FileInputStream("studentRegistryList.ser");
              ObjectInputStream in = new ObjectInputStream(fileIn);
              deserializedStudentList = (ArrayList)in.readObject();
              in.close();
              fileIn.close();
          } catch (IOException i) {
              i.printStackTrace();
          } catch (ClassNotFoundException e) {
              e.printStackTrace();
          }
          //Loop through array and find matching ID, if false,
          for (Student student : deserializedStudentList) {
              if (student.getStudentId().equals(login)) {
                  System.out.println("Successful login.");
                  courseRegistration();
              } else {
                    System.out.println("User not found. Please re-enter student ID:");
                    //userLogin();
              }
          }
          userInputScanner.close();
      } catch (Exception e) {
            e.printStackTrace();
      }
    }*/

    //*********************************Course registration option*********************************
    public void courseRegistration() {

            try {
              userInputScanner = new Scanner(System.in);
              System.out.println("Please choose from the following options");
              System.out.println("To view available courses, press 1.");
              System.out.println("To view registered courses, press 2.");
              System.out.println("To register for course, press 3.");
              System.out.println("To unregister for course, press 4.");
              String courseOption = userInputScanner.next();
              int number = Integer.parseInt(courseOption);

              if (number == 1) {
                  //Show available courses + option to register for course.
                  // NOTE: which method is wanted here?
                  //courseList.viewCourseList();  // displays all courses
                  courseList.viewAvailableCourseList(); // displays courses w/ seats available
              } else if (number == 2) {
                  //Show registered courses + option to un-register from course.
              } else if (number == 3) {
                  System.out.println("Enter course id");
                  int courseId = Integer.parseInt(userInputScanner.next());
                  // NOTE: should be ssn or student id
                  System.out.println("Enter Social Security Number");
                  String ssn = userInputScanner.next();
                  // Get student
                  Student student = null;
                  for(Student s: studentList) {
                      if(s.getStudentSsn() == ssn) {
                          student = s;
                      }
                  }
                  if(student != null) {
                      // Register for course
                      boolean enrollmentStatus = courseList.registerForCourse(courseId, student);
                      if(enrollmentStatus == false) {
                          System.out.println("Student course registration failed");
                      } else {
                          System.out.println("Registered for course");
                          // TODO: add course list to Student
                          //student.addCourse(id);
                      }
                  } else {
                      // Failed to find student in studentList
                      System.out.println("Could not find student enrolled.");
                  }
              } else if (number == 4) {
                  System.out.println("Enter course id");
                  int courseId = Integer.parseInt(userInputScanner.next());
                  // NOTE: should be ssn or student id
                  System.out.println("Enter Social Security Number");
                  String ssn = userInputScanner.next();
                  // Get student from social security number
                  Student student = null;
                  for(Student s: studentList) {
                      if(s.getStudentSsn() == ssn) {
                          student = s;
                      }
                  }
                  if(student != null) {
                      // Register for course
                      boolean enrollmentStatus = courseList.unregisterForCourse(courseId, student);
                      if(enrollmentStatus == false) {
                          System.out.println("Course unregistration failed");
                      } else {
                          System.out.println("Unregistered for course");
                          // TODO: add course list to Student
                          //student.removeCourse(id);
                      }
                  } else {
                      // Failed to find student in studentList
                      System.out.println("Could not find student enrolled.");
                  }
              } else {
                  //Return invalid input message and try again.
              }

              userInputScanner.close();
            } catch (Exception e) {
                  e.printStackTrace();
            }

        }

        //Changing course size
        public int getCourseSize() {
            return courseCurrentSize;
        }
 /*     public  RegistrationSystem() {
            courseList = new CourseList();
        }  */


} //end of Class
