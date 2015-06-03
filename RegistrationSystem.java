import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.*;
import java.util.*;

public class RegistrationSystem {
    //For User Input
    File schoolRegistrar;
    Scanner fileScanner;
    Scanner userInputScanner;
    PrintWriter saveToFile;

    String firstName;
    String lastName;
    String userLogin;

    private int courseMaxSize = 10;
    private int courseCurrentSize = 0;

    public static void main(String[] args) {
        RegistrationSystem builder = new RegistrationSystem();
        builder.go();

    } // end of static void

    public void go() {

        //Student Registration Begins here, first and last name.
        try {
          //Set up Scanner object using system.in
          userInputScanner = new Scanner(System.in);


          System.out.println("Welcome to the University of Irvine Online Registration System!");
          System.out.println("To create a new user press 1. To login press 2.");
          String menuOption = userInputScanner.next();
          int number = Integer.parseInt(menuOption);
          if (number == 1) {
            userRegistration();
          } else if (number == 2) {
            userLogin();
          } else {
            System.out.println("Invalid input. Please choose again.");
            String userInput = userInputScanner.next();
          }

          //After registration, load new screen to enter login include

          //check database for user, then load menu

          //menu selection - show available courses or view registered courses.

          //available courses menu - show list with info - also give option to register for course

          //registered courses menu - show list with info - also give option to un-register a course.

          saveToFile.close();
          userInputScanner.close();
        } catch (Exception e) {
          e.printStackTrace();
        }

    } //end of go()

    //*********************************To create a new User*************************************************
    public void userRegistration() {

        try {
          userInputScanner = new Scanner(System.in);

          //Prompt for User's name
          System.out.println("Please enter your first name: ");
          String userFirstName = userInputScanner.next();

          System.out.println("Please enter your last name: ");
          String userLastName = userInputScanner.next();

          System.out.println("Please enter your SSN: ");
          String ssn = userInputScanner.next();
          int foo = Integer.parseInt(ssn);

          System.out.println("Thank you " + userFirstName + " " + userLastName);

          System.out.println("Please enter your login name: ");
          String userLogin = userInputScanner.next();

          //Instantiate a new User with User's input
          Student userLogin = new Student (userFirstName, userLastName, foo);

          //add new User to courseList
          exampleArray.add(userLogin);

          //save user's input to file
          File schoolRegistrar = new File("database.txt");
          fileScanner = new Scanner(schoolRegistrar);

          //validate if ssn = unique?
          userInputScanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //*********************************To sign in a registered User*********************************
    public void userLogin() {

      try {
          userInputScanner = new Scanner(System.in);
          //Prompt User for login name
          System.out.println("Please enter your login name: ");
          String login = userInputScanner.next();

          //open file and retrieve user info from database
          userInputScanner.close();
      } catch (Exception e) {
            e.printStackTrace();
      }

    }

    //*********************************Course registration option*********************************
    public void courseRegistration() {

        try {
          userInputScanner = new Scanner(System.in);
          System.out.println("Please choose from the following options");
          System.out.println("To view available courses, press 1.");
          System.out.println("To view registered courses, press 2.");
          String courseOption = userInputScanner.next();
          int number = Integer.parseInt(menuOption);

          if (number == 1) {
              //Show available courses + option to register for course.
          } else if (number == 2) {
              //Show registered courses + option to un-register from course.
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


} //end of Class
