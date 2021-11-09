import java.util.*;

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
    public List<Person> setPersonList(List<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            allPerson.put(i + 1, list.get(i));
        }
        return new ArrayList<>(allPerson.values());
    }

    static boolean hasPerson(Person obj) {
        for (Person person : allPerson.values()) {
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
