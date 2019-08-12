package com.datastr.sort;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class QuickSort {

    public List<Integer> sort(List<Integer> elements) {
        if (elements.size() == 0) {
            return elements;
        }

        Integer pivot = elements.get(0);

        List<Integer> lesser = elements.stream()
                .filter(integer -> integer < pivot)
                .collect(toList());

        List<Integer> higher = elements.stream()
                .filter(integer -> integer > pivot)
                .collect(toList());

        List<Integer> sortedList = new ArrayList<>();
        sortedList.addAll(sort(lesser));
        sortedList.add(pivot);
        sortedList.addAll(sort(higher));
        return sortedList;
    }
}
