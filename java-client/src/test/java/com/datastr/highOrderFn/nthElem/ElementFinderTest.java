package com.datastr.highOrderFn.nthElem;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class ElementFinderTest {
    private final Iterable<String> letters = Arrays.asList("a", "b", "c", "d", "e");
    private NthElementFinder finder = new NthElementFinder();
    private JavaStyleFinder javaStyleFinder = new JavaStyleFinder();

    @Test
    public void shouldBeAbleToFindFirst() {
        assertEquals(finder.first(letters), javaStyleFinder.first(letters));
        assertEquals(finder.first(letters), "a");
    }

    @Test
    public void shouldBeAbleToFindSecond() {
        assertEquals(finder.second(letters), javaStyleFinder.second(letters));
        assertEquals(finder.second(letters), "b");
    }

    @Test
    public void shouldBeAbleToFindThird() {
        assertEquals(finder.third(letters), javaStyleFinder.third(letters));
        assertEquals(finder.third(letters), "c");
    }

    @Test
    public void shouldBeAbleToFindRest() {
        assertEquals(finder.rest(letters), javaStyleFinder.rest(letters));
    }

    @Test
    public void shouldBeAbleToFindNth() {
        assertEquals(finder.<String>nth(0).apply(letters), "a");
        assertEquals(finder.<String>nth(3).apply(letters), "d");
        assertEquals(finder.<String>nth(4).apply(letters), "e");
    }

}
