package com.datastr.stack;

import java.util.LinkedList;

public class KStack {
    private LinkedList<String> linkedList;

    public KStack() {
        this.linkedList = new LinkedList<>();
    }

    public boolean push(String item) {
        return this.linkedList.add(item);
    }

    public String pop() {
        return this.linkedList.removeLast();
    }
}
