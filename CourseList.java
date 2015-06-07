/*
 * CourseList class manages the courses, student registration and unregistration for course
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CourseList {
	private ArrayList<Course> courseList;

	// Constructor
	public CourseList() {
		courseList = new ArrayList<Course>();
		getCourseList();
	}

	public void addCourse(Course course) {
		courseList.add(course);
	}
	// View of each course information
	public void viewCourseList()
	{
		// Sort the peopleList ArrayList by last name in alphabetical order
		Collections.sort(courseList, Course.CourseNameComparator);

		//Iterate over courseList, view each course info
		for(Course c: courseList) {
			c.viewCourseInfo();
		}
	}
	// View of each course information w/ seats available
	public void viewAvailableCourseList()
	{
		// Sort the peopleList ArrayList by last name in alphabetical order
		Collections.sort(courseList, Course.CourseNameComparator);

		//Iterate over courseList, view each course info
		for(Course c: courseList) {
			if(c.isSeatAvailable()) {
				c.viewCourseInfo();
			}
		}
	}
	public Course getCourse(int id) {
		for(Course c: courseList) {
			if(c.getCourseId() == id) {
				return c;
			}
		}
		return null;
	}
	public boolean registerForCourse(int id, Student student) {
		Course course = getCourse(id);
		return course.register(student);
	}
	public boolean unregisterForCourse(int id, Student student) {
		Course course = getCourse(id);
		return course.unregister(student);
	}
	public void getCourseList() {
    	File courseListFile;
		Scanner fileScanner;
 		courseList = new ArrayList<Course>();
		try
		{
			// Open file CourseList.txt file
			courseListFile = new File("courseList.txt");

			fileScanner = new Scanner(courseListFile);
			// Set delimeter ',' and newline
			fileScanner.useDelimiter("[,\\n]");

			String string;
			Course course;

			int i=0;
			while(fileScanner.hasNext()) {
				// Create Course instance w/ info from input file
				course = new Course();
				course.setCourseId(Integer.parseInt(fileScanner.next())); // Course Id
				course.setCourseName(fileScanner.next()); // Name
				course.setSummary(fileScanner.next());
				course.setStudentLimit(Integer.parseInt(fileScanner.next()));
				int month = Integer.parseInt(fileScanner.next());
				int day = Integer.parseInt(fileScanner.next());
				int year = Integer.parseInt(fileScanner.next());

				month = Integer.parseInt(fileScanner.next());
				day = Integer.parseInt(fileScanner.next());
				year = Integer.parseInt(fileScanner.next());
				Datex startDate = new Datex(month, day, year);
				Datex endDate = new Datex(month, day, year);
				course.setDate(startDate, endDate);
				courseList.add(course);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
}
