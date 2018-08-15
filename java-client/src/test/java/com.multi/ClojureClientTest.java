package com.multi;

import clojure.java.api.Clojure;
import clojure.lang.IFn;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ClojureClientTest {

    @Test
    public void shouldCallClojureCode() {
        IFn require = Clojure.var("clojure.core", "require");
        require.invoke(Clojure.read("clojure-core.core"));

        IFn plus = Clojure.var("clojure-core.core", "sum");


        assertEquals(plus.invoke(3, 2), new Long(5));
    }
}
