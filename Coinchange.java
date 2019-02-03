package com.company;

import java.util.Scanner;

public class Coinchange {
    private static Scanner scanner=new Scanner(System.in);
    private static void write(int[][] arr,int n,int m)
    {
        for (int i=0;i<m;i++)
        {
            for (int j=0;j<=n;j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
    public static void main(String[] args) {
        System.out.println("enter the value of t");
        int t=scanner.nextInt();
        for (int k=0;k<t;k++) {
            System.out.println("enter the amount to be paid");
            int n = scanner.nextInt();  //amount to be paid
            System.out.println("enter the number of different denomination available ");
            int m = scanner.nextInt();
            System.out.println("enter the value for " + m + " different denomination");
            int[] dv = new int[m]; //dv--> denomination value

            for (int i = 0; i < m; i++) {
                dv[i] = scanner.nextInt();
            }

            int[][] now = new int[m][n + 1];  //2d array  now-->number of ways

            for (int i = 0; i < m; i++) {

                for (int j = 0; j <= n; j++) {
                    if (j == 0) {
                        now[i][j] = 1;
                    }
                }
            }

            int h = 0;
            int h1 = 0;
            //magic goes here
            for (int i = 0; i < m; i++) {

                for (int j = 1; j <= n; j++) {
                    if (i == 0) {
                        h1 = dv[i];
                        if (j >= h1 && j % h1 == 0) {
                            now[i][j] = 1;
                        } else {
                            now[i][j] = 0;
                        }

                    } else {
                        if (dv[i] > j) {
                            now[i][j] = now[i - 1][j];
                        } else {
                            h = j - dv[i];
                            now[i][j] = now[i - 1][j] + now[i][h];
                        }
                    }
                }
            }

            write(now, n, m);

            System.out.println("answer=" + now[m - 1][n]);

        }
    }
}
