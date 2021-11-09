import java.security.KeyStore;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonFilter {
    public Map<Field, String> way = new HashMap<>();

    public PersonFilter(Map<Field, String> way2) {
        this.way.putAll(way2);
    }

    public List<Person> personFilter(PersonList personList) {
        List<Predicate<Person>> filters = way.entrySet().stream()
                .map(this::mapToFilter)
                .collect(Collectors.toList());
        Predicate<Person> multipleFilter = MultiplePredicate.matchingAll(filters);
        List<Person> filtered = personList.getPersonList().stream()
                .filter(multipleFilter).collect(Collectors.toList());
        System.out.println(filtered);
        return filtered;
    }

    private Predicate<Person> mapToFilter(Map.Entry<Field, String> filterMapEntry) {
        return to -> to.getProperty(filterMapEntry.getKey()) == filterMapEntry.getValue();
    }
}
