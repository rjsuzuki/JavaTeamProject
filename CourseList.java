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
	private ArrayList<Course> alphabetizedCourseList;

	// Constructor
	public CourseList() {
		courseList = new ArrayList<Course>();
		getCourseList();
		getCourseListAlphabetized();
	}

	public void addCourse(Course course) {
		courseList.add(course);
	}
	public void removeCourse(Course course) {
		courseList.remove(course);
	}

	// View of each course information
	public void viewCourseList()
	{
		//Iterate over courseList, view each course info
		for(Course c: courseList) {
			c.viewCourseInfo();
		}
	}

	// View course list Alphabetically
	public void viewCourseListAlphabetically() {
		for(Course c: alphabetizedCourseList) {
			c.viewCourseInfo();
		}
	}

	// View of each course information w/ seats available
	public void viewAvailableCourseList()
	{
		//Iterate over courseList, view each course info
		for(Course c: courseList) {
			if(c.isSeatAvailable()) {
				c.viewCourseInfo();
			}
		}
	}

	public void viewAvailableCourseListAlphabetically()
	{
		for(Course c : alphabetizedCourseList) {
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
			Course course;

			while(fileScanner.hasNextLine()) {
				String[] courseAttributes = fileScanner.nextLine().split(",");
				course = new Course(new Integer(courseAttributes[0]).intValue(), courseAttributes[1], courseAttributes[2], new Integer(courseAttributes[3]).intValue(),
								new Integer(courseAttributes[4]).intValue(), new Integer(courseAttributes[5]).intValue(), new Integer(courseAttributes[6]).intValue(),
								new Integer(courseAttributes[7]).intValue(), new Integer(courseAttributes[8]).intValue(), new Integer(courseAttributes[9]).intValue());
				courseList.add(course);
			}
			fileScanner.close();

			System.out.println(courseList);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }

		public void getCourseListAlphabetized() {
					File courseListFile;
			Scanner fileScanner;
			alphabetizedCourseList = new ArrayList<Course>();
			try
			{
				// Open file CourseList.txt file
				courseListFile = new File("courseList.txt");
				fileScanner = new Scanner(courseListFile);
				Course course;

				while(fileScanner.hasNextLine()) {
					String[] courseAttributes = fileScanner.nextLine().split(",");
					course = new Course(new Integer(courseAttributes[0]).intValue(), courseAttributes[1], courseAttributes[2], new Integer(courseAttributes[3]).intValue(),
									new Integer(courseAttributes[4]).intValue(), new Integer(courseAttributes[5]).intValue(), new Integer(courseAttributes[6]).intValue(),
									new Integer(courseAttributes[7]).intValue(), new Integer(courseAttributes[8]).intValue(), new Integer(courseAttributes[9]).intValue());
					alphabetizedCourseList.add(course);
				}
				fileScanner.close();

				Collections.sort(alphabetizedCourseList);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		public boolean isCourse(int courseId) {
			for(Course c: courseList) {
				if(c.getCourseId() == courseId) {
					return true;
				}
			}
			return false;
		}

}
