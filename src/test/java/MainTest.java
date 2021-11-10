import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    PersonList filteredPerson;
    PersonList sortedPerson;
    PersonList pagedPerson;
    PersonList personList = new PersonList();
    Map<Field, Object> filterMap = new HashMap<>();
    Map<Field, Ord> sortMap = new HashMap<>();

    @BeforeEach
    void setUp() {
        personList.add(new Person("Nik", "Nos", Gen.male, 2002));
        personList.add(new Person("Artem", "Iv", Gen.male, 2001));
        personList.add(new Person("Lena", "Shape", Gen.female, 2006));
        personList.add(new Person("Dasha", "Iv", Gen.female, 2002));
        personList.add(new Person("Alex", "Shape", Gen.male, 1999));
        personList.add(new Person("Sergey", "Che", Gen.male, 2000));
        personList.add(new Person("Lena", "Kor", Gen.male, 1999));
        personList.add(new Person("Nik", "Shape", Gen.male, 2000));
        filterMap.put(Field.secondname, "Shape");
        filterMap.put(Field.gender, Gen.male);
        sortMap.put(Field.firstname, Ord.descending);
    }

    @Test
    void listIsReady() {
        filteredPerson = PersonFilter.personFilter(personList, filterMap);
        sortedPerson = PersonSort.personSort(filteredPerson, sortMap);
        pagedPerson = Pagination.paginationList(1, 2, sortedPerson);
        assertEquals(1, pagedPerson.getPersonList().size());
        assertEquals("Alex", pagedPerson.getPersonList().get(0).getFirstName());
        assertEquals("Shape", pagedPerson.getPersonList().get(0).getSecondName());
        assertEquals(Gen.male, pagedPerson.getPersonList().get(0).getGender());
        assertEquals(1999, pagedPerson.getPersonList().get(0).getYear());
    }
}