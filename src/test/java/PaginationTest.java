import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaginationTest {
    PersonList paged;
    PersonList personList = new PersonList();

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
    }

    @Test
    void truePage() {
        paged = Pagination.paginationList(3, 2, personList);
        assertEquals(3, paged.getPersonList().size());
        assertEquals("Dasha", paged.getPersonList().get(0).getFirstName());
        assertEquals("Alex", paged.getPersonList().get(1).getFirstName());
        assertEquals("Sergey", paged.getPersonList().get(2).getFirstName());
    }
}