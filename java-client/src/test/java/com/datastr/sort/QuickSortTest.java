package com.datastr.sort;

import net.jqwik.api.*;
import org.jooq.lambda.Seq;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertTrue;

public class QuickSortTest {
    @Test
    public void shouldSortFourElementList() throws Exception {
        List<Integer> integers = Seq.of(4, 2, 3, 2).toList();
        List<Integer> sortedList = new QuickSort().sort(integers);
        assertTrue(sortedList.size() == integers.size());
        assertTrue(sortedList.stream().sorted().collect(Collectors.toList()).equals(sortedList));
    }

    @Property(shrinking = ShrinkingMode.FULL)
    public void shouldBeAbleToSortGivenList(@ForAll("integerLists") List<Integer> randomList) throws Exception {
        System.out.println(randomList);
        List<Integer> sortedList = new QuickSort().sort(randomList);
        assertTrue(sortedList.size() == randomList.size());
        assertTrue(sortedList.stream().sorted().collect(Collectors.toList()).equals(sortedList));
    }

    @Provide
    Arbitrary<List> integerLists() {
        return Arbitraries.defaultFor(List.class, Integer.class);
    }

}
