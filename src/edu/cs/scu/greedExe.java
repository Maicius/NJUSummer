package edu.cs.scu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by maicius on 2017/7/9.
 */
public class greedExe {
    private static int N;
    private static GreedEntity act[] = new GreedEntity[100010];
    public static boolean cmp(GreedEntity a, GreedEntity b){
        return a.end < b.end;
    }
    public static int greedy_selector(){
        int num = 1, i=1;
        for(int j=2; j<N; j++){
            if(act[j].start >= act[i].end){
                i = j;
                num++;
            }
        }
        return num;
    }

    public static void main(String args[]) throws FileNotFoundException {
        System.setIn(new FileInputStream("/Users/maicius/code/wake_server/NJUSumber/src/edu/cs/scu/input.file"));
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for(int i=0; i<t; i++){
            N = sc.nextInt();
            for(int j =1; j <=N; j++){
                act[j] = new GreedEntity();
                act[j].start = sc.nextInt();
                act[j].end = sc.nextInt();
            }
            act[0] = new GreedEntity();
            act[0].start = -1;
            act[0].end = -1;
            bubleSort(act);
            int res = greedy_selector();
            System.out.println(res);
        }
    }

    public static void bubleSort(GreedEntity[] act){
        //nt n = act.length;
        for(int i=1; i< N; i++){
            for(int j=i; j < N; j++){
                if(act[i].end > act[j].end){
                    GreedEntity tmp = new GreedEntity();
                    tmp = act[i];
                    act[i] = act[j];
                    act[j] = tmp;
                }
            }
        }
    }
}
