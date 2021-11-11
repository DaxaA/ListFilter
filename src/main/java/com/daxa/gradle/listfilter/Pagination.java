package com.daxa.gradle.listfilter;

import java.util.List;
import java.util.stream.Collectors;

public class Pagination {
    public static List<Person> paginationList(int number, int page, List<Person> personList) {
        return personList.stream().skip(number * (page - 1)).limit(number).collect(Collectors.toList());
    }
}
