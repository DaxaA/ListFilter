import com.daxa.gradle.listfilter.Field;
import com.daxa.gradle.listfilter.Gen;
import com.daxa.gradle.listfilter.Person;
import com.daxa.gradle.listfilter.PersonFilter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PersonFilterTest {
    List<Person> filteredPerson;
    List<Person> personList = new ArrayList<>();
    Map<Field, Object> filterMap = new HashMap<>();

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
        //filterMap.put(com.daxa.gradle.listfilter.Field.firstname, "A");
        filterMap.put(Field.SECONDNAME, "Shape");
        filterMap.put(Field.GENDER, Gen.MALE);
        //filterMap.put(com.daxa.gradle.listfilter.Field.year, "2001");
    }

    @Test
    void listIsFiltered() {
        filteredPerson = PersonFilter.personFilter(personList, filterMap);
        System.out.println(filteredPerson);
        assertEquals(2, filteredPerson.size());
        assertEquals("Shape", filteredPerson.get(0).getSecondName());
        assertEquals("Shape", filteredPerson.get(1).getSecondName());
        assertEquals(Gen.MALE, filteredPerson.get(0).getGender());
        assertEquals(Gen.MALE, filteredPerson.get(1).getGender());
        assertEquals("Alex", filteredPerson.get(0).getFirstName());
        assertEquals("Nik", filteredPerson.get(1).getFirstName());
    }

}