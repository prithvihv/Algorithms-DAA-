package com.company;

import java.util.Scanner;
public class Main {
    static int MAX = 100;
    static final int infinity = 999;
    public static void main(String args[]) {
        int cost = infinity;
        int c[][] = new int[MAX][MAX]; // cost matrix
        int tour[] = new int[MAX]; // optimal tour
        int n; // max. cities
        System.out.println("Travelling Salesman Problem using Dynamic Programming\n");
        System.out.println("Enter number of cities: ");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        System.out.println("Enter Cost matrix:\n");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                c[i][j] = scanner.nextInt();
                if (c[i][j] == 0)
                    c[i][j] = 999;
            }
        for (int i = 0; i < n; i++)
            tour[i] = i;
        cost = tspdp(c, tour, 0, n);
        // print tour cost and tour
        System.out.println("Minimum Tour Cost: " + cost);
        System.out.println("\nTour:");
        for (int i = 0; i < n; i++) {
            System.out.print(tour[i] + " -> ");
        }
        System.out.println(tour[0] + "\n");
        scanner.close();
    }
    static int tspdp(int c[][], int tour[], int start, int n) {
        int i, j, k;
        int temp[] = new int[MAX];
        int mintour[] = new int[MAX];
        int mincost;
        int cost;
        //case where there are 3 nodes only 1 path is possible?
        if (start == n - 2)
            return c[tour[n - 2]][tour[n - 1]] + c[tour[n - 1]][0];
        mincost = infinity;
        for (i = start + 1; i < n; i++) {
            //copy current tour to temp
            for (j = 0; j < n; j++)
                temp[j] = tour[j];
            //make the next node various i values then make it
            temp[start + 1] = tour[i];
            temp[i] = tour[start + 1];//temp of start+1 and i have the same value(tour[i]) why?
            
            if (c[tour[start]][tour[i]] + (cost = tspdp(c, temp, start + 1, n)) < mincost) {
                mincost = c[tour[start]][tour[i]] + cost;
                for (k = 0; k < n; k++)
                    mintour[k] = temp[k];
            }
        }
        for (i = 0; i < n; i++)
            tour[i] = mintour[i];
        return mincost;
    }
}
/* Input matrix
0 10 15 20
5 0  9  10
6 13 0 12
8 8 9 0
*/