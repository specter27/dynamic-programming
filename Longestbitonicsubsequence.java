package com.company;

import java.util.Scanner;

public class Longestbitonicsubsequence {

    private static Scanner scanner=new Scanner(System.in);

    private static int max(int[] arr)
    {
        int maxe=arr[0];
        for (int i=0;i<arr.length;i++)
        {
            if (arr[i]>maxe)
            {
                maxe=arr[i];
            }
        }
        return maxe;
    }

    //------------------------------------------- LONGEST INCREASING SUB-SEQUENCE--------------->(LIS)
    private static int[] loninsubseq(int[] arr)
    {
        int lenlis=0;
        int[] lis = new int[arr.length];
        for (int q = 0; q < arr.length; q++) {
            lis[q] = 1;
        }

        int nlen=0;

        for(int i=1;i<arr.length;i++)  // finding longest increasing sub-sequence
        {
            for (int j=0;j<i;j++) {
                if (arr[j] < arr[i]) {
                    nlen = lis[j] + 1;
                    if (nlen >=lis[i]) {
                        lis[i] = nlen;
                    }
                }
            }
        }
        return lis ;
    }

    private static int[] ldecs(int[] arr)
    {
        int n=arr.length;
        int nlen=0;
        int[] lds=new int[n];

        for (int q = 0; q < arr.length; q++) {
            lds[q] = 1;
        }

        for (int i=n-2;i>=0;i--)
        {
            for (int j=n-1;j>i;j--)
            {
                if(arr[i]>arr[j])
                {
                    nlen=lds[j]+1;
                    if(nlen>=lds[i])
                    {
                        lds[i]=nlen;
                    }
                }
            }
        }
        return lds;
    }



    public static void main(String[] args) {
        System.out.println("enter the value of t");
        int t=scanner.nextInt();
        for (int j=0;j<t;j++) {
            System.out.println("enter the value of n");
            int n = scanner.nextInt();
            int[] arr = new int[n];

            for (int p = 0; p < arr.length; p++) {
                arr[p] = scanner.nextInt();
            }
            int[] lis = loninsubseq(arr);
            int[] lds = ldecs(arr);
            int[] result = new int[n];


            for (int i = 0; i < n; i++) {
                result[i] = lis[i] + lds[i] - 1;
            }

            int re = max(result);

            System.out.println("length of lbs=" + re);

        }
    }
}
