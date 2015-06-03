/* Person class */
public class Person {
	// state / fields
	private String firstName;
	private String lastName;
	private int age;
	private char gender;
	private String ssn;
	
	// Constructor
	public Person() {
		firstName = null;
		lastName = null;
		age = 0;
		gender = 'M';
		ssn = null;
		
	}
	// Constructor
	public Person(Person person) {
		firstName = person.firstName;
		lastName = person.lastName;
		age = person.age;
		gender = person.gender;
		ssn = person.ssn;
		
	}
	// Constructor
	public Person(String first, String last, int a, char g, String s) {
		firstName = first;
		lastName = last;
		// Note: this homework assignment does not do error checking for age, gender or digits in ssn
		age = a;
		gender = g;
		ssn = s;	
	}
	public boolean equal(Person p) {
		if(p.ssn == ssn && p.lastName == lastName && p.firstName == firstName && p.age == age
				&& p.gender == gender) {
			return true;
		} else {
			return false;
		}
	}
	public void talk() {
		System.out.println("Hi");
		
	}
	// Determine Full Name
	// Return string composed of first name, a space, then last name
	public String getFullName() {
		String fullName = new String(firstName + " " + lastName);
		return fullName;
	}
	
	// Return field values
	public String getFirstName() {
		return firstName; 
	}
	public String getLastName() {
		return lastName; 
	}
	// Determine Age
	public int getAge() {
		return age; 
	}
	// Determine Gender
	public char getGender() {
		return gender; 
	}
	// Determine SSN
	public String getSSN() {
		return ssn; 
	}
	
	// setters of data variables
	public void setFirstName(String name) {
		firstName = name;
	}
	
	public void setLastName(String name) {
		lastName = name;
	}
	
	public void setAge(int a) {
		age = a;
	}
	
	public void setGender(char g) {
		gender = g;
	}
	
	public void setSSN(String s) {
		ssn = s;
	}
	
	public String toString() {
		return "Person [firstName " + firstName + ", lastName " + lastName + ", age " + age + ", gender " + gender + ", ssn " + ssn + "]";
	}
}