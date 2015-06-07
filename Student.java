import java.util.*;
import java.io.*;

public class Student extends Person implements Serializable {

  private String studentId;

  public Student(String firstName, String lastName, int age, char gender, String ssn, String studentId) {
      super(firstName, lastName, age, gender, ssn);
      this.studentId = studentId;
  }

  public void setStudentId(String studentId) {
    this.studentId = studentId;
  }

  public String getStudentId() {
      return studentId;
  }



} //end of Class
