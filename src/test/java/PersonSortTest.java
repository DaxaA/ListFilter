import com.daxa.gradle.listfilter.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PersonSortTest {
    List<Person> sortedPerson;
    List<Person> personList = new ArrayList<>();
    Map<Field, Ord> sortMap = new HashMap<>();

    @BeforeEach
    void setUp() {
        personList.add(new Person("Nik", "Nos", Gen.MALE, 2002));
        personList.add(new Person("Artem", "Iv", Gen.MALE, 2001));
        personList.add(new Person("Lena", "Shape", Gen.FEMALE, 2006));
        personList.add(new Person("Dasha", "Iv", Gen.FEMALE, 2002));
        personList.add(new Person("Alex", "Shape", Gen.MALE, 1999));
        personList.add(new Person("Sergey", "Che", Gen.MALE, 2000));
        personList.add(new Person("Lena", "Kor", Gen.MALE, 1998));
        personList.add(new Person("Nik", "Shape", Gen.MALE, 2000));
    }

    @Test
    void sortDescendingForSecondName() {
        sortMap.put(Field.SECONDNAME, Ord.DESCENDING);
        sortedPerson = PersonSort.personSort(personList, sortMap);
        assertEquals(8, sortedPerson.size());
        assertEquals("Shape", sortedPerson.get(0).getSecondName());
        assertEquals("Shape", sortedPerson.get(1).getSecondName());
        assertEquals("Shape", sortedPerson.get(2).getSecondName());
        assertEquals("Nos", sortedPerson.get(3).getSecondName());
        assertEquals("Kor", sortedPerson.get(4).getSecondName());
        assertEquals("Iv", sortedPerson.get(5).getSecondName());
        assertEquals("Iv", sortedPerson.get(6).getSecondName());
        assertEquals("Che", sortedPerson.get(7).getSecondName());
    }

    @Test
    void sortAscendingForYear() {
        sortMap.put(Field.YEAR, Ord.ASCENDING);
        sortedPerson = PersonSort.personSort(personList, sortMap);
        assertEquals(1998, sortedPerson.get(0).getYear());
        assertEquals(1999, sortedPerson.get(1).getYear());
        assertEquals(2000, sortedPerson.get(2).getYear());
        assertEquals(2000, sortedPerson.get(3).getYear());
        assertEquals(2001, sortedPerson.get(4).getYear());
        assertEquals(2002, sortedPerson.get(5).getYear());
        assertEquals(2002, sortedPerson.get(6).getYear());
        assertEquals(2006, sortedPerson.get(7).getYear());
    }
}