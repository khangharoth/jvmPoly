package com.datastr.linklist;

public class KLinkedList {
    private Node<String> headNode;

    public KLinkedList() {
    }

    public void add(String item) {
        if (headNode == null) {
            this.headNode = new Node<>(item, null);
        } else {
            this.headNode = new Node(item, headNode);
        }

    }

    public void print() {
        System.out.println("");
        printNode(headNode);
    }

    private void printNode(Node<String> node) {
        if (node != null) {
            System.out.print(node.getData());
            System.out.print(" ");
            printNode(node.getLinkToNext());
        }
    }

    public void remove() {
        if (headNode != null) {
            headNode = headNode.getLinkToNext();
        }
    }
}
