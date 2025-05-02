package com.Recursion;

public class TowersOfHanoi {
    public static void main(String[] args) {
        int startPeg = 1; // value 1 used to indicate startPeg in output
        int endPeg = 3; // value 2 used to indicate endPeg in output
        int tempPeg = 2; // value 3 used to indicate tempPeg in output
        int totalDisks = 3; // number of disks

        solveTowers(totalDisks, startPeg, endPeg, tempPeg);

//        solveTower(totalDisks, startPeg, endPeg, tempPeg);
    }

    private static void solveTowers(int disks, int sourcePeg, int destinationPeg, int temPeg) {
        if (disks == 1) {
            System.out.printf("%n%d --> %d", sourcePeg, destinationPeg);
            return;
        }
        //recursion step -- move (disk - 1) disks from sourcePeg
        // to tempPeg using destinationPeg
        solveTowers(disks - 1, sourcePeg, temPeg, destinationPeg);

        // move last disk from sourcePeg to destinationPeg
        System.out.printf("%n%d --> %d", sourcePeg, destinationPeg);

        // move (disks - 1) disks from tempPeg to destinationPeg
        solveTowers(disks - 1, temPeg, destinationPeg, sourcePeg);

    }

    private static void solveTower(int totaldisks, int source, int destination, int tem) {
        if (totaldisks == 1) {
            System.out.printf("%n move disk from %d --> %d", source, destination);
            return;
        }
        solveTower(totaldisks - 1, source, tem, destination);

        System.out.printf("%n move disk from %d --> %d", source, destination);

        solveTower(totaldisks - 1, tem, destination, source);

    }
}
