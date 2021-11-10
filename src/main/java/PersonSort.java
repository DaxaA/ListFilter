import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonSort {
    public static PersonList personSort(PersonList personList, Map<Field, Ord> way) {
        Stream<Person> personStream = personList.getPersonList().stream();
        List<Person> sorted = new ArrayList<>();
        for (Map.Entry<Field, Ord> sortWay: way.entrySet()) {
            if (sortWay.getValue() == Ord.ascending) {
                sorted = ascendingSort(sortWay.getKey(), personStream);
            } else {
                sorted = descendingSort(sortWay.getKey(), personStream);
            }
        }
        PersonList sortedList = new PersonList();
        sortedList.setPersonList(sorted);
        //System.out.println(sortedList);
        return sortedList;
    }

    private static List<Person> ascendingSort(Field field, Stream<Person> personStream) {
        if (field == Field.firstname) {
            return personStream.sorted(Comparator.comparing(Person::getFirstName)).collect(Collectors.toList());
        } else if (field == Field.secondname) {
            return personStream.sorted(Comparator.comparing(Person::getSecondName)).collect(Collectors.toList());
        } else if (field == Field.gender) {
            return personStream.sorted(Comparator.comparing(Person::getGender)).collect(Collectors.toList());
        } else {
            return personStream.sorted(Comparator.comparing(Person::getYear)).collect(Collectors.toList());
        }
    }
    private static List<Person> descendingSort(Field field, Stream<Person> personStream) {
        if (field == Field.firstname) {
            return personStream.sorted(Comparator.comparing(Person::getFirstName).reversed()).collect(Collectors.toList());
        } else if (field == Field.secondname) {
            return personStream.sorted(Comparator.comparing(Person::getSecondName).reversed()).collect(Collectors.toList());
        } else if (field == Field.gender) {
            return personStream.sorted(Comparator.comparing(Person::getGender).reversed()).collect(Collectors.toList());
        } else {
            return personStream.sorted(Comparator.comparing(Person::getYear).reversed()).collect(Collectors.toList());
        }
    }
}
