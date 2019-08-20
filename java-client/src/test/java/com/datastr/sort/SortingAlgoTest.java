package com.datastr.sort;

import net.jqwik.api.*;
import org.jooq.lambda.Seq;
import org.testng.annotations.Test;


import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;

public class SortingAlgoTest {

    @Test
    public void shouldSortSimpleCase() {
        List<Integer> randomList = Seq.of(3, 0, -1).toList();
        List<Integer> sortedList = new SelectionSort().sort(randomList);
        assertEquals(sortedList.size(), randomList.size());
        assertEquals(sortedList, randomList.stream().sorted().collect(Collectors.toList()));
    }

    @Property(shrinking = ShrinkingMode.FULL)
    public void shouldBeAbleToSortByQuickSort(@ForAll("integerLists") List<Integer> randomList) {
        List<Integer> sortedList = new QuickSort().sort(randomList);
        assertEquals(sortedList.size(), randomList.size());
        assertEquals(sortedList, randomList.stream().sorted().collect(Collectors.toList()));
    }

    @Property(shrinking = ShrinkingMode.FULL)
    public void shouldBeAbleToSortBySelectionSort(@ForAll("integerLists") List<Integer> randomList) {
        List<Integer> sortedList = new SelectionSort().sort(randomList);
        assertEquals(sortedList.size(), randomList.size());
        assertEquals(sortedList, randomList.stream().sorted().collect(Collectors.toList()));
    }

    @Provide
    Arbitrary<List> integerLists() {
        return Arbitraries.defaultFor(List.class, Integer.class);
    }

}
