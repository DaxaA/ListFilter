package com.daxa.gradle.listfilter;// Все классы необходимо распределять по пакетам
// Название пакета, обычно, соответствует названию артефакта - groupId + artefactId
// В твоем случае, название корневого пакета может быть таким - com.daxa.gradle.listfilter

import java.util.*;

public class Person {
    private final String firstName;
    private final String secondName;
    private final Gen gender;
    private final Integer year;

    public Person(String firstName, String secondName, Gen gender, Integer year) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.gender = gender;
        this.year = year;
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
        if (key == Field.YEAR) {
            return year;
        } else if (key == Field.SECONDNAME) {
            return secondName;
        }  else if (key == Field.GENDER) {
            return gender;
        } else {
            return firstName;
        }
    }
}