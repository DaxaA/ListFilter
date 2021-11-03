import perspack.Person;
import perspack.PersonList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortedPerson {
    private static List<Person> sortedPersonList;
    private static List<SortInfo> sortInfoList;

    public SortedPerson(ArrayList<SortInfo> sortByInfo) {
        sortedPersonList = new ArrayList<Person>();
        sortInfoList = sortByInfo;
    }

    public static List<Person> getSortedPersonList() {
        return sortedPersonList;
    }

    public SortedPerson sortBySmth(PersonList personList, ArrayList<SortInfo> sortInfo) {
        sortedPersonList = personList.getPersonList().stream().sorted(
                Comparator.comparing(Person::getFirstName)
                        .thenComparing(Person::getYear)).collect(Collectors.toList());

    }
}
