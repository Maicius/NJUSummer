package edu.cs.scu;

import java.util.Scanner;



/**
 * Created by maicius on 2017/7/6.
 */

public class DPExe {
    private static int n;
    private static int arr[][] = new int[100][100];
    private static int totalSum[][] = new int[100][100];
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for(int i=1; i <= n ; i++){
            for(int j=1; j <=  i; j++){
                arr[i][j] = sc.nextInt();
                totalSum[i][j] = -1;
            }
        }
        System.out.println(maxSum(1, 1));
    }

    public static int max(int x, int y){
        return x > y? x: y;
    }
    public static int maxSum(int i, int j){

        if(totalSum[i][j] != -1)
            return totalSum[i][j];
        if(i == n){
            totalSum[i][j] = arr[i][j];
        }
        else {
            int x = maxSum(i + 1, j);
            int y = maxSum(i + 1, j + 1);
            totalSum[i][j] = arr[i][j] + max(x, y);
        }
        return totalSum[i][j];
    }
}
