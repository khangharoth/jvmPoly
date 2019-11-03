package com.datastr.highOrderFn.nthElem;

import com.google.common.collect.Lists;

import java.util.ArrayList;

public class MethodChainingFinder implements ElementFinder {

    public <T> T first(Iterable<T> items) {
        return items.iterator().next();
    }

    public <T> T second(Iterable<T> items) {
        return this.first(this.rest(items));
    }

    public <T> T third(Iterable<T> items) {
        return this.first(this.rest(this.rest(items)));
    }

    public <T> T nth(int n, Iterable<T> items) {
        return null;
    }

    public <T> Iterable<T> rest(Iterable<T> items) {
        ArrayList<T> list = Lists.newArrayList(items);
        return list.subList(1, list.size());
    }

}
