package com.datastr.chap2.recursion;

import java.util.Stack;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Rod a = new Rod("A");
        a.push(6);
        a.push(5);
        a.push(4);
        a.push(3);
        a.push(2);
        a.push(1);

        Rod b = new Rod("B");
        Rod c = new Rod("C");


        moveTop6(a, b, c);


        printRod(c);
        printRod(b);
        printRod(a);


    }

    private static void moveTop6(Rod initial, Rod target, Rod aux) {
        moveTop5(initial, target, aux);
        push(initial, aux);
        moveTop5(target, aux, initial);
    }

    private static void moveTop5(Rod initial, Rod target, Rod aux) {
        moveTop4(initial, aux, target);
        push(initial, target);
        moveTop4(aux, target, initial);
    }

    private static void moveTop4(Rod initial, Rod target, Rod aux) {
        moveTop3DiskFromInitialToTarget(initial, aux, target);
        push(initial, target);
        moveTop3DiskFromInitialToTarget(aux, target, initial);
    }

    private static void moveTop3DiskFromInitialToTarget(Rod initial, Rod target, Rod aux) {
        push(initial, target);
        push(initial, aux);
        push(target, aux);

        push(initial, target);
        push(aux, initial);
        push(aux, target);
        push(initial, target);
    }

    private static void printRod(Rod rod) {
        while (!rod.isEmpty()) {
            System.out.println(String.format("Rod [%s] had disk [%s]", rod.name, rod.pop()));
        }
        System.out.println(String.format("Rod [%s] is empty ", rod.name));
    }

    private static void push(Rod initial, Rod target) {
        Integer disk = initial.pop();
        if (!target.isEmpty() && target.peek() < disk) {
            throw new RuntimeException(String.format("Can't place bigger disk [%s] on smaller [%s]", disk, target.peek()));
        } else {
            target.push(disk);
        }
    }

    static class Rod {
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


}
