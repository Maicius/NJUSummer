import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MyMatrixTest {

	PrintStream console = null;
    ByteArrayOutputStream bytes = null;
    MyMatrix matrix;
    
    byte[] inputBytes;

    @org.junit.Before
    public void setUp() throws Exception {
    		
    	int[][] data = {
    			{1 , 1 , 1},
    			{1 , 1 , 1},
    			{1 , 1 , 1}
    	};
    	
        bytes = new ByteArrayOutputStream();
        console = System.out;
        matrix = new MyMatrix(data);

        System.setOut(new PrintStream(bytes));

    }

    @org.junit.After
    public void tearDown() throws Exception {
        
        System.setOut(console);
    }

    @org.junit.Test
    public void testPlus() throws Exception {
    	MyMatrix result = matrix.plus(matrix);
    	result.print();
    	int[][] data = {
    			{2 , 2 , 2},
    			{2 , 2 , 2},
    			{2 , 2 , 2}
    	};
    	assertTrue(result.equals(new MyMatrix(data)));
        
    }
    
    @org.junit.Test
    public void testTimes() throws Exception{
    	MyMatrix result = matrix.times(matrix);
    	int[][] data = {
    			{3,3,3},{3,3,3},{3,3,3}	
    	};
    	assertTrue(result.equals(new MyMatrix(data)));
    }
    
    @org.junit.Test
    public void testTimes2() throws Exception{
    	MyMatrix result = matrix.times(3);
    	int[][] data = {
    			{3,3,3},{3,3,3},{3,3,3}	
    	};
    	assertTrue(result.equals(new MyMatrix(data)));
    }
    
    @org.junit.Test
    public void testPlusFromConsole() throws Exception{
    	String input = "3 3\r\n1 1 1\r\n1 1 1\r\n1 1 1";
    	ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
    	System.setIn(inputStream);
    	MyMatrix result = matrix.plusFromConsole();
    	int[][] data = {
    			{2 , 2 , 2},
    			{2 , 2 , 2},
    			{2 , 2 , 2}
    	};
    	assertTrue(result.equals(new MyMatrix(data)));
    }
    
    @org.junit.Test
    public void testTimesFromConsole() throws Exception{
    	String input = "3 3\r\n1 1 1\r\n1 1 1\r\n1 1 1";
    	ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
    	System.setIn(inputStream);
    	MyMatrix result = matrix.timesFromConsole();
    	int[][] data = {
    			{3,3,3},{3,3,3},{3,3,3}	
    	};
    	assertTrue(result.equals(new MyMatrix(data)));
    }
    
    @org.junit.Test
    public void testTranspose() throws Exception{
    	MyMatrix result = matrix.transpose();
    	assertTrue(result.equals(matrix));
    }
    
    @org.junit.Test
    public void testPrint() throws Exception{
    	matrix.print();
    	assertEquals("\r\n1 1 1\r\n1 1 1\r\n1 1 1\r\n\r\n" , bytes.toString());
    }
    
}
