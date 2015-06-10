import java.util.*;
import java.io.*;

@SuppressWarnings("serial")

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

  // Check if registered for course
  public boolean isRegistered(Course course) {
	  for(Course c: courseList) {
		  if(c.equals(course)) {
			  return true;
		  }
	  }
	  return false;
  }

  // Add course to Student's courseList
  public void registerForCourse(Course course) {
	  courseList.add(course);
	  if(courseList.size() > 1) {
		  Collections.sort(courseList);
	  }
  }
  
  public void unregisterForCourse(Course course) {
	  courseList.remove(course);
  }
  
  public void viewCourseList() {
      //Iterate over courseList, view each course info
      for(Course c: courseList) {
          c.viewCourseHeader();
      }
  }
} //end of Class