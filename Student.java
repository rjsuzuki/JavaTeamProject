import java.io.Serializable;
import java.util.*;

public class Student implements Serializable {

  static final long serialVersionUID = -6588858836832007281L;
  private String firstName;
  private String lastName;
  private String userLogin;
  private ArrayList<Course> courseList;

  public void getRegisteredCourses() {
    return courseList.getList();
  }


  //Constructor
  Student(String a, String b, String c) {
    a = firstName;
    b = lastName;
    c = userLogin;
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

  public String toString() {
    return firstName + " " + lastName + ", ";
  }

} //end of Class
