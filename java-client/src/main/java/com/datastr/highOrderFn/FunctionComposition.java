package com.datastr.highOrderFn;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

public class FunctionComposition {
    public static void main(String[] args) {
        List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
        System.out.println(FunctionComposition.<String>first2().apply(letters));
        System.out.println(FunctionComposition.<String>rest2().apply(letters));
        System.out.println(FunctionComposition.<String>second2().apply(letters));
        System.out.println(FunctionComposition.<String>third2().apply(letters));
        System.out.println(FunctionComposition.<String>nth2(4).apply(letters));
        System.out.println(FunctionComposition.<String>nth2(3).apply(letters));
    }

    private static <T> Function<List<T>, T> nth2(int n) {
        Function<List<T>, T> baseFn = FunctionComposition.first2();

        return IntStream.range(0, n)
                .boxed()
                .reduce(baseFn, (listTFunction, o) -> listTFunction.compose(rest2()),
                        (listTFunction, listTFunction2) -> listTFunction.compose(rest2()));
    }

    private static <T> T third(List<T> items) {
        return first(rest(rest(items)));
    }

    private static <T> Function<List<T>, T> third2() {
        return FunctionComposition.<T>first2().compose(rest2()).compose(rest2());
    }


    private static <T> T second(List<T> items) {
        return first(rest(items));
    }

    private static <T> Function<List<T>, T> second2() {
        return FunctionComposition.<T>first2().compose(rest2());
    }

    private static <T> T first(List<T> items) {
        return items.iterator().next();
    }

    private static <T> List<T> rest(List<T> items) {
        return items.subList(1, items.size());
    }

    private static <T> Function<List<T>, T> first2() {
        return e -> e.get(0);
    }

    private static <T> Function<List<T>, List<T>> rest2() {
        return e -> e.subList(1, e.size());
    }
}
