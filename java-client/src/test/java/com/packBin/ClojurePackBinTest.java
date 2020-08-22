package com.packBin;

import clojure.java.api.Clojure;
import clojure.lang.IFn;
import clojure.lang.PersistentArrayMap;
import clojure.lang.PersistentVector;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class ClojurePackBinTest {
    @Test
    public void shouldBeAbleToPackBin() {
        IFn require = Clojure.var("clojure.core", "require");
        require.invoke(Clojure.read("com.pack-bin.pack-bin"));


        IFn packbins = Clojure.var("com.pack-bin.pack-bin", "pack-bins");

        PersistentVector bins = bins();
        PersistentArrayMap containers = containers();

        PersistentArrayMap result = (PersistentArrayMap) packbins.invoke(containers, bins);
        assertEquals(result.size(), 3);
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
