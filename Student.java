import java.util.*;
import java.io.*;

public class Student extends Person implements Serializable {

  private String studentId;
  private ArrayList<Course> courseList;

  //Constructor
  public Student(String firstName, String lastName, int age, char gender, String ssn, String studentId) {
      super(firstName, lastName, age, gender, ssn);
      this.studentId = studentId;
      this.courseList = new ArrayList<Course>();
  }

  public void setStudentId(String studentId) {
    this.studentId = studentId;
  }

  public String getStudentId() {
      return studentId;
  }

  public String getStudentSsn() {
      return super.getSsn();
  }

  public void registerForCourse(Course course) {
	  courseList.add(course);
  }
  
  public void unregisterForCourse(Course course) {
	  courseList.remove(course);
  }
  
  public void viewCourseList() {
		//Iterate over courseList, view each course info
		for(Course c: courseList) {
			c.viewCourseInfo();
		}
  }
} //end of Class
