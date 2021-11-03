import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import perspack.Gen;
import perspack.Person;
import perspack.PersonList;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    PersonList allPerson = new PersonList();
    private static Person p1;
    private static Person p2;
    private static Person p3;

    @BeforeEach
    public void setUp() {
        p1 = new Person("D", "A", Gen.female, 2002);
        p2 = new Person("A", "I", Gen.male, 2001);
        p3 = new Person("N", "A", Gen.female, 1978);
        allPerson.add(p1);
        allPerson.add(p2);
        allPerson.add(p3);
    }

    @Test
    public void getAllPersonTest() {
        List<Person> expected = allPerson.getPersonList();
        List<Person> actual = new ArrayList<>();
        actual.add(p1);
        actual.add(p2);
        actual.add(p3);
        assertEquals(expected, actual);
    }

    @Test
    public void getAllPersonNotNull() {
        List<Person> expected = allPerson.getPersonList();
        assertNotNull(expected);
    }

    @Test
    public void newPersonNameIsNull() {
        for (Person person: allPerson.getPersonList()) {
            if (((person.getFirstName() != null && person.getFirstName().isEmpty())
                    || (person.getSecondName() != null && person.getSecondName().isEmpty()))
                    || person.getFirstName() == null || person.getSecondName() == null) {
                fail("Empty name!");
            }
        }
    }

    @Test
    public void newPersonGenderIsNull() {
        for (Person person: allPerson.getPersonList()) {
            if (person.getGender() == null) {
                fail("Undefined gender!");
            }
        }
    }

    @Test
    public void newPersonYearIsNull() {
        for (Person person: allPerson.getPersonList()) {
            if (person.getYear() <= 0) {
                fail("Non-existent year!");
            }
        }
    }
}