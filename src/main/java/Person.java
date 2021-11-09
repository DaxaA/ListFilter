import java.util.*;

public class Person {
    private String firstName;
    private String secondName;
    private Gen gender;
    private int year;

    public Person(String firstName, String secondName, Gen gender, int year) {
        if ((firstName == null || !firstName.isEmpty())
                || (secondName == null || !secondName.isEmpty())
                && gender != null && year > 0) {
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return PersonList.number + ". " + firstName + " " +
                secondName + ": gen - " + gender + ", year - " + year + ";";
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
        switch (key) {
            case firstname -> {
                return firstName;
            }
            case secondname -> {
                return secondName;
            }
            case year -> {
                return year;
            }
            default -> {
                return gender;
            }
        }
    }
}