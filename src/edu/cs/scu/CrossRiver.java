package edu.cs.scu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by maicius on 2017/7/9.
 */
public class CrossRiver {
    public static int min(int a, int b){
        return a> b ? b: a;
    }
    public static void main(String args[]) throws FileNotFoundException {
        int t, n ,tmp;
        int ans[] = new int[1000];
        int speed[] = new int[1005];
        System.setIn(new FileInputStream("/Users/maicius/code/" +
                "wake_server/NJUSumber/src/edu/cs/scu/input/corssRiverInput"));
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for(int l=0;l< t; l++){
            n = sc.nextInt();
            for(int j=0; j< n; j++){
                speed[j] = sc.nextInt();
            }
            // bubble sort(0->n:small->large)
            for(int i=0; i < n; i++){
                for(int j=i; j < n; j++){
                    if(speed[i] > speed[j]){
                        tmp = speed[i];
                        speed[i] = speed[j];
                        speed[j] = tmp;
                    }
                }
            }
            //greedy
            int start = n;
            ans[l] = 0;
            while (start !=0){
                //start = 1, 2, 3 直接处理
                if(start == 1){
                    ans[l] += speed[0];
                    break;
                }
                else if(start == 2){
                    ans[l] +=speed[1];
                    break;
                }
                else if(start == 3){
                    ans[l] +=speed[2] + speed[3] + speed[1];
                    break;
                }
                else{
                    ans[l] += min(speed[1]+speed[0]+speed[start-1]+speed[1],
                            speed[start-1]+2*speed[0]+speed[start-2]);
                    start -= 2;
                }
            }
            System.out.println(ans[l]);
        }

    }
}
