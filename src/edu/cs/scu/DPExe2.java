package edu.cs.scu;

import java.util.Scanner;



/**
 * Created by maicius on 2017/7/6.
 */

public class DPExe2 {
    private static int n;
    private static int arr[][] = new int[100][100];
    private static int totalSum[][] = new int[100][100];
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for(int i=1; i <= n ; i++){
            for(int j=1; j <=  i; j++){
                arr[i][j] = sc.nextInt();
                //totalSum[i][j] = -1;
            }
        }
        for(int i=1; i<=n; i++){
            totalSum[n][i] = arr[n][i];
        }
        for(int i=n-1; i >=1; i--){
            for(int j=i; i >=1; i--){
                totalSum[i][j] = max(totalSum[i+1][j], totalSum[i][j+1]) + arr[i][j];
            }
        }

        System.out.println(totalSum[1][1]);
    }

    public static int max(int x, int y){
        return x > y? x: y;
    }
}
