import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.LoggingPermission;

import static org.junit.jupiter.api.Assertions.*;

class PersonFilterTest {
    PersonList filteredPerson;
    PersonList pagedPerson;
    PersonList personList = new PersonList();
    private static Person p1;
    private static Person p2;
    private static Person p3;

    @BeforeEach
    void setUp() {
        personList.add(new Person("Nik", "Nos", Gen.male, 2002));
        personList.add(new Person("Artem", "Iv", Gen.male, 2001));
        personList.add(new Person("Lena", "Shap", Gen.female, 2006));
        personList.add(new Person("Dasha", "Iv", Gen.female, 2002));
        personList.add(new Person("Alex", "Shap", Gen.male, 1999));
        personList.add(new Person("Sergey", "Cheb", Gen.male, 2000));
        personList.add(new Person("Lena", "Kor", Gen.male, 1999));
        personList.add(new Person("Nik", "Shap", Gen.male, 2000));
        Map<Field, Object> filterMap = new HashMap<>();
        //filterMap.put(Field.firstname, "A");
        filterMap.put(Field.secondname, "Shap");
        filterMap.put(Field.gender, Gen.male);
        //filterMap.put(Field.year, "2001");
        filteredPerson = PersonFilter.personFilter(personList, filterMap);
    }

    @Test
    void listIsFiltered() {
        assertEquals(2, filteredPerson.getPersonList().size());
        assertEquals("Shap", filteredPerson.getPersonList().get(0).getSecondName());
        assertEquals("Shap", filteredPerson.getPersonList().get(1).getSecondName());
        assertEquals(Gen.male, filteredPerson.getPersonList().get(0).getGender());
        assertEquals(Gen.male, filteredPerson.getPersonList().get(1).getGender());
    }

}