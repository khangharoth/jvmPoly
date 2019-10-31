package com.datastr.highOrderFn;

import clojure.java.api.Clojure;
import clojure.lang.IFn;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.function.Function;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ClojureHighOrderFxnTest {

    @Test
    public void shouldCompose() {
        IFn require = Clojure.var("clojure.core", "require");
        require.invoke(Clojure.read("fx-composition.high"));

        IFn applyTwice = Clojure.var("fx-composition.high", "applyTwice");
        IFn addThree = Clojure.var("fx-composition.high", "addThree");


        Object result = applyTwice.invoke(addThree, 10);

        assertEquals(result, 16L);


    }
}
