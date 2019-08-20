package com.datastr.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class QuickSort implements SortAlgo {

    public List<Integer> sort(List<Integer> elements) {
        if (elements.size() == 0) {
            return elements;
        }

        Integer pivot = elements.get(0);


        List<Integer> sortedList = new ArrayList<>();
        sortedList.addAll(sort(filter(elements, integer -> integer < pivot)));
        sortedList.addAll(filter(elements, integer -> integer.equals(pivot)));
        sortedList.addAll(sort(filter(elements, integer -> integer > pivot)));
        return sortedList;
    }

    private List<Integer> filter(List<Integer> elements, Predicate<Integer> integerPredicate) {
        return elements.stream()
                .filter(integerPredicate)
                .collect(toList());
    }

}
