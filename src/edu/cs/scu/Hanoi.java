package edu.cs.scu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by maicius on 2017/7/9.
 */
public class Hanoi {
    private static int n, k;
    public static  int hanoi(int x){
        if(x == k)
            return 1;
        else
            return hanoi(x-1) * 2;
    }

    public static void main(String args[]) throws FileNotFoundException {
        int u;
        System.setIn(new FileInputStream("/Users/maicius/code/wake_server/NJUSumber/src/edu/cs/scu/input.file"));
        Scanner sc = new Scanner(System.in);
        u = sc.nextInt();
        for(int i=0; i< u; i++){
            n = sc.nextInt();
            k = sc.nextInt();
            System.out.println(hanoi(n));
        }
    }
}
