package com.datastr.chap2.recursion;

public class TowerOfHanoi2 {

    public static void main(String[] args) {
        move(2, "A", "C", "B");
    }

    public static void move(int n, String from, String to, String via) {
        if (n == 1) {
            System.out.println("Move disk from pole " + from + " to pole " + to);
        } else {
            move(n - 1, from, via, to);
            move(1, from, to, via);
            move(n - 1, via, to, from);
        }
    }
}
