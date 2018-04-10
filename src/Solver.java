import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solver {
	
	private Board board;
	
	public Solver(Board board) {
		this.board = board;
	}
	
	public void solve() {
		//Keep track of loops to ensure that we don't infinite loop on an unsolvable board
		int loops = 0;
		while(!isSolved()) {
			checkSolutions();
			loops++;
			if(loops == 100) {
				System.out.println(board.toString());
				break;
			}
		
		}
		System.out.println(board.toString());
	}
	//This method finds all unsolved positions and attempts to solve them
	public void checkSolutions() {
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(board.getValue(j, i) == ' ') {
					attemptToSolve(i,j);
				}
			}
		}
	}
	
	//To attempt to solve we start with all digits, then remove all of the digits that appear in the same row, column and square as our position
	//If there is only one digit left we insert that, this is repeated until all positions with one possible digit are filled, at which point we restart the process
	public void attemptToSolve(int i, int j) {
		
		Character[] numsArr = {'1','2','3','4','5','6','7','8','9'};
		List<Character> nums = new ArrayList<Character>();
		nums.addAll(Arrays.asList(numsArr));
		
		for(char c : board.getRow(j)) nums.remove((Character)c);
		
		for(char c : board.getCol(i)) nums.remove((Character)c);
		
		String str = Arrays.deepToString(board.getSquare(((i)/3), ((j)/3))).replace("[", "");
		str = str.replace("]", "");
		str = str.replace(",", "");
		str = str.replace(" ", "");
	
		for(char c : str.toCharArray()) nums.remove((Character)c);
		
		if(nums.toArray().length == 1)
				board.setValue(j, i, nums.get(0));
		
	}
	public void attemptDeepSolve() {
		Board deepBoard = new Board(board.getBoard());
		
	}
	
	//This method does not check if the solution is correct, just that all values are filled as it should be impossible for the solution to be incorrect, if we are unable to solve it, the board will remain incomplete
	public boolean isSolved() {
		for(char[] i : board.getBoard()) {
			for(char j : i) {
				if(j == ' ')
					return false;
			}
				
		}
		return true;
	}

}
