package com.datastr.sort;

import clojure.java.api.Clojure;
import clojure.lang.IFn;
import clojure.lang.LazySeq;
import org.jooq.lambda.Seq;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ClojureQuickSortTest {
    @Test
    public void shouldSortFourElementList() {
        IFn require = Clojure.var("clojure.core", "require");
        require.invoke(Clojure.read("data-str.quick-sort"));

        IFn quickSort = Clojure.var("data-str.quick-sort", "quick-sort");


        List<Integer> integers = Seq.of(4, 2, 3, 2).toList();

        LazySeq sortedSeq = (LazySeq) quickSort.invoke(integers);
        assertEquals(sortedSeq.size(), integers.size());

        assertTrue(sortedSeq.stream().sorted().collect(Collectors.toList()).equals(sortedSeq));
    }
}
