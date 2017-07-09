package edu.cs.scu;

import java.util.Scanner;

/**
 * Created by maicius on 2017/7/6.
 */
public class piggyBank {
    static int MAXN = 1000000;
    static int inf = 1000000;
    public static void main(String args[]){
        System.out.println("Input test cases numbers");
        Scanner sc = new Scanner(System.in);

        int testCaseNum = sc.nextInt();
        int p[] = new int[MAXN];
        int w[] = new int[MAXN];
        int dp[] = new int[MAXN*10];
        int piggyWeight=0;
        int coinType = 0;
        for(int i=0; i < testCaseNum; i++){
            int initPiggyWeight = sc.nextInt();
            int fullPiggyWeight = sc.nextInt();
            piggyWeight = fullPiggyWeight - initPiggyWeight;
            for(int k=0; k<=piggyWeight; ++k)
                dp[k] = -inf;

            coinType = sc.nextInt();
            for(int j=0; j< coinType; ++j){
                p[j]= sc.nextInt();
                w[j] = sc.nextInt();
                p[j] = -p[j];
            }
            System.out.println("Input end");
            dp[0] = 0;
            for(int m=0; m < coinType; ++m){
                for(int n=w[m];n <= piggyWeight; ++n){
                    dp[n] = max(dp[n], dp[n-w[m]] + p[m]);
                }
            }
            if(dp[piggyWeight] == -inf)
                System.out.println("This is impossible.");
            else
                System.out.println("The minimum amount of money in the piggy-bank is %d.\n" + (-dp[piggyWeight]));
        }
    }

    public static int max(int x, int y){
        return x > y? x: y;
    }
}
