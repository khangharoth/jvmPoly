package com.datastr.chap2.recursion;

import java.util.Stack;

public class TowerOfHanoi3 {
    public static void main(String[] args) {
        Rod a = new Rod("A");
        a.push(4);
        a.push(3);
        a.push(2);
        a.push(1);

        Rod b = new Rod("B");
        Rod c = new Rod("C");

        move(a.size(), a, c, b);

        printRod(c);
        printRod(b);
        printRod(a);


    }

    private static void move(int n, Rod from, Rod to, Rod via) {
        if (n == 1) {
            push(from, to);
        } else {
            move(n - 1, from, via, to);
            move(1, from, to, via);
            move(n - 1, via, to, from);
        }
    }

    private static void printRod(Rod rod) {
        while (!rod.isEmpty()) {
            System.out.println(String.format("Rod [%s] had disk [%s]", rod.name, rod.pop()));
        }
        System.out.println(String.format("Rod [%s] is empty ", rod.name));
    }

    private static void push(Rod from, Rod to) {
        Integer disk = from.pop();
        if (!to.isEmpty() && to.peek() < disk) {
            throw new RuntimeException(String.format("Can't place bigger disk [%s] on smaller [%s]", disk, to.peek()));
        } else {
            to.push(disk);
        }
    }

}

class Rod {
    String name;
    Stack<Integer> stack = new Stack<>();

    Rod(String name) {
        this.name = name;
    }

    void push(Integer disk) {
        this.stack.push(disk);
    }

    Integer pop() {
        return this.stack.pop();
    }

    boolean isEmpty() {
        return this.stack.isEmpty();
    }

    Integer peek() {
        return this.stack.peek();
    }

    public Integer size() {
        return this.stack.size();
    }


}
