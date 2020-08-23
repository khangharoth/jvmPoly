package com.packBin;

import clojure.java.api.Clojure;
import clojure.lang.IFn;
import clojure.lang.Keyword;
import clojure.lang.PersistentArrayMap;
import clojure.lang.PersistentVector;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static clojure.lang.Keyword.find;
import static org.testng.Assert.assertEquals;


public class ClojurePackBinTest {
    @Test
    public void shouldBeAbleToPackBin() {
        IFn require = Clojure.var("clojure.core", "require");
        require.invoke(Clojure.read("com.pack-bin.pack-bin"));


        IFn packbins = Clojure.var("com.pack-bin.pack-bin", "pack-bins");

        List<Map<Keyword, Integer>> bins = bins();
        PersistentArrayMap containers = containers();

        Map<Keyword, Map<Keyword, List<Map<Keyword, Integer>>>> packedContainers = (Map<Keyword, Map<Keyword, List<Map<Keyword, Integer>>>>) packbins.invoke(containers, bins);

        Integer binsCombinedSize = bins.stream()
                .map(map -> map.get(find("size")))
                .reduce(0, Integer::sum);

        Integer packedContainerContentSize = packedContainers.values()
                .stream()
                .map(a -> a.get(find("contents"))
                        .stream()
                        .map(c -> c.get(find("size")))
                        .reduce(0, Integer::sum))
                .reduce(0, Integer::sum);

        assertEquals(packedContainerContentSize, binsCombinedSize);

    }

    private PersistentArrayMap containers() {
        IFn generatecontainers = Clojure.var("com.pack-bin.pack-bin", "generate-containers");
        return (PersistentArrayMap) generatecontainers.invoke(3, 20);
    }

    private PersistentVector bins() {
        IFn generatebins = Clojure.var("com.pack-bin.pack-bin", "generate-bins");
        return (PersistentVector) generatebins.invoke(3, 20);
    }
}
