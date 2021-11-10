import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PersonFilterTest {
    PersonList filteredPerson;
    PersonList personList = new PersonList();
    Map<Field, Object> filterMap = new HashMap<>();

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
        //filterMap.put(Field.firstname, "A");
        filterMap.put(Field.secondname, "Shape");
        filterMap.put(Field.gender, Gen.male);
        //filterMap.put(Field.year, "2001");
    }

    @Test
    void listIsFiltered() {
        filteredPerson = PersonFilter.personFilter(personList, filterMap);
        System.out.println(filteredPerson);
        assertEquals(2, filteredPerson.getPersonList().size());
        assertEquals("Shape", filteredPerson.getPersonList().get(0).getSecondName());
        assertEquals("Shape", filteredPerson.getPersonList().get(1).getSecondName());
        assertEquals(Gen.male, filteredPerson.getPersonList().get(0).getGender());
        assertEquals(Gen.male, filteredPerson.getPersonList().get(1).getGender());
        assertEquals("Alex", filteredPerson.getPersonList().get(0).getFirstName());
        assertEquals("Nik", filteredPerson.getPersonList().get(1).getFirstName());
    }

}