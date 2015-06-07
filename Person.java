import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.io.Serializable;

public class Person implements Serializable, Comparable<Person> {


    //State(first,last,age,gender,ssn)
    private String firstName;
    private String lastName;
    private int age;
    private char gender;
    private String ssn;


    //Person Class - blueprint
    Person(String a, String b, int c, char d, String e) {
      firstName = a;
      lastName = b;
      age = c;
      gender = d;
      ssn = e;
    }


    // Methods - Setters and Getters`
    public String getFullName() {
      return firstName + " " + lastName;
    }

    public String getFirstName() {
      return firstName;
    }

    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }

    public String getLastName() {
      return lastName;
    }

    public void setLastName(String lastName) {
      this.lastName = lastName;
    }

    public int getAge() {
      return age;
    }

    public void setAge(int age) {
      this.age = age;
    }

    public char getGender() {
      return gender;
    }

    public void setGender(char gender) {
      this.gender = gender;
    }

    public String getSsn() {
      return ssn;
    }

    public void setSsn(String ssn) {
      this.ssn = ssn;
    }

    //Speak
    public void speak() {
      System.out.println("Hello");
    }


    public String toString() {
      return "First name: " + firstName + ", Last name: " + lastName + ", Age: " + age + ", Gender: " + gender +
                ", SSN: " + ssn;
    }

    public int compareTo(Person person) {
      return this.lastName.compareTo(person.getLastName());
    }

}
