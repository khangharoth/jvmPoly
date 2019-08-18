package com.datastr.sort;

import clojure.java.api.Clojure;
import clojure.lang.IFn;
import org.jooq.lambda.Seq;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ClojureQuickSortTest {
    @Test
    public void shouldCallClojureCode() {
        IFn require = Clojure.var("clojure.core", "require");
        require.invoke(Clojure.read("data-str.quick-sort"));

        IFn plus = Clojure.var("data-str.quick-sort", "quick-sort");


        List<Integer> integers = Seq.of(4, 2, 3, 2).toList();

        System.out.println(plus.invoke(integers));
    }
}
