import com.daxa.gradle.listfilter.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    List<Person> filteredPerson;
    List<Person> sortedPerson;
    List<Person> pagedPerson;
    List<Person> personList = new ArrayList<>();
    Map<Field, Object> filterMap = new HashMap<>();
    Map<Field, Ord> sortMap = new HashMap<>();

    @BeforeEach
    void setUp() {
        personList.add(new Person("Nik", "Nos", Gen.MALE, 2002));
        personList.add(new Person("Artem", "Iv", Gen.MALE, 2001));
        personList.add(new Person("Lena", "Shape", Gen.FEMALE, 2006));
        personList.add(new Person("Dasha", "Iv", Gen.FEMALE, 2002));
        personList.add(new Person("Alex", "Shape", Gen.MALE, 1999));
        personList.add(new Person("Sergey", "Che", Gen.MALE, 2000));
        personList.add(new Person("Lena", "Kor", Gen.MALE, 1999));
        personList.add(new Person("Nik", "Shape", Gen.MALE, 2000));
        filterMap.put(Field.SECONDNAME, "Shape");
        filterMap.put(Field.GENDER, Gen.MALE);
        sortMap.put(Field.FIRSTNAME, Ord.DESCENDING);
    }

    @Test
    public void getAllPersonNotNull() {
        List<Person> expected = personList;
        assertNotNull(expected);
    }

    @Test
    void listIsReady() {
        filteredPerson = PersonFilter.personFilter(personList, filterMap);
        sortedPerson = PersonSort.personSort(filteredPerson, sortMap);
        pagedPerson = Pagination.paginationList(1, 2, sortedPerson);
        assertEquals(1, pagedPerson.size());
        assertEquals("Alex", pagedPerson.get(0).getFirstName());
        assertEquals("Shape", pagedPerson.get(0).getSecondName());
        assertEquals(Gen.MALE, pagedPerson.get(0).getGender());
        assertEquals(1999, pagedPerson.get(0).getYear());
    }
}