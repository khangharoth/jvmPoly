package com.datastr.sort;

import net.jqwik.api.*;
import org.jooq.lambda.Seq;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class QuickSortTest {

    @Property(shrinking = ShrinkingMode.FULL)
    public void shouldBeAbleToSortByQuickSort(@ForAll("integerLists") List<Integer> randomList) {
        List<Integer> sortedList = new QuickSort().sort(randomList);
        assertEquals(sortedList.size(), randomList.size());
        assertEquals(sortedList, randomList.stream().sorted().collect(Collectors.toList()));
    }

    @Property(shrinking = ShrinkingMode.FULL)
    @Disabled
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
