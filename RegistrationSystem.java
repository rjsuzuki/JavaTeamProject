import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.*;
import java.util.*;

public class RegistrationSystem {
  public static void main(String[] args) {

      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
      //get current date
      Date date = new Date();
      System.out.println(dateFormat.format(date));


      //For User Input
      File schoolRegistrar;
      Scanner fileScanner;
      Scanner userInputScanner;
      PrintWriter userDatabase;

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

        System.out.println("Thank you " + userLogin + ". You have successfully registered.");
        System.out.println("Please follow further instructions to proceed with course registration");
        
        //save user's input to file
        schoolRegistrar = new File("userDatabase");
        userDatabase = new PrintWriter(schoolRegistrar);
        userDatabase.println(userLastName + userFirstName + userLogin);

        userDatabase.close();
        userInputScanner.close();
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      }

//After student registers, prompt

  } //end of public static
} //end of Class
