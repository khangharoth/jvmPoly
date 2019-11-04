package com.datastr.highOrderFn.nthElem;

import org.jooq.lambda.Seq;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.jooq.lambda.Seq.seq;
import static org.testng.Assert.assertEquals;

public class ElementFinderTest {
    private FunctionCompositionFinder finder = new FunctionCompositionFinder();
    private MethodChainingFinder methodChainingFinder = new MethodChainingFinder();

    private Seq<String> lettersSeq() {
        return seq(Arrays.asList("a", "b", "c", "d", "e"));
    }

    @Test
    public void shouldBeAbleToFindFirst() {
        assertEquals(finder.first(lettersSeq()), methodChainingFinder.first(lettersSeq()));

        assertEquals(methodChainingFinder.first(lettersSeq()), "a");
        assertEquals(finder.first(lettersSeq()), "a");
    }

    @Test
    public void shouldBeAbleToFindSecond() {
        assertEquals(finder.second(lettersSeq()), methodChainingFinder.second(lettersSeq()));
        assertEquals(finder.second(lettersSeq()), "b");
    }

    @Test
    public void shouldBeAbleToFindThird() {
        assertEquals(finder.third(lettersSeq()), methodChainingFinder.third(lettersSeq()));
        assertEquals(finder.third(lettersSeq()), "c");
    }

    @Test
    public void shouldBeAbleToFindRest() {
        assertEquals(finder.rest(lettersSeq()), methodChainingFinder.rest(lettersSeq()));
    }

    @Test
    public void shouldBeAbleToFindNth() {
        assertEquals(finder.<String>nth(0, lettersSeq()), "a");
        assertEquals(finder.<String>nth(3, lettersSeq()), "d");
        assertEquals(finder.<String>nth(4, lettersSeq()), "e");
    }

}
