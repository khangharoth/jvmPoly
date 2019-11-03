package com.datastr.highOrderFn.nthElem;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.IntStream;

public class FunctionCompositionFinder implements ElementFinder {
    public <T> T first(Iterable<T> items) {
        return this.<T>firstFunction()
                .apply(items);
    }

    public <T> T second(Iterable<T> items) {
        return this.<T>firstFunction()
                .compose(this.rest())
                .apply(items);
    }

    public <T> T third(Iterable<T> items) {
        return this.<T>firstFunction()
                .compose(this.rest())
                .compose(this.rest())
                .apply(items);
    }

    @Override
    public <T> T nth(int n, Iterable<T> items) {
        return this.<T>nth(n).apply(items);
    }


    public <T> Iterable<T> rest(Iterable<T> items) {
        return this.<T>rest().apply(items);
    }

    private <T> Function<Iterable<T>, T> firstFunction() {
        return e -> e.iterator().next();
    }

    private <T> Function<Iterable<T>, Iterable<T>> rest() {
        return e -> {
            ArrayList<T> list = Lists.newArrayList(e);
            return list.subList(1, list.size());
        };
    }

    private <T> Function<Iterable<T>, T> nth(int n) {
        Function<Iterable<T>, T> baseFn = this.firstFunction();

        return IntStream.range(0, n)
                .boxed()
                .reduce(baseFn, (listTFunction, o) -> listTFunction.compose(this.rest()),
                        (listTFunction, listTFunction2) -> listTFunction.compose(this.rest()));
    }
}
