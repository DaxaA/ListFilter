import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonFilter {
    public static PersonList personFilter(PersonList personList, Map<Field, Object> way) {
        List<Predicate<Person>> filters = way.entrySet().stream()
                .map(PersonFilter::mapToFilter)
                .collect(Collectors.toList());
        Predicate<Person> multipleFilter = MultiplePredicate.matchingAll(filters);
        List<Person> filtered = personList.getPersonList().stream()
                .filter(multipleFilter).collect(Collectors.toList());
        PersonList filteredPerson = new PersonList();
        filteredPerson.setPersonList(filtered);
        //System.out.println(filteredPerson);
        return filteredPerson;
    }

    private static Predicate<Person> mapToFilter(Map.Entry<Field, Object> filterMapEntry) {
        return to -> to.getProperty(filterMapEntry.getKey()) == filterMapEntry.getValue();
    }
}
