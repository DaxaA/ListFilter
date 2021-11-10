import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaginationTest {
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
        pagedPerson = Pagination.paginationList(2, 3, personList);
    }

    @Test
    void truePage() {
        assertEquals(2, pagedPerson.getPersonList().size());
        assertEquals("Alex", pagedPerson.getPersonList().get(0).getFirstName());
        assertEquals("Sergey", pagedPerson.getPersonList().get(1).getFirstName());
    }
}