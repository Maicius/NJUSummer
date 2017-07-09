package edu.cs.scu.input;

import java.util.Scanner;

/**
 * Created by maicius on 2017/7/9.
 */
public class hanoi2 {
    public static int hanoi2(int x){
        int m=1;
        for(int i=1; i< x; i++)
           m = m*2 + 1;
        return m;
    }
    public static void main(String args[]){
        int x, k;
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        for(int i=0; i< x; i++){
            k = sc.nextInt();
            System.out.println(hanoi2(k));
        }
    }
}
