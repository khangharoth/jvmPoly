package com.datastr.highOrderFn.nthElem;

import org.jooq.lambda.Seq;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class ElementFinderTest {
    private final Iterable<String> letters = Arrays.asList("a", "b", "c", "d", "e");
    private final Seq<String> lettersSeq = Seq.of("a", "b", "c", "d", "e");
    private FunctionCompositionFinder finder = new FunctionCompositionFinder();
    private MethodChainingFinder methodChainingFinder = new MethodChainingFinder();

    @Test
    @Ignore
    public void shouldBeAbleToFindFirst() {
        assertEquals(finder.first(lettersSeq), methodChainingFinder.first(lettersSeq));

        assertEquals(methodChainingFinder.first(lettersSeq), "a");
        assertEquals(finder.first(lettersSeq), "a");
    }

    @Test
    public void shouldBeAbleToFindSecond() {
        assertEquals(finder.second(letters), methodChainingFinder.second(letters));
        assertEquals(finder.second(letters), "b");
    }

    @Test
    public void shouldBeAbleToFindThird() {
        assertEquals(finder.third(letters), methodChainingFinder.third(letters));
        assertEquals(finder.third(letters), "c");
    }

    @Test
    public void shouldBeAbleToFindRest() {
        assertEquals(finder.rest(letters), methodChainingFinder.rest(letters));
    }

    @Test
    public void shouldBeAbleToFindNth() {
        assertEquals(finder.<String>nth(0, letters), "a");
        assertEquals(finder.<String>nth(3, letters), "d");
        assertEquals(finder.<String>nth(4, letters), "e");
    }

}
