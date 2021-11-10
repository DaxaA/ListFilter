import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pagination {
    public static PersonList paginationList(int number, int page, PersonList personList) {
        List<Person> paged = personList.getPersonList().stream()
                .skip(number * (page - 1)).limit(number).collect(Collectors.toList());
        PersonList paginatedPerson = new PersonList();
        paginatedPerson.setPersonList(paged);
        System.out.println(paginatedPerson);
        return paginatedPerson;
    }
}
