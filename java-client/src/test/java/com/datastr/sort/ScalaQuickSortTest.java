package com.datastr.sort;

import com.datastr.ScalaQuickSort;
import net.jqwik.api.*;
import org.jooq.lambda.Seq;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ScalaQuickSortTest {

    @Test
    public void shouldSortTwoElementList() {
        List<Integer> integers = Seq.of(4, 2, 3, 2).toList();
        List<Integer> sortedList = ScalaQuickSort.sortJava(integers);
        assertEquals(sortedList.size(), integers.size());
        assertEquals(sortedList.stream().sorted().collect(Collectors.toList()), sortedList);
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
