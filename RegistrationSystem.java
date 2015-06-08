import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.*;
import java.util.*;

public class RegistrationSystem implements Serializable {

    private static final long serialVersionUID = 1L;

    //For User Input
    private File studentRegistryList;
    private Scanner fileScanner;
    private Scanner userInputScanner;


    private int maximumStudentCapacity = 30;
    private int courseMaxSize = 10;
    private int courseCurrentSize = 0;
    private CourseList courseList;  //may or may not be right
    private ArrayList<Student> studentList;


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
          System.out.println("To create a new user press 1. To begin course registration press 2.");
          int number = userInputScanner.nextInt();
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

          //use equals() to compare strings
          System.out.println("Thank you " + userFirstName + " " + userLastName);
          System.out.println("You have now been added to the database.");

          //Return screen to login page
          courseRegistration();

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
              System.out.println("Please choose from the following options.");
              System.out.println("To view available courses, press 1.");
              System.out.println("To view all courses, press 2.");
              System.out.println("To view registered courses, press 3.");
              System.out.println("To register for course, press 4.");
              System.out.println("To unregister for course, press 5.");
              System.out.println("To save changes, press 6.");
              System.out.println("To save and exit, press 7.");
              int number = userInputScanner.nextInt();


              if (number == 1) {
                  courseList.viewAvailableCourseList(); // displays courses w/ seats available
              	  courseRegistration();
              } else if (number == 2) {
                  //show all courses.
                  courseList.viewCourseList();
                  courseRegistration();
              } else if (number == 3) {
                  //Show registered courses + option to un-register from course.
                  //
                  courseRegistration();
              } else if (number == 4) {
                  System.out.println("Enter course id");
                  int courseId = userInputScanner.nextInt();
                  // NOTE: should be ssn or student id
                  System.out.println("Enter Social Security Number");
                  String ssn = userInputScanner.next();
                  // Get student
                  Student student = null;
                  for(Student s: studentList) {
                      if(s.getStudentSsn().equals(ssn)) {
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
                          // Add course to student's courseList
                          student.registerForCourse(courseList.getCourse(courseId));
                      }
                  } else {
                      // Failed to find student in studentList
                      System.out.println("Could not find student enrolled. Try again or quit and register.");
                      courseRegistration();
                  }
              }
              else if (number == 6 || number ==7) {
				            FileOutputStream fileOut = new FileOutputStream("studentRegistryList.ser"); // creates a serial file in ouput stream
				            ObjectOutputStream out = new ObjectOutputStream(fileOut); // routes an object into the output stream
				              out.writeObject(studentList); // write specified object(s) into file
				            out.close();
				            fileOut.close();

				            //use equals() to compare strings
          		System.out.println("Information saved to the database.");
          		if (number==6) {
				  courseRegistration();
					}
			  }


              else if (number == 5) {
                  System.out.println("Enter course id");
                  int courseId = userInputScanner.nextInt();
                  // NOTE: should be ssn or student id
                  System.out.println("Enter Social Security Number");
                  String ssn = userInputScanner.next();
                  // Get student from social security number
                  Student student = null;
                  for(Student s: studentList) {
                      if(s.getStudentSsn().equals(ssn)) {
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
                          // Remove course to student's courseList
                          student.unregisterForCourse(courseList.getCourse(courseId));
                      }
                  }




                  else {
                      // Failed to find student in studentList
                      System.out.println("Could not find student enrolled. Please try again.");
                      courseRegistration();
                  }
              } else {
                  //Return invalid input message and try again.
                  System.out.println("Invalid input. Please try again.");
                  courseRegistration();
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

        public RegistrationSystem() {
        	System.out.println("RegistrationSystem");
            courseList = new CourseList();
            // TODO: remove the following call, temporary for testing
            //courseList.viewCourseList();
            studentList = new ArrayList<Student>();
        }


} //end of Class
