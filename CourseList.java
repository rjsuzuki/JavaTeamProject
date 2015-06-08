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

			while (fileScanner.hasNextLine()) {
						String[] courseAttributes = fileScanner.nextLine().split(",");

						Datex tempStartDate = new Datex(new Integer(courseAttributes[4]).intValue(),new Integer(courseAttributes[5]).intValue(),new Integer(courseAttributes[6]).intValue());
						Datex tempEndDate = new Datex(new Integer(courseAttributes[7]).intValue(), new Integer(courseAttributes[8]).intValue(), new Integer(courseAttributes[9]).intValue());
						Course tempCourse = new Course(new Integer(courseAttributes[0]).intValue(), tempStartDate, tempEndDate, courseAttributes[1],
																								courseAttributes[2], new Integer(courseAttributes[3]).intValue());

						courseList.add(tempCourse);
						}


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
}
