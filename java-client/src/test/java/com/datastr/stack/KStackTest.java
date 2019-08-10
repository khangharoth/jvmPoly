package com.datastr.stack;

import org.testng.annotations.Test;

public class KStackTest {
    @Test
    public void simpleStackTest() {
        KStack stack = new KStack();
        stack.push("Hello");
        stack.push("World");
        stack.push("Kuldeep");


        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
