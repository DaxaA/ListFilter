import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaginationTest {
    PersonList pagedPerson;
    PersonList personList = new PersonList();
    private static Person p1;
    private static Person p2;
    private static Person p3;
    @BeforeEach
    void setUp() {
        p1 = new Person("A", "A", Gen.female, 2001);
        p2 = new Person("A", "I", Gen.male, 100);
        p3 = new Person("N", "A", Gen.female, 1);
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        pagedPerson = Pagination.paginationList(1, 3, personList);
    }

    @Test
    void truePage() {
        assertEquals(1, pagedPerson.getPersonList().size());
        assertEquals("N", pagedPerson.getPersonList().get(0).getFirstName());
        assertEquals("A", pagedPerson.getPersonList().get(0).getSecondName());
        assertEquals(Gen.female, pagedPerson.getPersonList().get(0).getGender());
        assertEquals(1, pagedPerson.getPersonList().get(0).getYear());
    }
}