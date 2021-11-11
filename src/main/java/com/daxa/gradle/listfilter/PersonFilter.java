package com.daxa.gradle.listfilter;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonFilter {
    public static List<Person> personFilter(List<Person> personList, Map<Field, Object> way) {
        List<Predicate<Person>> filters = way.entrySet().stream()
                .map(PersonFilter::mapToFilter)
                .collect(Collectors.toList());
        Predicate<Person> multipleFilter = MultiplePredicate.matchingAll(filters);
        return personList.stream()
                .filter(multipleFilter).collect(Collectors.toList());
    }

    private static Predicate<Person> mapToFilter(Map.Entry<Field, Object> filterMapEntry) {
        return to -> to.getProperty(filterMapEntry.getKey()) == filterMapEntry.getValue();
    }
}
