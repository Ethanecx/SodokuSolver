
import java.util.Scanner;

public class sodokuSolve {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		char[][] boardArr = new char[9][9];
		//String[] s = ("53  7    /6  195   / 98    6 /8   6   3/4  8 3  1/7   2   6/ 6    28 /   419  5/    8  79").split("/");
		//for(int i = 0; i < s.length; i++) {
			//boardArr[i] = s[i].toCharArray();
		//}
		
		System.out.println("Please enter the board one line at a time, no spaces, and enter ' ' for any missing values.");
		for(int i = 0; i < 9; i++) {
			System.out.print((i + 1) + ": ");
			boardArr[i] = kb.nextLine().toCharArray();
		}
		
		//Create and print board object to show starting board
		Board board = new Board(boardArr);
		System.out.println(board.toString());
		//Create a solver object and solve
		Solver solver = new Solver(board);
		solver.solve();
		

	}

}
