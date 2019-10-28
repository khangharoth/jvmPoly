package com.datastr.sort;

import clojure.java.api.Clojure;
import clojure.lang.IFn;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.function.Function;

public class ClojureHighOrderFxnTest {

    @Test
    @Ignore
    public void should() {
        IFn require = Clojure.var("clojure.core", "require");
        require.invoke(Clojure.read("fx-composition.high"));

        IFn applyTwice = Clojure.var("fx-composition.high", "applyTwice");


        Object result = applyTwice.invoke((Function<Integer, Integer>) number -> number + 3, 10);


    }
}
