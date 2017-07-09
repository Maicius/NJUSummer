package edu.cs.scu;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by maicius on 2017/7/7.
 */
public class SegmentTreeProbelem {
    private static int r[] = new int[50009];
    private static int SUM;
    private static int count;
    //private static List<SegmentTree> t = new ArrayList<>();
    private static SegmentTree t[] = new SegmentTree[140000];

    public static void make(int left, int right, int num){
        t[num] = new SegmentTree();
        t[num].setLeft(left);
        t[num].setRight(right);
        if(left == right) {

            t[num].setSum(r[left]);
            System.out.println("left:"+ left+" right:"+ right + " "+"sum"+ t[num].getSum()+" num:"+num);
        }
        else{
            System.out.println("else:"+ "left:"+ left+" right:"+ right + " "+"r[left]"+ r[left]+" num:"+ num);
            make(left, (left + right)/2, num + num);
            make((left + right) /2 +1, right, num + num +1);
            t[num].setSum(t[num + num].getSum() + t[num + num +1].getSum());
            System.out.println("t[num]:"+ num+ " "+ t[num].getSum());
        }
    }
    public static void query(int left, int right, int num){
        System.out.println("left:"+left + "right:" + right + "t[num]Left:" + t[num].getLeft() + "t[num]Right:" + t[num].getRight());
        System.out.println("t[num]SUM:" + t[num].getSum());
        if(left <=t[num].getLeft() && right >=t[num].getRight())
            SUM +=t[num].getSum();
        else{
            if(right <=(t[num].getLeft() + t[num].getRight())/2)
                query(left, right, num + num);
            else if(left >=(t[num].getLeft() + t[num].getRight()) / 2 +1)
                query(left, right, num + num +1);
            else{
                query(left, right, num + num);
                query(left, right, num + num +1);
            }
        }
    }

    public static void add(int x, int y, int num){
        t[num].setSum(t[num].getSum() + y);
        if( t[num].getLeft() == t[num].getRight())
            return;
        if( x > (t[num].getLeft() + t[num].getRight())/ 2)
            add(x, y, num + num +1);
        else{
            add(x, y ,num+num);
        }
    }
    public static void sup(int x, int y, int num){
        t[num].setSum(t[num].getSum() - y);
        if(t[num].getLeft() == t[num].getRight())
            return;
        if(x > (t[num].getLeft() + t[num].getRight()) /2)
            sup(x, y, num + num +1);
        else
            sup(x, y, num +num);
    }
    public static void main(String args[]){
        int num, i ,a, b, n ,m = 0;
        String s = "";
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        for(int k = num; k>0; k--){
            n = sc.nextInt();
            for(i =1; i<=n; i++)
                r[i] = sc.nextInt();
            make(1, n ,1);
            System.out.println("Case: " + (++m));
            sc.nextLine();
            while(true){
                s = sc.nextLine();
                StringTokenizer st = new StringTokenizer(s, " ");
                String ins = st.nextToken();
                if(ins.equals("End"))
                    break;;
                if(ins.equals("Query")){
                    a = Integer.parseInt(st.nextToken());
                    b = Integer.parseInt(st.nextToken());
                    SUM = 0;
                    query(a, b, 1);
                    System.out.print(SUM);
                }
                if(ins.equals("Add")){
                    a = Integer.parseInt(st.nextToken());
                    b = Integer.parseInt(st.nextToken());
                    add(a, b ,1);
                }
                if(ins.equals("Sub")){
                    a = Integer.parseInt(st.nextToken());
                    b = Integer.parseInt(st.nextToken());
                    sup(a, b ,1);
                }
            }
        }
    }

}
