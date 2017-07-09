package edu.cs.scu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by maicius on 2017/7/5.
 */
public class Probelem2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int numArray = sc.nextInt();
        int arrayLen = 50000;

        int campus[][] = new int[numArray][arrayLen];
        List<Instrct> list = new ArrayList<>();

        for (int i = 0; i < numArray; i++) {
            int length=sc.nextInt();
            System.out.println("输入数组");
            for (int j = 0; j < length; j++) {
                campus[i][j] = sc.nextInt();
            }
            sc.nextLine();
            System.out.println("输入指令");

            String ins = sc.nextLine();
            while (!ins.equals("End")) {
                Instrct instrct = new Instrct();
                instrct.setValue(ins);
                instrct.setIndex(i);
                list.add(instrct);
                ins = sc.nextLine();
            }
            System.out.println("输入结束");
        }

        for (int i = 0; i < numArray; i++) {
            System.out.println("Case " + (i + 1) + ":");
            for (Instrct instrct : list) {
                if (instrct.getIndex() == i) {
                    StringTokenizer st = new StringTokenizer(instrct.getValue(), " ");
                    String ins1 = st.nextToken();
                    int ins2 = Integer.parseInt(st.nextToken());
                    int ins3 = Integer.parseInt(st.nextToken());
                    if (ins1.equals("Query")) {
                        int sum = 0;
                        for (int k = ins2 - 1; k < ins3; k++) {
                            sum += campus[i][k];
                            //System.out.println("sum:"+sum+"campus:"+campus[i][k]);
                        }
                        System.out.println("Query");
                        System.out.println(sum);
                    } else if (ins1.equals("Add")) {
                        //System.out.println("Add");
                        campus[i][ins2 - 1] += ins3;
                        //System.out.println(campus[i][ins2]);
                    } else if (ins1.equals("Sub")) {
                        //System.out.println("Sub");
                        campus[i][ins2 - 1] -= ins3;
                        //System.out.println(campus[i][ins2]);
                    }
                }
            }
        }
    }

}

