package com.company;

import java.util.Scanner;

public class stockbuyandsell {

    /*so basically in this we have to tell weather there exist any TRADING INTERVALS with profit
     * if yes
      * print the intervals
      * else
      * print----No Profit*/
    private static Scanner scanner=new Scanner(System.in);
    private static int buyingdate(int pbd,int[] arr)
    {
        int nbd=0;        // new buying date
        if (arr[pbd+1]>arr[pbd])
        {
            nbd=pbd;
        }
        else {
            nbd=pbd+1;
        }

        return nbd;
    }

    private static boolean profit(int[] arr)  //test weather the array elements are completely decreasing or not
    {
        boolean re=false;
        int size=arr.length;
        int count=0;
        int sin=0;
        for(int i=0;i<size;i++)
        {
           for (int j=i+1;j<size;j++)
           {
               if (arr[i]>arr[j])
               {
                   continue;
               }
               else {
                   sin=1;
                   break;
               }
           }
           if (sin==1)
           {
               break;
           }
           count=count+1;
        }
        if (count==size)
        {
         re=true;
        }
        return re;
    }
    private static boolean eqct(int[] arr)   //equal cost--->check weather all the elements in the array are equal or not
    {
        int c=1;
        boolean result=false;
        int l=arr[0];
        for (int i=1;i<arr.length;i++)
        {
            if (arr[i]==l){
              c=c+1;
            }
            else {
                break;
            }
        }
         if(c==arr.length){
            result=true;
         }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("enter the value of the t");
        int t = scanner.nextInt();
        for (int k = 0; k < t; k++) {
            System.out.println("enter the value of n");
            int n = scanner.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            //finding the first buying day

            boolean test1 = profit(arr);
            boolean test2 = eqct(arr);


            if (test1 == false && test2 == false) {


                int bd = buyingdate(0, arr); //bd---->buying day(intial buying day)


                //deciding the selling day

                int u = 0;  //used for keeping record for how many days we have to keep the stock
                int sd = 0; //selling day
                for (int j = bd + 1; j < n; j++) {

                    if (arr[j] > arr[bd + u]) {
                        u = u + 1;
                        if (j == n - 1) {
                            sd = bd + u;
                            System.out.print("(" + bd + " " + sd + ") "+"\n");
                        }
                        continue;
                    }
                    //100 180 260 310 40 535 695


                    else {
                        if (u == 0) {
                            if (bd < n - 1) {
                                int abd = buyingdate(bd, arr);  // actual buying date
                                j = abd;
                                bd = abd;
                                u = 0;
                            }
                        } else {
                            sd = bd + u;
                            System.out.print("(" + bd + " " + sd + ")\u0020");
                            bd = sd + 1;
                            if (bd < n - 1) {
                                int abd = buyingdate(bd, arr);  // actual buying date
                                j = abd;
                                bd = abd;
                                u = 0;
                            } else {
                                break;
                            }
                            // 23 13 25 29 33 19 34 45 65 67
                        }
                    }
                }
                System.out.print("\n");
            }

            else if(test1==true||test2==true) {
                System.out.println("No Profit");
            }

        }

        //886 2777 6915 7793 8335 5386 492 6649 1421 2362 27 8690 59 7763 3926 540 3426 9172 5736 5211 5368 2567 6429 5782 1530 2862 5123 4067 3135 3929 9802 4022 3058 3069 8167 1393 8456 5011 8042 6229 7373 4421 4919 3784 8537 5198 4324 8315 4370 6413 3526 6091 8980 9956 1873 6862 9170 6996 7281 2305 925 7084 6327 336 6505 846 1729 1313 5857 6124 3895 9582 545 8814 3367 5434 364 4043 3750 1087 6808 7276 7178 5788
    }
}
  //  85
// 5403 2651 2754 2399 9932 5060 9676 3368 7739 12 6226 8586 8094 7539 795 570 1434 378 7467 6601 97 2902 3317 492 6652 756 7301 280 4286 9441 3865 9689 8444 6619 8440 4729 8031 8117 8097 5771 4481 675 709 8927 4567 7856 9497 2353 4586 6965 5306 4683 6219 8624 1528 2871 5732 8829 9503 19 8270 3368 9708 6715 6340 8149 7796 723 2618 2245 2846 3451 2921 3555 2379 7488 7764 8228 9841 2350 5193 1500 7034 7764 124