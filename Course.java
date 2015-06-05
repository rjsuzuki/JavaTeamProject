import java.util.*;
import java.io.*;

public class Course {

    //Course dates
    private int month;
    private int day;
    private int year;

    //Course information
    private int courseId;
    private Date startDate;
    private Date endDate;
    private String courseName;
    private String summary;
    private int studentLimit;

    //Create an ArrayList for courses, must include alphabetization method
    public ArrayList<Student> studentList;


    // Constructor
    public Course() {
        courseId = 0;
        courseName = null;
        summary = null;
        studentLimit = 0;
        studentList = new ArrayList<Student>();
    }
    // Constructor
    public Course(int id, String courseName, String summary, Date startDate, Date endDate, int studentLimit) {
        this.courseId = id;
        this.courseName = courseName;
        this.summary = summary;
        this.startDate = startDate;
        this.endDate = endDate;
        this.studentLimit = studentLimit;
        studentList = new ArrayList<Student>();
    }
    // Constructor
    public Course(int id, String courseName, String summary) {
        this.courseId = id;
        this.courseName = courseName;
        this.summary = summary;
        this.studentLimit = 0;
        studentList = new ArrayList<Student>();
    }
    public boolean equals(Course c) {
        // Each course id is unique, only id checked
        if(courseId == c.courseId) {
            return true;
        } else {
            return false;
        }
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

    public String getCourseName() {
      return courseName;
    }
    
    public String getSummary() {
        return summary;
    }
    
    public void setDate(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void setCourseId(int courseId) {
      this.courseId = courseId;
    }
    
    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setCourseName(String courseName) {
      this.courseName = courseName;
    }
    
    public void setStudentLimit(int limit) {
        studentLimit = limit;
    }

    public int getStudentsRegistered() {
      return studentList.size();
    }

    public int getAvailableSeats() {
      return studentLimit - studentList.size();
    }
    // Check student enrolled
    private boolean isStudent(Student student) {
        for(Student s: studentList) {
            if(s.equals(student)) {
                return true;
            }
        }
        return false;
    }
    public boolean isSeatAvailable() {
        if(studentList.size() >= studentLimit) {
            return false;
        } else {
            return true;
        }
    }
    
    public boolean registerStudent(Student student) {
        if(studentList.size() + 1 <= studentLimit) {
            studentList.add(student);
            // NOTE: check student instance updated
            //			student.addCourse(courseId);    // add course id to student's course list
            return true;
        } else {
            // course full;
            return false;
        }
    }
    public boolean unregisterStudent(Student student) {
        // Check student enrolled in course
        if(studentList.size() > 0 && isStudent(student)) {
            studentList.remove(student);
            // NOTE: check student instance updated
            //			student.removeCourse(courseId);
            return true;
        } else {
            // Not student enrolled in the course
            System.out.println("Student not enrolled in course.");
            return false;
        }
        
    }
    // Output course information to console
    // Alphabetical list of course identification number, course dates, name, brief summary,
    // the enrollment limit, and the number of students already enrolled.
    public void viewCourseInfo() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Dates: " + startDate.getDate() + " to " + endDate.getDate());
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Summary: " + summary);
        System.out.println("Enrollment Limit " + studentLimit + "    Enrolled Students " + studentList.size());
    }
    // Custom Comparator for sorting the list by courseName in ascending alphabetical order
    public static Comparator<Course> CourseNameComparator = new Comparator<Course>() {
    
    public int compare(Course c1, Course c2) {
	   String courseName1 = c1.getCourseName().toUpperCase();
	   String courseName2 = c2.getCourseName().toUpperCase();
    
	   return courseName1.compareTo(courseName2);
}};

} //end of Class
