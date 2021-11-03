package perspack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PersonList {
    static HashMap<Integer, Person> allPerson;
    private static int count = 0;
    static int number;

    public PersonList() {
        allPerson = new HashMap<>();
    }

    public List<Person> getPersonList() {
        return new ArrayList<>(allPerson.values());
    }

    static boolean hasPerson(Person obj) {
        for (Person person: allPerson.values()) {
            if (person.equals(obj) && person.hashCode() == obj.hashCode()) {
                return true;
            }
        }
        return false;
    }

    public void add(Person person) {
        if (!PersonList.hasPerson(person)) {
            PersonList.count++;
            PersonList.number = PersonList.count;
            PersonList.allPerson.put(PersonList.number, person);
        }
    }


}
