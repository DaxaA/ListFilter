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
        filterMap.put(Field.secondname, "Shap");
        filterMap.put(Field.gender, Gen.male);
        filteredPerson = PersonFilter.personFilter(personList, filterMap);
        Map<Field, Ord> sortMap = new HashMap<>();
        sortMap.put(Field.firstname, Ord.descending);
        sortedPerson = PersonSort.personSort(filteredPerson, sortMap);
        pagedPerson = Pagination.paginationList(1, 2, sortedPerson);
    }

    @Test
    void listIsReady() {
        assertEquals(1, pagedPerson.getPersonList().size());
        assertEquals("Alex", pagedPerson.getPersonList().get(0).getFirstName());
        assertEquals("Shap", pagedPerson.getPersonList().get(0).getSecondName());
        assertEquals(Gen.male, pagedPerson.getPersonList().get(0).getGender());
        assertEquals(1999, pagedPerson.getPersonList().get(0).getYear());
    }
}