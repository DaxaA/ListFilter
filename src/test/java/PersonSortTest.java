import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PersonSortTest {
    PersonList sortedPerson;
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
        Map<Field, Ord> sortMap = new HashMap<>();
        sortMap.put(Field.secondname, Ord.descending);
        sortedPerson = PersonSort.personSort(personList, sortMap);
    }
    @Test
    void sortDescendingForSecondName() {
        assertEquals(8, sortedPerson.getPersonList().size());
        assertEquals("Shap", sortedPerson.getPersonList().get(0).getSecondName());
        assertEquals("Shap", sortedPerson.getPersonList().get(1).getSecondName());
        assertEquals("Shap", sortedPerson.getPersonList().get(2).getSecondName());
        assertEquals("Nos", sortedPerson.getPersonList().get(3).getSecondName());
        assertEquals("Kor", sortedPerson.getPersonList().get(4).getSecondName());
        assertEquals("Iv", sortedPerson.getPersonList().get(5).getSecondName());
        assertEquals("Iv", sortedPerson.getPersonList().get(6).getSecondName());
        assertEquals("Cheb", sortedPerson.getPersonList().get(7).getSecondName());
    }
}