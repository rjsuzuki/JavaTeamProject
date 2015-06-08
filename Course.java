/*
 * Course contains course name, summary, when taught, list of students and
 * maximum limit of students which can enroll
 */
import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Course {
	private int id;    // unique course identification number
	private String courseName;
	private String summary;
	private  Datex startDate;
	private  Datex endDate;
	private ArrayList<Student> studentList;
	private int studentLimit;

	// Constructor
	public Course() {
		id = 0;
		courseName = null;
		summary = null;
		studentLimit = 0;
		studentList = new ArrayList<Student>();
	}
	// Constructor
	public Course(int id,  Datex startDate,  Datex endDate, String courseName, String summary, int studentLimit) {
		this.id = id;
		this.courseName = courseName;
		this.summary = summary;
		this.startDate = startDate;
		this.endDate = endDate;
		this.studentLimit = studentLimit;
		studentList = new ArrayList<Student>();
	}

	public boolean equals(Course c) {
		// Each course id is unique, only id checked
		if(id == c.id) {
			return true;
		} else {
			return false;
		}
	}
	public void setCourseId(int id) {
		this.id = id;
	}
	public void setCourseName(String name) {
		courseName = name;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}

	public void setDate( Datex startDate,  Datex endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public void setStudentLimit(int limit) {
		studentLimit = limit;
	}

	public ArrayList<Student> getStudentList() {
			return studentList;
	}

	public int getCourseId() {
		return id;
	}
	public String getCourseName() {
		return courseName;
	}
	public String getSummary() {
		return summary;
	}

	public  Datex getStartDate() {
		return startDate;
	}
	public  Datex getEndDate() {
		return endDate;
	}
	public int getAvailableSeats() {
		return studentLimit - studentList.size();
    }
	public boolean isSeatAvailable() {
	        if(studentList.size() >= studentLimit) {
	            return false;
	        } else {
	            return true;
	        }
    }



	public boolean register(Student student) {
		if(studentList.size() + 1 <= studentLimit) {
			studentList.add(student);
//			student.addCourse(id);    // add course id to student's course list
			return true;
		} else {
			// course full;
			return false;
		}
	}


	public boolean unregister(Student student) {
		// Check student enrolled in course
		if(studentList.size() > 0 && isStudent(student)) {
			studentList.remove(student);
//			student.removeCourse(id);
			return true;
		} else {
			// Not student enrolled in the course
			return false;
		}

	}
	// Check student enrolled
	public boolean isStudent(Student student) {
		for(Student s: studentList) {
			if(s.equals(student)) {
				return true;
			}
		}
		return false;
	}
	// Output course information to console
	// Alphabetical list of course identification number, course dates, name, brief summary,
	// the enrollment limit, and the number of students already enrolled.
	public void viewCourseInfo() {
		System.out.println("Course ID: " + id);
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
}
