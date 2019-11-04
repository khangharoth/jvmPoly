package com.datastr.highOrderFn.nthElem;

import org.jooq.lambda.Seq;

public class MethodChainingFinder implements ElementFinder {

    @Override
    public <T> T first(Seq<T> items) {
        return items.iterator().next();
    }

    public <T> T second(Seq<T> items) {
        return this.first(this.rest(items));
    }

    public <T> T third(Seq<T> items) {
        return this.first(this.rest(this.rest(items)));
    }

    public <T> T nth(int n, Seq<T> items) {
        return null;
    }

    public <T> Seq<T> rest(Seq<T> items) {
        return items.splitAtHead().v2;
    }

}
