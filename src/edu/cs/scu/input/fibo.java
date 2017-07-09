package edu.cs.scu.input;

/**
 * Created by maicius on 2017/7/10.
 */
public class fibo {
    private static  int fibArray[] = new int[10000];
    private static int sum = 0;
    public static int fib(int n){
        if(fibArray[n] != 0)
            return fibArray[n];
        else {
            fibArray[n] = fib(n - 1) + fib(n - 2);
            return fibArray[n];
        }
    }
    public static void main(String args[]){
        fibArray[0] = 1;
        fibArray[1] = 2;
        System.out.println(fib(4));
        System.out.println("");
    }
}
