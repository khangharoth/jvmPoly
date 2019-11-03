package com.datastr.highOrderFn.nthElem;

import org.jooq.lambda.Seq;

public interface ElementFinder {
    <T> T first(Iterable<T> items);

    <T> T first(Seq<T> items);

    <T> T second(Iterable<T> items);

    <T> T third(Iterable<T> items);

    <T> T nth(int n, Iterable<T> items);

    <T> Iterable<T> rest(Iterable<T> items);


}
