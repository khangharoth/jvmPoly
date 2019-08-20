package com.datastr.sort;

import java.util.Arrays;
import java.util.List;

public class SelectionSort implements SortAlgo {
    @Override
    public List<Integer> sort(List<Integer> elements) {
        Integer[] numbers = elements.toArray(new Integer[0]);

        for (int i = 0; i < numbers.length; i++) {

            for (int j = i; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    Integer tmp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = tmp;
                }
            }
        }
        return Arrays.asList(numbers);
    }
}
