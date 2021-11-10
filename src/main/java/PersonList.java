import java.util.*;

public class PersonList {
    static HashMap<Integer, Person> allPerson;
    private static int count = 0;
    public int id;

    public PersonList() {
        allPerson = new HashMap<>();
    }

    public List<Person> getPersonList() {
        return new ArrayList<>(allPerson.values());
    }
    public void setPersonList(List<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            id = i+1;
            allPerson.put(id, list.get(i));
        }
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
            count++;
            id = count;
            PersonList.allPerson.put(id, person);
        }
    }

    @Override
    public String toString() {
        return allPerson.entrySet().toString();
    }
}
