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

  public static void main(String[] args) {
      RegistrationSystem builder = new RegistrationSystem();
      builder.go();

  } // end of static void

  public void go() {

      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
      //get current date
      Date date = new Date();
      System.out.println(dateFormat.format(date));


      //Student Registration Begins here, first and last name.
      try {
        //Set up Scanner object using system.in
        userInputScanner = new Scanner(System.in);

        //Prompt for User's name
        System.out.println("Please enter your first name: ");
        String userFirstName = userInputScanner.next();

        System.out.println("Please enter your last name: ");
        String userLastName = userInputScanner.next();

        System.out.println("Please enter your login name: ");
        String userLogin = userInputScanner.next();


        //Instantiate a new User with User's input
        Student userLogin = new Student();
        userLogin.setFirstName(userFirstName);
        userLogin.setLastName(userLastName);

        //save user's input to file


        saveToFile.close();
        userInputScanner.close();
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      }

      //Serialize or text ouput of data?


      //provide 2 options for registered user on menu

      //View available courses > Show important information, ability to organize?

      //View Registered courses > then choose to return to main menu or Un-register a course

      //Save updated information to database




  } //end of go()
} //end of Class
