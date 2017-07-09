import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;


public class GameTest {
    TicTacToe game = null;
    Result result = null;
    PrintStream console = null;
    ByteArrayOutputStream bytes = null;
    String sep;

    @org.junit.Before
    public void setUp() throws Exception {
        game = new TicTacToe();
        bytes = new ByteArrayOutputStream();
        console = System.out;
        System.setOut(new PrintStream(bytes));
        sep = System.getProperty("line.separator");
    }

    @org.junit.After
    public void tearDown() throws Exception {
    	bytes.close();
        System.setOut(console);
    }
    
    // One step
    @org.junit.Test
    public void test1() throws Exception {
        result = game.playGame("A1");
        assertEquals(Result.GAMING,result);
        assertEquals(
                 "  A B C" + sep
                +"1 X _ _" + sep
                +"2 _ _ _" + sep
                +"3 _ _ _" + sep,bytes.toString());
    }
    
    // \, X win
    @org.junit.Test
    public void test3() throws Exception {
        result = game.playGame("A1,B1,B2,B3,C3");
        assertEquals(Result.X_WIN,result);
        assertEquals(
                 "  A B C" + sep
                +"1 X _ _" + sep
                +"2 _ _ _" + sep
                +"3 _ _ _" + sep
                +"  A B C" + sep
                +"1 X O _" + sep
                +"2 _ _ _" + sep
                +"3 _ _ _" + sep
                +"  A B C" + sep
                +"1 X O _" + sep
                +"2 _ X _" + sep
                +"3 _ _ _" + sep
                +"  A B C" + sep
                +"1 X O _" + sep
                +"2 _ X _" + sep
                +"3 _ O _" + sep
                +"  A B C" + sep
                +"1 X O _" + sep
                +"2 _ X _" + sep
                +"3 _ O X" + sep,bytes.toString());
    }
    
    // |, X win
    @org.junit.Test
    public void test5() throws Exception {
        result = game.playGame("C1,A2,C2,B2,C3");
        assertEquals(Result.X_WIN,result);
        assertEquals(
                 "  A B C" + sep
                +"1 _ _ X" + sep
                +"2 _ _ _" + sep
                +"3 _ _ _" + sep
                +"  A B C" + sep
                +"1 _ _ X" + sep
                +"2 O _ _" + sep
                +"3 _ _ _" + sep
                +"  A B C" + sep
                +"1 _ _ X" + sep
                +"2 O _ X" + sep
                +"3 _ _ _" + sep
                +"  A B C" + sep
                +"1 _ _ X" + sep
                +"2 O O X" + sep
                +"3 _ _ _" + sep
                +"  A B C" + sep
                +"1 _ _ X" + sep
                +"2 O O X" + sep
                +"3 _ _ X" + sep,bytes.toString());
    }
    
    // -, O win
    @org.junit.Test
    public void test7() throws Exception {
        result = game.playGame("A1,A2,B1,B2,C3,C2");
        assertEquals(Result.O_WIN,result);
        assertEquals(
                 "  A B C" + sep
                +"1 X _ _" + sep
                +"2 _ _ _" + sep
                +"3 _ _ _" + sep
                +"  A B C" + sep
                +"1 X _ _" + sep
                +"2 O _ _" + sep
                +"3 _ _ _" + sep
                +"  A B C" + sep
                +"1 X X _" + sep
                +"2 O _ _" + sep
                +"3 _ _ _" + sep
                +"  A B C" + sep
                +"1 X X _" + sep
                +"2 O O _" + sep
                +"3 _ _ _" + sep
                +"  A B C" + sep
                +"1 X X _" + sep
                +"2 O O _" + sep
                +"3 _ _ X" + sep
                +"  A B C" + sep
                +"1 X X _" + sep
                +"2 O O O" + sep
                +"3 _ _ X" + sep,bytes.toString());
    }
    
    // Draw
    @org.junit.Test
    public void test9() throws Exception {
        result = game.playGame("C1,A2,C2,C3,B2,A3,A1,B1,B3");
        assertEquals(Result.DRAW,result);
        assertEquals(
                 "  A B C" + sep
                +"1 _ _ X" + sep
                +"2 _ _ _" + sep
                +"3 _ _ _" + sep
                +"  A B C" + sep
                +"1 _ _ X" + sep
                +"2 O _ _" + sep
                +"3 _ _ _" + sep
                +"  A B C" + sep
                +"1 _ _ X" + sep
                +"2 O _ X" + sep
                +"3 _ _ _" + sep
                +"  A B C" + sep
                +"1 _ _ X" + sep
                +"2 O _ X" + sep
                +"3 _ _ O" + sep
                +"  A B C" + sep
                +"1 _ _ X" + sep
                +"2 O X X" + sep
                +"3 _ _ O" + sep
                +"  A B C" + sep
                +"1 _ _ X" + sep
                +"2 O X X" + sep
                +"3 O _ O" + sep
                +"  A B C" + sep
                +"1 X _ X" + sep
                +"2 O X X" + sep
                +"3 O _ O" + sep
                +"  A B C" + sep
                +"1 X O X" + sep
                +"2 O X X" + sep
                +"3 O _ O" + sep
                +"  A B C" + sep
                +"1 X O X" + sep
                +"2 O X X" + sep
                +"3 O X O" + sep,bytes.toString());
    }

}
