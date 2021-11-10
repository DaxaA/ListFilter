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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Gen getGender() {
        return gender;
    }

    public void setGender(Gen gender) {
        this.gender = gender;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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
        return (gender.equals(((Person) obj).gender))
                && firstName.equals(((Person) obj).firstName) && secondName.equals(((Person) obj).secondName);
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