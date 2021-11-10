import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    PersonList personList = new PersonList();
    private static Person p1;
    private static Person p2;
    private static Person p3;

    @BeforeEach
    public void setUp() {
        p1 = (new Person("Nik", "Nos", Gen.male, 2002));
        p2 = (new Person("Artem", "Iv", Gen.male, 2001));
        p3 = (new Person("Lena", "Shape", Gen.female, 2006));
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
    }

    @Test
    public void getAllPersonTest() {
        List<Person> expected = personList.getPersonList();
        List<Person> actual = new ArrayList<>();
        actual.add(p1);
        actual.add(p2);
        actual.add(p3);
        assertEquals(expected, actual);
    }

    @Test
    public void getAllPersonNotNull() {
        List<Person> expected = personList.getPersonList();
        assertNotNull(expected);
    }

    @Test
    public void newPersonNameIsNull() {
        for (Person person : personList.getPersonList()) {
            if (((person.getFirstName() != null && person.getFirstName().isEmpty())
                    || (person.getSecondName() != null && person.getSecondName().isEmpty()))
                    || person.getFirstName() == null || person.getSecondName() == null) {
                fail("Empty name!");
            }
        }
    }

    @Test
    public void newPersonGenderIsNull() {
        for (Person person : personList.getPersonList()) {
            if (person.getGender() == null) {
                fail("Undefined gender!");
            }
        }
    }

    @Test
    public void newPersonYearIsNull() {
        for (Person person : personList.getPersonList()) {
            if (person.getYear() <= 0) {
                fail("Non-existent year!");
            }
        }
    }
}