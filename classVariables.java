//Originally created by Joan

    class Date {
    private int month;
    private int day;
    private int year;
    public setDate(int month, int day, int year(;
    public String getMonth();
    public String getDay();
    public String getYear();
    }

    class Student {
    private String firstName;
    private String lastName;
    private ArrayList<Course> courseList;
    public void viewRegisteredCourses(); // output course names to console
    public int register(int courseId);
    public void unregister(int courseId);
    }

    class Course {
    private int id;
    private Date startDate;
    private Date endDate;
    private String courseName,
    private String summary;
    private int studentLimit;
    private int studentsRegistered;
    private ArrayList<Student> studentList;
    public void register();
    public void unregister();
    public void viewCourse(); // output course information to console
    public String getSummary();
    public int getSudentLimit();
    public int getStudentsRegistered();
    public String getCourseName();
    public int getID();
    public String getStartDate();
    public String getEndDate();
    }

    class Registration {
    private Map<id, Course> courseList;
    private ArrayList<Student> studentList
    public void addCourse(Course course);
    public void deleteCourse(int id);
    public Course getCourse(int id);
    public boolean registerStudent(Student student, int courseId);
    public void unregisterStudent(Student student, int courseId);
    public void viewCourseList(); // output course list in alphabetical order to console
    public void viewStudentCourseList(Student student); // output student's course list to console
    }
