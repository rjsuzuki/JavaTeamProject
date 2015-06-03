import java.util.*;
import java.io.*;

public class Student implements Serializable {

  private String firstName;
  private String lastName;
  private String userLogin;
  private int studentSsn;


  //Constructor
  Student(String a, String b, int c) {
    a = firstName;
    b = lastName;
    c = studentSsn;
  }

  public String getFullName() {
    return firstName + " " + lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getStudentSsn() {
    return studentSsn;
  }

  public void setStudentSsn(int ssn) {
    studentSsn = ssn;
  }

  public String toString() {
    return firstName + " " + lastName + ", " + studentSsn;
  }

} //end of Class
