
public class Board {
	
	private char[][] board;
	
	public Board(char[][] board) {
		this.board = board;
	}
	public void setValue(int x, int y, char val) {
		board[x][y] = val;
	}
	public char[][] getBoard(){
		return board;
	}
	public char getValue(int x, int y) {
		return board[x][y];
	}
	public char[] getRow(int row) {
		return board[row];
	}
	public char[] getCol(int col) {
		char[] colArr = new char[9];
		for(int i = 0; i < colArr.length; i++) {
			colArr[i] = board[i][col];
		}
		return colArr;
	}
	public char[][] getSquare(int x, int y){
		char[][] square = new char[3][3];
		int startX = x*3;
		int startY = y*3;
		for(int i = startY; i < startY+3; i++) {
			for(int j = startX; j < startX+3; j++) {
				square[i-startY][j-startX] = board[i][j];
			}
		}
		return square;
		
	}
	public String toString() {
		String str = "";
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				str += board[i][j];
				if(j!= 8)
					str += "|";
				if((j+1) % 3 == 0 && j != 8)
					str += "|";
				
			}
			if((i+1) % 3 == 0 && i != 8)
				str += "\n=====||=====||=====";
			str += "\n";
		}
		return str;
	}
}
