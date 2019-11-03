package com.datastr.highOrderFn.nthElem;

public interface ElementFinder {
    <T> T first(Iterable<T> items);

    <T> T second(Iterable<T> items);

    <T> T third(Iterable<T> items);

    <T> Iterable<T> rest(Iterable<T> items);


}
