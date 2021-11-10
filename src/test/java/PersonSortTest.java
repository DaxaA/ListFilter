import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PersonSortTest {
    PersonList sortedPerson;
    PersonList personList = new PersonList();
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
        Map<Field, Ord> sortMap = new HashMap<>();
        sortMap.put(Field.secondname, Ord.descending);
        sortedPerson = PersonSort.personSort(personList, sortMap);
    }
    @Test
    void sortForYearAfterFirstName() {
        assertEquals(3, sortedPerson.getPersonList().size());
        assertEquals("I", sortedPerson.getPersonList().get(0).getSecondName());
        assertEquals("A", sortedPerson.getPersonList().get(1).getSecondName());
        assertEquals("A", sortedPerson.getPersonList().get(2).getSecondName());
    }
}