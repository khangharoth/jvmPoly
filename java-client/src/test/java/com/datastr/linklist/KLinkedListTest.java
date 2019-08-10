package com.datastr.linklist;

import org.testng.annotations.Test;

public class KLinkedListTest {

    @Test
    public void simpleLinkTest() {

        KLinkedList list = new KLinkedList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.print();

        list.remove();
        list.remove();
        list.remove();

        list.print();
    }
}
