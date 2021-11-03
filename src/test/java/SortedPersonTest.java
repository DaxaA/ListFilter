import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import perspack.Gen;
import perspack.Person;
import perspack.PersonList;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SortedPersonTest {
    private SortedPerson sortedPerson;
    private PersonList personList = new PersonList();
    private static Person p1;
    private static Person p2;
    private static Person p3;

    @BeforeEach
    void setUp() {
        p1 = new Person("A", "A", Gen.female, 2001);
        p2 = new Person("A", "I", Gen.male, 100);
        p3 = new Person("N", "A", Gen.female, 1978);
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        sortedPerson = new SortedPerson(personList);
    }
    @Test
    void sortForYearAfterFirstName() {
        Stream<Person> personStream = personList.getPersonList().stream().sorted(Comparator.comparing(Person::getFirstName).thenComparing(Person::getYear));
        List<Person> sortedPerson = personStream.collect(Collectors.toList());
        assertEquals("A", sortedPerson.get(0).getFirstName());
        assertEquals("A", sortedPerson.get(1).getFirstName());
        assertEquals("N", sortedPerson.get(2).getFirstName());
        assertEquals(100, sortedPerson.get(0).getYear());
        assertEquals(2001, sortedPerson.get(1).getYear());
        assertEquals(1978, sortedPerson.get(2).getYear());
    }
}