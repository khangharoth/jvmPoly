package com.datastr.linklist;

public class Node<T> {
    private T data;
    private Node linkToNext;

    public Node(T data, Node linkToNext) {
        this.data = data;
        this.linkToNext = linkToNext;
    }

    public Node(T data) {
        this(data, null);
    }

    public T getData() {
        return data;
    }

    public Node getLinkToNext() {
        return linkToNext;
    }
}
