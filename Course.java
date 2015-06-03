import java.util.*;
import java.io.*;

public class Course {

    //Course dates
    private int month;
    private int day;
    private int year;
    public setDate (int month, int day, int year);
    public String getMonth();
    public String getDay();
    public String getYear();


    //Course information
    private int courseId;
    private Date startDate;
    private Date endDate;
    private String courseName;
    private String summary;
    private int studentsRegistered;

    public void register();
    public void unregister();
    public void viewCourse(); // output course information to console
    public String getSummary();


    //Create an ArrayList for courses, must include alphabetization method
    public ArrayList<Student> studentList;



    //constructors

    Course(int a, Date b, Date c, String d) {
      a = courseId;
      b = startDate;
      c = endDate;
      d = courseName;
    }

    public int getCourseId() {
      return courseId;
    }

    public Date getStartDate() {
      return startDate;
    }

    public Date getEndDate() {
      return endDate;
    }

    public void setStartDate() {

    }

    public void setEndDate() {

    }

    public String getCourseName() {
      return courseName;
    }


    public void setCourseId(int courseId) {
      this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
      this.courseName = courseName;
    }

    public int getStudentsRegistered() {
      return studentsRegistered;
    }

    public int getAvailableSeats() {
      return classMax - studentsRegistered;
    }

    public String toString() {
      return courseId + " " + startDate + " " + endDate + " " + courseName;
    }



} //end of Class
