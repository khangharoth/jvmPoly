package com.datastr.sort;

import net.jqwik.api.*;
import org.jooq.lambda.Seq;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;

public class ScalaSortClientTest {

    @Test
    public void shouldSortFourElementList() {
        List<Integer> randomList = Seq.of(4, 2, 3, 2).toList();
        List<Integer> sortedList = ScalaSelectionSort.sortJava(randomList);
        assertEquals(sortedList.size(), randomList.size());
        assertEquals(sortedList, sortedList.stream().sorted().collect(Collectors.toList()));
    }

    @Property(shrinking = ShrinkingMode.FULL)
    public void byQuickSort(@ForAll("integerLists") List<Integer> randomList) {
        List<Integer> sortedList = ScalaQuickSort.sortJava(randomList);
        assertEquals(sortedList.size(), randomList.size());
        assertEquals(sortedList, randomList.stream().sorted().collect(Collectors.toList()));
    }

    @Property(shrinking = ShrinkingMode.FULL)
    public void bySelectionSort(@ForAll("integerLists") List<Integer> randomList) {
        List<Integer> sortedList = ScalaSelectionSort.sortJava(randomList);
        assertEquals(sortedList.size(), randomList.size());
        assertEquals(sortedList, randomList.stream().sorted().collect(Collectors.toList()));
    }

    @Provide
    Arbitrary<List> integerLists() {
        return Arbitraries.defaultFor(List.class, Integer.class);
    }

}
