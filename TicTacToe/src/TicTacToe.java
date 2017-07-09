import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import Step.Step;

public class TicTacToe {
	/**
	 * Game的接口方法，我们会通过该方法进行测试
	 * 
	 * @param s为输入的操作序列
	 * @return 游戏结果
	 */
	private String sep = System.getProperty("line.separator");
	private static int chessboardRow = 3;
	private static int chessboardCol = 3;
	private static String chessboard[][] = new String[chessboardRow][chessboardCol];

	public Result playGame(String s) {
		setUpChessboard();
		List<Step> stepList = this.getPlaySteps(s);
		Result rs = this.startPlayGames(stepList);
		return rs;
	}

	public static void setUpChessboard() {
		for (int i = 0; i < chessboardCol; i++) {
			for (int j = 0; j < chessboardRow; j++) {
				chessboard[i][j] = "_";
			}
		}
	}

	public List<Step> getPlaySteps(String s) {
		StringTokenizer st = new StringTokenizer(s, ",");
		List<Step> stepList = new ArrayList<Step>();

		while (st.hasMoreTokens()) {
			Step step = new Step();
			String token = st.nextToken();
			// System.err.println("token:"+token);
			// System.out.println(token);
			int rowVal = mapABCtoInt(token.substring(0, 1).toCharArray());
			step.setRow(rowVal);
			step.setCol(Integer.parseInt(token.substring(1, 2)));
			// System.err.println("token:"+token+"rowVal:"+rowVal+"\t"+step.getRow()+
			// "colVal:" + step.getCol());
			stepList.add(step);
		}
		return stepList;
	}

	public String drawChessboard(String[][] chessboardLine) {
		String chessboard = "  A B C" + sep + "1 " + chessboardLine[0][0] + " " + chessboardLine[1][0] + " "
				+ chessboardLine[2][0] + sep + "2 " + chessboardLine[0][1] + " " + chessboardLine[1][1] + " "
				+ chessboardLine[2][1] + sep + "3 " + chessboardLine[0][2] + " " + chessboardLine[1][2] + " "
				+ chessboardLine[2][2] + sep;
		return chessboard;
	}

	public int mapABCtoInt(char[] s) {
		int val = -1;
		if (s[0] == 'A')
			val = 1;
		else if (s[0] == 'B')
			val = 2;
		else if (s[0] == 'C')
			val = 3;
		else {
			System.err.println("error: " + s[0]);
		}
		return val;
	}

	public Result startPlayGames(List<Step> steps) {
		int i = 0;
		Result rs = null;

		for (Step step : steps) {
			int col = step.getCol();
			int row = step.getRow();

			// System.err.println("I:"+i+" col:"+ col +" row:"+row);
			if (i % 2 == 0) {
				chessboard[row - 1][col - 1] = "X";
				System.out.print(this.drawChessboard(chessboard));
				rs = this.judgeResult(chessboard);
			} else {
				chessboard[row - 1][col - 1] = "O";
				System.out.print(this.drawChessboard(chessboard));
				rs = this.judgeResult(chessboard);
			}
			i++;
		}
		return rs;
	}

	public Result judgeResult(String[][] chessboardLine) {

		int XRow, XCol;
		int ORow, OCol;
		int XXWin, OXWin;// X型胜利的情况
		int ColSpareChess = 9, RowSpareChess = 9;
		if (chessboardLine[0][2] == "X" && chessboardLine[1][1] == "X" && chessboardLine[2][0] == "X") {
			return Result.X_WIN;
		} else if (chessboardLine[0][2] == "O" && chessboardLine[1][1] == "O" && chessboardLine[2][0] == "O") {
			return Result.O_WIN;
		} else {
			XXWin = 0;
			OXWin = 0;
			for (int i = 0; i < chessboardRow; i++) {
				XRow = 0;
				XCol = 0;
				ORow = 0;
				OCol = 0;

				if (chessboardLine[i][i] == "X") {
					XXWin++;
				} else if (chessboardLine[i][i] == "O") {
					OXWin++;
				}
				for (int j = 0; j < chessboardCol; j++) {

					if (chessboardLine[i][j] == "X") {
						ColSpareChess--;
						XCol++;
					} else if (chessboardLine[i][j] == "O") {
						ColSpareChess--;
						OCol++;
					}

					if (chessboardLine[j][i] == "X") {
						RowSpareChess--;
						XRow++;
					} else if (chessboardLine[j][i] == "O") {
						RowSpareChess--;
						ORow++;
					}
				}
				if (XCol == 3 || XRow == 3 || XXWin == 3) {
					return Result.X_WIN;
				} else if (OCol == 3 || ORow == 3 || OXWin == 3) {
					return Result.O_WIN;
				}
			}

			if (ColSpareChess > 0 && RowSpareChess > 0) {
				return Result.GAMING;
			} else {
				return Result.DRAW;
			}
		}
	}
}
