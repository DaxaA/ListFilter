import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PersonFilterTest {
    List<Person> filteredPerson;
    PersonList personList = new PersonList();
    PersonFilter personFilter;
    private static Person p1;
    private static Person p2;
    private static Person p3;

    @BeforeEach
    void setUp() {
        p1 = new Person("A", "A", Gen.female, 2001);
        p2 = new Person("A", "I", Gen.male, 100);
        p3 = new Person("N", "A", Gen.female, 1);
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        Map<Field, String> wayMap = new HashMap<>();
        wayMap.put(Field.firstname, "A");
        //wayMap.put(Field.year, "2002");
        personFilter = new PersonFilter(wayMap);
        filteredPerson = personFilter.personFilter(personList);
    }

    @Test
    void listIsFiltered() {
        assertEquals(2, filteredPerson.size());
        assertEquals("A", filteredPerson.get(0).getFirstName());
        //assertEquals(2001, filteredPerson.get(0).getYear());
    }

}