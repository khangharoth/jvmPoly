package com.datastr.recursion.towerOfHanoi;

import java.util.Stack;

import static java.lang.String.format;

public class TowerOfHanoi {


    public static void main(String[] args) {
        Stack<Integer> towerA = new Stack<>();
        Stack<Integer> towerB = new Stack<>();
        Stack<Integer> towerC = new Stack<>();

        putADisk(towerA, 5);
        putADisk(towerA, 4);
        putADisk(towerA, 3);
        putADisk(towerA, 2);
        putADisk(towerA, 1);

        moveNDiskFromSourceToDestination(towerA, towerB, towerC);
        putADisk(towerC, towerA.pop());
        moveNDiskFromSourceToDestination(towerB, towerC, towerA);

        while (!towerC.empty()) {
            System.out.println("Disk on Tower C : " + towerC.pop());
        }

    }


    private static void moveNDiskFromSourceToDestination(Stack source, Stack destination, Stack aux) {
        moveN1DiskToAux(source, destination, aux);
        moveNDiskToDestination(source, destination);
        moveN1DiskToDestination(source, destination, aux);

    }

    private static void moveN1DiskToDestination(Stack source, Stack destination, Stack aux) {
        putADisk(source, (int) aux.pop());
        putADisk(destination, (int) aux.pop());
        putADisk(destination, (int) source.pop());
    }

    private static void moveNDiskToDestination(Stack source, Stack destination) {
        putADisk(destination, (int) source.pop());
    }

    private static void moveN1DiskToAux(Stack source, Stack destination, Stack aux) {
        putADisk(destination, (int) source.pop());
        putADisk(aux, (int) source.pop());
        putADisk(aux, (int) destination.pop());
    }

    private static void putADisk(Stack stack, int disk) {
        if (stack.empty() || (int) stack.peek() > disk) {
            stack.push(disk);

        } else {
            throw new RuntimeException(format("wrong Disk %s", disk));
        }

    }
}
