import java.util.Arrays;
import java.util.Scanner;

/**
 * 矩阵类，实现矩阵的加法，矩阵乘法，点乘以及转置方法
 * 其中加法和点乘方法需要有两种实现方式
 * 1.传入一个MyMatrix对象进行2个矩阵的操作
 * 2.从控制台（console）读入一个矩阵数据，再进行操作
 * 所有的数据均为int型
 * 输入数据均默认为正确数据，不需要对输入数据进行校验
 * @author Ray Liu & Qin Liu
 *
 */
public class MyMatrix {

	private int[][] data;
	private int m; //矩阵的第一维长度
	private int n; //矩阵的第二维长度
	
	/**
	 * 构造函数，参数为2维int数组
	 * a[i][j]是矩阵中的第i+1行，第j+1列数据
	 * @param a
	 */
	public MyMatrix(int[][] a){
		this.data = a;
		m=a.length;
		n=a[0].length;
	}

	/**
	 * 返回2维int矩阵
	 * @return int[][]
	 */
	public int[][] getArray(){
		return data;
	}

	/**
	 * 返回矩阵的第一维长度
	 * @return int
	 */
	public int getM(){
		return m;
	}

	/**
	 * 返回矩阵的第二维长度
	 * @return
	 */
	public int getN(){
		return n;
	}
	
	/**
	 * 实现矩阵加法，返回一个新的矩阵
	 * @param B
	 * @return
	 */
	public MyMatrix plus(MyMatrix B){
		B.data = this.plus(this.data, B.data);
		return B;
	}
    public int[][] plus(int a[][], int b[][]){
		int m = a.length;
		int n = a[0].length;
		int c[][] = new int[m][n];
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				c[i][j] = a[i][j]+b[i][j];
			}
		}
		return c;
	}
        
	
	/**
	 * 实现矩阵乘法，返回一个新的矩阵
	 * @param B
	 * @return
	 */
    public int singleTimes(int[][] a, int[][] b, 
    		int row, int col){
    	int rs = 0;
    	for(int i=0; i< a.length; i++){
    		rs += a[row][i] * b[i][col];
    	}
    	return rs;
    }
    
	public MyMatrix times(MyMatrix B){
		int m = this.n;
		int n = B.n;
		int data[][] = new int[m][n];
		for(int i=0; i< m; i++){
			for(int j=0; j<n; j++){
				data[i][j] = this.singleTimes(this.data, B.data, i, j);
			}
		}
		return new MyMatrix(data);
	}
	
	
	/**
	 * 实现矩阵的点乘，返回一个新的矩阵
	 * @param b
	 * @return
	 */
	public MyMatrix times(int b){
		
		int data[][] = this.data;
		int m = this.getM();
		int n = this.getN();
		for(int i=0;i<m; i++){
			for(int j=0; j<n; j++){
				data[i][j] = data[i][j] * b;
			}
		}
		MyMatrix matrix = new MyMatrix(data);
		return matrix;
	}
	
	/**
	 * 实现矩阵的转置，返回一个新的矩阵
	 * @return
	 */
	public MyMatrix transpose(){
		int data[][] = new int[this.n][this.m];
		for(int i=0; i<this.n; i++){
			for(int j=0; j<this.m; j++){
				data[i][j]= this.data[j][i];
			}
		}
		this.data = data;
		return this;
	}
	
	/**
	 * 从控制台读入矩阵数据，进行矩阵加法，读入数据格式如下：
	 * m n
	 * m * n 的数据方阵，以空格隔开
	 * example:
	 * 4 3
	 * 1 2 3 
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 返回一个新的矩阵
	 * @return
	 */
	public MyMatrix inputMatrixFromConsole(){
		Scanner sc = new Scanner(System.in); 
		int m = sc.nextInt();
		int n = sc.nextInt();
		int data[][] = new int[m][n];
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				data[i][j] = sc.nextInt();
			}
		}
		sc.close();
		return new MyMatrix(data);
	}
	
	public MyMatrix plusFromConsole(){
		MyMatrix matrix = inputMatrixFromConsole();
		return this.plus(matrix); 
	}
	
	/**
	 * 输入格式同上方法相同
	 * 实现矩阵的乘法
	 * 返回一个新的矩阵
	 * @return
	 */
	public MyMatrix timesFromConsole(){
		MyMatrix matrix = inputMatrixFromConsole();
		return this.times(matrix);
	}
	
	/**
	 * 打印出该矩阵的数据
	 * 起始一个空行，结束一个空行
	 * 矩阵中每一行数据呈一行，数据间以空格隔开
	 * example：
	 * 
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 
	 */
	public void print(){
		System.out.print("\r\n");
		for(int i=0; i<this.m; i++){
			for(int j=0; j<this.n; j++){
				System.out.print(this.data[i][j]);
				if(j < this.n - 1)
					System.out.print(" ");
			}
			System.out.print("\r\n");
		}
		System.out.print("\r\n");
	}
	
	/**
	 * 判断是否相等的方法，考生不要修改！！
	 */
	public boolean equals(Object obj){
		
		if(obj instanceof MyMatrix){
			MyMatrix matrix = (MyMatrix) obj;
			
			if(this.data.length != matrix.data.length){
				return false;
			}
			
			for(int i=0 ; i<this.data.length ; ++i){
				if(!Arrays.equals(this.data[i], matrix.data[i])){
					return false;
				}
			}
			
			return true;
			
		}else{
			return false;
		}
	}
	
}
