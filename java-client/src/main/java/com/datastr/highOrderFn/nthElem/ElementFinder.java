package com.datastr.highOrderFn.nthElem;

import org.jooq.lambda.Seq;

public interface ElementFinder {

    <T> T first(Seq<T> items);

    <T> T second(Seq<T> items);

    <T> T third(Seq<T> items);

    <T> T nth(int n, Seq<T> items);

    <T> Seq<T> rest(Seq<T> items);


}
