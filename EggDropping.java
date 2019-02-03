package com.company;

import java.util.Scanner;

public class EggDropping {
    private static Scanner scanner=new Scanner(System.in);

    private static int max(int a,int b)   /*returns true if
                                                        the floor is either the TOP or BOTTOM*/
    {
      int re;
      if(a>b)
      {
          re=a;
      }
      else {
          re=b;
      }
      return  re;
    }
    private static int min(int[] arr)
    {
        int min=arr[0];
        for (int i=1;i<arr.length;i++)
        {
            if(min>arr[i])
            {
                min=arr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println("enter the value of t");
        int t=scanner.nextInt();

        for (int l=0;l<t;l++) {
            System.out.println("enter the number of eggs");
            int n = Integer.parseInt(scanner.next());
            System.out.println("enter the number of floors");
            int fl = Integer.parseInt(scanner.next());


            int[][] arr = new int[n + 1][fl + 1];  // 2d array with n----rows and fl-----columns


            for (int i = 1; i <= n; i++)  // number of eggs
            {

                for (int j = 1; j <= fl; j++) //number of floor
                {
                    int[] noa = new int[j]; //no of attempts
                    if (i > 1) {  //means the first row has been completed

                        if (i > j) {
                            arr[i][j] = arr[i - 1][j];
                        } else {
                            for (int k = 1; k <= j; k++)  //k represent the present floor

                            {

                                int a = 0;   //determines the number of attempts that are required when the egg breaks from a certain floor
                                int b = 0;   //determines the number of attempts that are required when the egg does not
                                // breaks from a certain floor

                                // Calculating  the value of a
                                if (k - 1 < 1)   //check for the 1st floor
                                {
                                    a = 0;
                                } else {
                                    a = arr[i - 1][k - 1];
                                }

                                //Calculating the value of b
                                if (k + 1 > j)  //check for the top floor
                                {
                                    b = 0;
                                } else {
                                    b = arr[i][j - k];
                                }
                                noa[k - 1] = 1 + max(a, b);

                            }
                            arr[i][j] = min(noa);
                        }
                    } else {
                        arr[i][j] = j;
                    }


                }
            }

            for (int a=1;a<=n;a++)
            {
                for (int b=1;b<=fl;b++)
                {
                    System.out.print(arr[a][b]+" ");
                }
                System.out.print("\n");
            }

            System.out.println("ans="+arr[n][fl]);
        }
    }
}
