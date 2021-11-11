import com.daxa.gradle.listfilter.Gen;
import com.daxa.gradle.listfilter.Pagination;
import com.daxa.gradle.listfilter.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PaginationTest {
    List<Person> paged;
    List<Person> personList = new ArrayList<>();

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
    }

    @Test
    void truePage() {
        paged = Pagination.paginationList(3, 2, personList);
        assertEquals(3, paged.size());
        assertEquals("Dasha", paged.get(0).getFirstName());
        assertEquals("Alex", paged.get(1).getFirstName());
        assertEquals("Sergey", paged.get(2).getFirstName());
    }
}