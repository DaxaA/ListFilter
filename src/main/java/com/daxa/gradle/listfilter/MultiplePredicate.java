package com.daxa.gradle.listfilter;

import java.util.List;
import java.util.function.Predicate;

public class MultiplePredicate {
    public static <T> Predicate<T> matchingAll(List<Predicate<T>> predicates) {
        Predicate<T> multiPredicate = predicates.get(0);
        for (int i = 1; i < predicates.size(); i++) {
            multiPredicate = multiPredicate.and(predicates.get(i));
        }
        return multiPredicate;
    }
}
