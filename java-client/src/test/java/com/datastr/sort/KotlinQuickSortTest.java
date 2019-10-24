package com.datastr.sort;

import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.internal.collections.Ints.asList;

public class KotlinQuickSortTest {

    @Test
    public void shouldSort() {
        List<Integer> randomList = asList(6, 8, 4, 1, 3, 8, 10);
        List<Integer> sortedList = QuickSortKt.quickSort(randomList);
        assertEquals(sortedList, randomList.stream().sorted().collect(Collectors.toList()));
    }

}
