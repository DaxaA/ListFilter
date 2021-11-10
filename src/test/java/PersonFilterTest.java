import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.LoggingPermission;

import static org.junit.jupiter.api.Assertions.*;

class PersonFilterTest {
    PersonList filteredPerson;
    PersonList personList = new PersonList();
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
        Map<Field, Object> filterMap = new HashMap<>();
        //filterMap.put(Field.firstname, "A");
        filterMap.put(Field.secondname, "A");
        filterMap.put(Field.gender, Gen.female);
        //filterMap.put(Field.year, "2001");
        filteredPerson = PersonFilter.personFilter(personList, filterMap);
    }

    @Test
    void listIsFiltered() {
        assertEquals(2, filteredPerson.id);
        //assertEquals(Gen.female, filteredPerson.get(0).getGender());
        //assertEquals(2001, filteredPerson.get(0).getYear());
        //assertEquals(Gen.female, filteredPerson.get(1).getGender());
    }

}