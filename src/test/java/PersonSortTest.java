import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PersonSortTest {
    PersonList sortedPerson;
    PersonList personList = new PersonList();
    Map<Field, Ord> sortMap = new HashMap<>();

    @BeforeEach
    void setUp() {
        personList.add(new Person("Nik", "Nos", Gen.male, 2002));
        personList.add(new Person("Artem", "Iv", Gen.male, 2001));
        personList.add(new Person("Lena", "Shape", Gen.female, 2006));
        personList.add(new Person("Dasha", "Iv", Gen.female, 2002));
        personList.add(new Person("Alex", "Shape", Gen.male, 1999));
        personList.add(new Person("Sergey", "Che", Gen.male, 2000));
        personList.add(new Person("Lena", "Kor", Gen.male, 1998));
        personList.add(new Person("Nik", "Shape", Gen.male, 2000));
    }

    @Test
    void sortDescendingForSecondName() {
        sortMap.put(Field.secondname, Ord.descending);
        sortedPerson = PersonSort.personSort(personList, sortMap);
        assertEquals(8, sortedPerson.getPersonList().size());
        assertEquals("Shape", sortedPerson.getPersonList().get(0).getSecondName());
        assertEquals("Shape", sortedPerson.getPersonList().get(1).getSecondName());
        assertEquals("Shape", sortedPerson.getPersonList().get(2).getSecondName());
        assertEquals("Nos", sortedPerson.getPersonList().get(3).getSecondName());
        assertEquals("Kor", sortedPerson.getPersonList().get(4).getSecondName());
        assertEquals("Iv", sortedPerson.getPersonList().get(5).getSecondName());
        assertEquals("Iv", sortedPerson.getPersonList().get(6).getSecondName());
        assertEquals("Che", sortedPerson.getPersonList().get(7).getSecondName());
    }

    @Test
    void sortAscendingForYear() {
        sortMap.put(Field.year, Ord.ascending);
        sortedPerson = PersonSort.personSort(personList, sortMap);
        assertEquals(1998, sortedPerson.getPersonList().get(0).getYear());
        assertEquals(1999, sortedPerson.getPersonList().get(1).getYear());
        assertEquals(2000, sortedPerson.getPersonList().get(2).getYear());
        assertEquals(2000, sortedPerson.getPersonList().get(3).getYear());
        assertEquals(2001, sortedPerson.getPersonList().get(4).getYear());
        assertEquals(2002, sortedPerson.getPersonList().get(5).getYear());
        assertEquals(2002, sortedPerson.getPersonList().get(6).getYear());
        assertEquals(2006, sortedPerson.getPersonList().get(7).getYear());
    }
}