package com.company;

import java.util.Scanner;

public class zerooneknapsack {


    private static Scanner scanner=new Scanner(System.in);

    private static int[] read(int n)
    {
        int[] arr=new int[n];
        for (int i=0;i<n;i++)
        {
            arr[i]=scanner.nextInt();
        }
        return arr;
    }

    private static int max(int a,int b)
    {
        int h=0;
        if (a>b)
        {
            h=a;
        }
        else {
            h=b;
        }
        return h;
    }

    public static void main(String[] args) {
        System.out.println("enter the value of t");
        int t = scanner.nextInt();
        for (int k = 0; k < t; k++) {
            System.out.println("enter the number of items");
            int n = scanner.nextInt();
            System.out.println("enter the capacity");
            int cap = scanner.nextInt();
            System.out.println("enter the values for " + n + " items");
            int[] val = read(n);
            System.out.println("enter the weights for " + n + " items");
            int[] wt = read(n);


            // here comes the code for 0/1 knapsack using dynamic programming

            int[][] arr = new int[n][cap + 1];  //2D array

            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= cap; j++) {
                    int u = wt[i];
                    int h = j - wt[i];
                    if (h >= 0) {
                        if (i == 0) {
                            arr[i][j] = val[i];
                            continue;
                        }
                        int op1 = val[i] + arr[i - 1][j - u];
                        int op2 = arr[i - 1][j];
                        arr[i][j] = max(op1, op2);
                    } else if (h < 0) {
                        if (i == 0) {
                            arr[i][j] = 0;
                            continue;
                        }
                        arr[i][j] = arr[i - 1][j];
                    }
                }
            }
            System.out.println("max value of that can be generated" +
                    " from the given items for the available knapsack=" + arr[n - 1][cap]);
        }
    }
}
