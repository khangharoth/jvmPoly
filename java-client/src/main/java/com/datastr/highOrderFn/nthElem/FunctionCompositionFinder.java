package com.datastr.highOrderFn.nthElem;

import org.jooq.lambda.Seq;

import java.util.function.Function;
import java.util.stream.IntStream;

public class FunctionCompositionFinder implements ElementFinder {
    @Override
    public <T> T first(Seq<T> items) {
        return items.iterator().next();
    }

    public <T> T second(Seq<T> items) {
        return this.<T>firstFunction()
                .compose(this.restFunction())
                .apply(items);
    }

    public <T> T third(Seq<T> items) {
        return this.<T>firstFunction()
                .compose(this.restFunction())
                .compose(this.restFunction())
                .apply(items);
    }

    @Override
    public <T> T nth(int n, Seq<T> items) {
        return this.<T>nth(n).apply(items);
    }


    public <T> Seq<T> rest(Seq<T> items) {
        return this.<T>restFunction().apply(items);
    }

    private <T> Function<Seq<T>, T> firstFunction() {
        return e -> e.iterator().next();
    }

    private <T> Function<Seq<T>, Seq<T>> restFunction() {
        return e -> e.splitAtHead().v2;
    }

    private <T> Function<Seq<T>, T> nth(int n) {
        Function<Seq<T>, T> baseFn = this.firstFunction();

        return IntStream.range(0, n)
                .boxed()
                .reduce(baseFn, (listTFunction, o) -> listTFunction.compose(this.restFunction()),
                        (listTFunction, listTFunction2) -> listTFunction.compose(this.restFunction()));
    }
}
