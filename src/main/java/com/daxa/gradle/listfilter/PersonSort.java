package com.daxa.gradle.listfilter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonSort {

    private static final Map<Field, Comparator<Person>> COMPARATOR_MAP = Map.of(
            Field.FIRSTNAME, Comparator.comparing(Person::getFirstName),
            Field.SECONDNAME, Comparator.comparing(Person::getSecondName),
            Field.GENDER, Comparator.comparing(Person::getGender),
            Field.YEAR, Comparator.comparing(Person::getYear)
    );

    public static List<Person> personSort(List<Person> personList, Map<Field, Ord> way) {
        Stream<Person> personStream = personList.stream();
        List<Person> sorted = new ArrayList<>();
        for (Map.Entry<Field, Ord> sortWay: way.entrySet()) {
            sorted = personStream.sorted(getComparator(sortWay.getKey(), sortWay.getValue()))
                    .collect(Collectors.toList());
        }
        return sorted;
    }

    private static Comparator<Person> getComparator(Field field, Ord way) {
        Comparator<Person> comparator = COMPARATOR_MAP.get(field);

        if(Ord.DESCENDING.equals(way)) {
            comparator = comparator.reversed();
        }

        return comparator;
    }

    /*
    @Deprecated
    private static List<com.daxa.gradle.listfilter.Person> ascendingSort(com.daxa.gradle.listfilter.Field field, Stream<com.daxa.gradle.listfilter.Person> personStream) {
        if (field == com.daxa.gradle.listfilter.Field.FIRSTNAME) {
            return personStream.sorted(Comparator.comparing(com.daxa.gradle.listfilter.Person::getFirstName)).collect(Collectors.toList());
        } else if (field == com.daxa.gradle.listfilter.Field.SECONDNAME) {
            return personStream.sorted(Comparator.comparing(com.daxa.gradle.listfilter.Person::getSecondName)).collect(Collectors.toList());
        } else if (field == com.daxa.gradle.listfilter.Field.GENDER) {
            return personStream.sorted(Comparator.comparing(com.daxa.gradle.listfilter.Person::getGender)).collect(Collectors.toList());
        } else {
            return personStream.sorted(Comparator.comparing(com.daxa.gradle.listfilter.Person::getYear)).collect(Collectors.toList());
        }
    }

    @Deprecated
    private static List<com.daxa.gradle.listfilter.Person> descendingSort(com.daxa.gradle.listfilter.Field field, Stream<com.daxa.gradle.listfilter.Person> personStream) {
        if (field == com.daxa.gradle.listfilter.Field.FIRSTNAME) {
            return personStream.sorted(Comparator.comparing(com.daxa.gradle.listfilter.Person::getFirstName).reversed()).collect(Collectors.toList());
        } else if (field == com.daxa.gradle.listfilter.Field.SECONDNAME) {
            return personStream.sorted(Comparator.comparing(com.daxa.gradle.listfilter.Person::getSecondName).reversed()).collect(Collectors.toList());
        } else if (field == com.daxa.gradle.listfilter.Field.GENDER) {
            return personStream.sorted(Comparator.comparing(com.daxa.gradle.listfilter.Person::getGender).reversed()).collect(Collectors.toList());
        } else {
            return personStream.sorted(Comparator.comparing(com.daxa.gradle.listfilter.Person::getYear).reversed()).collect(Collectors.toList());
        }
    }
    */
}
