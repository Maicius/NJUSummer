import java.util.Arrays;
import java.util.Scanner;

/**
 * �����࣬ʵ�־���ļӷ�������˷�������Լ�ת�÷���
 * ���мӷ��͵�˷�����Ҫ������ʵ�ַ�ʽ
 * 1.����һ��MyMatrix�������2������Ĳ���
 * 2.�ӿ���̨��console������һ���������ݣ��ٽ��в���
 * ���е����ݾ�Ϊint��
 * �������ݾ�Ĭ��Ϊ��ȷ���ݣ�����Ҫ���������ݽ���У��
 * @author Ray Liu & Qin Liu
 *
 */
public class MyMatrix {

	private int[][] data;
	private int m; //����ĵ�һά����
	private int n; //����ĵڶ�ά����
	
	/**
	 * ���캯��������Ϊ2άint����
	 * a[i][j]�Ǿ����еĵ�i+1�У���j+1������
	 * @param a
	 */
	public MyMatrix(int[][] a){
		this.data = a;
		m=a.length;
		n=a[0].length;
	}

	/**
	 * ����2άint����
	 * @return int[][]
	 */
	public int[][] getArray(){
		return data;
	}

	/**
	 * ���ؾ���ĵ�һά����
	 * @return int
	 */
	public int getM(){
		return m;
	}

	/**
	 * ���ؾ���ĵڶ�ά����
	 * @return
	 */
	public int getN(){
		return n;
	}
	
	/**
	 * ʵ�־���ӷ�������һ���µľ���
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
	 * ʵ�־���˷�������һ���µľ���
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
	 * ʵ�־���ĵ�ˣ�����һ���µľ���
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
	 * ʵ�־����ת�ã�����һ���µľ���
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
	 * �ӿ���̨����������ݣ����о���ӷ����������ݸ�ʽ���£�
	 * m n
	 * m * n �����ݷ����Կո����
	 * example:
	 * 4 3
	 * 1 2 3 
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * ����һ���µľ���
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
	 * �����ʽͬ�Ϸ�����ͬ
	 * ʵ�־���ĳ˷�
	 * ����һ���µľ���
	 * @return
	 */
	public MyMatrix timesFromConsole(){
		MyMatrix matrix = inputMatrixFromConsole();
		return this.times(matrix);
	}
	
	/**
	 * ��ӡ���þ��������
	 * ��ʼһ�����У�����һ������
	 * ������ÿһ�����ݳ�һ�У����ݼ��Կո����
	 * example��
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
	 * �ж��Ƿ���ȵķ�����������Ҫ�޸ģ���
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
