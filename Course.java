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

    //Create an ArrayList for courses, must include alphabetization method

    //A Teacher has course(s)



} //end of Class
