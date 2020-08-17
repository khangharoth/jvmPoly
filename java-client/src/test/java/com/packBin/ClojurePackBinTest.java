package com.packBin;

import clojure.java.api.Clojure;
import clojure.lang.IFn;
import org.testng.annotations.Test;

public class ClojurePackBinTest {
    @Test
    public void shouldBeAbleToPackBin() {
        IFn require = Clojure.var("clojure.core", "require");
        require.invoke(Clojure.read("com.pack-bin.pack-bin"));

        IFn packBins = Clojure.var("com.pack-bin.pack-bin", "pack-bins");

    }
}
