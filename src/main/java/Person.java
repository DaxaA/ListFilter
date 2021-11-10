import java.util.*;

public class Person {
    private String firstName;
    private String secondName;
    private Gen gender;
    private Integer year;

    public Person(String firstName, String secondName, Gen gender, Integer year) {
        if ((firstName == null || !firstName.isEmpty())
                || (secondName == null || !secondName.isEmpty())
                && gender != null) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.gender = gender;
            this.year = year;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public Gen getGender() {
        return gender;
    }

    public Integer getYear() {
        return year;
    }

    @Override
    public String toString() {
        return firstName + " " +
                secondName + ": gen - " + gender + ", year - " + year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, gender, year);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj instanceof Person) return false;
        Person person = (Person) obj;
        return (gender.equals(person.gender))
                && firstName.equals(person.firstName) && secondName.equals(person.secondName);
    }

    public Object getProperty(Field key) {
        if (key == Field.year) {
            return year;
        } else if (key == Field.secondname) {
            return secondName;
        }  else if (key == Field.gender) {
            return gender;
        } else {
            return firstName;
        }
    }
}